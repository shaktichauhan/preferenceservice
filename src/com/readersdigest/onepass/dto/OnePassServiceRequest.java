package com.readersdigest.onepass.dto;

import java.io.Serializable;
import java.util.Set;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlElements;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class OnePassServiceRequest.
 *
 * @author shsingh
 */
@XmlRootElement(name = "onePassServiceRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class OnePassServiceRequest implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The appId. */
    @XmlElement
    public String appId;
    
    /** The appId. */
    @XmlElement
    public String brandCode;

    /** The accountNumber. */
    @XmlElement
    public String accountNumber;

    /** The zipCode. */
    @XmlElement
    public String zipCode;

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
    
    /** The state. */
    @XmlElement
    public String state;
    
    /** The email address. */
    @XmlElement
    public String emailAddress;
    
    /** The password. */
    @XmlElement
    public String password;
    
   
    

}
