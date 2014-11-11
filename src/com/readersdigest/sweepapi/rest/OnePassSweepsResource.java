
package com.readersdigest.sweepapi.rest;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import com.readersdigest.sweepapi.dto.OnePassSweepEntryResponse;
import com.readersdigest.sweepapi.dto.SweepEntryDTO;
import com.readersdigest.sweepapi.service.OnePassSweepApiService;
import com.readersdigest.sweepapi.service.impl.OnePassSweepApiServiceImpl;
import com.sun.jersey.spi.resource.Singleton;



@Path("/onePassSweepService")
@Singleton
public class OnePassSweepsResource {


    private OnePassSweepApiService onePassSweepApiService;
    
    /** The response. */
    @Context
    HttpServletResponse response;


    @POST
    @Path("createSweepEntry")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public final OnePassSweepEntryResponse createSweepEntry(SweepEntryDTO entry) {

    	onePassSweepApiService = new OnePassSweepApiServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassSweepApiService.createSweepEntry(entry);

    }
    
    @POST
    @Path("createSweepEntryWithSubscription")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public final OnePassSweepEntryResponse createSweepEntryWithSubscription(SweepEntryDTO entry) {

    	onePassSweepApiService = new OnePassSweepApiServiceImpl();
        response.setHeader("Access-Control-Allow-Origin","*");
        return onePassSweepApiService.createSweepEntryWithSubscription(entry);

    }
   

   
}
