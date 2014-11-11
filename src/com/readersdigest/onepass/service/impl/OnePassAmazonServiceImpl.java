package com.readersdigest.onepass.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;

import com.cds.global.api.Customer;
import com.cds.global.api.Entitlements;
import com.cds.global.api.MultiMag;
import com.cds.global.api.Order;
import com.cds.global.api.OrderItem;
import com.cds.global.api.Payment;
import com.cds.global.api.WSG;
import com.cds.global.api.WSGResponse;
import com.readersdigest.exacttarget.client.ETExtensionServices;
import com.readersdigest.exacttarget.client.impl.ETExtensionServicesImpl;
import com.readersdigest.exacttarget.dto.DigitalProfile;
import com.readersdigest.exacttarget.dto.ETResponse;
import com.readersdigest.exacttarget.dto.PersonalizationParameters;
import com.readersdigest.exacttarget.dto.TriggeredSendMail;
import com.readersdigest.onepass.db.EntityManagerHelper;
import com.readersdigest.onepass.db.IMemberDAO;
import com.readersdigest.onepass.db.IMemberOnePassInfoDAO;
import com.readersdigest.onepass.db.Member;
import com.readersdigest.onepass.db.MemberDAO;
import com.readersdigest.onepass.db.MemberOnePassInfo;
import com.readersdigest.onepass.db.MemberOnePassInfoDAO;
import com.readersdigest.onepass.dto.EntitlementsDTO;
import com.readersdigest.onepass.dto.OnePassServiceAmazonResponse;
import com.readersdigest.onepass.dto.OnePassServiceRequest;
import com.readersdigest.onepass.dto.OnePassServiceResponse;
import com.readersdigest.onepass.exception.ServiceException;
import com.readersdigest.onepass.service.OnePassAmazonService;
import com.readersdigest.onepass.util.OneWayEncrypter;
import com.readersdigest.onepass.util.RSAEncryptionDescription;
import com.readersdigest.onepass.util.StringUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class OnePassAmazonServiceImpl.
 * 
 * 
 * @author shsingh
 * 
 */
public class OnePassAmazonServiceImpl implements OnePassAmazonService {


    /** The member dao. */
    private IMemberDAO memberDAO;

    /** The member one pass info dao. */
    private IMemberOnePassInfoDAO memberOnePassInfoDAO;

    /** The service validator. */
    private ServiceValidator serviceValidator;

   
    /** The Constant ACTIVE_MEMBER. */
    public static final String ACTIVE_MEMBER = "A";
    
    /** The Constant INACTIVE_MEMBER. */
    public static final String INACTIVE_MEMBER = "I";
    
    /**
     * Instantiates a new one pass service impl.
     */
    public OnePassAmazonServiceImpl() {
        memberDAO = new MemberDAO();
        serviceValidator = new ServiceValidator();
        memberOnePassInfoDAO = new MemberOnePassInfoDAO();
    }


	
    /* (non-Javadoc)
     * @see com.readersdigest.onepass.service.OnePassAmazonService#onePassValidation(com.readersdigest.onepass.dto.OnePassServiceRequest)
     */
    public OnePassServiceAmazonResponse onePassValidation(OnePassServiceRequest onePassRequest) {
    	OnePassServiceAmazonResponse response =  new OnePassServiceAmazonResponse();
    	
		try {
			if(!serviceValidator.amazonAutherizationValidation(onePassRequest)) {
	        	 response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
	             response.editCode = "13"; // Required PArameters validation
	             response.status = getBundleStringValue("transactionFailed");
	             response.detailMessage = new ArrayList<String>();
	             response.detailMessage.add("Unauthorized Request");
	             return response;
	        }
	
			try {
                serviceValidator.amazonCDSValidation(onePassRequest);
            } catch (ServiceException ex) {

                response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
            	response.editCode = "11"; // Required PArameters validation
            	response.status = getBundleStringValue("transactionFailed");
            	response.detailMessage = new ArrayList<String>();
            	response.detailMessage.add(ex.getMessage());
            }
			
	      	WSGResponse wsgr = lookupCustomer(onePassRequest);
			
			Customer customer = null;
			List<MemberOnePassInfo> memberOnePassInfoList = null;
			
			if(wsgr.isSuccess()) {
					System.out.println(wsgr.getDataRecieved());
			    	customer = (Customer) wsgr.getObjects().get(0);
			    	List<MultiMag> multiMagList = customer.getMultiMag();
			    	boolean callOrder = true;
			    	if(multiMagList != null && multiMagList.size() > 0) {
			    		for(MultiMag multiMag : multiMagList) {
			    			String magAbbrevation = multiMag.getMagAbbreviation();
			    			if(onePassRequest.brandCode.equalsIgnoreCase(magAbbrevation)) {
			    				System.out.println("in mag abbrevation");
			    				callOrder = false;
			    				break;
			    			}
			    		}
			    		
			    		if(callOrder) {
			    			WSG wsg = null;
			    	        String prodAbbr = StringUtils.getKindleProdId(onePassRequest.appId);
			    	        
			    	        wsg = new WSG(getBundleStringValue("cdsKindleAppId"), getBundleStringValue("cdsKindlePassword"), prodAbbr);
			    			Order order = new Order();
			    			//customer.setEmail(onePassRequest.emailAddress);
			    			order.setCustomer(customer);
			    			order.setPromotionKey(getBundleStringValue("promo_key"));
			    			order.setOrderType(getBundleStringValue("order_type"));
			    			Payment payment = new Payment();
			    			payment.setPaymentType(getBundleStringValue("payment_type"));
			    			Map<String,String> permissions = new HashMap<String,String>();
			    			permissions.put("emailAuthorization", "Y");
			    	        customer.setPermissions(permissions);
			    			OrderItem orderItem = new OrderItem();
			    			orderItem.setSubscriptionTerm(getBundleStringValue("subscription_term"));
			    			orderItem.setValue(getBundleStringValue("item_value"));
			    			order.getOrderItems().add(orderItem);
			    			order.setPayment(payment);
			    			wsgr = wsg.addOrder(order);
			    			if (wsgr.isSuccess()) {
			    				System.out.println(wsgr.getDataRecieved());
			    				response.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
			                	response.accountNumber = customer.getAccountNumber();
			                   	response.emailAddress = customer.getEmail();
			                	response.editCode = "1"; // for rda non registered user
			                	response.status = getBundleStringValue("transactionSuccess");
			                	response.detailMessage = new ArrayList<String>();
			                	response.detailMessage.add(getBundleStringValue("transactionSuccessMessage"));
			    			} else {
			    				System.out.println("Order no workey...");
			    				response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
			                	response.accountNumber = customer.getAccountNumber();
			                   	response.emailAddress = customer.getEmail();
			                	response.editCode = "6"; // for rda registered user
			                	response.status = getBundleStringValue("transactionFailed");
			                	response.detailMessage = wsgr.getErrorMessages();
			          		}
			    		} else {
			    			String strAccountNumber = customer.getAccountNumber();
			                int accountLength = strAccountNumber.length();
			                for (int i = accountLength; i < 10; i++) {
			                    strAccountNumber = "0" + strAccountNumber;
			                }
			                
			    			memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("accountNumber", "prodId", "active", strAccountNumber, onePassRequest.brandCode, ACTIVE_MEMBER);
			    			
			    			if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
			                    for (MemberOnePassInfo memberOnePassInfo : memberOnePassInfoList) {
			                    	memberOnePassInfo = memberOnePassInfoDAO.refresh(memberOnePassInfo);
			                    	response.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
			                    	response.accountNumber = memberOnePassInfo.getAccountNumber();
			                       	response.emailAddress = memberOnePassInfo.getEmailAddress();
			                       	if(memberOnePassInfo.getPassword() != null && !"".equals(memberOnePassInfo.getPassword())) {
			                       		response.editCode = "2"; // for rdo registered user
			                       	} else {
			                       		response.editCode = "5"; // for rdo registered user but don't have password
			                       	}
			                    	response.status = getBundleStringValue("transactionSuccess");
			                    	response.detailMessage = new ArrayList<String>();
			                    	response.detailMessage.add(getBundleStringValue("transactionSuccessMessage"));
			                    }
			    			} else {
			    				response.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
			                	response.accountNumber = customer.getAccountNumber();
			                   	response.emailAddress = customer.getEmail();
			                   	response.editCode = "3"; // for rdo non registered user
			                   	response.status = getBundleStringValue("transactionSuccess");
			                	response.detailMessage = new ArrayList<String>();
			                	response.detailMessage.add(getBundleStringValue("transactionSuccessMessage"));
			    			}
			    			
			    		}
			    	}
				} else {
					response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
			    	//response.accountNumber = customer.getAccountNumber();
			       //	response.emailAddress = customer.getEmail();
			    	response.editCode = "6"; // for rdo registered user
			    	response.status = getBundleStringValue("transactionFailed");
			    	response.detailMessage = wsgr.getErrorMessages();
					System.out.println(wsgr.getDataRecieved());
				}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
	    	//response.accountNumber = customer.getAccountNumber();
	       //	response.emailAddress = customer.getEmail();
	    	response.editCode = "20"; // for rdo registered user
	    	response.status = getBundleStringValue("transactionFailed");
	    	response.detailMessage = new ArrayList<String>();
        	response.detailMessage.add(e.getMessage());
		}
    
    	return response;
    }
    
    /* (non-Javadoc)
     * @see com.readersdigest.onepass.service.OnePassAmazonService#onePassRegistration(com.readersdigest.onepass.dto.OnePassServiceRequest)
     */
    public OnePassServiceAmazonResponse onePassRegistration(OnePassServiceRequest onePassRequest) {
    	
    	OnePassServiceAmazonResponse serviceResponse = new OnePassServiceAmazonResponse();
    	
    	 try {
    		 
    		 if(!serviceValidator.amazonAutherizationValidation(onePassRequest)) {
    			 serviceResponse.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
    			 serviceResponse.editCode = "13"; // Required PArameters validation
    			 serviceResponse.status = getBundleStringValue("transactionFailed");
    			 serviceResponse.detailMessage = new ArrayList<String>();
    			 serviceResponse.detailMessage.add("Unauthorized Request");
    			 return serviceResponse;
	         }
		 
    		 try {
                 serviceValidator.amazonRegistationValidation(onePassRequest);
             } catch (ServiceException ex) {
            	 
            	 serviceResponse.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
                 serviceResponse.emailAddress = onePassRequest.emailAddress;
                 serviceResponse.accountNumber = onePassRequest.accountNumber;
         		 serviceResponse.editCode = "11";
         		 serviceResponse.status = getBundleStringValue("transactionFailed");
                 serviceResponse.detailMessage = new ArrayList<String>();
                 serviceResponse.detailMessage.add(ex.getMessage());
                 return serviceResponse;
             }
    		 
    		     		 
    		String password = null;
			try {
				password = RSAEncryptionDescription.decryptData(onePassRequest.password);
			} catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
				serviceResponse.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
                serviceResponse.emailAddress = onePassRequest.emailAddress;
                serviceResponse.accountNumber = onePassRequest.accountNumber;
        		serviceResponse.editCode = "10";
        		serviceResponse.status = getBundleStringValue("transactionFailed");
                serviceResponse.detailMessage = new ArrayList<String>();
                serviceResponse.detailMessage.add(ex.getMessage());
                return serviceResponse;
				
			}
    		 
    		 try {
    			 try {
					serviceValidator.validEmail(onePassRequest.emailAddress);
				} catch (ServiceException e) {
					// TODO Auto-generated catch block
					 serviceResponse.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
	                 serviceResponse.emailAddress = onePassRequest.emailAddress;
	                 serviceResponse.accountNumber = onePassRequest.accountNumber;
	         		 serviceResponse.editCode = "7";
	         		 serviceResponse.status = getBundleStringValue("transactionFailed");
	                 serviceResponse.detailMessage = new ArrayList<String>();
	                 serviceResponse.detailMessage.add(e.getMessage());
	                 return serviceResponse;
				}
    			
    			 serviceValidator.validPassword(password);
    		 } catch (ServiceException ex) {
            	 
            	 serviceResponse.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
                 serviceResponse.emailAddress = onePassRequest.emailAddress;
                 serviceResponse.accountNumber = onePassRequest.accountNumber;
         		 serviceResponse.editCode = "16";
         		 serviceResponse.status = getBundleStringValue("transactionFailed");
                 serviceResponse.detailMessage = new ArrayList<String>();
                 serviceResponse.detailMessage.add(ex.getMessage());
                 return serviceResponse;
             }
    		 
    		 System.out.println("\n\n\n ***** password : " +  password);
    		 
    		 EntityManagerHelper.log("Start OnePassServiceImpl.createUserProfileInfo() ..", Level.INFO, null);
             
                          
             Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
//
             Member member = null;
             String accountNumber = onePassRequest.accountNumber;

             String prodAbbr = StringUtils.getKindleProdId(onePassRequest.appId);
              
             MemberOnePassInfo memberOnePassInfo = null;

             if (accountNumber != null && !"".equalsIgnoreCase(accountNumber.trim())) {

                 accountNumber = accountNumber.trim();
                 for (int i = accountNumber.length(); i < 10; i++) {
                     accountNumber = "0" + accountNumber;
                 }

             }
             
             Customer customer = null;
             WSGResponse wsgr = null;
             WSG wsg = null;
             
             if (accountNumber != null && !"".equalsIgnoreCase(accountNumber.trim())) {
              
                 wsg = new WSG(getBundleStringValue("cdsKindleAppId"), getBundleStringValue("cdsKindlePassword"), prodAbbr);
     
                 wsgr = wsg.lookupCustomer(accountNumber);

                 if (wsgr.isSuccess()) {

                   customer = (Customer) wsgr.getObjects().get(0);
                   List<MultiMag> multiMagList = customer.getMultiMag();
			    	boolean callOrder = true;
			    	if(multiMagList != null && multiMagList.size() > 0) {
			    		for(MultiMag multiMag : multiMagList) {
			    			String magAbbrevation = multiMag.getMagAbbreviation();
			    			if(onePassRequest.brandCode.equalsIgnoreCase(magAbbrevation)) {
			    				System.out.println("in mag abbrevation");
			    				callOrder = false;
			    				break;
			    			}
			    		}
			    	}

                     if (callOrder) {
                    	 serviceResponse.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
                         serviceResponse.emailAddress = onePassRequest.emailAddress;
                         serviceResponse.accountNumber = onePassRequest.accountNumber;
                 		 serviceResponse.editCode = "18";
                 		 serviceResponse.status = getBundleStringValue("transactionFailed");
                         serviceResponse.detailMessage = new ArrayList<String>();
                         serviceResponse.detailMessage.add("Account Number is not activated for RDO products.");
                         return serviceResponse;
                     } 
//                     else {
//                    	    if(!onePassRequest.emailAddress.trim().equalsIgnoreCase(customer.getEmail())) {
//                    	    	customer.setEmail(onePassRequest.emailAddress.trim());
//                        	 	wsgr = wsg.updateCustomer(customer);
//                        	 	if (!wsgr.isSuccess()) {
//                        	 		serviceResponse.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
//                        	 		serviceResponse.accountNumber = onePassRequest.accountNumber;
//                        	 		serviceResponse.emailAddress = onePassRequest.emailAddress.trim();
//                        	 		serviceResponse.editCode = "6"; // for rdo registered user
//                        	 		serviceResponse.status = getBundleStringValue("transactionFailed");
//                        	 		serviceResponse.detailMessage = wsgr.getErrorMessages();
//                					System.out.println(wsgr.getDataRecieved());
//                					return serviceResponse;
//                        	 	}
//                    	    }
//                    	 	
//                     } 
                 } else {
                     serviceResponse.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
                     serviceResponse.emailAddress = onePassRequest.emailAddress;
                     serviceResponse.accountNumber = onePassRequest.accountNumber;
                     serviceResponse.editCode = "6"; 
 			    	 serviceResponse.status = getBundleStringValue("transactionFailed");
 			    	 serviceResponse.detailMessage = wsgr.getErrorMessages();
 					 System.out.println(wsgr.getDataRecieved());
                     return serviceResponse;
                 }
             
             }
             
             EntityManagerHelper.beginTransaction();
                                     
             List<MemberOnePassInfo> memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active",
            		 onePassRequest.emailAddress.trim(), prodAbbr, ACTIVE_MEMBER);
             
             if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
            
            	 memberOnePassInfo = memberOnePassInfoList.get(0);
            	 memberOnePassInfo = memberOnePassInfoDAO.refresh(memberOnePassInfo);
            	 if (memberOnePassInfo.getAccountNumber() != null && 
                         !"".equals(memberOnePassInfo.getAccountNumber().trim())) {
            		 if (!accountNumber.equals(memberOnePassInfo.getAccountNumber())) {
            			 EntityManagerHelper.rollback();
                         serviceResponse.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
                         serviceResponse.emailAddress = onePassRequest.emailAddress;
                         serviceResponse.accountNumber = onePassRequest.accountNumber;
                 		 serviceResponse.editCode = "19";
                 		 serviceResponse.status = getBundleStringValue("transactionFailed");
                         serviceResponse.detailMessage = new ArrayList<String>();
                         serviceResponse.detailMessage.add(StringUtils.getBundleProperty("customerService.accountConfiguration.error"));
                         return serviceResponse;
            		 } else {
            			 memberOnePassInfo.setPassword(OneWayEncrypter.encryptString(password));
                    	 memberOnePassInfo.setCreateDate(timeStamp);
                         memberOnePassInfoDAO.update(memberOnePassInfo);
            		 }
            	 } else {
            		 List<MemberOnePassInfo> memberOnePassInfoAccountList = memberOnePassInfoDAO.findByProperties("accountNumber", "prodId", "active",
                    		 accountNumber, prodAbbr, ACTIVE_MEMBER); 
            		 
            		 if (memberOnePassInfoAccountList != null && memberOnePassInfoAccountList.size() > 0) {
            			 memberOnePassInfo = memberOnePassInfoAccountList.get(0);
            			 memberOnePassInfo = memberOnePassInfoDAO.refresh(memberOnePassInfo);
            		 }
            		 memberOnePassInfo.setPassword(OneWayEncrypter.encryptString(password));
                	 memberOnePassInfo.setAccountNumber(accountNumber);
                     memberOnePassInfo.setEmailAddress(onePassRequest.emailAddress.trim());
                     memberOnePassInfo.setUserType("CDS");
                     memberOnePassInfo.setActive(ACTIVE_MEMBER);
                     memberOnePassInfo.setZipCode(customer.getZipCode());
                     memberOnePassInfo.setFullName(customer.getName());
                     memberOnePassInfo.setCreateDate(timeStamp);
                     memberOnePassInfoDAO.update(memberOnePassInfo);
            	 }
             } else {
            	 List<MemberOnePassInfo> memberOnePassInfoAccountList = memberOnePassInfoDAO.findByProperties("accountNumber", "prodId", "active",
                		 accountNumber, prodAbbr, ACTIVE_MEMBER); 
            	 if (memberOnePassInfoAccountList != null && memberOnePassInfoAccountList.size() > 0) {
            		 memberOnePassInfo = memberOnePassInfoAccountList.get(0);
            		 memberOnePassInfo = memberOnePassInfoDAO.refresh(memberOnePassInfo);
        			 memberOnePassInfo.setPassword(OneWayEncrypter.encryptString(password));
                	 memberOnePassInfo.setAccountNumber(accountNumber);
                     memberOnePassInfo.setEmailAddress(onePassRequest.emailAddress.trim());
                     memberOnePassInfo.setUserType("CDS");
                     memberOnePassInfo.setActive(ACTIVE_MEMBER);
                     memberOnePassInfo.setZipCode(customer.getZipCode());
                     memberOnePassInfo.setFullName(customer.getName());
                     memberOnePassInfo.setCreateDate(timeStamp);
                     memberOnePassInfoDAO.update(memberOnePassInfo);
            	 } else {
            		 memberOnePassInfo = new MemberOnePassInfo();
            		 memberOnePassInfo.setPassword(OneWayEncrypter.encryptString(password));
                     memberOnePassInfo.setEmailAddress(onePassRequest.emailAddress.trim());
                     memberOnePassInfo.setProdId(prodAbbr);
                     memberOnePassInfo.setActive(ACTIVE_MEMBER);
                     memberOnePassInfo.setZipCode(customer.getZipCode());
                     memberOnePassInfo.setFullName(customer.getName());
                     memberOnePassInfo.setCreateDate(timeStamp);
                     memberOnePassInfo.setUserType("CDS");
                     memberOnePassInfo.setAccountNumber(accountNumber);
                     memberOnePassInfoDAO.save(memberOnePassInfo);
            	 }
             }
             
             if(!onePassRequest.emailAddress.trim().equalsIgnoreCase(customer.getEmail())) {
     	    	customer.setEmail(onePassRequest.emailAddress.trim());
         	 	wsgr = wsg.updateCustomer(customer);
         	 	if (!wsgr.isSuccess()) {
         	 		EntityManagerHelper.rollback();
         	 		serviceResponse.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
         	 		serviceResponse.accountNumber = onePassRequest.accountNumber;
         	 		serviceResponse.emailAddress = onePassRequest.emailAddress.trim();
         	 		serviceResponse.editCode = "6"; // for rdo registered user
         	 		serviceResponse.status = getBundleStringValue("transactionFailed");
         	 		serviceResponse.detailMessage = wsgr.getErrorMessages();
 					System.out.println(wsgr.getDataRecieved());
 					return serviceResponse;
         	 	}
     	    }
     	       
             //Add timer to execute the task in different thread to increase the performance
             Timer  timer = new Timer();             
             ETUpateTask etTask = new ETUpateTask();
             etTask.setCustomer(customer);
             etTask.setEmailAddress(onePassRequest.emailAddress.trim());
             etTask.setSourceCode(onePassRequest.brandCode);
             timer.schedule(etTask, 1000);
             
             EntityManagerHelper.commit();
             
             EntityManagerHelper.log("End OnePassServiceImpl.createUserProfileInfo() ..", Level.INFO, null);
         } catch (ServiceException ex) {
             EntityManagerHelper.log("Error OnePassServiceImpl.createUserProfileInfo() ..", Level.ALL, ex);
             ex.printStackTrace();
             EntityManagerHelper.rollback();
             serviceResponse.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
     		 serviceResponse.editCode = "20";
     		 serviceResponse.status = getBundleStringValue("transactionFailed");
             serviceResponse.detailMessage = new ArrayList<String>();
             serviceResponse.detailMessage.add(ex.getMessage());
             return serviceResponse;

         } catch (Exception ex) {
             EntityManagerHelper.log("Error OnePassServiceImpl.createUserProfileInfo() ..", Level.ALL, ex);
             ex.printStackTrace();
             EntityManagerHelper.rollback();
             serviceResponse.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
             serviceResponse.emailAddress = onePassRequest.emailAddress;
             serviceResponse.accountNumber = onePassRequest.accountNumber;
     		 serviceResponse.editCode = "20";
     		 serviceResponse.status = getBundleStringValue("transactionFailed");
             serviceResponse.detailMessage = new ArrayList<String>();
             serviceResponse.detailMessage.add(ex.getMessage());
             return serviceResponse;

         } finally {
             EntityManagerHelper.clear();
             EntityManagerHelper.closeEntityManager();
         }

         serviceResponse.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
         serviceResponse.emailAddress = onePassRequest.emailAddress;
         serviceResponse.accountNumber = onePassRequest.accountNumber;
         serviceResponse.editCode = "4";
         serviceResponse.status = getBundleStringValue("transactionSuccess");
         serviceResponse.detailMessage = new ArrayList<String>();
         serviceResponse.detailMessage.add(getBundleStringValue("transactionSuccessMessage"));
        return serviceResponse;
    	
    }
    
    class ETUpateTask extends TimerTask {
    	
        public void run() {
        	 DigitalProfile profile = new DigitalProfile();
        	 if(customer != null) {
            	 profile.setAddress1(customer.getAddress1());
         		 profile.setAddress2(customer.getAddress2());
         		 profile.setCity(customer.getCity());
         		 //profile.setFirstName(onePassRequest.firstName);
         		 //profile.setLastName(dto.addressFields.lastName);
        		 profile.setPostalCode(customer.getZipCode());
         		 profile.setStateProvinceCode(customer.getState()); 
             }
     		 
     		 profile.setLastUpdateDate(String.valueOf(System.currentTimeMillis()));//please use time miles in long and pass as a String
     
     		 profile.setEmailAddress(getEmailAddress());
     		// String sourceName = StringUtils.getSourceName();
     		 profile.setSource(StringUtils.getSourceNameByProdabbr(sourceCode)); /// Set the Source Name
     		
     		ETExtensionServices eTExtensionServices = new ETExtensionServicesImpl();
     		ETResponse etResponse = eTExtensionServices.addUpdateDigitalProfile("onepass", profile);
     		
     		System.out.println("\n\n **********  etResponse.getCode() : " + etResponse.getCode());
     	
     		
//     		if(etResponse.getDetailedMessages() != null) {
//     			for(int i=0; i<etResponse.getDetailedMessages().length; i++) {
//     				System.out.println("\n\n **********  etResponse.getDetailedMessage " + i +": " + etResponse.getDetailedMessages()[i]);
//     			}
//     		}
     		
        }
        
        private Customer customer;
        
        private String  emailAddress;
        
        private String  sourceCode;

		public String getSourceCode() {
			return sourceCode;
		}

		public void setSourceCode(String sourceCode) {
			this.sourceCode = sourceCode;
		}

		public String getEmailAddress() {
			return emailAddress;
		}

		public void setEmailAddress(String emailAddress) {
			this.emailAddress = emailAddress;
		}

		public Customer getCustomer() {
			return customer;
		}

		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
        
        
     }

    /* (non-Javadoc)
     * @see com.readersdigest.onepass.service.OnePassAmazonService#onePassSubscriptionStatus(com.readersdigest.onepass.dto.OnePassServiceRequest)
     */
    public OnePassServiceAmazonResponse onePassSubscriptionStatus(OnePassServiceRequest onePassRequest) {
    	OnePassServiceAmazonResponse response = new OnePassServiceAmazonResponse();
    	try {
    		
    		if(!serviceValidator.amazonAutherizationValidation(onePassRequest)) {
	        	 response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
	             response.editCode = "13"; // Required PArameters validation
	             response.status = getBundleStringValue("transactionFailed");
	             response.detailMessage = new ArrayList<String>();
	             response.detailMessage.add("Unauthorized Request");
	             return response;
	        }
    		
    		try {
                serviceValidator.amazonSubscriptionValidation(onePassRequest);
            } catch (ServiceException ex) {
           	 
            	response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
                response.editCode = "11";
        		response.status = getBundleStringValue("transactionFailed");
        		response.detailMessage = new ArrayList<String>();
        		response.detailMessage.add(ex.getMessage());
                return response;
            }
    		
    		WSGResponse wsgr = lookupCustomer(onePassRequest);
			Customer customer = null;
			System.out.println("\n\n\n ******shakti onePassRequest " + onePassRequest.accountNumber);
			System.out.println("\n\n\n ******shakti wsgr.isSuccess() " + wsgr.isSuccess());
			if(wsgr.isSuccess()) {
					System.out.println(wsgr.getDataRecieved());
			    	customer = (Customer) wsgr.getObjects().get(0);
			    	List<MultiMag> multiMagList = customer.getMultiMag();
			    	boolean callOrder = true;
			    	if(multiMagList != null && multiMagList.size() > 0) {
			    		for(MultiMag multiMag : multiMagList) {
			    			String magAbbrevation = multiMag.getMagAbbreviation();
			    			if(onePassRequest.brandCode.equalsIgnoreCase(magAbbrevation)) {
			    				System.out.println("in mag abbrevation");
			    				response.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
						    	response.emailAddress = customer.getEmail();
						    	response.accountNumber = customer.getAccountNumber();
						    	response.editCode = "0";
						    	response.serviceSubscriptionDescription = multiMag.getServiceStatusDescription();
						    	response.serviceSubscriptionStatus = multiMag.getServiceStatus();
						    	response.status = getBundleStringValue("transactionSuccess");
						    	response.detailMessage = new ArrayList<String>();
						    	response.detailMessage.add(getBundleStringValue("transactionSuccessMessage"));
						    	callOrder = false;
			    				break;
			    			}
			    		}
			    	}
			    	
			    	if(callOrder) {
			    		response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
				    	response.editCode = "18";
				    	response.status = getBundleStringValue("transactionFailed");
				    	response.detailMessage = new ArrayList<String>();
			            response.detailMessage.add("Account Number is not activated for RDO products.");
			    	}
 			} else {
					System.out.println(wsgr.getDataRecieved());
					response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
			    	response.editCode = "6";
			    	response.status = getBundleStringValue("transactionFailed");
			    	response.detailMessage = wsgr.getErrorMessages();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
            response.editCode = "20";
            response.status = getBundleStringValue("transactionFailed");
            response.detailMessage = new ArrayList<String>();
            response.detailMessage.add(e.getMessage());
		}
   
    	return response;
    }

    /* (non-Javadoc)
     * @see com.readersdigest.onepass.service.OnePassAmazonService#onePassEntitlements(com.readersdigest.onepass.dto.OnePassServiceRequest)
     */
    public OnePassServiceAmazonResponse onePassEntitlements(OnePassServiceRequest onePassRequest) {
    	
    	OnePassServiceAmazonResponse response = new OnePassServiceAmazonResponse();
    	try {
    		
    		if(!serviceValidator.amazonAutherizationValidation(onePassRequest)) {
	        	 response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
	             response.editCode = "13"; // Required PArameters validation
	             response.status = getBundleStringValue("transactionFailed");
	             response.detailMessage = new ArrayList<String>();
	             response.detailMessage.add("Unauthorized Request");
	             return response;
	        }
    		
    		try {
                serviceValidator.amazonSubscriptionValidation(onePassRequest);
            } catch (ServiceException ex) {
           	 
            	response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
                response.editCode = "11";
        		response.status = getBundleStringValue("transactionFailed");
        		response.detailMessage = new ArrayList<String>();
        		response.detailMessage.add(ex.getMessage());
                return response;
            }
    		
    		String filterIssue = getBundleStringValue("rda_amazon_filter_issues");
    		String specialIssue = getBundleStringValue("rda_amazon_special_issues");
    		
    		String filterissues[] = filterIssue.split(";");
    		String specialIssues[] = specialIssue.split(";");
    		
    		Set<String> filterIssueSet = new HashSet<String>(Arrays.asList(filterissues));
    		
			WSGResponse wsgr = getEntitlement(onePassRequest);
			Entitlements entitlements = null;
			if(wsgr.isSuccess()) {
				System.out.println(wsgr.getDataRecieved());
				entitlements = (Entitlements) wsgr.getObjects().get(0);
				response.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
				response.accountNumber = onePassRequest.accountNumber;
				response.editCode = "0";
			   	response.status = getBundleStringValue("transactionSuccess");
				response.detailMessage = new ArrayList<String>();
				response.detailMessage.add(getBundleStringValue("transactionSuccessMessage"));
				EntitlementsDTO entitlementsDTO = new EntitlementsDTO();
			    List<String> productIdList = new ArrayList<String>();
			    
				if(entitlements.getIssues() != null) {
				 Iterator<String> iterator = entitlements.getIssues().iterator();
			     while(iterator.hasNext()) {
			    	String issue = iterator.next();
			    	if("RDO".equalsIgnoreCase(onePassRequest.brandCode)) {
			    		issue = "RDA" + issue;
			    		
			    	}
			    	
			    	if(!filterIssueSet.contains(issue)) {
			    		productIdList.add(issue);
			    	}
				    
			    }
			  }
			
			 // Add special issues in entitlement list
			  for(String spIssue : specialIssues) {
					productIdList.add(spIssue);
			  }
			  
				Collections.sort(productIdList);
				entitlementsDTO.productId = productIdList;
				response.entitlements = entitlementsDTO;
			} else {
				System.out.println(wsgr.getDataRecieved());
				response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
				response.editCode = "6";
				response.status = getBundleStringValue("transactionFailed");
				response.detailMessage = wsgr.getErrorMessages();
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
            response.editCode = "20";
            response.status = getBundleStringValue("transactionFailed");
            response.detailMessage = new ArrayList<String>();
            response.detailMessage.add(e.getMessage());
		}
    	return response;
    	
    }

    /* (non-Javadoc)
     * @see com.readersdigest.onepass.service.OnePassAmazonService#onePassSignInWithCredentials(com.readersdigest.onepass.dto.OnePassServiceRequest)
     */
    /* (non-Javadoc)
     * @see com.readersdigest.onepass.service.OnePassAmazonService#onePassSignInWithCredentials(com.readersdigest.onepass.dto.OnePassServiceRequest)
     */
	public OnePassServiceAmazonResponse onePassSignInWithCredentials(
			OnePassServiceRequest onePassRequest) {
		List<MemberOnePassInfo> memberOnePassInfoList = null;
		OnePassServiceAmazonResponse response = new OnePassServiceAmazonResponse();
		try {

			if (!serviceValidator.amazonAutherizationValidation(onePassRequest)) {
				response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
				response.editCode = "13"; // Required PArameters validation
				response.status = getBundleStringValue("transactionFailed");
				response.detailMessage = new ArrayList<String>();
				response.detailMessage.add("Unauthorized Request");
				return response;
			}

			try {
				serviceValidator.amazonSignInValidation(onePassRequest);
			} catch (ServiceException ex) {

				response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
				response.editCode = "11";
				response.status = getBundleStringValue("transactionFailed");
				response.detailMessage = new ArrayList<String>();
				response.detailMessage.add(ex.getMessage());
				return response;
			}
			String prodAbbr = StringUtils.getKindleProdId(onePassRequest.appId);
			String encPassword = "";

			String password = null;
			try {
				password = RSAEncryptionDescription.decryptData(onePassRequest.password);
			} catch (Exception ex) {
				// TODO Auto-generated catch block
				ex.printStackTrace();
				response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
				response.emailAddress = onePassRequest.emailAddress;
				response.editCode = "10";
				response.status = getBundleStringValue("transactionFailed");
				response.detailMessage = new ArrayList<String>();
				response.detailMessage.add(ex.getMessage());
				return response;

			}

			encPassword = OneWayEncrypter.encryptString(password);

			try {

				long accountNumber = Long.parseLong(onePassRequest.emailAddress.trim());
				String strAccountNumber = String.valueOf(accountNumber);
				int accountLength = strAccountNumber.length();
				for (int i = accountLength; i < 10; i++) {
					strAccountNumber = "0" + strAccountNumber;
				}

				EntityManagerHelper.log(
						"Start OnePassServiceAdobeResponse.accountNumber : "
								+ strAccountNumber, Level.INFO, null);
				memberOnePassInfoList = memberOnePassInfoDAO.findByProperties(
						"accountNumber", "prodId", "active", strAccountNumber,
						prodAbbr, ACTIVE_MEMBER);
				if (memberOnePassInfoList != null
						&& memberOnePassInfoList.size() > 0) {
					MemberOnePassInfo memberOnePassInfo = memberOnePassInfoList
							.get(0);
					memberOnePassInfo = memberOnePassInfoDAO
							.refresh(memberOnePassInfo);
					Customer customer = null;
					WSGResponse wsgr = null;
					WSG wsg = null;

					wsg = new WSG(getBundleStringValue("cdsKindleAppId"),
							getBundleStringValue("cdsKindlePassword"), prodAbbr);

					wsgr = wsg.lookupCustomer(accountNumber);

					if (wsgr.isSuccess()) {
						customer = (Customer) wsgr.getObjects().get(0);
						if (password.equals(customer.getZipCode())) {
							response.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
							response.emailAddress = memberOnePassInfo
									.getEmailAddress();
							response.accountNumber = memberOnePassInfo
									.getAccountNumber();
							response.editCode = "0";
							response.status = getBundleStringValue("transactionSuccess");
							response.detailMessage = new ArrayList<String>();
							response.detailMessage
									.add(getBundleStringValue("transactionSuccessMessage"));
						} else {
							response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
							response.editCode = "15";
							response.status = getBundleStringValue("transactionFailed");
							response.detailMessage = new ArrayList<String>();
							response.detailMessage.add("Authentication Failed.");
						}
					} else {
						response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
						response.accountNumber = customer.getAccountNumber();
						response.emailAddress = customer.getEmail();
						response.editCode = "6";
						response.status = getBundleStringValue("transactionFailed");
						response.detailMessage = wsgr.getErrorMessages();
					}

				} else {
					response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
					response.editCode = "15";
					response.status = getBundleStringValue("transactionFailed");
					response.detailMessage = new ArrayList<String>();
					response.detailMessage.add("Authentication Failed.");
				}

			} catch (Exception ex) {
				memberOnePassInfoList = memberOnePassInfoDAO.findByProperties(
						"emailAddress", "prodId", "active",
						onePassRequest.emailAddress.trim(), prodAbbr,
						ACTIVE_MEMBER);

				if (memberOnePassInfoList != null
						&& memberOnePassInfoList.size() > 0) {
					MemberOnePassInfo memberOnePassInfo = memberOnePassInfoList
							.get(0);
					memberOnePassInfo = memberOnePassInfoDAO
							.refresh(memberOnePassInfo);
					if (encPassword.equals(memberOnePassInfo.getPassword())) {
						if(memberOnePassInfo.getAccountNumber() != null && !"".equals(memberOnePassInfo.getAccountNumber().trim())) {
							response.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
							response.emailAddress = memberOnePassInfo
									.getEmailAddress();
							response.accountNumber = memberOnePassInfo
									.getAccountNumber();
							response.editCode = "0";
							response.status = getBundleStringValue("transactionSuccess");
							response.detailMessage = new ArrayList<String>();
							response.detailMessage
									.add(getBundleStringValue("transactionSuccessMessage"));
						} else {
							response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
							response.editCode = "15";
							response.status = getBundleStringValue("transactionFailed");
							response.detailMessage = new ArrayList<String>();
							response.detailMessage.add("Authentication Failed.");
						}
						
					} else {
						response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
						response.editCode = "15";
						response.status = getBundleStringValue("transactionFailed");
						response.detailMessage = new ArrayList<String>();
						response.detailMessage.add("Authentication Failed.");
					}
				} else {
					response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
					response.editCode = "15";
					response.status = getBundleStringValue("transactionFailed");
					response.detailMessage = new ArrayList<String>();
					response.detailMessage.add("Authentication Failed.");
				}
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
			response.editCode = "20";
			response.status = getBundleStringValue("transactionFailed");
			response.detailMessage = new ArrayList<String>();
			response.detailMessage.add(e.getMessage());
		}

		return response;
	}
    
    /* (non-Javadoc)
     * @see com.readersdigest.onepass.service.OnePassAmazonService#onePassForgotPassword(com.readersdigest.onepass.dto.OnePassServiceRequest)
     */
    public OnePassServiceAmazonResponse onePassForgotPassword(OnePassServiceRequest onePassRequest) {
    	
    	String sourceId = "769";
    	OnePassServiceAmazonResponse response = new OnePassServiceAmazonResponse();
    	
    	if(!serviceValidator.amazonAutherizationValidation(onePassRequest)) {
       	 response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
            response.editCode = "13"; // Required PArameters validation
            response.status = getBundleStringValue("transactionFailed");
            response.detailMessage = new ArrayList<String>();
            response.detailMessage.add("Unauthorized Request");
            return response;
       }
    	try {
            serviceValidator.amazonForgotPasswordValidation(onePassRequest);
        } catch (ServiceException ex) {
       	   	response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
            response.editCode = "11";
    		response.status = getBundleStringValue("transactionFailed");
    		response.detailMessage = new ArrayList<String>();
    		response.detailMessage.add(ex.getMessage());
            return response;
        }
    	
//    	List<MemberOnePassInfo> memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active", onePassRequest.emailAddress, onePassRequest.brandCode, ACTIVE_MEMBER);
//		
//		if (memberOnePassInfoList == null || memberOnePassInfoList.size() <= 0) {
//			response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
//            response.editCode = "17";
//    		response.status = getBundleStringValue("transactionFailed");
//    		response.detailMessage = new ArrayList<String>();
//    		response.detailMessage.add("Email Address is not registered.");
//            return response;
//		}
        
    	 
        try {
        	
	    	OnePassServiceResponse serviceResponse = new OnePassAuthServiceImpl().resetForgetPasswordToken(onePassRequest.emailAddress,sourceId);
	    	
	    	
	        if ("FAILED".equalsIgnoreCase(serviceResponse.status)) {
	            response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
	            if(StringUtils.getBundleProperty("emailAddress.valid").equalsIgnoreCase(serviceResponse.responseText) ) {
	            	 response.editCode = "17";
	            } else {
	            	response.editCode = "20";
	            }
	           
	            response.status = getBundleStringValue("transactionFailed");
	            response.detailMessage = new ArrayList<String>();
	            response.detailMessage.add(serviceResponse.responseText);
	            return  response;
	        }
	        
	        
	        String prodId = StringUtils.getProdIdBySource(sourceId);
	        
	        String URL = getBundleStringValue("amazonForgetPasswordActionURL") + serviceResponse.token +"&sourceId="+sourceId;
	        String emailContent = getBundleStringValue("forgetPasswordMailingTemplateContent_"+prodId);
	        
	        emailContent = emailContent.replaceAll("##url##", URL);
       
            
            TriggeredSendMail triggeredEmail = new TriggeredSendMail();
    		triggeredEmail.setEmailAddress(onePassRequest.emailAddress);
    		triggeredEmail.setEmailingId(getBundleStringValue("resetPasswordEmailId"));
    		triggeredEmail.setEtBrand(getBundleStringValue("etBrand"));
   	
    		String[] key = {"email_content"};
    		String[] value ={emailContent};
    		
    		List<PersonalizationParameters> personalizationParametersList = new ArrayList<PersonalizationParameters>();
    		
    		for(int i=0; i<key.length ; i++) {
    			PersonalizationParameters personalizationParameters = new PersonalizationParameters();
    			personalizationParameters.setKey(key[i]);
    			personalizationParameters.setValue(value[i]);
    			personalizationParametersList.add(personalizationParameters);
    		}
    		
    		triggeredEmail.setPersonalizationParameters(personalizationParametersList);
    		
    		ETExtensionServices eTExtensionServices = new ETExtensionServicesImpl();
    		ETResponse etResponse = eTExtensionServices.sendTriggeredMail("onepass", triggeredEmail);
    		
    		System.out.println("\n\n **********  etResponse.getCode() : " + etResponse.getCode());
    		System.out.println("\n\n **********  etResponse.getDescription() : " + etResponse.getDescription());
    		
    		if("200".equals(etResponse.getCode())) {
    			response.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
    	    	response.emailAddress = onePassRequest.emailAddress;
    	    	response.editCode = "0";
    	    	response.status = getBundleStringValue("transactionSuccess");
    	    	response.detailMessage = new ArrayList<String>();
    	    	response.detailMessage.add(getBundleStringValue("transactionSuccessMessage"));
    			
    		} else {
    			response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
                response.editCode = "20";
                response.status = getBundleStringValue("transactionFailed");
                response.detailMessage = new ArrayList<String>();
                if(etResponse.getDetailedMessages() != null) {
                	for(int i=0; i<etResponse.getDetailedMessages().length; i++) {
        				System.out.println("\n\n **********  etResponse.getDetailedMessage " + i +": " + etResponse.getDetailedMessages()[i]);
        				response.detailMessage.add( etResponse.getDetailedMessages()[i]);
        			}
                }
               
    		}
            
        } catch (Exception e) {
            e.printStackTrace();
            response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
            response.editCode = "20";
            response.status = getBundleStringValue("transactionFailed");
            response.detailMessage = new ArrayList<String>();
            response.detailMessage.add(e.getMessage());
            return  response;
        }
        
        return response;
    }

    
    /**
     * Lookup customer.
     *
     * @param onePassRequest the one pass request
     * @return the WSG response
     */
    private WSGResponse lookupCustomer(OnePassServiceRequest onePassRequest) {
    	WSGResponse wsgr = null;
        WSG wsg = null;
        String prodAbbr = StringUtils.getKindleProdId(onePassRequest.appId);
        
        wsg = new WSG(getBundleStringValue("cdsKindleAppId"), getBundleStringValue("cdsKindlePassword"), prodAbbr);
    	Customer customer = new Customer();
    
    	if(onePassRequest.accountNumber == null || "".equals(onePassRequest.accountNumber.trim())) {
    		customer.setAddress1(onePassRequest.address1);
    		customer.setAddress2(onePassRequest.address2);
    		
    		String customerName = (onePassRequest.firstName != null ? onePassRequest.firstName : "");
    		customerName = customerName + " " + (onePassRequest.lastName != null ? onePassRequest.lastName : "");
    		customer.setName(customerName);
    		customer.setCity(onePassRequest.city);
    		customer.setZipCode(onePassRequest.zipCode);
    		customer.setState(onePassRequest.state);
    		wsgr = wsg.lookupCustomerByAddress(customer);
    	} else {
    		wsgr = wsg.lookupCustomer(onePassRequest.accountNumber);
    	}
    	
    	
    	return wsgr;
    }
    
    /**
     * Gets the entitlement.
     *
     * @param onePassRequest the one pass request
     * @return the entitlement
     */
    private WSGResponse getEntitlement(OnePassServiceRequest onePassRequest) {
    	WSGResponse wsgr = null;
        WSG wsg = null;
        String prodAbbr = StringUtils.getKindleProdId(onePassRequest.appId);
        
        wsg = new WSG(getBundleStringValue("cdsKindleAppId"), getBundleStringValue("cdsKindlePassword"), prodAbbr);
    	wsgr = wsg.getEntitlements(onePassRequest.accountNumber.trim());
    	return wsgr;
    }
    
    
    /**
     * Gets the bundle string value.
     *
     * @param key the key
     * @return the bundle string value
     */
    public static String getBundleStringValue(String key) {
        return StringUtils.getBundleProperty("com.readersdigest.onepass.OnePassResources", key);
    }

       
}