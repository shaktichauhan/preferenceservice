package com.cds.global;

import java.util.Iterator;

import com.cds.global.api.Customer;
import com.cds.global.api.Entitlements;
import com.cds.global.api.Order;
import com.cds.global.api.OrderItem;
import com.cds.global.api.OrderOverview;
import com.cds.global.api.Payment;
import com.cds.global.api.Series;
import com.cds.global.api.WSG;
import com.cds.global.api.WSGResponse;

public class Test {

	public static void main(String args[]) {
	        String[] prodAbbrs = { "RDO"};
	        WSG wsg = new WSG();
	        WSGResponse wsgr = null;
	        Entitlements  entitle= null;
	        int i=0;
	        for (String prodAbbr : prodAbbrs) {
	            wsg.setAppId("onepassipad"); // ipad id
                wsg.setPassword("2073465336"); // ipad password
                wsg.setProdAbbr(prodAbbr);
                wsgr = wsg.getEntitlements("198275018");
                System.out.println("\n \n *** i = " +i);
                System.out.println("\n \n *** wsgr.isSuccess() = "+ wsgr.isSuccess());
                System.out.println(wsgr.getDataRecieved());
                i++;
                if (wsgr.isSuccess()) {
                	System.out.println(wsgr.getDataRecieved());
                	entitle = (Entitlements) wsgr.getObjects().get(0);
                    
//                    System.out.println(entitle.getAccountNumber());
//                    if(entitle.getIssues() != null) {
//                    	Iterator<String> iterator = entitle.getIssues().iterator();
//                        while(iterator.hasNext()) {
//                        	String issue = iterator.next();
//                        	System.out.println("\n fdfdfd*****************"+issue);
//                        
//                        }
//                    }
                   // Iterator<String> iterator = customer.getIssues().iterator();
                    //System.out.println("\n fdfdfd*****************"+customer.getIssues().size());
                    break;
                }
	        }
//	        WSG wsg = new WSG("onepassipad","2073465336","FHO");
//        
//	       // WSGResponse response = wsg.lookupCustomer("melaniephd@gmail.com");
//	       ///wsg.setToLocal();
//	         WSGResponse response = wsg.lookupCustomer("480187525");
	         
//	         Customer customer = new Customer();
//	         customer.setAccountNumber("480187525");
//	         customer.setPassword("10610");
	          //response = wsg.updateCustomer(customer);
	         
	        
	         //1206522114814
//	         Order order = new Order();
//	         order.setOrderNumber("1206522114814");
//	         WSGResponse response = wsg.lookupOrder(order);
//	        
//	        Customer customer = new Customer();
//	        customer.setAccountNumber("95528766");
//	        customer.setEmail("markupdate@callisfamily.net");
//	        customer.setName("Mark Update");
//	        WSGResponse response =wsg.updateCustomer(customer);
	        
//	        System.out.println(response.getDataRecieved());
//	        System.out.println(response.getTransactionId());
//	        System.out.println(response.isSuccess());
//	        
	    }
}
