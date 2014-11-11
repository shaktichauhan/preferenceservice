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
 * The Class OnePassTummyUserProfileDTO.
 *
 * @author shsingh DTO OnePassTummyUserProfileDTO used to contains the parsed
 *         xml data in java object
 */
@XmlRootElement(name = "userProfileRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class OnePassTummyUserProfileDTO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The email fields. */
    @XmlElement
    public EmailDTO emailFields;
    
    @XmlElementWrapper(name="surveyFields")
    @XmlElements(@XmlElement(name="field",type=SurveyFieldDTO.class))
    public Set<SurveyFieldDTO> surveyFields;
    
    /** The email fields. */
    @XmlElement
    public String weight;

    /** The account fields. */
    @XmlElement
    public AccountDTO accountFields;

    /** The address fields. */
    @XmlElement
    public AddressDTO addressFields;

}
