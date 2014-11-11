package com.readersdigest.onepass.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class CreateOnePassUserProfileDTO.
 *
 * @author shsingh DTO CreateOnePassUserProfileDTO used to contains the parsed
 *         xml data in java object
 */
@XmlRootElement(name = "userProfileRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class CreateOnePassUserProfileDTO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The email fields. */
    @XmlElement
    public EmailDTO emailFields;

    /** The account fields. */
    @XmlElement
    public AccountDTO accountFields;

    /** The address fields. */
    @XmlElement
    public AddressDTO addressFields;

}
