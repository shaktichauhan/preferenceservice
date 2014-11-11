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

import com.readersdigest.emailClient.EmailClient;
import com.readersdigest.emailClient.StrongMailClient;
import com.readersdigest.onepass.db.EntityManagerHelper;
import com.readersdigest.onepass.dto.OnePassServiceResponse;
import com.readersdigest.onepass.form.OnePassRegistrationForm;
import com.readersdigest.onepass.service.OnePassService;
import com.readersdigest.onepass.service.impl.OnePassAuthServiceImpl;
import com.readersdigest.onepass.util.StringUtils;

/**
 * The Class OnePassLoginAction.
 * 
 * @author shsingh
 */
public class OnePassForgetPasswordAction extends Action {

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

        EntityManagerHelper.log("Start OnePassForgetPasswordAction.execute() method", Level.INFO, null);

        OnePassRegistrationForm onePassform = (OnePassRegistrationForm) form;

        onePassService = new OnePassAuthServiceImpl();

        ActionMessages messages = new ActionMessages();
        String sourceId = onePassform.getSourceId();   
        
        OnePassServiceResponse serviceResponse = onePassService.resetForgetPasswordToken(onePassform.getEmailAddress(),sourceId);

        if ("FAILED".equalsIgnoreCase(serviceResponse.status)) {
            messages.add(Globals.ERROR_KEY, new ActionMessage("error.globalError", serviceResponse.responseText));
            saveErrors(request, messages);
            EntityManagerHelper.log("End OnePassForgetPasswordAction.execute() method, Error...", Level.INFO, null);
            return mapping.getInputForward();
        }
        
        
        String prodId = StringUtils.getProdIdBySource(sourceId);
        
        String URL = request.getRequestURL().toString();
        int index = URL.indexOf(request.getContextPath() + "/");
        URL = URL.substring(0, index);
        URL = URL + request.getContextPath() + "/" + getBundleStringValue("forgetPasswordActionURL") + serviceResponse.token +"&sourceId="+sourceId;
        String emailContent = getBundleStringValue("forgetPasswordMailingTemplateContent_"+prodId);
        emailContent = emailContent.replaceAll("##url##", URL);
        
        try {
            EmailClient emailClient = new StrongMailClient();
            String strtxRecord = emailContent + "::" + onePassform.getEmailAddress();
            emailClient.send(strtxRecord, getBundleStringValue("forgetPasswordMailingTemplate"));
        } catch (Exception e) {
            e.printStackTrace();
        }

        EntityManagerHelper.log("End OnePassForgetPasswordAction.execute() method", Level.INFO, null);
        
        ActionForward forward = new ActionForward();
        // update forward path with the application id
        forward.setPath(mapping.getInputForward().getPath() + "?transactionCompleted=true&sourceId="+sourceId);
        forward.setRedirect(mapping.getInputForward().getRedirect());
        return forward;

        //return mapping.findForward("success");
    }

    /**
     * Gets the bundle string value.
     *
     * @param key the key
     * @return the bundle string value
     */
    private String getBundleStringValue(String key) {
        return StringUtils.getBundleProperty("com.readersdigest.onepass.OnePassResources", key);
    }

}
