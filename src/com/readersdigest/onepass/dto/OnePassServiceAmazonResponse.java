package com.readersdigest.onepass.dto;

import java.io.Serializable;
import java.util.List;

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
@XmlRootElement(name = "onePassServiceResponse")

@XmlAccessorType(XmlAccessType.FIELD)
public class OnePassServiceAmazonResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The accountNumber. */
    @XmlElement
    public String accountNumber;
    
    /** The http response code. */
    @XmlAttribute
    public String httpResponseCode;
    
    /** The editCode. */
    @XmlElement
    public String editCode;
    
    /** The emailAddress. */
    @XmlElement
    public String emailAddress;
           
    /** The status. */
    @XmlElement
    public String status;
    
    /** The detailMessage. */
    @XmlElement
    public List<String> detailMessage;
    
    /** The serviceSubscriptionStatus */
    @XmlElement
    public String serviceSubscriptionStatus;
    
    /** The serviceSubscriptionDescription */
    @XmlElement
    public String serviceSubscriptionDescription;
    
      
    /** The entitlements. */
    @XmlElement
    public EntitlementsDTO entitlements;

}
