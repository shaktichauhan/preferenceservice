package com.readersdigest.exacttarget.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class DigitalProfileWithSubscription.
 *
 * @author shsingh DTO DigitalProfileWithSubscription used to contains the parsed
 *         JSON data in java object
 */

public class DigitalProfileWithSubscription implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The digital profile. */
    @JsonProperty("DigitalProfile")
    private DigitalProfile digitalProfile;
    
    /** The subscription preferences. */
    @JsonProperty("SubscriptionPreferences")
    private SubscriptionPreferences subscriptionPreferences;
    
    
	/**
	 * Gets the digital profile.
	 *
	 * @return the digital profile
	 */
	public DigitalProfile getDigitalProfile() {
		return digitalProfile;
	}

	/**
	 * Sets the digital profile.
	 *
	 * @param digitalProfile the new digital profile
	 */
	public void setDigitalProfile(DigitalProfile digitalProfile) {
		this.digitalProfile = digitalProfile;
	}

	/**
	 * Gets the subscription preferences.
	 *
	 * @return the subscription preferences
	 */
	public SubscriptionPreferences getSubscriptionPreferences() {
		return subscriptionPreferences;
	}

	/**
	 * Sets the subscription preferences.
	 *
	 * @param subscriptionPreferences the new subscription preferences
	 */
	public void setSubscriptionPreferences(
			SubscriptionPreferences subscriptionPreferences) {
		this.subscriptionPreferences = subscriptionPreferences;
	}

	
}
