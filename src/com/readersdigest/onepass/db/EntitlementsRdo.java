package com.readersdigest.onepass.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * EntitlementsRdo entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "entitlements_rdo", schema = "dbo", catalog = "registration")
public class EntitlementsRdo implements java.io.Serializable {

	// Fields

	private String productId;

	// Constructors

	/** default constructor */
	public EntitlementsRdo() {
	}

	/** full constructor */
	public EntitlementsRdo(String productId) {
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