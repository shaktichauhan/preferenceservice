package com.readersdigest.onepass.brandAdvocate.action;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.Globals;
import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;
import org.apache.struts.action.ActionMessage;
import org.apache.struts.action.ActionMessages;

import com.readersdigest.onepass.brandAdvocate.form.BrandAdvocateForm;
import com.readersdigest.onepass.brandAdvocate.util.TriggerEmail;
import com.readersdigest.onepass.db.MemberAdvocateInfo;
import com.readersdigest.onepass.db.MemberOnePassInfo;
import com.readersdigest.onepass.service.impl.OnePassBrandAdvocateServiceImpl;
import com.readersdigest.onepass.service.impl.ServiceValidator;
import com.readersdigest.onepass.util.StringUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class BrandAdvocateAction.
 * 
 * @author nlohani
 */
public class BrandAdvocateAction extends Action {

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

		BrandAdvocateForm brandAvocateForm = (BrandAdvocateForm) form;
		String[] firstName = brandAvocateForm.getFirstName();
		String[] lastName = brandAvocateForm.getLastName();
		String[] emailAddress = brandAvocateForm.getEmailAddress();
		String advocateFirstName = brandAvocateForm.getAdvocateFirstName();
		String advocateLastName = brandAvocateForm.getAdvocateLastName();
		String adocateEmailAddress = brandAvocateForm.getAdvocateEmailAddress();
		String token = UUID.randomUUID().toString();
		String promoKey = brandAvocateForm.getPromoKey();
		String trkId = brandAvocateForm.getTrkId();
		String productAbbr=brandAvocateForm.getProdAbbr();
		
		List<MemberOnePassInfo> memberOnePassInfoList = null;
		ServiceValidator validation = new ServiceValidator();

		// Check the friends email address validation...
		memberOnePassInfoList = validation.checkEmailValidation(emailAddress, productAbbr);
		
		if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
			for (MemberOnePassInfo email : memberOnePassInfoList) {
				messages.add(Globals.ERROR_KEY, new ActionMessage(
						"error.globalError",getBundleStringValue("emaiExit.Invalid")+" " +email.getEmailAddress() + " "
								+ getBundleStringValue("emaiExit.Invalid.Full")));
			}
			saveErrors(request, messages);
			return mapping.getInputForward();

		}

		try {
			MemberAdvocateInfo entity = new MemberAdvocateInfo();
			OnePassBrandAdvocateServiceImpl memberadv = new OnePassBrandAdvocateServiceImpl();
			entity.setAdvEmailAddress(adocateEmailAddress);
			entity.setAdvFirstName(advocateFirstName);
			entity.setAdvLastName(advocateLastName);
			entity.setTrackingId(trkId);
			entity.setPromoKey(promoKey);
			entity.setCreateDate(new Timestamp(System.currentTimeMillis()));
			entity.setToken(token);
			memberadv.registerAdvocateProfile(entity);
		} catch (Exception e) {
			e.printStackTrace();
			messages.add(Globals.ERROR_KEY, new ActionMessage(
					"error.globalError",
					getBundleStringValue("notInsert.inDataBase")));
			saveErrors(request, messages);
			return mapping.getInputForward();
			// TODO: handle exception

		}
		
		int i = 0;
		while (i < emailAddress.length) {
			if (emailAddress[i] != null && !"".equals(emailAddress[i])) {
				TriggerEmail.sendEmailToFriend(firstName[i], emailAddress[i],
						advocateFirstName, advocateLastName,
						adocateEmailAddress, lastName[i], token, promoKey,
						trkId);

			}

			i++;
		}
		
		TriggerEmail.sendEmailToAdvocate(adocateEmailAddress,
				advocateFirstName, advocateLastName, firstName, lastName,
				emailAddress);
		
		ActionForward forward = new ActionForward();
		forward.setPath(mapping.findForward("success").getPath()
				+ "?token="
				+ token);
		forward.setRedirect(mapping.getInputForward().getRedirect());
		return forward;

	}

	/**
	 * Gets the bundle string value.
	 *
	 * @param key the key
	 * @return the bundle string value
	 */
	private static String getBundleStringValue(String key) {
		return StringUtils.getBundleProperty(
				"com.readersdigest.onepass.brandAdvocate.ApplicationResources",
				key);
	}

}
