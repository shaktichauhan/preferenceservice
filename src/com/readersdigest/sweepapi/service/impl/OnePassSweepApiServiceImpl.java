package com.readersdigest.sweepapi.service.impl;

import java.sql.Timestamp;
import java.util.List;

import com.readersdigest.exacttarget.client.ETExtensionServices;
import com.readersdigest.exacttarget.client.impl.ETExtensionServicesImpl;
import com.readersdigest.exacttarget.dto.DigitalProfile;
import com.readersdigest.exacttarget.dto.DigitalProfileWithSubscription;
import com.readersdigest.exacttarget.dto.ETResponse;
import com.readersdigest.exacttarget.dto.Preferences;
import com.readersdigest.exacttarget.dto.SubscriptionPreferences;
import com.readersdigest.onepass.exception.ServiceException;
import com.readersdigest.onepass.service.impl.ServiceValidator;
import com.readersdigest.onepass.util.StringUtils;
import com.readersdigest.sweepapi.db.EntityManagerHelper;
import com.readersdigest.sweepapi.db.ISweepEntryDAO;
import com.readersdigest.sweepapi.db.SweepEntryDAO;
import com.readersdigest.sweepapi.db.SweepValidation;
import com.readersdigest.sweepapi.db.SweepsEntry;
import com.readersdigest.sweepapi.dto.OnePassSweepEntryResponse;
import com.readersdigest.sweepapi.dto.SweepEntryDTO;
import com.readersdigest.sweepapi.service.OnePassSweepApiService;


/**
 * The Class OnePassSweepApiServiceImpl.
 */
public class OnePassSweepApiServiceImpl implements OnePassSweepApiService {

   /* (non-Javadoc)
    * @see com.readersdigest.sweepapi.service.OnePassSweepApiService#createSweepEntry(com.readersdigest.sweepapi.dto.SweepEntryDTO)
    */
   public OnePassSweepEntryResponse createSweepEntry(SweepEntryDTO entry) {
	   OnePassSweepEntryResponse response  = new OnePassSweepEntryResponse();
	   
	   try {
		   SweepsEntry sweepsEntry  = new SweepsEntry();
		   ISweepEntryDAO sweepsDAO = new SweepEntryDAO();
		   ServiceValidator serviceValidator = new ServiceValidator();
		   
			try {
				serviceValidator.validateRequired(String.valueOf(entry.getSepId()), "Sep Id is required");
				serviceValidator.validEmail(entry.getEmailAddress());
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				 response.setStatus(getBundleStringValue("transactionFailed"));
				 response.setResponseCode(getBundleStringValue("serviceFailedStatusCode"));
				 response.setResponseMessage(e.getMessage());
				 return response;
			}
		   
		   SweepValidation sweepVal =  sweepsDAO.getListValidationId(entry.getSepId());
		   boolean validate = sweepVal.validateRequest(sweepVal);
		   
		   if(!validate) {
			   response.setStatus(getBundleStringValue("transactionFailed"));
			   response.setResponseCode(getBundleStringValue("serviceFailedStatusCode"));
			   response.setResponseMessage("The Sep Id is not valid or inactivated");
			   return response;
		   }
		   
		   EntityManagerHelper.beginTransaction();
		   sweepsEntry.setSepId(entry.getSepId());
		   sweepsEntry.setFirstName(entry.getFirstName());
		   sweepsEntry.setLastName(entry.getLastName());
		   sweepsEntry.setEmail(entry.getEmailAddress());
		   sweepsEntry.setTrackingId(entry.getTrackingId());
		   sweepsEntry.setAddress1(entry.getAddress1());
		   sweepsEntry.setAddress2(entry.getAddress2());
		   sweepsEntry.setCity(entry.getCity());
		   sweepsEntry.setState(entry.getState());
		   sweepsEntry.setZip(entry.getZip());
		   sweepsEntry.setPhone(entry.getPhone());
		   sweepsEntry.setCountry(entry.getCountry());
		   sweepsEntry.setSpId(sweepVal.getSpId());
		   sweepsEntry.setCreateDate(new Timestamp(System.currentTimeMillis()));
		   sweepsEntry.setCreateDatetime( new Timestamp(System.currentTimeMillis()));
		   sweepsDAO.save(sweepsEntry);
		   EntityManagerHelper.commit();

		   System.out.println("\n\n\n &&&&&&&&&&&& sweepsEntry.getSeId() " +sweepsEntry.getSeId());
		   System.out.println("\n\n\n &&&&&&&&&&&& sweepsEntry.getSeId() " +sweepsEntry.getSpId());
		   response.setSeId(sweepsEntry.getSeId());
		   response.setSpId(sweepsEntry.getSpId());
		   response.setStatus(getBundleStringValue("transactionSuccess"));
		   response.setResponseCode(getBundleStringValue("serviceSuccessStatusCode"));
		   response.setResponseMessage(getBundleStringValue("transactionSuccessMessage"));
		   
		  
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		EntityManagerHelper.rollback();
		response.setStatus(getBundleStringValue("transactionFailed"));
		response.setResponseCode(getBundleStringValue("serviceFailedStatusCode"));
		response.setResponseMessage(e.getMessage());
	} finally {
		EntityManagerHelper.clear();
		EntityManagerHelper.closeEntityManager();
	}
	  
	   return response;
   }

   
   /* (non-Javadoc)
    * @see com.readersdigest.sweepapi.service.OnePassSweepApiService#createSweepEntryWithSubscription(com.readersdigest.sweepapi.dto.SweepEntryDTO)
    */
   public OnePassSweepEntryResponse createSweepEntryWithSubscription(SweepEntryDTO entry) {
	   OnePassSweepEntryResponse response  = new OnePassSweepEntryResponse();
	   
	   try {
		   
		   SweepsEntry sweepsEntry  = new SweepsEntry();
		   ISweepEntryDAO sweepsDAO = new SweepEntryDAO();
		   ServiceValidator serviceValidator = new ServiceValidator();
		   
			try {
				serviceValidator.validateRequired(String.valueOf(entry.getSepId()), "Sep Id is required");
				serviceValidator.validEmail(entry.getEmailAddress());
			} catch (ServiceException e) {
				// TODO Auto-generated catch block
				 response.setStatus(getBundleStringValue("transactionFailed"));
				 response.setResponseCode(getBundleStringValue("serviceFailedStatusCode"));
				 response.setResponseMessage(e.getMessage());
				 return response;
			}
		   
		   SweepValidation sweepVal =  sweepsDAO.getListValidationId(entry.getSepId());
		   boolean validate = sweepVal.validateRequest(sweepVal);
		   
		   if(!validate) {
			   response.setStatus(getBundleStringValue("transactionFailed"));
			   response.setResponseCode(getBundleStringValue("serviceFailedStatusCode"));
			   response.setResponseMessage("The Sep Id is not valid or inactivated");
			   return response;
		   }
		   
		   EntityManagerHelper.beginTransaction();
		   sweepsEntry.setSepId(entry.getSepId());
		   sweepsEntry.setFirstName(entry.getFirstName());
		   sweepsEntry.setLastName(entry.getLastName());
		   sweepsEntry.setEmail(entry.getEmailAddress());
		   sweepsEntry.setTrackingId(entry.getTrackingId());
		   sweepsEntry.setAddress1(entry.getAddress1());
		   sweepsEntry.setAddress2(entry.getAddress2());
		   sweepsEntry.setCity(entry.getCity());
		   sweepsEntry.setState(entry.getState());
		   sweepsEntry.setZip(entry.getZip());
		   sweepsEntry.setPhone(entry.getPhone());
		   sweepsEntry.setCountry(entry.getCountry());
		   sweepsEntry.setSpId(sweepVal.getSpId());
		   sweepsEntry.setCreateDate(new Timestamp(System.currentTimeMillis()));
		   sweepsEntry.setCreateDatetime( new Timestamp(System.currentTimeMillis()));
		   sweepsDAO.save(sweepsEntry);
		   EntityManagerHelper.commit();
		   
		   updateInET(entry);

		   response.setSeId(sweepsEntry.getSeId());
		   response.setSpId(sweepsEntry.getSpId());
		   response.setStatus(getBundleStringValue("transactionSuccess"));
		   response.setResponseCode(getBundleStringValue("serviceSuccessStatusCode"));
		   response.setResponseMessage(getBundleStringValue("transactionSuccessMessage"));
		   
		  
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		EntityManagerHelper.rollback();
		response.setStatus(getBundleStringValue("transactionFailed"));
		response.setResponseCode(getBundleStringValue("serviceFailedStatusCode"));
		response.setResponseMessage(e.getMessage());
	} finally {
		EntityManagerHelper.clear();
		EntityManagerHelper.closeEntityManager();
	}
	  
	   return response;
   }
   
   
   private void updateInET(SweepEntryDTO entry) {
	   // Create Digital Profile POJO
		DigitalProfile profile = new DigitalProfile();
		profile.setAddress1(entry.getAddress1());
		profile.setAddress2(entry.getAddress2());
		profile.setCity(entry.getCity());
		profile.setCountryCode(entry.getCountry());
		profile.setFirstName(entry.getFirstName());
		profile.setLastName(entry.getLastName());
		profile.setLastUpdateDate(System.currentTimeMillis()+"");//please use time miles in long and pass as a String
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
		if(preferencesList != null && preferencesList.size() > 0) {
			subscriptionPreferences.setSubscriptionPreferences(preferencesList);

			// Final DigitalProfileWithSubscription POJO will pass in service method with parameters
			DigitalProfileWithSubscription digitalProfileWithSubscription = new DigitalProfileWithSubscription();
			digitalProfileWithSubscription.setDigitalProfile(profile);
			digitalProfileWithSubscription.setSubscriptionPreferences(subscriptionPreferences);
			etResponse = eTExtensionServices.addUpdateDigitalProfileWithSubscriptions("consumer_marketing", digitalProfileWithSubscription);
			
		} else {
			etResponse = eTExtensionServices.addUpdateDigitalProfile("consumer_marketing", profile);
		}
		
		System.out.println("\n\n **********  etResponse.getCode() : " + etResponse.getCode());
		System.out.println("\n\n **********  etResponse.getDescription() : " + etResponse.getDescription());
		if(etResponse.getDetailedMessages() != null) {
			for(int i=0; i<etResponse.getDetailedMessages().length; i++) {
				System.out.println("\n\n **********  etResponse.getDetailedMessage " + i +": " + etResponse.getDetailedMessages()[i]);
			}
		}
		
   }
   /**
    * Gets the bundle string value.
    *
    * @param key the key
    * @return the bundle string value
    */
   public static String getBundleStringValue(String key) {
       return StringUtils.getBundleProperty("com.readersdigest.onepass.OnePassResources", key);
   }


}
