package com.readersdigest.onepass.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class OnePassTummyServiceResponse.
 *
 * @author shsingh
 */
@XmlRootElement(name = "onePassTummyServiceResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class OnePassTummyServiceResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The paidUser. */
    @XmlElement
    public String paidUser;

    /** The response text. */
    @XmlElement
    public String responseText;       
    
    /** The http response code. */
    @XmlAttribute
    public String httpResponseCode;

    /** The status. */
    @XmlElement
    public String status;

}
