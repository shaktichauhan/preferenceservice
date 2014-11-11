package com.readersdigest.sweepapi.db;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the SweepsPrizeItem database table.
 * 
 */
@Entity
public class SweepsPrizeItem implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private SweepsPrizeItemPK id;

	private String description;

	public SweepsPrizeItem() {
	}

	public SweepsPrizeItemPK getId() {
		return this.id;
	}

	public void setId(SweepsPrizeItemPK id) {
		this.id = id;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

}