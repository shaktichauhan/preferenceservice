package com.cds.global.api;

import java.util.Iterator;
import java.util.List;

import org.dom4j.Element;

import com.cds.global.common.Constants;

public class Payment extends BaseServiceObject {
	protected String invoiceNumber = null;
	protected String effort = null;
	protected String paymentType = null;
	protected String amountPaid = null;
	protected String cardProfileId = null; //DOMS returns this on order lookup
	protected String creditCardType = null;
	protected String creditCardNumber = null;
	protected String creditCardExpire = null;
	protected String creditCardExpireMonth = null;
	protected String creditCardExpireYear = null;
	protected String authorizationCode = null;
	protected String authorizationDate = null;
	protected String currencyType = null;
	protected String lastChargeDate = null;
	protected String creditCardCVV = null;
	protected String useForRemainderOfService = null;//only for PF right now.
	protected String paymentOnOrderType = null;//only for SERV right now.  when sending a payment, they need to know whether it's a gift or reg order.
	//
	protected Customer billingInformation = new Customer();
	//
	public Payment() {}
	/**
	 * Create a Payment class and set the Customer to the passed in object.
	 * 
	 * @param customer
	 */
	public Payment(Customer customer) {
		this.billingInformation = customer;
	}
	/**
	 * Validate all data needed for a Payment transaction is set.
	 * 
	 * @param wsg
	 * @param wsgResponse
	 * @return boolean
	 */
	public boolean validatePaymentReadiness(WSG wsg, WSGResponse wsgResponse) {
		if (billingInformation == null || billingInformation.getAccountNumber() == null || billingInformation.getAccountNumber().trim().length() < 1) {
			wsgResponse.setSuccess(false);
			wsgResponse.addErrorMessage("There must be a Customer with an Account Number to make a payment.");
		} else {
			wsg.setUrl("/payment/" + Constants.PRODUCT_ID_REPLACE_VALUE + "?");
		}
		//
		return wsgResponse.isSuccess();
	}
	/**
	 * Populate this object from a List of XML nodes.
	 * 
	 * @param nodes
	 */
	@SuppressWarnings("unchecked")
	public void populateFromXmlNode(List<Element> nodes) {
		Element paymentElement = null;
		//
		for (Iterator<Element> iter = nodes.iterator(); iter.hasNext(); ) {
	        paymentElement = iter.next();
	        setInvoiceNumber(paymentElement.elementText("invoiceNumber"));
	        setEffort(paymentElement.elementText("effort"));
	        setAmountPaid(paymentElement.elementText("amountPaid"));
	        setCreditCardType(paymentElement.elementText("creditCardType"));
	        setCreditCardNumber(paymentElement.elementText("creditCardNumber"));
	        setCreditCardExpire(paymentElement.elementText("creditCardExpire"));
	        setCreditCardExpireMonth(paymentElement.elementText("creditCardExpireMonth"));
	        setCreditCardExpireYear(paymentElement.elementText("creditCardExpireYear"));
	        setCreditCardCVV(paymentElement.elementText("creditCardCVV"));
	        setUseForRemainderOfService(paymentElement.elementText("useForRemainderOfService"));
	        setPaymentType(paymentElement.elementText("paymentType"));
	        setCardProfileId(paymentElement.elementText("cardProfileId"));
	        setAuthorizationCode(paymentElement.elementText("authorizationCode"));
	        setAuthorizationDate(paymentElement.elementText("authorizationDate"));
	        setLastChargeDate(paymentElement.elementText("lastChargeDate"));
	        setPaymentOnOrderType(paymentElement.elementText("paymentOnOrderType"));
	        //childElement.elementText("amountPaid")
	        List<Element> billingInformationNodes = paymentElement.selectNodes("billingInformation");
	        if (billingInformationNodes != null && billingInformationNodes.size() > 0) {
	        	getBillingInformation().populateFromXmlNode(billingInformationNodes);
	        }
		}
	}
	/**
	 * Populate an XML Element from the values in this object.
	 * 
	 * @param paymentNode
	 * @return String
	 */
	public String createXmlString(Element paymentNode) {
		//create the root element and add it to the document
		if (getInvoiceNumber() != null && !"".equals(getInvoiceNumber().trim())) {
			paymentNode.addElement("invoiceNumber").addText(getInvoiceNumber());
		}
		if (getEffort() != null && !"".equals(getEffort().trim())) {
			paymentNode.addElement("effort").addText(getEffort());
		}
		if (getAmountPaid() != null && !"".equals(getAmountPaid().trim())) {
			paymentNode.addElement("amountPaid").addText(getAmountPaid());
		}
		if (getCreditCardType() != null && !"".equals(getCreditCardType().trim())) {
			paymentNode.addElement("creditCardType").addText(getCreditCardType());
		}
		if (getCreditCardNumber() != null && !"".equals(getCreditCardNumber().trim())) {
			paymentNode.addElement("creditCardNumber").addText(getCreditCardNumber());
		}
		if (getCreditCardExpire() != null && !"".equals(getCreditCardExpire().trim())) {
			paymentNode.addElement("creditCardExpire").addText(getCreditCardExpire());
		}
		if (getCreditCardExpireMonth() != null && !"".equals(getCreditCardExpireMonth().trim())) {
			paymentNode.addElement("creditCardExpireMonth").addText(getCreditCardExpireMonth());
		}
		if (getCreditCardExpireYear() != null && !"".equals(getCreditCardExpireYear().trim())) {
			paymentNode.addElement("creditCardExpireYear").addText(getCreditCardExpireYear());
		}
		if (getCreditCardCVV() != null && !"".equals(getCreditCardCVV().trim())) {
			paymentNode.addElement("creditCardCVV").addText(getCreditCardCVV());
		}
		if (getUseForRemainderOfService() != null && !"".equals(getUseForRemainderOfService().trim())) {
			paymentNode.addElement("useForRemainderOfService").addText(getUseForRemainderOfService());
		}
		if (getPaymentType() != null && !"".equals(getPaymentType().trim())) {
			paymentNode.addElement("paymentType").addText(getPaymentType());
		}
		if (getCardProfileId() != null && !"".equals(getCardProfileId().trim())) {
			paymentNode.addElement("cardProfileId").addText(getCardProfileId());
		}
		if (getAuthorizationCode() != null && !"".equals(getAuthorizationCode().trim())) {
			paymentNode.addElement("authorizationCode").addText(getAuthorizationCode());
		}
		if (getAuthorizationDate() != null && !"".equals(getAuthorizationDate().trim())) {
			paymentNode.addElement("authorizationDate").addText(getAuthorizationCode());
		}
		if (getLastChargeDate() != null && !"".equals(getLastChargeDate().trim())) {
			paymentNode.addElement("lastChargeDate").addText(getLastChargeDate());
		}
		if (getPaymentOnOrderType() != null && !"".equals(getPaymentOnOrderType().trim())) {
			paymentNode.addElement("paymentOnOrderType").addText(getPaymentOnOrderType());
		}
		if (getBillingInformation() != null) {
			Element billingInfo = paymentNode.addElement("billingInformation");
			billingInformation.createXml(billingInfo);
		}
		//
		return paymentNode.asXML();
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
	 * @return the effort
	 */
	public String getEffort() {
		return effort;
	}
	/**
	 * @param effort the effort to set
	 */
	public void setEffort(String effort) {
		this.effort = effort;
	}
	/**
	 * @return the paymentType
	 */
	public String getPaymentType() {
		return paymentType;
	}
	/**
	 * @param paymentType the paymentType to set
	 */
	public void setPaymentType(String paymentType) {
		this.paymentType = paymentType;
	}
	/**
	 * @return the amountPaid
	 */
	public String getAmountPaid() {
		return amountPaid;
	}
	/**
	 * @param amountPaid the amountPaid to set
	 */
	public void setAmountPaid(String amountPaid) {
		this.amountPaid = amountPaid;
	}
	/**
	 * @return the cardProfileId
	 */
	public String getCardProfileId() {
		return cardProfileId;
	}
	/**
	 * @param cardProfileId the cardProfileId to set
	 */
	public void setCardProfileId(String cardProfileId) {
		this.cardProfileId = cardProfileId;
	}
	/**
	 * @return the creditCardType
	 */
	public String getCreditCardType() {
		return creditCardType;
	}
	/**
	 * @param creditCardType the creditCardType to set
	 */
	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}
	/**
	 * @return the creditCardNumber
	 */
	public String getCreditCardNumber() {
		return creditCardNumber;
	}
	/**
	 * @param creditCardNumber the creditCardNumber to set
	 */
	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}
	/**
	 * @return the creditCardExpire
	 */
	public String getCreditCardExpire() {
		return creditCardExpire;
	}
	/**
	 * @param creditCardExpire the creditCardExpire to set
	 */
	public void setCreditCardExpire(String creditCardExpire) {
		this.creditCardExpire = creditCardExpire;
	}
	/**
	 * @return the creditCardExpireMonth
	 */
	public String getCreditCardExpireMonth() {
		return creditCardExpireMonth;
	}
	/**
	 * @param creditCardExpireMonth the creditCardExpireMonth to set
	 */
	public void setCreditCardExpireMonth(String creditCardExpireMonth) {
		this.creditCardExpireMonth = creditCardExpireMonth;
	}
	/**
	 * @return the creditCardExpireYear
	 */
	public String getCreditCardExpireYear() {
		return creditCardExpireYear;
	}
	/**
	 * @param creditCardExpireYear the creditCardExpireYear to set
	 */
	public void setCreditCardExpireYear(String creditCardExpireYear) {
		this.creditCardExpireYear = creditCardExpireYear;
	}
	/**
	 * @return the authorizationCode
	 */
	public String getAuthorizationCode() {
		return authorizationCode;
	}
	/**
	 * @param authorizationCode the authorizationCode to set
	 */
	public void setAuthorizationCode(String authorizationCode) {
		this.authorizationCode = authorizationCode;
	}
	/**
	 * @return the authorizationDate
	 */
	public String getAuthorizationDate() {
		return authorizationDate;
	}
	/**
	 * @param authorizationDate the authorizationDate to set
	 */
	public void setAuthorizationDate(String authorizationDate) {
		this.authorizationDate = authorizationDate;
	}
	/**
	 * @return the currencyType
	 */
	public String getCurrencyType() {
		return currencyType;
	}
	/**
	 * @param currencyType the currencyType to set
	 */
	public void setCurrencyType(String currencyType) {
		this.currencyType = currencyType;
	}
	/**
	 * @return the lastChargeDate
	 */
	public String getLastChargeDate() {
		return lastChargeDate;
	}
	/**
	 * @param lastChargeDate the lastChargeDate to set
	 */
	public void setLastChargeDate(String lastChargeDate) {
		this.lastChargeDate = lastChargeDate;
	}
	/**
	 * @return the creditCardCVV
	 */
	public String getCreditCardCVV() {
		return creditCardCVV;
	}
	/**
	 * @param creditCardCVV the creditCardCVV to set
	 */
	public void setCreditCardCVV(String creditCardCVV) {
		this.creditCardCVV = creditCardCVV;
	}
	/**
	 * @return the useForRemainderOfService
	 */
	public String getUseForRemainderOfService() {
		return useForRemainderOfService;
	}
	/**
	 * @param useForRemainderOfService the useForRemainderOfService to set
	 */
	public void setUseForRemainderOfService(String useForRemainderOfService) {
		this.useForRemainderOfService = useForRemainderOfService;
	}
	/**
	 * @return the paymentOnOrderType
	 */
	public String getPaymentOnOrderType() {
		return paymentOnOrderType;
	}
	/**
	 * @param paymentOnOrderType the paymentOnOrderType to set
	 */
	public void setPaymentOnOrderType(String paymentOnOrderType) {
		this.paymentOnOrderType = paymentOnOrderType;
	}
	/**
	 * @return the billingInformation
	 */
	public Customer getBillingInformation() {
		return billingInformation;
	}
	/**
	 * @param billingInformation the billingInformation to set
	 */
	public void setBillingInformation(Customer billingInformation) {
		this.billingInformation = billingInformation;
	}
}
