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
import com.readersdigest.onepass.dto.OnePassUserLoginDTO;
import com.readersdigest.onepass.form.OnePassRegistrationForm;
import com.readersdigest.onepass.service.OnePassService;
import com.readersdigest.onepass.service.impl.OnePassServiceImpl;

/**
 * The Class OnePassLoginAction.
 *
 * @author shsingh
 */
public class OnePassLoginAction extends Action {

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

        OnePassRegistrationForm onePassLoginform = (OnePassRegistrationForm) form;

        onePassService = new OnePassServiceImpl();
        ActionMessages messages = new ActionMessages();

        OnePassUserLoginDTO userLoginDTO = new OnePassUserLoginDTO();
        userLoginDTO.emailAddress = onePassLoginform.getEmailAddress();
        userLoginDTO.password = onePassLoginform.getPassword();
        // not in use
//        OnePassServiceResponse serviceResponse = onePassService.userLogin(userLoginDTO);
//
//        if ("FAILED".equalsIgnoreCase(serviceResponse.status)) {
//            messages.add(Globals.ERROR_KEY, new ActionMessage("error.globalError", serviceResponse.responseText));
//            saveErrors(request, messages);
//            EntityManagerHelper.log("End OnePassRegistrationAction.execute() method, Error...", Level.INFO, null);
//            return mapping.getInputForward();
//        }

        EntityManagerHelper.log("End OnePassRegistrationAction.execute() method", Level.INFO, null);

        return mapping.findForward("success");
    }

}
