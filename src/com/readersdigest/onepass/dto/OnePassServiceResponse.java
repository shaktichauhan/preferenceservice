package com.readersdigest.onepass.dto;

import java.io.Serializable;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class OnePassServiceResponse.
 *
 * @author shsingh
 */
@XmlRootElement(name = "onePassServiceResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class OnePassServiceResponse implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The token. */
    @XmlElement
    public String token;

    /** The response text. */
    @XmlElement
    public String responseText;

    /** The status. */
    @XmlElement
    public String status;

    /** The primary email address. */
    @XmlElement
    public String primaryEmailAddress;
    
    /** The reset Password URL. */
    @XmlElement
    public String resetPasswordURL;

}
