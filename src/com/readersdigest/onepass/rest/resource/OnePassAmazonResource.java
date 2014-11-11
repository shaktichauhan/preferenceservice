
package com.readersdigest.onepass.rest.resource;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.readersdigest.onepass.dto.OnePassServiceAmazonResponse;
import com.readersdigest.onepass.dto.OnePassServiceRequest;
import com.readersdigest.onepass.service.OnePassAmazonService;
import com.readersdigest.onepass.service.impl.OnePassAmazonServiceImpl;
import com.sun.jersey.spi.resource.Singleton;


// TODO: Auto-generated Javadoc
/**
 * The Class OnePassAmazonResource.
 * 
 * @author shsingh
 * 
 *         OnePassAmazonResource is the service initiates class that calls the service business logic methods
 */
@Path("/onePassService")
@Singleton
public class OnePassAmazonResource {

    /** The one pass amazon service. */
    private OnePassAmazonService onePassAmazonService;
    
    /** The response. */
    @Context
    HttpServletResponse response;

    
    /**
     * One pass validation.
     *
     * @param onePassRequest the one pass request
     * @return the one pass service amazon response
     */
    @POST
    @Path("validation")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public final OnePassServiceAmazonResponse onePassValidation(OnePassServiceRequest onePassRequest) {

    	onePassAmazonService = new OnePassAmazonServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassAmazonService.onePassValidation(onePassRequest);

    }
    
    
    /**
     * One pass registration.
     *
     * @param onePassRequest the one pass request
     * @return the one pass service amazon response
     */
    @POST
    @Path("registration")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public final OnePassServiceAmazonResponse onePassRegistration(OnePassServiceRequest onePassRequest) {

    	onePassAmazonService = new OnePassAmazonServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassAmazonService.onePassRegistration(onePassRequest);

    }

    /**   
     * 
     * One pass subscription status.
     *
     * @param onePassRequest the one pass request
     * @return the one pass service amazon response
     */
    @POST
    @Path("subscriptionStatus")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public final OnePassServiceAmazonResponse onePassSubscriptionStatus(OnePassServiceRequest onePassRequest) {

    	onePassAmazonService = new OnePassAmazonServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassAmazonService.onePassSubscriptionStatus(onePassRequest);

    }
    
    
    /**
     * One pass subscription status.
     *
     * @param onePassRequest the one pass request
     * @return the one pass service amazon response
     */
    @POST
    @Path("getEntitlements")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public final OnePassServiceAmazonResponse onePassEntitlements(OnePassServiceRequest onePassRequest) {

    	onePassAmazonService = new OnePassAmazonServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassAmazonService.onePassEntitlements(onePassRequest);

    }
    
  
    
    /**
     * One pass forgot password.
     *
     * @param onePassRequest the one pass request
     * @return the one pass service amazon response
     */
    @POST
    @Path("forgotPassword")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public final OnePassServiceAmazonResponse onePassForgotPassword(OnePassServiceRequest onePassRequest) {

    	onePassAmazonService = new OnePassAmazonServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassAmazonService.onePassForgotPassword(onePassRequest);

    }

	/**
     * One pass signInWithCredentials.
     *
     * @param onePassRequest the one pass request
     * @return the one pass service amazon response
     */
	@POST
    @Path("signInWithCredentials")
    @Consumes(MediaType.APPLICATION_XML)
    @Produces(MediaType.APPLICATION_XML)
    public final OnePassServiceAmazonResponse onePassSignInWithCredentials(OnePassServiceRequest onePassRequest) {

    	onePassAmazonService = new OnePassAmazonServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassAmazonService.onePassSignInWithCredentials(onePassRequest);

    }

   
}
