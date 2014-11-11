package com.readersdigest.onepass.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 * AbstractOpAccount entity provides the base persistence definition of the
 * OpAccount entity. @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */
@MappedSuperclass
public abstract class AbstractOpAccount implements java.io.Serializable {

	// Fields

	private OpAccountId id;
	private OpPerson opPerson;
	private String password;
	private Set<OpPreference> opPreferences = new HashSet<OpPreference>(0);

	// Constructors

	/** default constructor */
	public AbstractOpAccount() {
	}

	/** minimal constructor */
	public AbstractOpAccount(OpAccountId id, OpPerson opPerson) {
		this.id = id;
		this.opPerson = opPerson;
	}

	/** full constructor */
	public AbstractOpAccount(OpAccountId id, OpPerson opPerson,
			String password, Set<OpPreference> opPreferences) {
		this.id = id;
		this.opPerson = opPerson;
		this.password = password;
		this.opPreferences = opPreferences;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "domainNm", column = @Column(name = "DOMAIN_NM", nullable = false, length = 50)),
			@AttributeOverride(name = "personId", column = @Column(name = "PERSON_ID", nullable = false)) })
	public OpAccountId getId() {
		return this.id;
	}

	public void setId(OpAccountId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PERSON_ID", nullable = false, insertable = false, updatable = false)
	public OpPerson getOpPerson() {
		return this.opPerson;
	}

	public void setOpPerson(OpPerson opPerson) {
		this.opPerson = opPerson;
	}

	@Column(name = "PASSWORD", length = 30)
	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "opAccount")
	public Set<OpPreference> getOpPreferences() {
		return this.opPreferences;
	}

	public void setOpPreferences(Set<OpPreference> opPreferences) {
		this.opPreferences = opPreferences;
	}

}