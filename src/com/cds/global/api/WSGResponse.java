package com.cds.global.api;

import java.util.ArrayList;

import com.cds.global.common.Constants;

public class WSGResponse implements Constants {
	private boolean success = true;
	private boolean sentToOffline = false;
	private String transactionId = null;
	private ArrayList<String> errorMessages = new ArrayList<String>();
	private String dataRecieved = null;
	private ArrayList<Object> objects = new ArrayList<Object>();

	public WSGResponse() {}

	/**
	 * @return the success
	 */
	public boolean isSuccess() {
		return success;
	}

	/**
	 * @param success the success to set
	 */
	public void setSuccess(boolean success) {
		this.success = success;
	}

	/**
	 * @return the transactionId
	 */
	public String getTransactionId() {
		return transactionId;
	}

	/**
	 * @param transactionId the transactionId to set
	 */
	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	/**
	 * @return the errorMessages
	 */
	public ArrayList<String> getErrorMessages() {
		return errorMessages;
	}

	/**
	 * @param erroMessages the errorMessages to set
	 */
	public void addErrorMessage(String errorMessage) {
		this.getErrorMessages().add(errorMessage);
	}

	/**
	 * @return the dataRecieved
	 */
	public String getDataRecieved() {
		return dataRecieved;
	}

	/**
	 * @param dataReceived the dataRecieved to set
	 */
	public void setDataRecieved(String dataRecieved) {
		this.dataRecieved = dataRecieved;
	}

	/**
	 * @return the objects
	 */
	public ArrayList<Object> getObjects() {
		return objects;
	}
	
	public void addObject(Object o) {
		this.objects.add(o);
	}

	/**
	 * @return a boolean as to whether or not the transaction was thus sent to Offline for processing.
	 * Transactions are sent to Offline if they could not be applied real-time for some reason. 
	 * For example, a transaction may be flagged as a possible duplicate, and must therefore 
	 * be sent to Offline for further valication and processing.
	 */
	public boolean isSentToOffline() {
		return sentToOffline;
	}

	/**
	 * @param set a boolean of whether the transaction was sent to Offline or not.
	 */
	public void setSentToOffline(boolean sentToOffline) {
		this.sentToOffline = sentToOffline;
	}
}

