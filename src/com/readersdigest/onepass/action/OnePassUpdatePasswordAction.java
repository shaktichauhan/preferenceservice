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
import com.readersdigest.onepass.dto.OnePassServiceResponse;
import com.readersdigest.onepass.form.OnePassRegistrationForm;
import com.readersdigest.onepass.service.OnePassService;
import com.readersdigest.onepass.service.impl.OnePassAuthServiceImpl;

/**
 * The Class OnePassUpdatePasswordAction.
 *
 * @author shsingh
 */
public class OnePassUpdatePasswordAction extends Action {
    
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

        EntityManagerHelper.log("Start OnePassUpdatePasswordAction.execute() method", Level.INFO, null);
        
        OnePassRegistrationForm onePassform = (OnePassRegistrationForm) form;
        String password = onePassform.getPassword();
        String token = onePassform.getToken();
        String sourceId= onePassform.getSourceId();
        onePassService = new OnePassAuthServiceImpl();
        ActionMessages messages = new ActionMessages();
        
        OnePassServiceResponse serviceResponse = onePassService.updateNewPassword(token, password, sourceId);
        
        if ("FAILED".equalsIgnoreCase(serviceResponse.status)) {
            messages.add(Globals.ERROR_KEY, new ActionMessage("error.globalError", serviceResponse.responseText));
            saveErrors(request, messages);
            EntityManagerHelper.log("End OnePassRegistrationAction.execute() method, Error...", Level.INFO, null);
            return mapping.getInputForward();
        }
      
        EntityManagerHelper.log("End OnePassUpdatePasswordAction.execute() method", Level.INFO, null);
        
         
         ActionForward forward = new ActionForward();
         // update forward path with the application id
         forward.setPath(mapping.getInputForward().getPath() + "?transactionCompleted=true&sourceId="+sourceId);
         forward.setRedirect(mapping.getInputForward().getRedirect());
         return forward;

       // return mapping.findForward("success");
    }

}
