package com.readersdigest.onepass.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OpEmailId entity. @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */
@Embeddable
public class OpEmailId implements java.io.Serializable {

	// Fields

	private String email;
	private Integer personId;

	// Constructors

	/** default constructor */
	public OpEmailId() {
	}

	/** full constructor */
	public OpEmailId(String email, Integer personId) {
		this.email = email;
		this.personId = personId;
	}

	// Property accessors

	@Column(name = "EMAIL", nullable = false)
	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
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
		if (!(other instanceof OpEmailId))
			return false;
		OpEmailId castOther = (OpEmailId) other;

		return ((this.getEmail() == castOther.getEmail()) || (this.getEmail() != null
				&& castOther.getEmail() != null && this.getEmail().equals(
				castOther.getEmail())))
				&& ((this.getPersonId() == castOther.getPersonId()) || (this
						.getPersonId() != null
						&& castOther.getPersonId() != null && this
						.getPersonId().equals(castOther.getPersonId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getEmail() == null ? 0 : this.getEmail().hashCode());
		result = 37 * result
				+ (getPersonId() == null ? 0 : this.getPersonId().hashCode());
		return result;
	}

}