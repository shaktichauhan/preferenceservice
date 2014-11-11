package com.readersdigest.onepass.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="field")
@XmlAccessorType(XmlAccessType.FIELD)
public class SurveyFieldDTO {

	@XmlElement
	public String questionId;
	
	@XmlElement
	public String answer;
	
}
