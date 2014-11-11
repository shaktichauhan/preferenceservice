package com.readersdigest.onepass.jpa;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * AbstractOpPreference entity provides the base persistence definition of the
 * OpPreference entity. @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */
@MappedSuperclass
public abstract class AbstractOpPreference implements java.io.Serializable {

	// Fields

	private OpPreferenceId id;
	private OpPreferenceDetail opPreferenceDetail;
	private OpAccount opAccount;
	private Boolean flag;

	// Constructors

	/** default constructor */
	public AbstractOpPreference() {
	}

	/** full constructor */
	public AbstractOpPreference(OpPreferenceId id,
			OpPreferenceDetail opPreferenceDetail, OpAccount opAccount,
			Boolean flag) {
		this.id = id;
		this.opPreferenceDetail = opPreferenceDetail;
		this.opAccount = opAccount;
		this.flag = flag;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "domainNm", column = @Column(name = "DOMAIN_NM", nullable = false, length = 50)),
			@AttributeOverride(name = "personId", column = @Column(name = "PERSON_ID", nullable = false)),
			@AttributeOverride(name = "preferenceId", column = @Column(name = "PREFERENCE_ID", nullable = false)) })
	public OpPreferenceId getId() {
		return this.id;
	}

	public void setId(OpPreferenceId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "PREFERENCE_ID", nullable = false, insertable = false, updatable = false)
	public OpPreferenceDetail getOpPreferenceDetail() {
		return this.opPreferenceDetail;
	}

	public void setOpPreferenceDetail(OpPreferenceDetail opPreferenceDetail) {
		this.opPreferenceDetail = opPreferenceDetail;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({
			@JoinColumn(name = "DOMAIN_NM", referencedColumnName = "DOMAIN_NM", nullable = false, insertable = false, updatable = false),
			@JoinColumn(name = "PERSON_ID", referencedColumnName = "PERSON_ID", nullable = false, insertable = false, updatable = false) })
	public OpAccount getOpAccount() {
		return this.opAccount;
	}

	public void setOpAccount(OpAccount opAccount) {
		this.opAccount = opAccount;
	}

	@Column(name = "FLAG", nullable = false)
	public Boolean getFlag() {
		return this.flag;
	}

	public void setFlag(Boolean flag) {
		this.flag = flag;
	}

}