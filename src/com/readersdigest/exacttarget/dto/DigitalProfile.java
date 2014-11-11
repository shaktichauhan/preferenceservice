package com.readersdigest.exacttarget.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.readersdigest.exacttarget.utils.ETVaidationUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class DigitalProfile.
 *
 * @author shsingh DTO DigitalProfile used to contains the parsed
 *         JSON data in java object
 */

public class DigitalProfile implements Serializable {

	 /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The address1. */
    @JsonProperty("AddressLine1")
    private String address1;
    
    /** The address2. */
    @JsonProperty("AddressLine2")
    private String address2;
    
    /** The birth date. */
    @JsonProperty("BirthDate")
    private String birthDate = ETVaidationUtils.convertJsonDate("0");
    
    /** The city. */
    @JsonProperty("City")
    private String city;
   
    /** The country code. */
    @JsonProperty("CountryCode")
    private String countryCode;
   
    /** The email address. */
    @JsonProperty("Email")
    private String emailAddress;
   
    /** The first name. */
    @JsonProperty("FirstName")
    private String firstName;
    
    /** The food interest. */
    @JsonProperty("FoodInterest")
    private String foodInterest;
    
    /** The gender. */
    @JsonProperty("Gender")
    private String gender;
   
    /** The last update date. */
    @JsonProperty("LastUpdateDate")
    private String lastUpdateDate = ETVaidationUtils.convertJsonDate("0");
    
    /** The phone number. */
    @JsonProperty("PhoneNumber")
    private String phoneNumber;
        
    /** The middle name. */
    @JsonProperty("MiddleName")
    private String middleName;
    
    /** The last name. */
    @JsonProperty("LastName")
    private String lastName;
   
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

	/** The phone number type. */
	@JsonProperty("PhoneNumberType")
    private String phoneNumberType;
   
    /** The postal code. */
    @JsonProperty("PostalCode")
    private String postalCode;
   
    /** The source. */
    @JsonProperty("Source")
    private String source;
    
    /** The state province code. */
    @JsonProperty("StateProvinceCode")
    private String stateProvinceCode;
   
    /** The title. */
    @JsonProperty("Title")
    private String title;
   
    /** The tracking id. */
    @JsonProperty("TrackingId")
    private String trackingId;
    
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
	 * Gets the birth date.
	 *
	 * @return the birth date
	 */
	public String getBirthDate() {
		return birthDate;
	}

	
	/**
	 * Sets the birth date.
	 *
	 * @param birthDate the new birth date
	 */
	public void setBirthDate(String birthDate) {
		this.birthDate = ETVaidationUtils.convertJsonDate(birthDate);
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
	 * Gets the country code.
	 *
	 * @return the country code
	 */
	public String getCountryCode() {
		return countryCode;
	}

	/**
	 * Sets the country code.
	 *
	 * @param countryCode the new country code
	 */
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
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
	 * Gets the food interest.
	 *
	 * @return the food interest
	 */
	public String getFoodInterest() {
		return foodInterest;
	}

	/**
	 * Sets the food interest.
	 *
	 * @param foodInterest the new food interest
	 */
	public void setFoodInterest(String foodInterest) {
		this.foodInterest = foodInterest;
	}

	/**
	 * Gets the gender.
	 *
	 * @return the gender
	 */
	public String getGender() {
		return gender;
	}

	/**
	 * Sets the gender.
	 *
	 * @param gender the new gender
	 */
	public void setGender(String gender) {
		this.gender = gender;
	}

	/**
	 * Gets the last update date.
	 *
	 * @return the last update date
	 */
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	/**
	 * Sets the last update date.
	 *
	 * @param lastUpdateDate the new last update date
	 */
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = ETVaidationUtils.convertJsonDate(lastUpdateDate);
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber the new phone number
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = ETVaidationUtils.convertETFormatPhoneNumber(phoneNumber);
	}

	/**
	 * Gets the middle name.
	 *
	 * @return the middle name
	 */
	public String getMiddleName() {
		return middleName;
	}

	/**
	 * Sets the middle name.
	 *
	 * @param middleName the new middle name
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}

	/**
	 * Gets the phone number type.
	 *
	 * @return the phone number type
	 */
	public String getPhoneNumberType() {
		return phoneNumberType;
	}

	/**
	 * Sets the phone number type.
	 *
	 * @param phoneNumberType the new phone number type
	 */
	public void setPhoneNumberType(String phoneNumberType) {
		this.phoneNumberType = phoneNumberType;
	}

	/**
	 * Gets the postal code.
	 *
	 * @return the postal code
	 */
	public String getPostalCode() {
		return postalCode;
	}

	/**
	 * Sets the postal code.
	 *
	 * @param postalCode the new postal code
	 */
	public void setPostalCode(String postalCode) {
		this.postalCode = postalCode;
	}

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
	 * Gets the state province code.
	 *
	 * @return the state province code
	 */
	public String getStateProvinceCode() {
		return stateProvinceCode;
	}

	/**
	 * Sets the state province code.
	 *
	 * @param stateProvinceCode the new state province code
	 */
	public void setStateProvinceCode(String stateProvinceCode) {
		this.stateProvinceCode = stateProvinceCode;
	}

	/**
	 * Gets the title.
	 *
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}

	/**
	 * Sets the title.
	 *
	 * @param title the new title
	 */
	public void setTitle(String title) {
		this.title = title;
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
