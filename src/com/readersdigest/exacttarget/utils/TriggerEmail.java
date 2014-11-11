package com.readersdigest.exacttarget.utils;

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
	public static boolean sendEmail(String emailAddress, String etEmailKey,String[] etKeyPerameter,String[] etValue  ) {

		TriggeredSendMail triggeredEmail = new TriggeredSendMail();
		triggeredEmail.setEmailAddress(emailAddress);
		triggeredEmail
				.setEmailingId(etEmailKey);
		triggeredEmail.setEtBrand("RdEmail");

		String[] key = {};
		String[] value = {};
        if( etEmailKey.length()!=0){
         key = etKeyPerameter;
         value = etValue;
        }
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
				"consumer_marketing", triggeredEmail);

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

	

}
