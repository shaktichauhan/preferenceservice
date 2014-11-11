package com.readersdigest.sweepapi.db;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the SweepsPrize database table.
 * 
 */
@Entity
public class SweepsPrize implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sp_id")
	private int spId;

	private String active;

	@Column(name="create_date")
	private Timestamp createDate;

	private String description;

	@Column(name="end_date")
	private Timestamp endDate;

	@Column(name="modify_date")
	private Timestamp modifyDate;

	private String signature;

	@Column(name="start_date")
	private Timestamp startDate;

	@Column(name="sweeps_location")
	private String sweepsLocation;

	public SweepsPrize() {
	}

	public int getSpId() {
		return this.spId;
	}

	public void setSpId(int spId) {
		this.spId = spId;
	}

	public String getActive() {
		return this.active;
	}

	public void setActive(String active) {
		this.active = active;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Timestamp getEndDate() {
		return this.endDate;
	}

	public void setEndDate(Timestamp endDate) {
		this.endDate = endDate;
	}

	public Timestamp getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public Timestamp getStartDate() {
		return this.startDate;
	}

	public void setStartDate(Timestamp startDate) {
		this.startDate = startDate;
	}

	public String getSweepsLocation() {
		return this.sweepsLocation;
	}

	public void setSweepsLocation(String sweepsLocation) {
		this.sweepsLocation = sweepsLocation;
	}

}