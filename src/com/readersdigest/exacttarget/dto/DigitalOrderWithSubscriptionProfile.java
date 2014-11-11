package com.readersdigest.exacttarget.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class DigitalOrderWithSubscriptionProfile.
 *
 * @author shsingh DTO DigitalOrderWithSubscriptionProfile used to contains the parsed
 *         JSON data in java object
 */

public class DigitalOrderWithSubscriptionProfile implements Serializable {

	 /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**
     * Gets the digital order.
     *
     * @return the digital order
     */
    public DigitalOrder getDigitalOrder() {
		return digitalOrder;
	}

	/**
	 * Sets the digital order.
	 *
	 * @param digitalOrder the new digital order
	 */
	public void setDigitalOrder(DigitalOrder digitalOrder) {
		this.digitalOrder = digitalOrder;
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

	/** The digital order. */
	@JsonProperty("DigitalOrder")
    private DigitalOrder digitalOrder;

    /** The subscription preferences. */
    @JsonProperty("SubscriptionPreferences")
    private SubscriptionPreferences subscriptionPreferences;
    
    /** The digital profile. */
    @JsonProperty("DigitalProfile")
    private DigitalProfile digitalProfile;
    
     
}
