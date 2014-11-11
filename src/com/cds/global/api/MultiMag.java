package com.cds.global.api;

import org.dom4j.Element;

public class MultiMag {
	protected String magAbbreviation = null;
	protected String nonGiftAmountDue = null;
	protected String giftAmountDue = null;
	protected String autoRenewal = null;
	protected String serviceStatus = null;
	protected String serviceStatusDescription = null;
	protected String expireIssue = null;
	protected String expireIssueDescription = null;
	/**
	 * Populated this MultiMag object from an XML Element.
	 * 
	 * @param multiMagElement
	 */
	public void populateFromXmlNode(Element multiMagElement) {
		setMagAbbreviation(multiMagElement.elementText("magAbbreviation"));
		setNonGiftAmountDue(multiMagElement.elementText("nonGiftAmountDue"));
		setGiftAmountDue(multiMagElement.elementText("giftAmountDue"));
		setAutoRenewal(multiMagElement.elementText("autoRenewal"));
		setServiceStatus(multiMagElement.elementText("serviceStatus"));
		setServiceStatusDescription(multiMagElement.elementText("serviceStatusDescription"));
		setExpireIssue(multiMagElement.elementText("expireIssue"));
		setExpireIssueDescription(multiMagElement.elementText("expireIssueDescription"));
	}
	
	public String getMagAbbreviation() {
		return magAbbreviation;
	}
	public void setMagAbbreviation(String magAbbreviation) {
		this.magAbbreviation = magAbbreviation;
	}
	public String getNonGiftAmountDue() {
		return nonGiftAmountDue;
	}
	public void setNonGiftAmountDue(String nonGiftAmountDue) {
		this.nonGiftAmountDue = nonGiftAmountDue;
	}
	public String getGiftAmountDue() {
		return giftAmountDue;
	}
	public void setGiftAmountDue(String giftAmountDue) {
		this.giftAmountDue = giftAmountDue;
	}
	public String getAutoRenewal() {
		return autoRenewal;
	}
	public void setAutoRenewal(String autoRenewal) {
		this.autoRenewal = autoRenewal;
	}
	public String getServiceStatus() {
		return serviceStatus;
	}
	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	public String getServiceStatusDescription() {
		return serviceStatusDescription;
	}
	public void setServiceStatusDescription(String serviceStatusDescription) {
		this.serviceStatusDescription = serviceStatusDescription;
	}
	public String getExpireIssue() {
		return expireIssue;
	}
	public void setExpireIssue(String expireIssue) {
		this.expireIssue = expireIssue;
	}
	public String getExpireIssueDescription() {
		return expireIssueDescription;
	}
	public void setExpireIssueDescription(String expireIssueDescription) {
		this.expireIssueDescription = expireIssueDescription;
	}
	
}
