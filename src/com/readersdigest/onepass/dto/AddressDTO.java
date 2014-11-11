package com.readersdigest.onepass.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class AddressDTO.
 *
 * @author shsingh
 */
@XmlRootElement(name = "address")
@XmlAccessorType(XmlAccessType.FIELD)
public class AddressDTO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The first name. */
    @XmlElement
    public String firstName;

    /** The last name. */
    @XmlElement
    public String lastName;

    /** The address1. */
    @XmlElement
    public String address1;

    /** The address2. */
    @XmlElement
    public String address2;

    /** The city. */
    @XmlElement
    public String city;

    /** The state code. */
    @XmlElement
    public String stateCode;

    /** The zip. */
    @XmlElement
    public String zip;

    /** The country code. */
    @XmlElement
    public String countryCode;

    /** The primary. */
    @XmlElement
    public boolean primary;

}
