package com.readersdigest.onepass.brandAdvocate.form;

import java.io.Serializable;

import org.apache.struts.validator.ValidatorForm;


/**
 * The Class RegistrationForm.
 */
public class RegistrationForm extends ValidatorForm implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The advocate first name. */
	private String advocateFirstName;

	/** The advocate last name. */
	private String advocateLastName;

	/** The advocate email address. */
	private String advocateEmailAddress;

	/** The recipiant first name. */
	private String recipiantFirstName;

	/** The recipiant last name. */
	private String recipiantLastName;

	/** The recipiant email address. */
	private String recipiantEmailAddress;

	/** The recipiant password. */
	private String recipiantPassword;

	/** The token. */
	private String token;

	/** The source name. */
	private String sourceName;

	/** The tracking id. */
	private String trkId;

	
	/** The promotable. */
	private String[] promotable = null;

	/** The user type. */
	private String userType;

	/** The prod abbr. */
	private String prodAbbr;

	/** The register mail. */
	private String registerMail;

	/**
	 * Gets the register mail.
	 * 
	 * @return the register mail
	 */
	public String getRegisterMail() {
		return registerMail;
	}

	/**
	 * Sets the register mail.
	 * 
	 * @param registerMail
	 *            the new register mail
	 */
	public void setRegisterMail(String registerMail) {
		this.registerMail = registerMail;
	}

	/**
	 * Gets the token.
	 * 
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * Sets the token.
	 * 
	 * @param token
	 *            the new token
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * Gets the advocate first name.
	 * 
	 * @return the advocate first name
	 */
	public String getAdvocateFirstName() {
		return advocateFirstName;
	}

	/**
	 * Sets the advocate first name.
	 * 
	 * @param advocateFirstName
	 *            the new advocate first name
	 */
	public void setAdvocateFirstName(String advocateFirstName) {
		this.advocateFirstName = advocateFirstName;
	}

	/**
	 * Gets the advocate last name.
	 * 
	 * @return the advocate last name
	 */
	public String getAdvocateLastName() {
		return advocateLastName;
	}

	/**
	 * Sets the advocate last name.
	 * 
	 * @param advocateLastName
	 *            the new advocate last name
	 */
	public void setAdvocateLastName(String advocateLastName) {
		this.advocateLastName = advocateLastName;
	}

	/**
	 * Gets the advocate email address.
	 * 
	 * @return the advocate email address
	 */
	public String getAdvocateEmailAddress() {
		return advocateEmailAddress;
	}

	/**
	 * Sets the advocate email address.
	 * 
	 * @param advocateEmailAddress
	 *            the new advocate email address
	 */
	public void setAdvocateEmailAddress(String advocateEmailAddress) {
		this.advocateEmailAddress = advocateEmailAddress;
	}

	/**
	 * Gets the recipiant first name.
	 * 
	 * @return the recipiant first name
	 */
	public String getRecipiantFirstName() {
		return recipiantFirstName;
	}

	/**
	 * Sets the recipiant first name.
	 * 
	 * @param recipiantFirstName
	 *            the new recipiant first name
	 */
	public void setRecipiantFirstName(String recipiantFirstName) {
		this.recipiantFirstName = recipiantFirstName;
	}

	/**
	 * Gets the recipiant last name.
	 * 
	 * @return the recipiant last name
	 */
	public String getRecipiantLastName() {
		return recipiantLastName;
	}

	/**
	 * Sets the recipiant last name.
	 * 
	 * @param recipiantLastName
	 *            the new recipiant last name
	 */
	public void setRecipiantLastName(String recipiantLastName) {
		this.recipiantLastName = recipiantLastName;
	}

	/**
	 * Gets the recipiant email address.
	 * 
	 * @return the recipiant email address
	 */
	public String getRecipiantEmailAddress() {
		return recipiantEmailAddress;
	}

	/**
	 * Sets the recipiant email address.
	 * 
	 * @param recipiantEmailAddress
	 *            the new recipiant email address
	 */
	public void setRecipiantEmailAddress(String recipiantEmailAddress) {
		this.recipiantEmailAddress = recipiantEmailAddress;
	}

	/**
	 * Gets the recipiant password.
	 * 
	 * @return the recipiant password
	 */
	public String getRecipiantPassword() {
		return recipiantPassword;
	}

	/**
	 * Sets the recipiant password.
	 * 
	 * @param recipiantPassword
	 *            the new recipiant password
	 */
	public void setRecipiantPassword(String recipiantPassword) {
		this.recipiantPassword = recipiantPassword;
	}

	/**
	 * Gets the source name.
	 * 
	 * @return the source name
	 */
	public String getSourceName() {
		return sourceName;
	}

	/**
	 * Sets the source name.
	 * 
	 * @param sourceName
	 *            the new source name
	 */
	public void setSourceName(String sourceName) {
		this.sourceName = sourceName;
	}

	
	/**
	 * Gets the tracking id.
	 * 
	 * @return the tracking id
	 */
	public String getTrkId() {
		return trkId;
	}
	/**
	 * Sets the tracking id.
	 * 
	 * @param trackingId
	 *            the new tracking id
	 */
	public void setTrkId(String trkId) {
		this.trkId = trkId;
	}

	/**
	 * Gets the promotable.
	 * 
	 * @return the promotable
	 */
	public String[] getPromotable() {
		return promotable;
	}

	/**
	 * Sets the promotable.
	 * 
	 * @param promotable
	 *            the new promotable
	 */
	public void setPromotable(String[] promotable) {
		this.promotable = promotable;
	}

	/**
	 * Gets the user type.
	 * 
	 * @return the user type
	 */
	public String getUserType() {
		return userType;
	}

	/**
	 * Sets the user type.
	 * 
	 * @param userType
	 *            the new user type
	 */
	public void setUserType(String userType) {
		this.userType = userType;
	}

	/**
	 * Gets the prod abbr.
	 * 
	 * @return the prod abbr
	 */
	public String getProdAbbr() {
		return prodAbbr;
	}

	/**
	 * Sets the prod abbr.
	 * 
	 * @param prodAbbr
	 *            the new prod abbr
	 */
	public void setProdAbbr(String prodAbbr) {
		this.prodAbbr = prodAbbr;
	}

}
