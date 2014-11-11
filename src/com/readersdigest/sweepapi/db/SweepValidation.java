package com.readersdigest.sweepapi.db;

import java.sql.Timestamp;

// TODO: Auto-generated Javadoc
/**
 * The Class SweepValidation.
 */
public class SweepValidation {

	/** The sep active. */
	private String sepActive;
	
	/** The slp active. */
	private String slpActive;
	
	/** The sp active. */
	private String spActive;
	
	/** The slp online. */
	private String slpOnline;
	
	/** The slp landing path. */
	private String slpLandingPath;
	
	/** The sp start date. */
	private Timestamp spStartDate;
	
	/** The sp end date. */
	private Timestamp spEndDate;
	
	/** The slp end date. */
	private Timestamp slpEndDate;
	
	/** The sp id. */
	private int spId;

	/**
	 * Gets the sep active.
	 *
	 * @return the sep active
	 */
	public String getSepActive() {
		return sepActive;
	}

	/**
	 * Sets the sep active.
	 *
	 * @param sepActive the new sep active
	 */
	public void setSepActive(String sepActive) {
		this.sepActive = sepActive;
	}

	/**
	 * Gets the slp active.
	 *
	 * @return the slp active
	 */
	public String getSlpActive() {
		return slpActive;
	}

	/**
	 * Sets the slp active.
	 *
	 * @param slpActive the new slp active
	 */
	public void setSlpActive(String slpActive) {
		this.slpActive = slpActive;
	}

	/**
	 * Gets the sp active.
	 *
	 * @return the sp active
	 */
	public String getSpActive() {
		return spActive;
	}

	/**
	 * Sets the sp active.
	 *
	 * @param spActive the new sp active
	 */
	public void setSpActive(String spActive) {
		this.spActive = spActive;
	}

	/**
	 * Gets the slp online.
	 *
	 * @return the slp online
	 */
	public String getSlpOnline() {
		return slpOnline;
	}

	/**
	 * Sets the slp online.
	 *
	 * @param slpOnline the new slp online
	 */
	public void setSlpOnline(String slpOnline) {
		this.slpOnline = slpOnline;
	}

	/**
	 * Gets the slp landing path.
	 *
	 * @return the slp landing path
	 */
	public String getSlpLandingPath() {
		return slpLandingPath;
	}

	/**
	 * Sets the slp landing path.
	 *
	 * @param slpLandingPath the new slp landing path
	 */
	public void setSlpLandingPath(String slpLandingPath) {
		this.slpLandingPath = slpLandingPath;
	}

	/**
	 * Gets the sp start date.
	 *
	 * @return the sp start date
	 */
	public Timestamp getSpStartDate() {
		return spStartDate;
	}

	/**
	 * Sets the sp start date.
	 *
	 * @param spStartDate the new sp start date
	 */
	public void setSpStartDate(Timestamp spStartDate) {
		this.spStartDate = spStartDate;
	}

	/**
	 * Gets the sp end date.
	 *
	 * @return the sp end date
	 */
	public Timestamp getSpEndDate() {
		return spEndDate;
	}

	/**
	 * Sets the sp end date.
	 *
	 * @param spEndDate the new sp end date
	 */
	public void setSpEndDate(Timestamp spEndDate) {
		this.spEndDate = spEndDate;
	}

	/**
	 * Gets the slp end date.
	 *
	 * @return the slp end date
	 */
	public Timestamp getSlpEndDate() {
		return slpEndDate;
	}

	/**
	 * Sets the slp end date.
	 *
	 * @param slpEndDate the new slp end date
	 */
	public void setSlpEndDate(Timestamp slpEndDate) {
		this.slpEndDate = slpEndDate;
	}

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
	 * Validate request.
	 *
	 * @param sweepVal the sweep val
	 * @return true, if successful
	 */
	public boolean validateRequest(SweepValidation sweepVal) {
		if("Y".equalsIgnoreCase(sweepVal.getSepActive()) &&  "Y".equalsIgnoreCase(sweepVal.getSpActive())
				&& "Y".equalsIgnoreCase(sweepVal.getSlpActive()) && "Y".equalsIgnoreCase(sweepVal.getSlpOnline())) {
			Timestamp currentTime = new Timestamp(System.currentTimeMillis());
			System.out.println("\n\n currentTime.compareTo(sweepVal.getSpStartDate()) :" + currentTime.compareTo(sweepVal.getSpStartDate()));
			System.out.println("\n\n currentTime.compareTo(sweepVal.getSpEndDate()) :" + currentTime.compareTo(sweepVal.getSpEndDate()));
			
			if(currentTime.compareTo(sweepVal.getSpStartDate()) >=0
					&& currentTime.compareTo(sweepVal.getSpEndDate()) <=0) {
				return true;
			} else{
				return false;
			}
			
		} else {
			return false;
		}
	}
	
	
}
