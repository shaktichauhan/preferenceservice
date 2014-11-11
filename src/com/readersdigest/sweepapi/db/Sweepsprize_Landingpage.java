package com.readersdigest.sweepapi.db;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the Sweepsprize_Landingpage database table.
 * 
 */
@Entity
public class Sweepsprize_Landingpage implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private Sweepsprize_LandingpagePK id;

	public Sweepsprize_Landingpage() {
	}

	public Sweepsprize_LandingpagePK getId() {
		return this.id;
	}

	public void setId(Sweepsprize_LandingpagePK id) {
		this.id = id;
	}

}