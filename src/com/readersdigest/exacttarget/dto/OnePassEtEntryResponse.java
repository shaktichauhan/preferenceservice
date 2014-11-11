package com.readersdigest.exacttarget.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;


// TODO: Auto-generated Javadoc
/**
 * The Class OnePassSweepEntryResponse.
 *
 * @author Shakti Chauhan - shakti_singh@consultant.rd.com DTO OnePassSweepEntryResponse used to contains the parsed
 *         JSON data in java object
 */

public class OnePassEtEntryResponse implements Serializable {

	 /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The status. */
    @JsonProperty("Status")
    private String status;
    

    /** The response code. */
    @JsonProperty("ResponseCode")
    private String responseCode;
    
    /** The response message. */
    @JsonProperty("ResponseMessage")
    private String responseMessage;
        
    /** The response message. */
    @JsonProperty("errorCode")
    private String errorCode ="0";
    
  
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

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}
   
	
}
