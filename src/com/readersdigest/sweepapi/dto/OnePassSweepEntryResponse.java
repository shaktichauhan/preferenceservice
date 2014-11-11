package com.readersdigest.sweepapi.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;


// TODO: Auto-generated Javadoc
/**
 * The Class OnePassSweepEntryResponse.
 *
 * @author shsingh DTO OnePassSweepEntryResponse used to contains the parsed
 *         JSON data in java object
 */

public class OnePassSweepEntryResponse implements Serializable {

	 /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
   
    /** The sp id. */
    @JsonProperty("SpId")
    private int spId;
    
    /** The se id. */
    @JsonProperty("SeId")
    private int seId;
    
    /** The status. */
    @JsonProperty("Status")
    private String status;
    

    /** The response code. */
    @JsonProperty("ResponseCode")
    private String responseCode;
    
    /** The response message. */
    @JsonProperty("ResponseMessage")
    private String responseMessage;
        
    
    /**
     * Gets the sp id.
     *
     * @return the sp id
     */
    public int getSpId() {
		return spId;
	}

	/**
	 * Sets the sp id.
	 *
	 * @param spId the new sp id
	 */
	public void setSpId(int spId) {
		this.spId = spId;
	}

	/**
	 * Gets the status.
	 *
	 * @return the status
	 */
	public String getStatus() {
		return status;
	}

	/**
	 * Sets the status.
	 *
	 * @param status the new status
	 */
	public void setStatus(String status) {
		this.status = status;
	}

	/**
	 * Gets the se id.
	 *
	 * @return the se id
	 */
	public int getSeId() {
		return seId;
	}

	/**
	 * Sets the se id.
	 *
	 * @param seId the new se id
	 */
	public void setSeId(int seId) {
		this.seId = seId;
	}

	/**
	 * Gets the response code.
	 *
	 * @return the response code
	 */
	public String getResponseCode() {
		return responseCode;
	}

	/**
	 * Sets the response code.
	 *
	 * @param responseCode the new response code
	 */
	public void setResponseCode(String responseCode) {
		this.responseCode = responseCode;
	}

	/**
	 * Gets the response message.
	 *
	 * @return the response message
	 */
	public String getResponseMessage() {
		return responseMessage;
	}

	/**
	 * Sets the response message.
	 *
	 * @param responseMessage the new response message
	 */
	public void setResponseMessage(String responseMessage) {
		this.responseMessage = responseMessage;
	}
   
	
}
