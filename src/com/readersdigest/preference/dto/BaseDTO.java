package com.readersdigest.preference.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author shsingh
 *
 */

@XmlRootElement(name = "base")
@XmlAccessorType(XmlAccessType.FIELD)
public class BaseDTO implements Serializable {

	@XmlElement
	public Long id;

	@XmlElement
	public Integer version;

}
