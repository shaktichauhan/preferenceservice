package com.readersdigest.exacttarget.client.testclient;

import java.util.ArrayList;
import java.util.List;

import com.readersdigest.exacttarget.client.ETExtensionServices;
import com.readersdigest.exacttarget.client.impl.ETExtensionServicesImpl;
import com.readersdigest.exacttarget.dto.DigitalProfile;
import com.readersdigest.exacttarget.dto.DigitalProfileWithSubscription;
import com.readersdigest.exacttarget.dto.ETResponse;
import com.readersdigest.exacttarget.dto.Preferences;
import com.readersdigest.exacttarget.dto.SubscriptionPreferences;

public class TestDigitalProfileWithSubscriptionPreferences {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
        // Create Digital Profile POJO
		DigitalProfile profile = new DigitalProfile();
		profile.setAddress1("5400 S 60th St.");
		profile.setAddress2("");
		profile.setBirthDate("601406505000");//please use time miles in long and pass as a String
		profile.setCity("whitePlains");
		profile.setCountryCode("US");
		profile.setFirstName("name");
		profile.setFoodInterest("none");
		profile.setGender("M");
		profile.setLastName("dsds");
		profile.setLastUpdateDate("601406505000");//please use time miles in long and pass as a String
		profile.setMiddleName("");
		profile.setPhoneNumber("3232323232");
		profile.setPhoneNumberType("mobile");
		profile.setPostalCode("10601");
		profile.setStateProvinceCode("NY");
		profile.setTitle("Mr");
		profile.setEmailAddress("brett_mollen@rd.com");
		profile.setSource("TOH from Website");
		profile.setTrackingId("34543");
		
		// CreateSubscriptionPreferences POJO
		SubscriptionPreferences subscriptionPreferences = new SubscriptionPreferences();
		subscriptionPreferences.setEmailAddress("brett_mollen@rd.com");
        // you need to use loop for multiple preferences to add in list
		List<Preferences> preferencesList = new ArrayList<Preferences>();
		Preferences pre = new Preferences();
		pre.setLastActivityDate("601406505000");//please use time miles in long and pass as a String
		pre.setLastPromotionKey("key1");
		pre.setLastTrackingId("ide2");
		pre.setOptedIn(true);
		pre.setSubscriptionId("100");
		pre.setLastSource("TOH from Website");
		preferencesList.add(pre);
		Preferences pre1 = new Preferences();
		pre1.setLastActivityDate("601406505000");//please use time miles in long and pass as a String
		pre1.setLastPromotionKey("key1");
		pre1.setLastTrackingId("ide2");
		pre1.setOptedIn(true);
		pre1.setSubscriptionId("200");
		pre1.setLastSource("TOH from Website");
		preferencesList.add(pre1);
		subscriptionPreferences.setSubscriptionPreferences(preferencesList);

		// Final DigitalProfileWithSubscription POJO will pass in service method with parameters
		DigitalProfileWithSubscription digitalProfileWithSubscription = new DigitalProfileWithSubscription();
		digitalProfileWithSubscription.setDigitalProfile(profile);
		digitalProfileWithSubscription.setSubscriptionPreferences(subscriptionPreferences);
		
		ETExtensionServices eTExtensionServices = new ETExtensionServicesImpl();
		ETResponse etResponse = eTExtensionServices.addUpdateDigitalProfileWithSubscriptions("consumer_marketing", digitalProfileWithSubscription);
		
		System.out.println("\n\n **********  etResponse.getCode() : " + etResponse.getCode());
		System.out.println("\n\n **********  etResponse.getDescription() : " + etResponse.getDescription());
		if(etResponse.getDetailedMessages() != null) {
			for(int i=0; i<etResponse.getDetailedMessages().length; i++) {
				System.out.println("\n\n **********  etResponse.getDetailedMessage " + i +": " + etResponse.getDetailedMessages()[i]);
			}
		}
		
		
	}

}
