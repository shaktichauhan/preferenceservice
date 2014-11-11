package com.readersdigest.exacttarget.client.testclient;

import com.readersdigest.exacttarget.client.ETExtensionServices;
import com.readersdigest.exacttarget.client.impl.ETExtensionServicesImpl;
import com.readersdigest.exacttarget.dto.ETResponse;

public class TestGetDigitalProfile {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
 
		ETExtensionServices eTExtensionServices = new ETExtensionServicesImpl();
		ETResponse etResponse = eTExtensionServices.getDigitalProfile("consumer_marketing", "brett_mollen@rd.com");
		
		System.out.println("\n\n **********  etResponse.getCode() : " + etResponse.getCode());
		System.out.println("\n\n **********  etResponse.getDescription() : " + etResponse.getDescription());
		
		System.out.println("\n\n **********  etResponse.getAddress1(): " + etResponse.getAddress1());
		
		System.out.println("\n\n **********  etResponse.getFirstName() : " + etResponse.getFirstName());
		
		System.out.println("\n\n **********  etResponse.getPhoneNumber() : " + etResponse.getPhoneNumber());
		
		if(etResponse.getDetailedMessages() != null) {
			for(int i=0; i<etResponse.getDetailedMessages().length; i++) {
				System.out.println("\n\n **********  etResponse.getDetailedMessage " + i +": " + etResponse.getDetailedMessages()[i]);
			}
		}
		
		
		
		
	}

}
