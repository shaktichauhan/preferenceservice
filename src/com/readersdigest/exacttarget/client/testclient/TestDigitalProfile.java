package com.readersdigest.exacttarget.client.testclient;

import com.readersdigest.exacttarget.client.ETExtensionServices;
import com.readersdigest.exacttarget.client.impl.ETExtensionServicesImpl;
import com.readersdigest.exacttarget.dto.DigitalProfile;
import com.readersdigest.exacttarget.dto.ETResponse;

public class TestDigitalProfile {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
        // Create Digital Profile POJO
		DigitalProfile profile = new DigitalProfile();
		profile.setAddress1("5400 S 60th St.");
		profile.setAddress2("");
		profile.setBirthDate("601406505000");//please use timemiles in long and pass as a String
		profile.setCity("whitePlains");
		profile.setCountryCode("US");
		profile.setFirstName("name");
		profile.setFoodInterest("none");
		profile.setGender("M");
		profile.setLastName("dsds");
		profile.setLastUpdateDate("601406505000");//please use timemiles in long and pass as a String
		profile.setMiddleName("");
		profile.setPhoneNumber("3232323232");
		profile.setPhoneNumberType("mobile");
		profile.setPostalCode("10601");
		profile.setStateProvinceCode("NY");
		profile.setTitle("Mr");
		profile.setEmailAddress("brett_mollen@rd.com");
		profile.setSource("TOH from Website");
		profile.setTrackingId("34543");
		
		
		ETExtensionServices eTExtensionServices = new ETExtensionServicesImpl();
		ETResponse etResponse = eTExtensionServices.addUpdateDigitalProfile("consumer_marketing", profile);
		
		System.out.println("\n\n **********  etResponse.getCode() : " + etResponse.getCode());
		System.out.println("\n\n **********  etResponse.getDescription() : " + etResponse.getDescription());
		if(etResponse.getDetailedMessages() != null) {
			for(int i=0; i<etResponse.getDetailedMessages().length; i++) {
				System.out.println("\n\n **********  etResponse.getDetailedMessage " + i +": " + etResponse.getDetailedMessages()[i]);
			}
		}
		
		
	}

}
