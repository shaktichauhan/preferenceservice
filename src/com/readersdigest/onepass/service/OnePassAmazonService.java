package com.readersdigest.onepass.service;

import com.readersdigest.onepass.dto.OnePassServiceAmazonResponse;
import com.readersdigest.onepass.dto.OnePassServiceRequest;

// TODO: Auto-generated Javadoc
/**
 * The Interface OnePassAmazonService.
 * 
 * @author shsingh
 */
public interface OnePassAmazonService {

    
    /**
     * One pass validation.
     *
     * @param onePassRequest the one pass request
     * @return the one pass service amazon response
     */
    OnePassServiceAmazonResponse onePassValidation(OnePassServiceRequest onePassRequest);
    
    /**
     * One pass registration.
     *
     * @param onePassRequest the one pass request
     * @return the one pass service amazon response
     */
    OnePassServiceAmazonResponse onePassRegistration(OnePassServiceRequest onePassRequest);

    /**
     * One pass subscription status.
     *
     * @param onePassRequest the one pass request
     * @return the one pass service amazon response
     */
    OnePassServiceAmazonResponse onePassSubscriptionStatus(OnePassServiceRequest onePassRequest);

    /**
     * One pass entitlements.
     *
     * @param onePassRequest the one pass request
     * @return the one pass service amazon response
     */
    OnePassServiceAmazonResponse onePassEntitlements(OnePassServiceRequest onePassRequest);

    /**
     * One pass sign in with credentials.
     *
     * @param onePassRequest the one pass request
     * @return the one pass service amazon response
     */
    OnePassServiceAmazonResponse onePassSignInWithCredentials(OnePassServiceRequest onePassRequest); 
    
    /**
     * One pass forgot password.
     *
     * @param onePassRequest the one pass request
     * @return the one pass service amazon response
     */
    OnePassServiceAmazonResponse onePassForgotPassword(OnePassServiceRequest onePassRequest);

 

}
