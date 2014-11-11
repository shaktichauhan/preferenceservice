package com.readersdigest.exacttarget.dto;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class UserRole.
 *
 * @author shsingh DTO UserRole used to contains the parsed
 *         JSON data in java object
 */

public class UserRole implements Serializable {

	 /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The email address. */
    @JsonProperty("Email")
    private String emailAddress;
   
    /** The tracking id. */
    @JsonProperty("TrackingId")
    private String trackingId;
    
    /** The source. */
    @JsonProperty("Source")
    private String source;
    
    /** The user roles. */
    @JsonProperty("UserRoles")
    private List<UserRoles> userRoles;
    
	/**
	 * Gets the source.
	 *
	 * @return the source
	 */
	public String getSource() {
		return source;
	}

	/**
	 * Sets the source.
	 *
	 * @param source the new source
	 */
	public void setSource(String source) {
		this.source = source;
	}

	/**
	 * Gets the user roles.
	 *
	 * @return the user roles
	 */
	public List<UserRoles> getUserRoles() {
		return userRoles;
	}

	/**
	 * Sets the user roles.
	 *
	 * @param userRoles the new user roles
	 */
	public void setUserRoles(List<UserRoles> userRoles) {
		this.userRoles = userRoles;
	}

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

	/**
	 * Gets the tracking id.
	 *
	 * @return the tracking id
	 */
	public String getTrackingId() {
		return trackingId;
	}

	/**
	 * Sets the tracking id.
	 *
	 * @param trackingId the new tracking id
	 */
	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}
	
}
