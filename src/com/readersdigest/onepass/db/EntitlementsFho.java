package com.readersdigest.onepass.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EntitlementsFho entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "entitlements_fho", schema = "dbo", catalog = "registration")
public class EntitlementsFho implements java.io.Serializable {

	// Fields

	private String productId;

	// Constructors

	/** default constructor */
	public EntitlementsFho() {
	}

	/** full constructor */
	public EntitlementsFho(String productId) {
		this.productId = productId;
	}

	// Property accessors
	@Id
	@Column(name = "product_id", nullable = false)
	public String getProductId() {
		return this.productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

}