package com.readersdigest.onepass.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;

import com.readersdigest.exacttarget.client.ETExtensionServices;
import com.readersdigest.exacttarget.client.impl.ETExtensionServicesImpl;
import com.readersdigest.exacttarget.dto.DigitalProfile;
import com.readersdigest.exacttarget.dto.DigitalProfileWithSubscription;
import com.readersdigest.exacttarget.dto.ETResponse;
import com.readersdigest.exacttarget.dto.Preferences;
import com.readersdigest.exacttarget.dto.SubscriptionPreferences;
import com.readersdigest.onepass.brandAdvocate.form.RegistrationForm;
import com.readersdigest.onepass.db.EntityManagerHelper;
import com.readersdigest.onepass.db.IMemberAdvocateInfoDAO;
import com.readersdigest.onepass.db.IMemberOnePassInfoDAO;
import com.readersdigest.onepass.db.MemberAdvocateInfo;
import com.readersdigest.onepass.db.MemberAdvocateInfoDAO;
import com.readersdigest.onepass.db.MemberOnePassInfo;
import com.readersdigest.onepass.db.MemberOnePassInfoDAO;
import com.readersdigest.onepass.dto.OnePassServiceResponse;
import com.readersdigest.onepass.exception.ServiceException;
import com.readersdigest.onepass.util.OneWayEncrypter;
import com.readersdigest.onepass.util.StringUtils;


/**
 * The Class OnePassBrandAdvocateServiceImpl.
 * 
 * @author shsingh
 */
public class OnePassBrandAdvocateServiceImpl {
	
    /** The Constant ACTIVE_MEMBER. */
    public static final String ACTIVE_MEMBER = "A";
    
    /** The Constant TRANSACTION_SUCCESS. */
    public static final String TRANSACTION_SUCCESS = getBundleStringValue("transactionSuccess");

    /** The Constant TRANSACTION_FAILED. */
    public static final String TRANSACTION_FAILED = getBundleStringValue("transactionFailed");;

    /** The Constant TRANSACTION_SUCCESS_RESPONSE_TEXT. */
    public static final String TRANSACTION_SUCCESS_RESPONSE_TEXT = getBundleStringValue("transactionSuccessMessage");
	
    /**
     * Register advocate profile.
     *
     * @param memAdvInfo the mem adv info
     * @return the one pass service response
     */
    public OnePassServiceResponse registerAdvocateProfile(MemberAdvocateInfo memAdvInfo) {
		OnePassServiceResponse response = new OnePassServiceResponse();
		
		try {
			EntityManagerHelper.beginTransaction();
			MemberAdvocateInfoDAO memberadv= new MemberAdvocateInfoDAO();
			memberadv.save(memAdvInfo);
			EntityManagerHelper.commit();
		} catch (Exception e) {
			e.printStackTrace();
			EntityManagerHelper.rollback();
			response.status = TRANSACTION_FAILED;
			return response;
		}
		
		
		return response;
	}
	
	/**
	 * Gets the advocate member.
	 *
	 * @param token the token
	 * @return the advocate member
	 */
	public MemberAdvocateInfo getAdvocateMember(String token) {
		
		try {
			IMemberAdvocateInfoDAO memberAdvocateInfoDAO = new MemberAdvocateInfoDAO();
	    
	        List<MemberAdvocateInfo> memberAdvocateList =  memberAdvocateInfoDAO.findByProperty("token", token);
	        if (memberAdvocateList != null && memberAdvocateList.size() > 0) {
	        	return memberAdvocateList.get(0);
	        }
	        
		} catch (Exception e) {
			// TODO Auto-generated catch block
			
			// need to pass failed response here
			e.printStackTrace();
			return null;
		}
		
		
		return null;
	}
	
	
	 /**
 	 * Creates the profile.
 	 *
 	 * @param form the form
 	 * @return the one pass service response
 	 */
 	public OnePassServiceResponse createProfile(RegistrationForm form) {

        EntityManagerHelper.log("Start OnePassBrandAdvocateServiceImpl.createProfile() ..", Level.INFO, null);
        OnePassServiceResponse serviceResponse = new OnePassServiceResponse();
        
        try {
           
        	EntityManagerHelper.beginTransaction();
            Timestamp timeStamp = new Timestamp(System.currentTimeMillis());


            MemberOnePassInfo memberOnePassInfo = new MemberOnePassInfo();

            String prodAbbr = form.getProdAbbr();
            
            String lastName = form.getRecipiantLastName() == null ? "" : form.getRecipiantLastName();
            String fullName = form.getRecipiantFirstName() + " " + lastName;
            IMemberOnePassInfoDAO memberOnePassInfoDAO = new MemberOnePassInfoDAO();
            memberOnePassInfo.setActive(ACTIVE_MEMBER);
            memberOnePassInfo.setPassword(OneWayEncrypter.encryptString(form.getRecipiantPassword()));
            memberOnePassInfo.setEmailAddress(form.getRecipiantEmailAddress().trim());
            memberOnePassInfo.setFullName(fullName);
            memberOnePassInfo.setProdId(prodAbbr);
            memberOnePassInfo.setUserType(form.getUserType());
            memberOnePassInfo.setCreateDate(timeStamp);

            memberOnePassInfoDAO.save(memberOnePassInfo);

            DigitalProfile profile = new DigitalProfile();
    		profile.setEmailAddress(form.getRecipiantEmailAddress().trim());
    		profile.setSource(form.getSourceName()); 
    		profile.setTrackingId(form.getTrkId());
    	
    		// CreateSubscriptionPreferences POJO
    		SubscriptionPreferences subscriptionPreferences = new SubscriptionPreferences();
    		subscriptionPreferences.setEmailAddress(form.getRecipiantEmailAddress().trim());
    		
    		String[] promotables = form.getPromotable();
    		List<Preferences> preferencesList = new ArrayList<Preferences>();
    		
    		if(promotables != null && promotables.length > 0) {
    			
    			for (String promotable : promotables) {
                	Preferences pre = new Preferences();
            		pre.setLastActivityDate(String.valueOf(System.currentTimeMillis()));
            		pre.setOptedIn(true);
            		pre.setSubscriptionId(promotable);
            		pre.setLastSource(form.getSourceName()); 
            		pre.setLastTrackingId(form.getTrkId());
            		preferencesList.add(pre);
                }
        		            
    		}
    		     
          	subscriptionPreferences.setSubscriptionPreferences(preferencesList);

    		// Final DigitalProfileWithSubscription POJO will pass in service method with parameters
    		DigitalProfileWithSubscription digitalProfileWithSubscription = new DigitalProfileWithSubscription();
    		digitalProfileWithSubscription.setDigitalProfile(profile);
    		digitalProfileWithSubscription.setSubscriptionPreferences(subscriptionPreferences);
    		
    		ETExtensionServices eTExtensionServices = new ETExtensionServicesImpl();
    		ETResponse etResponse = null;
    		
    		if(preferencesList != null && preferencesList.size() > 0) {
    			etResponse = eTExtensionServices.addUpdateDigitalProfileWithSubscriptions("onepass", digitalProfileWithSubscription);
    		} else {
    			etResponse = eTExtensionServices.addUpdateDigitalProfile("onepass", profile);
    		}
    		
    		
    		System.out.println("\n\n **********  etResponse.getCode() : " + etResponse.getCode());
    		System.out.println("\n\n **********  etResponse.getDescription() : " + etResponse.getDescription());
    		
    		if(etResponse.getDetailedMessages() != null) {
    			for(int i=0; i<etResponse.getDetailedMessages().length; i++) {
    				System.out.println("\n\n **********  etResponse.getDetailedMessage " + i +": " + etResponse.getDetailedMessages()[i]);
    			}
    		}

            EntityManagerHelper.commit();

            
            EntityManagerHelper.log("End OnePassServiceImpl.createUserProfileInfo() ..", Level.INFO, null);
        } catch (ServiceException ex) {
            EntityManagerHelper.log("Error OnePassServiceImpl.createUserProfileInfo() ..", Level.ALL, ex);
            ex.printStackTrace();
            EntityManagerHelper.rollback();
            serviceResponse.responseText = ex.getMessage();
            serviceResponse.status = TRANSACTION_FAILED;
            return serviceResponse;

        } catch (Exception ex) {
            EntityManagerHelper.log("Error OnePassServiceImpl.createUserProfileInfo() ..", Level.ALL, ex);
            ex.printStackTrace();
            EntityManagerHelper.rollback();
            serviceResponse.responseText = ex.getMessage();
            serviceResponse.status = TRANSACTION_FAILED;
            return serviceResponse;

        } finally {
            EntityManagerHelper.clear();
            EntityManagerHelper.closeEntityManager();
        }

        serviceResponse.responseText = TRANSACTION_SUCCESS_RESPONSE_TEXT;
        serviceResponse.status = TRANSACTION_SUCCESS;
        return serviceResponse;
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
					"com.readersdigest.onepass.OnePassResources", key);
		}
	
}

    