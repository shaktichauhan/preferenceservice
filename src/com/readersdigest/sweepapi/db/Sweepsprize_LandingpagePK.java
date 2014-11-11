package com.readersdigest.sweepapi.db;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the Sweepsprize_Landingpage database table.
 * 
 */
@Embeddable
public class Sweepsprize_LandingpagePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="slp_id")
	private int slpId;

	@Column(name="sp_id")
	private int spId;

	public Sweepsprize_LandingpagePK() {
	}
	public int getSlpId() {
		return this.slpId;
	}
	public void setSlpId(int slpId) {
		this.slpId = slpId;
	}
	public int getSpId() {
		return this.spId;
	}
	public void setSpId(int spId) {
		this.spId = spId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof Sweepsprize_LandingpagePK)) {
			return false;
		}
		Sweepsprize_LandingpagePK castOther = (Sweepsprize_LandingpagePK)other;
		return 
			(this.slpId == castOther.slpId)
			&& (this.spId == castOther.spId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.slpId;
		hash = hash * prime + this.spId;
		
		return hash;
	}
}