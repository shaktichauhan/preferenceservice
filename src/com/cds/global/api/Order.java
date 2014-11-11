package com.cds.global.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Element;

import com.cds.global.common.Constants;

public class Order extends BaseServiceObject {
	protected String orderNumber = "";
	protected String orderType = null;//non sub donor, gift recipient, etc.
	protected String orderTypeDescription = null;
	protected String orderStatus = null;
	protected String orderStatusDescription = null;
	
	protected String promotionKey = null;//promotion key to use, will turn into aka document key on SERV, tracking code on DOMS
	protected String quantityAlreadyReceived = null;
	protected String quantityAlreadyReceivedDate = null;
	protected String receiveDate = null;
	protected String poNumber = null;
	protected String invoiceNumber = null;
	protected String planCode = null;
	protected String specialProductCode = null;
	protected String clientAccountNumber = null;
	
	protected String internetNumber = null;
	protected String vendorOrderNumber = null;
	protected String taxExemptCode = null;
	protected String deliveryMethod = null;
	protected String forceContinuity = null;
	protected String miscValue = null;
	protected String shippingAndHandlingAmt = null;
	protected String discountAmt = null;
	protected String couponsAmt = null;
	protected String marketingDBAccountNumber = null;
	protected String salesRepAccountNumber = null;
	protected String numberOfInstallments = null;
	protected String installmentsAllowed = null;
	
	protected String totalOrderValue = null;
	protected String totalOrderTax = null;
	protected String totalOrderPostageHandling = null;
	protected String amountDue = null;
	
	protected String subscriptionStart = null;
	protected String subscriptionLastSent = null;
	protected String subscriptionEnd = null;
	protected String subscriptionItemsRemaining = null;
	protected String autoRenew = null;
	protected String resumeSubscription = null; //Y or date to resume
	protected String suspendSubscription = null;//Y or date to suspend until
	protected String stopRecurringCharge = null;
	protected String refundAmount = null;
	
	protected String reasonCode = null;  //reason code for change to order (cancel, delete, etc)
	
	protected Customer customer = new Customer();
	protected Payment payment = new Payment();
	protected ArrayList<OrderItem> orderItems = new ArrayList<OrderItem>();
	protected HashMap<String, String> attributes = new HashMap<String, String>();
	/**
	 * Validate we are ready to send an order.  There must be a Customer object
	 * with a value for Name.
	 * 
	 * @param wsg
	 * @param wsgResponse
	 * @return boolean
	 */
	public boolean validateOrderReadiness(WSG wsg, WSGResponse wsgResponse) {
		if (getCustomer() == null) {
			wsgResponse.setSuccess(false);
			wsgResponse.addErrorMessage("There must be a Customer to send an order.");
		} else {
			String name = getCustomer().getName();
			if (name == null || "".equals(name.trim())) {
				name = getCustomer().getFirstName() + " " + getCustomer().getLastName();
				if (name == null || "".equals(name.trim())) {
					wsgResponse.setSuccess(false);
					wsgResponse.addErrorMessage("There must be a Customer with a Name to send an order.");
				}
			}
		}
		if (wsgResponse.isSuccess()) {
			wsg.setUrl("/order/" + Constants.PRODUCT_ID_REPLACE_VALUE + "?");
		}
		//
		return wsgResponse.isSuccess();
	}
	/**
	 * Validate we are ready to send an order.  There must be a Customer object
	 * with a value for Name.
	 * 
	 * @param wsg
	 * @param wsgResponse
	 * @return boolean
	 */
	public boolean validateLookupReadiness(WSG wsg, WSGResponse wsgResponse) {
		if (getCustomer() == null) {
			wsgResponse.setSuccess(false);
			wsgResponse.addErrorMessage("There must be a Customer when looking up an order");
		} else if (getCustomer().getAccountNumber() == null || "".equals(getCustomer().getAccountNumber().trim())) {
			wsgResponse.setSuccess(false);
			wsgResponse.addErrorMessage("There must be a Customer with an account number when looking up an order");
		} else if (getOrderNumber() == null || "".equals(getOrderNumber().trim())) {
			wsgResponse.setSuccess(false);
			wsgResponse.addErrorMessage("There must be an Order Number when looking up an order");
		}
		if (wsgResponse.isSuccess()) {
			wsg.setUrl("/order/" + Constants.PRODUCT_ID_REPLACE_VALUE + "/" + getOrderNumber() + "?");
		}
		//
		return wsgResponse.isSuccess();
	}
	/**
	 * Populate an XML Element from the values in this object.
	 * 
	 * @param orderElement
	 * @return String
	 */
	public String createXml(Element orderElement) {
		if (getOrderNumber() != null && !"".equals(getOrderNumber().trim())) {
			orderElement.addElement("orderNumber").addText(getOrderNumber());
		}
		if (getOrderType() != null && !"".equals(getOrderType().trim())) {
			orderElement.addElement("orderType").addText(getOrderType());
		}
		if (getOrderTypeDescription() != null && !"".equals(getOrderTypeDescription().trim())) {
			orderElement.addElement("orderTypeDescription").addText(getOrderTypeDescription());
		}
		if (getOrderStatus() != null && !"".equals(getOrderStatus().trim())) {
			orderElement.addElement("orderStatus").addText(getOrderStatus());
		}
		if (getOrderStatusDescription() != null && !"".equals(getOrderStatusDescription().trim())) {
			orderElement.addElement("orderStatusDescription").addText(getOrderStatusDescription());
		}
		if (getPromotionKey() != null && !"".equals(getPromotionKey().trim())) {
			orderElement.addElement("promotionKey").addText(getPromotionKey());
		}
		if (getQuantityAlreadyReceived() != null && !"".equals(getQuantityAlreadyReceived().trim())) {
			orderElement.addElement("quantityAlreadyReceived").addText(getQuantityAlreadyReceived());
		}
		if (getQuantityAlreadyReceivedDate() != null && !"".equals(getQuantityAlreadyReceivedDate().trim())) {
			orderElement.addElement("quantityAlreadyReceivedDate").addText(getQuantityAlreadyReceivedDate());
		}
		if (getReceiveDate() != null && !"".equals(getReceiveDate().trim())) {
			orderElement.addElement("receiveDate").addText(getReceiveDate());
		}
		if (getPoNumber() != null && !"".equals(getPoNumber().trim())) {
			orderElement.addElement("poNumber").addText(getPoNumber());
		}
		if (getInvoiceNumber() != null && !"".equals(getInvoiceNumber().trim())) {
			orderElement.addElement("invoiceNumber").addText(getInvoiceNumber());
		}
		if (getPlanCode() != null && !"".equals(getPlanCode().trim())) {
			orderElement.addElement("planCode").addText(getPlanCode());
		}
		if (getSpecialProductCode() != null && !"".equals(getSpecialProductCode().trim())) {
			orderElement.addElement("specialProductCode").addText(getSpecialProductCode());
		}
		if (getInternetNumber() != null && !"".equals(getInternetNumber().trim())) {
			orderElement.addElement("internetNumber").addText(getInternetNumber());
		}
		if (getTaxExemptCode() != null && !"".equals(getTaxExemptCode().trim())) {
			orderElement.addElement("taxExemptCode").addText(getTaxExemptCode());
		}
		if (getDeliveryMethod() != null && !"".equals(getDeliveryMethod().trim())) {
			orderElement.addElement("deliveryMethod").addText(getDeliveryMethod());
		}
		if (getForceContinuity() != null && !"".equals(getForceContinuity().trim())) {
			orderElement.addElement("forceContinuity").addText(getForceContinuity());
		}
		if (getMiscValue() != null && !"".equals(getMiscValue().trim())) {
			orderElement.addElement("miscValue").addText(getMiscValue());
		}
		if (getShippingAndHandlingAmt() != null && !"".equals(getShippingAndHandlingAmt().trim())) {
			orderElement.addElement("shippingAndHandlingAmt").addText(getShippingAndHandlingAmt());
		}
		if (getDiscountAmt() != null && !"".equals(getDiscountAmt().trim())) {
			orderElement.addElement("discountAmt").addText(getDiscountAmt());
		}
		if (getCouponsAmt() != null && !"".equals(getCouponsAmt().trim())) {
			orderElement.addElement("couponsAmt").addText(getCouponsAmt());
		}
		if (getMarketingDBAccountNumber() != null && !"".equals(getMarketingDBAccountNumber().trim())) {
			orderElement.addElement("marketingDBAccountNumber").addText(getMarketingDBAccountNumber());
		}
		if (getSalesRepAccountNumber() != null && !"".equals(getSalesRepAccountNumber().trim())) {
			orderElement.addElement("salesRepAccountNumber").addText(getSalesRepAccountNumber());
		}
		if (getNumberOfInstallments() != null && !"".equals(getNumberOfInstallments().trim())) {
			orderElement.addElement("numberOfInstallments").addText(getNumberOfInstallments());
		}
		if (getInstallmentsAllowed() != null && !"".equals(getInstallmentsAllowed().trim())) {
			orderElement.addElement("installmentsAllowed").addText(getInstallmentsAllowed());
		}
		if (getTotalOrderValue() != null && !"".equals(getTotalOrderValue().trim())) {
			orderElement.addElement("totalOrderValue").addText(getTotalOrderValue());
		}
		if (getTotalOrderTax() != null && !"".equals(getTotalOrderTax().trim())) {
			orderElement.addElement("totalOrderTax").addText(getTotalOrderTax());
		}
		if (getTotalOrderPostageHandling() != null && !"".equals(getTotalOrderPostageHandling().trim())) {
			orderElement.addElement("totalOrderPostageHandling").addText(getTotalOrderPostageHandling());
		}
		if (getAmountDue() != null && !"".equals(getAmountDue().trim())) {
			orderElement.addElement("amountDue").addText(getAmountDue());
		}
		if (getSubscriptionStart() != null && !"".equals(getSubscriptionStart().trim())) {
			orderElement.addElement("subscriptionStart").addText(getSubscriptionStart());
		}
		if (getSubscriptionLastSent() != null && !"".equals(getSubscriptionLastSent().trim())) {
			orderElement.addElement("subscriptionLastSent").addText(getSubscriptionLastSent());
		}
		if (getSubscriptionEnd() != null && !"".equals(getSubscriptionEnd().trim())) {
			orderElement.addElement("subscriptionEnd").addText(getSubscriptionEnd());
		}
		if (getSubscriptionItemsRemaining() != null && !"".equals(getSubscriptionItemsRemaining().trim())) {
			orderElement.addElement("subscriptionItemsRemaining").addText(getSubscriptionItemsRemaining());
		}
		if (getAutoRenew() != null && !"".equals(getAutoRenew().trim())) {
			orderElement.addElement("autoRenew").addText(getAutoRenew());
		}
		if (getResumeSubscription() != null && !"".equals(getResumeSubscription().trim())) {
			orderElement.addElement("resumeSubscription").addText(getResumeSubscription());
		}
		if (getSuspendSubscription() != null && !"".equals(getSuspendSubscription().trim())) {
			orderElement.addElement("suspendSubscription").addText(getSuspendSubscription());
		}
		if (getStopRecurringCharge() != null && !"".equals(getStopRecurringCharge().trim())) {
			orderElement.addElement("stopRecurringCharge").addText(getStopRecurringCharge());
		}
		if (getRefundAmount() != null && !"".equals(getRefundAmount().trim())) {
			orderElement.addElement("refundAmount").addText(getRefundAmount());
		}
		if (getReasonCode() != null && !"".equals(getReasonCode().trim())) {
			orderElement.addElement("reasonCode").addText(getReasonCode());
		}
		if (getVendorOrderNumber() != null && !"".equals(getVendorOrderNumber().trim())) {
			orderElement.addElement("vendorOrderNumber").addText(getVendorOrderNumber());
		}
		if (getClientAccountNumber() != null && !"".equals(getClientAccountNumber().trim())) {
			orderElement.addElement("clientAccountNumber").addText(getClientAccountNumber());
		}
		//
		if (getCustomer() != null) {
			Element customerElement = orderElement.addElement("customer");
			getCustomer().createXml(customerElement);
		}
		//
		if (getPayment() != null) {
			Element paymentElement = orderElement.addElement("payment");
			getPayment().createXmlString(paymentElement);
		}
		//
		if (getOrderItems() != null && getOrderItems().size() > 0) {
			Element orderItemElement = null;
			OrderItem orderItem = null;
			for(Iterator<OrderItem> it = getOrderItems().iterator(); it.hasNext(); ) {
				orderItemElement = orderElement.addElement("orderItem");
				orderItem = it.next();
				orderItem.toXml(orderItemElement);
			}
		}
		//
		if (getAttributes() != null && !getAttributes().isEmpty()) {
			Element attributsElement = orderElement.addElement("attributes");
			String key = null;
			String value = null;
			for(Iterator<String> it = getAttributes().keySet().iterator(); it.hasNext(); ) {
				key = it.next();
				value = getAttributes().get(key);
				attributsElement.addElement(key).addText(value);
			}
		}
		//
		return orderElement.asXML();
	}
	/**
	 * Populate this Order Object from a list of Order Elements.
	 * 
	 * @param orderElements
	 */
	@SuppressWarnings("unchecked")
	public void populateFromXml(List<Element> orderElements) {
		Element orderElement = null;
		OrderItem orderItem = null;
		//
		for (Iterator<Element> iter = orderElements.iterator(); iter.hasNext(); ) {
	        orderElement = iter.next();
	        setOrderNumber(orderElement.elementText("orderNumber"));
	        setOrderType(orderElement.elementText("orderType"));
	        setOrderTypeDescription(orderElement.elementText("orderTypeDescription"));
	        setOrderStatus(orderElement.elementText("orderStatus"));
	        setOrderStatusDescription(orderElement.elementText("orderStatusDescription"));
	        setPromotionKey(orderElement.elementText("promotionKey"));
	        setQuantityAlreadyReceived(orderElement.elementText("quantityAlreadyReceived"));
	        setQuantityAlreadyReceivedDate(orderElement.elementText("quantityAlreadyReceivedDate"));
	        setReceiveDate(orderElement.elementText("receiveDate"));
	        setPoNumber(orderElement.elementText("poNumber"));
	        setInvoiceNumber(orderElement.elementText("invoiceNumber"));
	        setPlanCode(orderElement.elementText("planCode"));
	        setSpecialProductCode(orderElement.elementText("specialProductCode"));
	        setInternetNumber(orderElement.elementText("internetNumber"));
	        setTaxExemptCode(orderElement.elementText("taxExemptCode"));
	        setDeliveryMethod(orderElement.elementText("deliveryMethod"));
	        setForceContinuity(orderElement.elementText("forceContinuity"));
	        setMiscValue(orderElement.elementText("miscValue"));
	        setShippingAndHandlingAmt(orderElement.elementText("shippingAndHandlingAmt"));
	        setDiscountAmt(orderElement.elementText("discountAmt"));
	        setCouponsAmt(orderElement.elementText("couponsAmt"));
	        setMarketingDBAccountNumber(orderElement.elementText("marketingDBAccountNumber"));
	        setSalesRepAccountNumber(orderElement.elementText("salesRepAccountNumber"));
	        setNumberOfInstallments(orderElement.elementText("numberOfInstallments"));
	        setInstallmentsAllowed(orderElement.elementText("installmentsAllowed"));
	        setTotalOrderValue(orderElement.elementText("totalOrderValue"));
	        setTotalOrderTax(orderElement.elementText("totalOrderTax"));
	        setTotalOrderPostageHandling(orderElement.elementText("totalOrderPostageHandling"));
	        setAmountDue(orderElement.elementText("amountDue"));
	        setSubscriptionStart(orderElement.elementText("subscriptionStart"));
	        setSubscriptionLastSent(orderElement.elementText("subscriptionLastSent"));
	        setSubscriptionEnd(orderElement.elementText("subscriptionEnd"));
	        setSubscriptionItemsRemaining(orderElement.elementText("subscriptionItemsRemaining"));
	        setAutoRenew(orderElement.elementText("autoRenew"));
	        setResumeSubscription(orderElement.elementText("resumeSubscription"));
	        setSuspendSubscription(orderElement.elementText("suspendSubscription"));
	        setStopRecurringCharge(orderElement.elementText("stopRecurringCharge"));
	        setRefundAmount(orderElement.elementText("refundAmount"));
	        setReasonCode(orderElement.elementText("reasonCode"));
	        setVendorOrderNumber(orderElement.elementText("vendorOrderNumber"));
	        setClientAccountNumber(orderElement.elementText("clientAccountNumber"));
	        //
	        List<Element> customers = orderElement.selectNodes("customer");
	        getCustomer().populateFromXmlNode(customers);
	        //
	        List<Element> paymentElements = orderElement.elements("payment");
	        if (paymentElements != null && paymentElements.size() > 0) {
	        	if (getPayment() == null) {
	        		setPayment(new Payment());
	        	}
	        	getPayment().populateFromXmlNode(paymentElements);
	        }
	        //
	        List<Element> orderItems = orderElement.elements("orderItem");
	        if (orderItems != null && orderItems.size() > 0) {
	        	for(Iterator<Element> it = orderItems.iterator(); it.hasNext(); ) {
	        		orderItem = new OrderItem();
	        		orderItem.populateFromXmlNode((Element)it.next());
	        		getOrderItems().add(orderItem);
	        	}
	        }

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
	 * @return the orderType
	 */
	public String getOrderType() {
		return orderType;
	}
	/**
	 * @param orderType the orderType to set
	 */
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	/**
	 * @return the orderTypeDescription
	 */
	public String getOrderTypeDescription() {
		return orderTypeDescription;
	}
	/**
	 * @param orderTypeDescription the orderTypeDescription to set
	 */
	public void setOrderTypeDescription(String orderTypeDescription) {
		this.orderTypeDescription = orderTypeDescription;
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
	 * @return the quantityAlreadyReceived
	 */
	public String getQuantityAlreadyReceived() {
		return quantityAlreadyReceived;
	}
	/**
	 * @param quantityAlreadyReceived the quantityAlreadyReceived to set
	 */
	public void setQuantityAlreadyReceived(String quantityAlreadyReceived) {
		this.quantityAlreadyReceived = quantityAlreadyReceived;
	}
	/**
	 * @return the quantityAlreadyReceivedDate
	 */
	public String getQuantityAlreadyReceivedDate() {
		return quantityAlreadyReceivedDate;
	}
	/**
	 * @param quantityAlreadyReceivedDate the quantityAlreadyReceivedDate to set
	 */
	public void setQuantityAlreadyReceivedDate(String quantityAlreadyReceivedDate) {
		this.quantityAlreadyReceivedDate = quantityAlreadyReceivedDate;
	}
	/**
	 * @return the receiveDate
	 */
	public String getReceiveDate() {
		return receiveDate;
	}
	/**
	 * @param receiveDate the receiveDate to set
	 */
	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}
	/**
	 * @return the poNumber
	 */
	public String getPoNumber() {
		return poNumber;
	}
	/**
	 * @param poNumber the poNumber to set
	 */
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}
	/**
	 * @return the invoiceNumber
	 */
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	/**
	 * @param invoiceNumber the invoiceNumber to set
	 */
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	/**
	 * @return the planCode
	 */
	public String getPlanCode() {
		return planCode;
	}
	/**
	 * @param planCode the planCode to set
	 */
	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}
	/**
	 * @return the specialProductCode
	 */
	public String getSpecialProductCode() {
		return specialProductCode;
	}
	/**
	 * @param specialProductCode the specialProductCode to set
	 */
	public void setSpecialProductCode(String specialProductCode) {
		this.specialProductCode = specialProductCode;
	}
	/**
	 * @return the internetNumber
	 */
	public String getInternetNumber() {
		return internetNumber;
	}
	/**
	 * @param internetNumber the internetNumber to set
	 */
	public void setInternetNumber(String internetNumber) {
		this.internetNumber = internetNumber;
	}
	/**
	 * @return the taxExemptCode
	 */
	public String getTaxExemptCode() {
		return taxExemptCode;
	}
	/**
	 * @param taxExemptCode the taxExemptCode to set
	 */
	public void setTaxExemptCode(String taxExemptCode) {
		this.taxExemptCode = taxExemptCode;
	}
	/**
	 * @return the deliveryMethod
	 */
	public String getDeliveryMethod() {
		return deliveryMethod;
	}
	/**
	 * @param deliveryMethod the deliveryMethod to set
	 */
	public void setDeliveryMethod(String deliveryMethod) {
		this.deliveryMethod = deliveryMethod;
	}
	/**
	 * @return the forceContinuity
	 */
	public String getForceContinuity() {
		return forceContinuity;
	}
	/**
	 * @param forceContinuity the forceContinuity to set
	 */
	public void setForceContinuity(String forceContinuity) {
		this.forceContinuity = forceContinuity;
	}
	/**
	 * @return the miscValue
	 */
	public String getMiscValue() {
		return miscValue;
	}
	/**
	 * @param miscValue the miscValue to set
	 */
	public void setMiscValue(String miscValue) {
		this.miscValue = miscValue;
	}
	/**
	 * @return the shippingAndHandlingAmt
	 */
	public String getShippingAndHandlingAmt() {
		return shippingAndHandlingAmt;
	}
	/**
	 * @param shippingAndHandlingAmt the shippingAndHandlingAmt to set
	 */
	public void setShippingAndHandlingAmt(String shippingAndHandlingAmt) {
		this.shippingAndHandlingAmt = shippingAndHandlingAmt;
	}
	/**
	 * @return the discountAmt
	 */
	public String getDiscountAmt() {
		return discountAmt;
	}
	/**
	 * @param discountAmt the discountAmt to set
	 */
	public void setDiscountAmt(String discountAmt) {
		this.discountAmt = discountAmt;
	}
	/**
	 * @return the couponsAmt
	 */
	public String getCouponsAmt() {
		return couponsAmt;
	}
	/**
	 * @param couponsAmt the couponsAmt to set
	 */
	public void setCouponsAmt(String couponsAmt) {
		this.couponsAmt = couponsAmt;
	}
	/**
	 * @return the marketingDBAccountNumber
	 */
	public String getMarketingDBAccountNumber() {
		return marketingDBAccountNumber;
	}
	/**
	 * @param marketingDBAccountNumber the marketingDBAccountNumber to set
	 */
	public void setMarketingDBAccountNumber(String marketingDBAccountNumber) {
		this.marketingDBAccountNumber = marketingDBAccountNumber;
	}
	/**
	 * @return the salesRepAccountNumber
	 */
	public String getSalesRepAccountNumber() {
		return salesRepAccountNumber;
	}
	/**
	 * @param salesRepAccountNumber the salesRepAccountNumber to set
	 */
	public void setSalesRepAccountNumber(String salesRepAccountNumber) {
		this.salesRepAccountNumber = salesRepAccountNumber;
	}
	/**
	 * @return the numberOfInstallments
	 */
	public String getNumberOfInstallments() {
		return numberOfInstallments;
	}
	/**
	 * @param numberOfInstallments the numberOfInstallments to set
	 */
	public void setNumberOfInstallments(String numberOfInstallments) {
		this.numberOfInstallments = numberOfInstallments;
	}
	/**
	 * @return the installmentsAllowed
	 */
	public String getInstallmentsAllowed() {
		return installmentsAllowed;
	}
	/**
	 * @param installmentsAllowed the installmentsAllowed to set
	 */
	public void setInstallmentsAllowed(String installmentsAllowed) {
		this.installmentsAllowed = installmentsAllowed;
	}
	/**
	 * @return the totalOrderValue
	 */
	public String getTotalOrderValue() {
		return totalOrderValue;
	}
	/**
	 * @param totalOrderValue the totalOrderValue to set
	 */
	public void setTotalOrderValue(String totalOrderValue) {
		this.totalOrderValue = totalOrderValue;
	}
	/**
	 * @return the totalOrderTax
	 */
	public String getTotalOrderTax() {
		return totalOrderTax;
	}
	/**
	 * @param totalOrderTax the totalOrderTax to set
	 */
	public void setTotalOrderTax(String totalOrderTax) {
		this.totalOrderTax = totalOrderTax;
	}
	/**
	 * @return the totalOrderPostageHandling
	 */
	public String getTotalOrderPostageHandling() {
		return totalOrderPostageHandling;
	}
	/**
	 * @param totalOrderPostageHandling the totalOrderPostageHandling to set
	 */
	public void setTotalOrderPostageHandling(String totalOrderPostageHandling) {
		this.totalOrderPostageHandling = totalOrderPostageHandling;
	}
	/**
	 * @return the amountDue
	 */
	public String getAmountDue() {
		return amountDue;
	}
	/**
	 * @param amountDue the amountDue to set
	 */
	public void setAmountDue(String amountDue) {
		this.amountDue = amountDue;
	}
	/**
	 * @return the subscriptionStart
	 */
	public String getSubscriptionStart() {
		return subscriptionStart;
	}
	/**
	 * @param subscriptionStart the subscriptionStart to set
	 */
	public void setSubscriptionStart(String subscriptionStart) {
		this.subscriptionStart = subscriptionStart;
	}
	/**
	 * @return the subscriptionLastSent
	 */
	public String getSubscriptionLastSent() {
		return subscriptionLastSent;
	}
	/**
	 * @param subscriptionLastSent the subscriptionLastSent to set
	 */
	public void setSubscriptionLastSent(String subscriptionLastSent) {
		this.subscriptionLastSent = subscriptionLastSent;
	}
	/**
	 * @return the subscriptionEnd
	 */
	public String getSubscriptionEnd() {
		return subscriptionEnd;
	}
	/**
	 * @param subscriptionEnd the subscriptionEnd to set
	 */
	public void setSubscriptionEnd(String subscriptionEnd) {
		this.subscriptionEnd = subscriptionEnd;
	}
	/**
	 * @return the subscriptionItemsRemaining
	 */
	public String getSubscriptionItemsRemaining() {
		return subscriptionItemsRemaining;
	}
	/**
	 * @param subscriptionItemsRemaining the subscriptionItemsRemaining to set
	 */
	public void setSubscriptionItemsRemaining(String subscriptionItemsRemaining) {
		this.subscriptionItemsRemaining = subscriptionItemsRemaining;
	}
	/**
	 * @return the autoRenew
	 */
	public String getAutoRenew() {
		return autoRenew;
	}
	/**
	 * @param autoRenew the autoRenew to set
	 */
	public void setAutoRenew(String autoRenew) {
		this.autoRenew = autoRenew;
	}
	/**
	 * @return the resumeSubscription
	 */
	public String getResumeSubscription() {
		return resumeSubscription;
	}
	/**
	 * @param resumeSubscription the resumeSubscription to set
	 */
	public void setResumeSubscription(String resumeSubscription) {
		this.resumeSubscription = resumeSubscription;
	}
	/**
	 * @return the suspendSubscription
	 */
	public String getSuspendSubscription() {
		return suspendSubscription;
	}
	/**
	 * @param suspendSubscription the suspendSubscription to set
	 */
	public void setSuspendSubscription(String suspendSubscription) {
		this.suspendSubscription = suspendSubscription;
	}
	/**
	 * @return the stopRecurringCharge
	 */
	public String getStopRecurringCharge() {
		return stopRecurringCharge;
	}
	/**
	 * @param stopRecurringCharge the stopRecurringCharge to set
	 */
	public void setStopRecurringCharge(String stopRecurringCharge) {
		this.stopRecurringCharge = stopRecurringCharge;
	}
	/**
	 * @return the refundAmount
	 */
	public String getRefundAmount() {
		return refundAmount;
	}
	/**
	 * @param refundAmount the refundAmount to set
	 */
	public void setRefundAmount(String refundAmount) {
		this.refundAmount = refundAmount;
	}
	/**
	 * @return the reasonCode
	 */
	public String getReasonCode() {
		return reasonCode;
	}
	/**
	 * @param reasonCode the reasonCode to set
	 */
	public void setReasonCode(String reasonCode) {
		this.reasonCode = reasonCode;
	}
	/**
	 * @return the customer
	 */
	public Customer getCustomer() {
		return customer;
	}
	/**
	 * @param customer the customer to set
	 */
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	/**
	 * @return the payment
	 */
	public Payment getPayment() {
		return payment;
	}
	/**
	 * @param payment the payment to set
	 */
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	/**
	 * @return the orderItem
	 */
	public ArrayList<OrderItem> getOrderItems() {
		return orderItems;
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
	/**
	 * @return the clientAccountNumber
	 */
	public String getClientAccountNumber() {
		return clientAccountNumber;
	}
	/**
	 * @param clientAccountNumber the clientAccountNumber to set
	 */
	public void setClientAccountNumber(String clientAccountNumber) {
		this.clientAccountNumber = clientAccountNumber;
	}
}
