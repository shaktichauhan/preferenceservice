package com.readersdigest.onepass.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class EmailDTO.
 *
 * @author shsingh DTO EmailDTO used to contains the
 * parsed xml data in java object
 */

@XmlRootElement(name = "email")
@XmlAccessorType(XmlAccessType.FIELD)
public class EmailDTO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The email address. */
    @XmlElement
    public String emailAddress;

    /** The confirm email address. */
    @XmlElement
    public String confirmEmailAddress;

    /** The password. */
    @XmlElement
    public String password;

    /** The confirm password. */
    @XmlElement
    public String confirmPassword;

    /** The new email address. */
    @XmlElement
    public String newEmailAddress;
    
    /** The account Number. */
    @XmlElement
    public String accountNumber;

    /** The primary. */
    @XmlElement
    public boolean primary;
}
