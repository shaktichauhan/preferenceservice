package com.cds.global.api;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Element;

public class OrderItem {
	protected String orderNumber = "";
	protected String orderTypeCode = null;
	protected String orderTypeCodeDescription = null;
	protected String productNumber = null;
	protected String offerCode = null;
	
	protected String productSize = null;
	protected String productStyle = null;
	protected String productColor = null;
	protected String productDesc = null;
	protected String orderStatus = null;
	protected String orderStatusDescription = null;
	protected String quantity = null;
	protected String subscriptionTerm = null;
	protected String vendorOrderNumber = null;
	
	protected String value = null;
	protected String trackingNumber = null;
	protected String giftMessage = null;
	protected String previewItem = null;
	protected String previewAmt = null;
	protected String previewDays = null;
	protected String sequenceNumber = null;
	protected String customerGetsRefund = null;
	
	protected String deferredIncome = null;
	protected String earnedIncome = null;
	
	protected Customer recipient = new Customer();
	protected HashMap<String, String> attributes = new HashMap<String, String>();
	/**
	 * Populate and XML Element from this OrderItem object.
	 * 
	 * @param orderItemElement
	 * @return String
	 */
	public String toXml(Element orderItemElement) {
		if (getOrderNumber() != null && !"".equals(getOrderNumber().trim())) {
			orderItemElement.addElement("orderNumber").addText(getOrderNumber());
		}
		if (getOrderTypeCode() != null && !"".equals(getOrderTypeCode().trim())) {
			orderItemElement.addElement("orderTypeCode").addText(getOrderTypeCode());
		}
		if (getOrderTypeCodeDescription() != null && !"".equals(getOrderTypeCodeDescription().trim())) {
			orderItemElement.addElement("orderTypeCodeDescription").addText(getOrderTypeCodeDescription());
		}
		if (getProductNumber() != null && !"".equals(getProductNumber().trim())) {
			orderItemElement.addElement("productNumber").addText(getProductNumber());
		}
		if (getOfferCode() != null && !"".equals(getOfferCode().trim())) {
			orderItemElement.addElement("offerCode").addText(getOfferCode());
		}
		if (getProductSize() != null && !"".equals(getProductSize().trim())) {
			orderItemElement.addElement("productSize").addText(getProductSize());
		}
		if (getProductStyle() != null && !"".equals(getProductStyle().trim())) {
			orderItemElement.addElement("productStyle").addText(getProductStyle());
		}
		if (getProductColor() != null && !"".equals(getProductColor())) {
			orderItemElement.addElement("productColor").addText(getProductColor());
		}
		if (getProductDesc() != null && !"".equals(getProductDesc())) {
			orderItemElement.addElement("productDesc").addText(getProductDesc());
		}
		if (getOrderStatus() != null && !"".equals(getOrderStatus())) {
			orderItemElement.addElement("orderStatus").addText(getOrderStatus());
		}
		if (getOrderStatusDescription() != null && !"".equals(getOrderStatusDescription())) {
			orderItemElement.addElement("orderStatusDescription").addText(getOrderStatusDescription());
		}
		if (getQuantity() != null && !"".equals(getQuantity())) {
			orderItemElement.addElement("quantity").addText(getQuantity());
		}
		if (getSubscriptionTerm() != null && !"".equals(getSubscriptionTerm())) {
			orderItemElement.addElement("subscriptionTerm").addText(getSubscriptionTerm());
		}
		if (getValue() != null && !"".equals(getValue())) {
			orderItemElement.addElement("value").addText(getValue());
		}
		if (getTrackingNumber() != null && !"".equals(getTrackingNumber())) {
			orderItemElement.addElement("trackingNumber").addText(getTrackingNumber());
		}
		if (getGiftMessage() != null && !"".equals(getGiftMessage())) {
			orderItemElement.addElement("giftMessage").addText(getGiftMessage());
		}
		if (getPreviewItem() != null && !"".equals(getPreviewItem())) {
			orderItemElement.addElement("previewItem").addText(getPreviewItem());
		}
		if (getPreviewAmt() != null && !"".equals(getPreviewAmt())) {
			orderItemElement.addElement("previewAmt").addText(getPreviewAmt());
		}
		if (getPreviewDays() != null && !"".equals(getPreviewDays())) {
			orderItemElement.addElement("previewDays").addText(getPreviewDays());
		}
		if (getSequenceNumber() != null && !"".equals(getSequenceNumber())) {
			orderItemElement.addElement("sequenceNumber").addText(getSequenceNumber());
		}
		if (getCustomerGetsRefund() != null && !"".equals(getCustomerGetsRefund())) {
			orderItemElement.addElement("customerGetsRefund").addText(getCustomerGetsRefund());
		}
		if (getDeferredIncome() != null && !"".equals(getDeferredIncome())) {
			orderItemElement.addElement("deferredIncome").addText(getDeferredIncome());
		}
		if (getEarnedIncome() != null && !"".equals(getEarnedIncome())) {
			orderItemElement.addElement("earnedIncome").addText(getEarnedIncome());
		}
		if (getVendorOrderNumber() != null && !"".equals(getVendorOrderNumber())) {
			orderItemElement.addElement("vendorOrderNumber").addText(getVendorOrderNumber());
		}
		//
		if (getRecipient() != null) {
			Element recipientElement = orderItemElement.addElement("recipient");
			getRecipient().createXml(recipientElement);
		}
		//
		if (getAttributes() != null && getAttributes().size() > 0) {
			Element attributesElement = orderItemElement.addElement("attributes");
			String key = null;
			String value = null;
			for(Iterator<String> it = getAttributes().keySet().iterator(); it.hasNext(); ) {
				key = it.next();
				value = getAttributes().get(key);
				attributesElement.addElement(key).addText(value);
			}
		}
		//
		return orderItemElement.asXML();
	}
	/**
	 * Populate this OrderItem object with values from an XML Element.
	 * 
	 * @param orderItemElement
	 */
	@SuppressWarnings("unchecked")
	public void populateFromXmlNode(Element orderItemElement) {
		setOrderNumber(orderItemElement.elementText("orderNumber"));
		setOrderTypeCode(orderItemElement.elementText("orderTypeCode"));
		setOrderTypeCodeDescription(orderItemElement.elementText("orderTypeCodeDescription"));
		setProductNumber(orderItemElement.elementText("productNumber"));
		setOfferCode(orderItemElement.elementText("offerCode"));
		setProductSize(orderItemElement.elementText("productSize"));
		setProductStyle(orderItemElement.elementText("productStyle"));
		setProductColor(orderItemElement.elementText("productColor"));
		setProductDesc(orderItemElement.elementText("productDesc"));
		setOrderStatus(orderItemElement.elementText("orderStatus"));
		setOrderStatusDescription(orderItemElement.elementText("orderStatusDescription"));
		setQuantity(orderItemElement.elementText("quantity"));
		setSubscriptionTerm(orderItemElement.elementText("subscriptionTerm"));
		setValue(orderItemElement.elementText("value"));
		setTrackingNumber(orderItemElement.elementText("trackingNumber"));
		setGiftMessage(orderItemElement.elementText("giftMessage"));
		setPreviewItem(orderItemElement.elementText("previewItem"));
		setPreviewAmt(orderItemElement.elementText("previewAmt"));
		setPreviewDays(orderItemElement.elementText("previewDays"));
		setSequenceNumber(orderItemElement.elementText("sequenceNumber"));
		setCustomerGetsRefund(orderItemElement.elementText("customerGetsRefund"));
		setDeferredIncome(orderItemElement.elementText("deferredIncome"));
		setEarnedIncome(orderItemElement.elementText("earnedIncome"));
		//
        List<Element> recipientNodes = orderItemElement.selectNodes("recipient");
        if (recipientNodes != null && recipientNodes.size() > 0) {
        	getRecipient().populateFromXmlNode(recipientNodes);
        }
        //
        Element attributeElement = orderItemElement.element("attributes");
        if (attributeElement != null) {
        	loadAttributes(attributeElement);
        }
	}
	
	@SuppressWarnings("unchecked")
	private void loadAttributes(Element attributeElement) {
		List<Element> attributeElements = attributeElement.elements();
		Element attElement = null;
		for(Iterator<Element> it = attributeElements.iterator(); it.hasNext(); ) {
			attElement = (Element)it.next();
			getAttributes().put(attElement.getName(), attElement.getText());
		}
		
	}
	
	/**
	 * @return the orderNumber
	 */
	public String getOrderNumber() {
		return orderNumber;
	}
	/**
	 * @param orderNumber the orderNumber to set
	 */
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	/**
	 * @return the orderTypeCode
	 */
	public String getOrderTypeCode() {
		return orderTypeCode;
	}
	/**
	 * @param orderTypeCode the orderTypeCode to set
	 */
	public void setOrderTypeCode(String orderTypeCode) {
		this.orderTypeCode = orderTypeCode;
	}
	/**
	 * @return the orderTypeCodeDescription
	 */
	public String getOrderTypeCodeDescription() {
		return orderTypeCodeDescription;
	}
	/**
	 * @param orderTypeCodeDescription the orderTypeCodeDescription to set
	 */
	public void setOrderTypeCodeDescription(String orderTypeCodeDescription) {
		this.orderTypeCodeDescription = orderTypeCodeDescription;
	}
	/**
	 * @return the productNumber
	 */
	public String getProductNumber() {
		return productNumber;
	}
	/**
	 * @param productNumber the productNumber to set
	 */
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
	/**
	 * @return the offerCode
	 */
	public String getOfferCode() {
		return offerCode;
	}
	/**
	 * @param offerCode the offerCode to set
	 */
	public void setOfferCode(String offerCode) {
		this.offerCode = offerCode;
	}
	/**
	 * @return the productSize
	 */
	public String getProductSize() {
		return productSize;
	}
	/**
	 * @param productSize the productSize to set
	 */
	public void setProductSize(String productSize) {
		this.productSize = productSize;
	}
	/**
	 * @return the productStyle
	 */
	public String getProductStyle() {
		return productStyle;
	}
	/**
	 * @param productStyle the productStyle to set
	 */
	public void setProductStyle(String productStyle) {
		this.productStyle = productStyle;
	}
	/**
	 * @return the productColor
	 */
	public String getProductColor() {
		return productColor;
	}
	/**
	 * @param productColor the productColor to set
	 */
	public void setProductColor(String productColor) {
		this.productColor = productColor;
	}
	/**
	 * @return the productDesc
	 */
	public String getProductDesc() {
		return productDesc;
	}
	/**
	 * @param productDesc the productDesc to set
	 */
	public void setProductDesc(String productDesc) {
		this.productDesc = productDesc;
	}
	/**
	 * @return the orderStatus
	 */
	public String getOrderStatus() {
		return orderStatus;
	}
	/**
	 * @param orderStatus the orderStatus to set
	 */
	public void setOrderStatus(String orderStatus) {
		this.orderStatus = orderStatus;
	}
	/**
	 * @return the orderStatusDescription
	 */
	public String getOrderStatusDescription() {
		return orderStatusDescription;
	}
	/**
	 * @param orderStatusDescription the orderStatusDescription to set
	 */
	public void setOrderStatusDescription(String orderStatusDescription) {
		this.orderStatusDescription = orderStatusDescription;
	}
	/**
	 * @return the quantity
	 */
	public String getQuantity() {
		return quantity;
	}
	/**
	 * @param quantity the quantity to set
	 */
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
	/**
	 * @return the subscriptionTerm
	 */
	public String getSubscriptionTerm() {
		return subscriptionTerm;
	}
	/**
	 * @param subscriptionTerm the subscriptionTerm to set
	 */
	public void setSubscriptionTerm(String subscriptionTerm) {
		this.subscriptionTerm = subscriptionTerm;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the trackingNumber
	 */
	public String getTrackingNumber() {
		return trackingNumber;
	}
	/**
	 * @param trackingNumber the trackingNumber to set
	 */
	public void setTrackingNumber(String trackingNumber) {
		this.trackingNumber = trackingNumber;
	}
	/**
	 * @return the giftMessage
	 */
	public String getGiftMessage() {
		return giftMessage;
	}
	/**
	 * @param giftMessage the giftMessage to set
	 */
	public void setGiftMessage(String giftMessage) {
		this.giftMessage = giftMessage;
	}
	/**
	 * @return the previewItem
	 */
	public String getPreviewItem() {
		return previewItem;
	}
	/**
	 * @param previewItem the previewItem to set
	 */
	public void setPreviewItem(String previewItem) {
		this.previewItem = previewItem;
	}
	/**
	 * @return the previewAmt
	 */
	public String getPreviewAmt() {
		return previewAmt;
	}
	/**
	 * @param previewAmt the previewAmt to set
	 */
	public void setPreviewAmt(String previewAmt) {
		this.previewAmt = previewAmt;
	}
	/**
	 * @return the previewDays
	 */
	public String getPreviewDays() {
		return previewDays;
	}
	/**
	 * @param previewDays the previewDays to set
	 */
	public void setPreviewDays(String previewDays) {
		this.previewDays = previewDays;
	}
	/**
	 * @return the sequenceNumber
	 */
	public String getSequenceNumber() {
		return sequenceNumber;
	}
	/**
	 * @param sequenceNumber the sequenceNumber to set
	 */
	public void setSequenceNumber(String sequenceNumber) {
		this.sequenceNumber = sequenceNumber;
	}
	/**
	 * @return the customerGetsRefund
	 */
	public String getCustomerGetsRefund() {
		return customerGetsRefund;
	}
	/**
	 * @param customerGetsRefund the customerGetsRefund to set
	 */
	public void setCustomerGetsRefund(String customerGetsRefund) {
		this.customerGetsRefund = customerGetsRefund;
	}
	/**
	 * @return the deferredIncome
	 */
	public String getDeferredIncome() {
		return deferredIncome;
	}
	/**
	 * @param deferredIncome the deferredIncome to set
	 */
	public void setDeferredIncome(String deferredIncome) {
		this.deferredIncome = deferredIncome;
	}
	/**
	 * @return the earnedIncome
	 */
	public String getEarnedIncome() {
		return earnedIncome;
	}
	/**
	 * @param earnedIncome the earnedIncome to set
	 */
	public void setEarnedIncome(String earnedIncome) {
		this.earnedIncome = earnedIncome;
	}
	/**
	 * @return the recipient
	 */
	public Customer getRecipient() {
		return recipient;
	}
	/**
	 * @param recipient the recipient to set
	 */
	public void setRecipient(Customer recipient) {
		this.recipient = recipient;
	}
	/**
	 * @return the attributes
	 */
	public HashMap<String, String> getAttributes() {
		return attributes;
	}
	/**
	 * @param attributes the attributes to set
	 */
	public void setAttributes(HashMap<String, String> attributes) {
		this.attributes = attributes;
	}
	/**
	 * @return the vendorOrderNumber
	 */
	public String getVendorOrderNumber() {
		return vendorOrderNumber;
	}
	/**
	 * @param vendorOrderNumber the vendorOrderNumber to set
	 */
	public void setVendorOrderNumber(String vendorOrderNumber) {
		this.vendorOrderNumber = vendorOrderNumber;
	}
}
