package com.readersdigest.onepass.brandAdvocate.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts.action.Action;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

import com.readersdigest.onepass.brandAdvocate.util.TriggerEmail;

/**
 * The Class OptOutRegistration.
 */
public class OptOutRegistration extends Action {

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

		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String emailAddress = request.getParameter("emailAddress");
		String password = "";
		String registerMail = "N";
		String promoKey=request.getParameter("promoKey");
		String trkId=request.getParameter("trkid");
		String token=request.getParameter("token");
		String advocateFirstName=request.getParameter("advocateFirstName");
		String advocateLastName=request.getParameter("advocateLastName");
		String adocateEmailAddress=request.getParameter("adocateEmailAddress");
		

		TriggerEmail.sendregisterEmailToRecipent(firstName, lastName,
				emailAddress, password, registerMail,promoKey,trkId,advocateFirstName,advocateLastName,adocateEmailAddress,token);

		return mapping.findForward("success");
	}

}
