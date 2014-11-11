package com.readersdigest.onepass.db;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Bundle entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "bundle", schema = "dbo", catalog = "registration")
public class Bundle implements java.io.Serializable {

	// Fields

	private Integer bundleId;
	private Application application;
	private String bundleName;
	private String description;
	private Double price;
	private Set<MemberBundle> memberBundles = new HashSet<MemberBundle>(0);
	
	// Constructors

	/** default constructor */
	public Bundle() {
	}

	/** minimal constructor */
	public Bundle(Integer bundleId, Application application, String bundleName,
			String description) {
		this.bundleId = bundleId;
		this.application = application;
		this.bundleName = bundleName;
		this.description = description;
	}

	/** full constructor */
	public Bundle(Integer bundleId, Application application, String bundleName,
			String description, Double price,
			Set<MemberBundle> memberBundles) {
		this.bundleId = bundleId;
		this.application = application;
		this.bundleName = bundleName;
		this.description = description;
		this.price = price;
		this.memberBundles = memberBundles;	}

	// Property accessors
	@Id
	@Column(name = "bundle_id", unique = true, nullable = false)
	public Integer getBundleId() {
		return this.bundleId;
	}

	public void setBundleId(Integer bundleId) {
		this.bundleId = bundleId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "application_id", nullable = false)
	public Application getApplication() {
		return this.application;
	}

	public void setApplication(Application application) {
		this.application = application;
	}

	@Column(name = "bundle_name", nullable = false)
	public String getBundleName() {
		return this.bundleName;
	}

	public void setBundleName(String bundleName) {
		this.bundleName = bundleName;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "price", scale = 4)
	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	
	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "bundle")
	public Set<MemberBundle> getMemberBundles() {
		return this.memberBundles;
	}

	public void setMemberBundles(Set<MemberBundle> memberBundles) {
		this.memberBundles = memberBundles;
	}

	

}