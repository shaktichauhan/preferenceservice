package com.cds.global.api;

import org.dom4j.Element;

public class OrderOverview {
	protected String prodId = null;
	protected String productName = null;
	protected String orderNumber = null;  // aka subscription_id on DOMS
	protected String status = null;
	protected String statusDescription = null;
	protected String promotionKey = null; // aka document key on SERV, tracking code on DOMS
	protected String billKey = null;
	protected String lastPaymentAmount = null;
	protected String lastPaymentDate = null;
	protected String createdDate = null;
	protected String amountDue = null;
	protected String invoiceNumber = null;
	protected String previousBillAmount = null;
	protected String orderEntry = null;
	protected String orderEntryDescription = null;
	protected String orderSetCode = null;
	protected String orderSetCodeDescription = null;
	protected String orderSummaryDate = null;//deprecated!  use createdDate
	protected String creditStatus = null;
	protected String creditStatusDescription = null;
	protected String orderValue = null;
	protected String billEffort = null;
	protected String installmentAllowed = null;
	protected String installmentSent = null;
	protected String installmentDue = null;
	protected String installmentAmount = null;
	protected String planCode = null;	
	protected String subscriptionStart = null;
	protected String subscriptionExpire = null;
	protected String subscriptionTerm = null;
	protected String autoRenew = null;
	protected String periodUnit = null;
	protected String productNumber = null;
	
	protected CardProfile cardProfile = null;
	/**
	 * Populate this OrderOverview object from an XML Element.
	 * 
	 * @param orderSummaryElement
	 */
	public void populateFromXmlNode(Element orderSummaryElement) {
        setProdId(orderSummaryElement.elementText("prodId"));
        setOrderNumber(orderSummaryElement.elementText("orderNumber"));
        setCreatedDate(orderSummaryElement.elementText("createdDate"));
        setAmountDue(orderSummaryElement.elementText("amountDue"));
        setInvoiceNumber(orderSummaryElement.elementText("invoiceNumber"));
        setPreviousBillAmount(orderSummaryElement.elementText("previousBillAmount"));
        setOrderSummaryDate(orderSummaryElement.elementText("orderSummaryDate"));
        setCreditStatus(orderSummaryElement.elementText("creditStatus"));
        setCreditStatusDescription(orderSummaryElement.elementText("creditStatusDescription"));
        setOrderValue(orderSummaryElement.elementText("orderValue"));
        setBillEffort(orderSummaryElement.elementText("billEffort"));
        setInstallmentAllowed(orderSummaryElement.elementText("installmentAllowed"));
        setInstallmentSent(orderSummaryElement.elementText("installmentSent"));
        setInstallmentDue(orderSummaryElement.elementText("installmentDue"));
        setInstallmentAmount(orderSummaryElement.elementText("installmentAmount"));
        setPlanCode(orderSummaryElement.elementText("planCode"));
        setProductName(orderSummaryElement.elementText("productName"));
        setStatus(orderSummaryElement.elementText("status"));
        setStatusDescription(orderSummaryElement.elementText("statusDescription"));
        setPromotionKey(orderSummaryElement.elementText("promotionKey"));
        setBillKey(orderSummaryElement.elementText("billKey"));
        setLastPaymentAmount(orderSummaryElement.elementText("lastPaymentAmount"));
        setLastPaymentDate(orderSummaryElement.elementText("lastPaymentDate"));
        setOrderEntry(orderSummaryElement.elementText("orderEntry"));
        setOrderEntryDescription(orderSummaryElement.elementText("orderEntryDescription"));
        setOrderSetCode(orderSummaryElement.elementText("orderSetCode"));
        setOrderSetCodeDescription(orderSummaryElement.elementText("orderSetCodeDescription"));
        setSubscriptionStart(orderSummaryElement.elementText("subscriptionStart"));
        setSubscriptionExpire(orderSummaryElement.elementText("subscriptionExpire"));
        setSubscriptionTerm(orderSummaryElement.elementText("subscriptionTerm"));
        setAutoRenew(orderSummaryElement.elementText("autoRenew"));
        setPeriodUnit(orderSummaryElement.elementText("periodUnit"));
        setProductNumber(orderSummaryElement.elementText("productNumber"));
        //
        Element cardProfileElement = orderSummaryElement.element("cardProfile");
        if (cardProfileElement != null) {
	        if (getCardProfile() == null) {
	        	setCardProfile(new CardProfile());
	        }
	        getCardProfile().populateFromXmlNode(cardProfileElement);
        }
        //
        return;
	}
	/**
	 * Populate and XML Element with the values from this OrderOverview object.
	 * 
	 * @param orderSummaryElement
	 * @return String
	 */
	public String toXml(Element orderSummaryElement) {
		orderSummaryElement.addElement("prodId").addText(getProdId());
		orderSummaryElement.addElement("productName").addText(getProductName());
		orderSummaryElement.addElement("orderNumber").addText(getOrderNumber());
		orderSummaryElement.addElement("status").addText(getStatus());
		orderSummaryElement.addElement("statusDescription").addText(getStatusDescription());
		orderSummaryElement.addElement("promotionKey").addText(getPromotionKey());
		orderSummaryElement.addElement("billKey").addText(getBillKey());
		orderSummaryElement.addElement("lastPaymentAmount").addText(getLastPaymentAmount());
		orderSummaryElement.addElement("lastPaymentDate").addText(getLastPaymentDate());
		orderSummaryElement.addElement("createdDate").addText(getCreatedDate());
		orderSummaryElement.addElement("amountDue").addText(getAmountDue());
		orderSummaryElement.addElement("invoiceNumber").addText(getInvoiceNumber());
		orderSummaryElement.addElement("previousBillAmount").addText(getPreviousBillAmount());
		orderSummaryElement.addElement("orderEntry").addText(getOrderEntry());
		orderSummaryElement.addElement("orderEntryDescription").addText(getOrderEntryDescription());
		orderSummaryElement.addElement("orderSetCode").addText(getOrderSetCode());
		orderSummaryElement.addElement("orderSetCodeDescription").addText(getOrderSetCodeDescription());
		orderSummaryElement.addElement("orderSummaryDate").addText(getOrderSummaryDate());
		orderSummaryElement.addElement("creditStatus").addText(getCreditStatus());
		orderSummaryElement.addElement("creditStatusDescription").addText(getCreditStatusDescription());
		orderSummaryElement.addElement("orderValue").addText(getOrderValue());
		orderSummaryElement.addElement("billEffort").addText(getBillEffort());
		orderSummaryElement.addElement("installmentAllowed").addText(getInstallmentAllowed());
		orderSummaryElement.addElement("installmentSent").addText(getInstallmentSent());
		orderSummaryElement.addElement("installmentDue").addText(getInstallmentDue());
		orderSummaryElement.addElement("installmentAmount").addText(getInstallmentAmount());
		orderSummaryElement.addElement("planCode").addText(getPlanCode());
		orderSummaryElement.addElement("subscriptionStart").addText(getSubscriptionStart());
		orderSummaryElement.addElement("subscriptionExpire").addText(getSubscriptionExpire());
		orderSummaryElement.addElement("subscriptionTerm").addText(getSubscriptionTerm());
		orderSummaryElement.addElement("autoRenew").addText(getAutoRenew());
		orderSummaryElement.addElement("periodUnit").addText(getPeriodUnit());
		orderSummaryElement.addElement("productNumber").addText(getProductNumber());
		//
		if (getCardProfile() != null) {
			Element cardProfileElement = orderSummaryElement.addElement("cardProfile");
			getCardProfile().toXml(cardProfileElement);
		}
		//
		return orderSummaryElement.asXML();
	}
	
	public String getAmountDue() {
		return amountDue;
	}
	public void setAmountDue(String amountDue) {
		this.amountDue = amountDue;
	}
	public String getLastPaymentAmount() {
		return lastPaymentAmount;
	}
	public void setLastPaymentAmount(String lastPaymentAmount) {
		this.lastPaymentAmount = lastPaymentAmount;
	}
	public String getLastPaymentDate() {
		return lastPaymentDate;
	}
	public void setLastPaymentDate(String lastPaymentDate) {
		this.lastPaymentDate = lastPaymentDate;
	}
	public String getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(String createdDate) {
		this.createdDate = createdDate;
	}
	public String getProdId() {
		return prodId;
	}
	public void setProdId(String prodId) {
		this.prodId = prodId;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	/**
	 * @return the promotionKey
	 */
	public String getPromotionKey() {
		return promotionKey;
	}
	/**
	 * @param promotionKey the promotionKey to set
	 */
	public void setPromotionKey(String promotionKey) {
		this.promotionKey = promotionKey;
	}
	/**
	 * @return the billKey
	 */
	public String getBillKey() {
		return billKey;
	}
	/**
	 * @param billKey the billKey to set
	 */
	public void setBillKey(String billKey) {
		this.billKey = billKey;
	}
	public String getOrderNumber() {
		return orderNumber;
	}
	public void setOrderNumber(String orderNumber) {
		this.orderNumber = orderNumber;
	}
	public String getPreviousBillAmount() {
		return previousBillAmount;
	}
	public void setPreviousBillAmount(String previousBillAmount) {
		this.previousBillAmount = previousBillAmount;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getBillEffort() {
		return billEffort;
	}
	public void setBillEffort(String billEffort) {
		this.billEffort = billEffort;
	}
	public String getCreditStatus() {
		return creditStatus;
	}
	public void setCreditStatus(String creditStatus) {
		this.creditStatus = creditStatus;
	}
	public String getInstallmentAllowed() {
		return installmentAllowed;
	}
	public void setInstallmentAllowed(String installmentAllowed) {
		this.installmentAllowed = installmentAllowed;
	}
	public String getInstallmentAmount() {
		return installmentAmount;
	}
	public void setInstallmentAmount(String installmentAmount) {
		this.installmentAmount = installmentAmount;
	}
	public String getInstallmentDue() {
		return installmentDue;
	}
	public void setInstallmentDue(String installmentDue) {
		this.installmentDue = installmentDue;
	}
	public String getInstallmentSent() {
		return installmentSent;
	}
	public void setInstallmentSent(String installmentSent) {
		this.installmentSent = installmentSent;
	}
	public String getOrderEntry() {
		return orderEntry;
	}
	public void setOrderEntry(String orderEntry) {
		this.orderEntry = orderEntry;
	}
	public String getOrderSummaryDate() {
		return orderSummaryDate;
	}
	public void setOrderSummaryDate(String orderSummaryDate) {
		this.orderSummaryDate = orderSummaryDate;
	}
	public String getOrderValue() {
		return orderValue;
	}
	public void setOrderValue(String orderValue) {
		this.orderValue = orderValue;
	}
	/**
	 * @return the subscriptionTerm
	 */
	public String getSubscriptionTerm() {
		return subscriptionTerm;
	}
	/**
	 * @param the subscriptionTerm to set
	 */
	public void setSubscriptionTerm(String subscriptionTerm) {
		this.subscriptionTerm = subscriptionTerm;
	}
	public String getPlanCode() {
		return planCode;
	}
	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}
	public String getOrderSetCode() {
		return orderSetCode;
	}
	public void setOrderSetCode(String orderSetCode) {
		this.orderSetCode = orderSetCode;
	}
	public String getStatusDescription() {
		return statusDescription;
	}
	public void setStatusDescription(String statusDescription) {
		this.statusDescription = statusDescription;
	}
	public String getOrderEntryDescription() {
		return orderEntryDescription;
	}
	public void setOrderEntryDescription(String orderEntryDescription) {
		this.orderEntryDescription = orderEntryDescription;
	}
	public String getOrderSetCodeDescription() {
		return orderSetCodeDescription;
	}
	public void setOrderSetCodeDescription(String orderSetCodeDescription) {
		this.orderSetCodeDescription = orderSetCodeDescription;
	}
	public String getCreditStatusDescription() {
		return creditStatusDescription;
	}
	public void setCreditStatusDescription(String creditStatusDescription) {
		this.creditStatusDescription = creditStatusDescription;
	}
	public String getSubscriptionExpire() {
		return subscriptionExpire;
	}
	public void setSubscriptionExpire(String subscriptionExpire) {
		this.subscriptionExpire = subscriptionExpire;
	}
	public String getSubscriptionStart() {
		return subscriptionStart;
	}
	public void setSubscriptionStart(String subscriptionStart) {
		this.subscriptionStart = subscriptionStart;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public CardProfile getCardProfile() {
		return cardProfile;
	}
	public void setCardProfile(CardProfile cardProfile) {
		this.cardProfile = cardProfile;
	}
	public String getAutoRenew() {
		return autoRenew;
	}
	public void setAutoRenew(String autoRenew) {
		this.autoRenew = autoRenew;
	}
	public String getPeriodUnit() {
		return periodUnit;
	}
	public void setPeriodUnit(String periodUnit) {
		this.periodUnit = periodUnit;
	}
	public String getProductNumber() {
		return productNumber;
	}
	public void setProductNumber(String productNumber) {
		this.productNumber = productNumber;
	}
}
