package com.readersdigest.onepass.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class OnePassServiceAdobeEntitledVerifyResponse.
 *
 * @author shsingh
 */
@XmlRootElement(name = "result")

@XmlAccessorType(XmlAccessType.FIELD)
public class OnePassServiceAdobeEntitledVerifyResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The token. */
    @XmlElement
    public String authToken;
    
    /** The http response code. */
    @XmlAttribute
    public String httpResponseCode;
    
    /** The entitled. */
    @XmlElement
    public boolean entitled;
    
}
