package com.readersdigest.onepass.db;

import java.sql.Timestamp;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * MemberBundle entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "member_bundle", schema = "dbo", catalog = "registration")
public class MemberBundle implements java.io.Serializable {

	// Fields

	private MemberBundleId id;
	private MemberStatus memberStatus;
	private Member member;
	private Bundle bundle;
	private Timestamp createDate;
	private Timestamp updateDate;
	private Timestamp expiryDate;
	private String autoRenew;

	// Constructors

	/** default constructor */
	public MemberBundle() {
	}

	/** minimal constructor */
	public MemberBundle(MemberBundleId id, MemberStatus memberStatus,
			Member member, Bundle bundle, Timestamp createDate, String autoRenew) {
		this.id = id;
		this.memberStatus = memberStatus;
		this.member = member;
		this.bundle = bundle;
		this.createDate = createDate;
		this.autoRenew = autoRenew;
	}

	/** full constructor */
	public MemberBundle(MemberBundleId id, MemberStatus memberStatus,
			Member member, Bundle bundle, Timestamp createDate,
			Timestamp updateDate, Timestamp expiryDate, String autoRenew) {
		this.id = id;
		this.memberStatus = memberStatus;
		this.member = member;
		this.bundle = bundle;
		this.createDate = createDate;
		this.updateDate = updateDate;
		this.expiryDate = expiryDate;
		this.autoRenew = autoRenew;
	}

	// Property accessors
	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "memberId", column = @Column(name = "member_id", nullable = false)),
			@AttributeOverride(name = "bundleId", column = @Column(name = "bundle_id", nullable = false)) })
	public MemberBundleId getId() {
		return this.id;
	}

	public void setId(MemberBundleId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_status_id", nullable = false)
	public MemberStatus getMemberStatus() {
		return this.memberStatus;
	}

	public void setMemberStatus(MemberStatus memberStatus) {
		this.memberStatus = memberStatus;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_id", nullable = false, insertable = false, updatable = false)
	public Member getMember() {
		return this.member;
	}

	public void setMember(Member member) {
		this.member = member;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "bundle_id", nullable = false, insertable = false, updatable = false)
	public Bundle getBundle() {
		return this.bundle;
	}

	public void setBundle(Bundle bundle) {
		this.bundle = bundle;
	}

	@Column(name = "create_date", nullable = false, length = 23)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@Column(name = "update_date", length = 23)
	public Timestamp getUpdateDate() {
		return this.updateDate;
	}

	public void setUpdateDate(Timestamp updateDate) {
		this.updateDate = updateDate;
	}

	@Column(name = "expiry_date", length = 23)
	public Timestamp getExpiryDate() {
		return this.expiryDate;
	}

	public void setExpiryDate(Timestamp expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Column(name = "auto_renew", nullable = false, length = 1)
	public String getAutoRenew() {
		return this.autoRenew;
	}

	public void setAutoRenew(String autoRenew) {
		this.autoRenew = autoRenew;
	}

}