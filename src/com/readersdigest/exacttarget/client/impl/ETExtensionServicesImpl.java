package com.readersdigest.exacttarget.client.impl;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.httpclient.protocol.Protocol;
import org.apache.commons.httpclient.protocol.ProtocolSocketFactory;
import org.codehaus.jackson.map.ObjectMapper;

import com.readersdigest.exacttarget.EasySSLProtocolSocketFactory;
import com.readersdigest.exacttarget.client.ETExtensionServices;
import com.readersdigest.exacttarget.dto.DigitalOrderWithSubscriptionProfile;
import com.readersdigest.exacttarget.dto.DigitalProfile;
import com.readersdigest.exacttarget.dto.DigitalProfileWithSubscription;
import com.readersdigest.exacttarget.dto.ETResponse;
import com.readersdigest.exacttarget.dto.ETUserRoleResponse;
import com.readersdigest.exacttarget.dto.GetSubscriptionPreferencesRequest;
import com.readersdigest.exacttarget.dto.GetUserRoleRequest;
import com.readersdigest.exacttarget.dto.SubscriptionPreferences;
import com.readersdigest.exacttarget.dto.TriggeredSendMail;
import com.readersdigest.exacttarget.dto.UserRole;
import com.readersdigest.exacttarget.utils.ETVaidationUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class ETExtensionServicesImpl.
 */
public class ETExtensionServicesImpl implements ETExtensionServices {

	/** The et response. */
	private ETResponse etResponse;

	/* (non-Javadoc)
	 * @see com.readersdigest.exacttarget.client.ETExtensionServices#addDigitalOrderWithSubProfile(java.lang.String, com.readersdigest.exacttarget.dto.DigitalOrderWithSubscriptionProfile)
	 */
	public ETResponse addDigitalOrderWithSubProfile(
			String applicationName,
			DigitalOrderWithSubscriptionProfile digitalOrderWithSubscriptionProfile) {
		etResponse = new ETResponse();

		try {
			ObjectMapper mapper = new ObjectMapper();

			// serialize userList to JSON format and write to file
			String jsonString = mapper
					.writeValueAsString(digitalOrderWithSubscriptionProfile);

			String authToken = ETVaidationUtils.getAuthToken(applicationName);
			String url = "";
		    
			if(ETVaidationUtils.isProdEnvironment) {
		    	url=ETVaidationUtils.PROD_ETService_AddDigitalOrder_URL;
		    } else {
		    	url=ETVaidationUtils.DEV_ETService_AddDigitalOrder_URL;
		    }
			
			System.out.println("JSON string: " + jsonString);

			//String url = "https://test.digital-database-services.rd.com/AddDigitalOrder";

			etResponse = callETExtenstionService(etResponse, url,  authToken ,jsonString);
				
		} catch (Exception e) {
			e.printStackTrace();
		}

		return etResponse;
	}

	/* (non-Javadoc)
	 * @see com.readersdigest.exacttarget.client.ETExtensionServices#addUpdateDigitalProfile(java.lang.String, com.readersdigest.exacttarget.dto.DigitalProfile)
	 */
	public ETResponse addUpdateDigitalProfile(String applicationName,
			DigitalProfile digitalProfile) {
		etResponse = new ETResponse();
		
		try {
			ObjectMapper mapper = new ObjectMapper();

			// serialize userList to JSON format and write to file
			String jsonString = mapper
					.writeValueAsString(digitalProfile);
	
			System.out.println("JSON string: " + jsonString);
			
			String authToken = ETVaidationUtils.getAuthToken(applicationName);
			
			String url = "";
		    
			if(ETVaidationUtils.isProdEnvironment) {
		    	url=ETVaidationUtils.PROD_ETService_AddUpdateDigitalProfile_URL;
		    } else {
		    	url=ETVaidationUtils.DEV_ETService_AddUpdateDigitalProfile_URL;
		    }

			
			//String url = "https://test.digital-database-services.rd.com/AddUpdateDigitalProfile";
			
			etResponse = callETExtenstionService(etResponse, url,  authToken ,jsonString);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return etResponse;
	}

	/* (non-Javadoc)
	 * @see com.readersdigest.exacttarget.client.ETExtensionServices#addUpdateDigitalProfileWithSubscriptions(java.lang.String, com.readersdigest.exacttarget.dto.DigitalProfileWithSubscription)
	 */
	public ETResponse addUpdateDigitalProfileWithSubscriptions(
			String applicationName,
			DigitalProfileWithSubscription digitalProfileWithSubscription) {
		etResponse = new ETResponse();
		
		try {
			ObjectMapper mapper = new ObjectMapper();

			// serialize userList to JSON format and write to file
			String jsonString = mapper
					.writeValueAsString(digitalProfileWithSubscription);
			
			String authToken = ETVaidationUtils.getAuthToken(applicationName);
			String url = "";
		    
			if(ETVaidationUtils.isProdEnvironment) {
		    	url=ETVaidationUtils.PROD_ETService_AddUpdateDigitalProfileAndSubscriptionPreferences_URL;
		    } else {
		    	url=ETVaidationUtils.DEV_ETService_AddUpdateDigitalProfileAndSubscriptionPreferences_URL;
		    }
	
			System.out.println("JSON string: " + jsonString);
			
				//String url = "https://test.digital-database-services.rd.com/AddUpdateDigitalProfileAndSubscriptionPreferences";
			
			etResponse = callETExtenstionService(etResponse, url,  authToken ,jsonString);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return etResponse;
	}

	/* (non-Javadoc)
	 * @see com.readersdigest.exacttarget.client.ETExtensionServices#addUpdateSubscriptionPreferences(java.lang.String, com.readersdigest.exacttarget.dto.SubscriptionPreferences)
	 */
	public ETResponse addUpdateSubscriptionPreferences(String applicationName,
			SubscriptionPreferences subscriptionPreferences) {
		etResponse = new ETResponse();
		
		try {
			ObjectMapper mapper = new ObjectMapper();

			// serialize userList to JSON format and write to file
			String jsonString = mapper
					.writeValueAsString(subscriptionPreferences);
			
			String authToken = ETVaidationUtils.getAuthToken(applicationName);
			String url = "";
		    
			if(ETVaidationUtils.isProdEnvironment) {
		    	url=ETVaidationUtils.PROD_ETService_AddUpdateSubscriptionPreferences_URL;
		    } else {
		    	url=ETVaidationUtils.DEV_ETService_AddUpdateSubscriptionPreferences_URL;
		    }
			
	
			System.out.println("JSON string: " + jsonString);
			
			
			//String url = "https://test.digital-database-services.rd.com/AddUpdateSubscriptionPreferences";
			
			etResponse = callETExtenstionService(etResponse, url, authToken ,jsonString);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return etResponse;
	}
	
	
	
	/* (non-Javadoc)
	 * @see com.readersdigest.exacttarget.client.ETExtensionServices#addUpdateUserRoles(java.lang.String, com.readersdigest.exacttarget.dto.UserRole)
	 */
	public ETResponse addUpdateUserRoles(String applicationName, UserRole userRole) {
		etResponse = new ETResponse();
		
		try {
			ObjectMapper mapper = new ObjectMapper();

			// serialize userList to JSON format and write to file
			String jsonString = mapper
					.writeValueAsString(userRole);
	
			System.out.println("JSON string: " + jsonString);
			
			String authToken = ETVaidationUtils.getAuthToken(applicationName);
			String url = "";
		    
			if(ETVaidationUtils.isProdEnvironment) {
		    	url=ETVaidationUtils.PROD_ETService_AddUpdateUserRoles_URL;
		    } else {
		    	url=ETVaidationUtils.DEV_ETService_AddUpdateUserRoles_URL;
		    }
			
			//String url = "https://test.digital-database-services.rd.com/AddUpdateUserRoles";
			
			etResponse = callETExtenstionService(etResponse, url, authToken ,jsonString);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return etResponse;
		
	}
	
	
	/* (non-Javadoc)
	 * @see com.readersdigest.exacttarget.client.ETExtensionServices#getDigitalProfile(java.lang.String, java.lang.String)
	 */
	public ETResponse getDigitalProfile(String applicationName, String emailAddress) {
		etResponse = new ETResponse();
		
		try {
			
			StringBuffer jsonString = new StringBuffer("{ \"Email\" : \"");
			jsonString.append(emailAddress);
			jsonString.append("\" }");
			// serialize userList to JSON format and write to file
			
			String authToken = ETVaidationUtils.getAuthToken(applicationName);
			String url = "";
		    
			if(ETVaidationUtils.isProdEnvironment) {
		    	url=ETVaidationUtils.PROD_ETService_GetDigitalProfile_URL;
		    } else {
		    	url=ETVaidationUtils.DEV_ETService_GetDigitalProfile_URL;
		    }
			
			System.out.println("JSON string: " + jsonString.toString());
			
			//String url = "https://test.digital-database-services.rd.com/GetDigitalProfile";
			
			etResponse = callETExtenstionService(etResponse, url, authToken ,jsonString.toString());
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return etResponse;
		
	}
	
	/* (non-Javadoc)
	 * @see com.readersdigest.exacttarget.client.ETExtensionServices#getBasicProfileByEmailHash(java.lang.String, java.lang.String)
	 */
	public ETResponse getBasicProfileByEmailHash(String applicationName, String hashedEmail) {
		etResponse = new ETResponse();
		
		try {
			
			StringBuffer jsonString = new StringBuffer("{ \"HashedEmail\" : \"");
			jsonString.append(hashedEmail);
			jsonString.append("\" }");
			// serialize userList to JSON format and write to file
			
			System.out.println("JSON string: " + jsonString.toString());
			
			String authToken = ETVaidationUtils.getAuthToken(applicationName);
			String url = "";
		    
			if(ETVaidationUtils.isProdEnvironment) {
		    	url=ETVaidationUtils.PROD_ETService_GetBasicProfileByEmailHash_URL;
		    } else {
		    	url=ETVaidationUtils.DEV_ETService_GetBasicProfileByEmailHash_URL;
		    }
			
			//String url = "https://test.digital-database-services.rd.com/GetBasicProfileByEmailHash";
			
			etResponse = callETExtenstionService(etResponse, url, authToken ,jsonString.toString());
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return etResponse;
	}
	
	/* (non-Javadoc)
	 * @see com.readersdigest.exacttarget.client.ETExtensionServices#getSubscriptionPreferences(java.lang.String, com.readersdigest.exacttarget.dto.GetSubscriptionPreferencesRequest)
	 */
	public ETResponse getSubscriptionPreferences(String applicationName, GetSubscriptionPreferencesRequest subscriptionPreferences) {
		etResponse = new ETResponse();
		
		try {
			ObjectMapper mapper = new ObjectMapper();

			// serialize userList to JSON format and write to file
			String jsonString = mapper
					.writeValueAsString(subscriptionPreferences);
	
			System.out.println("JSON string: " + jsonString);
			
			String authToken = ETVaidationUtils.getAuthToken(applicationName);
			String url = "";
		    
			if(ETVaidationUtils.isProdEnvironment) {
		    	url=ETVaidationUtils.PROD_ETService_GetSubscriptionPreferences_URL;
		    } else {
		    	url=ETVaidationUtils.DEV_ETService_GetSubscriptionPreferences_URL;
		    }
			
			//String url = "https://test.digital-database-services.rd.com/AddUpdateUserRoles";
			
			etResponse = callETExtenstionService(etResponse, url, authToken ,jsonString);
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return etResponse;
	}
	
	
	/* (non-Javadoc)
	 * @see com.readersdigest.exacttarget.client.ETExtensionServices#getUserRoles(java.lang.String, com.readersdigest.exacttarget.dto.GetUserRoleRequest)
	 */
	public ETResponse getUserRoles(String applicationName, GetUserRoleRequest userRoleRequest) {
		etResponse = new ETResponse();
		
		try {
			
			ObjectMapper mapper = new ObjectMapper();

			// serialize userList to JSON format and write to file
			String jsonString = mapper
					.writeValueAsString(userRoleRequest);
			// serialize userList to JSON format and write to file
			
			System.out.println("JSON string: " + jsonString.toString());
			
			String authToken = ETVaidationUtils.getAuthToken(applicationName);
			String url = "";
		    
			if(ETVaidationUtils.isProdEnvironment) {
		    	url=ETVaidationUtils.PROD_ETService_GetUserRoles_URL;
		    } else {
		    	url=ETVaidationUtils.DEV_ETService_GetUserRoles_URL;
		    }
			
			//String url = "https://test.digital-database-services.rd.com/GetUserRoles";
			
			etResponse = callETExtenstionService(etResponse, url, authToken, jsonString.toString());
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return etResponse;
	}
	
	
	/* (non-Javadoc)
	 * @see com.readersdigest.exacttarget.client.ETExtensionServices#getMostRecentDigitalOrder(java.lang.String, java.lang.String)
	 */
	public ETResponse getMostRecentDigitalOrder(String applicationName, String emailAddress) {
		etResponse = new ETResponse();
		
		try {
			
			StringBuffer jsonString = new StringBuffer("{ \"Email\" : \"");
			jsonString.append(emailAddress);
			jsonString.append("\" }");
			// serialize userList to JSON format and write to file
			
			String authToken = ETVaidationUtils.getAuthToken(applicationName);
			String url = "";
		    
			if(ETVaidationUtils.isProdEnvironment) {
		    	url=ETVaidationUtils.PROD_ETService_GetMostRecentDigitalOrder_URL;
		    } else {
		    	url=ETVaidationUtils.DEV_ETService_GetMostRecentDigitalOrder_URL;
		    }
			
			System.out.println("JSON string: " + jsonString.toString());
			
			//String url = "https://test.digital-database-services.rd.com/GetDigitalProfile";
			
			etResponse = callETExtenstionService(etResponse, url, authToken ,jsonString.toString());
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return etResponse;
	}
	
	
	/* (non-Javadoc)
	 * @see com.readersdigest.exacttarget.client.ETExtensionServices#sendTriggeredMail(java.lang.String, com.readersdigest.exacttarget.dto.TriggeredSendMail)
	 */
	public ETResponse sendTriggeredMail(String applicationName, TriggeredSendMail triggeredEmail) {
		etResponse = new ETResponse();
		
		try {
			
			ObjectMapper mapper = new ObjectMapper();

			// serialize userList to JSON format and write to file
			String jsonString = mapper
					.writeValueAsString(triggeredEmail);
			// serialize userList to JSON format and write to file
			
			System.out.println("JSON string: " + jsonString.toString());
			
			String authToken = ETVaidationUtils.getAuthToken(applicationName);
			String url = "";
		    
			if(ETVaidationUtils.isProdEnvironment) {
		    	url=ETVaidationUtils.PROD_ETService_TriggeredEmail_URL;
		    } else {
		    	url=ETVaidationUtils.DEV_ETService_TriggeredEmail_URL;
		    }
			
			//String url = "https://test.digital-database-services.rd.com/GetUserRoles";
			
			etResponse = callETExtenstionService(etResponse, url, authToken, jsonString.toString());
				
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return etResponse;
	}

	/**
	 * Call et extenstion service.
	 *
	 * @param etResponse the et response
	 * @param serviceURL the service url
	 * @param authToken the auth token
	 * @param jsonString the json string
	 * @return the ET response
	 */
	private ETResponse callETExtenstionService(ETResponse etResponse,
			String serviceURL, String authToken, String jsonString) {
		
		try {

			ObjectMapper mapper = new ObjectMapper();

			PostMethod postMethod;

			//use for skipping the untrusted certificate
			if(!ETVaidationUtils.isProdEnvironment) {
				Protocol easyhttps = new Protocol("https",
						(ProtocolSocketFactory) new EasySSLProtocolSocketFactory(),
						443);
				Protocol.registerProtocol("https", easyhttps);
			}

			HttpClient httpClient = new HttpClient();

			postMethod = new PostMethod(serviceURL);
			postMethod.addRequestHeader("Authorization", authToken);
			RequestEntity requestEntity = new StringRequestEntity(jsonString,
					"application/json", "UTF-8");

			postMethod.setRequestEntity(requestEntity);

			int executeResult = httpClient.executeMethod(postMethod);

			System.out.println("JSON executeResult: " + executeResult);
			InputStream stream = postMethod.getResponseBodyAsStream();
			etResponse = mapper.readValue(stream, ETResponse.class);
			System.out.println("JSON etResponse: " + etResponse.getCode());


			
				
			
			/*try { BufferedReader r1 = new BufferedReader( new
			  InputStreamReader( stream ) ); String line = r1.readLine();
			  System.out.println("\n\n *********line " + line); while( line !=
			 null ) {
			  
			 line = r1.readLine(); System.out.println("\n\n *********line " +
			  line); }
			  
			  } catch( Exception e ) { e.printStackTrace(); }*/
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return etResponse;
	}
	
	
	/*private ETUserRoleResponse callETExtenstionService(ETUserRoleResponse etResponse,
			String serviceURL, String authToken, String jsonString) {
		
		try {

			ObjectMapper mapper = new ObjectMapper();

			PostMethod postMethod;

			if(!ETVaidationUtils.isProdEnvironment) {
				Protocol easyhttps = new Protocol("https",
						(ProtocolSocketFactory) new EasySSLProtocolSocketFactory(),
						443);
				Protocol.registerProtocol("https", easyhttps);
			}
			

			HttpClient httpClient = new HttpClient();

			postMethod = new PostMethod(serviceURL);
			postMethod.addRequestHeader("Authorization", authToken);
			RequestEntity requestEntity = new StringRequestEntity(jsonString,
					"application/json", "UTF-8");

			postMethod.setRequestEntity(requestEntity);

			int executeResult = httpClient.executeMethod(postMethod);

			System.out.println("JSON executeResult: " + executeResult);
			InputStream stream = postMethod.getResponseBodyAsStream();
			//etResponse = mapper.readValue(stream, ETUserRoleResponse.class);
			//System.out.println("JSON etResponse: " + etResponse.getCode());
			
				
			
			 try { BufferedReader r1 = new BufferedReader( new
			  InputStreamReader( stream ) ); String line = r1.readLine();
			  System.out.println("\n\n *********line " + line); while( line !=
			 null ) {
			  
			 line = r1.readLine(); System.out.println("\n\n *********line " +
			  line); }
			  
			  } catch( Exception e ) { e.printStackTrace(); }
			 

		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return etResponse;
	}*/

}
