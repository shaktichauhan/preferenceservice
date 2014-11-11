package com.readersdigest.onepass.brandAdvocate.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.readersdigest.onepass.brandAdvocate.form.RegistrationForm;
import com.readersdigest.onepass.brandAdvocate.util.TriggerEmail;
import com.readersdigest.onepass.db.MemberAdvocateInfo;
import com.readersdigest.onepass.dto.OnePassServiceResponse;
import com.readersdigest.onepass.exception.ServiceException;
import com.readersdigest.onepass.service.impl.OnePassBrandAdvocateServiceImpl;
import com.readersdigest.onepass.service.impl.ServiceValidator;
import com.readersdigest.onepass.util.StringUtils;

/**
 * The Class RegistrationAction.
 */
public class RegistrationAction extends Action {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.apache.struts.action.Action#execute(org.apache.struts.action.
	 * ActionMapping, org.apache.struts.action.ActionForm,
	 * javax.servlet.http.HttpServletRequest,
	 * javax.servlet.http.HttpServletResponse)
	 */
	@Override
	public final ActionForward execute(final ActionMapping mapping,
			final ActionForm form, final HttpServletRequest request,
			final HttpServletResponse response) throws Exception {
		ActionMessages messages = new ActionMessages();

		RegistrationForm registrationForm = (RegistrationForm) form;

		String firstName = registrationForm.getRecipiantFirstName();
		String lastName = registrationForm.getRecipiantLastName();
		String emailAddress = registrationForm.getRecipiantEmailAddress();
		String password = registrationForm.getRecipiantPassword();
		String registerMail = registrationForm.getRegisterMail();
        String productAbbr=registrationForm.getProdAbbr();
        String trackId=registrationForm.getTrkId();
        String promoKey=registrationForm.getUserType();
		ServiceValidator validation = new ServiceValidator();
		
		// Check the friends email address validation...
		try {
			validation.uniqueAdvocateEmailValidation(emailAddress, productAbbr);
		} catch (ServiceException e) {
	     	// TODO: handle exception
			messages.add(Globals.ERROR_KEY, new ActionMessage(
					"error.globalError",
					getBundleStringValue("emailExist")));
			saveErrors(request, messages);
			return mapping.getInputForward();

		}
		try {

			validation.validPassword(password);
		} catch (ServiceException e) {
			messages.add(Globals.ERROR_KEY, new ActionMessage(
					"error.globalError",
					getBundleStringValue("invalid.Password")));
			saveErrors(request, messages);
			return mapping.getInputForward();
		}

		OnePassBrandAdvocateServiceImpl onePassBrandAdvocateServiceImpl = new OnePassBrandAdvocateServiceImpl();

		if (registrationForm.getToken() != null
				&& !"".equals(registrationForm.getToken().trim())) {
			MemberAdvocateInfo memberAdvocateInfo = onePassBrandAdvocateServiceImpl
					.getAdvocateMember(registrationForm.getToken());
			if (memberAdvocateInfo != null) {
				String advocateFirstName = memberAdvocateInfo.getAdvFirstName();
				String advocateLastName = memberAdvocateInfo.getAdvLastName();
				String adocateEmailAddress = memberAdvocateInfo
						.getAdvEmailAddress();
				registrationForm.setTrkId(memberAdvocateInfo.getTrackingId());
				OnePassServiceResponse serviceResponse = onePassBrandAdvocateServiceImpl
						.createProfile(registrationForm);

				if ("FAILED".equalsIgnoreCase(serviceResponse.status)) {
					messages.add(Globals.ERROR_KEY, new ActionMessage(
							"error.globalError", serviceResponse.responseText));
					saveErrors(request, messages);
					return mapping.getInputForward();
				}
				
				TriggerEmail.sendregisterEmailToRecipent(firstName, lastName,
						emailAddress, password, registerMail,promoKey,trackId,advocateFirstName,advocateLastName,adocateEmailAddress,registrationForm.getToken());
				
				if("ADV_RDO_3".equalsIgnoreCase(promoKey)) {
				   TriggerEmail.sendregisterEmailToAdvocate(adocateEmailAddress,
				   advocateFirstName, advocateLastName, firstName,
				   lastName, emailAddress);
				}
				
			} else {
				messages.add(Globals.ERROR_KEY, new ActionMessage(
						"error.globalError",
						getBundleStringValue("token.Invalid")));
				saveErrors(request, messages);
				return mapping.getInputForward();
			}
		} else {
			messages.add(Globals.ERROR_KEY, new ActionMessage(
					"error.globalError", getBundleStringValue("token.Invalid")));
			saveErrors(request, messages);
			return mapping.getInputForward();
		}

		return mapping.findForward("success_"+promoKey);
	}

	/**
	 * Gets the bundle string value.
	 * 
	 * @param key
	 *            the key
	 * @return the bundle string value
	 */
	private static String getBundleStringValue(String key) {
		return StringUtils.getBundleProperty(
				"com.readersdigest.onepass.brandAdvocate.ApplicationResources",
				key);
	}

}
