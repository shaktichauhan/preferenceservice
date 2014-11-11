package com.cds.global;

import java.text.SimpleDateFormat;
import java.util.Date;

import com.cds.global.api.Customer;
import com.cds.global.api.Order;
import com.cds.global.api.OrderItem;
import com.cds.global.api.Payment;
import com.cds.global.api.TransactionSource;
import com.cds.global.api.WSG;
import com.cds.global.api.WSGResponse;

public class DOMSTest {

	public static void main(String args[]) {
		Customer customer = null;
		WSG wsg = new WSG("wsgapi","4571721893","008");
		wsg.setToLocal();
		WSGResponse wsgr = wsg.lookupCustomer(new Long("1"));
		//
		if (wsgr.isSuccess()) {
			System.out.println("Customer Lookup Worked");
		} else {
			System.out.println("Customer Lookup no workey...");
			for(int i = 0; i < wsgr.getErrorMessages().size(); i++) {
				System.out.println("Error Message " + (i+1) + ": " + wsgr.getErrorMessages().get(i));
			}
		}
		//
		if (wsgr.isSuccess()) {
			customer = (Customer)wsgr.getObjects().get(0);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd-HH.mm.ss");
			customer.setAddress2(sdf.format(new Date()));
			wsg = new WSG("wsgapi","4571721893","008");
			TransactionSource tsAttr = new TransactionSource();
			tsAttr.setKey("jamie");
			tsAttr.setValue("CustomerUpdate");
			TransactionSource tsElm = new TransactionSource();
			tsElm.setKey("infinity");
			tsElm.setValue("AndBeyond");
			tsElm.setAttribute(false);
			wsg.setToLocal();
			wsg.addTransactionSource(tsAttr);
			wsg.addTransactionSource(tsElm);
			wsgr = wsg.updateCustomer(customer);
			//
			if (wsgr.isSuccess()) {
				System.out.println("Customer Update Worked");
			} else {
				System.out.println("Customer Update no workey...");
				for(int i = 0; i < wsgr.getErrorMessages().size(); i++) {
					System.out.println("Error Message " + (i+1) + ": " + wsgr.getErrorMessages().get(i));
				}
			}
		}
		//
		if (wsgr.isSuccess()) {
			Order order = new Order();
			order.setCustomer(customer);
			OrderItem orderItem = new OrderItem();
			orderItem.setProductNumber("265");
			orderItem.setQuantity("1");
			orderItem.setSubscriptionTerm("2");
			orderItem.setValue("30.00");
			orderItem.setOfferCode("1YR1995");
			Payment payment = new Payment();
			payment.setPaymentType("Credit Card");
			payment.setCreditCardNumber("5555544443332213");
			payment.setCreditCardExpire("0121");
			payment.setCreditCardType("MC");
			payment.setCreditCardCVV("123");
			order.getOrderItems().add(orderItem);
			order.setPayment(payment);
			//
			wsg = new WSG("wsgapi","4571721893","008");
			wsg.setToLocal();
			TransactionSource tsAttr = new TransactionSource();
			tsAttr.setKey("jamie");
			tsAttr.setValue("Order");
			TransactionSource tsElm = new TransactionSource();
			tsElm.setKey("coffe");
			tsElm.setValue("GOOD");
			tsElm.setAttribute(false);
			wsg.addTransactionSource(tsAttr);
			wsg.addTransactionSource(tsElm);
			wsgr = wsg.addOrder(order);
			//
			if (wsgr.isSuccess()) {
				System.out.println("Order Worked");
			} else {
				System.out.println("Order no workey...");
				for(int i = 0; i < wsgr.getErrorMessages().size(); i++) {
					System.out.println("Error Message " + (i+1) + ": " + wsgr.getErrorMessages().get(i));
				}
			}
		}
	}
}
