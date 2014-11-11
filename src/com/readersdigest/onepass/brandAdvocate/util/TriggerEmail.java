package com.readersdigest.onepass.brandAdvocate.util;

import java.util.ArrayList;
import java.util.List;

import com.readersdigest.exacttarget.client.ETExtensionServices;
import com.readersdigest.exacttarget.client.impl.ETExtensionServicesImpl;
import com.readersdigest.exacttarget.dto.ETResponse;
import com.readersdigest.exacttarget.dto.PersonalizationParameters;
import com.readersdigest.exacttarget.dto.TriggeredSendMail;
import com.readersdigest.onepass.util.StringUtils;


/**
 * The Class TriggerEmail.
 */
public class TriggerEmail {

	/**
	 * Send email to friend.
	 *
	 * @param firstName the first name
	 * @param emailAddress the email address
	 * @param advocateFirstName the advocate first name
	 * @param advocateLastName the advocate last name
	 * @param adocateEmailAddesss the adocate email addesss
	 * @param lastname the lastname
	 * @param token the token
	 * @param promoKey the promo key
	 * @param trkId the trk id
	 * @return true, if successful
	 */
	public static boolean sendEmailToFriend(String firstName,
			String emailAddress, String advocateFirstName,
			String advocateLastName, String adocateEmailAddesss,
			String lastname, String token, String promoKey, String trkId) {

		TriggeredSendMail triggeredEmail = new TriggeredSendMail();
		triggeredEmail.setEmailAddress(emailAddress);
		triggeredEmail
				.setEmailingId(getBundleStringValue("brandAdvocateFriendEmailId"));
		triggeredEmail.setEtBrand(getBundleStringValue("etBrand"));

		String[] key = { "advocate_email", "advocate_first_name",
				"advocate_last_name", "reference_token", "friend_email",
				"friend_first_name", "friend_last_name", "promo_key",
				"tracking_id" };
		String[] value = { adocateEmailAddesss, advocateFirstName,
				advocateLastName, token, emailAddress, firstName, lastname,
				promoKey, trkId };

		List<PersonalizationParameters> personalizationParametersList = new ArrayList<PersonalizationParameters>();

		for (int i = 0; i < key.length; i++) {
			PersonalizationParameters personalizationParameters = new PersonalizationParameters();
			personalizationParameters.setKey(key[i]);
			personalizationParameters.setValue(value[i]);
			personalizationParametersList.add(personalizationParameters);
		}

		triggeredEmail
				.setPersonalizationParameters(personalizationParametersList);

		ETExtensionServices eTExtensionServices = new ETExtensionServicesImpl();
		ETResponse etResponse = eTExtensionServices.sendTriggeredMail(
				getBundleStringValue("etBrandUnitName"), triggeredEmail);

		System.out.println("\n\n **********  etResponse.getCode() : "
				+ etResponse.getCode());
		System.out.println("\n\n **********  etResponse.getDescription() : "
				+ etResponse.getDescription());

		if (etResponse.getDetailedMessages() != null) {
			for (int i = 0; i < etResponse.getDetailedMessages().length; i++) {
				System.out
						.println("\n\n **********  etResponse.getDetailedMessage "
								+ i
								+ ": "
								+ etResponse.getDetailedMessages()[i]);
			}
		}

		return true;

	}

	/**
	 * Send email to advocate.
	 *
	 * @param adocateEmailAddesss the adocate email addesss
	 * @param advocateFirstName the advocate first name
	 * @param advocateLastName the advocate last name
	 * @param friendFirstName the friend first name
	 * @param friendLastname the friend lastname
	 * @param friendEmailAddress the friend email address
	 * @return true, if successful
	 */
	public static boolean sendEmailToAdvocate(String adocateEmailAddesss,
			String advocateFirstName, String advocateLastName,
			String[] friendFirstName, String[] friendLastname,
			String[] friendEmailAddress) {

		TriggeredSendMail triggeredEmail = new TriggeredSendMail();
		triggeredEmail.setEmailAddress(adocateEmailAddesss);
		triggeredEmail
				.setEmailingId(getBundleStringValue("brandAdvocateEmailId"));
		triggeredEmail.setEtBrand(getBundleStringValue("etBrand"));

		String[] key = { "advocate_email", "advocate_first_name",
				"advocate_last_name", "friend1_first_name",
				"friend1_last_name", "friend1_email", "friend2_first_name",
				"friend2_last_name", "friend2_email", "friend3_first_name",
				"friend3_last_name", "friend3_email" };
		String[] value = { adocateEmailAddesss, advocateFirstName,
				advocateLastName, friendFirstName[0], friendLastname[0],
				friendEmailAddress[0], friendFirstName[1], friendLastname[1],
				friendEmailAddress[1], friendFirstName[2], friendLastname[2],
				friendEmailAddress[2] };

		List<PersonalizationParameters> personalizationParametersList = new ArrayList<PersonalizationParameters>();

		for (int i = 0; i < key.length; i++) {
			PersonalizationParameters personalizationParameters = new PersonalizationParameters();
			personalizationParameters.setKey(key[i]);
			personalizationParameters.setValue(value[i]);
			personalizationParametersList.add(personalizationParameters);
		}

		triggeredEmail
				.setPersonalizationParameters(personalizationParametersList);

		ETExtensionServices eTExtensionServices = new ETExtensionServicesImpl();
		ETResponse etResponse = eTExtensionServices.sendTriggeredMail(
				getBundleStringValue("etBrandUnitName"), triggeredEmail);

		System.out.println("\n\n **********  etResponse.getCode() : "
				+ etResponse.getCode());
		System.out.println("\n\n **********  etResponse.getDescription() : "
				+ etResponse.getDescription());

		if (etResponse.getDetailedMessages() != null) {
			for (int i = 0; i < etResponse.getDetailedMessages().length; i++) {
				System.out
						.println("\n\n **********  etResponse.getDetailedMessage "
								+ i
								+ ": "
								+ etResponse.getDetailedMessages()[i]);
			}
		}

		return true;
	}

	/**
	 * Sendregister email to advocate.
	 *
	 * @param advocateEmailAddress the advocate email address
	 * @param advocateFirstName the advocate first name
	 * @param advocateLastName the advocate last name
	 * @param friendFirstName the friend first name
	 * @param friendLastname the friend lastname
	 * @param friendEmailAddress the friend email address
	 * @return true, if successful
	 */
	public static boolean sendregisterEmailToAdvocate(
			String advocateEmailAddress, String advocateFirstName,
			String advocateLastName, String friendFirstName,
			String friendLastname, String friendEmailAddress) {

		TriggeredSendMail triggeredEmail = new TriggeredSendMail();
		triggeredEmail.setEmailAddress(advocateEmailAddress);
		triggeredEmail
				.setEmailingId(getBundleStringValue("brandAdvocateFriendRegisterEmail"));
		triggeredEmail.setEtBrand(getBundleStringValue("etBrand"));

		String[] key = { "advocate_email", "advocate_first_name",
				"advocate_last_name", "friend_email", "friend_first_name",
				"friend_last_name" };
		String[] value = { advocateEmailAddress, advocateFirstName,
				advocateLastName, friendEmailAddress, friendFirstName,
				friendLastname };

		List<PersonalizationParameters> personalizationParametersList = new ArrayList<PersonalizationParameters>();

		for (int i = 0; i < key.length; i++) {
			PersonalizationParameters personalizationParameters = new PersonalizationParameters();
			personalizationParameters.setKey(key[i]);
			personalizationParameters.setValue(value[i]);
			personalizationParametersList.add(personalizationParameters);
		}

		triggeredEmail
				.setPersonalizationParameters(personalizationParametersList);

		ETExtensionServices eTExtensionServices = new ETExtensionServicesImpl();
		ETResponse etResponse = eTExtensionServices.sendTriggeredMail(
				getBundleStringValue("etBrandUnitName"), triggeredEmail);

		System.out.println("\n\n **********  etResponse.getCode() : "
				+ etResponse.getCode());
		System.out.println("\n\n **********  etResponse.getDescription() : "
				+ etResponse.getDescription());

		if (etResponse.getDetailedMessages() != null) {
			for (int i = 0; i < etResponse.getDetailedMessages().length; i++) {
				System.out
						.println("\n\n **********  etResponse.getDetailedMessage "
								+ i
								+ ": "
								+ etResponse.getDetailedMessages()[i]);
			}
		}

		return true;
	}

	/**
	 * Sendregister email to recipent.
	 *
	 * @param friendFirstName the friend first name
	 * @param friendLastName the friend last name
	 * @param friendEmailAddress the friend email address
	 * @param password the password
	 * @param registerMail the register mail
	 * @return true, if successful
	 */
	public static boolean sendregisterEmailToRecipent(String friendFirstName,
			String friendLastName, String friendEmailAddress, String password,
			String registerMail,String promoKey,String trackId,String advocateFirstName,String advocateLastName,String adocateEmailAddress,String token) {
        
		String emailKey = null;
		
		if("ADV_RDO_3".equalsIgnoreCase(promoKey)){
			emailKey="friend_signup";	
		}
		else if ("ADV_RDO_1".equalsIgnoreCase(promoKey)) {
			emailKey="friend_signup_onemonth";
		}
		else{
			emailKey="friend_optout";
			
		}
		TriggeredSendMail triggeredEmail = new TriggeredSendMail();
		triggeredEmail.setEmailAddress(friendEmailAddress);
		triggeredEmail
				.setEmailingId(emailKey);
		triggeredEmail.setEtBrand(getBundleStringValue("etBrand"));

		String[] key = { "friend_email", "friend_first_name",
				"friend_last_name", "friend_password", "register_mail","promo_key",
				"tracking_id", "advocate_email", "advocate_first_name",
				"advocate_last_name", "reference_token"};
		String[] value = { friendEmailAddress, friendFirstName, friendLastName,
				password, registerMail,promoKey,trackId,adocateEmailAddress,advocateFirstName,advocateLastName,token };

		List<PersonalizationParameters> personalizationParametersList = new ArrayList<PersonalizationParameters>();

		for (int i = 0; i < key.length; i++) {
			PersonalizationParameters personalizationParameters = new PersonalizationParameters();
			personalizationParameters.setKey(key[i]);
			personalizationParameters.setValue(value[i]);
			personalizationParametersList.add(personalizationParameters);
		}

		triggeredEmail
				.setPersonalizationParameters(personalizationParametersList);

		ETExtensionServices eTExtensionServices = new ETExtensionServicesImpl();
		ETResponse etResponse = eTExtensionServices.sendTriggeredMail(
				getBundleStringValue("etBrandUnitName"), triggeredEmail);

		System.out.println("\n\n **********  etResponse.getCode() : "
				+ etResponse.getCode());
		System.out.println("\n\n **********  etResponse.getDescription() : "
				+ etResponse.getDescription());

		if (etResponse.getDetailedMessages() != null) {
			for (int i = 0; i < etResponse.getDetailedMessages().length; i++) {
				System.out
						.println("\n\n **********  etResponse.getDetailedMessage "
								+ i
								+ ": "
								+ etResponse.getDetailedMessages()[i]);
			}
		}

		return true;
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
