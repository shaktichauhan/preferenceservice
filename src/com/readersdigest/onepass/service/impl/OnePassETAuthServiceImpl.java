package com.readersdigest.onepass.service.impl;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

import javax.persistence.FlushModeType;

import com.cds.global.api.Customer;
import com.cds.global.api.WSGResponse;
import com.readersdigest.exacttarget.client.ETExtensionServices;
import com.readersdigest.exacttarget.client.impl.ETExtensionServicesImpl;
import com.readersdigest.exacttarget.dto.DigitalProfile;
import com.readersdigest.exacttarget.dto.ETResponse;
import com.readersdigest.onepass.db.EmailValidation;
import com.readersdigest.onepass.db.EmailValidationDAO;
import com.readersdigest.onepass.db.EntityManagerHelper;
import com.readersdigest.onepass.db.IEmailValidationDAO;
import com.readersdigest.onepass.db.IMemberDAO;
import com.readersdigest.onepass.db.IMemberOnePassInfoDAO;
import com.readersdigest.onepass.db.Member;
import com.readersdigest.onepass.db.MemberDAO;
import com.readersdigest.onepass.db.MemberOnePassInfo;
import com.readersdigest.onepass.db.MemberOnePassInfoDAO;
import com.readersdigest.onepass.dto.OnePassServiceAdobeResponse;
import com.readersdigest.onepass.util.OneWayEncrypter;
import com.readersdigest.onepass.util.StringUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class OnePassETAuthServiceImpl.
 *
 * @author shsingh
 *
 */

public class OnePassETAuthServiceImpl extends OnePassAuthServiceImpl {

    /** The member dao. */
    private IMemberDAO memberDAO;

    /** The email validation dao. */
    private IEmailValidationDAO emailValidationDAO;

    /** The member one pass info dao. */
    private IMemberOnePassInfoDAO memberOnePassInfoDAO;

    /**  Fix token for Rd employee to provide free subscription *. */
    private final static String RDEMPLOYEE_AUTH_TOKEN = "rdaemployee-free-subscription";
    
    /** The Constant BRANDADVOCATE_ONE_MONTH_TOKEN. */
    private final static String BRANDADVOCATE_ONE_MONTH_TOKEN = "brandadvocte-free-1month-subscription";
    
    /** The Constant BRANDADVOCATE_THREE_MONTH_TOKEN. */
    private final static String BRANDADVOCATE_THREE_MONTH_TOKEN = "brandadvocte-free-3month-subscription";

    /** The prod abbrs. */
    public String[] prodAbbrs = getBundleStringValue("cdsProdAbbrs") != null ? getBundleStringValue("cdsProdAbbrs").split(",") : null;

    /**
     * Instantiates a new one pass et auth service impl.
     */
    public OnePassETAuthServiceImpl() {
        memberDAO = new MemberDAO();
        emailValidationDAO = new EmailValidationDAO();
        memberOnePassInfoDAO = new MemberOnePassInfoDAO();

    }

    /**
     * Instantiates a new one pass service impl.
     * 
     * @param emailAddress
     *            the email address
     * @param password
     *            the password
     * @param appId
     *            the app id
     * @param appVersion
     *            the app version
     * @param uuid
     *            the uuid
     * @return the one pass service adobe response
     */
    /*
     * (non-Javadoc)
     * 
     * @see com.readersdigest.onepass.service.impl.OnePassServiceImpl#signInWithCredentials(java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String, java.lang.String)
     */
    
    public OnePassServiceAdobeResponse signInWithCredentials(String emailAddress, String password, String appId, String appVersion, String uuid) {

        EntityManagerHelper.log("Start OnePassServiceAdobeResponse.signInWithCredentials ..", Level.INFO, null);

        WSGResponse wsgr = null;
        Customer customer = null;
        String rdEmailPattern = getBundleStringValue("rdEmailRegEx");

        String prodAbbr = StringUtils.getProdId(appId);

        if (prodAbbr == null || "".equals(prodAbbr)) {
            prodAbbr = StringUtils.getKindleProdId(appId); // Getting the APP Id for Kindle
        }

        String cdsZipCode = null;


        List<MemberOnePassInfo> memberOnePassInfoList = null;
        MemberOnePassInfo strMemberOnePassInfo = null;

        OnePassServiceAdobeResponse adobeServiceResponse = new OnePassServiceAdobeResponse();

        String encPassword = "";

        try {
            encPassword = OneWayEncrypter.encryptString(password);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        try {
            //Email strEmail = null;

            boolean isAccountNumber = false;
            String strAccountNumber = null;
            EntityManagerHelper.beginTransaction();
            
            try {

                long accountNumber = Long.parseLong(emailAddress.trim());
                strAccountNumber = String.valueOf(accountNumber);
                int accountLength = strAccountNumber.length();
                for (int i = accountLength; i < 10; i++) {
                    strAccountNumber = "0" + strAccountNumber;
                }

                EntityManagerHelper.log("Start OnePassServiceAdobeResponse.accountNumber : " + strAccountNumber, Level.INFO, null);
                isAccountNumber = true;
                memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("accountNumber", "prodId", "active", strAccountNumber, prodAbbr, ACTIVE_MEMBER);

            } catch (Exception ex) {

                EntityManagerHelper.log("Start OnePassServiceAdobeResponse. accountparsing Error emailAddresz : " + emailAddress, Level.INFO, null);
                memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active", emailAddress.trim(), prodAbbr, ACTIVE_MEMBER);
                isAccountNumber = false;
                
                long currentTime = System.currentTimeMillis();
                
                // For RDA employee users
                if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
                    for (MemberOnePassInfo memberOnePassInfo : memberOnePassInfoList) {
                    	memberOnePassInfo = memberOnePassInfoDAO.refresh(memberOnePassInfo);
                    	
                        if(encPassword.equals(memberOnePassInfo.getPassword())) {
                        	
                           	if(getBundleStringValue("brand_advocate_1month_usertype").equalsIgnoreCase(memberOnePassInfo.getUserType())
                           			&& (memberOnePassInfo.getAccountNumber() == null || "".equals(memberOnePassInfo.getAccountNumber()))) {
                        		if(currentTime-memberOnePassInfo.getCreateDate().getTime() <= Long.parseLong(getBundleStringValue("brand_advocate_1month")) ) {
                        			 adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
	                                 adobeServiceResponse.authToken = BRANDADVOCATE_ONE_MONTH_TOKEN + prodAbbr;
	                                 adobeServiceResponse.emailAddress = memberOnePassInfo.getEmailAddress();
	                                 return adobeServiceResponse;
                        		}
                        		
                        	} else if (getBundleStringValue("brand_advocate_3month_usertype").equalsIgnoreCase(memberOnePassInfo.getUserType())
                           			&& (memberOnePassInfo.getAccountNumber() == null || "".equals(memberOnePassInfo.getAccountNumber()))) {
                        		if(currentTime-memberOnePassInfo.getCreateDate().getTime() <= Long.parseLong(getBundleStringValue("brand_advocate_3month")) ) {
                        			 adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
	                                 adobeServiceResponse.authToken = BRANDADVOCATE_THREE_MONTH_TOKEN + prodAbbr;
	                                 adobeServiceResponse.emailAddress = memberOnePassInfo.getEmailAddress();
	                                 return adobeServiceResponse;
                        		}
                        		
                        	} else if(memberOnePassInfo.getEmailAddress().matches(rdEmailPattern)) {
                        	
	                        	List<EmailValidation> emailValidList = emailValidationDAO.findByProperties("emailAddress", "prodId", memberOnePassInfo.getEmailAddress(), prodAbbr);
	                        	
	                            if (emailValidList != null && emailValidList.size() > 0) {
	                            	EmailValidation emailValid = emailValidList.get(0);
	                                emailValid = emailValidationDAO.refresh(emailValid);
	                                if (VALID_STRING.equalsIgnoreCase(emailValid.getValid())) {
	                                    // adobeServiceResponse = authenticateCDSUser(cdsRdAccountNumber, cdsRdZipCode, appId, appVersion, uuid, adobeServiceResponse);
	                                    adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
	                                    adobeServiceResponse.authToken = RDEMPLOYEE_AUTH_TOKEN + prodAbbr;
	                                    adobeServiceResponse.emailAddress = memberOnePassInfo.getEmailAddress();
	                                    return adobeServiceResponse;
	                                } else {
	                                    emailValidToken(memberOnePassInfo.getEmailAddress(), prodAbbr);
	                                }
	                            } else {
	                                emailValidToken(memberOnePassInfo.getEmailAddress(), prodAbbr);
	                            }
	
	                        } 
                        }
                    }
                }
            }

            System.out.println("\n\n\n ********  memberOnePassInfoList " + memberOnePassInfoList);

            if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
                for (MemberOnePassInfo memberOnePassInfo : memberOnePassInfoList) {
                    memberOnePassInfo = memberOnePassInfoDAO.refresh(memberOnePassInfo);
                    if (memberOnePassInfo.getAccountNumber() != null && !"".equals(memberOnePassInfo.getAccountNumber().trim())) {
                        strMemberOnePassInfo = memberOnePassInfo;
                        if (encPassword.equalsIgnoreCase(memberOnePassInfo.getPassword())) {
                            cdsZipCode = memberOnePassInfo.getZipCode();
                        }
                        break;
                    }
                }
            }

            if (isAccountNumber) {

//                try {
                    if (strMemberOnePassInfo != null) {
                        if (cdsZipCode != null) {
                            adobeServiceResponse = authenticateCDSUser(emailAddress, cdsZipCode, appId, appVersion, uuid, adobeServiceResponse);

                        } else {
                            adobeServiceResponse = authenticateCDSUser(emailAddress, password, appId, appVersion, uuid, adobeServiceResponse);

                        }
                        
                        adobeServiceResponse.emailAddress = strMemberOnePassInfo.getEmailAddress();
                        if (adobeServiceResponse.authToken != null) {
                          adobeServiceResponse = validEmailAddress(strMemberOnePassInfo.getEmailAddress(), prodAbbr, adobeServiceResponse);
                        } else {
                            adobeServiceResponse.validEmailAddress = INVALID_STRING;
                        }
                    } else {
                        adobeServiceResponse = authenticateCDSUser(emailAddress, password, appId, appVersion, uuid, adobeServiceResponse);

                        if (adobeServiceResponse.authToken != null) {
                            wsgr = StringUtils.getCustomerInfo(appId, emailAddress);
                            if (wsgr.isSuccess()) {
                                customer = (Customer) wsgr.getObjects().get(0);
                                System.out.println("\n\n\n ***calling before validEmailAddress customer.getEmail():: " + customer.getEmail());
                                if (customer.getEmail() != null && !"".equals(customer.getEmail().trim())) {
                                    adobeServiceResponse = validEmailAddress(customer.getEmail(), prodAbbr, adobeServiceResponse);
                                    adobeServiceResponse = addCDSUser(customer, prodAbbr, adobeServiceResponse);
                                    adobeServiceResponse.accountNumber = strAccountNumber;
                                    return adobeServiceResponse;
                                } else {
                                    adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
                                    adobeServiceResponse.error = "NONDIGITALACTIVATED";
                                    adobeServiceResponse.errorCode = "10003";
                                    adobeServiceResponse.validEmailAddress = INVALID_STRING; //  no need to show the email validation popup
                                }
                            }
                        }
                    }

                    adobeServiceResponse.accountNumber = strAccountNumber;


            } else {
                System.out.println("\n\n\n ********in Is ACCOUNT NUMBER FALSE COn strMemberOnePassInfo :: " + strMemberOnePassInfo);

                if (strMemberOnePassInfo != null) {
                    if (cdsZipCode != null) {
                        adobeServiceResponse = authenticateCDSUser(strMemberOnePassInfo.getAccountNumber(), cdsZipCode, appId, appVersion, uuid,
                                adobeServiceResponse);
                    } else {
                        adobeServiceResponse = authenticateCDSUser(strMemberOnePassInfo.getAccountNumber(), password, appId, appVersion, uuid, adobeServiceResponse);
                    }

                    adobeServiceResponse.accountNumber = strMemberOnePassInfo.getAccountNumber();
                    adobeServiceResponse.emailAddress = emailAddress;
                    if (adobeServiceResponse.authToken != null) {
                        adobeServiceResponse = validEmailAddress(emailAddress, prodAbbr, adobeServiceResponse);
                    } else {
                        adobeServiceResponse.validEmailAddress = INVALID_STRING;
                    }
                    

                } else {
                    adobeServiceResponse = authenticateCDSUser(emailAddress, password, appId, appVersion, uuid, adobeServiceResponse);
                    if (adobeServiceResponse.authToken != null) {
                        wsgr = StringUtils.getCustomerInfo(appId, emailAddress);

                        if (wsgr.isSuccess()) {
                            customer = (Customer) wsgr.getObjects().get(0);
                            adobeServiceResponse = authenticateCDSUser(customer.getAccountNumber(), password, appId, appVersion, uuid, adobeServiceResponse);
                            
                            if (adobeServiceResponse.authToken != null) {
                                adobeServiceResponse = validEmailAddress(emailAddress, prodAbbr, adobeServiceResponse);
                                adobeServiceResponse = addCDSUser(customer, prodAbbr, adobeServiceResponse);
                            } else {
                                adobeServiceResponse.validEmailAddress = INVALID_STRING;
                            }
                            
                            adobeServiceResponse.accountNumber = customer.getAccountNumber();
                            adobeServiceResponse.emailAddress = emailAddress;
                            return adobeServiceResponse;
                            
                        } else {
                            if (wsgr.getErrorMessages().size() > 0 && "EMAIL not unique".equalsIgnoreCase(wsgr.getErrorMessages().get(0))) {
                                System.out.println("\n\n\n ********in IS SUCCESS FAILED FORM CDS  EMAIL not unique :: ");

                                adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
                                adobeServiceResponse.error = "UNIQUEEMAILERROR";
                                adobeServiceResponse.errorCode = "10002";
                                adobeServiceResponse.emailAddress = emailAddress;
                                adobeServiceResponse.validEmailAddress = INVALID_STRING;
                            }
                        }
                    } else {
                    	 System.out.println("\n\n\n ********in memberOnePassInfoList :: " + memberOnePassInfoList);
                        if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
                        	 System.out.println("\n\n\n ********in memberOnePassInfoList.get(0).getPassword():: " + memberOnePassInfoList.get(0).getPassword());
                        	 System.out.println("\n\n\n ********in encPassword: " + encPassword);
                            if (encPassword.equals(memberOnePassInfoList.get(0).getPassword())) {
                                adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
                                adobeServiceResponse.authToken = memberOnePassInfoList.get(0).getPassword();
                                adobeServiceResponse.emailAddress = emailAddress.trim();
                            } else {
                                adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
                            }

                        } else {
                            adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
                        }
                    }
                }
                
            }
            
            EntityManagerHelper.commit();
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            EntityManagerHelper.rollback();
            e.printStackTrace();
        } finally {
            EntityManagerHelper.clear();
            EntityManagerHelper.closeEntityManager();
        }
        
        return adobeServiceResponse;
      
    }

     /**
      * Adds the cds user.
      *
      * @param customer the customer
      * @param prodAbbr the prod abbr
      * @param adobeServiceResponse the adobe service response
      * @return the one pass service adobe response
      */
     private OnePassServiceAdobeResponse addCDSUser(Customer customer, String prodAbbr, OnePassServiceAdobeResponse adobeServiceResponse) {

        EntityManagerHelper.log("Start OnePassServiceAdobeResponse. CDS Token Success fue Check in OnePass for storing ", Level.INFO, null);
        Member member = null;
        List<MemberOnePassInfo> memberOnePassInfoList = null;

        try {
           // EntityManagerHelper.beginTransaction();
            EntityManagerHelper.getEntityManager().setFlushMode(FlushModeType.COMMIT);

            String accountNumber = customer.getAccountNumber();
            String userEmailAddress = customer.getEmail();
            adobeServiceResponse.emailAddress = userEmailAddress;

            memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("accountNumber", "prodId", "active", accountNumber, prodAbbr, ACTIVE_MEMBER);
 
            if (memberOnePassInfoList == null || memberOnePassInfoList.size() == 0) {

                EntityManagerHelper.log("Start OnePassServiceAdobeResponse. CDS Token Success fue Check in OnePass memberInfoList is null ", Level.INFO, null);

                member = new Member();

                if (memberDAO.findByMemberName(userEmailAddress.trim()).size() > 0) {
                    member.setMemberName(UUID.randomUUID().getMostSignificantBits() + ":" + userEmailAddress.trim());
                } else {
                    member.setMemberName(userEmailAddress.trim());
                }

                memberDAO.save(member);

                memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active", userEmailAddress.trim(), prodAbbr,
                        ACTIVE_MEMBER);
                MemberOnePassInfo memberOnePassInfo = new MemberOnePassInfo();
                if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
                    if (memberOnePassInfoList.size() > 1 || 
                            (memberOnePassInfoList.get(0).getAccountNumber() != null && 
                            !"".equals(memberOnePassInfoList.get(0).getAccountNumber()))) {
                        adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
                        adobeServiceResponse.error = "UNIQUEEMAILERROR";
                        adobeServiceResponse.errorCode = "10002";
                        EntityManagerHelper.rollback();
                        return adobeServiceResponse;
                    }

                    MemberOnePassInfo exeMemberOnePassInfo = memberOnePassInfoList.get(0);
                    exeMemberOnePassInfo.setActive(INACTIVE_MEMBER);
                    memberOnePassInfo.setMemberOnePassRefId(exeMemberOnePassInfo.getMemberOnePassInfoId());
                    memberOnePassInfoDAO.update(exeMemberOnePassInfo);
                }
                // else {
                memberOnePassInfo.setMember(member);
                memberOnePassInfo.setActive(ACTIVE_MEMBER);
                memberOnePassInfo.setAccountNumber(accountNumber);
                memberOnePassInfo.setZipCode(customer.getZipCode());
                memberOnePassInfo.setFullName(customer.getName());
                memberOnePassInfo.setEmailAddress(userEmailAddress.trim());
                memberOnePassInfo.setCreateDate(new Timestamp(System.currentTimeMillis()));
                memberOnePassInfo.setProdId(prodAbbr);
                memberOnePassInfo.setUserType("CDS");
                memberOnePassInfoDAO.save(memberOnePassInfo);
                // }
                
                DigitalProfile profile = new DigitalProfile();
        		profile.setEmailAddress(userEmailAddress.trim());
        		
        		String sourceName = StringUtils.getSourceNameByProdabbr(prodAbbr);
        		profile.setSource(sourceName); /// Set the Source Name
        		
        		//profile.setSource("TOH from Website"); // add the source name
        	
        		ETExtensionServices eTExtensionServices = new ETExtensionServicesImpl();
        		ETResponse etResponse = eTExtensionServices.addUpdateDigitalProfile("onepass", profile);
        		
        		System.out.println("\n\n **********  etResponse.getCode() : " + etResponse.getCode());
        		System.out.println("\n\n **********  etResponse.getDescription() : " + etResponse.getDescription());
        		
        		if(etResponse.getDetailedMessages() != null) {
        			for(int i=0; i<etResponse.getDetailedMessages().length; i++) {
        				System.out.println("\n\n **********  etResponse.getDetailedMessage " + i +": " + etResponse.getDetailedMessages()[i]);
        			}
        		}

                adobeServiceResponse.cdsForgetPassword = "true";

            }

            EntityManagerHelper.commit();
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            EntityManagerHelper.rollback();
        }

        return adobeServiceResponse;
    }

    
    
}
