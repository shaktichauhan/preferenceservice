package com.readersdigest.onepass.db;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * MemberStatus entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "member_status", schema = "dbo", catalog = "registration")
public class MemberStatus implements java.io.Serializable {

	// Fields

	private Integer memberStatusId;
	private String memberStatusName;
	private String description;
	private Set<MemberBundle> memberBundles = new HashSet<MemberBundle>(0);

	// Constructors

	/** default constructor */
	public MemberStatus() {
	}

	/** minimal constructor */
	public MemberStatus(Integer memberStatusId, String memberStatusName,
			String description) {
		this.memberStatusId = memberStatusId;
		this.memberStatusName = memberStatusName;
		this.description = description;
	}

	/** full constructor */
	public MemberStatus(Integer memberStatusId, String memberStatusName,
			String description, Set<MemberBundle> memberBundles) {
		this.memberStatusId = memberStatusId;
		this.memberStatusName = memberStatusName;
		this.description = description;
		this.memberBundles = memberBundles;
	}

	// Property accessors
	@Id
	@Column(name = "member_status_id", unique = true, nullable = false)
	public Integer getMemberStatusId() {
		return this.memberStatusId;
	}

	public void setMemberStatusId(Integer memberStatusId) {
		this.memberStatusId = memberStatusId;
	}

	@Column(name = "member_status_name", nullable = false)
	public String getMemberStatusName() {
		return this.memberStatusName;
	}

	public void setMemberStatusName(String memberStatusName) {
		this.memberStatusName = memberStatusName;
	}

	@Column(name = "description", nullable = false)
	public String getDescription() {
		return this.description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "memberStatus")
	public Set<MemberBundle> getMemberBundles() {
		return this.memberBundles;
	}

	public void setMemberBundles(Set<MemberBundle> memberBundles) {
		this.memberBundles = memberBundles;
	}

}