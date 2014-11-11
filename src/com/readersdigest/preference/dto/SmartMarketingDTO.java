package com.readersdigest.preference.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "smartMarketingData")
public class SmartMarketingDTO {
	
	@XmlElement
	public List<SmartMarketingDetailsDTO> smartMarketingList;
	
}
