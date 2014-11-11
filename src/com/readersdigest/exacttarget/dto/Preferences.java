package com.readersdigest.exacttarget.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.readersdigest.exacttarget.utils.ETVaidationUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class Preferences.
 *
 * @author shsingh DTO Preferences used to contains the parsed
 *         JSON data in java object
 */

public class Preferences implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The last activity date. */
    @JsonProperty("LastActivityDate")
    private String lastActivityDate = ETVaidationUtils.convertJsonDate("0");;
   
    /** The last promotion key. */
    @JsonProperty("LastPromotionKey")
    private String lastPromotionKey;
    
    /** The last source. */
    @JsonProperty("LastSource")
    private String lastSource;
    
    /** The last tracking id. */
    @JsonProperty("LastTrackingId")
    private String lastTrackingId;
   
    /** The opted in. */
    @JsonProperty("OptedIn")
    private boolean optedIn;
    
    /**
     * Gets the last activity date.
     *
     * @return the last activity date
     */
    public String getLastActivityDate() {
		return lastActivityDate;
	}

	/**
	 * Sets the last activity date.
	 *
	 * @param lastActivityDate the new last activity date
	 */
	public void setLastActivityDate(String lastActivityDate) {
		this.lastActivityDate = ETVaidationUtils.convertJsonDate(lastActivityDate);
	}

	/**
	 * Gets the last promotion key.
	 *
	 * @return the last promotion key
	 */
	public String getLastPromotionKey() {
		return lastPromotionKey;
	}

	/**
	 * Sets the last promotion key.
	 *
	 * @param lastPromotionKey the new last promotion key
	 */
	public void setLastPromotionKey(String lastPromotionKey) {
		this.lastPromotionKey = lastPromotionKey;
	}

	/**
	 * Gets the last source.
	 *
	 * @return the last source
	 */
	public String getLastSource() {
		return lastSource;
	}

	/**
	 * Sets the last source.
	 *
	 * @param lastSource the new last source
	 */
	public void setLastSource(String lastSource) {
		this.lastSource = lastSource;
	}

	/**
	 * Gets the last tracking id.
	 *
	 * @return the last tracking id
	 */
	public String getLastTrackingId() {
		return lastTrackingId;
	}

	/**
	 * Sets the last tracking id.
	 *
	 * @param lastTrackingId the new last tracking id
	 */
	public void setLastTrackingId(String lastTrackingId) {
		this.lastTrackingId = lastTrackingId;
	}

	/**
	 * Checks if is opted in.
	 *
	 * @return true, if is opted in
	 */
	public boolean isOptedIn() {
		return optedIn;
	}

	/**
	 * Sets the opted in.
	 *
	 * @param optedIn the new opted in
	 */
	public void setOptedIn(boolean optedIn) {
		this.optedIn = optedIn;
	}

	/**
	 * Gets the subscription id.
	 *
	 * @return the subscription id
	 */
	public String getSubscriptionId() {
		return subscriptionId;
	}

	/**
	 * Sets the subscription id.
	 *
	 * @param subscriptionId the new subscription id
	 */
	public void setSubscriptionId(String subscriptionId) {
		this.subscriptionId = subscriptionId;
	}

	/** The subscription id. */
	@JsonProperty("SubscriptionId")
    private String subscriptionId;
        
   

}
