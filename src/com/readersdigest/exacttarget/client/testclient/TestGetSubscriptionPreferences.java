package com.readersdigest.exacttarget.client.testclient;

import com.readersdigest.exacttarget.client.ETExtensionServices;
import com.readersdigest.exacttarget.client.impl.ETExtensionServicesImpl;
import com.readersdigest.exacttarget.dto.ETResponse;
import com.readersdigest.exacttarget.dto.GetSubscriptionPreferencesRequest;
import com.readersdigest.exacttarget.dto.Preferences;

public class TestGetSubscriptionPreferences {

	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
       
		// CreateSubscriptionPreferences POJO
		GetSubscriptionPreferencesRequest subscriptionPreferences = new GetSubscriptionPreferencesRequest();
		subscriptionPreferences.setEmailAddress("brett_mollen@rd.com");
        // you need to use loop for multiple preferences to add in list
		/*List<Preferences> preferencesList = new ArrayList<Preferences>();
		Preferences pre = new Preferences();
		pre.setLastActivityDate("601406505000"); //please use timemiles in long and pass as a String
		pre.setLastPromotionKey("key1");
		pre.setLastTrackingId("ide2");
		pre.setOptedIn(true);
		pre.setSubscriptionId("100");
		pre.setLastSource("TOH from Website");
		preferencesList.add(pre);
		Preferences pre1 = new Preferences();
		pre1.setLastActivityDate("601406505000");//please use timemiles in long and pass as a String
		pre1.setLastPromotionKey("key1");
		pre1.setLastTrackingId("ide2");
		pre1.setOptedIn(true);
		pre1.setSubscriptionId("200");
		pre1.setLastSource("TOH from Website");
		preferencesList.add(pre1);
		subscriptionPreferences.setSubscriptionPreferences(preferencesList);*/

		ETExtensionServices eTExtensionServices = new ETExtensionServicesImpl();
		ETResponse etResponse = eTExtensionServices.getSubscriptionPreferences("consumer_marketing", subscriptionPreferences);
		
		System.out.println("\n\n **********  etResponse.getCode() : " + etResponse.getCode());
		System.out.println("\n\n **********  etResponse.getDescription() : " + etResponse.getDescription());
		
		System.out.println("\n\n **********  etResponse.getDescription() : " + etResponse.getTransactionDate());
		if(etResponse.getDetailedMessages() != null) {
			for(int i=0; i<etResponse.getDetailedMessages().length; i++) {
				System.out.println("\n\n **********  etResponse.getDetailedMessage " + i +": " + etResponse.getDetailedMessages()[i]);
			}
		}
		
		if(etResponse.getSubscriptionPreferences() != null && etResponse.getSubscriptionPreferences().size()>0) {
			for(int i=0; i<etResponse.getSubscriptionPreferences().size(); i++) {
				Preferences pre = etResponse.getSubscriptionPreferences().get(i);
				System.out.println("\n\n **********  pre.getLastPromotionKey() " + i +": " +pre.getLastPromotionKey());
				System.out.println("\n\n **********  pre.getLastActivityDate() " + i +": " +pre.getLastActivityDate());
				System.out.println("\n\n **********  pre.getSubscriptionId() " + i +": " +pre.getSubscriptionId());
				System.out.println("\n\n **********  pre.getLastSource() " + i +": " +pre.getLastSource());
			}
		}
		
		
	}

}
