package com.readersdigest.exacttarget.dto;

import java.io.Serializable;
import java.util.List;

import org.codehaus.jackson.annotate.JsonProperty;


/**
 * The Class TriggeredSendMail.
 *
 * @author shsingh DTO TriggeredSendMail used to contains the parsed
 *         JSON data in java object
 */

public class TriggeredSendMail implements Serializable {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The email address. */
    @JsonProperty("Email")
    private String emailAddress;
    
    /** The MailingId. */
    @JsonProperty("MailingId")
    private String emailingId;
    
    
	/** The EtBrand. */
    @JsonProperty("EtBrand")
    private String etBrand;
    
    
    /** The PersonalizationParameters. */
    @JsonProperty("PersonalizationParameters")
    private List<PersonalizationParameters> personalizationParameters;
    
    

	/**
     * Gets the email address.
     *
     * @return the email address
     */
    public String getEmailAddress() {
		return emailAddress;
	}

	/**
	 * Sets the email address.
	 *
	 * @param emailAddress the new email address
	 */
	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	

    /**
     * Gets the emailingId id.
     *
     * @return the emailingId id
     */
    public String getEmailingId() {
		return emailingId;
	}

	/**
	 * Sets the emailingId id.
	 *
	 * @param emailingId the new emailingId id
	 */
	public void setEmailingId(String emailingId) {
		this.emailingId = emailingId;
	}

	/**
	 * Gets the et brand.
	 *
	 * @return the et brand
	 */
	public String getEtBrand() {
		return etBrand;
	}

	/**
	 * Sets the et brand.
	 *
	 * @param etBrand the new et brand
	 */
	public void setEtBrand(String etBrand) {
		this.etBrand = etBrand;
	}

	public List<PersonalizationParameters> getPersonalizationParameters() {
		return personalizationParameters;
	}

	public void setPersonalizationParameters(List<PersonalizationParameters> personalizationParameters) {
		this.personalizationParameters = personalizationParameters;
	}

		
}
