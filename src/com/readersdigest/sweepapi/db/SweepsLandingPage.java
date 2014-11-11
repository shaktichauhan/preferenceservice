package com.readersdigest.sweepapi.db;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the SweepsLandingPage database table.
 * 
 */
@Entity
public class SweepsLandingPage implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="slp_id")
	private int slpId;

	private String active;

	@Column(name="create_date")
	private Timestamp createDate;

	private String description;

	@Column(name="end_date")
	private Timestamp endDate;

	@Column(name="landing_path")
	private String landingPath;

	@Column(name="modify_date")
	private Timestamp modifyDate;

	private String online;

	private String signature;

	public SweepsLandingPage() {
	}

	public int getSlpId() {
		return this.slpId;
	}

	public void setSlpId(int slpId) {
		this.slpId = slpId;
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

	public String getLandingPath() {
		return this.landingPath;
	}

	public void setLandingPath(String landingPath) {
		this.landingPath = landingPath;
	}

	public Timestamp getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getOnline() {
		return this.online;
	}

	public void setOnline(String online) {
		this.online = online;
	}

	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

}