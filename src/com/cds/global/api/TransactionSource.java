package com.cds.global.api;

public class TransactionSource {
	protected boolean attribute = true;
	protected String value = null;
	protected String key = null;
	/**
	 * @return the attribute
	 */
	public boolean isAttribute() {
		return attribute;
	}
	/**
	 * @param attribute the attribute to set
	 */
	public void setAttribute(boolean attribute) {
		this.attribute = attribute;
	}
	/**
	 * @return the value
	 */
	public String getValue() {
		return value;
	}
	/**
	 * @param value the value to set
	 */
	public void setValue(String value) {
		this.value = value;
	}
	/**
	 * @return the key
	 */
	public String getKey() {
		return key;
	}
	/**
	 * @param key the key to set
	 */
	public void setKey(String key) {
		this.key = key;
	}

}
