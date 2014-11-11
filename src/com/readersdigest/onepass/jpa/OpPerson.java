package com.readersdigest.onepass.jpa;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * OpPerson entity. @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */
@Entity
@Table(name = "OP_PERSON", schema = "dbo", catalog = "registration")
public class OpPerson extends AbstractOpPerson implements java.io.Serializable {

	// Constructors

	/** default constructor */
	public OpPerson() {
	}

	/** minimal constructor */
	public OpPerson(Integer personId) {
		super(personId);
	}

	/** full constructor */
	public OpPerson(String firstNm, String lastNm, Set<OpAccount> opAccounts, Set<OpAddress> opAddresses,
			Set<OpEmail> opEmails) {
		super(firstNm, lastNm, opAccounts, opAddresses, opEmails);
	}

}
