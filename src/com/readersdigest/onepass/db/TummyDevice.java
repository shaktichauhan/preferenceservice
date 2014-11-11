package com.readersdigest.onepass.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * TummyDevice entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tummy_device", schema = "dbo", catalog = "registration")
public class TummyDevice implements java.io.Serializable {

	// Fields

	private Integer tummyDeviceId;
	private MemberOnePassInfo memberOnePassInfo;
	private String deviceId;

	// Constructors

	/** default constructor */
	public TummyDevice() {
	}

	/** minimal constructor */
	public TummyDevice(Integer tummyDeviceId,
	        MemberOnePassInfo memberOnePassInfo) {
		this.tummyDeviceId = tummyDeviceId;
		this.memberOnePassInfo = memberOnePassInfo;
	}

	/** full constructor */
	public TummyDevice(Integer tummyDeviceId,
			MemberOnePassInfo memberOnePassInfo, String deviceId) {
		this.tummyDeviceId = tummyDeviceId;
		this.memberOnePassInfo = memberOnePassInfo;
		this.deviceId = deviceId;
	}

	// Property accessors
	@Id
	@Column(name = "tummy_device_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getTummyDeviceId() {
		return this.tummyDeviceId;
	}

	public void setTummyDeviceId(Integer tummyDeviceId) {
		this.tummyDeviceId = tummyDeviceId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_onepass_info_id", nullable = false)
	public MemberOnePassInfo getMemberOnePassInfo() {
		return this.memberOnePassInfo;
	}

	public void setMemberOnePassInfo(MemberOnePassInfo memberOnePassInfo) {
		this.memberOnePassInfo = memberOnePassInfo;
	}

	@Column(name = "device_id")
	public String getDeviceId() {
		return this.deviceId;
	}

	public void setDeviceId(String deviceId) {
		this.deviceId = deviceId;
	}

}