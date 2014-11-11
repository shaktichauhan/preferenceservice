package com.readersdigest.onepass.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;


@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)

public class PersonDTO implements Serializable{
	
	@XmlElement
	public String firstName;
	
	@XmlElement
	public String lastName;
}
