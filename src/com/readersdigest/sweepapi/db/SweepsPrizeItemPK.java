package com.readersdigest.sweepapi.db;

import java.io.Serializable;
import javax.persistence.*;

/**
 * The primary key class for the SweepsPrizeItem database table.
 * 
 */
@Embeddable
public class SweepsPrizeItemPK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="sp_id")
	private int spId;

	@Column(name="sp_item_id")
	private int spItemId;

	public SweepsPrizeItemPK() {
	}
	public int getSpId() {
		return this.spId;
	}
	public void setSpId(int spId) {
		this.spId = spId;
	}
	public int getSpItemId() {
		return this.spItemId;
	}
	public void setSpItemId(int spItemId) {
		this.spItemId = spItemId;
	}

	public boolean equals(Object other) {
		if (this == other) {
			return true;
		}
		if (!(other instanceof SweepsPrizeItemPK)) {
			return false;
		}
		SweepsPrizeItemPK castOther = (SweepsPrizeItemPK)other;
		return 
			(this.spId == castOther.spId)
			&& (this.spItemId == castOther.spItemId);
	}

	public int hashCode() {
		final int prime = 31;
		int hash = 17;
		hash = hash * prime + this.spId;
		hash = hash * prime + this.spItemId;
		
		return hash;
	}
}