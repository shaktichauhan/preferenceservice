package com.readersdigest.onepass.service.impl;

import java.io.IOException;
import java.io.InputStream;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.UUID;
import java.util.logging.Level;

import javax.persistence.FlushModeType;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.lang.WordUtils;

import com.cds.global.api.Customer;
import com.cds.global.api.WSGResponse;
import com.readersdigest.exacttarget.client.ETExtensionServices;
import com.readersdigest.exacttarget.client.impl.ETExtensionServicesImpl;
import com.readersdigest.exacttarget.dto.DigitalProfile;
import com.readersdigest.exacttarget.dto.ETResponse;
import com.readersdigest.onepass.db.Email;
import com.readersdigest.onepass.db.EmailDAO;
import com.readersdigest.onepass.db.EmailValidation;
import com.readersdigest.onepass.db.EmailValidationDAO;
import com.readersdigest.onepass.db.EntitlementsBrandAdvocate;
import com.readersdigest.onepass.db.EntitlementsBrandAdvocateDAO;
import com.readersdigest.onepass.db.EntitlementsFho;
import com.readersdigest.onepass.db.EntitlementsFhoDAO;
import com.readersdigest.onepass.db.EntitlementsRdo;
import com.readersdigest.onepass.db.EntitlementsRdoDAO;
import com.readersdigest.onepass.db.EntitlementsToh;
import com.readersdigest.onepass.db.EntitlementsTohDAO;
import com.readersdigest.onepass.db.EntityManagerHelper;
import com.readersdigest.onepass.db.IEmailDAO;
import com.readersdigest.onepass.db.IEmailValidationDAO;
import com.readersdigest.onepass.db.IEntitlementsBrandAdvocateDAO;
import com.readersdigest.onepass.db.IEntitlementsFhoDAO;
import com.readersdigest.onepass.db.IEntitlementsRdoDAO;
import com.readersdigest.onepass.db.IEntitlementsTohDAO;
import com.readersdigest.onepass.db.IMemberDAO;
import com.readersdigest.onepass.db.IMemberOnePassInfoDAO;
import com.readersdigest.onepass.db.IMemberPWDResetDAO;
import com.readersdigest.onepass.db.IPromotionalEntitlementsRdoDAO;
import com.readersdigest.onepass.db.Member;
import com.readersdigest.onepass.db.MemberDAO;
import com.readersdigest.onepass.db.MemberOnePassInfo;
import com.readersdigest.onepass.db.MemberOnePassInfoDAO;
import com.readersdigest.onepass.db.MemberPWDReset;
import com.readersdigest.onepass.db.MemberPWDResetDAO;
import com.readersdigest.onepass.db.PromotionalEntitlementsRdo;
import com.readersdigest.onepass.db.PromotionalEntitlementsRdoDAO;
import com.readersdigest.onepass.dto.AccountDTO;
import com.readersdigest.onepass.dto.EmailDTO;
import com.readersdigest.onepass.dto.EntitlementsDTO;
import com.readersdigest.onepass.dto.HeaderDTO;
import com.readersdigest.onepass.dto.OnePassServiceAdobeEntitledVerifyResponse;
import com.readersdigest.onepass.dto.OnePassServiceAdobeResponse;
import com.readersdigest.onepass.dto.OnePassServiceResponse;
import com.readersdigest.onepass.dto.PreferenceDTO;
import com.readersdigest.onepass.dto.UpdateOnePassUserProfileDTO;
import com.readersdigest.onepass.exception.ServiceException;
import com.readersdigest.onepass.util.OneWayEncrypter;
import com.readersdigest.onepass.util.StringUtils;

/**
 * The Class OnePassAuthServiceImpl.
 *
 * @author shsingh
 *
 */

public class OnePassAuthServiceImpl extends OnePassServiceImpl {

    /** The member dao. */
    private IMemberDAO memberDAO;


    /** The email dao. */
    private IEmailDAO emailDAO;

    private IEmailValidationDAO emailValidationDAO;

    private IEntitlementsFhoDAO entitlementsFhoDAO;
    private IEntitlementsRdoDAO entitlementsRdoDAO;
    private IEntitlementsTohDAO entitlementsTohDAO;
    private IPromotionalEntitlementsRdoDAO promotionalEntitlementsRdoDAO;

    private IMemberOnePassInfoDAO memberOnePassInfoDAO;

    /** Fix token for Rd employee to provide free subscription **/
    private final static String RDEMPLOYEE_AUTH_TOKEN = "rdaemployee-free-subscription";
    
    /** The Constant BRANDADVOCATE_ONE_MONTH_TOKEN. */
    private final static String BRANDADVOCATE_ONE_MONTH_TOKEN = "brandadvocte-free-1month-subscription";
    
    /** The Constant BRANDADVOCATE_THREE_MONTH_TOKEN. */
    private final static String BRANDADVOCATE_THREE_MONTH_TOKEN = "brandadvocte-free-3month-subscription";

    /** The prod abbrs. */
    public String[] prodAbbrs = getBundleStringValue("cdsProdAbbrs") != null ? getBundleStringValue("cdsProdAbbrs").split(",") : null;

    public OnePassAuthServiceImpl() {
        memberDAO = new MemberDAO();
        emailDAO = new EmailDAO();
        emailValidationDAO = new EmailValidationDAO();
        entitlementsFhoDAO = new EntitlementsFhoDAO();
        entitlementsRdoDAO = new EntitlementsRdoDAO();
        entitlementsTohDAO = new EntitlementsTohDAO();
        memberOnePassInfoDAO = new MemberOnePassInfoDAO();
        promotionalEntitlementsRdoDAO = new PromotionalEntitlementsRdoDAO();
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

        Member member = null;
        List<Email> emailList = null;
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

                // For RDA employee users
                if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
                    for (MemberOnePassInfo memberOnePassInfo : memberOnePassInfoList) {
                        if (memberOnePassInfo.getEmailAddress().matches(rdEmailPattern) && encPassword.equals(memberOnePassInfo.getPassword())) {
                            emailList = emailDAO.findByEmailAddress(memberOnePassInfo.getEmailAddress());
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

            System.out.println("\n\n\n ********  memberOnePassInfoList " + memberOnePassInfoList);

            if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
                for (MemberOnePassInfo memberOnePassInfo : memberOnePassInfoList) {
                    memberOnePassInfo = memberOnePassInfoDAO.refresh(memberOnePassInfo);
                    if (memberOnePassInfo.getAccountNumber() != null && !"".equals(memberOnePassInfo.getAccountNumber().trim())) {
                        strMemberOnePassInfo = memberOnePassInfo;
                        member = memberOnePassInfo.getMember();
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
//                            if (adobeServiceResponse.authToken != null) {
//                                adobeServiceResponse.emailAddress = strMemberOnePassInfo.getEmailAddress();
//                                adobeServiceResponse = validEmailAddress(strMemberOnePassInfo.getEmailAddress(), prodAbbr, adobeServiceResponse);
//                            } else {
//                                wsgr = StringUtils.getCustomerInfo(appId, emailAddress);
//                                if (wsgr.isSuccess()) {
//                                    customer = (Customer) wsgr.getObjects().get(0);
//                                    // update customer information (Customer, memberInfolist)
//                                    cdsZipCode = customer.getZipCode();
//                                    adobeServiceResponse = authenticateCDSUser(emailAddress, cdsZipCode, appId, appVersion, uuid, adobeServiceResponse);
//                                    adobeServiceResponse.emailAddress = strMemberOnePassInfo.getEmailAddress();
//                                    adobeServiceResponse = validEmailAddress(strMemberOnePassInfo.getEmailAddress(), prodAbbr, adobeServiceResponse);
//                                }
//                            }
                        } else {
                            adobeServiceResponse = authenticateCDSUser(emailAddress, password, appId, appVersion, uuid, adobeServiceResponse);
//                            adobeServiceResponse.emailAddress = strMemberOnePassInfo.getEmailAddress();
//                            adobeServiceResponse = validEmailAddress(strMemberOnePassInfo.getEmailAddress(), prodAbbr, adobeServiceResponse);
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
                    //return adobeServiceResponse;

//                } catch (Exception e) {
//                    // TODO Auto-generated catch block
//                    e.printStackTrace();
//                }
//                adobeServiceResponse.accountNumber = strAccountNumber;
//                return adobeServiceResponse;

            } else {
                System.out.println("\n\n\n ********in Is ACCOUNT NUMBER FALSE COn strMemberOnePassInfo :: " + strMemberOnePassInfo);

                if (strMemberOnePassInfo != null) {
                    if (cdsZipCode != null) {
                        adobeServiceResponse = authenticateCDSUser(strMemberOnePassInfo.getAccountNumber(), cdsZipCode, appId, appVersion, uuid,
                                adobeServiceResponse);
//                        if (adobeServiceResponse.authToken != null) {
//                            if (strMemberOnePassInfo != null) {
//                                adobeServiceResponse.emailAddress = strMemberOnePassInfo.getEmailAddress();
//                               // adobeServiceResponse = validEmailAddress(strMemberOnePassInfo.getEmailAddress(), prodAbbr, adobeServiceResponse);
//                            }
//
//                        } else {
//                            wsgr = StringUtils.getCustomerInfo(appId, emailAddress);
//                            if (wsgr.isSuccess()) {
//                                customer = (Customer) wsgr.getObjects().get(0);
//                                // update customer information (Customer, memberInfolist)
//                                cdsZipCode = customer.getZipCode();
//                                adobeServiceResponse = authenticateCDSUser(emailAddress, cdsZipCode, appId, appVersion, uuid, adobeServiceResponse);
//                                adobeServiceResponse.emailAddress = strMemberOnePassInfo.getEmailAddress();
//                                //adobeServiceResponse = validEmailAddress(strMemberOnePassInfo.getEmailAddress(), prodAbbr, adobeServiceResponse);
//                            }
//                        }
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
                        if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
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

    public OnePassServiceAdobeResponse validEmailAddress(String emailAddress, String prodId, OnePassServiceAdobeResponse adobeServiceResponse) {

        List<EmailValidation> emailValidList = null;

        adobeServiceResponse.validEmailAddress = INVALID_STRING;

        try {
      	
        	emailValidList = emailValidationDAO.findByProperties("emailAddress", "prodId", emailAddress, prodId);
        	
        	if (emailValidList != null && emailValidList.size() > 0) {
        		EmailValidation emailValid = emailValidList.get(0);
                emailValid = emailValidationDAO.refresh(emailValid);
                if (VALID_STRING.equalsIgnoreCase(emailValid.getValid())) {
                    adobeServiceResponse.validEmailAddress = VALID_STRING;
                }
            } 
           
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return adobeServiceResponse;
    }
    
    public OnePassServiceAdobeResponse validCDSEmailAddress(String emailAddress, String appId) {
  
        OnePassServiceAdobeResponse adobeServiceResponse = new OnePassServiceAdobeResponse();

        String prodAbbr = StringUtils.getProdId(appId);

        if (prodAbbr == null || "".equals(prodAbbr)) {
            prodAbbr = StringUtils.getKindleProdId(appId); // Getting the APP Id for Kindle
        }
        List<MemberOnePassInfo> memberOnePassInfoList = null;
        
        try {

            long accountNumber = Long.parseLong(emailAddress.trim());
            String strAccountNumber = String.valueOf(accountNumber);
            int accountLength = strAccountNumber.length();
            for (int i = accountLength; i < 10; i++) {
                strAccountNumber = "0" + strAccountNumber;
            }

            EntityManagerHelper.log("Start OnePassServiceAdobeResponse.validCDSEmailAddress.accountNumber : " + strAccountNumber, Level.INFO, null);
           
            memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("accountNumber", "prodId", "active", strAccountNumber, prodAbbr, ACTIVE_MEMBER);
            if(memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
                MemberOnePassInfo memberOnePassInfo = memberOnePassInfoList.get(0);
                memberOnePassInfo = memberOnePassInfoDAO.refresh(memberOnePassInfo);
                adobeServiceResponse = validEmailAddress(memberOnePassInfo.getEmailAddress(), prodAbbr, adobeServiceResponse);
                adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
                if(memberOnePassInfo.getPassword() == null || "".equals(memberOnePassInfo.getPassword().trim())) {
                    adobeServiceResponse.cdsForgetPassword = "true";
                }
                adobeServiceResponse.accountNumber = memberOnePassInfo.getAccountNumber();
                adobeServiceResponse.emailAddress = memberOnePassInfo.getEmailAddress();
               
            } else {
                adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
            }
            
        } catch (Exception ex) {
            memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active", emailAddress.trim(), prodAbbr, ACTIVE_MEMBER);
            if(memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
                MemberOnePassInfo memberOnePassInfo = memberOnePassInfoList.get(0);
                memberOnePassInfo = memberOnePassInfoDAO.refresh(memberOnePassInfo);
                if(memberOnePassInfo.getAccountNumber() != null && !"".equals(memberOnePassInfo.getAccountNumber().trim())) {
                    adobeServiceResponse = validEmailAddress(memberOnePassInfo.getEmailAddress(), prodAbbr, adobeServiceResponse);
                    adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
                    if(memberOnePassInfo.getPassword() == null || "".equals(memberOnePassInfo.getPassword().trim())) {
                        adobeServiceResponse.cdsForgetPassword = "true";
                    }
                    adobeServiceResponse.accountNumber = memberOnePassInfo.getAccountNumber();
                    adobeServiceResponse.emailAddress = memberOnePassInfo.getEmailAddress();
                } else {
                    adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
                }
            }
        }

        return adobeServiceResponse;
    }
    
    

    private OnePassServiceAdobeResponse addCDSUser(Customer customer, String prodAbbr, OnePassServiceAdobeResponse adobeServiceResponse) {

        EntityManagerHelper.log("Start OnePassServiceAdobeResponse. CDS Token Success fue Check in OnePass for storing ", Level.INFO, null);
        Member member = null;
        List<Email> emailList = null;
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

                emailList = emailDAO.findByEmailAddress(userEmailAddress.trim());

                if (emailList != null && emailList.size() > 0) {
                    Email email = emailList.get(0);
                    member = email.getMember();
                    if (member == null || member.getMemberId() <= 0) {
                        member = new Member();
                        if (memberDAO.findByMemberName(userEmailAddress.trim()).size() > 0) {
                            member.setMemberName(UUID.randomUUID().getMostSignificantBits() + ":" + userEmailAddress.trim());
                        } else {
                            member.setMemberName(userEmailAddress.trim());
                        }
                        // member.setPassword(encPassword);
                        memberDAO.save(member);
                        email.setNonMemberProfile(null);
                        email.setMember(member);
                    }
                    email.setEmailTypeId(EMAIL_PRIMARY_ID);
                    email.setEffectiveDate(new Timestamp(System.currentTimeMillis()));
                    emailDAO.update(email);
                } else {
                    member = new Member();
                    if (memberDAO.findByMemberName(userEmailAddress.trim()).size() > 0) {
                        member.setMemberName(UUID.randomUUID().getMostSignificantBits() + ":" + userEmailAddress.trim());
                    } else {
                        member.setMemberName(userEmailAddress.trim());
                    }

                    memberDAO.save(member);
                    Email email = new Email();
                    email.setMember(member);
                    email.setEmailAddress(userEmailAddress.trim());
                    email.setEmailTypeId(EMAIL_PRIMARY_ID);
                    email.setEffectiveDate(new Timestamp(System.currentTimeMillis()));
                    emailDAO.save(email);
                }

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
                    // memberOnePassInfo.setMember(member);
                    // memberOnePassInfo.setAccountNumber(accountNumber);
                    // memberOnePassInfo.setZipCode(customer.getZipCode());
                    // memberOnePassInfo.setFullName(customer.getName());
                    // memberOnePassInfo.setCreateDate(new Timestamp(System.currentTimeMillis()));
                    // memberOnePassInfo.setProdId(prodAbbr);
                    // memberOnePassInfo.setUserType("CDS");
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

                if(StringUtils.isPreAndETUpdate()) {
                	 
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

    /*
     * (non-Javadoc)
     * 
     * @see com.readersdigest.onepass.service.impl.OnePassServiceImpl#renewAuthToken(java.lang.String, java.lang.String, java.lang.String)
     */
    public OnePassServiceAdobeResponse renewAuthToken(String authToken, String appId, String appVersion) {

        OnePassServiceAdobeResponse adobeServiceResponse = new OnePassServiceAdobeResponse();

        String prodAbbr = StringUtils.getProdId(appId);

        if (prodAbbr == null || "".equals(prodAbbr)) {
            prodAbbr = StringUtils.getKindleProdId(appId); // Getting the APP Id for Kindle
        }

        if ((RDEMPLOYEE_AUTH_TOKEN + prodAbbr).equals(authToken)) {
            adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
            adobeServiceResponse.authToken = RDEMPLOYEE_AUTH_TOKEN + prodAbbr;
            EntityManagerHelper.log("Start OnePassServiceAdobeResponse. renewAuthToken : Rd Employee Token : ", Level.INFO, null);
            return adobeServiceResponse;
        }
        
        if ((BRANDADVOCATE_THREE_MONTH_TOKEN + prodAbbr).equals(authToken)) {
        	adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
            adobeServiceResponse.authToken = BRANDADVOCATE_THREE_MONTH_TOKEN + prodAbbr;
            EntityManagerHelper.log("Start OnePassServiceAdobeResponse. renewAuthToken : Rd Employee Token : ", Level.INFO, null);
            return adobeServiceResponse;
        } 
        
        if ((BRANDADVOCATE_ONE_MONTH_TOKEN + prodAbbr).equals(authToken)) {
        	adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
            adobeServiceResponse.authToken = BRANDADVOCATE_ONE_MONTH_TOKEN + prodAbbr;
            EntityManagerHelper.log("Start OnePassServiceAdobeResponse. renewAuthToken : Rd Employee Token : ", Level.INFO, null);
            return adobeServiceResponse;
        } 

        adobeServiceResponse = renewCDSAuthToken(authToken, appId, appVersion, adobeServiceResponse);

        if (adobeServiceResponse.authToken == null) {
            List<Member> memberList = memberDAO.findByPassword(authToken);
            if (memberList != null && memberList.size() > 0) {
                adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
                adobeServiceResponse.authToken = authToken;
            } else {
                adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
            }

        }

        return adobeServiceResponse;
    }

    /**
     * Authenticate cds user.
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
     * @param adobeServiceResponse
     *            the adobe service response
     * @return the one pass service adobe response
     */
    public OnePassServiceAdobeResponse authenticateCDSUser(String emailAddress, String password, String appId, String appVersion, String uuid,
            OnePassServiceAdobeResponse adobeServiceResponse) {

        StringBuffer URL = new StringBuffer(getBundleStringValue("cdsSignInWithCredentalsUrl"));
        URL.append("emailAddress=" + emailAddress);
        URL.append("&password=" + password);
        URL.append("&uuid=" + uuid);
        URL.append("&appId=" + appId);
        URL.append("&appVersion=" + appVersion);

        System.out.println("\n\n URL.toString() :  " + URL.toString());

        GetMethod method = new GetMethod(URL.toString());

        HttpClient httpClient = new HttpClient();

        try {

            int executeResult = httpClient.executeMethod(method);

            if (200 != executeResult) {
                System.out.println("\n\n ********* 200 != executeResult ********\n\n ");
            }

            InputStream stream = method.getResponseBodyAsStream();
            JAXBContext context;
            context = JAXBContext.newInstance(adobeServiceResponse.getClass());

            Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setSchema(null);
            adobeServiceResponse = OnePassServiceAdobeResponse.class.cast(unmarshaller.unmarshal(stream));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        return adobeServiceResponse;

    }

    /**
     * Renew cds auth token.
     * 
     * @param authToken
     *            the auth token
     * @param appId
     *            the app id
     * @param appVersion
     *            the app version
     * @param adobeServiceResponse
     *            the adobe service response
     * @return the one pass service adobe response
     */
    private OnePassServiceAdobeResponse renewCDSAuthToken(String authToken, String appId, String appVersion, OnePassServiceAdobeResponse adobeServiceResponse) {

        StringBuffer URL = new StringBuffer(getBundleStringValue("cdsRenewAuthTokenUrl"));
        URL.append("authToken=" + authToken);
        URL.append("&appId=" + appId);
        URL.append("&appVersion=" + appVersion);

        System.out.println("\n\n URL.toString() :  " + URL.toString());

        EntityManagerHelper.log("Start OnePassServiceAdobeResponse. renewCDSAuthToken : URL.toString() : " + URL.toString(), Level.INFO, null);

        GetMethod method = new GetMethod(URL.toString());

        HttpClient httpClient = new HttpClient();

        try {

            int executeResult = httpClient.executeMethod(method);

            if (200 != executeResult) {
                System.out.println("\n\n ********* 200 != executeResult ********\n\n ");
            }

            InputStream stream = method.getResponseBodyAsStream();
            JAXBContext context;
            context = JAXBContext.newInstance(adobeServiceResponse.getClass());

            Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setSchema(null);
            adobeServiceResponse = OnePassServiceAdobeResponse.class.cast(unmarshaller.unmarshal(stream));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        EntityManagerHelper.log("END OnePassServiceAdobeResponse. renewCDSAuthToken  ", Level.INFO, null);

        return adobeServiceResponse;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.readersdigest.onepass.service.impl.OnePassServiceImpl#resetForgetPasswordToken(java.lang.String)
     */
    public OnePassServiceResponse resetForgetPasswordToken(String emailAddress, String sourceId) {

        EntityManagerHelper.log("Start OnePassAuthServiceImpl.resetForgetPasswordToken() ..", Level.INFO, null);

        OnePassServiceResponse serviceResponse;
        serviceResponse = new OnePassServiceResponse();

        if (sourceId == null || "".equals(sourceId.trim())) {
            sourceId = "769"; // default rdo source
        }

        String prodAbbr = StringUtils.getProdIdBySource(sourceId);

        try {
            EntityManagerHelper.beginTransaction();
            EntityManagerHelper.getEntityManager().setFlushMode(FlushModeType.COMMIT);
            
            try {
                ServiceValidator serviceValidator = new ServiceValidator();
                serviceValidator.validateRequired(emailAddress, StringUtils.getBundleProperty("emailAddress.required"));
                serviceValidator.validEmailAddress(emailAddress, "emailAddress.valid");
            } catch (ServiceException ex) {
                serviceResponse.responseText = ex.getMessage();
                serviceResponse.status = TRANSACTION_FAILED;
                EntityManagerHelper.rollback();
                EntityManagerHelper.log("Error OnePassServiceImpl.userLogin() ..", Level.INFO, ex);
                return serviceResponse;
            }

            Member member = null;
            List<MemberOnePassInfo> memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active", emailAddress.trim(),
                    prodAbbr, ACTIVE_MEMBER);
            if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
                MemberOnePassInfo memberOnePassInfo = memberOnePassInfoDAO.refresh(memberOnePassInfoList.get(0));
                member = memberOnePassInfo.getMember();
                IMemberPWDResetDAO memberPWDResetDAO = new MemberPWDResetDAO();
                MemberPWDReset memberPWDReset = new MemberPWDReset();
                memberPWDReset.setMember(member);
                memberPWDReset.setMemberOnePassId(memberOnePassInfo.getMemberOnePassInfoId());
                memberPWDReset.setToken(UUID.randomUUID().toString());
                memberPWDReset.setCreateDate(new Timestamp(System.currentTimeMillis()));
                memberPWDResetDAO.save(memberPWDReset);
                serviceResponse.token = memberPWDReset.getToken();
                EntityManagerHelper.commit();
            } else {
                serviceResponse.responseText = StringUtils.getBundleProperty("emailAddress.valid");
                serviceResponse.status = TRANSACTION_FAILED;
                EntityManagerHelper.rollback();
                return serviceResponse;
            }

        } catch (Exception e) {
            serviceResponse.responseText = e.getMessage();
            serviceResponse.status = TRANSACTION_FAILED;
            EntityManagerHelper.rollback();
            e.printStackTrace();
        } finally {
            EntityManagerHelper.clear();
            EntityManagerHelper.closeEntityManager();
        }

        EntityManagerHelper.log("End OnePassAuthServiceImpl.resetForgetPasswordToken() ..", Level.INFO, null);

        return serviceResponse;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.readersdigest.onepass.service.impl.OnePassServiceImpl#updateNewPassword(java.lang.String, java.lang.String)
     */
    public OnePassServiceResponse updateNewPassword(String token, String password, String sourceId) {

        EntityManagerHelper.log("Start OnePassServiceImpl.updateNewPassword() ..", Level.INFO, null);

        OnePassServiceResponse serviceResponse = new OnePassServiceResponse();

        if (sourceId == null || "".equals(sourceId.trim())) {
            sourceId = "769"; // default rdo source
        }

        String prodAbbr = StringUtils.getProdIdBySource(sourceId);

        try {

            EntityManagerHelper.beginTransaction();
            EntityManagerHelper.getEntityManager().setFlushMode(FlushModeType.COMMIT);
            
            IMemberPWDResetDAO memberPWDResetDAO = new MemberPWDResetDAO();

            List<MemberOnePassInfo> memberOnePassInfoList = null;

            List<MemberPWDReset> memberPWDResetList = memberPWDResetDAO.findByToken(token);

            if (memberPWDResetList == null || memberPWDResetList.size() == 0) {
                serviceResponse.responseText = StringUtils.getBundleProperty("token.valid");
                serviceResponse.status = TRANSACTION_FAILED;
                return serviceResponse;
            }

            MemberPWDReset memberPWDReset = memberPWDResetList.get(0);
            String tokenExiprationTime = getBundleStringValue("passwordResetExpiration");
            long expirationTime = tokenExiprationTime != null && !"".equals(tokenExiprationTime.trim()) ? Long.parseLong(tokenExiprationTime) : 0;
            Member member = null;
            String rdEmailPattern = getBundleStringValue("rdEmailRegEx");

            if (memberPWDReset.getCreateDate().getTime() + expirationTime < System.currentTimeMillis()) {
                serviceResponse.responseText = StringUtils.getBundleProperty("token.expired");
                serviceResponse.status = TRANSACTION_FAILED;
            } else {
                member = memberPWDReset.getMember();
                //memberOnePassInfoList = findByProperties("member.memberId", "prodId", "active", member.getMemberId(), prodAbbr,
                       // ACTIVE_MEMBER);
                MemberOnePassInfo memberOnePassInfo = memberOnePassInfoDAO.findById(memberPWDReset.getMemberOnePassId());
                
//                if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
//                    for (MemberOnePassInfo memberOnePassInfo : memberOnePassInfoList) {
//                        try {
//                            memberOnePassInfo.setPassword(OneWayEncrypter.encryptString(password));
//                        } catch (NoSuchAlgorithmException e) {
//                            serviceResponse.responseText = StringUtils.getBundleProperty("password.failedEncryption");
//                            serviceResponse.status = TRANSACTION_FAILED;
//                            EntityManagerHelper.rollback();
//                            e.printStackTrace();
//                        }
//
//                        memberOnePassInfoDAO.update(memberOnePassInfo);
//
//                        if (memberOnePassInfo.getEmailAddress().matches(rdEmailPattern)) {
//                            List<EmailValidation> emailValidList = emailValidationDAO.findByProperty("emailAddress", memberOnePassInfo.getEmailAddress());
//                            if (emailValidList != null && emailValidList.size() > 0) {
//                            	EmailValidation emailValid = emailValidList.get(0);
//                                emailValid.setValid(OnePassServiceImpl.VALID_STRING);
//                                emailValidationDAO.update(emailValid);
//                            } else {
//                            	EmailValidation emailValid = new EmailValidation();
//                                emailValid.setEmailAddress(memberOnePassInfo.getEmailAddress());
//                                emailValid.setCreateDate(new Timestamp(System.currentTimeMillis()));
//                                emailValid.setValid(VALID_STRING);
//                                emailValid.setProdId(prodAbbr);
//                                token = UUID.randomUUID().toString();
//                                emailValid.setToken(token);
//                                emailValidationDAO.save(emailValid);
//                            }
//                        }
//                    }
//                }

                try {
                    memberOnePassInfo.setPassword(OneWayEncrypter.encryptString(password));
                } catch (NoSuchAlgorithmException e) {
                    serviceResponse.responseText = StringUtils.getBundleProperty("password.failedEncryption");
                    serviceResponse.status = TRANSACTION_FAILED;
                    EntityManagerHelper.rollback();
                    e.printStackTrace();
                }

                memberOnePassInfoDAO.update(memberOnePassInfo);

                if (memberOnePassInfo.getEmailAddress().matches(rdEmailPattern)) {
                    List<EmailValidation> emailValidList = emailValidationDAO.findByProperty("emailAddress", memberOnePassInfo.getEmailAddress());
                    if (emailValidList != null && emailValidList.size() > 0) {
                    	EmailValidation emailValid = emailValidList.get(0);
                        emailValid.setValid(OnePassServiceImpl.VALID_STRING);
                        emailValidationDAO.update(emailValid);
                    } else {
                    	EmailValidation emailValid = new EmailValidation();
                        emailValid.setEmailAddress(memberOnePassInfo.getEmailAddress());
                        emailValid.setCreateDate(new Timestamp(System.currentTimeMillis()));
                        emailValid.setValid(VALID_STRING);
                        emailValid.setProdId(prodAbbr);
                        token = UUID.randomUUID().toString();
                        emailValid.setToken(token);
                        emailValidationDAO.save(emailValid);
                    }
                }
                
                serviceResponse.responseText = TRANSACTION_SUCCESS_RESPONSE_TEXT;
                serviceResponse.status = TRANSACTION_SUCCESS;
            }

            // Update the time up to 24 + 1 hrs for blocking user to use token second time
            memberPWDReset.setCreateDate(new Timestamp(System.currentTimeMillis() - (expirationTime + 3600000)));
            memberPWDResetDAO.update(memberPWDReset);

            EntityManagerHelper.commit();
        } catch (Exception e) {
            serviceResponse.responseText = e.getMessage();
            serviceResponse.status = TRANSACTION_FAILED;
            EntityManagerHelper.rollback();
            e.printStackTrace();
        } finally {
            EntityManagerHelper.clear();
            EntityManagerHelper.closeEntityManager();
        }

        EntityManagerHelper.log("End OnePassServiceImpl.updateNewPassword() ..", Level.INFO, null);

        return serviceResponse;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.readersdigest.onepass.service.impl.OnePassServiceImpl#updateNewPassword(java.lang.String, java.lang.String)
     */
    public OnePassServiceAdobeResponse updateCDSUserPassword(String emailAddress, String password, String accountNumber, String appId) {

        EntityManagerHelper.log("Start OnePassAuthServiceImpl.updateCDSUserPassword() ..", Level.INFO, null);

        OnePassServiceAdobeResponse serviceResponse = new OnePassServiceAdobeResponse();

        try {
            String prodAbbr = StringUtils.getProdId(appId);

            if (prodAbbr == null || "".equals(prodAbbr)) {
                prodAbbr = StringUtils.getKindleProdId(appId); // Getting the APP Id for Kindle
            }

            EntityManagerHelper.beginTransaction();
            EntityManagerHelper.getEntityManager().setFlushMode(FlushModeType.COMMIT);

            List<MemberOnePassInfo> memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "accountNumber", "active",
                    emailAddress.trim(), prodAbbr, accountNumber, ACTIVE_MEMBER);

            if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
                try {
                    MemberOnePassInfo memberOnePassInfo = memberOnePassInfoList.get(0);
                    memberOnePassInfo.setPassword(OneWayEncrypter.encryptString(password));
                    memberOnePassInfoDAO.update(memberOnePassInfo);
                    EntityManagerHelper.commit();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    serviceResponse.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
                    EntityManagerHelper.rollback();
                    return serviceResponse;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
            serviceResponse.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
            return serviceResponse;
        } finally {
            EntityManagerHelper.clear();
            EntityManagerHelper.closeEntityManager();
        }

        EntityManagerHelper.log("End OnePassServiceImpl.updateCDSNewPassword() ..", Level.INFO, null);
        serviceResponse.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");

        return serviceResponse;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.readersdigest.onepass.service.impl.OnePassServiceImpl#entitlements(java.lang.String, java.lang.String, java.lang.String)
     */
    public OnePassServiceAdobeResponse entitlements(String authToken, String appId, String appVersion) {

        OnePassServiceAdobeResponse adobeServiceResponse = new OnePassServiceAdobeResponse();

        StringBuffer URL = new StringBuffer(getBundleStringValue("cdsEntitlementsUrl"));
        URL.append("authToken=" + authToken);
        URL.append("&appId=" + appId);
        URL.append("&appVersion=" + appVersion);

        EntityManagerHelper.log("Start OnePassServiceAdobeResponse.entitlements() URL.toString() : " + URL.toString(), Level.INFO, null);

        String prodAbbr = StringUtils.getProdId(appId);

        if (prodAbbr == null || "".equals(prodAbbr)) {
            prodAbbr = StringUtils.getKindleProdId(appId); // Getting the APP Id for Kindle
        }

        if ((RDEMPLOYEE_AUTH_TOKEN + prodAbbr).equals(authToken)) {
            adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
            adobeServiceResponse.entitlements = new EntitlementsDTO();
            adobeServiceResponse.entitlements.productId = getEntitlements(appId);
            EntityManagerHelper.log(" OnePassServiceAdobeResponse.entitlements() Return entilements for employee ", Level.INFO, null);
            return adobeServiceResponse;
        } 
        
        if ((BRANDADVOCATE_THREE_MONTH_TOKEN + prodAbbr).equals(authToken)) {
            adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
            adobeServiceResponse.entitlements = new EntitlementsDTO();
            adobeServiceResponse.entitlements.productId = getBrandAdvocateEntitlements(appId);
            EntityManagerHelper.log(" OnePassServiceAdobeResponse.entitlements() Return entilements for employee ", Level.INFO, null);
            return adobeServiceResponse;
        } 
        
        if ((BRANDADVOCATE_ONE_MONTH_TOKEN + prodAbbr).equals(authToken)) {
        	adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
            adobeServiceResponse.entitlements = new EntitlementsDTO();
            adobeServiceResponse.entitlements.productId = getPromotionalEntitlements(appId);
            EntityManagerHelper.log(" OnePassServiceAdobeResponse.entitlements() Return entilements for employee ", Level.INFO, null);
            return adobeServiceResponse;
        } 
        
                
        GetMethod method = new GetMethod(URL.toString());

        HttpClient httpClient = new HttpClient();

        try {

            int executeResult = httpClient.executeMethod(method);

            if (200 != executeResult) {
                System.out.println("\n\n ********* 200 != executeResult ********\n\n ");
            }

            InputStream stream = method.getResponseBodyAsStream();
            JAXBContext context;
            context = JAXBContext.newInstance(adobeServiceResponse.getClass());

            Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setSchema(null);
            adobeServiceResponse = OnePassServiceAdobeResponse.class.cast(unmarshaller.unmarshal(stream));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        if (getBundleStringValue("serviceSuccessStatusCode").equals(adobeServiceResponse.httpResponseCode)) {
            return adobeServiceResponse;
        } else {

            List<Member> memberList = memberDAO.findByPassword(authToken);
            if (memberList != null && memberList.size() > 0) {
                adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
                adobeServiceResponse.entitlements = new EntitlementsDTO();
            } else {
                adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
            }

            return adobeServiceResponse;
        }

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.readersdigest.onepass.service.impl.OnePassServiceImpl#verifyEntitlement(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public OnePassServiceAdobeEntitledVerifyResponse verifyEntitlement(String authToken, String productId, String appId, String appVersion) {

        OnePassServiceAdobeEntitledVerifyResponse adobeServiceResponse = new OnePassServiceAdobeEntitledVerifyResponse();

        StringBuffer URL = new StringBuffer(getBundleStringValue("cdsVerifyEntitlementUrl"));
        URL.append("authToken=" + authToken);
        URL.append("&productId=" + productId);
        URL.append("&appId=" + appId);
        URL.append("&appVersion=" + appVersion);

        System.out.println("\n\n URL.toString() :  " + URL.toString());

        String prodAbbr = StringUtils.getProdId(appId);

        if (prodAbbr == null || "".equals(prodAbbr)) {
            prodAbbr = StringUtils.getKindleProdId(appId); // Getting the APP Id for Kindle
        }

        if ((RDEMPLOYEE_AUTH_TOKEN + prodAbbr).equals(authToken)) {
            adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
            adobeServiceResponse.entitled = verifyEmployeeEntitlements(appId, productId);
            EntityManagerHelper.log(" OnePassServiceAdobeResponse.verifyEntitlement() Return entilements for employee ", Level.INFO, null);
            return adobeServiceResponse;
        }
        
        if ((BRANDADVOCATE_THREE_MONTH_TOKEN + prodAbbr).equals(authToken)) {
        	adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
            adobeServiceResponse.entitled = verifyBrandAdvocateEntitlements(appId, productId);
            EntityManagerHelper.log(" OnePassServiceAdobeResponse.verifyPromotionalEmployeeEntitlements() Return entilements for employee ", Level.INFO, null);
            return adobeServiceResponse;
        } 
        
        if ((BRANDADVOCATE_ONE_MONTH_TOKEN + prodAbbr).equals(authToken)) {
        	adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
            adobeServiceResponse.entitled = verifyPromotionalEmployeeEntitlements(appId, productId);
            EntityManagerHelper.log(" OnePassServiceAdobeResponse.verifyPromotionalEmployeeEntitlements() Return entilements for employee ", Level.INFO, null);
            return adobeServiceResponse;
        } 
        

        GetMethod method = new GetMethod(URL.toString());

        HttpClient httpClient = new HttpClient();

        try {

            int executeResult = httpClient.executeMethod(method);

            if (200 != executeResult) {
                System.out.println("\n\n ********* 200 != executeResult ********\n\n ");
            }

            InputStream stream = method.getResponseBodyAsStream();
            JAXBContext context;
            context = JAXBContext.newInstance(adobeServiceResponse.getClass());

            Unmarshaller unmarshaller = context.createUnmarshaller();
            unmarshaller.setSchema(null);
            adobeServiceResponse = OnePassServiceAdobeEntitledVerifyResponse.class.cast(unmarshaller.unmarshal(stream));

        } catch (IOException e) {
            e.printStackTrace();
        } catch (JAXBException e) {
            e.printStackTrace();
        }

        if (getBundleStringValue("serviceSuccessStatusCode").equals(adobeServiceResponse.httpResponseCode)) {
            return adobeServiceResponse;
        } else {
            List<Member> memberList = memberDAO.findByPassword(authToken);
            if (memberList != null && memberList.size() > 0) {
                adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
                adobeServiceResponse.entitled = false;
            } else {
                adobeServiceResponse.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
            }

            return adobeServiceResponse;
        }

    }

    public List<String> getEntitlements(String appId) {

        List<String> entilements = new ArrayList<String>();

        try {
            String prodAbbr = StringUtils.getProdId(appId);

            if (prodAbbr == null || "".equals(prodAbbr)) {
                prodAbbr = StringUtils.getKindleProdId(appId); // Getting the APP Id for Kindle
            }

            if ("RDO".equals(prodAbbr)) {
                List<EntitlementsRdo> listRdo = entitlementsRdoDAO.findAll();
                for (EntitlementsRdo entitlementsRdo : listRdo) {
                    entilements.add(entitlementsRdo.getProductId());
                }
            } else if ("TOO".equals(prodAbbr)) {
                List<EntitlementsToh> listToh = entitlementsTohDAO.findAll();
                for (EntitlementsToh entitlementsToh : listToh) {
                    entilements.add(entitlementsToh.getProductId());
                }
            } else if ("FHO".equals(prodAbbr)) {
                List<EntitlementsFho> listFho = entitlementsFhoDAO.findAll();
                for (EntitlementsFho entitlementsFho : listFho) {
                    entilements.add(entitlementsFho.getProductId());
                }
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            EntityManagerHelper.clear();
            EntityManagerHelper.closeEntityManager();
        }

        return entilements;
    }
    
    public List<String> getPromotionalEntitlements(String appId) {

        List<String> entilements = new ArrayList<String>();

        try {
            String prodAbbr = StringUtils.getProdId(appId);

            if (prodAbbr == null || "".equals(prodAbbr)) {
                prodAbbr = StringUtils.getKindleProdId(appId); // Getting the APP Id for Kindle
            }

            if ("RDO".equals(prodAbbr)) {
                List<PromotionalEntitlementsRdo> listRdo = promotionalEntitlementsRdoDAO.findAll();
                for (PromotionalEntitlementsRdo entitlementsRdo : listRdo) {
                    entilements.add(entitlementsRdo.getProductId());
                }
            } /*else if ("TOO".equals(prodAbbr)) {
                List<EntitlementsToh> listToh = entitlementsTohDAO.findAll();
                for (EntitlementsToh entitlementsToh : listToh) {
                    entilements.add(entitlementsToh.getProductId());
                }
            } else if ("FHO".equals(prodAbbr)) {
                List<EntitlementsFho> listFho = entitlementsFhoDAO.findAll();
                for (EntitlementsFho entitlementsFho : listFho) {
                    entilements.add(entitlementsFho.getProductId());
                }
            }*/
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            EntityManagerHelper.clear();
            EntityManagerHelper.closeEntityManager();
        }

        return entilements;
    }
    
    public List<String> getBrandAdvocateEntitlements(String appId) {

        List<String> entilements = new ArrayList<String>();

        try {
            String prodAbbr = StringUtils.getProdId(appId);

            if (prodAbbr == null || "".equals(prodAbbr)) {
                prodAbbr = StringUtils.getKindleProdId(appId); // Getting the APP Id for Kindle
            }
            
            IEntitlementsBrandAdvocateDAO entitlementsDAO = new EntitlementsBrandAdvocateDAO();
            
            List<EntitlementsBrandAdvocate> listEntitlements = entitlementsDAO.findByProperties("brand", "active", prodAbbr, "A");
            
            for (EntitlementsBrandAdvocate entitlement : listEntitlements) {
                    entilements.add(entitlement.getProductId());
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } finally {
            EntityManagerHelper.clear();
            EntityManagerHelper.closeEntityManager();
        }

        return entilements;
    }
    
    
    private boolean verifyBrandAdvocateEntitlements(String appId, String productId) {

        try {
            String prodAbbr = StringUtils.getProdId(appId);

            if (prodAbbr == null || "".equals(prodAbbr)) {
                prodAbbr = StringUtils.getKindleProdId(appId); // Getting the APP Id for Kindle
            }

            IEntitlementsBrandAdvocateDAO entitlementsDAO = new EntitlementsBrandAdvocateDAO();
            
            List<EntitlementsBrandAdvocate> listEntitlements = entitlementsDAO.findByProperties("brand", "productId", prodAbbr, productId);
            
            return listEntitlements != null;
           
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } finally {
            EntityManagerHelper.clear();
            EntityManagerHelper.closeEntityManager();
        }

    }
    
    private boolean verifyPromotionalEmployeeEntitlements(String appId, String productId) {

        try {
            String prodAbbr = StringUtils.getProdId(appId);

            if (prodAbbr == null || "".equals(prodAbbr)) {
                prodAbbr = StringUtils.getKindleProdId(appId); // Getting the APP Id for Kindle
            }

            if ("RDO".equals(prodAbbr)) {
            	PromotionalEntitlementsRdo entitlement = promotionalEntitlementsRdoDAO.findById(productId);
                return entitlement != null;

            } /*else if ("TOO".equals(prodAbbr)) {
                EntitlementsToh entitlement = entitlementsTohDAO.findById(productId);
                return entitlement != null;
            } else if ("FHO".equals(prodAbbr)) {
                EntitlementsFho entitlement = entitlementsFhoDAO.findById(productId);
                return entitlement != null;
            } */else {
                return false;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } finally {
            EntityManagerHelper.clear();
            EntityManagerHelper.closeEntityManager();
        }

    }

    private boolean verifyEmployeeEntitlements(String appId, String productId) {

        try {
            String prodAbbr = StringUtils.getProdId(appId);

            if (prodAbbr == null || "".equals(prodAbbr)) {
                prodAbbr = StringUtils.getKindleProdId(appId); // Getting the APP Id for Kindle
            }

            if ("RDO".equals(prodAbbr)) {
                EntitlementsRdo entitlement = entitlementsRdoDAO.findById(productId);
                return entitlement != null;

            } else if ("TOO".equals(prodAbbr)) {
                EntitlementsToh entitlement = entitlementsTohDAO.findById(productId);
                return entitlement != null;
            } else if ("FHO".equals(prodAbbr)) {
                EntitlementsFho entitlement = entitlementsFhoDAO.findById(productId);
                return entitlement != null;
            } else {
                return false;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return false;
        } finally {
            EntityManagerHelper.clear();
            EntityManagerHelper.closeEntityManager();
        }

    }

    public OnePassServiceAdobeResponse getUserInfo(String userName, String appId) {

        OnePassServiceAdobeResponse adobeServiceResponse = new OnePassServiceAdobeResponse();

        String prodAbbr = StringUtils.getProdId(appId);

        if (prodAbbr == null || "".equals(prodAbbr)) {
            prodAbbr = StringUtils.getKindleProdId(appId); // Getting the APP Id for Kindle
        }

        System.out.println("\n\n ***prodAbbr : " + prodAbbr);

        try {
            if (userName == null || "".equalsIgnoreCase(userName.trim())) {
                adobeServiceResponse.completeAccountSetUp = "false";
                return adobeServiceResponse;
            }

            List<MemberOnePassInfo> memberOnePassInfoList;

            try {

                long accountNumber = Long.parseLong(userName.trim());
                String strAccountNumber = String.valueOf(accountNumber);
                int accountLength = strAccountNumber.length();

                for (int i = accountLength; i < 10; i++) {
                    strAccountNumber = "0" + strAccountNumber;
                }

                memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("accountNumber", "prodId", "active", strAccountNumber, prodAbbr, ACTIVE_MEMBER);

                if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
                    MemberOnePassInfo memberOnePassInfo = memberOnePassInfoDAO.refresh(memberOnePassInfoList.get(0));
                    adobeServiceResponse.completeAccountSetUp = "CDS";
                    adobeServiceResponse.fullName = WordUtils.capitalizeFully(memberOnePassInfo.getFullName());
                    adobeServiceResponse.emailAddress = memberOnePassInfo.getEmailAddress();
                    return adobeServiceResponse;
                }

            } catch (Exception ex) {
                EntityManagerHelper.log("ERROR Check for Email Address ..", Level.INFO, null);
            }

            memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active", userName.trim(), prodAbbr, ACTIVE_MEMBER);

            if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
                for (MemberOnePassInfo memberOnePassInfo : memberOnePassInfoList) {
                    memberOnePassInfo = memberOnePassInfoDAO.refresh(memberOnePassInfo);
                    if (memberOnePassInfo.getAccountNumber() != null && !"".equals(memberOnePassInfo.getAccountNumber().trim())) {
                        adobeServiceResponse.completeAccountSetUp = "CDS";
                        adobeServiceResponse.fullName = WordUtils.capitalizeFully(memberOnePassInfo.getFullName());
                        adobeServiceResponse.emailAddress = memberOnePassInfo.getEmailAddress();
                        return adobeServiceResponse;
                    }
                }
            }
            if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
                MemberOnePassInfo memberOnePassInfo = memberOnePassInfoDAO.refresh(memberOnePassInfoList.get(0));
              
                if (memberOnePassInfo.getFullName() != null && !"".equals(memberOnePassInfo.getFullName().trim())) {
                    adobeServiceResponse.completeAccountSetUp = "true";
                    adobeServiceResponse.fullName = WordUtils.capitalizeFully(memberOnePassInfo.getFullName());
                    adobeServiceResponse.emailAddress = memberOnePassInfo.getEmailAddress();
                    return adobeServiceResponse;
                } else {
                    adobeServiceResponse.completeAccountSetUp = "false";
                    adobeServiceResponse.emailAddress = userName;
                    return adobeServiceResponse;
                }
            }

            adobeServiceResponse.completeAccountSetUp = "false";
            return adobeServiceResponse;

        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            adobeServiceResponse.completeAccountSetUp = "false";
            return adobeServiceResponse;
        } finally {
            EntityManagerHelper.clear();
            EntityManagerHelper.closeEntityManager();
        }

    }

    
    public OnePassServiceResponse updateValidEmailAddress(String accountNumber, String oldEmailAddress, String newEmailAddress, String password,
            String sourceId, String appId) {

        OnePassServiceResponse serviceResponse = new OnePassServiceResponse();
        UpdateOnePassUserProfileDTO dto = new UpdateOnePassUserProfileDTO();
        dto.header = new HeaderDTO();
        dto.emailFields = new EmailDTO();
        dto.accountFields = new AccountDTO();
        dto.accountFields.preferenceFields = new HashSet<PreferenceDTO>();
        dto.header.emailAddress = oldEmailAddress;
        dto.emailFields.newEmailAddress = newEmailAddress;
        dto.accountFields.sourceId = sourceId;
        dto.emailFields.accountNumber = accountNumber;

        if (password != null && !"".equals(password.trim())) {
            dto.emailFields.password = password;
        }

        serviceResponse = updateEmailProfileInfo(dto);

        return serviceResponse;

    }

    public boolean updateEmailValidity(String token) {
        boolean flag = false;

        if (token == null) {
            return flag;
        }
        
        try {
            EntityManagerHelper.beginTransaction();
            EntityManagerHelper.getEntityManager().setFlushMode(FlushModeType.COMMIT);
            List<EmailValidation> emailValidList = emailValidationDAO.findByToken(token);
            if (emailValidList != null && emailValidList.size() > 0) {
            	EmailValidation emailValid = emailValidList.get(0);
            	 System.out.println("\n\n ******emailValidList : in F " );
                    emailValid = emailValidationDAO.refresh(emailValid);
                    emailValid.setValid(VALID_STRING);
                    emailValidationDAO.update(emailValid);
                    EntityManagerHelper.commit();
                    flag = true;
                
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            EntityManagerHelper.rollback();
        } finally {
            EntityManagerHelper.clear();
            EntityManagerHelper.closeEntityManager();
        }
        return flag;
    }

}
