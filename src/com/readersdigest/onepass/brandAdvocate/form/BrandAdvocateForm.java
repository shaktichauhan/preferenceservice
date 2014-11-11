package com.readersdigest.onepass.brandAdvocate.form;

import java.io.Serializable;

import org.apache.struts.validator.ValidatorForm;


// TODO: Auto-generated Javadoc
/**
 * The Class BrandAdvocateForm.
 */
public class BrandAdvocateForm extends ValidatorForm implements Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;

	/** The first name. */
	private String[] firstName;

	/** The last name. */
	private String[] lastName;

	/** The email address. */
	private String[] emailAddress;

	/** The advocate first name. */
	private String advocateFirstName;

	/** The advocate last name. */
	private String advocateLastName;

	/** The advocate email address. */
	private String advocateEmailAddress;

	/** The traking id. */
	private String trkId;

	

	
	/** The promo key. */
	private String promoKey;
	
	/** The prod abbr. */
	String prodAbbr;

	/**
	 * Gets the traking id.
	 *
	 * @return the traking id
	 */
	public String getTrkId() {
		return trkId;
	}
	/**
	 * Sets the traking id.
	 *
	 * @param trakingId the new traking id
	 */
	public void setTrkId(String trkId) {
		this.trkId = trkId;
	}

	/**
	 * Gets the promo key.
	 *
	 * @return the promo key
	 */
	public String getPromoKey() {
		return promoKey;
	}

	/**
	 * Sets the promo key.
	 *
	 * @param promoKey the new promo key
	 */
	public void setPromoKey(String promoKey) {
		this.promoKey = promoKey;
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
	 * @param advocateFirstName the new advocate first name
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
	 * @param advocateLastName the new advocate last name
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
	 * @param advocateEmailAddress the new advocate email address
	 */
	public void setAdvocateEmailAddress(String advocateEmailAddress) {
		this.advocateEmailAddress = advocateEmailAddress;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public final String[] getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName the new first name
	 */
	public final void setFirstName(final String[] firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public final String[] getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName the new last name
	 */
	public final void setLastName(final String[] lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the email address.
	 *
	 * @return the email address
	 */
	public final String[] getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Sets the email address.
	 *
	 * @param emailAddress the new email address
	 */
	public final void setEmailAddress(final String[] emailAddress) {
		this.emailAddress = emailAddress;
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
	 * @param prodAbbr the new prod abbr
	 */
	public void setProdAbbr(String prodAbbr) {
		this.prodAbbr = prodAbbr;
	}
	
	

}
