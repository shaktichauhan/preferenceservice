package com.readersdigest.onepass.jpa;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * OpAddress entity. @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */
@Entity
@Table(name = "OP_ADDRESS", schema = "dbo", catalog = "registration")
public class OpAddress extends AbstractOpAddress implements
		java.io.Serializable {

	// Constructors

	/** default constructor */
	public OpAddress() {
	}

	/** minimal constructor */
	public OpAddress( OpPerson opPerson) {
		super(opPerson);
	}

	/** full constructor */
	public OpAddress(OpPerson opPerson, String street1,
			String street2, String city, String stateNm, String zip,
			String country, Boolean primaryFlag) {
		super(opPerson, street1, street2, city, stateNm, zip, country,
				primaryFlag);
	}

}
