package com.readersdigest.onepass.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * OpPreference entity. @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */
@Entity
@Table(name = "OP_PREFERENCE", schema = "dbo", catalog = "registration")
public class OpPreference extends AbstractOpPreference implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public OpPreference() {
	}

	/** full constructor */
	public OpPreference(OpPreferenceId id,
			OpPreferenceDetail opPreferenceDetail, OpAccount opAccount,
			Boolean flag) {
		super(id, opPreferenceDetail, opAccount, flag);
	}

}
