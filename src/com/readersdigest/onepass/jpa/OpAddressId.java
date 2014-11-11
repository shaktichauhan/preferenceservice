package com.readersdigest.onepass.jpa;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * OpAddressId entity. @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */
@Embeddable
public class OpAddressId implements java.io.Serializable {

	// Fields

	private Integer addressId;
	private Integer personId;

	// Constructors

	/** default constructor */
	public OpAddressId() {
	}

	/** full constructor */
	public OpAddressId(Integer addressId, Integer personId) {
		this.addressId = addressId;
		this.personId = personId;
	}

	// Property accessors

	@Column(name = "ADDRESS_ID", nullable = false)
	public Integer getAddressId() {
		return this.addressId;
	}

	public void setAddressId(Integer addressId) {
		this.addressId = addressId;
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
		if (!(other instanceof OpAddressId))
			return false;
		OpAddressId castOther = (OpAddressId) other;

		return ((this.getAddressId() == castOther.getAddressId()) || (this
				.getAddressId() != null && castOther.getAddressId() != null && this
				.getAddressId().equals(castOther.getAddressId())))
				&& ((this.getPersonId() == castOther.getPersonId()) || (this
						.getPersonId() != null
						&& castOther.getPersonId() != null && this
						.getPersonId().equals(castOther.getPersonId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getAddressId() == null ? 0 : this.getAddressId().hashCode());
		result = 37 * result
				+ (getPersonId() == null ? 0 : this.getPersonId().hashCode());
		return result;
	}

}