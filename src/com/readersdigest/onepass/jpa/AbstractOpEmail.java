package com.readersdigest.onepass.jpa;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

/**
 * AbstractOpEmail entity provides the base persistence definition of the
 * OpEmail entity. @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */
@MappedSuperclass
public abstract class AbstractOpEmail implements java.io.Serializable {

	// Fields

	private OpEmailId id;
	private OpPerson opPerson;
	private Boolean primaryFlag;

	// Constructors

	/** default constructor */
	public AbstractOpEmail() {
	}

	/** minimal constructor */
	public AbstractOpEmail(OpEmailId id, OpPerson opPerson) {
		this.id = id;
		this.opPerson = opPerson;
	}

	/** full constructor */
	public AbstractOpEmail(OpEmailId id, OpPerson opPerson, Boolean primaryFlag) {
		this.id = id;
		this.opPerson = opPerson;
		this.primaryFlag = primaryFlag;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "email", column = @Column(name = "EMAIL", nullable = false)),
			@AttributeOverride(name = "personId", column = @Column(name = "PERSON_ID", nullable = false)) })
	public OpEmailId getId() {
		return this.id;
	}

	public void setId(OpEmailId id) {
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

	@Column(name = "PRIMARY_FLAG")
	public Boolean getPrimaryFlag() {
		return this.primaryFlag;
	}

	public void setPrimaryFlag(Boolean primaryFlag) {
		this.primaryFlag = primaryFlag;
	}

}