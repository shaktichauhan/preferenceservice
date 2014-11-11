package com.readersdigest.exacttarget.utils;

/**
 * The Class ETVaidationUtils.
 *
 * @author shsingh 
 *      
 */

public class ETVaidationUtils {
	
	
    public static final String DEV_ETService_AddDigitalOrder_URL="https://test.digital-database-services.rd.com/AddDigitalOrder";
    public static final String DEV_ETService_AddUpdateDigitalProfile_URL="https://test.digital-database-services.rd.com/AddUpdateDigitalProfile";
    public static final String DEV_ETService_AddUpdateDigitalProfileAndSubscriptionPreferences_URL="https://test.digital-database-services.rd.com/AddUpdateDigitalProfileAndSubscriptionPreferences";
	public static final String DEV_ETService_AddUpdateSubscriptionPreferences_URL="https://test.digital-database-services.rd.com/AddUpdateSubscriptionPreferences";
	public static final String DEV_ETService_AddUpdateUserRoles_URL="https://test.digital-database-services.rd.com/AddUpdateUserRoles";
	public static final String DEV_ETService_GetBasicProfileByEmailHash_URL="https://test.digital-database-services.rd.com/GetBasicProfileByEmailHash";
	public static final String DEV_ETService_GetDigitalProfile_URL="https://test.digital-database-services.rd.com/GetDigitalProfile";
	public static final String DEV_ETService_GetMostRecentDigitalOrder_URL="https://test.digital-database-services.rd.com/GetMostRecentDigitalOrder";
	public static final String DEV_ETService_GetSubscriptionPreferences_URL="https://test.digital-database-services.rd.com/GetSubscriptionPreferences";
	public static final String DEV_ETService_GetUserRoles_URL="https://test.digital-database-services.rd.com/GetUserRoles";
	public static final String DEV_ETService_TriggeredEmail_URL="https://test.digital-database-services.rd.com/TriggeredSendMail";
	
	public static final String PROD_ETService_AddDigitalOrder_URL="https://digital-database-services.rd.com/AddDigitalOrder";
	public static final String PROD_ETService_AddUpdateDigitalProfile_URL="https://digital-database-services.rd.com/AddUpdateDigitalProfile";
	public static final String PROD_ETService_AddUpdateDigitalProfileAndSubscriptionPreferences_URL="https://digital-database-services.rd.com/AddUpdateDigitalProfileAndSubscriptionPreferences";
	public static final String PROD_ETService_AddUpdateSubscriptionPreferences_URL="https://digital-database-services.rd.com/AddUpdateSubscriptionPreferences";
	public static final String PROD_ETService_AddUpdateUserRoles_URL="https://digital-database-services.rd.com/AddUpdateUserRoles";
	public static final String PROD_ETService_GetBasicProfileByEmailHash_URL="https://digital-database-services.rd.com/GetBasicProfileByEmailHash";
	public static final String PROD_ETService_GetDigitalProfile_URL="https://digital-database-services.rd.com/GetDigitalProfile";
	public static final String PROD_ETService_GetMostRecentDigitalOrder_URL="https://digital-database-services.rd.com/GetMostRecentDigitalOrder";
	public static final String PROD_ETService_GetSubscriptionPreferences_URL="https://digital-database-services.rd.com/GetSubscriptionPreferences";
	public static final String PROD_ETService_GetUserRoles_URL="https://digital-database-services.rd.com/GetUserRoles";
	public static final String PROD_ETService_TriggeredEmail_URL="https://digital-database-services.rd.com/TriggeredSendMail";

	public static final boolean	isProdEnvironment = false;
	  
	
	public static final String dev_consumer_marketing_authToken="hSvI8z2U50OkyNgDBYD43A";
	public static final String dev_onepass_authToken="NhQi9Ayu-0CH4bXkjyhTXw";
	
	public static final String prod_consumer_marketing_authToken="Q6VZvQpg40maAaWxaNBXgQ";
	public static final String prod_onepass_authToken="PrGeSsYCPkGccIdH51ZL0A";
	
	public static String getAuthToken(String applicationName) {
		if(isProdEnvironment) {
			if("onepass".equalsIgnoreCase(applicationName)) {
				return prod_onepass_authToken;
			} else {
				return prod_consumer_marketing_authToken;
			}
		} else {
			if("onepass".equalsIgnoreCase(applicationName)) {
				return dev_onepass_authToken;
			} else {
				return dev_consumer_marketing_authToken;
			}
		}
		
		
	}
	
	public static String convertJsonDate(String dateTime) {
		StringBuffer jsonDate = new StringBuffer("/Date(");
		if(dateTime == null || "".equals(dateTime.trim())) {
			dateTime = "0";
		}
		jsonDate.append(String.valueOf(dateTime));
		jsonDate.append(")/");
		return jsonDate.toString();
	}
	
	
	/**
	 * Convert et format phone number.
	 *
	 * @param phoneNumber the phone number
	 * @return the string
	 */
	public static String convertETFormatPhoneNumber(String phoneNumber ) {
		try {
			
			if(phoneNumber != null && !"".equals(phoneNumber.trim())) {
				phoneNumber = phoneNumber.subSequence(0, 3)+ "-" + phoneNumber.subSequence(3, 6) + "-" + phoneNumber.subSequence(6, 10);
				
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			
		}
		
		return phoneNumber;
	}
	
    

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		System.out.println(ETVaidationUtils.convertETFormatPhoneNumber("23143234"));

	}

}
