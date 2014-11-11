package com.readersdigest.onepass.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class PreferenceDTO.
 * 
 * @author shsingh
 */
@XmlRootElement(name = "preference")
@XmlAccessorType(XmlAccessType.FIELD)
public class PreferenceDTO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The preference id. */
    @XmlElement
    public String preferenceId;

    /** The opt in. */
    @XmlElement
    public boolean optIn;

}
