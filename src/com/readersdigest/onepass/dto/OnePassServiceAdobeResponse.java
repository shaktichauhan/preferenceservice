package com.readersdigest.onepass.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class OnePassServiceResponse.
 *
 * @author shsingh
 */
@XmlRootElement(name = "result")

@XmlAccessorType(XmlAccessType.FIELD)
public class OnePassServiceAdobeResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The token. */
    @XmlElement
    public String authToken;
    
    /** The http response code. */
    @XmlAttribute
    public String httpResponseCode;
    
    /** The errorCode. */
    @XmlAttribute
    public String errorCode;
    
    /** The emailAddress. */
    @XmlElement
    public String emailAddress;
    
    /** The validEmailAddress. */
    @XmlElement
    public String validEmailAddress;
    
    /** The accountNumber. */
    @XmlElement
    public String accountNumber;
    
    /** The full name. */
    @XmlElement
    public String fullName;
    
    /** The completeAccountSetUp. */
    @XmlElement
    public String completeAccountSetUp;
    
    /** The cdsForgetPassword */
    @XmlElement
    public String cdsForgetPassword;
    
    /** The error */
    @XmlElement
    public String error;
    
      
    /** The entitlements. */
    @XmlElement
    public EntitlementsDTO entitlements;

}
