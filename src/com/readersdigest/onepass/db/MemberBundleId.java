package com.readersdigest.onepass.db;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * MemberBundleId entity. @author MyEclipse Persistence Tools
 */
@Embeddable
public class MemberBundleId implements java.io.Serializable {

	// Fields

	private Integer memberId;
	private Integer bundleId;

	// Constructors

	/** default constructor */
	public MemberBundleId() {
	}

	/** full constructor */
	public MemberBundleId(Integer memberId, Integer bundleId) {
		this.memberId = memberId;
		this.bundleId = bundleId;
	}

	// Property accessors

	@Column(name = "member_id", nullable = false)
	public Integer getMemberId() {
		return this.memberId;
	}

	public void setMemberId(Integer memberId) {
		this.memberId = memberId;
	}

	@Column(name = "bundle_id", nullable = false)
	public Integer getBundleId() {
		return this.bundleId;
	}

	public void setBundleId(Integer bundleId) {
		this.bundleId = bundleId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof MemberBundleId))
			return false;
		MemberBundleId castOther = (MemberBundleId) other;

		return ((this.getMemberId() == castOther.getMemberId()) || (this
				.getMemberId() != null && castOther.getMemberId() != null && this
				.getMemberId().equals(castOther.getMemberId())))
				&& ((this.getBundleId() == castOther.getBundleId()) || (this
						.getBundleId() != null
						&& castOther.getBundleId() != null && this
						.getBundleId().equals(castOther.getBundleId())));
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getMemberId() == null ? 0 : this.getMemberId().hashCode());
		result = 37 * result
				+ (getBundleId() == null ? 0 : this.getBundleId().hashCode());
		return result;
	}

}