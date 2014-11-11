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
import com.readersdigest.onepass.service.impl.ServiceValidator;
import com.readersdigest.onepass.util.StringUtils;

/**
 * The Class OnePassResetPassword.
 *
 * @author shsingh
 */
public class OnePassResetPassword extends Action {

    /*
     * (non-Javadoc)
     *
     * @see org.apache.struts.action.Action#execute(org.apache.struts.action. ActionMapping, org.apache.struts.action.ActionForm,
     * javax.servlet.http.HttpServletRequest, javax.servlet.http.HttpServletResponse)
     */
    @Override
    public final ActionForward execute(final ActionMapping mapping, final ActionForm form, final HttpServletRequest request, final HttpServletResponse response)
            throws Exception {

        EntityManagerHelper.log("Start OnePassResetPassword.execute() method", Level.INFO, null);
        
        ServiceValidator serviceValidatior = new ServiceValidator();
        String token = request.getParameter("token");
        
        String sourceId = request.getParameter("sourceId");
        
        String prodId = "";
        
        if(sourceId == null || "".equals(sourceId)) {
            prodId = "RDO";
        } else {
            prodId = StringUtils.getProdIdBySource(sourceId);
        }
        
        if("true".equalsIgnoreCase(request.getParameter("transactionCompleted"))) {
            return mapping.findForward("success_"+prodId);
        }
        
        ActionMessages messages = new ActionMessages();
        
        try {
            serviceValidatior.validForgetPasswordToken(token);
        } catch (Exception e) {
                messages.add(Globals.ERROR_KEY, new ActionMessage("error.globalError", e.getMessage()));
                saveErrors(request, messages);
                EntityManagerHelper.log("End OnePassResetPassword.execute() method, Error...", Level.INFO, null);
        }
      
        EntityManagerHelper.log("End OnePassResetPassword.execute() method", Level.INFO, null);

        return mapping.findForward("success_"+prodId);
    }

}
