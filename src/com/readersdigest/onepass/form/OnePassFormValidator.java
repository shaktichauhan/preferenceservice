package com.readersdigest.onepass.form;

import java.io.Serializable;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.validator.Field;
import org.apache.commons.validator.Validator;
import org.apache.commons.validator.ValidatorAction;
import org.apache.struts.action.ActionMessages;
import org.apache.struts.validator.Resources;

import com.readersdigest.onepass.exception.ServiceException;
import com.readersdigest.onepass.util.StringUtils;

/**
 * The Class OnePassFormValidator.
 *
 * @author shsingh
 */
public class OnePassFormValidator implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Validate password.
     * 
     * @param form
     *            the form
     * @param action
     *            the action
     * @param field
     *            the field
     * @param actionMessage
     *            the action message
     * @param request
     *            the request
     * @return true, if successful
     */
    public static boolean validatePassword(final Object form, final ValidatorAction va, final Field field, final ActionMessages actionMessage,
            final Validator validator, final HttpServletRequest request) {

        try {
            OnePassRegistrationForm registerForm = (OnePassRegistrationForm) form;

            String password = registerForm.getPassword();
            String pattern = "((?=.*[0-9])(?=.*[a-zA-Z])(?=[\\S]+$).{6,50})";

            if (!password.matches(pattern)) {
                actionMessage.add(field.getKey(), Resources.getActionMessage(validator, request, va, field));
                return false;
            } else {
                if(password.charAt(0) == '?' || password.charAt(0) == '!') {
                    actionMessage.add(field.getKey(), Resources.getActionMessage(validator, request, va, field));
                    return false;
                }
                return true;
            }

        } catch (Exception e) {
            return false;
        }

    }

}
