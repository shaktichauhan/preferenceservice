package com.cds.global.api;

import org.dom4j.Element;
/**
 * Some CDS Global systems store multiple credit card profiles for a given customer.
 * This class handles transactions dealing with card profiles.
 * 
 * @author jab910
 */
public class CardProfile extends BaseServiceObject {
	//Setup right now to only support one card profile from DOMS.
	//Would need redesigned to store multiple 
	protected String cardProfileId = null;
	protected String cardProfileName = null;
	protected String creditCardType = null;
	protected String creditCardNumber = null;
	protected String creditCardExpire = null;
	protected String creditCardExpireMonth = null;
	protected String creditCardExpireYear = null;
	protected String creditCardCVV = null;
	protected String name = null;
	protected String accountNumber = null;

	/**
	 * Populate this CardProfile objects an XML Element.
	 * 
	 * @param cardProfileElement
	 */
	public void populateFromXmlNode(Element cardProfileElement) {
		setCardProfileId(cardProfileElement.elementText("cardProfileId"));
		setCardProfileName(cardProfileElement.elementText("cardProfileName"));
		setCreditCardType(cardProfileElement.elementText("creditCardType"));
		setCreditCardNumber(cardProfileElement.elementText("creditCardNumber"));
		setCreditCardExpire(cardProfileElement.elementText("creditCardExpire"));
		setCreditCardExpireMonth(cardProfileElement.elementText("creditCardExpireMonth"));
		setCreditCardExpireYear(cardProfileElement.elementText("creditCardExpireYear"));
		setCreditCardCVV(cardProfileElement.elementText("creditCardCVV"));
		setName(cardProfileElement.elementText("name"));
		setAccountNumber(cardProfileElement.elementText("accountNumber"));
	}
	
	/**
	 * The values contained in this CardProfile object are populated into
	 * the passed in XML Element.
	 * 
	 * @param cardProfileElement
	 * @return String The XML generated as a string.
	 */
	public String toXml(Element cardProfileElement) {
		cardProfileElement.addElement("cardProfileId").addText(getCardProfileId());
		cardProfileElement.addElement("cardProfileName").addText(getCardProfileName());
		cardProfileElement.addElement("creditCardType").addText(getCreditCardType());
		cardProfileElement.addElement("creditCardNumber").addText(getCreditCardNumber());
		cardProfileElement.addElement("creditCardExpire").addText(getCreditCardExpire());
		cardProfileElement.addElement("creditCardExpireMonth").addText(getCreditCardExpireMonth());
		cardProfileElement.addElement("creditCardExpireYear").addText(getCreditCardExpireYear());
		cardProfileElement.addElement("creditCardCVV").addText(getCreditCardCVV());
		cardProfileElement.addElement("name").addText(getName());
		cardProfileElement.addElement("accountNumber").addText(getAccountNumber());
		return cardProfileElement.asXML();
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
	 * @return the cardProfileName
	 */
	public String getCardProfileName() {
		return cardProfileName;
	}

	/** 
	 * @param cardProfileName the cardProfileName to set
	 */
	public void setCardProfileName(String cardProfileName) {
		this.cardProfileName = cardProfileName;
	}

	/**
	 * @return the creditCardType
	 */
	public String getCreditCardType() {
		return creditCardType;
	}

	/** TODO get Credit Card types for this
	 * 
	 * Set the creditCardType
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

	/** TODO Explain credit card expire, expire month and expire year
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}

	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
}
