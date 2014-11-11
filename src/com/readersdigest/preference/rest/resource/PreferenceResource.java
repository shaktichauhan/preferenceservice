package com.readersdigest.preference.rest.resource;

import javax.servlet.http.HttpServletResponse;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;

import org.codehaus.jettison.json.JSONException;
import org.codehaus.jettison.json.JSONObject;

import com.readersdigest.preference.dto.CreatePreferenceRequestDTO;
import com.readersdigest.preference.dto.CreatePreferenceResponseDTO;
import com.readersdigest.preference.service.PreferenceService;
import com.readersdigest.preference.service.impl.PreferenceServiceImpl;
import com.sun.jersey.spi.resource.Singleton;

/**
 * @author shsingh
 *
 */

@Path("/")
@Singleton
public class PreferenceResource {

	//@Context
	//SecurityContext securityCtx;
	
	@Context
	HttpServletResponse response;

	PreferenceService preferencService;

	@POST
	@Path("createPreferenceEpid")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public CreatePreferenceResponseDTO createPreferenceEpid(
			CreatePreferenceRequestDTO preference) {

		preferencService = new PreferenceServiceImpl();
		return preferencService.createPreferenceEpid(preference);

	}

	@POST
	@Path("insertOptPreference")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public CreatePreferenceResponseDTO insertOptPreference(
			CreatePreferenceRequestDTO preference) {

		preferencService = new PreferenceServiceImpl();
		return preferencService.insertOptPreference(preference);

	}

	@POST
	@Path("fetchPreferencebyEmail")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	
	public CreatePreferenceResponseDTO fetchPreferencebyEmail(
			CreatePreferenceRequestDTO preference) {

		preferencService = new PreferenceServiceImpl();
		return preferencService.fetchPreferencebyEmail(preference);

	}

	@POST
	@Path("fetchPreferencebyEpid")
	@Consumes(MediaType.APPLICATION_XML)
	@Produces(MediaType.APPLICATION_XML)
	public CreatePreferenceResponseDTO fetchPreferencebyEpid(
			CreatePreferenceRequestDTO preference) {

		preferencService = new PreferenceServiceImpl();
		return preferencService.fetchPreferencebyEpid(preference);

	}
	
	
	@GET
	@Path("insertSweeps")
	@Produces(MediaType.TEXT_PLAIN)
	public String insertSweeps(@QueryParam("sepId")
	String sepId, @QueryParam("slpId")
	String slpId, @QueryParam("firstName")
	String firstName, @QueryParam("lastName")
	String lastName, @QueryParam("address1")
	String address1, @QueryParam("address2")
	String address2, @QueryParam("city")
	String city, @QueryParam("state")
	String state, @QueryParam("postalCode")
	String postalCode, @QueryParam("country")
	String country, @QueryParam("phone")
	String phone, @QueryParam("email")
	String email) {

		preferencService = new PreferenceServiceImpl();
		
		return String.valueOf(preferencService.insertSweeps(sepId, slpId, firstName, lastName,
				address1, address2, city, state, postalCode, country, phone,
				email));
		
		
		
	}
	
		
	@GET
	@Path("getEpid")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getEpid(@QueryParam("emailAddress")
	String emailAddress) {

		preferencService = new PreferenceServiceImpl();
		
		String epid = preferencService.getEpid(emailAddress);
	    response.setHeader("Access-Control-Allow-Origin","*");
	    response.addHeader("P3P","CP=\"IDC DSP COR ADM DEVi TAIi PSA PSD IVAi IVDi CONi HIS OUR IND CNT\"");
		JSONObject obj = new JSONObject();
		
		try {
			obj.putOpt("EPID", epid);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	
	}
	
	@GET
	@Path("getSmartMarketingByEmail")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getSmartMarketingByEmail(@QueryParam("emailAddress")
	String emailAddress) {

		preferencService = new PreferenceServiceImpl();
		
		String smartMktProps = preferencService.getSmartMarketingByEmail(emailAddress);
		
		JSONObject obj = new JSONObject();
		response.setHeader("Access-Control-Allow-Origin","*");
		response.addHeader("P3P","CP=\"IDC DSP COR ADM DEVi TAIi PSA PSD IVAi IVDi CONi HIS OUR IND CNT\"");
		
		try {
			obj.put("SMARTMARKETINGPROPS", smartMktProps);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
		
	}
	
	@GET
	@Path("getSmartMarketingByEpid")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getSmartMarketingByEpid(@QueryParam("epid")
	String epid) {

		preferencService = new PreferenceServiceImpl();
		
		String smartMktProps = preferencService.getSmartMarketingByEpid(epid);
		
		JSONObject obj = new JSONObject();
		response.setHeader("Access-Control-Allow-Origin","*");
		response.addHeader("P3P","CP=\"IDC DSP COR ADM DEVi TAIi PSA PSD IVAi IVDi CONi HIS OUR IND CNT\"");
		
		try {
			obj.put("SMARTMARKETINGPROPS", smartMktProps);
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
		
	}


	@GET
	@Path("getEpidByLegacyEpid")
	@Produces(MediaType.APPLICATION_JSON)
	public JSONObject getEpidByLegacyEpid(@QueryParam("epid")
	String epid) {

		preferencService = new PreferenceServiceImpl();
		
		JSONObject obj = new JSONObject();
		response.setHeader("Access-Control-Allow-Origin","*");
		response.addHeader("P3P","CP=\"IDC DSP COR ADM DEVi TAIi PSA PSD IVAi IVDi CONi HIS OUR IND CNT\"");
		
		try {
			obj.put("EPID", preferencService.getEpidByLegacyEpid(epid));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return obj;
		
	}
	
	
	

}
