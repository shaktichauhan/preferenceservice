package com.readersdigest.emailClient;

public class TransactionRecord {
	public String firstName = "";
	public String lastName = "";
	public String email = "";
	public String topic = "";
	public String id = "";
	
	
	public String getRecordAsString()
	{
	return email+"::"+id+"::"+firstName+"::"+lastName+"::"+topic;
	}


	public String getFirstName() {
		return firstName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public String getLastName() {
		return lastName;
	}


	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public String getTopic() {
		return topic;
	}


	public void setTopic(String topic) {
		this.topic = topic;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}
}
