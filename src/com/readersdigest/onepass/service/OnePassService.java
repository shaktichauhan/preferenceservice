package com.readersdigest.onepass.service;

import com.readersdigest.onepass.dto.CreateOnePassUserProfileDTO;
import com.readersdigest.onepass.dto.OnePassServiceAdobeEntitledVerifyResponse;
import com.readersdigest.onepass.dto.OnePassServiceAdobeResponse;
import com.readersdigest.onepass.dto.OnePassServiceResponse;
import com.readersdigest.onepass.dto.UpdateOnePassUserProfileDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface OnePassService.
 * 
 * @author shsingh
 */
public interface OnePassService {

    /**
     * Creates the user profile info.
     * 
     * @param onePassRequest
     *            the one pass request
     * @return the one pass service response
     */
    OnePassServiceResponse createUserProfileInfo(CreateOnePassUserProfileDTO onePassRequest);

    /**
     * Update email profile info.
     * 
     * @param onePassRequest
     *            the one pass request
     * @return the one pass service response
     */
    OnePassServiceResponse updateEmailProfileInfo(UpdateOnePassUserProfileDTO onePassRequest);
    
    /**
     * Update user profile info.
     * 
     * @param onePassRequest
     *            the one pass request
     * @return the one pass service response
     */
    OnePassServiceResponse updateUserProfileInfo(UpdateOnePassUserProfileDTO onePassRequest);
    
    /**
     * Update cds user profile info.
     *
     * @param dto the dto
     * @return the one pass service response
     */
   // OnePassServiceResponse updateCDSUserProfileInfo(final UpdateOnePassUserProfileDTO dto);

    /**
     * Minimal registration.
     * 
     * @param dto
     *            the dto
     * @return the one pass service response
     */
    OnePassServiceResponse minimalRegistration(final CreateOnePassUserProfileDTO dto);

    /**
     * Renew auth token.
     * 
     * @param authToken
     *            the auth token
     * @param appId
     *            the app id
     * @param appVersion
     *            the app version
     * @return the one pass service adobe response
     */
    OnePassServiceAdobeResponse renewAuthToken(String authToken, String appId, String appVersion);

    /**
     * Sign in with credentials.
     * 
     * @param emailAddress
     *            the email address
     * @param password
     *            the password
     * @param appId
     *            the app id
     * @param appVersion
     *            the app version
     * @param uuid
     *            the uuid
     * @return the one pass service adobe response
     */
    OnePassServiceAdobeResponse signInWithCredentials(String emailAddress, String password, String appId, String appVersion, String uuid);

    /**
     * Entitlements.
     * 
     * @param authToken
     *            the auth token
     * @param appId
     *            the app id
     * @param appVersion
     *            the app version
     * @return the one pass service adobe response
     */
    OnePassServiceAdobeResponse entitlements(String authToken, String appId, String appVersion);

    /**
     * Verify entitlement.
     * 
     * @param authToken
     *            the auth token
     * @param productId
     *            the product id
     * @param appId
     *            the app id
     * @param appVersion
     *            the app version
     * @return the one pass service adobe response
     */
    OnePassServiceAdobeEntitledVerifyResponse verifyEntitlement(String authToken, String productId, String appId, String appVersion);

    /**
     * Reset forget password token.
     *
     * @param emailAddress the email address
     * @param sourceId the source id
     * @return the one pass service response
     */
    OnePassServiceResponse resetForgetPasswordToken(String emailAddress, String sourceId);

    /**
     * Update new password.
     *
     * @param token the token
     * @param password the password
     * @param sourceId the source id
     * @return the one pass service response
     */
    OnePassServiceResponse updateNewPassword(String token, String password, String sourceId);
    
    
    

    /**
     * Update email address.
     *
     * @param oldEmailAddress the old email address
     * @param newEmailAddress the new email address
     * @param prodId the prod id
     * @return the one pass service response
     */
    OnePassServiceResponse updateEmailAddress(String oldEmailAddress, String newEmailAddress, String prodId);
    
    
    /**
     * Update one pass all brands email address.
     *
     * @param oldEmailAddress the old email address
     * @param newEmailAddress the new email address
     * @return the one pass service response
     */
    OnePassServiceResponse updateOnePassAllBrandsEmailAddress(String oldEmailAddress, String newEmailAddress);


    /**
     * Update cds user password.
     *
     * @param emailAddress the email address
     * @param password the password
     * @param accountNumber the account number
     * @param appId the app id
     * @return the one pass service adobe response
     */
    OnePassServiceAdobeResponse updateCDSUserPassword(String emailAddress, String password, String accountNumber, String appId); 

    /**
     * Gets the user info.
     *
     * @param userName the user name
     * @param appId the app id
     * @return the user info
     */
    OnePassServiceAdobeResponse getUserInfo(String userName, String appId); 

    /**
     * Encrypt user name.
     *
     * @param token the token
     * @return the string
     */
    //String encryptUserName(String userName, String appId);
    
    /**
     * Update email validity.
     *
     * @param token the token
     * @return true, if successful
     */
    boolean updateEmailValidity(String token);
    
    
    /**
     * Update valid email address.
     *
     * @param accountNumber the account number
     * @param oldEmailAddress the old email address
     * @param newEmailAddress the new email address
     * @param password the password
     * @param sourceId the source id
     * @param appId the app id
     * @return the one pass service response
     */
    OnePassServiceResponse updateValidEmailAddress(String accountNumber,String oldEmailAddress, String newEmailAddress, String password, String sourceId, String appId);
    
    
    /**
     * Valid cds email address.
     *
     * @param emailAddress the email address
     * @param appId the app id
     * @return the one pass service adobe response
     */
    OnePassServiceAdobeResponse validCDSEmailAddress(String emailAddress, String appId);


}
