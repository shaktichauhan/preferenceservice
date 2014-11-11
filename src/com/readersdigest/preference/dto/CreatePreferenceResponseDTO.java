package com.readersdigest.preference.dto;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "preferenceResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreatePreferenceResponseDTO extends BaseDTO {

	@XmlElement
	public String email;

	@XmlElement
	public String epid;

	@XmlElement
	public String responseCode;

	@XmlElement
	public String responseMessage;

	@XmlElement
	public List<PreferenceListDTO> preference;

}
