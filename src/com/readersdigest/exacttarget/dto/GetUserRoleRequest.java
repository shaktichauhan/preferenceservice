package com.readersdigest.exacttarget.dto;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class GetSubscriptionPreferencesRequest.
 *
 * @author shsingh DTO GetSubscriptionPreferencesRequest used to contains the parsed
 *         JSON data in java object
 */

public class GetUserRoleRequest implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The email address. */
    @JsonProperty("Email")
    private String emailAddress;
    
    
    /** The RoleIds. */
    @JsonProperty("RoleIds")
    private List<String> roleIds;
    
   
    /**
     * Gets the email address.
     *
     * @return the email address
     */
    public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Sets the email address.
	 *
	 * @param emailAddress the new email address
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	public List<String> getRoleIds() {
		return roleIds;
	}

	public void setRoleIds(List<String> roleIds) {
		this.roleIds = roleIds;
	}

	
}
