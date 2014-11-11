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
 * The Class AccountDTO.
 *
 * @author shsingh
 *
 *         DTO AccountDTO used to contains the parsed xml data in java object
 */

@XmlRootElement(name = "account")
@XmlAccessorType(XmlAccessType.FIELD)
public class AccountDTO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The source id. */
    @XmlElement
    public String sourceId;

    /** The tracking id. */
    @XmlElement
    public String trackingId;
    
    /** The Paid User. */
    @XmlElement
    public String paidUser;
    
    /** The preference fields. */
    @XmlElementWrapper(name = "preferenceFields")
    @XmlElements(@XmlElement(name = "preference", type = PreferenceDTO.class))
    public Set<PreferenceDTO> preferenceFields;
}
