package com.readersdigest.exacttarget.client.testclient;

import java.util.ArrayList;
import java.util.List;

import com.readersdigest.exacttarget.client.ETExtensionServices;
import com.readersdigest.exacttarget.client.impl.ETExtensionServicesImpl;
import com.readersdigest.exacttarget.dto.ETResponse;
import com.readersdigest.exacttarget.dto.GetUserRoleRequest;
import com.readersdigest.exacttarget.dto.UserRoles;

public class TestGetUserRole {

	/**
	 * @param args
	 */
	public static void main(String[] args) {

		GetUserRoleRequest userRolesRequest = new GetUserRoleRequest();
		List<String> roleIds = new ArrayList<String>();
		
		userRolesRequest.setEmailAddress("brett_mollen@rd.com");
		userRolesRequest.setRoleIds(roleIds);
		
		ETExtensionServices eTExtensionServices = new ETExtensionServicesImpl();
		ETResponse etResponse = eTExtensionServices.getUserRoles(
				"consumer_marketing", userRolesRequest);

		System.out.println("\n\n **********  etResponse.getCode() : "
				+ etResponse.getCode());
		System.out.println("\n\n **********  etResponse.getEmailAddress() : "
				+ etResponse.getEmailAddress());


		if (etResponse.getUserRoles() != null
				&& etResponse.getUserRoles().size() > 0) {
			UserRoles userRoles = etResponse.getUserRoles().get(0);// use loop
																	// for all
																	// roles

			System.out.println("\n\n **********  etResponse.getCdsServId  : "
					+ userRoles.getCdsServId());
			System.out.println("\n\n **********  etResponse.getRoleId  "
					+ userRoles.getRoleId());
			System.out.println("\n\n **********  etResponse.getRoleStatusCode "
					+ userRoles.getRoleStatusCode());
		}
	}

}
