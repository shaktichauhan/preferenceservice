package com.readersdigest.onepass.db;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * MemberAdvocateInfo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "member_onepass_advocate_info", schema = "dbo", catalog = "registration")
public class MemberAdvocateInfo implements java.io.Serializable {

	// Fields

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The advocate id. */
	private Integer advocateId;
	
	/** The adv email address. */
	private String advEmailAddress;
	
	/** The token. */
	private String token;
	
	/** The create date. */
	private Timestamp createDate;
	
	/** The adv first name. */
	private String advFirstName;
	
	/** The adv last name. */
	private String advLastName;
	
	/** The tracking id. */
	private String trackingId;
	
	/** The promo key. */
	private String promoKey;

	// Constructors

	/**
	 *  default constructor.
	 */
	public MemberAdvocateInfo() {
	}

	
	// Property accessors
	/**
	 * Gets the advocate id.
	 *
	 * @return the advocate id
	 */
	@Id
	@Column(name = "advocate_id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getAdvocateId() {
		return this.advocateId;
	}

	/**
	 * Sets the advocate id.
	 *
	 * @param advocateId the new advocate id
	 */
	public void setAdvocateId(Integer advocateId) {
		this.advocateId = advocateId;
	}

	/**
	 * Gets the adv email address.
	 *
	 * @return the adv email address
	 */
	@Column(name = "email_address", nullable = false)
	public String getAdvEmailAddress() {
		return this.advEmailAddress;
	}

	/**
	 * Sets the adv email address.
	 *
	 * @param advEmailAddress the new adv email address
	 */
	public void setAdvEmailAddress(String advEmailAddress) {
		this.advEmailAddress = advEmailAddress;
	}

	/**
	 * Gets the token.
	 *
	 * @return the token
	 */
	@Column(name = "token")
	public String getToken() {
		return this.token;
	}

	/**
	 * Sets the token.
	 *
	 * @param token the new token
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * Gets the creates the date.
	 *
	 * @return the creates the date
	 */
	@Column(name = "create_date", nullable = false, length = 23)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	/**
	 * Sets the creates the date.
	 *
	 * @param createDate the new creates the date
	 */
	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	/**
	 * Gets the adv first name.
	 *
	 * @return the adv first name
	 */
	@Column(name = "adv_first_name")
	public String getAdvFirstName() {
		return this.advFirstName;
	}

	/**
	 * Sets the adv first name.
	 *
	 * @param advFirstName the new adv first name
	 */
	public void setAdvFirstName(String advFirstName) {
		this.advFirstName = advFirstName;
	}
	
	/**
	 * Gets the adv last name.
	 *
	 * @return the adv last name
	 */
	@Column(name = "adv_last_name")
	public String getAdvLastName() {
		return this.advLastName;
	}

	/**
	 * Sets the adv last name.
	 *
	 * @param advLastName the new adv last name
	 */
	public void setAdvLastName(String advLastName) {
		this.advLastName = advLastName;
	}

	/**
	 * Gets the tracking id.
	 *
	 * @return the tracking id
	 */
	@Column(name = "tracking_id")
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
	 * Gets the promo key.
	 *
	 * @return the promo key
	 */
	@Column(name = "promo_key")
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
	
	

}