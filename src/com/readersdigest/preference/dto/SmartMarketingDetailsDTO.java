package com.readersdigest.preference.dto;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "smartMarketing")
public class SmartMarketingDetailsDTO {

	@XmlElement
	public String emailPropertyId;
	
	@XmlElement
	public String emailPropertyName;
	
	@XmlElement
	public String emailPropertyValue;

	@XmlElement
	public String emailAddress;
	
	
}
