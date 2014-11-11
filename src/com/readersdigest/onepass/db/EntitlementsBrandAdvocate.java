package com.readersdigest.onepass.db;

import java.sql.Timestamp;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


// TODO: Auto-generated Javadoc
/**
 * The Class EntitlementsBrandAdvocate.
 */
@Entity
@Table(name = "entitlements_advocate", schema = "dbo", catalog = "registration")
public class EntitlementsBrandAdvocate implements java.io.Serializable {

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;


	/** The product id. */
	private String productId;

	/** The active. */
	private String active;
	
	/** The brand. */
	private String brand;

	/** The create date. */
	private Timestamp createDate;

	/**
	 *  default constructor.
	 */
	public EntitlementsBrandAdvocate() {
	}

	/**
	 * Gets the product id.
	 *
	 * @return the product id
	 */
	@Id
	@Column(name = "product_id", nullable = false)
	public String getProductId() {
		return this.productId;
	}

	/**
	 * Sets the product id.
	 *
	 * @param productId the new product id
	 */
	public void setProductId(String productId) {
		this.productId = productId;
	}

	/**
	 * Gets the active.
	 *
	 * @return the active
	 */
	@Id
	@Column(name = "active")
	public String getActive() {
		return active;
	}

	/**
	 * Sets the active.
	 *
	 * @param active the new active
	 */
	public void setActive(String active) {
		this.active = active;
	}
	
	
	/**
	 * Gets the brand.
	 *
	 * @return the brand
	 */
	@Id
	@Column(name = "brand", nullable = false)
	public String getBrand() {
		return brand;
	}

	/**
	 * Sets the brand.
	 *
	 * @param brand the new brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	
	/**
	 * Gets the creates the date.
	 *
	 * @return the creates the date
	 */
	@Column(name = "create_date", length = 23)
    public Timestamp getCreateDate() {
        return this.createDate;
    }

    /**
     * Sets the creates the date.
     *
     * @param createDate the new creates the date
     */
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

}