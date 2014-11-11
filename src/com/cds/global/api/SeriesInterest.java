package com.cds.global.api;

public class SeriesInterest extends BaseServiceObject {
	protected String interestCode = null;
	protected String InterestCodeDescription = null;
	/**
	 * @return the interestCode
	 */
	public String getInterestCode() {
		return interestCode;
	}
	/**
	 * @param interestCode the interestCode to set
	 */
	public void setInterestCode(String interestCode) {
		this.interestCode = interestCode;
	}
	/**
	 * @return the interestCodeDescription
	 */
	public String getInterestCodeDescription() {
		return InterestCodeDescription;
	}
	/**
	 * @param interestCodeDescription the interestCodeDescription to set
	 */
	public void setInterestCodeDescription(String interestCodeDescription) {
		InterestCodeDescription = interestCodeDescription;
	}
}
