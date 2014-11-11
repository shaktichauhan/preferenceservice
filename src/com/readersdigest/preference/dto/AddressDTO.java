package com.readersdigest.preference.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author shsingh
 *
 */

@XmlRootElement(name = "address")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressDTO extends BaseDTO {

	@XmlElement
	public String address1;

	@XmlElement
	public String address2;

	@XmlElement
	public String address3;

	@XmlElement
	public String city;

	@XmlElement
	public String postalCode;

	@XmlElement
	public String countryCode;

}
