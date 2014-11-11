package com.cds.global.api;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.mail.internet.InternetAddress;
import javax.ws.rs.core.MultivaluedMap;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.Node;

import com.cds.global.common.Constants;
import com.cds.global.utils.Utility;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.core.util.MultivaluedMapImpl;
/**
 * This is the main communication class for the API.  Any communications to CDS Global
 * will be done via this class.
 * 
 * @author jab910
 */
public class WSG implements Constants {
	private String appId = null;
	private String password = null;
	private String clientCode = null;
	private String prodAbbr = null;
	private String URI = Constants.PRODUCTION_BASE_URL;
	private boolean inProduction = true;
	private String url = "";
	private Map<String, TransactionSource> transactionSource = new HashMap<String, TransactionSource>();

	public WSG() {}
	/**
	 * Create a new WSG object and set the Application Id, Password, and
	 * Product Abbreviation to the values passed.
	 * 
	 * @param appId
	 * @param password
	 * @param prodAbbr
	 */
	public WSG(String appId, String password, String prodAbbr) {
		this(appId, password, prodAbbr, null);
	}
	/**
	 * Create a new WSG object and set the Application Id, Password,
	 * Product Abbreviation, and URI to the values passed.
	 * 
	 * @param appId
	 * @param password
	 * @param prodAbbr
	 * @param uri
	 */
	public WSG(String appId, String password, String prodAbbr, String uri) {
		this.appId = appId;
		this.password = password;
		this.prodAbbr = prodAbbr;
		//
		if (uri != null) {
			this.URI = uri;
		}
	}
	/**
	 * Perform a Customer Lookup function using the email address passed in
	 * as an InternetAddress.
	 * 
	 * @param email
	 * @return wsgResponse
	 */
	public WSGResponse lookupCustomer(InternetAddress email) {
		return this.lookupCustomer(new Customer(email));
	}
	/**
	 * Perform a Customer Lookup function using the Account Number passed
	 * in.
	 * 
	 * @param accountNbr
	 * @return wsgResponse
	 */
	public WSGResponse lookupCustomer(Long accountNbr) {
		return this.lookupCustomer(new Customer(accountNbr.longValue()));
	}
	/**
	 * Perform a Customer Lookup function using the passed in value as either
	 * an Account Number or an Email Address.
	 * 
	 * @param lookupValue
	 * @return wsgReponse
	 */
	public WSGResponse lookupCustomer(String lookupValue) {
		return this.lookupCustomer(new Customer(lookupValue));
	}
	/**
	 * Perform a Customer lookup, using the Customer data passed.
	 * 
	 * @param customer
	 * @return wsgResponse
	 */
	@SuppressWarnings("unchecked")
	protected WSGResponse lookupCustomer(Customer customer) {
		WSGResponse wsgResponse = new WSGResponse();
		// Check to make sure we have the minimum data needed to make a call
		this.validateCallReadiness(wsgResponse);
		customer.validateLookupReadiness(this, wsgResponse);
		//
		if (wsgResponse.isSuccess()) {
			//We have the needed data to make the Customer Lookup call to WSG so lets do it
		    try {
				Client wsg = new Client();
			
		    	WebResource wr = wsg.resource(finalizeUri());
				//
				MultivaluedMap<String, String> params = createWsgParams();
				//
				System.out.println("\n\n\n *********wr.queryParams(params) " + wr.queryParams(params));
				ClientResponse response = wr.queryParams(params).type("application/xml").header("Content-Type", "application/xml").get(ClientResponse.class);
		    	Document doc = processResponse(response, wsgResponse);
		    	//
				if (wsgResponse.isSuccess()) {
					customer.populateFromXmlNode(doc.selectNodes("/transaction/customer"));
					wsgResponse.addObject(customer);
				}
		    } catch(Exception e) {
		    	e.printStackTrace();
		    	wsgResponse.setSuccess(false);
		    	wsgResponse.addErrorMessage(e.getMessage());
		    } 
		}
		return wsgResponse;
	}
	
	
	/**
	 * Perform a Customer lookup, using the Customer data passed.
	 * 
	 * @param customer
	 * @return wsgResponse
	 */
	@SuppressWarnings("unchecked")
	public WSGResponse lookupCustomerByAddress(Customer customer) {
		WSGResponse wsgResponse = new WSGResponse();
		// Check to make sure we have the minimum data needed to make a call
		this.validateCallReadiness(wsgResponse);
		customer.validateCustomerLookupReadiness(this, wsgResponse);
		//
		if (wsgResponse.isSuccess()) {
			//We have the needed data to make the Customer Lookup call to WSG so lets do it
		    try {
				Client wsg = new Client();
				System.out.println("\n\n\n *********finalizeUri() " + finalizeUri());
		    	WebResource wr = wsg.resource(finalizeUri());
				//
				MultivaluedMap<String, String> params = createCustomerWsgParams(customer);
				//
				System.out.println("\n\n\n *********wr.queryParams(params) " + wr.queryParams(params));
				ClientResponse response = wr.queryParams(params).type("application/xml").header("Content-Type", "application/xml").get(ClientResponse.class);
		    	Document doc = processResponse(response, wsgResponse);
		    	//
				if (wsgResponse.isSuccess()) {
					customer.populateFromXmlNode(doc.selectNodes("/transaction/customer"));
					wsgResponse.addObject(customer);
				}
		    } catch(Exception e) {
		    	e.printStackTrace();
		    	wsgResponse.setSuccess(false);
		    	wsgResponse.addErrorMessage(e.getMessage());
		    } 
		}
		return wsgResponse;
	}
	
	
	/**
	 * Perform a Entitlements lookup, using the Entitlements data passed.
	 * 
	 * @param customer
	 * @return wsgResponse
	 */
	@SuppressWarnings("unchecked")
	public WSGResponse getEntitlements(String accountNumber) {
		
		Entitlements entitlements = new Entitlements();
		entitlements.setAccountNumber(accountNumber);
		WSGResponse wsgResponse = new WSGResponse();
		
		return getEntitlment(entitlements);
	}
	
	
	/**
	 * Perform a Customer lookup, using the Customer data passed.
	 * 
	 * @param customer
	 * @return wsgResponse
	 */
	@SuppressWarnings("unchecked")
	protected WSGResponse getEntitlment(Entitlements entitlements) {
		WSGResponse wsgResponse = new WSGResponse();
		// Check to make sure we have the minimum data needed to make a call
		this.validateCallReadiness(wsgResponse);
		entitlements.validateLookupReadiness(this, wsgResponse);
		//
		if (wsgResponse.isSuccess()) {
			//We have the needed data to make the Customer Lookup call to WSG so lets do it
		    try {
				Client wsg = new Client();
		    	WebResource wr = wsg.resource(finalizeUri());
				//
				MultivaluedMap<String, String> params = createWsgParams();
				//
				ClientResponse response = wr.queryParams(params).type("application/xml").header("Content-Type", "application/xml").get(ClientResponse.class);
		    	Document doc = processResponse(response, wsgResponse);
		    	//
				if (wsgResponse.isSuccess()) {
					entitlements.populateFromXmlNode(doc.selectNodes("/transaction/entitlements/issue"));
					wsgResponse.addObject(entitlements);
				}
		    } catch(Exception e) {
		    	e.printStackTrace();
		    	wsgResponse.setSuccess(false);
		    	wsgResponse.addErrorMessage(e.getMessage());
		    } 
		}
		return wsgResponse;
	}
	/**
	 * Perform a Order lookup, using the order number and account number.
	 * 
	 * @param order
	 * @return wsgResponse
	 */
	public WSGResponse lookupOrder(String orderNumber, String accountNumber) {
		Customer customer = new Customer();
		customer.setAccountNumber(accountNumber);
		Order order = new Order();
		order.setCustomer(customer);
		order.setOrderNumber(orderNumber);
		//
		return lookupOrder(order);
	}
	/**
	 * Perform a Order lookup, using the order data passed.
	 * 
	 * @param order
	 * @return wsgResponse
	 */
	@SuppressWarnings("unchecked")
	public WSGResponse lookupOrder(Order order) {
		WSGResponse wsgResponse = new WSGResponse();
		// Check to make sure we have the minimum data needed to make a call
		this.validateCallReadiness(wsgResponse);
		order.validateLookupReadiness(this, wsgResponse);
		//
		if (wsgResponse.isSuccess()) {
			//We have the needed data to make the Customer Lookup call to WSG so lets do it
		    try {
				Client wsg = new Client();
		    	WebResource wr = wsg.resource(finalizeUri());
				//
				MultivaluedMap<String, String> params = createWsgParams();
				//
				params.add("accountNumber", order.getCustomer().getAccountNumber());
				//
				ClientResponse response = wr.queryParams(params).type("application/xml").header("Content-Type", "application/xml").get(ClientResponse.class);
		    	Document doc = processResponse(response, wsgResponse);
		    	//
				if (wsgResponse.isSuccess()) {
					order.populateFromXml(doc.selectNodes("/transaction/order"));
					wsgResponse.addObject(order);
				}
		    } catch(Exception e) {
		    	e.printStackTrace();
		    	wsgResponse.setSuccess(false);
		    	wsgResponse.addErrorMessage(e.getMessage());
		    } 
		}
		return wsgResponse;
	}
	/**
	 * Perform a Series lookup, using the order data passed. Note that Series lookups only apply to SERV/Pf.
	 * 
	 * @param order
	 * @return wsgResponse
	 */
	public WSGResponse lookupSeries(Series series) {
		WSGResponse wsgResponse = new WSGResponse();
		// Check to make sure we have the minimum data needed to make a call
		this.validateCallReadiness(wsgResponse);
		series.validateLookupReadiness(this, wsgResponse);
		//
		if (wsgResponse.isSuccess()) {
			//We have the needed data to make the Customer Lookup call to WSG so lets do it
		    try {
				Client wsg = new Client();
		    	WebResource wr = wsg.resource(finalizeUri());
				//
				MultivaluedMap<String, String> params = createWsgParams();
				//
				params.add("accountNumber", series.getCustomer().getAccountNumber());
				params.add("shipToAccountNumber", series.getRecipient().getAccountNumber());
				//
				ClientResponse response = wr.queryParams(params).type("application/xml").header("Content-Type", "application/xml").get(ClientResponse.class);
		    	Document doc = processResponse(response, wsgResponse);
		    	//
				if (wsgResponse.isSuccess()) {
					List seriesNodes = doc.selectNodes("/transaction/series");
					Series tmp = null;
					for (Iterator it = seriesNodes.iterator(); it.hasNext(); ) {
						tmp = new Series();
						tmp.populateFromXml((Element)it.next());
						wsgResponse.addObject(tmp);
					}
				}
		    } catch(Exception e) {
		    	e.printStackTrace();
		    	wsgResponse.setSuccess(false);
		    	wsgResponse.addErrorMessage(e.getMessage());
		    } 
		}
		return wsgResponse;
	}


	/**
	 * Send a Payment to CDS Global.
	 * 
	 * @param payment
	 * @return wsgResponse
	 */
	@SuppressWarnings("unchecked")
	public WSGResponse addPayment(Payment payment) {
		WSGResponse wsgResponse = new WSGResponse();
		// Check to make sure we have the minimum data needed to make a call
		this.validateCallReadiness(wsgResponse);
		payment.validatePaymentReadiness(this, wsgResponse);
		//
		if (wsgResponse.isSuccess()) {
			//We have the needed data to make the Customer Lookup call to WSG so lets do it
		    try {
		    	Client wsg = new Client();
		    	WebResource wr = wsg.resource(finalizeUri());
				//Build up the parameters to pass
		    	MultivaluedMap<String, String> params = createWsgParams();
		    	//
				Document document = DocumentHelper.createDocument();
				Element paymentElement = document.addElement("payment");
				payment.createXmlString(paymentElement);
				addTransactionSourceToElement(paymentElement);
				//
				ClientResponse response = wr.queryParams(params).type("application/xml").header("Content-Type", "application/xml").post(ClientResponse.class, document.asXML());
				//
				processResponse(response, wsgResponse);
				//
				if (wsgResponse.isSuccess()) {
					payment.populateFromXmlNode(document.selectNodes("/transaction/payment"));
					wsgResponse.addObject(payment);
				}
		    } catch(Exception e) {
		    	e.printStackTrace();
		    	wsgResponse.setSuccess(false);
		    	wsgResponse.addErrorMessage(e.getMessage());
		    } 
		}
		//
		return wsgResponse;
	}
	/**
	 * Send a new order to CDS Global.  This will create a new order.
	 * 
	 * @param order
	 * @return wsgResponse
	 */
	@SuppressWarnings("unchecked")
	public WSGResponse addOrder(Order order) {
		WSGResponse wsgResponse = new WSGResponse();
		// Check to make sure we have the minimum data needed to make a call
		this.validateCallReadiness(wsgResponse);
		order.validateOrderReadiness(this, wsgResponse);
		//
		if (wsgResponse.isSuccess()) {
			//We have the needed data to make the Customer Lookup call to WSG so lets do it
		    try {
		    	Client wsg = new Client();
		    	WebResource wr = wsg.resource(finalizeUri());
				//Build up the parameters to pass
		    	MultivaluedMap<String, String> params = createWsgParams();
		    	//
				Document document = DocumentHelper.createDocument();
				Element orderElement = document.addElement("order");
		    	order.createXml(orderElement);
		    	addTransactionSourceToElement(orderElement);
		    	//
				ClientResponse response = wr.queryParams(params).type("application/xml").header("Content-Type", "application/xml").post(ClientResponse.class, document.asXML());
				//
				processResponse(response, wsgResponse);
				//
				if (wsgResponse.isSuccess()) {
					order.populateFromXml(document.selectNodes("/transaction/order"));
					wsgResponse.addObject(order);
				}
		    } catch(Exception e) {
		    	e.printStackTrace();
		    	wsgResponse.setSuccess(false);
		    	wsgResponse.addErrorMessage(e.getMessage());
		    } 
		}
		//
		return wsgResponse;
	}
	/**
	 * Update a Customer using the Customer object passed.
	 * 
	 * @param customer
	 * @return wsgResponse
	 */
	@SuppressWarnings("unchecked")
	public WSGResponse updateCustomer(Customer customer) {
		WSGResponse wsgResponse = new WSGResponse();
		// Check to make sure we have the minimum data needed to make a call
		this.validateCallReadiness(wsgResponse);
		customer.validateUpdateReadiness(this, wsgResponse);
		//
		if (wsgResponse.isSuccess()) {
			//We have the needed data to make the Customer Lookup call to WSG so lets do it
		    try {
		    	Client wsg = new Client();
		    	WebResource wr = wsg.resource(finalizeUri());
				//Build up the parameters to pass
		    	MultivaluedMap<String, String> params = createWsgParams();
				//
				Document document = DocumentHelper.createDocument();
				Element customerElement = document.addElement("customer");
				customer.createXml(customerElement);
				addTransactionSourceToElement(customerElement);
				//
				ClientResponse response = wr.queryParams(params).type("application/xml").header("Content-Type", "application/xml").put(ClientResponse.class, document.asXML());
				//
				Document doc = processResponse(response, wsgResponse);
				//
				if (wsgResponse.isSuccess()) {
					customer.populateFromXmlNode(doc.selectNodes("/transaction/customer"));
					wsgResponse.addObject(customer);
				}
		    } catch(Exception e) {
		    	e.printStackTrace();
		    	wsgResponse.setSuccess(false);
		    	wsgResponse.addErrorMessage(e.getMessage());
		    } 
		}
		//
		return wsgResponse;
	}
	
	/**
	 * Send an Update Series to CDS Global. Note that Update Series transactions only apply to SERV/Pf.
	 * 
	 * @param order
	 * @return wsgResponse
	 */
	@SuppressWarnings("unchecked")
	public WSGResponse updateSeries(Series series) {
		WSGResponse wsgResponse = new WSGResponse();
		// Check to make sure we have the minimum data needed to make a call
		this.validateCallReadiness(wsgResponse);
		series.validateUpdateReadiness(this, wsgResponse);
		//
		if (wsgResponse.isSuccess()) {
			//We have the needed data to make the Customer Lookup call to WSG so lets do it
		    try {
		    	Client wsg = new Client();
		    	WebResource wr = wsg.resource(finalizeUri());
				//Build up the parameters to pass
		    	MultivaluedMap<String, String> params = createWsgParams();
		    	//
				params.add("accountNumber", series.getCustomer().getAccountNumber());
				params.add("shipToAccountNumber", series.getRecipient().getAccountNumber());
				//
				Document document = DocumentHelper.createDocument();
				Element seriesElement = document.addElement("series");
		    	series.createXml(seriesElement);
		    	addTransactionSourceToElement(seriesElement);
		    	//
				ClientResponse response = wr.queryParams(params).type("application/xml").header("Content-Type", "application/xml").put(ClientResponse.class, document.asXML());
				//
				processResponse(response, wsgResponse);
				//
				if (wsgResponse.isSuccess()) {
					List seriesNodes = document.selectNodes("/transaction/series");
					Series tmp = null;
					for (Iterator it = seriesNodes.iterator(); it.hasNext(); ) {
						tmp = new Series();
						tmp.populateFromXml((Element)it.next());
						wsgResponse.addObject(tmp);
					}
				}
		    } catch(Exception e) {
		    	e.printStackTrace();
		    	wsgResponse.setSuccess(false);
		    	wsgResponse.addErrorMessage(e.getMessage());
		    } 
		}
		//
		return wsgResponse;
	}
	/**
	 * Process the response from a call to CDS Global. This evaluates the transaction and returns the transaction ID, a success or failure,
	 * and a message containing transaction failure details if applicable. Note that orders that could not apply in real-time are noted as successful,
	 * but sent to Offline for further processing.
	 * 
	 * @param response
	 * @param wsgResponse
	 * @return Document
	 * @throws DocumentException
	 */
	private Document processResponse(ClientResponse response, WSGResponse wsgResponse) throws DocumentException {
		String data = response.getEntity(String.class);
		wsgResponse.setDataRecieved(data);
		Document doc = DocumentHelper.parseText(data);
		Node node = doc.selectSingleNode("//isSuccess");
		if (node != null) {
			wsgResponse.setSuccess(Utility.stringMeansYes(node.getText()));
		}
		node = doc.selectSingleNode("//message");
		if (node != null) {
			wsgResponse.addErrorMessage(node.getText());
		}
		node = doc.selectSingleNode("//sentToOffline");
		if (node != null) {
			wsgResponse.setSentToOffline(Utility.stringMeansYes(node.getText()));
		} else {
			wsgResponse.setSentToOffline(false);
		}
		node = doc.selectSingleNode("//transactionId");
		if (node != null) {
			wsgResponse.setTransactionId(node.getText());
		}
		return doc;
	}
	
	/**
	 * Add the base WSG parameters.
	 * 
	 * @return MultivaluedMap<String, String>
	 */
	protected MultivaluedMap<String, String> createWsgParams() {
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		//
		params.add("appId", this.getAppId());
		params.add("pwd", this.getPassword());
		params.add("apiVersion", Constants.API_VERSION);
		//
		return params;
	}
	
	/**
	 * Add the base WSG parameters.
	 * 
	 * @return MultivaluedMap<String, String>
	 */
	protected MultivaluedMap<String, String> createCustomerWsgParams(Customer customer) {
		MultivaluedMap<String, String> params = new MultivaluedMapImpl();
		//
		params.add("appId", this.getAppId());
		params.add("pwd", this.getPassword());
		params.add("apiVersion", Constants.API_VERSION);
		params.add("name",customer.getName());
		params.add("address1", customer.getAddress1());
		params.add("address2", customer.getAddress2());
		params.add("city", customer.getCity());
		params.add("state", customer.getState());
		params.add("zipCode", customer.getZipCode());
		//
		return params;
	}
	/**
	 * Make sure we have a value for all required fields before attempting to
	 * call CDS Global.
	 *   appId
	 *   password
	 *   prodAbbr
	 *   uri
	 *   
	 * @param wsgResponse
	 */
	protected void validateCallReadiness(WSGResponse wsgResponse) {
		if (this.getAppId() == null || this.getAppId().length() < 1) {
			wsgResponse.addErrorMessage("Invalid AppId - No AppId set.");
			wsgResponse.setSuccess(false);
		}
		if (this.getPassword() == null || this.getPassword().length() < 1) {
			wsgResponse.addErrorMessage("Invalid Password - No Password set.");
			wsgResponse.setSuccess(false);
		}
		if (this.getURI() == null || this.getURI().length() < 1) {
			wsgResponse.addErrorMessage("Invalid URI - No URI set.");
			wsgResponse.setSuccess(false);
		}
		if (this.getProdAbbr() == null || this.getProdAbbr().trim().length() != 3) {
			wsgResponse.addErrorMessage("Invalid Product Abbreviation - Not set.");
			wsgResponse.setSuccess(false);
		}
		//
		return;
	}
	/**
	 * 
	 * Return the full URI to connect to the target data source.
	 * @return String
	 */
	protected String finalizeUri() {
    	String sUrl = this.getURI() + this.getUrl();
    	sUrl = sUrl.replaceAll(Constants.PRODUCT_ID_REPLACE_VALUE, this.getProdAbbr().trim());
    	//
    	return sUrl;
	}
	/**
	 * @return the appId
	 */
	public String getAppId() {
		return appId;
	}

	/**
	 * @param appId the appId to set
	 */
	public void setAppId(String appId) {
		this.appId = appId;
	}

	/**
	 * @return get the password
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
	 * @return get the uRI passed in the WSG call
	 */
	public String getURI() {
		return URI;
	}

	/**
	 * @param uRI the uRI to set
	 */
	protected void setURI(String uRI) {
		URI = uRI;
	}

	/**
	 * @return get the parameters passed in the uRL
	 */
	public String getUrl() {
		return url;
	}

	/**
	 * @param uRL the uRL parameters to set
	 */
	public void setUrl(String url) {
		this.url = url;
	}

	/**
	 * @return get the clientCode
	 */
	public String getClientCode() {
		return clientCode;
	}

	/**
	 * @param clientCode the clientCode to set
	 */
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}

	/**
	 * @return get the product ID (prodAbbr)
	 */
	public String getProdAbbr() {
		return prodAbbr;
	}

	/**
	 * @param prodAbbr the product ID to set
	 */
	public void setProdAbbr(String prodAbbr) {
		this.prodAbbr = prodAbbr;
	}

	/**
	 * @return the inProduction value.
	 */
	public boolean isInProduction() {
		return inProduction;
	}
	/**
	 * @param set To Local URI. Used for localhost testing only.
	 */
	public void setToLocal() {
		setURI(Constants.LOCAL_BASE_URL);
	}

	/**
	 * This is for testing purposes.  If you are just creating your interface, please
	 * set production to false so you can call the QA server.  Be sure that once in
	 * production you set inProduction to true.
	 * 
	 * @param inProduction
	 */
	public void setInProduction(boolean inProduction) {
		if (inProduction) {
			setURI(Constants.PRODUCTION_BASE_URL);
		} else {
			setURI(Constants.QA_BASE_URL);
		}
		this.inProduction = inProduction;
	}
	/**
	 * @return the transactionSource
	 */
	public Map<String, TransactionSource> getTransactionSource() {
		return transactionSource;
	}
	/**
	 * @param transactionSource the transactionSource to set
	 */
	public void addTransactionSource(TransactionSource ts) {
		this.transactionSource.put(ts.getKey(), ts);
	}
	/**
	 * 
	 * @param add transaction source to the root document element.
	 */
	protected void addTransactionSourceToElement(Element root) {
		Element transactionSourceElement = null;
		TransactionSource ts = null;
		//
		if (!getTransactionSource().isEmpty()) {
			transactionSourceElement = root.addElement("transactionSource");
		}
		//
		for (Iterator<TransactionSource> it = getTransactionSource().values().iterator(); it.hasNext();) {
			ts = it.next();
			if (ts.isAttribute()) {
				transactionSourceElement.addAttribute(ts.getKey(), ts.getValue());
			} else {
				transactionSourceElement.addElement(ts.getKey()).addText(ts.getValue());
			}
		}
	}
}
