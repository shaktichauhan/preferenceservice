package com.readersdigest.onepass.db;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * MemberOnePassTummy entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "member_OnePass_tummy", schema = "dbo", catalog = "registration")
public class MemberOnePassTummy implements java.io.Serializable {

	// Fields

	private Integer memberOnePassTummyId;
	private MemberOnePassInfo memberOnePassInfo;
	private String weight;
	private Timestamp createDate;
	private Set<TummyAnswers> tummyAnswerses = new HashSet<TummyAnswers>(0);

	// Property accessors
	@Id
	@Column(name = "member_OnePass_tummy_id", unique = true, nullable = false)
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public Integer getMemberOnePassTummyId() {
		return this.memberOnePassTummyId;
	}

	public void setMemberOnePassTummyId(Integer memberOnePassTummyId) {
		this.memberOnePassTummyId = memberOnePassTummyId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_OnePass_info_id", nullable = false)
	public MemberOnePassInfo getMemberOnePassInfo() {
		return this.memberOnePassInfo;
	}

	public void setMemberOnePassInfo(MemberOnePassInfo memberOnePassInfo) {
		this.memberOnePassInfo = memberOnePassInfo;
	}

	@Column(name = "weight")
	public String getWeight() {
		return this.weight;
	}

	public void setWeight(String weight) {
		this.weight = weight;
	}

	
	@Column(name = "create_date", length = 23)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "memberOnePassTummy")
	public Set<TummyAnswers> getTummyAnswerses() {
		return this.tummyAnswerses;
	}

	public void setTummyAnswerses(Set<TummyAnswers> tummyAnswerses) {
		this.tummyAnswerses = tummyAnswerses;
	}

}