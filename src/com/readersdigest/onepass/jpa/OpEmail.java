package com.readersdigest.onepass.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * OpEmail entity. @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */
@Entity
@Table(name = "OP_EMAIL", schema = "dbo", catalog = "registration")
public class OpEmail extends AbstractOpEmail implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OpEmail() {
	}

	/** minimal constructor */
	public OpEmail(OpEmailId id, OpPerson opPerson) {
		super(id, opPerson);
	}

	/** full constructor */
	public OpEmail(OpEmailId id, OpPerson opPerson, Boolean primaryFlag) {
		super(id, opPerson, primaryFlag);
	}

}
