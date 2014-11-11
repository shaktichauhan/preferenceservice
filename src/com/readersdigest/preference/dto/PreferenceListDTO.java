package com.readersdigest.preference.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author shsingh
 *
 */
@XmlRootElement(name="preference")
@XmlAccessorType(XmlAccessType.FIELD)
public class PreferenceListDTO {
	@XmlElement
	public String preference_id;
	
	@XmlElement
	public String optIn;

}

