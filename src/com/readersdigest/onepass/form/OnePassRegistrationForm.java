package com.readersdigest.onepass.form;

import java.io.Serializable;

import org.apache.struts.validator.ValidatorForm;

// TODO: Auto-generated Javadoc
/**
 *The Class OnePassRegistrationForm.
 *
 *@author shsingh
 */
public class OnePassRegistrationForm extends ValidatorForm implements Serializable {

    /**The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /**The source id. */
    private String sourceId = "";

    /**The tracking id. */
    private String trackingId = "";

    /**The first name. */
    private String firstName = "";

    /**The last name. */
    private String lastName = "";
    
    /**The customer Name. */
    private String customerName = "";

    /**The street1. */
    private String street1 = "";

    /**The street2. */
    private String street2 = "";

    /**The city. */
    private String city = "";

    /**The postal code. */
    private String postalCode = "";

    /**The country. */
    private String country = null;

    /**The state. */
    private String state = null;

    /**The email address. */
    private String emailAddress = null;

    /**The new email address. */
    private String newEmailAddress = null;

    /**The confirm email address. */
    private String confirmEmailAddress = null;

    /**The password. */
    private String password = null;

    /**The confirm password. */
    private String confirmPassword = null;

    /**The token. */
    private String token = null;
    
    /**The accountNumber. */
    public String accountNumber = null;
    
    /** The app id. */
    public String appId = null;

    
    /**The promotable. */
    private String[] promotable = null;
    
    
    /**The promotable_unchecked. */
    private String promotable_unchecked = null;

    
	/**
     *Gets the source id.
     *
     *@return the source id
     */
    public final String getSourceId() {
        return sourceId;
    }

    /**
     *Sets the source id.
     *
     *@param sourceId
     *           the new source id
     */
    public final void setSourceId(final String sourceId) {
        this.sourceId = sourceId;
    }

    /**
     *Gets the tracking id.
     *
     *@return the tracking id
     */
    public final String getTrackingId() {
        return trackingId;
    }

    /**
     *Sets the tracking id.
     *
     *@param trackingId
     *           the new tracking id
     */
    public final void setTrackingId(final String trackingId) {
        this.trackingId = trackingId;
    }

    /**
     *Gets the first name.
     *
     *@return the first name
     */
    public final String getFirstName() {
        return firstName;
    }

    /**
     *Sets the first name.
     *
     *@param firstName
     *           the new first name
     */
    public final void setFirstName(final String firstName) {
        this.firstName = firstName;
    }

    /**
     *Gets the last name.
     *
     *@return the last name
     */
    public final String getLastName() {
        return lastName;
    }

    /**
     *Sets the last name.
     *
     *@param lastName
     *           the new last name
     */
    public final void setLastName(final String lastName) {
        this.lastName = lastName;
    }

    /**
     *Gets the street1.
     *
     *@return the street1
     */
    public final String getStreet1() {
        return street1;
    }

    /**
     *Sets the street1.
     *
     *@param street1
     *           the new street1
     */
    public final void setStreet1(final String street1) {
        this.street1 = street1;
    }

    /**
     *Gets the street2.
     *
     *@return the street2
     */
    public final String getStreet2() {
        return street2;
    }

    /**
     *Sets the street2.
     *
     *@param street2
     *           the new street2
     */
    public final void setStreet2(final String street2) {
        this.street2 = street2;
    }

    /**
     *Gets the city.
     *
     *@return the city
     */
    public final String getCity() {
        return city;
    }

    /**
     *Sets the city.
     *
     *@param city
     *           the new city
     */
    public final void setCity(final String city) {
        this.city = city;
    }

    /**
     *Gets the postal code.
     *
     *@return the postal code
     */
    public final String getPostalCode() {
        return postalCode;
    }

    /**
     *Sets the postal code.
     *
     *@param postalCode
     *           the new postal code
     */
    public final void setPostalCode(final String postalCode) {
        this.postalCode = postalCode;
    }

    /**
     *Gets the country.
     *
     *@return the country
     */
    public final String getCountry() {
        return country;
    }

    /**
     *Sets the country.
     *
     *@param country
     *           the new country
     */
    public final void setCountry(final String country) {
        this.country = country;
    }

    /**
     *Gets the state.
     *
     *@return the state
     */
    public final String getState() {
        return state;
    }

    /**
     *Sets the state.
     *
     *@param state
     *           the new state
     */
    public final void setState(final String state) {
        this.state = state;
    }

    /**
     *Gets the email address.
     *
     *@return the email address
     */
    public final String getEmailAddress() {
        return emailAddress;
    }

    /**
     *Sets the email address.
     *
     *@param emailAddress
     *           the new email address
     */
    public final void setEmailAddress(final String emailAddress) {
        this.emailAddress = emailAddress;
    }

    /**
     *Gets the new email address.
     *
     *@return the new email address
     */
    public final String getNewEmailAddress() {
        return newEmailAddress;
    }

    /**
     *Sets the new email address.
     *
     *@param newEmailAddress
     *           the new new email address
     */
    public final void setNewEmailAddress(final String newEmailAddress) {
        this.newEmailAddress = newEmailAddress;
    }

    /**
     *Gets the confirm email address.
     *
     *@return the confirm email address
     */
    public final String getConfirmEmailAddress() {
        return confirmEmailAddress;
    }

    /**
     *Sets the confirm email address.
     *
     *@param confirmEmailAddress
     *           the new confirm email address
     */
    public final void setConfirmEmailAddress(final String confirmEmailAddress) {
        this.confirmEmailAddress = confirmEmailAddress;
    }

    /**
     *Gets the password.
     *
     *@return the password
     */
    public final String getPassword() {
        return password;
    }

    /**
     *Sets the password.
     *
     *@param password
     *           the new password
     */
    public final void setPassword(final String password) {
        this.password = password;
    }

    /**
     *Gets the confirm password.
     *
     *@return the confirm password
     */
    public final String getConfirmPassword() {
        return confirmPassword;
    }

    /**
     *Sets the confirm password.
     *
     *@param confirmPassword
     *           the new confirm password
     */
    public final void setConfirmPassword(final String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }

    /**
     *Gets the promotable.
     *
     *@return the promotable
     */
    public final String[] getPromotable() {
        return promotable;
    }

    /**
     *Gets the token.
     *
     *@return the token
     */
    public final String getToken() {
        return token;
    }

    /**
     *Sets the token.
     *
     *@param token
     *           the new token
     */
    public final void setToken(final String token) {
        this.token = token;
    }

    /**
     *Sets the promotable.
     *
     *@param promotable
     *           the new promotable
     */
    public final void setPromotable(final String[] promotable) {
        this.promotable = promotable;
    }
    
    /**
     * Gets the account number.
     *
     * @return the account number
     */
    public final String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number.
     *
     * @param accountNumber the new account number
     */
    public final void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    /**
     * Gets the customer name.
     *
     * @return the customer name
     */
    public String getCustomerName() {
        return customerName;
    }

    /**
     * Sets the customer name.
     *
     * @param customerName the new customer name
     */
    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    /**
     * Gets the app id.
     *
     * @return the app id
     */
    public String getAppId() {
        return appId;
    }

    /**
     * Sets the app id.
     *
     * @param appId the new app id
     */
    public void setAppId(String appId) {
        this.appId = appId;
    }

    
    /**
     * Gets the promotable_unchecked.
     *
     * @return the promotable_unchecked
     */
    public String getPromotable_unchecked() {
		return promotable_unchecked;
	}

	/**
	 * Sets the promotable_unchecked.
	 *
	 * @param promotable_unchecked the new promotable_unchecked
	 */
	public void setPromotable_unchecked(String promotable_unchecked) {
		this.promotable_unchecked = promotable_unchecked;
	}


}
