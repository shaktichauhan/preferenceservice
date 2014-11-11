
package com.readersdigest.onepass.rest.resource;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.readersdigest.exacttarget.service.OnePassEtApiService;
import com.readersdigest.exacttarget.service.impl.OnePassEtApiServiceImpl;
import com.readersdigest.onepass.dto.CreateOnePassUserProfileDTO;
import com.readersdigest.onepass.dto.OnePassServiceAdobeEntitledVerifyResponse;
import com.readersdigest.onepass.dto.OnePassServiceAdobeResponse;
import com.readersdigest.onepass.dto.OnePassServiceResponse;
import com.readersdigest.onepass.dto.OnePassTummyServiceResponse;
import com.readersdigest.onepass.dto.OnePassTummyUserProfileDTO;
import com.readersdigest.onepass.dto.UpdateOnePassUserProfileDTO;
import com.readersdigest.onepass.service.OnePassService;
import com.readersdigest.onepass.service.OnePassTummyService;
import com.readersdigest.onepass.service.impl.OnePassAuthServiceImpl;
import com.readersdigest.onepass.service.impl.OnePassETAuthServiceImpl;
import com.readersdigest.onepass.service.impl.OnePassETTummyServiceImpl;
import com.readersdigest.onepass.service.impl.OnePassServiceImpl;
import com.readersdigest.onepass.service.impl.OnePassTummyServiceImpl;
import com.readersdigest.onepass.util.OnePassCDSProductUpdateJob;
import com.readersdigest.onepass.util.StringUtils;
import com.sun.jersey.spi.resource.Singleton;


/**
 * The Class OnePassResource.
 * 
 * @author shsingh
 * 
 *         OnePassResource is the service initiates class that calls the service business logic methods
 */
@Path("/service")
@Singleton
public class OnePassResource {

    /** The one pass service. */
    private OnePassService onePassService;
    
    /** The one pass sweep api service. */
    private OnePassEtApiService onePassEtApiService;
    
    /** The response. */
    @Context
    HttpServletResponse response;

    
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
    @GET
    @Path("SignInWithCredentials")
    @Produces(MediaType.APPLICATION_XML)
    public final OnePassServiceAdobeResponse signInWithCredentials(@QueryParam("emailAddress") String emailAddress, @QueryParam("password") String password,
            @QueryParam("appId") String appId, @QueryParam("appVersion") String appVersion, @QueryParam("uuid") String uuid) {
    	
    	if (StringUtils.isETApisCall()) {
			onePassService = new OnePassETAuthServiceImpl();
		} else {
			onePassService = new OnePassAuthServiceImpl();
		}

    	response.setHeader("Access-Control-Allow-Origin","*");
        return onePassService.signInWithCredentials(emailAddress, password, appId, appVersion, uuid);
    }

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
    @GET
    @Path("renewAuthToken")
    @Produces(MediaType.APPLICATION_XML)
    public final OnePassServiceAdobeResponse renewAuthToken(@QueryParam("authToken") String authToken, @QueryParam("appId") String appId,
            @QueryParam("appVersion") String appVersion) {

        onePassService = new OnePassAuthServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassService.renewAuthToken(authToken, appId, appVersion);

    }
    
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
    @GET
    @Path("RenewAuthToken")
    @Produces(MediaType.APPLICATION_XML)
    public final OnePassServiceAdobeResponse RenewAuthToken(@QueryParam("authToken") String authToken, @QueryParam("appId") String appId,
            @QueryParam("appVersion") String appVersion) {

        onePassService = new OnePassAuthServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassService.renewAuthToken(authToken, appId, appVersion);

    }
    
    
   /**
     * Entitlements.
     *
     * @param authToken the auth token
     * @param appId the app id
     * @param appVersion the app version
     * @return the one pass service adobe response
     */
    @GET
    @Path("entitlements")
    @Produces(MediaType.APPLICATION_XML)
    public final OnePassServiceAdobeResponse entitlements(@QueryParam("authToken") String authToken, @QueryParam("appId") String appId,
            @QueryParam("appVersion") String appVersion) {

        onePassService = new OnePassAuthServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassService.entitlements(authToken, appId, appVersion);

    }
    
    /**
     * Entitlements.
     *
     * @param authToken the auth token
     * @param appId the app id
     * @param appVersion the app version
     * @return the one pass service adobe response
     */
    @GET
    @Path("Entitlements")
    @Produces(MediaType.APPLICATION_XML)
    public final OnePassServiceAdobeResponse Entitlements(@QueryParam("authToken") String authToken, @QueryParam("appId") String appId,
            @QueryParam("appVersion") String appVersion) {

        onePassService = new OnePassAuthServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassService.entitlements(authToken, appId, appVersion);

    }
    
    
    /**
     * Verify entitlement.
     *
     * @param authToken the auth token
     * @param productId the product id
     * @param appId the app id
     * @param appVersion the app version
     * @return the one pass service adobe response
     */
    @GET
    @Path("verifyEntitlement")
    @Produces(MediaType.APPLICATION_XML)
    public final OnePassServiceAdobeEntitledVerifyResponse verifyEntitlement(@QueryParam("authToken") String authToken,
            @QueryParam("productId") String productId,
            @QueryParam("appId") String appId,
            @QueryParam("appVersion") String appVersion) {

        onePassService = new OnePassAuthServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassService.verifyEntitlement(authToken, productId, appId, appVersion);

    }
    
    /**
     * Reset forget password token.
     * 
     * @param emailAddress
     *            the email address
     * @return the one pass service response
     */
    @GET
    @Path("resetForgetPasswordToken")
    @Produces(MediaType.APPLICATION_XML)
    public final OnePassServiceResponse resetForgetPasswordToken(@QueryParam("emailAddress") String emailAddress,
            @QueryParam("sourceId") String sourceId) {
        onePassService = new OnePassAuthServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassService.resetForgetPasswordToken(emailAddress,sourceId);
    }

    /**
     * Update new password.
     * 
     * @param token
     *            the token
     * @param password
     *            the password
     * @return the one pass service response
     */
    @GET
    @Path("updateNewPassword")
    @Produces(MediaType.APPLICATION_XML)
    public final OnePassServiceResponse updateNewPassword(@QueryParam("token") String token, @QueryParam("password") String password,
            @QueryParam("sourceId") String sourceId) {
        onePassService = new OnePassAuthServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassService.updateNewPassword(token, password, sourceId);
    }
    
    /**
     * Update cds user password.
     *
     * @param emailAddress the email address
     * @param password the password
     * @return the one pass service adobe response
     */
    @GET
    @Path("updateCDSUserPassword")
    @Produces(MediaType.APPLICATION_XML)
    public final OnePassServiceAdobeResponse updateCDSUserPassword(@QueryParam("emailAddress") String emailAddress, @QueryParam("password") String password,
            @QueryParam("accountNumber") String accountNumber,@QueryParam("appId")String appId) {
        onePassService = new OnePassAuthServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassService.updateCDSUserPassword(emailAddress, password, accountNumber, appId);
    }
    
    /**
     * Update new password.
     *
     * @param userName the user name
     * @param appId the app id
     * @return the one pass service response
     */
    @GET
    @Path("getUserInfo")
    @Produces(MediaType.APPLICATION_XML)
    public OnePassServiceAdobeResponse getUserInfo(@QueryParam("userName") String userName,
            @QueryParam("appId")String appId) {
        onePassService = new OnePassAuthServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassService.getUserInfo(userName, appId );
    }
    
//    /**
//     * Update new password.
//     *
//     * @param userName the user name
//     * @return the one pass service response
//     */
//    @GET
//    @Path("encryptUserName")
//    @Produces(MediaType.TEXT_PLAIN)
//    public String encryptUserName(@QueryParam("userName") String userName,
//            @QueryParam("appId")String appId) {
//        onePassService = new OnePassServiceImpl();
//        response.setHeader("Access-Control-Allow-Origin","*");
//        return onePassService.encryptUserName(userName, appId);
//    }
    
 
    /**
     * Update valid email address.
     *
     * @param oldEmailAddress the old email address
     * @param newEmailAddress the new email address
     * @param password the password
     * @param appId the app id
     * @return the one pass service response
     */
    @GET
    @Path("updateValidEmailAddress")
    @Produces(MediaType.APPLICATION_XML)
    public OnePassServiceResponse updateValidEmailAddress(@QueryParam("accountNumber") String accountNumber,
            @QueryParam("oldEmailAddress") String oldEmailAddress,
            @QueryParam("newEmailAddress") String newEmailAddress,
            @QueryParam("password") String password,
            @QueryParam("sourceId") String sourceId,
            @QueryParam("appId") String appId) {
        onePassService = new OnePassAuthServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassService.updateValidEmailAddress(accountNumber,oldEmailAddress,newEmailAddress,password,sourceId,appId);
    }
    
    @GET
    @Path("updateCDSEntitlements")
    @Produces(MediaType.TEXT_PLAIN)
    public final String updateCDSEntitlements() {
        OnePassCDSProductUpdateJob cdsUpdateJob = new OnePassCDSProductUpdateJob();
        //response.setHeader("Access-Control-Allow-Origin","*");
        return cdsUpdateJob.updateCDSProducts();
    }
    
    
    /**
     * Creates the user profile info.
     * 
     * @param onePassRequest
     *            the one pass request
     * @return the one pass service response
     */
    @POST
    @Path("createUserProfileInfo")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public final OnePassServiceResponse createUserProfileInfo(final CreateOnePassUserProfileDTO onePassRequest) {

        onePassService = new OnePassServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassService.createUserProfileInfo(onePassRequest);

    }

    /**
     * Update user profile info.
     * 
     * @param onePassRequest
     *            the one pass request
     * @return the one pass service response
     */
    @POST
    @Path("updateUserProfileInfo")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public final OnePassServiceResponse updateUserProfileInfo(final UpdateOnePassUserProfileDTO onePassRequest) {

        onePassService = new OnePassServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassService.updateUserProfileInfo(onePassRequest);

    }

    /**
     * Minimal registration.
     * 
     * @param onePassRequest
     *            the one pass request
     * @return the one pass service response
     */
    @POST
    @Path("minimalRegistration")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public final OnePassServiceResponse minimalRegistration(final CreateOnePassUserProfileDTO onePassRequest) {

        onePassService = new OnePassServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassService.minimalRegistration(onePassRequest);

    }
    
    @GET
    @Path("validCDSEmailAddress")
    @Produces(MediaType.APPLICATION_XML)
    public final OnePassServiceAdobeResponse validCDSEmailAddress(@QueryParam("emailAddress") String emailAddress,
            @QueryParam("appId") String appId) {
        onePassService = new OnePassAuthServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassService.validCDSEmailAddress(emailAddress, appId);
    }
    
    @GET
    @Path("authenticationBHEorder")
    @Produces(MediaType.APPLICATION_XML)
    public final OnePassTummyServiceResponse authenticationBHEorder(@QueryParam("emailAddress") String emailAddress,
            @QueryParam("deviceId") String deviceId,
            @QueryParam("appId") String appId) {
        OnePassTummyService onePassTummyService = new OnePassTummyServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassTummyService.authenticationBHEorder(emailAddress, deviceId, appId);
    }
    
    
    @POST
    @Path("tummyOnePassProfile")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public final OnePassTummyServiceResponse tummyOnePassProfile(final OnePassTummyUserProfileDTO dto) {
    	
    	OnePassTummyService onePassTummyService = null;
    	if (StringUtils.isETApisCall()) {
    		onePassTummyService = new OnePassETTummyServiceImpl();
		} else {
			onePassTummyService = new OnePassTummyServiceImpl();
		}
      
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassTummyService.tummyOnePassProfile(dto);

    }
    
    @GET
    @Path("createOnePassBHEUser")
    @Produces(MediaType.APPLICATION_XML)
    public final OnePassTummyServiceResponse createOnePassBHEUser(@QueryParam("emailAddress") String emailAddress,
    		@QueryParam("appId") String appId) {
    	OnePassTummyService onePassTummyService = null;
    	
    	if (StringUtils.isETApisCall()) {
    		onePassTummyService = new OnePassETTummyServiceImpl();
		} else {
			onePassTummyService = new OnePassTummyServiceImpl();
		}
    	
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassTummyService.createOnePassBHEUser(emailAddress, appId);
    }
    
    /**
     * Update valid email address.
     *
     * @param oldEmailAddress the old email address
     * @param newEmailAddress the new email address
     * @param password the password
     * @param appId the app id
     * @return the one pass service response
     */
    @GET
    @Path("updateEmailAddress")
    @Produces(MediaType.APPLICATION_XML)
    public OnePassTummyServiceResponse updateEmailAddress(@QueryParam("oldEmailAddress") String oldEmailAddress,
            @QueryParam("newEmailAddress") String newEmailAddress,
            @QueryParam("sourceId") String sourceId,
            @QueryParam("appId") String appId) {
        OnePassTummyService onePassTummyService = new OnePassTummyServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassTummyService.updateEmailAddress(oldEmailAddress,newEmailAddress,sourceId,appId);
    }
    
    
    
    
    /**
     * Update valid email address.
     *
     * @param oldEmailAddress the old email address
     * @param newEmailAddress the new email address
     * @param prodId
     * @return the one pass service response
     */
    @GET
    @Path("updateOnePassEmailAddress")
    @Produces(MediaType.APPLICATION_XML)
    public OnePassServiceResponse updateOnePassEmailAddress(@QueryParam("oldEmailAddress") String oldEmailAddress,
            @QueryParam("newEmailAddress") String newEmailAddress,
            @QueryParam("prodId") String prodId) {
    	 onePassService = new OnePassServiceImpl();
         response.setHeader("Access-Control-Allow-Origin","*");
         return onePassService.updateEmailAddress(oldEmailAddress,newEmailAddress,prodId);
    }
    
    
    /**
     * Update valid email address.
     *
     * @param oldEmailAddress the old email address
     * @param newEmailAddress the new email address
     * @return the one pass service response
     */
    @GET
    @Path("updateOnePassAllBrandsEmailAddress")
    @Produces(MediaType.APPLICATION_XML)
    public OnePassServiceResponse updateOnePassAllBrandsEmailAddress(@QueryParam("oldEmailAddress") String oldEmailAddress,
            @QueryParam("newEmailAddress") String newEmailAddress) {
    	onePassService = new OnePassServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassService.updateOnePassAllBrandsEmailAddress(oldEmailAddress,newEmailAddress);
    }
    
    
    /**
	 * Creates the external sweep entry with subscription.
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
	 * @param sepId the sep id
	 * @param sourceName the source name
	 * @param optIn the opt in
	 * @return the string
	 */

	
	@GET
	@Path("createEntryWithSubscription")
	@Produces(MediaType.TEXT_PLAIN)
	public String createEntryWithSubscription(
			@QueryParam("firstName") String firstName,
			@QueryParam("lastName") String lastName,
			@QueryParam("add1") String address1,
			@QueryParam("add2") String address2,
			@QueryParam("city") String city,
			@QueryParam("zip") String zip,
			@QueryParam("state") String state,
			@QueryParam("country") String country,
			@QueryParam("phone") String phone,
			@QueryParam("email") String emailAddress,
			@QueryParam("etEmailKey") String etEmailKey,
			@QueryParam("sourceName") String sourceName, 
			@QueryParam("trkid") String trkid,			
			@QueryParam("optIn") String optIn,
			@QueryParam("etCostumPerameter")String etCostumPerameter,
			@QueryParam("etCostumValue") String etCostumValue
			
			) {

		onePassEtApiService = new OnePassEtApiServiceImpl();
		response.setHeader("Access-Control-Allow-Origin", "*");
		
		return onePassEtApiService.createEntryWithSubscription(
				firstName, lastName, address1, address2, city, zip, state,
				country, phone, emailAddress, sourceName, trkid, etEmailKey, optIn, etCostumPerameter,etCostumValue);

	}

    


}
