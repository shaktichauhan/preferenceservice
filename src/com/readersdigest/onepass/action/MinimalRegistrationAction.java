package com.readersdigest.onepass.action;

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

import com.readersdigest.onepass.db.EntityManagerHelper;
import com.readersdigest.onepass.dto.AccountDTO;
import com.readersdigest.onepass.dto.CreateOnePassUserProfileDTO;
import com.readersdigest.onepass.dto.EmailDTO;
import com.readersdigest.onepass.dto.OnePassServiceResponse;
import com.readersdigest.onepass.form.OnePassRegistrationForm;
import com.readersdigest.onepass.service.OnePassService;
import com.readersdigest.onepass.service.impl.OnePassServiceETImpl;
import com.readersdigest.onepass.service.impl.OnePassServiceImpl;
import com.readersdigest.onepass.util.StringUtils;

/**
 * The Class OnePassLoginAction.
 *
 * @author shsingh
 */
public class MinimalRegistrationAction extends Action {

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

        EntityManagerHelper.log("Start OnePassRegistrationAction.execute() method", Level.INFO, null);

        OnePassRegistrationForm minimalRegistrationForm = (OnePassRegistrationForm) form;
        
        CreateOnePassUserProfileDTO profileDTO = new CreateOnePassUserProfileDTO();
        
        profileDTO.accountFields = new AccountDTO();
        profileDTO.accountFields.sourceId = minimalRegistrationForm.getSourceId();
        profileDTO.emailFields = new EmailDTO();
        profileDTO.emailFields.emailAddress = minimalRegistrationForm.getEmailAddress();
        profileDTO.emailFields.password = minimalRegistrationForm.getPassword();
        profileDTO.emailFields.confirmPassword = minimalRegistrationForm.getConfirmPassword();
        profileDTO.emailFields.confirmEmailAddress = minimalRegistrationForm.getConfirmEmailAddress();
        
        if(StringUtils.isETApisCall()) {
        	 onePassService = new OnePassServiceETImpl();
        } else {
        	 onePassService = new OnePassServiceImpl();
        }
        
        ActionMessages messages = new ActionMessages();
        
        OnePassServiceResponse serviceResponse = onePassService.minimalRegistration(profileDTO);
        
        if ("FAILED".equalsIgnoreCase(serviceResponse.status)) {
            messages.add(Globals.ERROR_KEY, new ActionMessage("error.globalError", serviceResponse.responseText));
            saveErrors(request, messages);
            EntityManagerHelper.log("End OnePassRegistrationAction.execute() method, Error...", Level.INFO, null);
            return mapping.getInputForward();
        }

        // Email Address verification for RD employees for free fulfillment
        String rdEmailPattern = StringUtils.getBundleProperty("com.readersdigest.onepass.OnePassResources", "rdEmailRegEx");
        String confirmationRequired = "false";
        if(minimalRegistrationForm.getEmailAddress().matches(rdEmailPattern)) {
              confirmationRequired = "true";
        }
        
        EntityManagerHelper.log("End OnePassRegistrationAction.execute() method", Level.INFO, null);
        
        ActionForward forward = new ActionForward();
        forward.setPath(mapping.findForward("success").getPath() + "?confirmationRequired="+confirmationRequired);
        forward.setRedirect(mapping.findForward("success").getRedirect());
        return forward;
          
    }

}
