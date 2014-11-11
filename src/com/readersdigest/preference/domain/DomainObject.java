package com.readersdigest.preference.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author shsingh
 *
 */

public class DomainObject implements Serializable {

	protected Long id;
	protected Date createdOn;
	protected Date updatedOn;
	protected Integer version;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	public Integer getVersion() {
		return version;
	}

	public void setVersion(Integer version) {
		this.version = version;
	}

}
