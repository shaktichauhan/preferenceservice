package com.readersdigest.onepass.action;

import java.util.HashSet;
import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.readersdigest.emailClient.EmailClient;
import com.readersdigest.emailClient.StrongMailClient;
import com.readersdigest.onepass.db.EntityManagerHelper;
import com.readersdigest.onepass.dto.AccountDTO;
import com.readersdigest.onepass.dto.AddressDTO;
import com.readersdigest.onepass.dto.CreateOnePassUserProfileDTO;
import com.readersdigest.onepass.dto.EmailDTO;
import com.readersdigest.onepass.dto.OnePassServiceResponse;
import com.readersdigest.onepass.dto.PreferenceDTO;
import com.readersdigest.onepass.form.OnePassRegistrationForm;
import com.readersdigest.onepass.service.OnePassService;
import com.readersdigest.onepass.service.impl.OnePassServiceETImpl;
import com.readersdigest.onepass.service.impl.OnePassServiceImpl;
import com.readersdigest.onepass.util.StringUtils;

/**
 * The Class PromotionalRegistrationAction.
 *
 * @author shsingh
 */
public class PromotionalRegistrationAction extends Action {

    /** The one pass service. */
    private OnePassService onePassService;

    /*
     * (non-Javadoc)
     *
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action. ActionMapping, org.apache.struts.action.ActionForm,
     * javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public final ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
            throws Exception {

        EntityManagerHelper.log("Start PromotionalRegistrationAction.execute() method", Level.INFO, null);

        OnePassRegistrationForm onePassRegistrationform = (OnePassRegistrationForm) form;

        if (StringUtils.isETApisCall()) {
			onePassService = new OnePassServiceETImpl();
		} else {
			onePassService = new OnePassServiceImpl();
		}
        
        ActionMessages messages = new ActionMessages();
        String trkid = request.getParameter("trkid");
        
        System.out.println("\n\n\n ********** trkid : " + trkid);
        
        OnePassServiceResponse serviceResponse = onePassService.createUserProfileInfo(getProfileDTO(onePassRegistrationform));

        if ("FAILED".equalsIgnoreCase(serviceResponse.status)) {
            messages.add(Globals.ERROR_KEY, new ActionMessage("error.globalError", serviceResponse.responseText));
            saveErrors(request, messages);
            EntityManagerHelper.log("End PromotionalRegistrationAction.execute() method, Error...", Level.INFO, null);
            return mapping.getInputForward();
        }

        EntityManagerHelper.log("End PromotionalRegistrationAction.execute() method", Level.INFO, null);
        
        String promotionalMailingTemplate = StringUtils.getBundleProperty("com.readersdigest.onepass.OnePassResources", "promotionalMailingTemplate");
        
        try {
            EmailClient emailClient = new StrongMailClient();
            String strtxRecord = onePassRegistrationform.getEmailAddress() + "::" + onePassRegistrationform.getEmailAddress() + "::" + onePassRegistrationform.getPassword();
            System.out.println("\n\n\n ********** strtxRecord : " + strtxRecord);
            emailClient.send(strtxRecord, promotionalMailingTemplate);
         } catch (Exception e) {
            e.printStackTrace();
        }
            
        ActionForward forward = new ActionForward();
        forward.setPath(mapping.findForward("success").getPath() + "?emailAddress="+onePassRegistrationform.getEmailAddress()+"&password="+ 
        		onePassRegistrationform.getPassword() + "&customerName="+onePassRegistrationform.getCustomerName() + "&trkid="+trkid);
        forward.setRedirect(mapping.getInputForward().getRedirect());
        return forward;
          
    }

    /**
     * Gets the profile dto.
     *
     * @param form
     *            the form
     * @return the profile dto
     */
    private CreateOnePassUserProfileDTO getProfileDTO(final OnePassRegistrationForm form) {

        CreateOnePassUserProfileDTO profileDTO = new CreateOnePassUserProfileDTO();
        
        profileDTO.accountFields = new AccountDTO();
        profileDTO.accountFields.sourceId = form.getSourceId();
        profileDTO.accountFields.trackingId = form.getTrackingId();
        profileDTO.accountFields.preferenceFields = new HashSet<PreferenceDTO>();

        String strPromotanble = form.getPromotable_unchecked();
		
		if (form.getPromotable() != null) {
			for (String preferenceId : form.getPromotable()) {
				PreferenceDTO preferenceDTO = new PreferenceDTO();
				preferenceDTO.preferenceId = preferenceId;
				preferenceDTO.optIn = true;
				profileDTO.accountFields.preferenceFields.add(preferenceDTO);
			}
		}

		if(strPromotanble != null) {
			String[] promotablesList = strPromotanble.split(":");
			for (int i = 0; i < promotablesList.length; i++) {
				boolean flag = false;
				for (String preferenceId : form.getPromotable()) {
					if (promotablesList[i].equals(preferenceId)) {
						flag = true;
						break;
					}
				}

				if (!flag) {
					PreferenceDTO preferenceDTO = new PreferenceDTO();
					preferenceDTO.preferenceId = promotablesList[i];
					preferenceDTO.optIn = false;
					profileDTO.accountFields.preferenceFields.add(preferenceDTO);
				}
			}
		}

        profileDTO.emailFields = new EmailDTO();
        profileDTO.emailFields.emailAddress = form.getEmailAddress();
        profileDTO.emailFields.accountNumber = form.getAccountNumber();
        profileDTO.emailFields.primary = true;
        profileDTO.emailFields.password = form.getPassword();
        profileDTO.emailFields.confirmPassword = form.getPassword(); // not required for promotion so use existing one
        profileDTO.emailFields.confirmEmailAddress = form.getEmailAddress(); // not required for promotion so use existing one
        

        profileDTO.addressFields = new AddressDTO();
       // profileDTO.addressFields.firstName = form.getFirstName();
       // profileDTO.addressFields.lastName = form.getLastName();
        String customerName = form.getCustomerName();
        int index = customerName.indexOf(" ");
        if(index >=0) {
            String firstName = customerName.substring(0, index);
            String lastName = customerName.substring(index+1);
            profileDTO.addressFields.firstName = firstName;
            profileDTO.addressFields.lastName = lastName;
        } else {
            profileDTO.addressFields.firstName = customerName;
        }
        
              

        return profileDTO;
    }
}
