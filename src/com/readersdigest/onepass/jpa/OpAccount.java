package com.readersdigest.onepass.jpa;

import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * OpAccount entity. @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */
@Entity
@Table(name = "OP_ACCOUNT", schema = "dbo", catalog = "registration")
public class OpAccount extends AbstractOpAccount implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public OpAccount() {
	}

	/** minimal constructor */
	public OpAccount(OpAccountId id, OpPerson opPerson) {
		super(id, opPerson);
	}

	/** full constructor */
	public OpAccount(OpAccountId id, OpPerson opPerson, String password,
			Set<OpPreference> opPreferences) {
		super(id, opPerson, password, opPreferences);
	}

}
