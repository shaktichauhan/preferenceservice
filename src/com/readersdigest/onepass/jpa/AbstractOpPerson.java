package com.readersdigest.onepass.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 * AbstractOpPerson entity provides the base persistence definition of the
 * OpPerson entity. @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */
@MappedSuperclass
public abstract class AbstractOpPerson implements java.io.Serializable {

	// Fields

	private Integer personId;
	private String firstNm;
	private String lastNm;
	private Set<OpAccount> opAccounts = new HashSet<OpAccount>(0);
	private Set<OpAddress> opAddresses = new HashSet<OpAddress>(0);
	private Set<OpEmail> opEmails = new HashSet<OpEmail>(0);

	// Constructors

	/** default constructor */
	public AbstractOpPerson() {
	}

	/** minimal constructor */
	public AbstractOpPerson(Integer personId) {
		this.personId = personId;
	}

	/** full constructor */
	public AbstractOpPerson(String firstNm, String lastNm,
			Set<OpAccount> opAccounts, Set<OpAddress> opAddresses,
			Set<OpEmail> opEmails) {
		this.firstNm = firstNm;
		this.lastNm = lastNm;
		this.opAccounts = opAccounts;
		this.opAddresses = opAddresses;
		this.opEmails = opEmails;
	}

	@Id
	@Column(name = "PERSON_ID", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	public Integer getPersonId() {
		return this.personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	@Column(name = "FIRST_NM")
	public String getFirstNm() {
		return this.firstNm;
	}

	public void setFirstNm(String firstNm) {
		this.firstNm = firstNm;
	}

	@Column(name = "LAST_NM")
	public String getLastNm() {
		return this.lastNm;
	}

	public void setLastNm(String lastNm) {
		this.lastNm = lastNm;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "opPerson")
	public Set<OpAccount> getOpAccounts() {
		return this.opAccounts;
	}

	public void setOpAccounts(Set<OpAccount> opAccounts) {
		this.opAccounts = opAccounts;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "opPerson")
	public Set<OpAddress> getOpAddresses() {
		return this.opAddresses;
	}

	public void setOpAddresses(Set<OpAddress> opAddresses) {
		this.opAddresses = opAddresses;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "opPerson")
	public Set<OpEmail> getOpEmails() {
		return this.opEmails;
	}

	public void setOpEmails(Set<OpEmail> opEmails) {
		this.opEmails = opEmails;
	}

}