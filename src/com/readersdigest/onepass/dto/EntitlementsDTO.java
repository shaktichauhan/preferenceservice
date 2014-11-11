package com.readersdigest.onepass.dto;

import java.io.Serializable;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

// TODO: Auto-generated Javadoc
/**
 * The Class EntitlementsDTO.
 *
 * @author shsingh
 */
@XmlRootElement(name = "entitlements")

@XmlAccessorType(XmlAccessType.FIELD)
public class EntitlementsDTO implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The token. */
    @XmlElement
    public List<String> productId;
    

}
