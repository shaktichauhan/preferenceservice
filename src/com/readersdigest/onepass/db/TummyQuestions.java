package com.readersdigest.onepass.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * TummyQuestions entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "tummy_questions", schema = "dbo", catalog = "registration")
public class TummyQuestions implements java.io.Serializable {

	// Fields

	private Integer tummyQuestionId;
	private String questionDesc;

	// Constructors

	/** default constructor */
	public TummyQuestions() {
	}

	/** full constructor */
	public TummyQuestions(Integer tummyQuestionId, String questionDesc) {
		this.tummyQuestionId = tummyQuestionId;
		this.questionDesc = questionDesc;
	}

	// Property accessors
	@Id
	@Column(name = "tummy_question_id", unique = true, nullable = false)
	public Integer getTummyQuestionId() {
		return this.tummyQuestionId;
	}

	public void setTummyQuestionId(Integer tummyQuestionId) {
		this.tummyQuestionId = tummyQuestionId;
	}

	@Column(name = "question_desc", nullable = false)
	public String getQuestionDesc() {
		return this.questionDesc;
	}

	public void setQuestionDesc(String questionDesc) {
		this.questionDesc = questionDesc;
	}

}