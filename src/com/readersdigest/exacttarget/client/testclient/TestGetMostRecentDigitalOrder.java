package com.readersdigest.exacttarget.client.testclient;

import com.readersdigest.exacttarget.client.ETExtensionServices;
import com.readersdigest.exacttarget.client.impl.ETExtensionServicesImpl;
import com.readersdigest.exacttarget.dto.ETResponse;

public class TestGetMostRecentDigitalOrder {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
 
		ETExtensionServices eTExtensionServices = new ETExtensionServicesImpl();
		ETResponse etResponse = eTExtensionServices.getMostRecentDigitalOrder("consumer_marketing", "brett_mollen@rd.com");
		
		System.out.println("\n\n **********  etResponse.getOrderDeviceType() : " + etResponse.getOrderDeviceType());
		System.out.println("\n\n **********  etResponse.getPaymentType() : " + etResponse.getPaymentType());
		System.out.println("\n\n **********  etResponse.getSource() : " + etResponse.getSource());
		System.out.println("\n\n **********  etResponse.getOrderNumber() : " + etResponse.getOrderNumber());
	
	}

}
