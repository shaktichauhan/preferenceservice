package com.cds.global.api;

import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Element;

import com.cds.global.common.Constants;

public class Entitlements implements Constants {
	
	protected HashSet<String> issues = null; // returned from DOMS as customer_id
	protected String accountNumber = null;
	
	public HashSet<String> getIssues() {
		return issues;
	}


	public void setIssues(HashSet<String> issues) {
		this.issues = issues;
	}


	public String getAccountNumber() {
		return accountNumber;
	}


	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}


	public Entitlements(){}
	
		
	/**
	 * Checks to make sure all required fields are present for a Customer lookup
	 * function.  There must be either an Account Number or Email Address present.
	 * 
	 * @param wsg
	 * @param wsgResponse
	 * @return boolean
	 */
	public boolean validateLookupReadiness(WSG wsg, WSGResponse wsgResponse) {
		if (this.getAccountNumber() == null || this.getAccountNumber().length() < 1) {
			//No Account Number for Lookup, check email address
			wsgResponse.addErrorMessage("There is no Account Number or Email Address set for this customer.  Lookup is not possible.");
			wsgResponse.setSuccess(false);
		} else {
			wsg.setUrl("/entitlements/" + Constants.PRODUCT_ID_REPLACE_VALUE + "/" + this.getAccountNumber() + "?");
		}
		//
		return wsgResponse.isSuccess();
	}
	
	/**
	 * Populate this object from a List of Customer nodes.
	 * 
	 * @param nodes
	 */
	@SuppressWarnings("unchecked")
	public void populateFromXmlNode(List<Element> nodes) {
		Element entitlementElement = null;
		issues = new HashSet<String>();
	
		for (Iterator<Element> iter = nodes.iterator(); iter.hasNext(); ) {
			
			entitlementElement = iter.next();
			issues.add(entitlementElement.getStringValue());
		}
		
		setIssues(issues);
	}
	
	
}
