package com.cds.global;

import java.util.HashMap;
import java.util.Map;

import com.cds.global.api.Customer;
import com.cds.global.api.Order;
import com.cds.global.api.OrderItem;
import com.cds.global.api.Payment;
import com.cds.global.api.TransactionSource;
import com.cds.global.api.WSG;
import com.cds.global.api.WSGResponse;

public class TestOrder1 {

	public static void main(String args[]) {
	        String[] prodAbbrs = { "RDO"};
	        WSG wsg = new WSG();
	        WSGResponse wsgr = null;
	        Customer  customer= null;
	        int i=0;
	        for (String prodAbbr : prodAbbrs) {
	            wsg.setAppId("onepassipad"); // ipad id
                wsg.setPassword("2073465336"); // ipad password
                wsg.setProdAbbr(prodAbbr);
                wsgr = wsg.lookupCustomer("819295684");
                if (wsgr.isSuccess()) {
                	System.out.println(wsgr.getDataRecieved());
                	customer = (Customer) wsgr.getObjects().get(0);
                }
                //customer =  new Customer("819295684");
                customer.setEmail("testshanu@mailinator.com");
                
    			Order order = new Order();
    			order.setCustomer(customer);
    			order.setPromotionKey("IE6FFVAL");
    			order.setOrderType("N");
    			Payment payment = new Payment();
    			payment.setPaymentType("CASH");
    			Map<String,String> permissions = new HashMap<String,String>();
    			permissions.put("emailAuthorization", "Y");
    	        customer.setPermissions(permissions);
    			OrderItem orderItem = new OrderItem();
    			orderItem.setSubscriptionTerm("006");
    			orderItem.setValue("00001");
    			order.getOrderItems().add(orderItem);
    			order.setPayment(payment);
    			wsgr = wsg.addOrder(order);
    			if (wsgr.isSuccess()) {
    				System.out.println(wsgr.getDataRecieved());
    				System.out.println("Order Worked");
    			} else {
    				System.out.println("Order no workey...");
    				for(int j = 0; j < wsgr.getErrorMessages().size(); j++) {
    					System.out.println("Error Message " + (j+1) + ": " + wsgr.getErrorMessages().get(j));
    				}
    			}
//    			wsg.setToLocal();
//    			TransactionSource tsAttr = new TransactionSource();
//    			tsAttr.setKey("jamie");
//    			tsAttr.setValue("Order");
//    			TransactionSource tsElm = new TransactionSource();
//    			tsElm.setKey("coffe");
//    			tsElm.setValue("GOOD");
//    			tsElm.setAttribute(false);
//    			wsg.addTransactionSource(tsAttr);
//    			wsg.addTransactionSource(tsElm);
    			wsgr = wsg.addOrder(order);
    			//
//    			if (wsgr.isSuccess()) {
//    				System.out.println("Order Worked");
//    				System.out.println(wsgr.getDataRecieved());
//    			} else {
//    				System.out.println("Order no workey...");
//    				for(int j = 0; i < wsgr.getErrorMessages().size(); j++) {
//    					System.out.println("Error Message " + (j+1) + ": " + wsgr.getErrorMessages().get(j));
//    				}
//    			}
    		
//	        
	        }
	    }
}
