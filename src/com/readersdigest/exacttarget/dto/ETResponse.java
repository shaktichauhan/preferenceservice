package com.readersdigest.exacttarget.dto;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;

// TODO: Auto-generated Javadoc
/**
 * The Class ETResponse.
 *
 * @author shsingh DTO ETResponse used to contains the parsed
 *         JSON data in java object
 */

public class ETResponse implements Serializable {

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
    private String birthDate;
    
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
    private String lastUpdateDate;
    
    /** The phone number. */
    @JsonProperty("PhoneNumber")
    private String phoneNumber;
        
    /** The middle name. */
    @JsonProperty("MiddleName")
    private String middleName;
   
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
    
    /** The code. */
    @JsonProperty("Code")
    private String code;
    
    /** The description. */
    @JsonProperty("Description")
    private String description;
        
    /** The last name. */
    @JsonProperty("LastName")
    private String lastName;
    
    /** The subscription preferences. */
    @JsonProperty("SubscriptionPreferences")
    private List<Preferences> subscriptionPreferences;
    
    /** The user roles. */
    @JsonProperty("UserRoles")
    private List<UserRoles> userRoles;
    
    /** The Transaction Date. */
    @JsonProperty("TransactionDate")
    private String transactionDate;
    
    /** The number of recipients. */
    @JsonProperty("NumberOfRecipients")
    private String numberOfRecipients;
    
    /** The order date. */
    @JsonProperty("OrderDate")
    private String orderDate;
    
    /** The order device type. */
    @JsonProperty("OrderDeviceType")
    private String orderDeviceType;
    
    /** The order number. */
    @JsonProperty("OrderNumber")
    private String orderNumber;
    
    /** The payment type. */
    @JsonProperty("PaymentType")
    private String paymentType;
   
    /** The product price. */
    @JsonProperty("ProductPrice")
    private String productPrice;
    
    /** The product id. */
    @JsonProperty("ProductId")
    private String productId;
    
    /** The product shipping. */
    @JsonProperty("ProductShipping")
    private String productShipping;
    
    /** The product tax. */
    @JsonProperty("ProductTax")
    private String productTax;
    
    /** The promotion key. */
    @JsonProperty("PromotionKey")
    private String promotionKey;
    
    /** The quantity. */
    @JsonProperty("Quantity")
    private String quantity;

    /** The role code. */
    @JsonProperty("RoleCode")
    private String roleCode;
    

	/** The ET Brand. */
    @JsonProperty("EtBrand")
    private String etBrand;
    
    /** The is validation enabled. */
    @JsonProperty("IsValidationEnabled")
    private boolean isValidationEnabled;
    
    /** The mailing id. */
    @JsonProperty("MailingId")
    private String mailingId;
    
    /** The parent timer id. */
    @JsonProperty("ParentTimerId")
    private String parentTimerId;
    
    /** The personalization parameters. */
    @JsonProperty("PersonalizationParameters")
    private PersonalizationParameters personalizationParameters;
    
    /**
     * Gets the et brand.
     *
     * @return the et brand
     */
    public String getEtBrand() {
		return etBrand;
	}

	/**
	 * Sets the et brand.
	 *
	 * @param etBrand the new et brand
	 */
	public void setEtBrand(String etBrand) {
		this.etBrand = etBrand;
	}
    
    /**
     * Checks if is validation enabled.
     *
     * @return true, if is validation enabled
     */
    public boolean isValidationEnabled() {
		return isValidationEnabled;
	}

	/**
	 * Sets the validation enabled.
	 *
	 * @param isValidationEnabled the new validation enabled
	 */
	public void setValidationEnabled(boolean isValidationEnabled) {
		this.isValidationEnabled = isValidationEnabled;
	}

	/**
	 * Gets the mailing id.
	 *
	 * @return the mailing id
	 */
	public String getMailingId() {
		return mailingId;
	}

	/**
	 * Sets the mailing id.
	 *
	 * @param mailingId the new mailing id
	 */
	public void setMailingId(String mailingId) {
		this.mailingId = mailingId;
	}

	/**
	 * Gets the parent timer id.
	 *
	 * @return the parent timer id
	 */
	public String getParentTimerId() {
		return parentTimerId;
	}

	/**
	 * Sets the parent timer id.
	 *
	 * @param parentTimerId the new parent timer id
	 */
	public void setParentTimerId(String parentTimerId) {
		this.parentTimerId = parentTimerId;
	}

	/**
	 * Gets the personalization parameters.
	 *
	 * @return the personalization parameters
	 */
	public PersonalizationParameters getPersonalizationParameters() {
		return personalizationParameters;
	}

	/**
	 * Sets the personalization parameters.
	 *
	 * @param personalizationParameters the new personalization parameters
	 */
	public void setPersonalizationParameters(
			PersonalizationParameters personalizationParameters) {
		this.personalizationParameters = personalizationParameters;
	}

	/**
     * Gets the number of recipients.
     *
     * @return the number of recipients
     */
    public String getNumberOfRecipients() {
		return numberOfRecipients;
	}

	/**
	 * Sets the number of recipients.
	 *
	 * @param numberOfRecipients the new number of recipients
	 */
	public void setNumberOfRecipients(String numberOfRecipients) {
		this.numberOfRecipients = numberOfRecipients;
	}

	/**
	 * Gets the order date.
	 *
	 * @return the order date
	 */
	public String getOrderDate() {
		return orderDate;
	}

	/**
	 * Sets the order date.
	 *
	 * @param orderDate the new order date
	 */
	public void setOrderDate(String orderDate) {
		this.orderDate = orderDate;
	}

	/**
	 * Gets the order device type.
	 *
	 * @return the order device type
	 */
	public String getOrderDeviceType() {
		return orderDeviceType;
	}

	/**
	 * Sets the order device type.
	 *
	 * @param orderDeviceType the new order device type
	 */
	public void setOrderDeviceType(String orderDeviceType) {
		this.orderDeviceType = orderDeviceType;
	}

	/**
	 * Gets the order number.
	 *
	 * @return the order number
	 */
	public String getOrderNumber() {
		return orderNumber;
	}

	/**
	 * Sets the order number.
	 *
	 * @param orderNumber the new order number
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}

	/**
	 * Gets the payment type.
	 *
	 * @return the payment type
	 */
	public String getPaymentType() {
		return paymentType;
	}

	/**
	 * Sets the payment type.
	 *
	 * @param paymentType the new payment type
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}

	/**
	 * Gets the product price.
	 *
	 * @return the product price
	 */
	public String getProductPrice() {
		return productPrice;
	}

	/**
	 * Sets the product price.
	 *
	 * @param productPrice the new product price
	 */
	public void setProductPrice(String productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * Gets the product id.
	 *
	 * @return the product id
	 */
	public String getProductId() {
		return productId;
	}

	/**
	 * Sets the product id.
	 *
	 * @param productId the new product id
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * Gets the product shipping.
	 *
	 * @return the product shipping
	 */
	public String getProductShipping() {
		return productShipping;
	}

	/**
	 * Sets the product shipping.
	 *
	 * @param productShipping the new product shipping
	 */
	public void setProductShipping(String productShipping) {
		this.productShipping = productShipping;
	}

	/**
	 * Gets the product tax.
	 *
	 * @return the product tax
	 */
	public String getProductTax() {
		return productTax;
	}

	/**
	 * Sets the product tax.
	 *
	 * @param productTax the new product tax
	 */
	public void setProductTax(String productTax) {
		this.productTax = productTax;
	}

	/**
	 * Gets the promotion key.
	 *
	 * @return the promotion key
	 */
	public String getPromotionKey() {
		return promotionKey;
	}

	/**
	 * Sets the promotion key.
	 *
	 * @param promotionKey the new promotion key
	 */
	public void setPromotionKey(String promotionKey) {
		this.promotionKey = promotionKey;
	}

	/**
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the role code.
	 *
	 * @return the role code
	 */
	public String getRoleCode() {
		return roleCode;
	}

	/**
	 * Sets the role code.
	 *
	 * @param roleCode the new role code
	 */
	public void setRoleCode(String roleCode) {
		this.roleCode = roleCode;
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

	/** The detailed messages. */
	@JsonProperty("DetailedMessages")
    private String[] detailedMessages;
    
    
	/**
	 * Gets the detailed messages.
	 *
	 * @return the detailed messages
	 */
	public String[] getDetailedMessages() {
		return detailedMessages;
	}

	/**
	 * Sets the detailed messages.
	 *
	 * @param detailedMessages the new detailed messages
	 */
	public void setDetailedMessages(String[] detailedMessages) {
		this.detailedMessages = detailedMessages;
	}

	/**
	 * Gets the description.
	 *
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the description.
	 *
	 * @param description the new description
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Gets the code.
	 *
	 * @return the code
	 */
	public String getCode() {
		return code;
	}

	/**
	 * Sets the code.
	 *
	 * @param code the new code
	 */
	public void setCode(String code) {
		this.code = code;
	}

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
		this.birthDate = birthDate;
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
		this.lastUpdateDate = lastUpdateDate;
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
		this.phoneNumber = phoneNumber;
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
	 * Gets the transaction date.
	 *
	 * @return the transaction date
	 */
	public String getTransactionDate() {
		return transactionDate;
	}

	/**
	 * Sets the transaction date.
	 *
	 * @param transactionDate the new transaction date
	 */
	public void setTransactionDate(String transactionDate) {
		this.transactionDate = transactionDate;
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

	
}
