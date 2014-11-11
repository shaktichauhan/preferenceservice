package com.readersdigest.sweepapi.db;

import java.io.Serializable;
import javax.persistence.*;

import java.sql.Timestamp;


/**
 * The persistent class for the SweepsEntry database table.
 * 
 */
@Entity
public class SweepsEntry implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE)
	@Column(name="se_id")
	private int seId;

	private String address1;

	private String address2;

	private String city;

	private String comment;

	private String country;

	@Column(name="create_date")
	private Timestamp createDate;

	@Column(name="create_datetime")
	private Timestamp createDatetime;

	private String email;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="opt_status_transaction_id")
	private int optStatusTransactionId;

	private String phone;

	@Column(name="processed",nullable = false)
	private String processed = "N";

	@Column(name="processed_date")
	private Timestamp processedDate;

	@Column(name="remove_me")
	private String removeMe;

	@Column(name="sep_id")
	private int sepId;

	@Column(name="sp_id")
	private int spId;

	@Column(name="sp_item_id")
	private int spItemId;

	private String state;

	@Column(name="tracking_id")
	private String trackingId;

	private String zip;

	public SweepsEntry() {
	}

	public int getSeId() {
		return this.seId;
	}

	public void setSeId(int seId) {
		this.seId = seId;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getComment() {
		return this.comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public String getCountry() {
		return this.country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	public Timestamp getCreateDatetime() {
		return this.createDatetime;
	}

	public void setCreateDatetime(Timestamp createDatetime) {
		this.createDatetime = createDatetime;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstName() {
		return this.firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return this.lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public int getOptStatusTransactionId() {
		return this.optStatusTransactionId;
	}

	public void setOptStatusTransactionId(int optStatusTransactionId) {
		this.optStatusTransactionId = optStatusTransactionId;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getProcessed() {
		return this.processed;
	}

	public void setProcessed(String processed) {
		this.processed = processed;
	}

	public Timestamp getProcessedDate() {
		return this.processedDate;
	}

	public void setProcessedDate(Timestamp processedDate) {
		this.processedDate = processedDate;
	}

	public String getRemoveMe() {
		return this.removeMe;
	}

	public void setRemoveMe(String removeMe) {
		this.removeMe = removeMe;
	}

	public int getSepId() {
		return this.sepId;
	}

	public void setSepId(int sepId) {
		this.sepId = sepId;
	}

	public int getSpId() {
		return this.spId;
	}

	public void setSpId(int spId) {
		this.spId = spId;
	}

	public int getSpItemId() {
		return this.spItemId;
	}

	public void setSpItemId(int spItemId) {
		this.spItemId = spItemId;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getTrackingId() {
		return this.trackingId;
	}

	public void setTrackingId(String trackingId) {
		this.trackingId = trackingId;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

}