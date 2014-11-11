package com.readersdigest.exacttarget.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.readersdigest.exacttarget.utils.ETVaidationUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class DigitalOrder.
 *
 * @author shsingh DTO DigitalOrder used to contains the parsed
 *         JSON data in java object
 */

public class DigitalOrder implements Serializable {

	 /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The email address. */
    @JsonProperty("Email")
    private String emailAddress;
   
    /** The product id. */
    @JsonProperty("ProductId")
    private String productId;
    
    /** The order date. */
    @JsonProperty("OrderDate")
    private String	orderDate = ETVaidationUtils.convertJsonDate("0");;
    
    /** The promotion key. */
    @JsonProperty("PromotionKey")
    private String promotionKey;
   
    /** The order device type. */
    @JsonProperty("OrderDeviceType")
    private String orderDeviceType;
    
    /** The quantity. */
    @JsonProperty("Quantity")
    private int quantity;
        
    /** The product price. */
    @JsonProperty("ProductPrice")
    private double productPrice;
   
    /** The product shipping. */
    @JsonProperty("ProductShipping")
    private double productShipping;
   
    /** The product tax. */
    @JsonProperty("ProductTax")
    private double productTax;
   
    /** The payment type. */
    @JsonProperty("PaymentType")
    private String paymentType;
    
    /** The number of recipients. */
    @JsonProperty("NumberOfRecipients")
    private int numberOfRecipients;
   
    /** The role code. */
    @JsonProperty("RoleCode")
    private String roleCode;
   
    /** The order number. */
    @JsonProperty("OrderNumber")
    private String orderNumber;
    
    /** The source. */
    @JsonProperty("Source")
    private String source;
    
    /** The tracking id. */
    @JsonProperty("TrackingId")
    private String trackingId;

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
		this.orderDate = ETVaidationUtils.convertJsonDate(orderDate);
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
	 * Gets the quantity.
	 *
	 * @return the quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	/**
	 * Gets the product price.
	 *
	 * @return the product price
	 */
	public double getProductPrice() {
		return productPrice;
	}

	/**
	 * Sets the product price.
	 *
	 * @param productPrice the new product price
	 */
	public void setProductPrice(double productPrice) {
		this.productPrice = productPrice;
	}

	/**
	 * Gets the product shipping.
	 *
	 * @return the product shipping
	 */
	public double getProductShipping() {
		return productShipping;
	}

	/**
	 * Sets the product shipping.
	 *
	 * @param productShipping the new product shipping
	 */
	public void setProductShipping(double productShipping) {
		this.productShipping = productShipping;
	}

	/**
	 * Gets the product tax.
	 *
	 * @return the product tax
	 */
	public double getProductTax() {
		return productTax;
	}

	/**
	 * Sets the product tax.
	 *
	 * @param productTax the new product tax
	 */
	public void setProductTax(double productTax) {
		this.productTax = productTax;
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
	 * Gets the number of recipients.
	 *
	 * @return the number of recipients
	 */
	public int getNumberOfRecipients() {
		return numberOfRecipients;
	}

	/**
	 * Sets the number of recipients.
	 *
	 * @param numberOfRecipients the new number of recipients
	 */
	public void setNumberOfRecipients(int numberOfRecipients) {
		this.numberOfRecipients = numberOfRecipients;
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
