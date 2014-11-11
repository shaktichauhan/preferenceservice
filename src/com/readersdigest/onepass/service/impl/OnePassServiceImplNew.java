package com.readersdigest.onepass.service.impl;

import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;

import com.readersdigest.emailClient.EmailClient;
import com.readersdigest.emailClient.StrongMailClient;
import com.readersdigest.onepass.db.AddressType;
import com.readersdigest.onepass.db.AddressTypeDAO;
import com.readersdigest.onepass.db.Bundle;
import com.readersdigest.onepass.db.BundleDAO;
import com.readersdigest.onepass.db.Email;
import com.readersdigest.onepass.db.EmailAddressOptHistory;
import com.readersdigest.onepass.db.EmailAddressOptStatus;
import com.readersdigest.onepass.db.EmailAddressOptStatusDAO;
import com.readersdigest.onepass.db.EmailAddressOptStatusId;
import com.readersdigest.onepass.db.EmailDAO;
import com.readersdigest.onepass.db.EmailValid;
import com.readersdigest.onepass.db.EmailValidDAO;
import com.readersdigest.onepass.db.EntityManagerHelper;
import com.readersdigest.onepass.db.IAddressTypeDAO;
import com.readersdigest.onepass.db.IBundleDAO;
import com.readersdigest.onepass.db.IEmailAddressOptStatusDAO;
import com.readersdigest.onepass.db.IEmailDAO;
import com.readersdigest.onepass.db.IEmailValidDAO;
import com.readersdigest.onepass.db.IMemberBundleDAO;
import com.readersdigest.onepass.db.IMemberDAO;
import com.readersdigest.onepass.db.IMemberInfoDAO;
import com.readersdigest.onepass.db.IMemberOnePassInfoDAO;
import com.readersdigest.onepass.db.IMemberStatusDAO;
import com.readersdigest.onepass.db.IOptStatusTransactionDAO;
import com.readersdigest.onepass.db.IPostalAddressDAO;
import com.readersdigest.onepass.db.ISourceDAO;
import com.readersdigest.onepass.db.IUserPreferenceDAO;
import com.readersdigest.onepass.db.Member;
import com.readersdigest.onepass.db.MemberBundle;
import com.readersdigest.onepass.db.MemberBundleDAO;
import com.readersdigest.onepass.db.MemberBundleId;
import com.readersdigest.onepass.db.MemberDAO;
import com.readersdigest.onepass.db.MemberInfo;
import com.readersdigest.onepass.db.MemberInfoDAO;
import com.readersdigest.onepass.db.MemberOnePassInfo;
import com.readersdigest.onepass.db.MemberOnePassInfoDAO;
import com.readersdigest.onepass.db.MemberStatus;
import com.readersdigest.onepass.db.MemberStatusDAO;
import com.readersdigest.onepass.db.OptStatus;
import com.readersdigest.onepass.db.OptStatusTransaction;
import com.readersdigest.onepass.db.OptStatusTransactionDAO;
import com.readersdigest.onepass.db.PostalAddress;
import com.readersdigest.onepass.db.PostalAddressDAO;
import com.readersdigest.onepass.db.Source;
import com.readersdigest.onepass.db.SourceDAO;
import com.readersdigest.onepass.db.UserPreference;
import com.readersdigest.onepass.db.UserPreferenceDAO;
import com.readersdigest.onepass.dto.CreateOnePassUserProfileDTO;
import com.readersdigest.onepass.dto.OnePassServiceAdobeEntitledVerifyResponse;
import com.readersdigest.onepass.dto.OnePassServiceAdobeResponse;
import com.readersdigest.onepass.dto.OnePassServiceResponse;
import com.readersdigest.onepass.dto.OnePassUserLoginDTO;
import com.readersdigest.onepass.dto.PreferenceDTO;
import com.readersdigest.onepass.dto.UpdateOnePassUserProfileDTO;
import com.readersdigest.onepass.exception.ServiceException;
import com.readersdigest.onepass.service.OnePassService;
import com.readersdigest.onepass.util.DESEncrypter;
import com.readersdigest.onepass.util.OneWayEncrypter;
import com.readersdigest.onepass.util.StringUtils;

/**
 * The Class OnePassServiceImpl.
 * 
 * 
 * @author shsingh
 * 
 */
public class OnePassServiceImplNew {//implements OnePassService {

//    /** The Constant OPT_UNDEFINED. */
//    public static final int OPT_UNDEFINED = 1;
//
//    /** The Constant OPT_PREFERS. */
//    public static final int OPT_PREFERS = 2;
//
//    /** The Constant OPT_PREFERS_NOT. */
//    public static final int OPT_PREFERS_NOT = 3;
//
//    /** The Constant OPT_NEVER. */
//    public static final int OPT_NEVER = 4;
//
//    /** The Constant ADDRESS_TYPE_ID. */
//    public static final int ADDRESS_TYPE_ID = 1;
//
//    /** The Constant EMAIL_PRIMARY_ID. */
//    public static final int EMAIL_PRIMARY_ID = 1;
//
//    /** The Constant EMAIL_SECONDARY_ID. */
//    public static final int EMAIL_SECONDARY_ID = 2;
//
//    /** The member dao. */
//    private IMemberDAO memberDAO;
//
//    /** The address dao. */
//    private IPostalAddressDAO addressDAO;
//
//    /** The address type dao. */
//    private IAddressTypeDAO addressTypeDAO;
//
//    /** The memberInfo dao. */
//    private IMemberInfoDAO memberInfoDAO;
//
//    /** The email dao. */
//    private IEmailDAO emailDAO;
//
//    /** The opt status transaction dao. */
//    private IOptStatusTransactionDAO optStatusTransactionDAO;
//
//    /** The source dao. */
//    private ISourceDAO sourceDAO;
//
//    /** The user preference dao. */
//    private IUserPreferenceDAO userPreferenceDAO;
//
//    /** The email address opt status dao. */
//    private IEmailAddressOptStatusDAO emailAddressOptStatusDAO;
//    
//    private IMemberStatusDAO memberStatusDAO;
//    
//    private IBundleDAO bundleDAO;
//    
//    private IMemberBundleDAO memberBundleDAO;    
//    
//    private IEmailValidDAO emailValidDAO;  
//    
//    private IMemberOnePassInfoDAO memberOnePassInfoDAO;
//
//    /** The service validator. */
//    private ServiceValidator serviceValidator;
//
//    /** The service response. */
//    private OnePassServiceResponse serviceResponse;
//
//    /** The Constant TRANSACTION_SUCCESS. */
//    public static final String TRANSACTION_SUCCESS = getBundleStringValue("transactionSuccess");
//
//    /** The Constant TRANSACTION_FAILED. */
//    public static final String TRANSACTION_FAILED = getBundleStringValue("transactionFailed");;
//
//    /** The Constant TRANSACTION_SUCCESS_RESPONSE_TEXT. */
//    public static final String TRANSACTION_SUCCESS_RESPONSE_TEXT = getBundleStringValue("transactionSuccessMessage");
//    
//    public static final String VALID_STRING = "Y";
//    public static final String INVALID_STRING = "N";
//
//    /**
//     * Instantiates a new one pass service impl.
//     */
//    public OnePassServiceImplNew() {
//        memberDAO = new MemberDAO();
//        memberInfoDAO = new MemberInfoDAO();
//        addressDAO = new PostalAddressDAO();
//        addressTypeDAO = new AddressTypeDAO();
//        emailDAO = new EmailDAO();
//        sourceDAO = new SourceDAO();
//        optStatusTransactionDAO = new OptStatusTransactionDAO();
//        userPreferenceDAO = new UserPreferenceDAO();
//        serviceValidator = new ServiceValidator();
//        emailAddressOptStatusDAO = new EmailAddressOptStatusDAO();
//        serviceResponse = new OnePassServiceResponse();
//        memberStatusDAO = new MemberStatusDAO();
//        bundleDAO = new BundleDAO();        
//        memberBundleDAO = new MemberBundleDAO();
//        emailValidDAO = new EmailValidDAO();
//        memberOnePassInfoDAO = new MemberOnePassInfoDAO();
//      }
//
//    /**
//     * Create the user profile information.
//     * 
//     * @param dto
//     *            the CreateOnePassUserProfileDTO
//     * @return the OnePassServiceResponse object
//     */
//    public final OnePassServiceResponse createUserProfileInfo(final CreateOnePassUserProfileDTO dto) {
//
//        try {
//
//            EntityManagerHelper.log("Start OnePassServiceImpl.createUserProfileInfo() ..", Level.INFO, null);
//
//            try {
//                serviceValidator.validService(dto);
//            } catch (ServiceException ex) {
//                serviceResponse.responseText = ex.getMessage();
//                serviceResponse.status = TRANSACTION_FAILED;
//                return serviceResponse;
//            }
//
//            EntityManagerHelper.beginTransaction();
//
//            Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
//            
//            Email email = null;
//            
//            Member member = null;
//            
//            String accountNumber = dto.emailFields.accountNumber;
//            
//            String prodAbbr = StringUtils.getProdIdBySource(dto.accountFields.sourceId);
//            
//            List<Email> emailList = emailDAO.findByEmailAddress(dto.emailFields.emailAddress.trim());
//           
//            if(emailList != null && emailList.size() > 0) {
//                email = emailDAO.findByEmailAddress(dto.emailFields.emailAddress.trim()).get(0);
//            }
//            
//            if(email != null) {
//                if(email.getMember() == null) {
//                    member = new Member();
//                    if(memberDAO.findByMemberName(dto.emailFields.emailAddress.trim()).size() > 0) {
//                        member.setMemberName(UUID.randomUUID().getMostSignificantBits()+":"+dto.emailFields.emailAddress.trim());
//                    } else {
//                        member.setMemberName(dto.emailFields.emailAddress.trim());
//                    }            
//                   // member.setPassword(OneWayEncrypter.encryptString(dto.emailFields.password));
//                    memberDAO.save(member);
//                    email.setMember(member);
//                    email.setEmailTypeId(EMAIL_PRIMARY_ID);
//                    email.setEffectiveDate(timeStamp);
//                    email.setNonMemberProfile(null);
//                } else {
//                   
//                    if(accountNumber != null && !"".equalsIgnoreCase(accountNumber.trim())) {
//                        IMemberInfoDAO memberInfoDAO = new MemberInfoDAO();
//                        accountNumber = accountNumber.trim();
//                        for (int i = accountNumber.length(); i < 10; i++) {
//                            accountNumber = "0" + accountNumber;
//                        }
//                        if(memberInfoDAO.findByProperties("accountNumber", "cdsProdId", accountNumber, prodAbbr).size() > 0) {
//                            EntityManagerHelper.rollback();
//                            throw new ServiceException(StringUtils.getBundleProperty("emailAddress.exist"));
//                        }
//                        member = email.getMember();
//                       // member.setPassword(OneWayEncrypter.encryptString(dto.emailFields.password));
//                        memberDAO.update(member);
//                    } else {
//                        EntityManagerHelper.rollback();
//                        throw new ServiceException(StringUtils.getBundleProperty("emailAddress.exist"));
//                    }
//                    
//                }
//                emailDAO.update(email);
//            } else {
//                email = new Email();
//                member = new Member();
//                if(memberDAO.findByMemberName(dto.emailFields.emailAddress.trim()).size() > 0) {
//                    member.setMemberName(UUID.randomUUID().getMostSignificantBits()+":"+dto.emailFields.emailAddress.trim());
//                } else {
//                    member.setMemberName(dto.emailFields.emailAddress.trim());
//                }            
//                //member.setPassword(OneWayEncrypter.encryptString(dto.emailFields.password));
//                memberDAO.save(member);
//                email.setMember(member);
//                email.setEmailAddress(dto.emailFields.emailAddress.trim());
//                email.setEmailTypeId(EMAIL_PRIMARY_ID);
//                email.setEffectiveDate(timeStamp);
//                emailDAO.save(email);
//            }
//            
//            MemberInfo memberInfo = new MemberInfo();
//            MemberOnePassInfo memberOnePassInfo = new MemberOnePassInfo();
//            
//            if(accountNumber != null && !"".equalsIgnoreCase(accountNumber.trim())) {
//                
//                accountNumber = accountNumber.trim();
//                for (int i = accountNumber.length(); i < 10; i++) {
//                    accountNumber = "0" + accountNumber;
//                }
//                //memberInfo.setDiscussionAlias("CDS");
//            }
//            
//            memberInfo.setMember(member);
//            //memberInfo.setAccountNumber(accountNumber);
//            //memberInfo.setCdsProdId(prodAbbr);
//            memberInfoDAO.save(memberInfo);
//            memberOnePassInfo.setMember(member);
//            memberOnePassInfo.setPassword(OneWayEncrypter.encryptString(dto.emailFields.password));
//            memberOnePassInfo.setEmailAddress(dto.emailFields.emailAddress.trim());
//            memberOnePassInfo.setAccountNumber(accountNumber);
//            memberOnePassInfo.setProdId(prodAbbr);
//            if(accountNumber != null && !"".equalsIgnoreCase(accountNumber.trim())) {
//                memberOnePassInfo.setUserType("CDS");
//            }
//            
//            memberOnePassInfoDAO.save(memberOnePassInfo);
//          
//            PostalAddress address = new PostalAddress();
//            address.setMember(member);
//            address.setFirstName(dto.addressFields.firstName);
//            address.setLastName(dto.addressFields.lastName);
//            address.setAddress1(dto.addressFields.address1);
//            address.setAddress2(dto.addressFields.address2);
//            address.setCity(dto.addressFields.city);
//            address.setCountry(dto.addressFields.countryCode);
//
//            // Only insert the state for Country USA and Canada
//            if ("US".equalsIgnoreCase(dto.addressFields.countryCode) || "CA".equalsIgnoreCase(dto.addressFields.countryCode)) {
//                address.setSubdivision(dto.addressFields.stateCode);
//            }
//
//            address.setZip(dto.addressFields.zip);
//            address.setEffectiveDate(timeStamp);
//            address.setCreateDate(timeStamp);
//
//            AddressType addressType = addressTypeDAO.findById(ADDRESS_TYPE_ID);
//            address.setAddressType(addressType);
//            addressDAO.save(address);
//         
//            OptStatusTransaction optStatusTransaction = new OptStatusTransaction();
//            optStatusTransaction.setEmail(email);
//            optStatusTransaction.setCreateDate(timeStamp);
//
//            Source source = sourceDAO.findById(Integer.parseInt(dto.accountFields.sourceId));
//
//            if (source != null) {
//                optStatusTransaction.setSource(source);
//            } else {
//                EntityManagerHelper.rollback();
//                serviceResponse.responseText = StringUtils.getBundleProperty("sourceId.valid");
//                serviceResponse.status = TRANSACTION_FAILED;
//                return serviceResponse;
//            }
//
//            optStatusTransaction.setTrackingId(dto.accountFields.trackingId);
//
//            optStatusTransactionDAO.save(optStatusTransaction);
//            EntityManagerHelper.commit();
//            
//            // refreshed the optStatusTransaction for getting the id
//            optStatusTransaction = optStatusTransactionDAO.refresh(optStatusTransaction);
//
//            EntityManagerHelper.beginTransaction();
//            
//            MemberBundle memberBundle = new MemberBundle();
//            MemberStatus memberStatus = memberStatusDAO.findById(1);
//            String bundleId=getBundleStringValue("bundleId");
//            Bundle bundle = bundleDAO.findById(Integer.parseInt(bundleId));
//            MemberBundleId memberBundleId = new MemberBundleId(member.getMemberId(), bundle.getBundleId());
//            
//            if(memberBundleDAO.findById(memberBundleId) == null) {
//                memberBundle.setMember(member);
//                memberBundle.setMemberStatus(memberStatus);
//                memberBundle.setAutoRenew("Y");
//                memberBundle.setId(memberBundleId);
//                memberBundle.setCreateDate(timeStamp);
//                memberBundleDAO.save(memberBundle);
//            }
//            
//
//            Set<EmailAddressOptStatus> emailAddressOptStatuses = createEmailAddressOptStatus(optStatusTransaction, dto);
//
//            optStatusTransaction.setEmailAddressOptStatuses(emailAddressOptStatuses);
//
//            member.setOptStatusTransaction(optStatusTransaction);
//            memberDAO.update(member);
//
//            optStatusTransactionDAO.update(optStatusTransaction);
//
//            EntityManagerHelper.commit();
//            
//            // Email Address verification for RD employees for free fulfillment
//            String rdEmailPattern = getBundleStringValue("rdEmailRegEx");
//            if(dto.emailFields.emailAddress.trim().toLowerCase().matches(rdEmailPattern)) {
//                emailValidToken(dto.emailFields.emailAddress.trim().toLowerCase(), "RDO");
//            }
//
//            EntityManagerHelper.log("End OnePassServiceImpl.createUserProfileInfo() ..", Level.INFO, null);
//        } catch (ServiceException ex) {
//            EntityManagerHelper.log("Error OnePassServiceImpl.createUserProfileInfo() ..", Level.ALL, ex);
//            ex.printStackTrace();
//            EntityManagerHelper.rollback();
//            serviceResponse.responseText = ex.getMessage();
//            serviceResponse.status = TRANSACTION_FAILED;
//            return serviceResponse;
//
//        } catch (Exception ex) {
//            EntityManagerHelper.log("Error OnePassServiceImpl.createUserProfileInfo() ..", Level.ALL, ex);
//            ex.printStackTrace();
//            EntityManagerHelper.rollback();
//            serviceResponse.responseText = ex.getMessage();
//            serviceResponse.status = TRANSACTION_FAILED;
//            return serviceResponse;
//
//        }
//
//        serviceResponse.responseText = TRANSACTION_SUCCESS_RESPONSE_TEXT;
//        serviceResponse.status = TRANSACTION_SUCCESS;
//        return serviceResponse;
//
//    }
//    
//    
//
//    /**
//     * Creates the email address opt status.
//     * 
//     * @param optStatusTransaction
//     *            the opt status transaction
//     * @param dto
//     *            the dto
//     * @return the sets the
//     * @throws ServiceException
//     *             the service exception
//     */
//    private Set<EmailAddressOptStatus> createEmailAddressOptStatus(OptStatusTransaction optStatusTransaction, CreateOnePassUserProfileDTO dto)
//            throws ServiceException {
//
//        EntityManagerHelper.log("Start OnePassServiceImpl.createEmailAddressOptStatus() ..", Level.INFO, null);
//
//        Set<EmailAddressOptStatus> emailAddressOptStatuses = new HashSet<EmailAddressOptStatus>();
//
//        try {
//            Set<PreferenceDTO> preferenceFields = dto.accountFields.preferenceFields;
//
//            for (PreferenceDTO preferenceDTO : preferenceFields) {
//                UserPreference userPreference = userPreferenceDAO.findById(Integer.parseInt(preferenceDTO.preferenceId));
//                if (userPreference != null) {
//                    EmailAddressOptStatusId emailAddressOptStatusId = new EmailAddressOptStatusId(optStatusTransaction.getOptStatusTransactionId(),
//                            userPreference.getUserPreferenceId());
//                    OptStatus optStatus = new OptStatus();
//                    if (preferenceDTO.optIn) {
//                        optStatus.setOptStatusId(OPT_PREFERS);
//                    } else {
//                        optStatus.setOptStatusId(OPT_PREFERS_NOT);
//                    }
//                    emailAddressOptStatuses.add(new EmailAddressOptStatus(emailAddressOptStatusId, userPreference, optStatus, optStatusTransaction));
//                } else {
//                    throw new ServiceException(StringUtils.getBundleProperty("preference.valid"));
//                }
//            }
//
//        } catch (Exception e) {
//            EntityManagerHelper.rollback();
//            e.printStackTrace();
//            EntityManagerHelper.log("Error OnePassServiceImpl.createEmailAddressOptStatus() ..", Level.INFO, null);
//            throw new ServiceException(e.getMessage());
//        }
//
//        EntityManagerHelper.log("End OnePassServiceImpl.createEmailAddressOptStatus() ..", Level.INFO, null);
//
//        return emailAddressOptStatuses;
//    }
//
//    /**
//     * Update the user profile information.
//     * 
//     * @param dto
//     *            the UpdateOnePassUserProfileDTO
//     * @return the OnePassServiceResponse object
//     */
//    public final OnePassServiceResponse updateUserProfileInfo(final UpdateOnePassUserProfileDTO dto) {
//
//        try {
//
//            EntityManagerHelper.log("Start OnePassServiceImpl.updateUserProfileInfo() ..", Level.INFO, null);
//
//            try {
//                serviceValidator.validUpdateService(dto);
//            } catch (ServiceException ex) {
//                serviceResponse.responseText = ex.getMessage();
//                serviceResponse.status = TRANSACTION_FAILED;
//                return serviceResponse;
//            }
//
//            EntityManagerHelper.beginTransaction();
//
//            Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
//
//            Email email = null;
//
//            Member member = null;
//            
//            String prodAbbr = StringUtils.getProdIdBySource(dto.accountFields.sourceId);
//            
//            String accountNumber = dto.emailFields.accountNumber;
//            
//            List<Email> emailList = emailDAO.findByEmailAddress(dto.header.emailAddress.trim());
//
//            if (emailList != null && emailList.size() > 0) {
//                email = emailList.get(0);
//                member = email.getMember();
//       
//            }
//
//            if (member == null) {
//                serviceResponse.responseText = StringUtils.getBundleProperty("emailAddress.notExist");
//                serviceResponse.status = TRANSACTION_FAILED;
//                EntityManagerHelper.rollback();
//                return serviceResponse;
//            }
//            
//           
//            
//
//            if (dto.emailFields.password != null) {
//                member.setPassword(OneWayEncrypter.encryptString(dto.emailFields.password));
//            }
//
//            memberDAO.update(member);
//
//
//            PostalAddress newAddress = new PostalAddress();
//            newAddress.setMember(member);
//            newAddress.setFirstName(dto.addressFields.firstName);
//            newAddress.setLastName(dto.addressFields.lastName);
//            newAddress.setAddress1(dto.addressFields.address1);
//            newAddress.setAddress2(dto.addressFields.address2);
//            newAddress.setCity(dto.addressFields.city);
//            newAddress.setCountry(dto.addressFields.countryCode);
//            // Only insert the state for Country USA and Canada
//            if ("US".equalsIgnoreCase(dto.addressFields.countryCode) || "CA".equalsIgnoreCase(dto.addressFields.countryCode)) {
//                newAddress.setSubdivision(dto.addressFields.stateCode);
//            }
//
//            newAddress.setZip(dto.addressFields.zip);
//            newAddress.setCreateDate(timeStamp);
//            newAddress.setEffectiveDate(timeStamp);
//
//            PostalAddress oldAddress = null;
//            
//            List<PostalAddress> postalAddressList = addressDAO.findByProperty("member", member);
//            if(postalAddressList != null && postalAddressList.size() > 0) {
//                oldAddress = postalAddressList.get(0);
//            }
//            
//            if (oldAddress == null || !newAddress.equals(oldAddress)) {
//                AddressType addressType = addressTypeDAO.findById(ADDRESS_TYPE_ID);
//                newAddress.setAddressType(addressType);
//                addressDAO.save(newAddress);
//            }
//
//            OptStatusTransaction optStatusTransaction = new OptStatusTransaction();
//
//            if (dto.emailFields.newEmailAddress != null && !"".equals(dto.emailFields.newEmailAddress.trim())
//                    && !dto.header.emailAddress.trim().equalsIgnoreCase(dto.emailFields.newEmailAddress.trim())) {
//               
//                List<MemberInfo> memberInfoList = memberInfoDAO.findByProperties("accountNumber", "cdsProdId", accountNumber, prodAbbr);
//                
//                if(memberInfoDAO.findByAccountNumber(accountNumber).size() > 1) {
//                     
//                    if (emailDAO.findByEmailAddress(dto.emailFields.newEmailAddress.trim()).size() > 0) {
//                        Email existingEmail = emailDAO.findByEmailAddress(dto.emailFields.newEmailAddress.trim()).get(0);
//                        existingEmail.setEmailTypeId(EMAIL_PRIMARY_ID);
//                        existingEmail.setEffectiveDate(timeStamp);
//                        emailDAO.update(existingEmail);
//                        optStatusTransaction.setEmail(existingEmail);
//                    } else {
//                        Email newEmail = new Email();
//                        newEmail.setMember(member);
//                        newEmail.setEmailAddress(dto.emailFields.newEmailAddress.trim());
//                        newEmail.setEmailTypeId(EMAIL_PRIMARY_ID);
//                        newEmail.setEffectiveDate(timeStamp);
//                        emailDAO.save(newEmail);
//                        optStatusTransaction.setEmail(newEmail);
//                    }
//                } else {
//                    email.setEmailTypeId(EMAIL_SECONDARY_ID);
//                    email.setEffectiveDate(timeStamp);
//                    emailDAO.update(email);
//                    if (emailDAO.findByEmailAddress(dto.emailFields.newEmailAddress.trim()).size() > 0) {
//                        Email existingEmail = emailDAO.findByEmailAddress(dto.emailFields.newEmailAddress.trim()).get(0);
//                        existingEmail.setEmailTypeId(EMAIL_PRIMARY_ID);
//                        existingEmail.setEffectiveDate(timeStamp);
//                        emailDAO.update(existingEmail);
//                        optStatusTransaction.setEmail(existingEmail);
//                    } else {
//                        Email newEmail = new Email();
//                        newEmail.setMember(member);
//                        newEmail.setEmailAddress(dto.emailFields.newEmailAddress.trim());
//                        newEmail.setEmailTypeId(EMAIL_PRIMARY_ID);
//                        newEmail.setEffectiveDate(timeStamp);
//                        emailDAO.save(newEmail);
//                        optStatusTransaction.setEmail(newEmail);
//                    }
//
//                }
//                
//                
//            } else {
//                optStatusTransaction.setEmail(email);
//            }
//
//            optStatusTransaction.setCreateDate(timeStamp);
//            Source source = sourceDAO.findById(Integer.parseInt(dto.accountFields.sourceId));
//
//            if (source != null) {
//                optStatusTransaction.setSource(source);
//            } else {
//                EntityManagerHelper.rollback();
//                serviceResponse.responseText = StringUtils.getBundleProperty("sourceId.valid");
//                serviceResponse.status = TRANSACTION_FAILED;
//                return serviceResponse;
//            }
//
//            optStatusTransaction.setTrackingId(dto.accountFields.trackingId);
//
//            List<OptStatusTransaction> optStatusTransactionList = optStatusTransactionDAO.findByProperties("email", "source", email, source);
//
//            Set<EmailAddressOptHistory> emailAddressOptHistories = new HashSet<EmailAddressOptHistory>();
//            for (OptStatusTransaction opStatusTrns : optStatusTransactionList) {
//                Set<EmailAddressOptStatus> emailAddressOptStatuses = opStatusTrns.getEmailAddressOptStatuses();
//                for (EmailAddressOptStatus emailAddOptStatus : emailAddressOptStatuses) {
//                    emailAddressOptHistories.add(new EmailAddressOptHistory(emailAddOptStatus.getUserPreference(), emailAddOptStatus.getOptStatus(),
//                            emailAddOptStatus.getOptStatusTransaction()));
//                    if (emailAddressOptStatusDAO.findById(emailAddOptStatus.getId()) != null) {
//                        emailAddressOptStatusDAO.delete(emailAddOptStatus);
//                    }
//                }
//            }
//
//            optStatusTransaction.setEmailAddressOptHistories(emailAddressOptHistories);
//
//            optStatusTransactionDAO.save(optStatusTransaction);
//
//            EntityManagerHelper.commit();
//
//            // refreshed the id for
//            optStatusTransaction = optStatusTransactionDAO.refresh(optStatusTransaction);
//
//            // start the new transaction for opt transaction id
//            EntityManagerHelper.beginTransaction();
//
//            serviceResponse.primaryEmailAddress = member.getMemberName();
//            serviceResponse.token = member.getPassword();
//
//            Set<EmailAddressOptStatus> emailAddressOptStatuses = createEmailAddressOptStatus(optStatusTransaction, dto);
//            optStatusTransaction.setEmailAddressOptStatuses(emailAddressOptStatuses);
//
//            member.setOptStatusTransaction(optStatusTransaction);
//            memberDAO.update(member);
//            optStatusTransactionDAO.update(optStatusTransaction);
//
//            EntityManagerHelper.commit();
//
//            EntityManagerHelper.log("End OnePassServiceImpl.updateUserProfileInfo() ..", Level.INFO, null);
//        } catch (ServiceException ex) {
//            EntityManagerHelper.log("Error OnePassServiceImpl.updateUserProfileInfo() ..", Level.ALL, ex);
//            ex.printStackTrace();
//            EntityManagerHelper.rollback();
//            serviceResponse.responseText = ex.getMessage();
//            serviceResponse.status = TRANSACTION_FAILED;
//            return serviceResponse;
//
//        } catch (Exception ex) {
//            EntityManagerHelper.log("Error OnePassServiceImpl.updateUserProfileInfo() ..", Level.ALL, ex);
//            ex.printStackTrace();
//            EntityManagerHelper.rollback();
//            serviceResponse.responseText = ex.getMessage();
//            serviceResponse.status = TRANSACTION_FAILED;
//            return serviceResponse;
//
//        }
//
//        serviceResponse.responseText = TRANSACTION_SUCCESS_RESPONSE_TEXT;
//        serviceResponse.status = TRANSACTION_SUCCESS;
//
//        return serviceResponse;
//
//    }
//
//    /**
//     * Update the user profile information.
//     * 
//     * @param dto
//     *            the UpdateCDSOnePassUserProfileDTO
//     * @return the OnePassServiceResponse object
//     */
//    public final OnePassServiceResponse updateCDSUserProfileInfo(final UpdateOnePassUserProfileDTO dto) {
//
//        try {
//
//            EntityManagerHelper.log("Start OnePassServiceImpl.updateCDSUserProfileInfo() ..", Level.INFO, null);
//
//            EntityManagerHelper.beginTransaction();
//
//            Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
//
//            Member member = null;
//            Email email = null;
//            
//            String prodAbbr = StringUtils.getProdIdBySource(dto.accountFields.sourceId);
//            
//            String accountNumber = dto.emailFields.accountNumber;   
//            
//            MemberInfo memberInfo = null;
//            
//            boolean updateMemberInfo = false;
//
//            List<Email> emailList = emailDAO.findByEmailAddress(dto.header.emailAddress.trim());
//            
//            if (emailList != null && emailList.size() > 0) {
//                email = emailList.get(0);
//                member = email.getMember();
//            }
//
//            if (member == null) {
//                serviceResponse.responseText = StringUtils.getBundleProperty("emailAddress.notExist");
//                serviceResponse.status = TRANSACTION_FAILED;
//                EntityManagerHelper.rollback();
//                return serviceResponse;
//            }
//            
//       
//            OptStatusTransaction optStatusTransaction = new OptStatusTransaction();
//
//            if (dto.emailFields.newEmailAddress != null && !"".equals(dto.emailFields.newEmailAddress.trim())
//                    && !dto.header.emailAddress.trim().equalsIgnoreCase(dto.emailFields.newEmailAddress.trim())) {
//                
//                List<MemberInfo> memberInfoList = memberInfoDAO.findByProperties("accountNumber", "cdsProdId", accountNumber, prodAbbr);
//                
//                if(memberInfoList != null && memberInfoList.size() > 0) {
//                    memberInfo = memberInfoList.get(0);
//                }
//                
//                System.out.println("\n\n\n ******** memberInfo : " + memberInfo);
//                System.out.println("\n\n\n ******** memberInfoDAO.findByAccountNumber(accountNumber).size() : " + memberInfoDAO.findByAccountNumber(accountNumber).size());
//                
//                if(memberInfo != null && memberInfoDAO.findByAccountNumber(accountNumber).size() > 1) {
//                    System.out.println("\n\n\n **5555555555555555555555555555 ");
//                    if (emailDAO.findByEmailAddress(dto.emailFields.newEmailAddress.trim()).size() > 0) {
//                        Email existingEmail = emailDAO.findByEmailAddress(dto.emailFields.newEmailAddress.trim()).get(0);
//                        Member existingEmailMember = existingEmail.getMember();
//                        if (dto.emailFields.password != null) {
//                            existingEmailMember.setPassword(OneWayEncrypter.encryptString(dto.emailFields.password));
//                        } else {
//                            existingEmailMember.setPassword(member.getPassword());
//                        }
//                        memberDAO.update(existingEmailMember);
//                        existingEmail.setEmailTypeId(EMAIL_PRIMARY_ID);
//                        existingEmail.setEffectiveDate(timeStamp);
//                        emailDAO.update(existingEmail);
//                        optStatusTransaction.setEmail(existingEmail);
//                        member = existingEmailMember;
//                        
//                    } else {
//                        Email newEmail = new Email();
//                        Member newMember = new Member();
//                        if(memberDAO.findByMemberName(dto.emailFields.newEmailAddress.trim()).size() > 0) {
//                            newMember.setMemberName(UUID.randomUUID().getMostSignificantBits()+":"+dto.emailFields.newEmailAddress.trim());
//                        } else {
//                            newMember.setMemberName(dto.emailFields.newEmailAddress.trim());
//                        } 
//                        
//                        if (dto.emailFields.password != null) {
//                            newMember.setPassword(OneWayEncrypter.encryptString(dto.emailFields.password));
//                        } else {
//                            newMember.setPassword(member.getPassword());
//                        }
//                        memberDAO.save(newMember);
//                        newEmail.setMember(newMember);
//                        newEmail.setEmailAddress(dto.emailFields.newEmailAddress.trim());
//                        newEmail.setEmailTypeId(EMAIL_PRIMARY_ID);
//                        newEmail.setEffectiveDate(timeStamp);
//                        member = newMember;
//                        emailDAO.save(newEmail);
//                        optStatusTransaction.setEmail(newEmail);
//                    }
//                    
//                    updateMemberInfo = true;
//                    
//                } else {
//                    email.setEmailTypeId(EMAIL_SECONDARY_ID);
//                    email.setEffectiveDate(timeStamp);
//                    emailDAO.update(email);
//                    if (emailDAO.findByEmailAddress(dto.emailFields.newEmailAddress.trim()).size() > 0) {
//                        Email existingEmail = emailDAO.findByEmailAddress(dto.emailFields.newEmailAddress.trim()).get(0);
//                        existingEmail.setEmailTypeId(EMAIL_PRIMARY_ID);
//                        existingEmail.setEffectiveDate(timeStamp);
//                        emailDAO.update(existingEmail);
//                        optStatusTransaction.setEmail(existingEmail);
//                    } else {
//                        Email newEmail = new Email();
//                        newEmail.setMember(member);
//                        newEmail.setEmailAddress(dto.emailFields.newEmailAddress.trim());
//                        newEmail.setEmailTypeId(EMAIL_PRIMARY_ID);
//                        newEmail.setEffectiveDate(timeStamp);
//                        emailDAO.save(newEmail);
//                        optStatusTransaction.setEmail(newEmail);
//                    }
//                    if (dto.emailFields.password != null) {
//                        member.setPassword(OneWayEncrypter.encryptString(dto.emailFields.password));
//                        memberDAO.update(member);
//                    }
//                }
//
//            } else {
//                optStatusTransaction.setEmail(email);
//                if (dto.emailFields.password != null) {
//                    member.setPassword(OneWayEncrypter.encryptString(dto.emailFields.password));
//                    memberDAO.update(member);
//                }
//            }
//
//            optStatusTransaction.setCreateDate(timeStamp);
//            Source source = sourceDAO.findById(Integer.parseInt(dto.accountFields.sourceId));
//
//            if (source != null) {
//                optStatusTransaction.setSource(source);
//            } else {
//                EntityManagerHelper.rollback();
//                serviceResponse.responseText = StringUtils.getBundleProperty("sourceId.valid");
//                serviceResponse.status = TRANSACTION_FAILED;
//                return serviceResponse;
//            }
//
//            optStatusTransaction.setTrackingId(dto.accountFields.trackingId);
//
//            List<OptStatusTransaction> optStatusTransactionList = optStatusTransactionDAO.findByProperties("email", "source", email, source);
//
//            Set<EmailAddressOptHistory> emailAddressOptHistories = new HashSet<EmailAddressOptHistory>();
//            for (OptStatusTransaction opStatusTrns : optStatusTransactionList) {
//                Set<EmailAddressOptStatus> emailAddressOptStatuses = opStatusTrns.getEmailAddressOptStatuses();
//                for (EmailAddressOptStatus emailAddOptStatus : emailAddressOptStatuses) {
//                    emailAddressOptHistories.add(new EmailAddressOptHistory(emailAddOptStatus.getUserPreference(), emailAddOptStatus.getOptStatus(),
//                            emailAddOptStatus.getOptStatusTransaction()));
//                    if (emailAddressOptStatusDAO.findById(emailAddOptStatus.getId()) != null) {
//                        emailAddressOptStatusDAO.delete(emailAddOptStatus);
//                    }
//                }
//            }
//
//            optStatusTransaction.setEmailAddressOptHistories(emailAddressOptHistories);
//
//            optStatusTransactionDAO.save(optStatusTransaction);
//
//            EntityManagerHelper.commit();
//
//            // refreshed the id for
//            optStatusTransaction = optStatusTransactionDAO.refresh(optStatusTransaction);
//
//            // start the new transaction for opt transaction id
//            EntityManagerHelper.beginTransaction();
//
//            Set<EmailAddressOptStatus> emailAddressOptStatuses = createEmailAddressOptStatus(optStatusTransaction, dto);
//            optStatusTransaction.setEmailAddressOptStatuses(emailAddressOptStatuses);
//
//            member.setOptStatusTransaction(optStatusTransaction);
//            memberDAO.update(member);
//            optStatusTransactionDAO.update(optStatusTransaction);
//            
//            if(updateMemberInfo && memberInfo != null) {
//                memberInfo.setMember(member);
//                memberInfoDAO.update(memberInfo);
//            }
//
//            EntityManagerHelper.commit();
//
//            EntityManagerHelper.log("End OnePassServiceImpl.updateCDSUserProfileInfo() ..", Level.INFO, null);
//        } catch (ServiceException ex) {
//            EntityManagerHelper.log("Error OnePassServiceImpl.updateCDSUserProfileInfo() ..", Level.ALL, ex);
//            ex.printStackTrace();
//            EntityManagerHelper.rollback();
//            serviceResponse.responseText = ex.getMessage();
//            serviceResponse.status = TRANSACTION_FAILED;
//            return serviceResponse;
//
//        } catch (Exception ex) {
//            EntityManagerHelper.log("Error OnePassServiceImpl.updateCDSUserProfileInfo() ..", Level.ALL, ex);
//            ex.printStackTrace();
//            EntityManagerHelper.rollback();
//            serviceResponse.responseText = ex.getMessage();
//            serviceResponse.status = TRANSACTION_FAILED;
//            return serviceResponse;
//
//        }
//
//        serviceResponse.responseText = TRANSACTION_SUCCESS_RESPONSE_TEXT;
//        serviceResponse.status = TRANSACTION_SUCCESS;
//
//        return serviceResponse;
//
//    }
//
//    /**
//     * Verify the email address and login details.
//     * 
//     * @param dto
//     *            the OnePassUserLoginDTO
//     * @return the OnePassServiceResponse object
//     */
//    public final OnePassServiceResponse userLogin(final OnePassUserLoginDTO dto) {
//
//        EntityManagerHelper.log("Start OnePassServiceImpl.userLogin() ..", Level.INFO, null);
//
//        try {
//            try {
//                serviceValidator.validLoginService(dto);
//            } catch (ServiceException ex) {
//                serviceResponse.responseText = ex.getMessage();
//                serviceResponse.status = TRANSACTION_FAILED;
//                EntityManagerHelper.log("Error OnePassServiceImpl.userLogin() ..", Level.INFO, ex);
//                return serviceResponse;
//            }
//
//            List<Email> emailList = emailDAO.findByEmailAddress(dto.emailAddress.trim());
//            String encPassword = OneWayEncrypter.encryptString(dto.password);
//            Member member = null;
//
//            if (emailList != null && emailList.size() > 0) {
//                Email email = emailList.get(0);
//                if (email.getEmailTypeId().intValue() == EMAIL_PRIMARY_ID) {
//                    member = email.getMember();
//                    if (member == null || !encPassword.equals(member.getPassword())) {
//                        serviceResponse.responseText = StringUtils.getBundleProperty("password.inValid");
//                        serviceResponse.status = TRANSACTION_FAILED;
//                        return serviceResponse;
//                    }
//                }
//            }
//
//            serviceResponse.token = member.getPassword();
//
//        } catch (NoSuchAlgorithmException e) {
//            serviceResponse.responseText = e.getMessage();
//            serviceResponse.status = TRANSACTION_FAILED;
//            EntityManagerHelper.log("Error OnePassServiceImpl.userLogin() ..", Level.INFO, e);
//            return serviceResponse;
//        }
//
//        EntityManagerHelper.log("End OnePassServiceImpl.userLogin() ..", Level.INFO, null);
//
//        serviceResponse.responseText = TRANSACTION_SUCCESS_RESPONSE_TEXT;
//        serviceResponse.status = TRANSACTION_SUCCESS;
//
//        return serviceResponse;
//    }
//
//    /**
//     * Verify the email address and login details.
//     * 
//     * @param dto
//     *            the OnePassUserLoginDTO
//     * @return the OnePassServiceResponse object
//     */
//    public final OnePassServiceResponse minimalRegistration(final CreateOnePassUserProfileDTO dto) {
//
//        EntityManagerHelper.log("Start OnePassServiceImpl.minimalRegistration() ..", Level.INFO, null);
//
//        try {
//            try {
//                serviceValidator.validMinimalRegistrationService(dto);
//            } catch (ServiceException ex) {
//                serviceResponse.responseText = ex.getMessage();
//                serviceResponse.status = TRANSACTION_FAILED;
//                EntityManagerHelper.log("Error OnePassServiceImpl.userLogin() ..", Level.INFO, ex);
//                return serviceResponse;
//            }
//
//            EntityManagerHelper.beginTransaction();
//
//            Timestamp timeStamp = new Timestamp(System.currentTimeMillis());
//
//            Member member = new Member();
//            
//            if(memberDAO.findByMemberName(dto.emailFields.emailAddress.trim()).size() > 0) {
//                member.setMemberName(UUID.randomUUID().getMostSignificantBits()+":"+dto.emailFields.emailAddress.trim());
//            } else {
//                member.setMemberName(dto.emailFields.emailAddress.trim());
//            }   
//            member.setPassword(OneWayEncrypter.encryptString(dto.emailFields.password));
//            memberDAO.save(member);
//
//            List<Email> emailList = emailDAO.findByEmailAddress(dto.emailFields.emailAddress.trim());
//            
//            Email email = null;
//            
//            if(emailList != null && emailList.size() > 0) {
//                email = emailDAO.findByEmailAddress(dto.emailFields.emailAddress.trim()).get(0);
//            }
//            
//            if(email != null) {
//                if(email.getMember() == null) {
//                    email.setMember(member);
//                    email.setEmailTypeId(EMAIL_PRIMARY_ID);
//                    email.setEffectiveDate(timeStamp);
//                    email.setNonMemberProfile(null);
//                } else {
//                    EntityManagerHelper.rollback();
//                    throw new ServiceException(StringUtils.getBundleProperty("emailAddress.exist"));
//                }
//            } else {
//                email = new Email();
//                email.setMember(member);
//                email.setEmailAddress(dto.emailFields.emailAddress.trim());
//                email.setEmailTypeId(EMAIL_PRIMARY_ID);
//                email.setEffectiveDate(timeStamp);
//            }
//            
//            emailDAO.save(email);
//            
//            OptStatusTransaction optStatusTransaction = new OptStatusTransaction();
//            optStatusTransaction.setEmail(email);
//            optStatusTransaction.setCreateDate(timeStamp);
//
//            Source source = sourceDAO.findById(Integer.parseInt(dto.accountFields.sourceId));
//
//            if (source != null) {
//                optStatusTransaction.setSource(source);
//            } else {
//                EntityManagerHelper.rollback();
//                serviceResponse.responseText = StringUtils.getBundleProperty("sourceId.valid");
//                serviceResponse.status = TRANSACTION_FAILED;
//                return serviceResponse;
//            }
//
//            optStatusTransaction.setTrackingId(dto.accountFields.trackingId);
//
//            optStatusTransactionDAO.save(optStatusTransaction);
//            EntityManagerHelper.commit();
//            
//            EntityManagerHelper.beginTransaction();
//            MemberBundle memberBundle = new MemberBundle();
//            MemberStatus memberStatus = memberStatusDAO.findById(1);
//            String bundleId=getBundleStringValue("bundleId");
//            Bundle bundle = bundleDAO.findById(Integer.parseInt(bundleId));
//            MemberBundleId memberBundleId = new MemberBundleId(member.getMemberId(), bundle.getBundleId());
//            memberBundle.setMember(member);
//            memberBundle.setMemberStatus(memberStatus);
//            memberBundle.setId(memberBundleId);
//            memberBundle.setAutoRenew("Y");
//            memberBundle.setCreateDate(timeStamp);
//            memberBundleDAO.save(memberBundle);
//            
//            EntityManagerHelper.commit();
//            
//            // Email Address verification for RD employees for free fulfillment
//            String rdEmailPattern = getBundleStringValue("rdEmailRegEx");
//            if(dto.emailFields.emailAddress.trim().toLowerCase().matches(rdEmailPattern)) {
//                emailValidToken(dto.emailFields.emailAddress.trim().toLowerCase(), "RDO");
//            }
//            
//      
//            EntityManagerHelper.log("End OnePassServiceImpl.createUserProfileInfo() ..", Level.INFO, null);
//        } catch (ServiceException ex) {
//            EntityManagerHelper.log("Error OnePassServiceImpl.createUserProfileInfo() ..", Level.ALL, ex);
//            ex.printStackTrace();
//            EntityManagerHelper.rollback();
//            serviceResponse.responseText = ex.getMessage();
//            serviceResponse.status = TRANSACTION_FAILED;
//            return serviceResponse;
//
//        } catch (Exception ex) {
//            EntityManagerHelper.log("Error OnePassServiceImpl.createUserProfileInfo() ..", Level.ALL, ex);
//            ex.printStackTrace();
//            EntityManagerHelper.rollback();
//            serviceResponse.responseText = ex.getMessage();
//            serviceResponse.status = TRANSACTION_FAILED;
//            return serviceResponse;
//
//        }
//
//        serviceResponse.responseText = TRANSACTION_SUCCESS_RESPONSE_TEXT;
//        serviceResponse.status = TRANSACTION_SUCCESS;
//        return serviceResponse;
//    }
//
//    /*
//     * (non-Javadoc)
//     * 
//     * @see com.readersdigest.onepass.service.OnePassService#isCompleteRegistration(java.lang.String)
//     */
//    public String isCompleteRegistration(String userName) {
//
//        try {
//            if (userName == null || "".equalsIgnoreCase(userName.trim())) {
//                return "false";
//            }
//            
//            List<MemberInfo> memberInfoList;
//            try {
//             
//               long accountNumber = Long.parseLong(userName.trim());
//               String strAccountNumber = String.valueOf(accountNumber);
//               int accountLength = strAccountNumber.length();
//               for(int i=accountLength; i < 10; i++) {
//                   strAccountNumber = "0" + strAccountNumber;
//               }
//               memberInfoList = memberInfoDAO.findByAccountNumber(strAccountNumber);
//               
//               if (memberInfoList != null && memberInfoList.size() > 0) {
//                   for (MemberInfo memberInfo : memberInfoList) {
//                       memberInfo = memberInfoDAO.refresh(memberInfo);
//                       if (memberInfo.getAccountNumber() != null && !"".equals(memberInfo.getAccountNumber()) && "CDS".equals(memberInfo.getDiscussionAlias())) {
//                           return "CDS";
//                       }
//                   }
//               }
//               
//           } catch(Exception ex) {
//               EntityManagerHelper.log("ERROR Check for Email Address ..", Level.INFO, null);
//           }
//             
//            List<Email> emailList = emailDAO.findByEmailAddress(userName.trim());
//            Member member = null;
//
//            if (emailList != null && emailList.size() > 0) {
//               Email strEmail = emailDAO.refresh(emailList.get(0));
//               if (strEmail.getEmailTypeId().intValue() != OnePassServiceImpl.EMAIL_PRIMARY_ID) {
//                    emailList = emailDAO.findByMemberId(strEmail.getMember().getMemberId());
//                    for(Email tEmail : emailList) {
//                        tEmail = emailDAO.refresh(tEmail);
//                        if (tEmail.getEmailTypeId().intValue() == OnePassServiceImpl.EMAIL_PRIMARY_ID) {
//                            member = tEmail.getMember();
//                            break;
//                        }
//                    }
//                } else {
//                    member = strEmail.getMember();
//                }
//                
//            }
//            
//           
//
//            if (member == null) {
//                return "false";
//            }
//
//            memberInfoList = memberInfoDAO.findByMemberId(member.getMemberId());
//
//            if (memberInfoList != null && memberInfoList.size() > 0) {
//                for (MemberInfo memberInfo : memberInfoList) {
//                    memberInfo = memberInfoDAO.refresh(memberInfo);
//                    if (memberInfo.getAccountNumber() != null && !"".equals(memberInfo.getAccountNumber()) && "CDS".equals(memberInfo.getDiscussionAlias())) {
//                        return "CDS";
//                    }
//                }
//            }
//
//            List<PostalAddress> postalAddressList = addressDAO.findByProperty("member", member);
//
//            if (postalAddressList != null && postalAddressList.size() > 0) {
//                return "true";
//            } else {
//                return "false";
//            }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//           return "false";
//        }
//
//    }
//    
//    
//        
//    public String encryptUserName(String userName) {
//        
//        DESEncrypter desEncrypt = new DESEncrypter(getBundleStringValue("passPhase"));
//        
//        try {
//            Member member = null;
//            List<Email> emailList = null;
//            List<MemberInfo> memberInfoList = null;
//            
//            //EntityManagerHelper.beginTransaction();
//            
//            try {
//
//                long accountNumber = Long.parseLong(userName);
//                String strAccountNumber = String.valueOf(accountNumber);
//                int accountLength = strAccountNumber.length();
//                for (int i = accountLength; i < 10; i++) {
//                    strAccountNumber = "0" + strAccountNumber;
//                }
//                
//                EntityManagerHelper.log("Start encryptUserName.accountNumber : " + strAccountNumber , Level.INFO, null);
//
//                memberInfoList = memberInfoDAO.findByAccountNumber(strAccountNumber);
//                if (memberInfoList != null && memberInfoList.size() > 0) {
//                     for (MemberInfo memberInfo : memberInfoList) {
//                        memberInfo = memberInfoDAO.refresh(memberInfo);
//                        if ("CDS".equals(memberInfo.getDiscussionAlias()) && memberInfo.getAccountNumber() != null) {
//                            return desEncrypt.encrypt(strAccountNumber);
////                            emailList = emailDAO.findByMemberId(memberInfo.getMember().getMemberId());
////                            if (emailList != null && emailList.size() > 0) {
////                                for(Email email : emailList) {
////                                    System.out.println("\n\n\n ****111 email Address " + email.getEmailAddress());
////                                    email = emailDAO.refresh(email);
////                                    if (email.getEmailTypeId().intValue() == OnePassServiceImpl.EMAIL_PRIMARY_ID) {
////                                        //EntityManagerHelper.commit();
////                                        return desEncrypt.encrypt(email.getEmailAddress());
////                                    }
////                                }
////                            }
//                           
//                        }
//                    }
//                }
//
//            } catch (Exception ex) {
//                
//                EntityManagerHelper.log("Start encryptUserName. accountparsing Error emailAddress : " , Level.INFO, null);
//                emailList = emailDAO.findByEmailAddress(userName);
//                 
//                if (emailList != null && emailList.size() > 0) {
//                    Email strEmail = emailDAO.refresh(emailList.get(0));
//                     if (strEmail.getEmailTypeId().intValue() != OnePassServiceImpl.EMAIL_PRIMARY_ID) {
//                        member = strEmail.getMember();
//                        emailList = emailDAO.findByMemberId(member.getMemberId());
//                        if (emailList != null && emailList.size() > 0) {
//                            for(Email email : emailList) {
//                                System.out.println("\n\n\n ****22222222 email Address " + email.getEmailAddress());
//                                email = emailDAO.refresh(email);
//                                if (email.getEmailTypeId().intValue() == OnePassServiceImpl.EMAIL_PRIMARY_ID) {
//                                    System.out.println("\n\n\n ****Encrypted email Address " + email.getEmailAddress());
//                                    //EntityManagerHelper.commit();
//                                    return desEncrypt.encrypt(email.getEmailAddress());
//                                }
//                            }
//                        }
//                     } else {
//                        //EntityManagerHelper.commit();
//                        System.out.println("\n\n\n ****Primary Email address Address : " + userName);
//                        
//                        return desEncrypt.encrypt(userName);
//                    }
//                        
//                }
//            }
//            System.out.println("\n\n\n ****exit without going any condition email Address :  " + userName );
//           // EntityManagerHelper.commit();
//            return desEncrypt.encrypt(userName);
//            
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//             e.printStackTrace();
//             //EntityManagerHelper.rollback();
//             return userName;
//         }
//    }
//
//    /*
//     * (non-Javadoc)
//     * 
//     * @see com.readersdigest.onepass.service.OnePassService#resetForgetPasswordToken(java.lang.String)
//     */
//    public OnePassServiceResponse resetForgetPasswordToken(String emailAddress) {
//        return null;
//    }
//
//    /*
//     * (non-Javadoc)
//     * 
//     * @see com.readersdigest.onepass.service.OnePassService#updateNewPassword(java.lang.String, java.lang.String)
//     */
//    public OnePassServiceResponse updateNewPassword(String token, String password) {
//        return null;
//    }
//
//    /*
//     * (non-Javadoc) 
//     * 
//     * @see com.readersdigest.onepass.service.OnePassService#renewAuthToken(java.lang.String, java.lang.String, java.lang.String)
//     */
//    public OnePassServiceAdobeResponse renewAuthToken(String authToken, String appId, String appVersion) {
//        return null;
//    }
//
//    /*
//     * (non-Javadoc)
//     * 
//     * @see com.readersdigest.onepass.service.OnePassService#signInWithCredentials(java.lang.String, java.lang.String, java.lang.String, java.lang.String,
//     * java.lang.String)
//     */
//    public OnePassServiceAdobeResponse signInWithCredentials(String emailAddress, String password, String appId, String appVersion, String uuid) {
//        return null;
//    }
//
//    /*
//     * (non-Javadoc)
//     * 
//     * @see com.readersdigest.onepass.service.OnePassService#entitlements(java.lang.String, java.lang.String, java.lang.String)
//     */
//    public OnePassServiceAdobeResponse entitlements(String authToken, String appId, String appVersion) {
//        return null;
//    }
//
//    /* (non-Javadoc)
//     * @see com.readersdigest.onepass.service.OnePassService#verifyEntitlement(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
//     */
//    public OnePassServiceAdobeEntitledVerifyResponse verifyEntitlement(String authToken, String productId, String appId, String appVersion) {
//        return null;
//    }
//    
//    /* (non-Javadoc)
//     * @see com.readersdigest.onepass.service.OnePassService#updateCDSUserPassword(java.lang.String, java.lang.String)
//     */
//    public OnePassServiceAdobeResponse updateCDSUserPassword(String emailAddress, String password)  {
//        return null;
//    }
//    
//    public OnePassServiceAdobeResponse getUserInfo(String userName, String appId) {
//        return null;
//    }
//    
//    public boolean updateEmailValidity(String token) {
//        return false;
//    }
//    
//    public OnePassServiceResponse updateValidEmailAddress(String accountNumber,String oldEmailAddress, String newEmailAddress, String password, String sourceId, String appId){
//        return null;
//    }
//    
//    
//    /*
//     * (non-Javadoc)
//     * 
//     * @see com.readersdigest.onepass.service.impl.OnePassServiceImpl#resetForgetPasswordToken(java.lang.String)
//     */
//    public boolean emailValidToken(String emailAddress, String prodId) {
//
//        EntityManagerHelper.log("Start OnePassServiceImpl.emailValidToken() ..", Level.INFO, null);
//        String token = null;
//        boolean flag = false;
//        try {
//            
//            List<Email> emailList = emailDAO.findByEmailAddress(emailAddress.trim());
//           
//            if(emailList != null && emailList.size() > 0 ) {
//                    Email email = emailList.get(0);
//                    List<EmailValid> emailValidList = emailValidDAO.findByProperty("email.emailId", email.getEmailId());
//                    if(emailValidList != null && emailValidList.size() > 0 ) {
//                        EmailValid emailValid = emailValidList.get(0);
//                        token = emailValid.getToken();
//                    } else {
//                        try {
//                            EntityManagerHelper.beginTransaction();
//                            EmailValid emailValid = new EmailValid();
//                            emailValid.setEmail(email);
//                            emailValid.setCreateDate(new Timestamp(System.currentTimeMillis()));
//                            emailValid.setValid(INVALID_STRING);
//                            token = UUID.randomUUID().toString();
//                            emailValid.setToken(token);
//                            emailValidDAO.save(emailValid);
//                            EntityManagerHelper.commit();
//                        } catch (Exception e) {
//                            // TODO Auto-generated catch block
//                            e.printStackTrace();
//                            EntityManagerHelper.rollback();
//                            return flag;
//                        }
//                        
//                    }
//                    
//                } else {
//                    return flag;
//                }
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//            return flag;
//        }
//        
//        String rdEmailPattern = getBundleStringValue("rdEmailRegEx");
//        String URL = "";
//        String templateName = "";
//        String emailContent = "";
//        
//        if(emailAddress.matches(rdEmailPattern)) {
//            URL =getBundleStringValue("rdEmailValidationActionURL") + token;
//            templateName = getBundleStringValue("rdEmailValidationMailingTemplate");
//            emailContent = getBundleStringValue("rdEmailValidationMailingTemplateContent");
//            emailContent = emailContent.replaceAll("##url##", URL);
//        } else {
//            URL =getBundleStringValue("emailValidationActionURL") + token;
//            templateName = getBundleStringValue("emailValidationMailingTemplate");
//            emailContent = getBundleStringValue("emailValidationMailingTemplateContent_"+prodId);
//            emailContent = emailContent.replaceAll("##url##", URL);
//        }
//       
//
//        try {
//            EmailClient emailClient = new StrongMailClient();
//            String strtxRecord = emailContent + "::" + emailAddress;
//            System.out.println("\n\n\n ********** strtxRecord : " + strtxRecord);
//            emailClient.send(strtxRecord, templateName);
//            flag = true;
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return flag;
//            
//    }
//    
//    
//
//    /**
//     * Gets the bundle string value.
//     * 
//     * @param key
//     *            the key
//     * @return the bundle string value
//     */
//    public static String getBundleStringValue(String key) {
//        return StringUtils.getBundleProperty("com.readersdigest.onepass.OnePassResources", key);
//    }
}
