package com.readersdigest.onepass.db;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EmailValid entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "email_validation", schema = "dbo", catalog = "registration")
public class EmailValidation implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private Integer emailValidId;
	private String emailAddress;
	private String token;
	private Timestamp createDate;
	private String valid;
	private String prodId;

	// Constructors

	/** default constructor */
	public EmailValidation() {
	}

	/** full constructor */
	public EmailValidation(Integer emailValidId, String emailAddress, String token,
			Timestamp createDate, String valid) {
		this.emailValidId = emailValidId;
		this.emailAddress = emailAddress;
		this.token = token;
		this.createDate = createDate;
		this.valid = valid;
	}

	// Property accessors
	@Id
	@Column(name = "email_validation_id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getEmailValidId() {
		return this.emailValidId;
	}

	public void setEmailValidId(Integer emailValidId) {
		this.emailValidId = emailValidId;
	}

	@Column(name = "email_address", nullable = false)
	public String getEmailAddress() {
		return this.emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	@Column(name = "token", nullable = false)
	public String getToken() {
		return this.token;
	}

	public void setToken(String token) {
		this.token = token;
	}

	@Column(name = "create_date", nullable = false, length = 23)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "valid", nullable = false, length = 10)
	public String getValid() {
		return this.valid;
	}

	public void setValid(String valid) {
		this.valid = valid;
	}
	
	@Column(name = "prod_id", nullable = false)
    public String getProdId() {
        return this.prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

}