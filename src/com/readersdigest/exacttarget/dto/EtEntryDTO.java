package com.readersdigest.exacttarget.dto;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

import com.readersdigest.exacttarget.dto.Preferences;


// TODO: Auto-generated Javadoc
/**
 * The Class SweepEntryDTO.
 *
 * @author shsingh DTO SweepEntryDTO used to contains the parsed
 *         JSON data in java object
 */

public class EtEntryDTO implements Serializable {

	 /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;


    
    

    /** The first name. */
    @JsonProperty("FirstName")
    private String firstName;
    
  
    /** The last name. */
    @JsonProperty("LastName")
    private String lastName;
    

    /** The email address. */
    @JsonProperty("EmailAddress")
    private String emailAddress;
   

  
    /** The tracking id. */
    @JsonProperty("TrackingId")
    private String trackingId;
  

    /** The address1. */
    @JsonProperty("Address1")
    private String address1;

    
    

    /** The address2. */
    @JsonProperty("Address2")
    private String address2;

    

    /** The state. */
    @JsonProperty("State")
    private String state;

    

    /** The zip. */
    @JsonProperty("Zip")
    private String zip;

    
    /** The city. */
    @JsonProperty("City")
    private String city;
    
    /** The country. */
    @JsonProperty("Country")
    private String country;
    
    /** The phone. */
    @JsonProperty("Phone")
    private String phone;
        
    /** The subscription preferences. */
    @JsonProperty("SubscriptionPreferences")
    private List<Preferences> subscriptionPreferences;
    
    /** The Source Name. */
    @JsonProperty("SourceName")
    private String sourceName;


	/**
	 * Gets the address1.
	 *
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}

	/**
	 * Sets the address1.
	 *
	 * @param address1 the new address1
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	/**
	 * Gets the address2.
	 *
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}

	/**
	 * Sets the address2.
	 *
	 * @param address2 the new address2
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	/**
	 * Gets the state.
	 *
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * Sets the state.
	 *
	 * @param state the new state
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * Gets the zip.
	 *
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * Sets the zip.
	 *
	 * @param zip the new zip
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * Gets the city.
	 *
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * Sets the city.
	 *
	 * @param city the new city
	 */
	public void setCity(String city) {
		this.city = city;
	}


	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	/**
	 * Gets the country.
	 *
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}

	/**
	 * Sets the country.
	 *
	 * @param country the new country
	 */
	public void setCountry(String country) {
		this.country = country;
	}

	/**
	 * Gets the phone.
	 *
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * Sets the phone.
	 *
	 * @param phone the new phone
	 */
	public void setPhone(String phone) {
		this.phone = phone;
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
	 * Gets the source name.
	 *
	 * @return the source name
	 */
	public String getSourceName() {
		return sourceName;
	}

	/**
	 * Sets the source name.
	 *
	 * @param sourceName the new source name
	 */
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}
    
   
	
}
