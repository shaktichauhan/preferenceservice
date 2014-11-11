package com.cds.global.api;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.mail.internet.AddressException;
import javax.mail.internet.InternetAddress;

import org.dom4j.Element;

import com.cds.global.common.Constants;

public class Customer implements Constants {
	protected String accountNumber = null; // returned from DOMS as customer_id
	protected String name = null;
	protected String firstName = null;
	protected String lastName = null;
	protected String middleName = null;
	protected String address1 = null;
	protected String address2 = null;
	protected String address3 = null;
	protected String city = null;
	protected String state = null;
	protected String zipCode = null;
	protected String county = null;
	protected String country = null;
	protected String email = null;//UK has hashtable for name/value pair
	protected String internetNumber = null;
	protected String username = null; //email username
	protected String password = null; // email password
	protected String securityQuestion = null; //Added for DOMS customers
	protected String securityAnswer = null; //Added for DOMS customers
	protected String phoneNumber = null;//UK has hashtable for name/value pair
	protected String phoneNumber2 = null;
	protected String faxNumber = null;//UK has hashtable for name/value pair
	protected String companyName = null;
	protected String jobTitle = null;
	protected String title = null;
	protected String department = null;
	protected String birthday = null;
	
	protected String effectiveDate = null;
	protected String serviceStatus = null;
	protected String serviceStatusDescription = null;
	protected String baseCreditStatus = null;
	protected String baseCreditStatusDescription = null;
	
	protected String numberOfCopies = null;
	protected String startIssue = null;
	protected String startIssueDescription = null;	
	protected String expireIssue = null;
	protected String expireIssueDescription = null;
	protected String lastIssue = null;
	protected String lastIssueDescription = null;
	protected String remainingIssues = null;
	protected String specialProductCode = null;
	protected String promotionKey = null; //promotionKey to promote new order
	protected String giftPromotionKey = null; //promotionKey to promote new gift order
	protected String historyOrders = null;
	protected String historyEmails = null;
	protected String historyNames = null;

	protected Map<String,String> permissions = new HashMap<String,String>();
	protected Map<String,String> demographics = new HashMap<String,String>();
	protected ArrayList<OrderOverview> orderSummary = new ArrayList<OrderOverview>();
	protected ArrayList<MultiMag> multiMags = new ArrayList<MultiMag>();  //view only
	protected Map<String,String> dailyExpire = new HashMap<String,String>(); //view only
	
	public Customer(){}
	
	/**
	 * Create a Customer object passing in a String value.  The value can be
	 * either an Account Number or an Email Address.
	 * 
	 * @param lookupValue
	 */
	public Customer(String lookupValue) {
		try{
			InternetAddress ia = new InternetAddress(lookupValue);
			//Still here so this must be a valid email address
			this.email = ia.getAddress();
		} catch (AddressException e) {
			//Not a valid email address so must be account number
			this.accountNumber = lookupValue;
		}
	}
	/**
	 * Create a Customer object passing in an Email Address as an Internet
	 * Address type.
	 * 
	 * @param internetAddress
	 */
	public Customer(InternetAddress internetAddress) {
		this.email = internetAddress.getAddress();
	}
	/**
	 * Create a Customer object passing in an Account Number.
	 * 
	 * @param acctNbr
	 */
	public Customer(long acctNbr) {
		this.accountNumber = "" + acctNbr;
	}
	
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
			if (this.getEmail() == null || this.getEmail().length() < 1) {
				//No Email address, can't look this person up
				wsgResponse.addErrorMessage("There is no Account Number or Email Address set for this customer.  Lookup is not possible.");
				wsgResponse.setSuccess(false);
			} else {
				wsg.setUrl("/customer/" + Constants.PRODUCT_ID_REPLACE_VALUE + "/" + this.getEmail() + "?");
			}
		} else {
			wsg.setUrl("/customer/" + Constants.PRODUCT_ID_REPLACE_VALUE + "/" + this.getAccountNumber() + "?");
		}
		//
		return wsgResponse.isSuccess();
	}
	
	/**
	 * Checks to make sure all required fields are present for a Customer lookup
	 * function.  There must be either an Account Number or Email Address present.
	 * 
	 * @param wsg
	 * @param wsgResponse
	 * @return boolean
	 */
	public boolean validateCustomerLookupReadiness(WSG wsg, WSGResponse wsgResponse) {
			wsg.setUrl("/customer/" + Constants.PRODUCT_ID_REPLACE_VALUE + "/?");
		
		return wsgResponse.isSuccess();
	}
	
	
	/**
	 * Checks to make sure all required fields are present for a Customer Update.
	 * To do a customer update, there must be an account number.  To get the
	 * account number, please do a customer lookup first.
	 * 
	 * @param wsg
	 * @param wsgResponse
	 * @return
	 */
	public boolean validateUpdateReadiness(WSG wsg, WSGResponse wsgResponse) {
		if (this.getAccountNumber() == null || this.getAccountNumber().length() < 1) {
			//Must have account number to update customer
			wsgResponse.addErrorMessage("There is no Account Numberset for this customer.  Update is not possible.");
			wsgResponse.setSuccess(false);
		} else {
			wsg.setUrl("/customer/" + Constants.PRODUCT_ID_REPLACE_VALUE + "/" + this.getAccountNumber() + "?");
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
		Element customerElement = null;
		//
		for (Iterator<Element> iter = nodes.iterator(); iter.hasNext(); ) {
	        customerElement = iter.next();
	        setAccountNumber(customerElement.elementText("accountNumber"));
	        setEmail(customerElement.elementText("email"));
	        setName(customerElement.elementText("name"));
	        setFirstName(customerElement.elementText("firstName"));
	        setLastName(customerElement.elementText("lastName"));
	        setMiddleName(customerElement.elementText("middleName"));
	        setAddress1(customerElement.elementText("address1"));
	        setAddress2(customerElement.elementText("address2"));
	        setAddress3(customerElement.elementText("address3"));
	        setZipCode(customerElement.elementText("zipCode"));
	        setCity(customerElement.elementText("city"));
	        setState(customerElement.elementText("state"));
	        setZipCode(customerElement.elementText("zipCode"));
	        setCountry(customerElement.elementText("country"));
	        setCounty(customerElement.elementText("county"));
	        setInternetNumber(customerElement.elementText("internetNumber"));
	        setUsername(customerElement.elementText("username"));
	        setPassword(customerElement.elementText("password"));
	        setSecurityQuestion(customerElement.elementText("securityQuestion"));
	        setSecurityAnswer(customerElement.elementText("securityAnswer"));
	        setPhoneNumber(customerElement.elementText("phoneNumber"));
	        setPhoneNumber2(customerElement.elementText("phoneNumber2"));
	        setFaxNumber(customerElement.elementText("faxNumber"));
	        setCompanyName(customerElement.elementText("companyName"));
	        setJobTitle(customerElement.elementText("jobTitle"));
	        setTitle(customerElement.elementText("title"));
	        setDepartment(customerElement.elementText("department"));
	        setBirthday(customerElement.elementText("birthday"));
	        setEffectiveDate(customerElement.elementText("effectiveDate"));
	        setServiceStatus(customerElement.elementText("serviceStatus"));
	        setServiceStatusDescription(customerElement.elementText("serviceStatusDescription"));
	        setBaseCreditStatus(customerElement.elementText("baseCreditStatus"));
	        setBaseCreditStatusDescription(customerElement.elementText("baseCreditStatusDescription"));
	        setNumberOfCopies(customerElement.elementText("numberOfCopies"));
	        setStartIssue(customerElement.elementText("startIssue"));
	        setStartIssueDescription(customerElement.elementText("startIssueDescription"));
	        setExpireIssue(customerElement.elementText("expireIssue"));
	        setExpireIssueDescription(customerElement.elementText("expireIssueDescription"));
	        setLastIssue(customerElement.elementText("lastIssue"));
	        setLastIssueDescription(customerElement.elementText("lastIssueDescription"));
	        setRemainingIssues(customerElement.elementText("remainingIssues"));
	        setSpecialProductCode(customerElement.elementText("specialProductCode"));
	        setPromotionKey(customerElement.elementText("promotionKey"));
	        setGiftPromotionKey(customerElement.elementText("giftPromotionKey"));
	        
	        Element permissionsElement = customerElement.element("permissions");
	        if (permissionsElement != null) {
	        	loadPermissions(permissionsElement);
	        }

	        Element demoElement = customerElement.element("demographics");
	        if (demoElement != null) {
	        	loadDemographics(demoElement);
	        }
	        
			List<Element> orderSummaryElements = customerElement.elements("orderSummary");
	        if (orderSummaryElements != null && orderSummaryElements.size() > 0) {
	        	loadOrderOverviews(orderSummaryElements);
	        }
	        
	        List<Element> multiMagElements = customerElement.elements("multiMag");
	        if (multiMagElements != null && multiMagElements.size() > 0) {
	        	loadMultiMags(multiMagElements);
	        }
		}
	}
	
	private void loadPermissions(Element permissions) {
		getPermissions().put("emailUseAnywherePerm", permissions.elementText("emailUseAnywherePerm"));
		getPermissions().put("emailAuthorization", permissions.elementText("emailAuthorization"));
		getPermissions().put("eBillPerm", permissions.elementText("eBillPerm"));
		getPermissions().put("emailUseForCompanyPerm", permissions.elementText("emailUseForCompanyPerm"));
	}
	
	@SuppressWarnings("unchecked")
	private void loadDemographics(Element demographics) {
		List<Element> demoElements = demographics.elements();
		Element demoElement = null;
		for(Iterator<Element> it = demoElements.iterator(); it.hasNext(); ) {
			demoElement = it.next();
			getDemographics().put(demoElement.getName(), demoElement.getText());
		}
		
	}
	
	private void loadOrderOverviews(List<Element> nodeList) {
		OrderOverview orderOverview = null;
		Element orderSummary = null;
		for (Iterator<Element> iter = nodeList.iterator(); iter.hasNext(); ) {
			orderSummary = iter.next();
			orderOverview = new OrderOverview();
			orderOverview.populateFromXmlNode(orderSummary);
            getOrderSummary().add(orderOverview);
		}
	}
	
	private void loadMultiMags(List<Element> multiMagElements) {
		MultiMag multiMag = null;
		Element multiMagElement = null;
		for (Iterator<Element> iter = multiMagElements.iterator(); iter.hasNext(); ) {
			multiMagElement = iter.next();
			multiMag = new MultiMag();
			multiMag.populateFromXmlNode(multiMagElement);
            getMultiMag().add(multiMag);
		}
	}
	/**
	 * Populate an XML Element from this Customer object.
	 * 
	 * @param customerElement
	 * @return String
	 */
	public String createXml(Element customerElement) {
		if (getAccountNumber() != null && !"".equals(getAccountNumber().trim())) {
			customerElement.addElement("accountNumber").addText(getAccountNumber());
		}
		if (getEmail() != null && !"".equals(getEmail().trim())) {
			customerElement.addElement("email").addText(getEmail());
		}
		if (getName() != null && !"".equals(getName().trim())) {
			customerElement.addElement("name").addText(getName());
		}
		if (getFirstName() != null && !"".equals(getFirstName().trim())) {
			customerElement.addElement("firstName").addText(getFirstName());
		}
		if (getLastName() != null && !"".equals(getLastName().trim())) {
			customerElement.addElement("lastName").addText(getLastName());
		}
		if (getMiddleName() != null && !"".equals(getMiddleName().trim())) {
			customerElement.addElement("middleName").addText(getMiddleName());
		}
		if (getAddress1() != null && !"".equals(getAddress1().trim())) {
			customerElement.addElement("address1").addText(getAddress1());
		}
		if (getAddress2() != null && !"".equals(getAddress2().trim())) {
			customerElement.addElement("address2").addText(getAddress2());
		}
		if (getAddress3() != null && !"".equals(getAddress3().trim())) {
			customerElement.addElement("address3").addText(getAddress3());
		}
		if (getCity() != null && !"".equals(getCity().trim())) {
			customerElement.addElement("city").addText(getCity());
		}
		if (getState() != null && !"".equals(getState().trim())) {
			customerElement.addElement("state").addText(getState());
		}
		if (getZipCode() != null && !"".equals(getZipCode().trim())) {
			customerElement.addElement("zipCode").addText(getZipCode());
		}
		if (getCounty() != null && !"".equals(getCounty().trim())) {
			customerElement.addElement("county").addText(getCounty());
		}
		if (getCountry() != null && !"".equals(getCountry().trim())) {
			customerElement.addElement("country").addText(getCountry());
		}
		if (getInternetNumber() != null && !"".equals(getInternetNumber().trim())) {
			customerElement.addElement("internetNumber").addText(getInternetNumber());
		}
		if (getUsername() != null && !"".equals(getUsername().trim())) {
			customerElement.addElement("username").addText(getUsername());
		}
		if (getPassword() != null && !"".equals(getPassword().trim())) {
			customerElement.addElement("password").addText(getPassword());
		}
		if (getSecurityQuestion() != null && !"".equals(getSecurityQuestion().trim())) {
			customerElement.addElement("securityQuestion").addText(getSecurityQuestion());
		}
		if (getSecurityAnswer() != null && !"".equals(getSecurityAnswer().trim())) {
			customerElement.addElement("securityAnswer").addText(getSecurityAnswer());
		}
		if (getPhoneNumber() != null && !"".equals(getPhoneNumber().trim())) {
			customerElement.addElement("phoneNumber").addText(getPhoneNumber());
		}
		if (getPhoneNumber2() != null && !"".equals(getPhoneNumber2().trim())) {
			customerElement.addElement("phoneNumber2").addText(getPhoneNumber2());
		}
		if (getFaxNumber() != null && !"".equals(getFaxNumber().trim())) {
			customerElement.addElement("faxNumber").addText(getFaxNumber());
		}
		if (getCompanyName() != null && !"".equals(getCompanyName().trim())) {
			customerElement.addElement("companyName").addText(getCompanyName());
		}
		if (getJobTitle() != null && !"".equals(getJobTitle().trim())) {
			customerElement.addElement("jobTitle").addText(getJobTitle());
		}
		if (getTitle() != null && !"".equals(getTitle().trim())) {
			customerElement.addElement("title").addText(getTitle());
		}
		if (getDepartment() != null && !"".equals(getDepartment().trim())) {
			customerElement.addElement("department").addText(getDepartment());
		}
		if (getBirthday() != null && !"".equals(getBirthday().trim())) {
			customerElement.addElement("birthday").addText(getBirthday());
		}
		if (getEffectiveDate() != null && !"".equals(getEffectiveDate().trim())) {
			customerElement.addElement("effectiveDate").addText(getEffectiveDate());
		}
		if (getServiceStatus() != null && !"".equals(getServiceStatus().trim())) {
			customerElement.addElement("serviceStatus").addText(getServiceStatus());
		}
		if (getServiceStatusDescription() != null && !"".equals(getServiceStatusDescription().trim())) {
			customerElement.addElement("serviceStatusDescription").addText(getServiceStatusDescription());
		}
		if (getBaseCreditStatus() != null && !"".equals(getBaseCreditStatus().trim())) {
			customerElement.addElement("baseCreditStatus").addText(getBaseCreditStatus());
		}
		if (getBaseCreditStatusDescription() != null && !"".equals(getBaseCreditStatusDescription().trim())) {
			customerElement.addElement("baseCreditStatusDescription").addText(getBaseCreditStatusDescription());
		}
		if (getNumberOfCopies() != null && !"".equals(getNumberOfCopies().trim())) {
			customerElement.addElement("numberOfCopies").addText(getNumberOfCopies());
		}
		if (getStartIssue() != null && !"".equals(getStartIssue().trim())) {
			customerElement.addElement("startIssue").addText(getStartIssue());
		}
		if (getStartIssueDescription() != null && !"".equals(getStartIssueDescription().trim())) {
			customerElement.addElement("startIssueDescription").addText(getStartIssueDescription());
		}
		if (getExpireIssue() != null && !"".equals(getExpireIssue().trim())) {
			customerElement.addElement("expireIssue").addText(getExpireIssue());
		}
		if (getExpireIssueDescription() != null && !"".equals(getExpireIssueDescription().trim())) {
			customerElement.addElement("expireIssueDescription").addText(getExpireIssueDescription());
		}
		if (getLastIssue() != null && !"".equals(getLastIssue().trim())) {
			customerElement.addElement("lastIssue").addText(getLastIssue());
		}
		if (getLastIssueDescription() != null && !"".equals(getLastIssueDescription().trim())) {
			customerElement.addElement("lastIssueDescription").addText(getLastIssueDescription());
		}
		if (getRemainingIssues() != null && !"".equals(getRemainingIssues().trim())) {
			customerElement.addElement("remainingIssues").addText(getRemainingIssues());
		}
		if (getSpecialProductCode() != null && !"".equals(getSpecialProductCode().trim())) {
			customerElement.addElement("specialProductCode").addText(getSpecialProductCode());
		}
		if (getPromotionKey() != null && !"".equals(getPromotionKey().trim())) {
			customerElement.addElement("promotionKey").addText(getPromotionKey());
		}
		if (getGiftPromotionKey() != null && !"".equals(getGiftPromotionKey().trim())) {
			customerElement.addElement("giftPromotionKey").addText(getGiftPromotionKey());
		}
		if (getPermissions() != null && getPermissions().size() > 0) {
			Element permissisionsNode = customerElement.addElement("permissions");
			String key = null;
			String value = null;
			for(Iterator<String> it = getPermissions().keySet().iterator(); it.hasNext(); ) {
				key = it.next();
				value = getPermissions().get(key);
				if (value != null && !"".equals(value.trim())) {
					permissisionsNode.addElement(key).addText(value);
				}
			}
		}
		if (getDemographics() != null && getDemographics().size() > 0) {
			Element demographicsNode = customerElement.addElement("demographics");
			String key = null;
			String value = null;
			for(Iterator<String> it = getDemographics().keySet().iterator(); it.hasNext(); ) {
				key = it.next();
				value = getDemographics().get(key);
				if (value != null && !"".equals(value.trim())) {
					demographicsNode.addElement(key).addText(value);
				}
			}
			
		}
		//
		return customerElement.asXML();
	}
	
	/**
	 * @return the accountNumber
	 */
	public String getAccountNumber() {
		return accountNumber;
	}
	/**
	 * @param accountNumber the accountNumber to set
	 */
	public void setAccountNumber(String accountNumber) {
		this.accountNumber = accountNumber;
	}
	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}
	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the middleName
	 */
	public String getMiddleName() {
		return middleName;
	}
	/**
	 * @param middleName the middleName to set
	 */
	public void setMiddleName(String middleName) {
		this.middleName = middleName;
	}
	/**
	 * @return the address1
	 */
	public String getAddress1() {
		return address1;
	}
	/**
	 * @param address1 the address1 to set
	 */
	public void setAddress1(String address1) {
		this.address1 = address1;
	}
	/**
	 * @return the address2
	 */
	public String getAddress2() {
		return address2;
	}
	/**
	 * @param address2 the address2 to set
	 */
	public void setAddress2(String address2) {
		this.address2 = address2;
	}
	/**
	 * @return the address3
	 */
	public String getAddress3() {
		return address3;
	}
	/**
	 * @param address3 the address3 to set
	 */
	public void setAddress3(String address3) {
		this.address3 = address3;
	}
	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}
	/**
	 * @param city the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}
	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}
	/**
	 * @param state the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}
	/**
	 * @return the zipCode
	 */
	public String getZipCode() {
		return zipCode;
	}
	/**
	 * @param zipCode the zipCode to set
	 */
	public void setZipCode(String zipCode) {
		this.zipCode = zipCode;
	}
	/**
	 * @return the county
	 */
	public String getCounty() {
		return county;
	}
	/**
	 * @param county the county to set
	 */
	public void setCounty(String county) {
		this.county = county;
	}
	/**
	 * @return the country
	 */
	public String getCountry() {
		return country;
	}
	/**
	 * @param country the country to set
	 */
	public void setCountry(String country) {
		this.country = country;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the internetNumber
	 */
	public String getInternetNumber() {
		return internetNumber;
	}
	/**
	 * @param internetNumber the internetNumber to set
	 */
	public void setInternetNumber(String internetNumber) {
		this.internetNumber = internetNumber;
	}
	/**
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}
	/**
	 * @param username the username to set
	 */
	public void setUsername(String username) {
		this.username = username;
	}
	/**
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}
	/**
	 * @param password the password to set
	 */
	public void setPassword(String password) {
		this.password = password;
	}
	/**
	 * @return the securityQuestion
	 */
	public String getSecurityQuestion() {
		return securityQuestion;
	}
	/**
	 * @param securityQuestion the securityQuestion to set
	 */
	public void setSecurityQuestion(String securityQuestion) {
		this.securityQuestion = securityQuestion;
	}
	/**
	 * @return the securityAnswer
	 */
	public String getSecurityAnswer() {
		return securityAnswer;
	}
	/**
	 * @param securityAnswer the securityAnswer to set
	 */
	public void setSecurityAnswer(String securityAnswer) {
		this.securityAnswer = securityAnswer;
	}
	/**
	 * @return the phoneNumber
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}
	/**
	 * @param phoneNumber the phoneNumber to set
	 */
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	/**
	 * @return the phoneNumber2
	 */
	public String getPhoneNumber2() {
		return phoneNumber2;
	}
	/**
	 * @param phoneNumber2 the phoneNumber2 to set
	 */
	public void setPhoneNumber2(String phoneNumber2) {
		this.phoneNumber2 = phoneNumber2;
	}
	/**
	 * @return the faxNumber
	 */
	public String getFaxNumber() {
		return faxNumber;
	}
	/**
	 * @param faxNumber the faxNumber to set
	 */
	public void setFaxNumber(String faxNumber) {
		this.faxNumber = faxNumber;
	}
	/**
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}
	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	/**
	 * @return the jobTitle
	 */
	public String getJobTitle() {
		return jobTitle;
	}
	/**
	 * @param jobTitle the jobTitle to set
	 */
	public void setJobTitle(String jobTitle) {
		this.jobTitle = jobTitle;
	}
	/**
	 * @return the title
	 */
	public String getTitle() {
		return title;
	}
	/**
	 * @param title the title to set
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	/**
	 * @return the department
	 */
	public String getDepartment() {
		return department;
	}
	/**
	 * @param department the department to set
	 */
	public void setDepartment(String department) {
		this.department = department;
	}
	/**
	 * @return the birthday
	 */
	public String getBirthday() {
		return birthday;
	}
	/**
	 * @param birthday the birthday to set
	 */
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	/**
	 * @return the effectiveDate
	 */
	public String getEffectiveDate() {
		return effectiveDate;
	}
	/**
	 * @param effectiveDate the effectiveDate to set
	 */
	public void setEffectiveDate(String effectiveDate) {
		this.effectiveDate = effectiveDate;
	}
	/**
	 * @return the serviceStatus
	 */
	public String getServiceStatus() {
		return serviceStatus;
	}
	/**
	 * @param serviceStatus the serviceStatus to set
	 */
	public void setServiceStatus(String serviceStatus) {
		this.serviceStatus = serviceStatus;
	}
	/**
	 * @return the serviceStatusDescription
	 */
	public String getServiceStatusDescription() {
		return serviceStatusDescription;
	}
	/**
	 * @param serviceStatusDescription the serviceStatusDescription to set
	 */
	public void setServiceStatusDescription(String serviceStatusDescription) {
		this.serviceStatusDescription = serviceStatusDescription;
	}
	/**
	 * @return the baseCreditStatus
	 */
	public String getBaseCreditStatus() {
		return baseCreditStatus;
	}
	/**
	 * @param baseCreditStatus the baseCreditStatus to set
	 */
	public void setBaseCreditStatus(String baseCreditStatus) {
		this.baseCreditStatus = baseCreditStatus;
	}
	/**
	 * @return the baseCreditStatusDescription
	 */
	public String getBaseCreditStatusDescription() {
		return baseCreditStatusDescription;
	}
	/**
	 * @param baseCreditStatusDescription the baseCreditStatusDescription to set
	 */
	public void setBaseCreditStatusDescription(String baseCreditStatusDescription) {
		this.baseCreditStatusDescription = baseCreditStatusDescription;
	}
	/**
	 * @return the numberOfCopies
	 */
	public String getNumberOfCopies() {
		return numberOfCopies;
	}
	/**
	 * @param numberOfCopies the numberOfCopies to set
	 */
	public void setNumberOfCopies(String numberOfCopies) {
		this.numberOfCopies = numberOfCopies;
	}
	/**
	 * @return the startIssue
	 */
	public String getStartIssue() {
		return startIssue;
	}
	/**
	 * @param startIssue the startIssue to set
	 */
	public void setStartIssue(String startIssue) {
		this.startIssue = startIssue;
	}
	/**
	 * @return the startIssueDescription
	 */
	public String getStartIssueDescription() {
		return startIssueDescription;
	}
	/**
	 * @param startIssueDescription the startIssueDescription to set
	 */
	public void setStartIssueDescription(String startIssueDescription) {
		this.startIssueDescription = startIssueDescription;
	}
	/**
	 * @return the expireIssue
	 */
	public String getExpireIssue() {
		return expireIssue;
	}
	/**
	 * @param expireIssue the expireIssue to set
	 */
	public void setExpireIssue(String expireIssue) {
		this.expireIssue = expireIssue;
	}
	/**
	 * @return the expireIssueDescription
	 */
	public String getExpireIssueDescription() {
		return expireIssueDescription;
	}
	/**
	 * @param expireIssueDescription the expireIssueDescription to set
	 */
	public void setExpireIssueDescription(String expireIssueDescription) {
		this.expireIssueDescription = expireIssueDescription;
	}
	/**
	 * @return the lastIssue
	 */
	public String getLastIssue() {
		return lastIssue;
	}
	/**
	 * @param lastIssue the lastIssue to set
	 */
	public void setLastIssue(String lastIssue) {
		this.lastIssue = lastIssue;
	}
	/**
	 * @return the lastIssueDescription
	 */
	public String getLastIssueDescription() {
		return lastIssueDescription;
	}
	/**
	 * @param lastIssueDescription the lastIssueDescription to set
	 */
	public void setLastIssueDescription(String lastIssueDescription) {
		this.lastIssueDescription = lastIssueDescription;
	}
	/**
	 * @return the remainingIssues
	 */
	public String getRemainingIssues() {
		return remainingIssues;
	}
	/**
	 * @param remainingIssues the remainingIssues to set
	 */
	public void setRemainingIssues(String remainingIssues) {
		this.remainingIssues = remainingIssues;
	}
	/**
	 * @return the specialProductCode
	 */
	public String getSpecialProductCode() {
		return specialProductCode;
	}
	/**
	 * @param specialProductCode the specialProductCode to set
	 */
	public void setSpecialProductCode(String specialProductCode) {
		this.specialProductCode = specialProductCode;
	}
	/**
	 * @return the promotionKey
	 */
	public String getPromotionKey() {
		return promotionKey;
	}
	/**
	 * @param promotionKey the promotionKey to set
	 */
	public void setPromotionKey(String promotionKey) {
		this.promotionKey = promotionKey;
	}
	/**
	 * @return the giftPromotionKey
	 */
	public String getGiftPromotionKey() {
		return giftPromotionKey;
	}
	/**
	 * @param giftPromotionKey the giftPromotionKey to set
	 */
	public void setGiftPromotionKey(String giftPromotionKey) {
		this.giftPromotionKey = giftPromotionKey;
	}
	/**
	 * @return the historyOrders
	 */
	public String getHistoryOrders() {
		return historyOrders;
	}
	/**
	 * @param historyOrders the historyOrders to set
	 */
	public void setHistoryOrders(String historyOrders) {
		this.historyOrders = historyOrders;
	}
	/**
	 * @return the historyEmails
	 */
	public String getHistoryEmails() {
		return historyEmails;
	}
	/**
	 * @param historyEmails the historyEmails to set
	 */
	public void setHistoryEmails(String historyEmails) {
		this.historyEmails = historyEmails;
	}
	/**
	 * @return the historyNames
	 */
	public String getHistoryNames() {
		return historyNames;
	}
	/**
	 * @param historyNames the historyNames to set
	 */
	public void setHistoryNames(String historyNames) {
		this.historyNames = historyNames;
	}
	/**
	 * @return the permissions
	 */
	public Map<String, String> getPermissions() {
		return permissions;
	}
	/**
	 * @param permissions the permissions to set
	 */
	public void setPermissions(Map<String, String> permissions) {
		this.permissions = permissions;
	}
	/**
	 * @return the demographics
	 */
	public Map<String, String> getDemographics() {
		return demographics;
	}
	/**
	 * @param demographics the demographics to set
	 */
	public void setDemographics(Map<String, String> demographics) {
		this.demographics = demographics;
	}
	/**
	 * @return the orderSummary
	 */
	public ArrayList<OrderOverview> getOrderSummary() {
		return orderSummary;
	}
	/**
	 * @param orderSummary the orderSummary to set
	 */
	public void setOrderSummary(ArrayList<OrderOverview> orderSummary) {
		this.orderSummary = orderSummary;
	}
	/**
	 * @return the multiMag
	 */
	public ArrayList<MultiMag> getMultiMag() {
		return multiMags;
	}
	/**
	 * @return the dailyExpire
	 */
	public Map<String, String> getDailyExpire() {
		return dailyExpire;
	}
	/**
	 * @param dailyExpire the dailyExpire to set
	 */
	public void setDailyExpire(Map<String, String> dailyExpire) {
		this.dailyExpire = dailyExpire;
	}
}
