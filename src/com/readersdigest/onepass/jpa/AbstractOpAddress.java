package com.readersdigest.onepass.jpa;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * AbstractOpAddress entity provides the base persistence definition of the
 * OpAddress entity. @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */
@MappedSuperclass
public abstract class AbstractOpAddress implements java.io.Serializable {

	// Fields

	private Integer id;
	private OpPerson opPerson;
	private String street1;
	private String street2;
	private String city;
	private String stateNm;
	private String zip;
	private String country;
	private Boolean primaryFlag;

	// Constructors

	/** default constructor */
	public AbstractOpAddress() {
	}

	/** minimal constructor */
	public AbstractOpAddress(OpPerson opPerson) {
		this.opPerson = opPerson;
	}

	/** full constructor */
	public AbstractOpAddress(OpPerson opPerson, String street1, String street2,
			String city, String stateNm, String zip, String country,
			Boolean primaryFlag) {
		this.opPerson = opPerson;
		this.street1 = street1;
		this.street2 = street2;
		this.city = city;
		this.stateNm = stateNm;
		this.zip = zip;
		this.country = country;
		this.primaryFlag = primaryFlag;
	}

	// Property accessors
	@Id
	@Column(name = "ADDRESS_ID", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_ID")
	public OpPerson getOpPerson() {
		return this.opPerson;
	}

	public void setOpPerson(OpPerson opPerson) {
		this.opPerson = opPerson;
	}

	@Column(name = "STREET1")
	public String getStreet1() {
		return this.street1;
	}

	public void setStreet1(String street1) {
		this.street1 = street1;
	}

	@Column(name = "STREET2")
	public String getStreet2() {
		return this.street2;
	}

	public void setStreet2(String street2) {
		this.street2 = street2;
	}

	@Column(name = "CITY")
	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Column(name = "STATE_NM")
	public String getStateNm() {
		return this.stateNm;
	}

	public void setStateNm(String stateNm) {
		this.stateNm = stateNm;
	}

	@Column(name = "ZIP")
	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	@Column(name = "COUNTRY")
	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	@Column(name = "PRIMARY_FLAG")
	public Boolean getPrimaryFlag() {
		return this.primaryFlag;
	}

	public void setPrimaryFlag(Boolean primaryFlag) {
		this.primaryFlag = primaryFlag;
	}

}
