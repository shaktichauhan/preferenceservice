package com.readersdigest.sweepapi.db;

import java.io.Serializable;
import javax.persistence.*;
import java.sql.Timestamp;


/**
 * The persistent class for the SweepsEntryPoint database table.
 * 
 */
@Entity
public class SweepsEntryPoint implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sep_id")
	private int sepId;

	private String active;

	@Column(name="create_date")
	private Timestamp createDate;

	private String description;

	@Column(name="modify_date")
	private Timestamp modifyDate;

	@Column(name="sep_freq")
	private String sepFreq;

	private String signature;

	@Column(name="slp_id")
	private int slpId;

	public SweepsEntryPoint() {
	}

	public int getSepId() {
		return this.sepId;
	}

	public void setSepId(int sepId) {
		this.sepId = sepId;
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

	public Timestamp getModifyDate() {
		return this.modifyDate;
	}

	public void setModifyDate(Timestamp modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getSepFreq() {
		return this.sepFreq;
	}

	public void setSepFreq(String sepFreq) {
		this.sepFreq = sepFreq;
	}

	public String getSignature() {
		return this.signature;
	}

	public void setSignature(String signature) {
		this.signature = signature;
	}

	public int getSlpId() {
		return this.slpId;
	}

	public void setSlpId(int slpId) {
		this.slpId = slpId;
	}

}