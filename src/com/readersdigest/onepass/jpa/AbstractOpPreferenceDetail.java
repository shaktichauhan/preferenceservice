package com.readersdigest.onepass.jpa;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;

/**
 * AbstractOpPreferenceDetail entity provides the base persistence definition of
 * the OpPreferenceDetail entity. @author Wilson Soethe Cursino -
 * wilson.cursino@rd.com
 */
@MappedSuperclass
public abstract class AbstractOpPreferenceDetail implements
		java.io.Serializable {

	// Fields

	private String preferenceId;
	private String description;
	private Set<OpPreference> opPreferences = new HashSet<OpPreference>(0);

	// Constructors

	/** default constructor */
	public AbstractOpPreferenceDetail() {
	}

	/** minimal constructor */
	public AbstractOpPreferenceDetail(String preferenceId) {
		this.preferenceId = preferenceId;
	}

	/** full constructor */
	public AbstractOpPreferenceDetail(String preferenceId, String description,
			Set<OpPreference> opPreferences) {
		this.preferenceId = preferenceId;
		this.description = description;
		this.opPreferences = opPreferences;
	}

	// Property accessors
	@Id
	@Column(name = "PREFERENCE_ID", unique = true, nullable = false)
	public String getPreferenceId() {
		return this.preferenceId;
	}

	public void setPreferenceId(String preferenceId) {
		this.preferenceId = preferenceId;
	}

	@Column(name = "DESCRIPTION")
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "opPreferenceDetail")
	public Set<OpPreference> getOpPreferences() {
		return this.opPreferences;
	}

	public void setOpPreferences(Set<OpPreference> opPreferences) {
		this.opPreferences = opPreferences;
	}

}