package com.readersdigest.onepass.jpa;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * OpPreferenceDetail entity. @author Wilson Soethe Cursino -
 * wilson.cursino@rd.com
 */
@Entity
@Table(name = "OP_PREFERENCE_DETAIL", schema = "dbo", catalog = "registration")
public class OpPreferenceDetail extends AbstractOpPreferenceDetail implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public OpPreferenceDetail() {
	}

	/** minimal constructor */
	public OpPreferenceDetail(String preferenceId) {
		super(preferenceId);
	}

	/** full constructor */
	public OpPreferenceDetail(String preferenceId, String description,
			Set<OpPreference> opPreferences) {
		super(preferenceId, description, opPreferences);
	}

}
