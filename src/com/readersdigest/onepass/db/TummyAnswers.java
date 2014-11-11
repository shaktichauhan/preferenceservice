package com.readersdigest.onepass.db;

import java.sql.Timestamp;

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
 * TummyAnswers entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tummy_answers", schema = "dbo", catalog = "registration")
public class TummyAnswers implements java.io.Serializable {

    private static final long serialVersionUID = 1L;
    
    private Integer tummyAnswerId;
	private MemberOnePassTummy memberOnePassTummy;
	private Integer questionId;
	private String answer;
	private Timestamp createDate;

	// Constructors

	/** default constructor */
	public TummyAnswers() {
	}

	/** full constructor */
	public TummyAnswers(MemberOnePassTummy memberOnePassTummy, Integer questionId,
			String answer, Timestamp createDate) {
		this.memberOnePassTummy = memberOnePassTummy;
		this.questionId = questionId;
		this.answer = answer;
		this.createDate = createDate;
	}

	// Property accessors
	@Id
	@Column(name = "tummy_answer_id", unique = true, nullable = false)
	@GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getTummyAnswerId() {
		return this.tummyAnswerId;
	}

	public void setTummyAnswerId(Integer tummyAnswerId) {
		this.tummyAnswerId = tummyAnswerId;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "member_OnePass_tummy_id", nullable = false)
	public MemberOnePassTummy getMemberOnePassTummy() {
		return this.memberOnePassTummy;
	}

	public void setMemberOnePassTummy(MemberOnePassTummy memberOnePassTummy) {
		this.memberOnePassTummy = memberOnePassTummy;
	}

	@Column(name = "question_id", nullable = false)
	public Integer getQuestionId() {
		return this.questionId;
	}

	public void setQuestionId(Integer questionId) {
		this.questionId = questionId;
	}

	@Column(name = "answer")
	public String getAnswer() {
		return this.answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	@Column(name = "create_date", length = 23, nullable = false)
	public Timestamp getCreateDate() {
		return this.createDate;
	}

	public void setCreateDate(Timestamp createDate) {
		this.createDate = createDate;
	}

}