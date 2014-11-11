package com.readersdigest.onepass.dto;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The Class UpdateOnePassUserProfileDTO.
 */
@XmlRootElement(name = "userProfileUpdateRequest")
@XmlAccessorType(XmlAccessType.FIELD)
public class UpdateOnePassUserProfileDTO extends CreateOnePassUserProfileDTO {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    /** The header. */
    @XmlElement
    public HeaderDTO header;

}
