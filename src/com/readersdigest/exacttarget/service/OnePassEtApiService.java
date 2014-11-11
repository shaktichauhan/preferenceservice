package com.readersdigest.exacttarget.service;

import com.readersdigest.exacttarget.dto.OnePassEtEntryResponse;
import com.readersdigest.exacttarget.dto.EtEntryDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface OnePassSweepApiService.
 * 
 * @author Shakti Chauhan - shakti_singh@consultant.rd.com
 * 
 */
public interface OnePassEtApiService {


	/**
	 * Creates the  entry with subscription.
	 *
	 * @param firstName the first name
	 * @param lastName the last name
	 * @param address1 the address1
	 * @param address2 the address2
	 * @param city the city
	 * @param zip the zip
	 * @param state the state
	 * @param country the country
	 * @param phone the phone
	 * @param emailAddress the email address
	
	 * @param optIn the opt in
	 * @return the string
	 */
	String createEntryWithSubscription(String firstName,
			String lastName, String address1, String address2, String city,
			String zip, String state, String country, String phone,
			String emailAddress,  String sourceName, String trkid, String etEmailKey, String optIn,String etCostumPerameter,String etCostumValue);
	
	

}
