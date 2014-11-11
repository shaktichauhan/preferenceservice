package com.readersdigest.onepass.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OpAccountId entity. @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */
@Embeddable
public class OpAccountId implements java.io.Serializable {

	// Fields

	private String domainNm;
	private Integer personId;

	// Constructors

	/** default constructor */
	public OpAccountId() {
	}

	/** full constructor */
	public OpAccountId(String domainNm, Integer personId) {
		this.domainNm = domainNm;
		this.personId = personId;
	}

	// Property accessors

	@Column(name = "DOMAIN_NM", nullable = false, length = 50)
	public String getDomainNm() {
		return this.domainNm;
	}

	public void setDomainNm(String domainNm) {
		this.domainNm = domainNm;
	}

	@Column(name = "PERSON_ID", nullable = false)
	public Integer getPersonId() {
		return this.personId;
	}

	public void setPersonId(Integer personId) {
		this.personId = personId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OpAccountId))
			return false;
		OpAccountId castOther = (OpAccountId) other;

		return ((this.getDomainNm() == castOther.getDomainNm()) || (this
				.getDomainNm() != null && castOther.getDomainNm() != null && this
				.getDomainNm().equals(castOther.getDomainNm())))
				&& ((this.getPersonId() == castOther.getPersonId()) || (this
						.getPersonId() != null
						&& castOther.getPersonId() != null && this
						.getPersonId().equals(castOther.getPersonId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getDomainNm() == null ? 0 : this.getDomainNm().hashCode());
		result = 37 * result
				+ (getPersonId() == null ? 0 : this.getPersonId().hashCode());
		return result;
	}

}