package com.readersdigest.onepass.service;

import com.readersdigest.onepass.dto.OnePassTummyServiceResponse;
import com.readersdigest.onepass.dto.OnePassTummyUserProfileDTO;

// TODO: Auto-generated Javadoc
/**
 * The Interface OnePassTummyService.
 * 
 * @author shsingh
 */
public interface OnePassTummyService {

    /**
     * Authentication bhe order.
     *
     * @param emailAddress the email address
     * @param deviceId the device id
     * @return the one pass tummy service response
     */
    OnePassTummyServiceResponse authenticationBHEorder(String emailAddress,String deviceId, String appId);
    
    
    /**
     * Tummy one pass profile.
     *
     * @param dto the dto
     * @return the one pass tummy service response
     */
    OnePassTummyServiceResponse tummyOnePassProfile(OnePassTummyUserProfileDTO dto);
    
    /**
     * Creates the one pass bhe user.
     *
     * @param emailAddress the email address
     * @return the one pass tummy service response
     */
    OnePassTummyServiceResponse createOnePassBHEUser(String emailAddress, String appId);
    
    /**
     * Update email address.
     *
     * @param oldEmailAddress the old email address
     * @param newEmailAddress the new email address
     * @param sourceId the source id
     * @param appId the app id
     * @return the one pass tummy service response
     */
    OnePassTummyServiceResponse updateEmailAddress(String oldEmailAddress, String newEmailAddress,String sourceId, String appId);


}
