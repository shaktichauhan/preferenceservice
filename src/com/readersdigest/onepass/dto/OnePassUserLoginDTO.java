package com.readersdigest.onepass.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class OnePassUserLoginDTO.
 *
 * @author shsingh
 */
@XmlRootElement(name = "onePassUserLogin")
@XmlAccessorType(XmlAccessType.FIELD)
public class OnePassUserLoginDTO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The email address. */
    @XmlElement
    public String emailAddress;

    /** The password. */
    @XmlElement
    public String password;

}
