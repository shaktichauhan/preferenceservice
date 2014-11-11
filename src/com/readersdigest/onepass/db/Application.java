package com.readersdigest.onepass.db;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Application entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "application", schema = "dbo", catalog = "registration")
public class Application implements java.io.Serializable {

	// Fields

	private Integer applicationId;
	private String applicationName;
	private String description;
	private String countryCode;
	private Set<Bundle> bundles = new HashSet<Bundle>(0);
	
	// Constructors

	/** default constructor */
	public Application() {
	}

	/** minimal constructor */
	public Application(Integer applicationId, String applicationName,
			String description) {
		this.applicationId = applicationId;
		this.applicationName = applicationName;
		this.description = description;
	}

	/** full constructor */
	public Application(Integer applicationId, String applicationName,
			String description, String countryCode,
			Set<Bundle> bundles){
			this.applicationId = applicationId;
		this.applicationName = applicationName;
		this.description = description;
		this.countryCode = countryCode;
		this.bundles = bundles;
	}

	// Property accessors
	@Id
	@Column(name = "application_id", unique = true, nullable = false)
	public Integer getApplicationId() {
		return this.applicationId;
	}

	public void setApplicationId(Integer applicationId) {
		this.applicationId = applicationId;
	}

	@Column(name = "application_name", nullable = false)
	public String getApplicationName() {
		return this.applicationName;
	}

	public void setApplicationName(String applicationName) {
		this.applicationName = applicationName;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "country_code")
	public String getCountryCode() {
		return this.countryCode;
	}

	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}

	

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "application")
	public Set<Bundle> getBundles() {
		return this.bundles;
	}

	public void setBundles(Set<Bundle> bundles) {
		this.bundles = bundles;
	}

	
}