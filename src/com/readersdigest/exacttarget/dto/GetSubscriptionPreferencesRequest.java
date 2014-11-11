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

public class GetSubscriptionPreferencesRequest implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The email address. */
    @JsonProperty("Email")
    private String emailAddress;
    
    
    /** The email address. */
    @JsonProperty("Brand")
    private String brand;
    
    /** The email address. */
    @JsonProperty("BrandFamily")
    private String brandFamily;
    
    /** The email address. */
    @JsonProperty("BusinessUnit")
    private String businessUnit;
    
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

	/**
	 * Gets the brand.
	 *
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Sets the brand.
	 *
	 * @param brand the new brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Gets the brand family.
	 *
	 * @return the brand family
	 */
	public String getBrandFamily() {
		return brandFamily;
	}

	/**
	 * Sets the brand family.
	 *
	 * @param brandFamily the new brand family
	 */
	public void setBrandFamily(String brandFamily) {
		this.brandFamily = brandFamily;
	}

	/**
	 * Gets the business unit.
	 *
	 * @return the business unit
	 */
	public String getBusinessUnit() {
		return businessUnit;
	}

	/**
	 * Sets the business unit.
	 *
	 * @param businessUnit the new business unit
	 */
	public void setBusinessUnit(String businessUnit) {
		this.businessUnit = businessUnit;
	}

}
