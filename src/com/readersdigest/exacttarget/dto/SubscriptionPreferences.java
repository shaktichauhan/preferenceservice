package com.readersdigest.exacttarget.dto;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class SubscriptionPreferences.
 *
 * @author shsingh DTO SubscriptionPreferences used to contains the parsed
 *         JSON data in java object
 */

public class SubscriptionPreferences implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The email address. */
    @JsonProperty("Email")
    private String emailAddress;
    
    /** The subscription preferences. */
    @JsonProperty("SubscriptionPreferences")
    private List<Preferences> subscriptionPreferences;
    
   
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
	 * Gets the subscription preferences.
	 *
	 * @return the subscription preferences
	 */
	public List<Preferences> getSubscriptionPreferences() {
		return subscriptionPreferences;
	}

	/**
	 * Sets the subscription preferences.
	 *
	 * @param subscriptionPreferences the new subscription preferences
	 */
	public void setSubscriptionPreferences(List<Preferences> subscriptionPreferences) {
		this.subscriptionPreferences = subscriptionPreferences;
	}

}
