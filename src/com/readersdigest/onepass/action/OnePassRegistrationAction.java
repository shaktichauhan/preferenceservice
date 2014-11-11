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
 * The Class OnePassRegistrationAction.
 * 
 * @author shsingh
 */
public class OnePassRegistrationAction extends Action {

	/** The one pass service. */
	private OnePassService onePassService;

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

		EntityManagerHelper.log(
				"Start OnePassRegistrationAction.execute() method", Level.INFO,
				null);

		OnePassRegistrationForm onePassRegistrationform = (OnePassRegistrationForm) form;

		onePassService = new OnePassServiceETImpl();

		if (StringUtils.isETApisCall()) {
			onePassService = new OnePassServiceETImpl();
		} else {
			onePassService = new OnePassServiceImpl();
		}

		ActionMessages messages = new ActionMessages();

		OnePassServiceResponse serviceResponse = onePassService
				.createUserProfileInfo(getProfileDTO(onePassRegistrationform));

		if ("FAILED".equalsIgnoreCase(serviceResponse.status)) {
			messages.add(Globals.ERROR_KEY, new ActionMessage(
					"error.globalError", serviceResponse.responseText));
			saveErrors(request, messages);
			EntityManagerHelper.log(
					"End OnePassRegistrationAction.execute() method, Error...",
					Level.INFO, null);
			return mapping.getInputForward();
		}

		EntityManagerHelper.log(
				"End OnePassRegistrationAction.execute() method", Level.INFO,
				null);

		// Email Address verification for RD employees for free fulfillment
		String rdEmailPattern = StringUtils.getBundleProperty(
				"com.readersdigest.onepass.OnePassResources", "rdEmailRegEx");
		String confirmationRequired = "false";
		if (onePassRegistrationform.getEmailAddress().matches(rdEmailPattern)) {
			confirmationRequired = "true";
		}

		ActionForward forward = new ActionForward();
		forward.setPath(mapping.getInputForward().getPath()
				+ "?transactionCompleted=true&confirmationRequired="
				+ confirmationRequired);
		forward.setRedirect(mapping.getInputForward().getRedirect());
		return forward;
		// return mapping.findForward("success");
	}

	/**
	 * Gets the profile dto.
	 * 
	 * @param form
	 *            the form
	 * @return the profile dto
	 */
	private CreateOnePassUserProfileDTO getProfileDTO(
			final OnePassRegistrationForm form) {

		CreateOnePassUserProfileDTO profileDTO = new CreateOnePassUserProfileDTO();

		String addressToggle = StringUtils.getBundleProperty(
				"com.readersdigest.onepass.OnePassResources", "addressToggle");

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
				if(form.getPromotable() != null) {
					for (String preferenceId : form.getPromotable()) {
						if (promotablesList[i].equals(preferenceId)) {
							flag = true;
							break;
						}
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
		profileDTO.emailFields.confirmPassword = form.getConfirmPassword();
		profileDTO.emailFields.confirmEmailAddress = form
				.getConfirmEmailAddress();

		profileDTO.addressFields = new AddressDTO();
		// profileDTO.addressFields.firstName = form.getFirstName();
		// profileDTO.addressFields.lastName = form.getLastName();
		String customerName = form.getCustomerName();
		int index = customerName.indexOf(" ");
		if (index >= 0) {
			String firstName = customerName.substring(0, index);
			String lastName = customerName.substring(index + 1);
			profileDTO.addressFields.firstName = firstName;
			profileDTO.addressFields.lastName = lastName;
		} else {
			profileDTO.addressFields.firstName = customerName;
		}
		if (!"true".equalsIgnoreCase(addressToggle)) {
			profileDTO.addressFields.city = form.getCity();
			profileDTO.addressFields.countryCode = form.getCountry();
			profileDTO.addressFields.primary = true;
			profileDTO.addressFields.stateCode = form.getState();
			profileDTO.addressFields.address1 = form.getStreet1();
			profileDTO.addressFields.address2 = form.getStreet2();
			profileDTO.addressFields.zip = form.getPostalCode();
		}

		return profileDTO;
	}
}
