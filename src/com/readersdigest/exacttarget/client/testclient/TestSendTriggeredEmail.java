package com.readersdigest.exacttarget.client.testclient;

import java.util.ArrayList;
import java.util.List;

import com.readersdigest.exacttarget.client.ETExtensionServices;
import com.readersdigest.exacttarget.client.impl.ETExtensionServicesImpl;
import com.readersdigest.exacttarget.dto.ETResponse;
import com.readersdigest.exacttarget.dto.PersonalizationParameters;
import com.readersdigest.exacttarget.dto.TriggeredSendMail;

// TODO: Auto-generated Javadoc
/**
 * The Class TestSendTriggeredEmail.
 */
public class TestSendTriggeredEmail {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
        // Create Digital Profile POJO
		
		TriggeredSendMail triggeredEmail = new TriggeredSendMail();
		triggeredEmail.setEmailAddress("shakti_singh@consultant.rd.com");
		triggeredEmail.setEmailingId("Site_Registration");
		triggeredEmail.setEtBrand("EntEmail");
		
		//String[] key = {"first_name","last_name","street_address","apt_number" , "city", "state" , "zip_code", "order_number",  "order_date"};
		//String[] value ={"Shakti","chauhan","50 S Stone","1N", "Elmsford", "NY", "10523", "10054", "04-15-2004"};
	
		String[] key = {"FirstName","Password", };
		String[] value ={"Shakti","Chauhan"};
		
		List<PersonalizationParameters> personalizationParametersList = new ArrayList<PersonalizationParameters>();
		
		for(int i=0; i<key.length ; i++) {
			PersonalizationParameters personalizationParameters = new PersonalizationParameters();
			personalizationParameters.setKey(key[i]);
			personalizationParameters.setValue(value[i]);
			personalizationParametersList.add(personalizationParameters);
		}
		
		triggeredEmail.setPersonalizationParameters(personalizationParametersList);
		
		ETExtensionServices eTExtensionServices = new ETExtensionServicesImpl();
		ETResponse etResponse = eTExtensionServices.sendTriggeredMail("consumer_marketing", triggeredEmail);
		
		System.out.println("\n\n **********  etResponse.getCode() : " + etResponse.getCode());
		System.out.println("\n\n **********  etResponse.getDescription() : " + etResponse.getDescription());
		
		if(etResponse.getDetailedMessages() != null) {
			for(int i=0; i<etResponse.getDetailedMessages().length; i++) {
				System.out.println("\n\n **********  etResponse.getDetailedMessage " + i +": " + etResponse.getDetailedMessages()[i]);
			}
		}
		
	}

}
