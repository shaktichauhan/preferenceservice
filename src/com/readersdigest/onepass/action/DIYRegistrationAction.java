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
import com.readersdigest.onepass.dto.OnePassTummyServiceResponse;
import com.readersdigest.onepass.dto.PreferenceDTO;
import com.readersdigest.onepass.form.OnePassRegistrationForm;
import com.readersdigest.onepass.service.OnePassTummyService;
import com.readersdigest.onepass.service.impl.OnePassETTummyServiceImpl;
import com.readersdigest.onepass.service.impl.OnePassTummyServiceImpl;
import com.readersdigest.onepass.util.StringUtils;

/**
 * The Class DIYRegistrationAction.
 *
 * @author shsingh
 */
public class DIYRegistrationAction extends Action {

    /** The one pass service. */
	private OnePassTummyService onePassTummyService = null;

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
    		onePassTummyService = new OnePassETTummyServiceImpl();
		} else {
			onePassTummyService = new OnePassTummyServiceImpl();
		}
        
        ActionMessages messages = new ActionMessages();
        
        String appId = onePassRegistrationform.getAppId();
        String emailAddress = onePassRegistrationform.getEmailAddress();
        
        System.out.println("\n\n\n ********** appId : " + appId);
        
        OnePassTummyServiceResponse  serviceResponse = onePassTummyService.createOnePassBHEUser(emailAddress, appId);
        
        if ("FAILED".equalsIgnoreCase(serviceResponse.status)) {
            messages.add(Globals.ERROR_KEY, new ActionMessage("error.globalError", serviceResponse.responseText));
            saveErrors(request, messages);
            EntityManagerHelper.log("End PromotionalRegistrationAction.execute() method, Error...", Level.INFO, null);
            return mapping.getInputForward();
        }

        EntityManagerHelper.log("End PromotionalRegistrationAction.execute() method", Level.INFO, null);
        
        return mapping.findForward("success");
        /*ActionForward forward = new ActionForward();
        forward.setPath(mapping.findForward("success").getPath() + "?emailAddress="+onePassRegistrationform.getEmailAddress()+"&password="+ 
        		onePassRegistrationform.getPassword() + "&customerName="+onePassRegistrationform.getCustomerName() + "&trkid="+trkid);
        forward.setRedirect(mapping.getInputForward().getRedirect());
        return forward;*/
          
    }

    
}
