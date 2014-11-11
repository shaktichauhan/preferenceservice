package com.readersdigest.onepass.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OpPreferenceId entity. @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */
@Embeddable
public class OpPreferenceId implements java.io.Serializable {

	// Fields

	private String domainNm;
	private Integer personId;
	private String preferenceId;

	// Constructors

	/** default constructor */
	public OpPreferenceId() {
	}

	/** full constructor */
	public OpPreferenceId(String domainNm, Integer personId, String preferenceId) {
		this.domainNm = domainNm;
		this.personId = personId;
		this.preferenceId = preferenceId;
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

	@Column(name = "PREFERENCE_ID", nullable = false)
	public String getPreferenceId() {
		return this.preferenceId;
	}

	public void setPreferenceId(String preferenceId) {
		this.preferenceId = preferenceId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof OpPreferenceId))
			return false;
		OpPreferenceId castOther = (OpPreferenceId) other;

		return ((this.getDomainNm() == castOther.getDomainNm()) || (this
				.getDomainNm() != null && castOther.getDomainNm() != null && this
				.getDomainNm().equals(castOther.getDomainNm())))
				&& ((this.getPersonId() == castOther.getPersonId()) || (this
						.getPersonId() != null
						&& castOther.getPersonId() != null && this
						.getPersonId().equals(castOther.getPersonId())))
				&& ((this.getPreferenceId() == castOther.getPreferenceId()) || (this
						.getPreferenceId() != null
						&& castOther.getPreferenceId() != null && this
						.getPreferenceId().equals(castOther.getPreferenceId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getDomainNm() == null ? 0 : this.getDomainNm().hashCode());
		result = 37 * result
				+ (getPersonId() == null ? 0 : this.getPersonId().hashCode());
		result = 37
				* result
				+ (getPreferenceId() == null ? 0 : this.getPreferenceId()
						.hashCode());
		return result;
	}

}