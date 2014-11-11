package com.readersdigest.preference.dto;

import java.math.BigDecimal;
import java.util.Locale;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The main preference object sent from requesting systems.  This is a common interface, so
 * do not break it. ie. existing field names should never be changed or moved.  
 * New fields may be added.
 *  
 * @author shsingh
 *
 */
@XmlRootElement(name="preference")
@XmlAccessorType(XmlAccessType.FIELD)
public class PreferenceDTO extends BaseDTO { 
 
	@XmlElement
	public String sourceId;
	
	@XmlElement
	public String preferenceId;
	
	@XmlElement
	public String trackingId;
	
	@XmlElement
	public String optIn;
	
	@XmlElement
	public String firstName;
	
	@XmlElement
	public String middleName;
	
	@XmlElement
	public String lastName;

	@XmlElement
	public String email;
	
	@XmlElement
	public AddressDTO billingAddress;
	
	@XmlElement
	public String dateOfBirth;
	
	@XmlElement
	public String epid;
	
}
