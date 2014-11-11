package com.readersdigest.exacttarget.client.testclient;

import java.util.ArrayList;
import java.util.List;

import com.readersdigest.exacttarget.client.ETExtensionServices;
import com.readersdigest.exacttarget.client.impl.ETExtensionServicesImpl;
import com.readersdigest.exacttarget.dto.ETResponse;
import com.readersdigest.exacttarget.dto.Preferences;
import com.readersdigest.exacttarget.dto.UserRole;
import com.readersdigest.exacttarget.dto.UserRoles;

public class TestAddUpdateUserRole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
       
		// UserRole POJO
		UserRole userRole = new UserRole();
		userRole.setEmailAddress("brett_mollen@rd.com");
		userRole.setSource("TOH from Website");
		userRole.setTrackingId("ide2");
		
        // you need to use loop for multiple User Roles to add in list
		List<UserRoles> userRolesList = new ArrayList<UserRoles>();
		UserRoles role1 = new UserRoles();
		role1.setCdsServId("1111122");
		role1.setLastUpdateDate("601406505000");//please use timemiles in long and pass as a String
		role1.setRoleExpireDate("601406505000");//please use timemiles in long and pass as a String
		role1.setRoleId("15");
		role1.setRoleStatusCode("Subscribing Donor");
		userRolesList.add(role1);
		UserRoles role2 = new UserRoles();
		role2.setCdsServId("1114122");
		role2.setLastUpdateDate("601406505000");//please use timemiles in long and pass as a String
		role2.setRoleExpireDate("601406505000");//please use timemiles in long and pass as a String
		role2.setRoleId("20");
		role2.setRoleStatusCode("Subscribing Donor");
		userRolesList.add(role2);
		
		userRole.setUserRoles(userRolesList);

		ETExtensionServices eTExtensionServices = new ETExtensionServicesImpl();
		ETResponse etResponse = eTExtensionServices.addUpdateUserRoles("consumer_marketing", userRole);
		
		System.out.println("\n\n **********  etResponse.getCode() : " + etResponse.getCode());
		System.out.println("\n\n **********  etResponse.getDescription() : " + etResponse.getDescription());
		if(etResponse.getDetailedMessages() != null) {
			for(int i=0; i<etResponse.getDetailedMessages().length; i++) {
				System.out.println("\n\n **********  etResponse.getDetailedMessage " + i +": " + etResponse.getDetailedMessages()[i]);
			}
		}
		
		
	}

}
