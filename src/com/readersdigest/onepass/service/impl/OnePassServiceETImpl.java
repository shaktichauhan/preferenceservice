package com.readersdigest.onepass.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;

import javax.persistence.FlushModeType;

import com.cds.global.api.Customer;
import com.cds.global.api.WSG;
import com.cds.global.api.WSGResponse;
import com.readersdigest.exacttarget.client.ETExtensionServices;
import com.readersdigest.exacttarget.client.impl.ETExtensionServicesImpl;
import com.readersdigest.exacttarget.dto.DigitalProfile;
import com.readersdigest.exacttarget.dto.DigitalProfileWithSubscription;
import com.readersdigest.exacttarget.dto.ETResponse;
import com.readersdigest.exacttarget.dto.Preferences;
import com.readersdigest.exacttarget.dto.SubscriptionPreferences;
import com.readersdigest.onepass.db.EntityManagerHelper;
import com.readersdigest.onepass.db.IMemberDAO;
import com.readersdigest.onepass.db.IMemberOnePassInfoDAO;
import com.readersdigest.onepass.db.Member;
import com.readersdigest.onepass.db.MemberDAO;
import com.readersdigest.onepass.db.MemberOnePassInfo;
import com.readersdigest.onepass.db.MemberOnePassInfoDAO;
import com.readersdigest.onepass.dto.CreateOnePassUserProfileDTO;
import com.readersdigest.onepass.dto.OnePassServiceResponse;
import com.readersdigest.onepass.dto.PreferenceDTO;
import com.readersdigest.onepass.dto.UpdateOnePassUserProfileDTO;
import com.readersdigest.onepass.exception.ServiceException;
import com.readersdigest.onepass.util.OneWayEncrypter;
import com.readersdigest.onepass.util.StringUtils;

/**
 * The Class OnePassServiceETImpl.
 * 
 * 
 * @author shsingh
 * 
 */
public class OnePassServiceETImpl extends OnePassServiceImpl {

    /** The Constant OPT_UNDEFINED. */
    public static final int OPT_UNDEFINED = 1;

    /** The Constant OPT_PREFERS. */
    public static final int OPT_PREFERS = 2;

    /** The Constant OPT_PREFERS_NOT. */
    public static final int OPT_PREFERS_NOT = 3;

    /** The Constant OPT_NEVER. */
    public static final int OPT_NEVER = 4;

    /** The Constant ADDRESS_TYPE_ID. */
    public static final int ADDRESS_TYPE_ID = 1;

    /** The Constant EMAIL_PRIMARY_ID. */
    public static final int EMAIL_PRIMARY_ID = 1;

    /** The Constant EMAIL_SECONDARY_ID. */
    public static final int EMAIL_SECONDARY_ID = 2;

    /** The member dao. */
    private IMemberDAO memberDAO;

      private IMemberOnePassInfoDAO memberOnePassInfoDAO;

    /** The service validator. */
    private ServiceValidator serviceValidator;

    /** The service response. */
    private OnePassServiceResponse serviceResponse;

    /** The Constant TRANSACTION_SUCCESS. */
    public static final String TRANSACTION_SUCCESS = getBundleStringValue("transactionSuccess");

    /** The Constant TRANSACTION_FAILED. */
    public static final String TRANSACTION_FAILED = getBundleStringValue("transactionFailed");;

    /** The Constant TRANSACTION_SUCCESS_RESPONSE_TEXT. */
    public static final String TRANSACTION_SUCCESS_RESPONSE_TEXT = getBundleStringValue("transactionSuccessMessage");

    public static final String VALID_STRING = "Y";
    public static final String INVALID_STRING = "N";

    public static final String ACTIVE_MEMBER = "A";
    public static final String INACTIVE_MEMBER = "I";

    /**
     * Instantiates a new one pass service impl.
     */
    public OnePassServiceETImpl() {
        memberDAO = new MemberDAO();
        serviceValidator = new ServiceValidator();
        serviceResponse = new OnePassServiceResponse();
        memberOnePassInfoDAO = new MemberOnePassInfoDAO();
    }

    /**
     * Create the user profile information.
     * 
     * @param dto
     *            the CreateOnePassUserProfileDTO
     * @return the OnePassServiceResponse object
     */
    public OnePassServiceResponse createUserProfileInfo(final CreateOnePassUserProfileDTO dto) {

        try {

            EntityManagerHelper.log("Start OnePassServiceImpl.createUserProfileInfo() ..", Level.INFO, null);
            
            EntityManagerHelper.beginTransaction();
            
            EntityManagerHelper.getEntityManager().setFlushMode(FlushModeType.COMMIT);

            try {
                serviceValidator.validService(dto);
            } catch (ServiceException ex) {
                serviceResponse.responseText = ex.getMessage();
                serviceResponse.status = TRANSACTION_FAILED;
                EntityManagerHelper.rollback();
                return serviceResponse;
            }
            
            Timestamp timeStamp = new Timestamp(System.currentTimeMillis());

            Member member = null;
            String accountNumber = dto.emailFields.accountNumber;

            String prodAbbr = StringUtils.getProdIdBySource(dto.accountFields.sourceId);
            
            member = new Member();
            if (memberDAO.findByMemberName(dto.emailFields.emailAddress.trim()).size() > 0) {
                member.setMemberName(UUID.randomUUID().getMostSignificantBits() + ":" + dto.emailFields.emailAddress.trim());
            } else {
                member.setMemberName(dto.emailFields.emailAddress.trim());
            }

            memberDAO.save(member);
  
            MemberOnePassInfo memberOnePassInfo = new MemberOnePassInfo();

            if (accountNumber != null && !"".equalsIgnoreCase(accountNumber.trim())) {

                accountNumber = accountNumber.trim();
                for (int i = accountNumber.length(); i < 10; i++) {
                    accountNumber = "0" + accountNumber;
                }

            }

            List<MemberOnePassInfo> memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active",
                    dto.emailFields.emailAddress.trim(), prodAbbr, ACTIVE_MEMBER);

            System.out.println("\n\n\n ****** memberOnePassInfoList " + memberOnePassInfoList);

            String lastName = dto.addressFields.lastName == null ? "" : dto.addressFields.lastName;
            String fullName = dto.addressFields.firstName + " " + lastName;

            if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {

                if (memberOnePassInfoList.size() > 1 || 
                        (memberOnePassInfoList.get(0).getAccountNumber() != null && 
                        !"".equals(memberOnePassInfoList.get(0).getAccountNumber()))) {
                    EntityManagerHelper.rollback();
                    throw new ServiceException(StringUtils.getBundleProperty("customerService.accountConfiguration.error"));
                }

                MemberOnePassInfo excMemberOnePassInfo = memberOnePassInfoList.get(0);

                if (accountNumber != null && !"".equalsIgnoreCase(accountNumber.trim())) {
                    excMemberOnePassInfo.setActive(INACTIVE_MEMBER);
                    memberOnePassInfoDAO.update(excMemberOnePassInfo);
                    memberOnePassInfo.setMemberOnePassRefId(excMemberOnePassInfo.getMemberOnePassInfoId());
                } else {
                    EntityManagerHelper.rollback();
                    throw new ServiceException(StringUtils.getBundleProperty("emailAddress.exist"));
                }

            }

            memberOnePassInfo.setMember(member);
            memberOnePassInfo.setPassword(OneWayEncrypter.encryptString(dto.emailFields.password));
            memberOnePassInfo.setEmailAddress(dto.emailFields.emailAddress.trim());
            memberOnePassInfo.setProdId(prodAbbr);
            memberOnePassInfo.setActive(ACTIVE_MEMBER);

            if (accountNumber != null && !"".equalsIgnoreCase(accountNumber.trim())) {
                memberOnePassInfo.setUserType("CDS");
                memberOnePassInfo.setAccountNumber(accountNumber);

                WSGResponse wsgr = null;
                WSG wsg = null;
                Customer customer = null;

                if (StringUtils.isIpadDevice(dto.accountFields.sourceId)) {
                    wsg = new WSG(StringUtils.getBundleProperty("com.readersdigest.onepass.OnePassResources", "cdsIpadAppId"), StringUtils.getBundleProperty(
                            "com.readersdigest.onepass.OnePassResources", "cdsIpadPassword"), prodAbbr);
                } else {
                    wsg = new WSG(StringUtils.getBundleProperty("com.readersdigest.onepass.OnePassResources", "cdsKindleAppId"), StringUtils.getBundleProperty(
                            "com.readersdigest.onepass.OnePassResources", "cdsKindlePassword"), prodAbbr);
                }

                wsgr = wsg.lookupCustomer(accountNumber);

                if (wsgr.isSuccess()) {

                    customer = (Customer) wsgr.getObjects().get(0);

                    if (customer.getEmail() == null || "".equals(customer.getEmail().trim())) {
                        serviceResponse.responseText = StringUtils.getBundleProperty("accountNumber.emailNotActivated");
                        serviceResponse.status = TRANSACTION_FAILED;
                        return serviceResponse;
                    } else if (!dto.emailFields.emailAddress.trim().equalsIgnoreCase(customer.getEmail().trim())) {
                        EntityManagerHelper.rollback();
                        serviceResponse.responseText = StringUtils.getBundleProperty("accountNumber.emailNotMatched");
                        serviceResponse.status = TRANSACTION_FAILED;
                        return serviceResponse;
                    }
                } else {
                    EntityManagerHelper.rollback();
                    serviceResponse.responseText = StringUtils.getBundleProperty("accountNumber.notValid");
                    serviceResponse.status = TRANSACTION_FAILED;
                    return serviceResponse;
                }

                if (customer != null) {
                    memberOnePassInfo.setZipCode(customer.getZipCode());
                    customer.setName(fullName.trim());
                    wsgr = wsg.updateCustomer(customer);
                    if (wsgr.isSuccess() && !wsgr.isSentToOffline()) {
                        memberOnePassInfo.setFullName(fullName.trim());
                    } else {
                        memberOnePassInfo.setFullName(customer.getName());
                    }
                }
            } else {
                memberOnePassInfo.setFullName(fullName.trim());
            }
            memberOnePassInfo.setCreateDate(timeStamp);
            memberOnePassInfoDAO.save(memberOnePassInfo);
            
            // Email Address verification for RD employees for free fulfillment
            String rdEmailPattern = getBundleStringValue("rdEmailRegEx");
            if (dto.emailFields.emailAddress.trim().toLowerCase().matches(rdEmailPattern)) {
                emailValidToken(dto.emailFields.emailAddress.trim().toLowerCase(), prodAbbr);
            }
            
            DigitalProfile profile = new DigitalProfile();
    		profile.setAddress1(dto.addressFields.address1);
    		profile.setAddress2(dto.addressFields.address2);
    		profile.setCity(dto.addressFields.city);
    		profile.setCountryCode(dto.addressFields.countryCode);
    		profile.setFirstName(dto.addressFields.firstName);
    		profile.setLastName(dto.addressFields.lastName);
    		profile.setLastUpdateDate(String.valueOf(System.currentTimeMillis()));//please use time miles in long and pass as a String
    		profile.setPostalCode(dto.addressFields.zip);
    		profile.setStateProvinceCode(dto.addressFields.stateCode);
    		profile.setEmailAddress(dto.emailFields.emailAddress.trim());
    		String sourceName = StringUtils.getSourceName(dto.accountFields.sourceId);
    		profile.setSource(sourceName); /// Set the Source Name
    		
    		// CreateSubscriptionPreferences POJO
    		SubscriptionPreferences subscriptionPreferences = new SubscriptionPreferences();
    		subscriptionPreferences.setEmailAddress(dto.emailFields.emailAddress.trim());
    		
    		Set<PreferenceDTO> preferenceFields = dto.accountFields.preferenceFields;
    		List<Preferences> preferencesList = new ArrayList<Preferences>();
    		
            for (PreferenceDTO preferenceDTO : preferenceFields) {
            	Preferences pre = new Preferences();
        		pre.setLastActivityDate(String.valueOf(System.currentTimeMillis()));//please use time miles in long and pass as a String
        		pre.setOptedIn(preferenceDTO.optIn);
        		pre.setSubscriptionId(preferenceDTO.preferenceId);
        		pre.setLastSource(sourceName); //set the source namr correctly
        		preferencesList.add(pre);
            }
                    
            // you need to use loop for multiple preferences to add in list
    		
    		subscriptionPreferences.setSubscriptionPreferences(preferencesList);

    		// Final DigitalProfileWithSubscription POJO will pass in service method with parameters
    		DigitalProfileWithSubscription digitalProfileWithSubscription = new DigitalProfileWithSubscription();
    		digitalProfileWithSubscription.setDigitalProfile(profile);
    		digitalProfileWithSubscription.setSubscriptionPreferences(subscriptionPreferences);
    		
    		ETExtensionServices eTExtensionServices = new ETExtensionServicesImpl();
    		ETResponse etResponse = eTExtensionServices.addUpdateDigitalProfileWithSubscriptions("onepass", digitalProfileWithSubscription);
    		
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
     * Verify the email address and login details.
     * 
     * @param dto
     *            the OnePassUserLoginDTO
     * @return the OnePassServiceResponse object
     */
    public OnePassServiceResponse minimalRegistration(final CreateOnePassUserProfileDTO dto) {

        EntityManagerHelper.log("Start OnePassServiceImpl.minimalRegistration() ..", Level.INFO, null);

        try {
            
            EntityManagerHelper.beginTransaction();
            EntityManagerHelper.getEntityManager().setFlushMode(FlushModeType.COMMIT);
            
            try {
                serviceValidator.validMinimalRegistrationService(dto);
            } catch (ServiceException ex) {
                serviceResponse.responseText = ex.getMessage();
                serviceResponse.status = TRANSACTION_FAILED;
                EntityManagerHelper.rollback();
                EntityManagerHelper.log("Error OnePassServiceImpl.userLogin() ..", Level.INFO, ex);
                return serviceResponse;
            }

            Timestamp timeStamp = new Timestamp(System.currentTimeMillis());

            Member member = new Member();

            if (memberDAO.findByMemberName(dto.emailFields.emailAddress.trim()).size() > 0) {
                member.setMemberName(UUID.randomUUID().getMostSignificantBits() + ":" + dto.emailFields.emailAddress.trim());
            } else {
                member.setMemberName(dto.emailFields.emailAddress.trim());
            }

            memberDAO.save(member);

            MemberOnePassInfo memberOnePassInfo = new MemberOnePassInfo();

            String prodAbbr = StringUtils.getProdIdBySource(dto.accountFields.sourceId);
            memberOnePassInfo.setMember(member);
            memberOnePassInfo.setActive(ACTIVE_MEMBER);
            memberOnePassInfo.setPassword(OneWayEncrypter.encryptString(dto.emailFields.password));
            memberOnePassInfo.setEmailAddress(dto.emailFields.emailAddress.trim());
            memberOnePassInfo.setProdId(prodAbbr);
            memberOnePassInfo.setCreateDate(timeStamp);

            memberOnePassInfoDAO.save(memberOnePassInfo);

            DigitalProfile profile = new DigitalProfile();
    		profile.setEmailAddress(dto.emailFields.emailAddress.trim());
    		String sourceName = StringUtils.getSourceName(dto.accountFields.sourceId);
    		profile.setSource(sourceName); /// Set the Source Name
    	
    		
    		ETExtensionServices eTExtensionServices = new ETExtensionServicesImpl();
    		ETResponse etResponse = eTExtensionServices.addUpdateDigitalProfile("onepass", profile);
    		
    		System.out.println("\n\n **********  etResponse.getCode() : " + etResponse.getCode());
    		System.out.println("\n\n **********  etResponse.getDescription() : " + etResponse.getDescription());
    		
    		if(etResponse.getDetailedMessages() != null) {
    			for(int i=0; i<etResponse.getDetailedMessages().length; i++) {
    				System.out.println("\n\n **********  etResponse.getDetailedMessage " + i +": " + etResponse.getDetailedMessages()[i]);
    			}
    		}
            
            // Email Address verification for RD employees for free fulfillment
            String rdEmailPattern = getBundleStringValue("rdEmailRegEx");
            if (dto.emailFields.emailAddress.trim().toLowerCase().matches(rdEmailPattern)) {
                emailValidToken(dto.emailFields.emailAddress.trim().toLowerCase(), prodAbbr);
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
     * Update the user profile information.
     * 
     * @param dto
     *            the UpdateOnePassUserProfileDTO
     * @return the OnePassServiceResponse object
     */
    public OnePassServiceResponse updateUserProfileInfo(final UpdateOnePassUserProfileDTO dto) {

        try {

            EntityManagerHelper.log("Start OnePassServiceImpl.updateUserProfileInfo() ..", Level.INFO, null);

            EntityManagerHelper.beginTransaction();
            EntityManagerHelper.getEntityManager().setFlushMode(FlushModeType.COMMIT);
            
            try {
                serviceValidator.validUpdateService(dto);
            } catch (ServiceException ex) {
                serviceResponse.responseText = ex.getMessage();
                serviceResponse.status = TRANSACTION_FAILED;
                return serviceResponse;
            }

            MemberOnePassInfo memberOnePassInfo = null;

            String prodAbbr = StringUtils.getProdIdBySource(dto.accountFields.sourceId);

            System.out.println("\n\n\n\n ***** dto.emailFields.emailAddress : " + dto.header.emailAddress.trim());
            System.out.println("\n\n\n\n ***** dto.emailFields.memberOnePassInfoDAO : " + memberOnePassInfoDAO);

            List<MemberOnePassInfo> memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active",
                    dto.header.emailAddress.trim(), prodAbbr, ACTIVE_MEMBER);

            // List<MemberOnePassInfo> newMemberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress",
            // "prodId",dto.emailFields.emailAddress.trim(), prodAbbr);

            if (memberOnePassInfoList == null || memberOnePassInfoList.size() == 0) {
                serviceResponse.responseText = StringUtils.getBundleProperty("emailAddress.notExist");
                serviceResponse.status = TRANSACTION_FAILED;
                EntityManagerHelper.rollback();
                return serviceResponse;
            } else {
                memberOnePassInfo = memberOnePassInfoList.get(0);
            }
            System.out.println("\n\n\n &&&&&&&&&&&& 11111111111111111shanu in uddate");
            
            
            if (dto.addressFields.firstName != null && !"".equals(dto.addressFields.firstName.trim())) {
                String lastName = dto.addressFields.lastName == null ? "" : dto.addressFields.lastName;
                String fullName = dto.addressFields.firstName + " " + lastName;
                memberOnePassInfo.setFullName(fullName.trim());
            }

            if (dto.emailFields.password != null) {
                memberOnePassInfo.setPassword(OneWayEncrypter.encryptString(dto.emailFields.password));
            }
            

            DigitalProfile profile = new DigitalProfile();
    		profile.setAddress1(dto.addressFields.address1);
    		profile.setAddress2(dto.addressFields.address2);
    		profile.setCity(dto.addressFields.city);
    		profile.setCountryCode(dto.addressFields.countryCode);
    		profile.setFirstName(dto.addressFields.firstName);
    		profile.setLastName(dto.addressFields.lastName);
    		profile.setLastUpdateDate(String.valueOf(System.currentTimeMillis()));//please use time miles in long and pass as a String
    		profile.setPostalCode(dto.addressFields.zip);
    		profile.setStateProvinceCode(dto.addressFields.stateCode);
    		profile.setEmailAddress(dto.header.emailAddress.trim());
    		String sourceName = StringUtils.getSourceName(dto.accountFields.sourceId);
    		profile.setSource(sourceName); /// Set the Source Name
    		
    		// CreateSubscriptionPreferences POJO
    		SubscriptionPreferences subscriptionPreferences = new SubscriptionPreferences();
    		subscriptionPreferences.setEmailAddress(dto.header.emailAddress.trim());
    		
    		Set<PreferenceDTO> preferenceFields = dto.accountFields.preferenceFields;
    		List<Preferences> preferencesList = new ArrayList<Preferences>();
    		
            for (PreferenceDTO preferenceDTO : preferenceFields) {
            	Preferences pre = new Preferences();
        		pre.setLastActivityDate(String.valueOf(System.currentTimeMillis()));//please use time miles in long and pass as a String
        		pre.setOptedIn(preferenceDTO.optIn);
        		pre.setSubscriptionId(preferenceDTO.preferenceId);
        		pre.setLastSource(sourceName);
        		preferencesList.add(pre);
            }
                    
            // you need to use loop for multiple preferences to add in list
    		
    		subscriptionPreferences.setSubscriptionPreferences(preferencesList);

    		// Final DigitalProfileWithSubscription POJO will pass in service method with parameters
    		DigitalProfileWithSubscription digitalProfileWithSubscription = new DigitalProfileWithSubscription();
    		digitalProfileWithSubscription.setDigitalProfile(profile);
    		digitalProfileWithSubscription.setSubscriptionPreferences(subscriptionPreferences);
    		
    		ETExtensionServices eTExtensionServices = new ETExtensionServicesImpl();
    		ETResponse etResponse = eTExtensionServices.addUpdateDigitalProfileWithSubscriptions("onepass", digitalProfileWithSubscription);
    		
    		System.out.println("\n\n **********  etResponse.getCode() : " + etResponse.getCode());
    		System.out.println("\n\n **********  etResponse.getDescription() : " + etResponse.getDescription());
    		
    		if(etResponse.getDetailedMessages() != null) {
    			for(int i=0; i<etResponse.getDetailedMessages().length; i++) {
    				System.out.println("\n\n **********  etResponse.getDetailedMessage " + i +": " + etResponse.getDetailedMessages()[i]);
    			}
    		}

            EntityManagerHelper.commit();

            serviceResponse.primaryEmailAddress = memberOnePassInfo.getEmailAddress();

            EntityManagerHelper.log("End OnePassServiceImpl.updateUserProfileInfo() ..", Level.INFO, null);
        } catch (ServiceException ex) {
            EntityManagerHelper.log("Error OnePassServiceImpl.updateUserProfileInfo() ..", Level.ALL, ex);
            ex.printStackTrace();
            EntityManagerHelper.rollback();
            serviceResponse.responseText = ex.getMessage();
            serviceResponse.status = TRANSACTION_FAILED;
            return serviceResponse;

        } catch (Exception ex) {
            EntityManagerHelper.log("Error OnePassServiceImpl.updateUserProfileInfo() ..", Level.ALL, ex);
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

       
}
