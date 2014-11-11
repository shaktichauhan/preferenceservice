package com.readersdigest.exacttarget.dto;

import java.io.Serializable;

import org.codehaus.jackson.annotate.JsonProperty;

import com.readersdigest.exacttarget.utils.ETVaidationUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class UserRoles.
 *
 * @author shsingh DTO UserRoles used to contains the parsed
 *         JSON data in java object
 */

public class UserRoles implements Serializable {

	 /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The cds serv id. */
    @JsonProperty("CDSServId")
    private String cdsServId;
    
    /** The last update date. */
    @JsonProperty("LastUpdateDate")
    private String lastUpdateDate = ETVaidationUtils.convertJsonDate("0");
    
    /** The role expire date. */
    @JsonProperty("RoleExpireDate")
    private String roleExpireDate = ETVaidationUtils.convertJsonDate("0");;
    
    /** The role id. */
    @JsonProperty("RoleId")
    private String roleId;
   
    /** The role status code. */
    @JsonProperty("RoleStatusCode")
    private String roleStatusCode;

	/**
	 * Gets the cds serv id.
	 *
	 * @return the cds serv id
	 */
	public String getCdsServId() {
		return cdsServId;
	}

	/**
	 * Sets the cds serv id.
	 *
	 * @param cdsServId the new cds serv id
	 */
	public void setCdsServId(String cdsServId) {
		this.cdsServId = cdsServId;
	}

	/**
	 * Gets the last update date.
	 *
	 * @return the last update date
	 */
	public String getLastUpdateDate() {
		return lastUpdateDate;
	}

	/**
	 * Sets the last update date.
	 *
	 * @param lastUpdateDate the new last update date
	 */
	public void setLastUpdateDate(String lastUpdateDate) {
		this.lastUpdateDate = ETVaidationUtils.convertJsonDate(lastUpdateDate);
	}

	/**
	 * Gets the role expire date.
	 *
	 * @return the role expire date
	 */
	public String getRoleExpireDate() {
		return roleExpireDate;
	}

	/**
	 * Sets the role expire date.
	 *
	 * @param roleExpireDate the new role expire date
	 */
	public void setRoleExpireDate(String roleExpireDate) {
		this.roleExpireDate = ETVaidationUtils.convertJsonDate(roleExpireDate);
	}

	/**
	 * Gets the role id.
	 *
	 * @return the role id
	 */
	public String getRoleId() {
		return roleId;
	}

	/**
	 * Sets the role id.
	 *
	 * @param roleId the new role id
	 */
	public void setRoleId(String roleId) {
		this.roleId = roleId;
	}

	/**
	 * Gets the role status code.
	 *
	 * @return the role status code
	 */
	public String getRoleStatusCode() {
		return roleStatusCode;
	}

	/**
	 * Sets the role status code.
	 *
	 * @param roleStatusCode the new role status code
	 */
	public void setRoleStatusCode(String roleStatusCode) {
		this.roleStatusCode = roleStatusCode;
	}
   
}
