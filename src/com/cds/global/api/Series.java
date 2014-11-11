package com.cds.global.api;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Element;

import com.cds.global.common.Constants;

public class Series extends BaseServiceObject {
	protected String orderType = null;
	protected String quantity = null;
	protected String promotionKey = null;
	protected String sourceCd = null;
	protected String quantityAlreadyReceived = null;
	protected String quantityAlreadyReceivedDate = null;
	protected String receiveDate = null;
	protected String poNumber = null;
	protected String invoiceNumber = null;
	protected String planCode = null;
	//now the information is different from an order
	protected String frequency = null;
	protected String planDescription = null;
	protected String planStatus = null;
	protected String planStatusDescription = null;
	protected String interest = null;
	protected String unpaids = null;
	protected String unpaidDollars = null;
	protected String shipDate = null;
	protected String paidDate = null;
	protected String cycleDate = null;
	protected String suspendDate = null;
	protected String resumeServiceDate = null;
	protected String numberOfValidInterest = null;
	
	protected Customer customer = new Customer();
	protected Customer recipient = new Customer();
	protected Payment payment = new Payment();
	protected ArrayList<SeriesInterest> interestEntries = new ArrayList<SeriesInterest>();

	/**
	 * Validate we are ready to send an order.  There must be a Customer object
	 * with a value for Name.
	 * 
	 * @param wsg
	 * @param wsgResponse
	 * @return boolean
	 */
	public boolean validateLookupReadiness(WSG wsg, WSGResponse wsgResponse) {
		if (getCustomer() == null) {
			wsgResponse.setSuccess(false);
			wsgResponse.addErrorMessage("There must be a Customer when looking up a series");
		} else if (getCustomer().getAccountNumber() == null || "".equals(getCustomer().getAccountNumber().trim())) {
			wsgResponse.setSuccess(false);
			wsgResponse.addErrorMessage("There must be a Customer with an account number when looking up a series");
		} else if (getPlanCode() == null || "".equals(getPlanCode().trim())) {
			wsgResponse.setSuccess(false);
			wsgResponse.addErrorMessage("There must be a Plan code when looking up a series");
		}
		if (wsgResponse.isSuccess()) {
			wsg.setUrl("/series/" + Constants.PRODUCT_ID_REPLACE_VALUE + "/" + getPlanCode() + "?");
		}
		//
		return wsgResponse.isSuccess();
	}
	/**
	 * Validate we are ready to send a Series Update.
	 * 
	 * @param wsg
	 * @param wsgResponse
	 * @return boolean
	 */
	public boolean validateUpdateReadiness(WSG wsg, WSGResponse wsgResponse) {
		if (getCustomer() == null) {
			wsgResponse.setSuccess(false);
			wsgResponse.addErrorMessage("There must be a Customer when updating up a series");
		} else if (getCustomer().getAccountNumber() == null || "".equals(getCustomer().getAccountNumber().trim())) {
			wsgResponse.setSuccess(false);
			wsgResponse.addErrorMessage("There must be a Customer with an account number when updating up a series");
		} else if (getPlanCode() == null || "".equals(getPlanCode().trim())) {
			wsgResponse.setSuccess(false);
			wsgResponse.addErrorMessage("There must be a Plan code when updating up a series");
		}
		if (wsgResponse.isSuccess()) {
			wsg.setUrl("/series/" + Constants.PRODUCT_ID_REPLACE_VALUE + "/" + getPlanCode() + "?");
		}
		//
		return wsgResponse.isSuccess();
	}
	/**
	 * 
	 * @param seriesElement
	 * @return String
	 */
	public String createXml(Element seriesElement) {
		if (getOrderType() != null && !"".equals(getOrderType().trim())) {
			seriesElement.addElement("orderType").addText(getOrderType());
		}
		if (getFrequency() != null && !"".equals(getFrequency().trim())) {
			seriesElement.addElement("frequency").addText(getFrequency());
		}
		if (getSuspendDate() != null && !"".equals(getSuspendDate().trim())) {
			seriesElement.addElement("suspendDate").addText(getSuspendDate());
		}
		if (getResumeServiceDate() != null && !"".equals(getResumeServiceDate().trim())) {
			seriesElement.addElement("resumeServiceDate").addText(getResumeServiceDate());
		}
		if (getInterest() != null && !"".equals(getInterest().trim())) {
			seriesElement.addElement("interest").addText(getInterest());
		}
		if (getQuantity() != null && !"".equals(getQuantity().trim())) {
			seriesElement.addElement("quantity").addText(getQuantity());
		}
		if (getPlanStatus() != null && !"".equals(getPlanStatus().trim())) {
			seriesElement.addElement("planStatus").addText(getPlanStatus());
		}
		if (getCustomer() != null && getCustomer().getAccountNumber() != null && !"".equals(getCustomer().getAccountNumber().trim())) {
			seriesElement.addElement("accountNumber").addText(getCustomer().getAccountNumber());
		}
		if (getRecipient() != null && getRecipient().getAccountNumber() != null && !"".equals(getRecipient().getAccountNumber().trim())) {
			seriesElement.addElement("shipToAccountNumber").addText(getRecipient().getAccountNumber());
		}
		if (getPayment() != null) {
			if (getPayment().getCreditCardExpire() != null && !"".equals(getPayment().getCreditCardExpire().trim())) {
				seriesElement.addElement("creditCardExpire").addText(getPayment().getCreditCardExpire());
			}
			if (getPayment().getCreditCardExpireMonth() != null && !"".equals(getPayment().getCreditCardExpireMonth().trim())) {
				seriesElement.addElement("creditCardExpireMonth").addText(getPayment().getCreditCardExpireMonth());
			}
			if (getPayment().getCreditCardExpireYear() != null && !"".equals(getPayment().getCreditCardExpireYear().trim())) {
				seriesElement.addElement("creditCardExpireYear").addText(getPayment().getCreditCardExpireYear());
			}
			if (getPayment().getCreditCardType() != null && !"".equals(getPayment().getCreditCardType().trim())) {
				seriesElement.addElement("creditCardType").addText(getPayment().getCreditCardType());
			}
			if (getPayment().getCreditCardCVV() != null && !"".equals(getPayment().getCreditCardCVV().trim())) {
				seriesElement.addElement("creditCardCVV").addText(getPayment().getCreditCardCVV());
			}
			if (getPayment().getCreditCardNumber() != null && !"".equals(getPayment().getCreditCardNumber().trim())) {
				seriesElement.addElement("creditCardNumber").addText(getPayment().getCreditCardNumber());
			}
		}
		//
		return seriesElement.asXML();
	}
	/**
	 * 
	 * @param seriesElements
	 * @param debug
	 * @param transaction
	 * @return
	 */
	public void populateFromXml(Element seriesElement) {
		Element childElement = null;
		SeriesInterest seriesInterest = new SeriesInterest();
		//Ask the document for the <series> tag it contains
		for (Iterator<Element> it = seriesElement.elements().iterator(); it.hasNext(); ) {
			childElement = it.next();
			System.out.println("childElement: " + childElement.getName());
			if ("orderType".equalsIgnoreCase(childElement.getName())) {
				setOrderType(childElement.getText());
			} else if ("promotionKey".equalsIgnoreCase(childElement.getName())) {
				setPromotionKey(childElement.getText());
			} else if ("quantity".equalsIgnoreCase(childElement.getName())) {
				setQuantity(childElement.getText());
			} else if ("sourceCd".equalsIgnoreCase(childElement.getName())) {
				setSourceCd(childElement.getText());
			} else if ("quantityAlreadyReceived".equalsIgnoreCase(childElement.getName())) {
				setQuantityAlreadyReceived(childElement.getText());
			} else if ("quantityAlreadyReceivedDate".equalsIgnoreCase(childElement.getName())) {
				setQuantityAlreadyReceivedDate(childElement.getText());
			} else if ("receiveDate".equalsIgnoreCase(childElement.getName())) {
				setReceiveDate(childElement.getText());
			} else if ("poNumber".equalsIgnoreCase(childElement.getName())) {
				setPoNumber(childElement.getText());
			} else if ("invoiceNumber".equalsIgnoreCase(childElement.getName())) {
				setInvoiceNumber(childElement.getText());
			} else if ("planCode".equalsIgnoreCase(childElement.getName())) {
				setPlanCode(childElement.getText());
			} else if ("frequency".equalsIgnoreCase(childElement.getName())) {
				System.out.println("frequency: " + childElement.getText());
				setFrequency(childElement.getText());
				System.out.println("frequency: " + getFrequency());
			} else if ("planDescription".equalsIgnoreCase(childElement.getName())) {
				setPlanDescription(childElement.getText());
			} else if ("planStatus".equalsIgnoreCase(childElement.getName())) {
				setPlanStatus(childElement.getText());
			} else if ("planStatusDescription".equalsIgnoreCase(childElement.getName())) {
				setPlanStatusDescription(childElement.getText());
			} else if ("interest".equalsIgnoreCase(childElement.getName())) {
				setInterest(childElement.getText());
			} else if ("unpaids".equalsIgnoreCase(childElement.getName())) {
				setUnpaids(childElement.getText());
			} else if ("unpaidDollars".equalsIgnoreCase(childElement.getName())) {
				setUnpaidDollars(childElement.getText());
			} else if ("shipDate".equalsIgnoreCase(childElement.getName())) {
				setShipDate(childElement.getText());
			} else if ("paidDate".equalsIgnoreCase(childElement.getName())) {
				setPaidDate(childElement.getText());
			} else if ("cycleDate".equalsIgnoreCase(childElement.getName())) {
				setCycleDate(childElement.getText());
			} else if ("suspendDate".equalsIgnoreCase(childElement.getName())) {
				setSuspendDate(childElement.getText());
			} else if ("resumeServiceDate".equalsIgnoreCase(childElement.getName())) {
				setResumeServiceDate(childElement.getText());
			} else if ("numberOfValidInterest".equalsIgnoreCase(childElement.getName())) {
				setNumberOfValidInterest(childElement.getText());
			} else if ("customer".equalsIgnoreCase(childElement.getName())) {
				List<Element> customers = new ArrayList<Element>();
				customers.add(childElement);
				getCustomer().populateFromXmlNode(customers);
			} else if ("recipient".equalsIgnoreCase(childElement.getName())) {
				List<Element> recipients = new ArrayList<Element>();
				recipients.add(childElement);
				getRecipient().populateFromXmlNode(recipients);
			} else if ("payment".equalsIgnoreCase(childElement.getName())) {
				List<Element> payments = new ArrayList<Element>();
				payments.add(childElement);
				getPayment().populateFromXmlNode(payments);
			} else if ("interestEntries".equalsIgnoreCase(childElement.getName())) {
				List elements = childElement.elements();
				seriesInterest = new SeriesInterest();
				Element element = null;
				for(Iterator ei = elements.iterator(); ei.hasNext(); ) {
					element = (Element)ei.next();
					if ("interest".equalsIgnoreCase(element.getName())) {
						seriesInterest.setInterestCode(element.getText());
					} else if ("planDescription".equalsIgnoreCase(element.getName())) {
						seriesInterest.setInterestCodeDescription(element.getText());
					}
				}
				interestEntries.add(seriesInterest);
			}
		}
	}
	public ArrayList<SeriesInterest> getInterestEntries() {
		return interestEntries;
	}
	public void setInterestEntries(ArrayList<SeriesInterest> interestEntries) {
		this.interestEntries = interestEntries;
	}
	public String getPlanCode() {
		return planCode;
	}
	public void setPlanCode(String planCode) {
		this.planCode = planCode;
	}
	public String getCycleDate() {
		return cycleDate;
	}
	public void setCycleDate(String cycleDate) {
		this.cycleDate = cycleDate;
	}
	public String getFrequency() {
		return frequency;
	}
	public void setFrequency(String frequency) {
		this.frequency = frequency;
	}
	public String getInterest() {
		return interest;
	}
	public void setInterest(String interest) {
		this.interest = interest;
	}
	public String getNumberOfValidInterest() {
		return numberOfValidInterest;
	}
	public void setNumberOfValidInterest(String numberOfValidInterest) {
		this.numberOfValidInterest = numberOfValidInterest;
	}
	public String getPaidDate() {
		return paidDate;
	}
	public void setPaidDate(String paidDate) {
		this.paidDate = paidDate;
	}
	public String getPlanDescription() {
		return planDescription;
	}
	public void setPlanDescription(String planDescription) {
		this.planDescription = planDescription;
	}
	public String getPlanStatus() {
		return planStatus;
	}
	public void setPlanStatus(String planStatus) {
		this.planStatus = planStatus;
	}
	public String getPlanStatusDescription() {
		return planStatusDescription;
	}
	public void setPlanStatusDescription(String planStatusDescription) {
		this.planStatusDescription = planStatusDescription;
	}
	public String getResumeServiceDate() {
		return resumeServiceDate;
	}
	public void setResumeServiceDate(String resumeServiceDate) {
		this.resumeServiceDate = resumeServiceDate;
	}
	public String getShipDate() {
		return shipDate;
	}
	public void setShipDate(String shipDate) {
		this.shipDate = shipDate;
	}
	public String getSuspendDate() {
		return suspendDate;
	}
	public void setSuspendDate(String suspendDate) {
		this.suspendDate = suspendDate;
	}
	public String getUnpaidDollars() {
		return unpaidDollars;
	}
	public void setUnpaidDollars(String unpaidDollars) {
		this.unpaidDollars = unpaidDollars;
	}
	public String getUnpaids() {
		return unpaids;
	}
	public void setUnpaids(String unpaids) {
		this.unpaids = unpaids;
	}
	public String getInvoiceNumber() {
		return invoiceNumber;
	}
	public void setInvoiceNumber(String invoiceNumber) {
		this.invoiceNumber = invoiceNumber;
	}
	public String getOrderType() {
		return orderType;
	}
	public void setOrderType(String orderType) {
		this.orderType = orderType;
	}
	public String getPoNumber() {
		return poNumber;
	}
	public void setPoNumber(String poNumber) {
		this.poNumber = poNumber;
	}
	public String getPromotionKey() {
		return promotionKey;
	}
	public void setPromotionKey(String promotionKey) {
		this.promotionKey = promotionKey;
	}
	public String getQuantityAlreadyReceived() {
		return quantityAlreadyReceived;
	}
	public void setQuantityAlreadyReceived(String quantityAlreadyReceived) {
		this.quantityAlreadyReceived = quantityAlreadyReceived;
	}
	public String getQuantityAlreadyReceivedDate() {
		return quantityAlreadyReceivedDate;
	}
	public void setQuantityAlreadyReceivedDate(String quantityAlreadyReceivedDate) {
		this.quantityAlreadyReceivedDate = quantityAlreadyReceivedDate;
	}
	public String getReceiveDate() {
		return receiveDate;
	}
	public void setReceiveDate(String receiveDate) {
		this.receiveDate = receiveDate;
	}
	public String getSourceCd() {
		return sourceCd;
	}
	public void setSourceCd(String sourceCd) {
		this.sourceCd = sourceCd;
	}
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	public Payment getPayment() {
		return payment;
	}
	public void setPayment(Payment payment) {
		this.payment = payment;
	}
	public Customer getRecipient() {
		return recipient;
	}
	public void setRecipient(Customer recipient) {
		this.recipient = recipient;
	}
	public String getQuantity() {
		return quantity;
	}
	public void setQuantity(String quantity) {
		this.quantity = quantity;
	}
}
