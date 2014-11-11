package com.readersdigest.onepass.action;

import java.util.logging.Level;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.readersdigest.onepass.db.EntityManagerHelper;
import com.readersdigest.onepass.service.OnePassService;
import com.readersdigest.onepass.service.impl.OnePassAuthServiceImpl;
import com.readersdigest.onepass.service.impl.ServiceValidator;

/**
 * The Class OnePassEmailValidation.
 *
 * @author shsingh
 */
public class OnePassEmailValidation extends Action {
    
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

        EntityManagerHelper.log("Start OnePassResetPassword.execute() method", Level.INFO, null);
        
       
        String token = request.getParameter("token");
        
        String prodId = request.getParameter("appId");
        
        onePassService = new OnePassAuthServiceImpl();

        boolean flag = onePassService.updateEmailValidity(token);
        
        String success = "success";
        
        if(prodId != null && !"".equals(prodId)) {
            success = success + "_" + prodId;
        }
        
        ActionForward forward = new ActionForward();
        forward.setPath(mapping.findForward(success).getPath() + "?transactionCompleted="+flag);
        forward.setRedirect(mapping.findForward(success).getRedirect());
        return forward;

    }

}
