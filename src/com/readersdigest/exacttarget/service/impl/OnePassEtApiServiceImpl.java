package com.readersdigest.exacttarget.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;


import com.readersdigest.exacttarget.client.ETExtensionServices;
import com.readersdigest.exacttarget.client.impl.ETExtensionServicesImpl;
import com.readersdigest.exacttarget.dto.DigitalProfile;
import com.readersdigest.exacttarget.dto.DigitalProfileWithSubscription;
import com.readersdigest.exacttarget.dto.ETResponse;
import com.readersdigest.exacttarget.dto.Preferences;
import com.readersdigest.exacttarget.dto.SubscriptionPreferences;

import com.readersdigest.exacttarget.dto.OnePassEtEntryResponse;
import com.readersdigest.exacttarget.dto.EtEntryDTO;
import com.readersdigest.exacttarget.service.OnePassEtApiService;

import com.readersdigest.exacttarget.utils.StringUtils;
import com.readersdigest.exacttarget.utils.TriggerEmail;
import com.sun.jersey.core.util.StringIgnoreCaseKeyComparator;

// TODO: Auto-generated Javadoc
/**
 * The Class OnePassSweepApiServiceImpl.
 * 
 * @author Shakti Chauhan - shakti_singh@consultant.rd.com
 * 
 */
public class OnePassEtApiServiceImpl implements OnePassEtApiService {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.readersdigest.sweepapi.service.OnePassSweepApiService#createSweepEntry
	 * (com.readersdigest.sweepapi.dto.SweepEntryDTO)
	 */
	
	

	public String createEntryWithSubscription(String firstName,
			String lastName, String address1, String address2, String city,
			String zip, String state, String country, String phone,
			String emailAddress,  String sourceName, String trkid, String etEmailKey, String optIn,String etCostumPerameter,String etCostumValue) {

		
		OnePassEtEntryResponse response = new OnePassEtEntryResponse();
		EtEntryDTO etEntryDTO = new EtEntryDTO();
		etEntryDTO.setAddress1(address1);
		etEntryDTO.setAddress2(address2);
		etEntryDTO.setCity(city);
		etEntryDTO.setCountry(country);
		etEntryDTO.setEmailAddress(emailAddress);
		etEntryDTO.setFirstName(firstName);
		etEntryDTO.setLastName(lastName);
		etEntryDTO.setPhone(phone);
	
		etEntryDTO.setSourceName(sourceName);
		etEntryDTO.setTrackingId(trkid);
		etEntryDTO.setState(state);
		etEntryDTO.setZip(zip);

		if (optIn != null && !"".equals(optIn.trim())) {
			String[] optIns = optIn.split(";");
			List<Preferences> subscriptionPreferences = new ArrayList<Preferences>();
			for (String preferenceId : optIns) {
				Preferences preference = new Preferences();
				preference.setSubscriptionId(preferenceId);
				preference.setLastSource(sourceName);
				preference.setLastTrackingId(trkid);
				preference.setOptedIn(true);
				subscriptionPreferences.add(preference);
			}

			etEntryDTO.setSubscriptionPreferences(subscriptionPreferences);
		}
		boolean flagET=true;
		
		flagET = updateInET(etEntryDTO);
		String[] etPerameter={};
		String[] etValue={};
		
	  if(etEmailKey != null && !"".equals(etEmailKey.trim()))
	  {
	  if (etCostumPerameter != null && !"".equals(etCostumPerameter.trim()))
	  {
		etPerameter = etCostumPerameter.split(";");
		etValue = etCostumValue.split(";");
	  }
		  TriggerEmail.sendEmail(emailAddress, etEmailKey,etPerameter,etValue);
	  }
		//boolean flagET=true;
        if(flagET)
        {
        response.setStatus(getBundleStringValue("transactionSuccess"));
		response.setResponseCode(getBundleStringValue("serviceSuccessStatusCode"));
		response.setResponseMessage(getBundleStringValue("transactionSuccessMessage"));
        }
         else {
        response.setResponseCode(getBundleStringValue("serviceFailedStatusCode"));
		response.setStatus(getBundleStringValue("transactionFailed"));
		response.setResponseMessage(getBundleProperty("ETExactUpdataionFailed"));
        }
		return response.getResponseMessage();
	}
	
	
	/**
	 * Update in et.
	 *
	 * @param entry the entry
	 */
	private boolean updateInET(EtEntryDTO entry) {
		// Create Digital Profile POJO
		DigitalProfile profile = new DigitalProfile();
		profile.setAddress1(entry.getAddress1());
		profile.setAddress2(entry.getAddress2());
		profile.setCity(entry.getCity());
		profile.setCountryCode(entry.getCountry());
		profile.setFirstName(entry.getFirstName());
		profile.setLastName(entry.getLastName());
		profile.setLastUpdateDate(System.currentTimeMillis() + "");// please use
																	// time
																	// miles in
																	// long and
																	// pass as a
																	// String
		profile.setPhoneNumber(entry.getPhone());
		profile.setPostalCode(entry.getZip());
		profile.setStateProvinceCode(entry.getState());
		profile.setEmailAddress(entry.getEmailAddress());
		profile.setSource(entry.getSourceName());
		profile.setTrackingId(entry.getTrackingId());

		// CreateSubscriptionPreferences POJO
		SubscriptionPreferences subscriptionPreferences = new SubscriptionPreferences();
		subscriptionPreferences.setEmailAddress(entry.getEmailAddress());
		// you need to use loop for multiple preferences to add in list
		List<Preferences> preferencesList = entry.getSubscriptionPreferences();
		ETExtensionServices eTExtensionServices = new ETExtensionServicesImpl();
		ETResponse etResponse = null;
		if (preferencesList != null && preferencesList.size() > 0) {
			subscriptionPreferences.setSubscriptionPreferences(preferencesList);

			// Final DigitalProfileWithSubscription POJO will pass in service
			// method with parameters
			DigitalProfileWithSubscription digitalProfileWithSubscription = new DigitalProfileWithSubscription();
			digitalProfileWithSubscription.setDigitalProfile(profile);
			digitalProfileWithSubscription
					.setSubscriptionPreferences(subscriptionPreferences);
			etResponse = eTExtensionServices
					.addUpdateDigitalProfileWithSubscriptions(
							"consumer_marketing",
							digitalProfileWithSubscription);

		} else {
			etResponse = eTExtensionServices.addUpdateDigitalProfile(
					"consumer_marketing", profile);
		}
		
		if (etResponse.getDetailedMessages() != null) {
			for (int i = 0; i < etResponse.getDetailedMessages().length; i++) {
				System.out
						.println("\n\n **********  etResponse.getDetailedMessage "
								+ i
								+ ": "
								+ etResponse.getDetailedMessages()[i]);
			}
		}

		if("200".equals(etResponse.getCode()) || "206".equals(etResponse.getCode() )) {
			return true;
		} else {
			return false;
		}
		
		

	}

	/**
	 * Gets the bundle string value.
	 * 
	 * @param key
	 *            the key
	 * @return the bundle string value
	 */
	public static String getBundleStringValue(String key) {
		return StringUtils.getBundleProperty(
				"com.readersdigest.exacttarget.SweepApiResources", key);
	}

	public static String getBundleProperty(String key) {
		return StringUtils.getBundleProperty(
				"com.readersdigest.exacttarget.ApplicationResources", key);
	}



}
