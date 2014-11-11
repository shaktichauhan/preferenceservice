package com.readersdigest.onepass.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;

import javax.persistence.FlushModeType;

import com.cds.global.api.Customer;
import com.cds.global.api.WSG;
import com.cds.global.api.WSGResponse;
import com.readersdigest.emailClient.EmailClient;
import com.readersdigest.emailClient.StrongMailClient;
import com.readersdigest.exacttarget.client.ETExtensionServices;
import com.readersdigest.exacttarget.client.impl.ETExtensionServicesImpl;
import com.readersdigest.exacttarget.dto.DigitalProfile;
import com.readersdigest.exacttarget.dto.DigitalProfileWithSubscription;
import com.readersdigest.exacttarget.dto.ETResponse;
import com.readersdigest.exacttarget.dto.Preferences;
import com.readersdigest.exacttarget.dto.SubscriptionPreferences;
import com.readersdigest.onepass.db.AddressType;
import com.readersdigest.onepass.db.AddressTypeDAO;
import com.readersdigest.onepass.db.BundleDAO;
import com.readersdigest.onepass.db.Email;
import com.readersdigest.onepass.db.EmailAddressOptHistory;
import com.readersdigest.onepass.db.EmailAddressOptStatus;
import com.readersdigest.onepass.db.EmailAddressOptStatusDAO;
import com.readersdigest.onepass.db.EmailAddressOptStatusId;
import com.readersdigest.onepass.db.EmailDAO;
import com.readersdigest.onepass.db.EmailValidation;
import com.readersdigest.onepass.db.EmailValidationDAO;
import com.readersdigest.onepass.db.EntityManagerHelper;
import com.readersdigest.onepass.db.IAddressTypeDAO;
import com.readersdigest.onepass.db.IBundleDAO;
import com.readersdigest.onepass.db.IEmailAddressOptStatusDAO;
import com.readersdigest.onepass.db.IEmailDAO;
import com.readersdigest.onepass.db.IEmailValidationDAO;
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
import com.readersdigest.onepass.db.MemberBundleDAO;
import com.readersdigest.onepass.db.MemberDAO;
import com.readersdigest.onepass.db.MemberInfoDAO;
import com.readersdigest.onepass.db.MemberOnePassInfo;
import com.readersdigest.onepass.db.MemberOnePassInfoDAO;
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
import com.readersdigest.onepass.dto.PreferenceDTO;
import com.readersdigest.onepass.dto.UpdateOnePassUserProfileDTO;
import com.readersdigest.onepass.exception.ServiceException;
import com.readersdigest.onepass.service.OnePassService;
import com.readersdigest.onepass.util.OneWayEncrypter;
import com.readersdigest.onepass.util.StringUtils;

/**
 * The Class OnePassServiceImpl.
 * 
 * 
 * @author shsingh
 * 
 */
public class OnePassServiceImpl implements OnePassService {

    /** The Constant OPT_UNDEFINED. */
    public static final int OPT_UNDEFINED = 1;

    /** The Constant OPT_PREFERS. */
    public static final int OPT_PREFERS = 2;

    /** The Constant OPT_PREFERS_NOT. */
    public static final int OPT_PREFERS_NOT = 3;

    /** The Constant OPT_NEVER. */
    public static final int OPT_NEVER = 4;

    /** The Constant ADDRESS_TYPE_ID. */
    public static final int ADDRESS_TYPE_ID = 1;

    /** The Constant EMAIL_PRIMARY_ID. */
    public static final int EMAIL_PRIMARY_ID = 1;

    /** The Constant EMAIL_SECONDARY_ID. */
    public static final int EMAIL_SECONDARY_ID = 2;

    /** The member dao. */
    private IMemberDAO memberDAO;

    /** The address dao. */
    private IPostalAddressDAO addressDAO;

    /** The address type dao. */
    private IAddressTypeDAO addressTypeDAO;

    /** The memberInfo dao. */
    private IMemberInfoDAO memberInfoDAO;

    /** The email dao. */
    private IEmailDAO emailDAO;

    /** The opt status transaction dao. */
    private IOptStatusTransactionDAO optStatusTransactionDAO;

    /** The source dao. */
    private ISourceDAO sourceDAO;

    /** The user preference dao. */
    private IUserPreferenceDAO userPreferenceDAO;

    /** The email address opt status dao. */
    private IEmailAddressOptStatusDAO emailAddressOptStatusDAO;

    private IMemberStatusDAO memberStatusDAO;

    private IBundleDAO bundleDAO;

    private IMemberBundleDAO memberBundleDAO;

    private IEmailValidationDAO emailValidationDAO;

    private IMemberOnePassInfoDAO memberOnePassInfoDAO;

    /** The service validator. */
    private ServiceValidator serviceValidator;

    /** The service response. */
    private OnePassServiceResponse serviceResponse;

    /** The Constant TRANSACTION_SUCCESS. */
    public static final String TRANSACTION_SUCCESS = getBundleStringValue("transactionSuccess");

    /** The Constant TRANSACTION_FAILED. */
    public static final String TRANSACTION_FAILED = getBundleStringValue("transactionFailed");;

    /** The Constant TRANSACTION_SUCCESS_RESPONSE_TEXT. */
    public static final String TRANSACTION_SUCCESS_RESPONSE_TEXT = getBundleStringValue("transactionSuccessMessage");

    public static final String VALID_STRING = "Y";
    public static final String INVALID_STRING = "N";

    public static final String ACTIVE_MEMBER = "A";
    public static final String INACTIVE_MEMBER = "I";

    /**
     * Instantiates a new one pass service impl.
     */
    public OnePassServiceImpl() {
        memberDAO = new MemberDAO();
        memberInfoDAO = new MemberInfoDAO();
        addressDAO = new PostalAddressDAO();
        addressTypeDAO = new AddressTypeDAO();
        emailDAO = new EmailDAO();
        sourceDAO = new SourceDAO();
        optStatusTransactionDAO = new OptStatusTransactionDAO();
        userPreferenceDAO = new UserPreferenceDAO();
        serviceValidator = new ServiceValidator();
        emailAddressOptStatusDAO = new EmailAddressOptStatusDAO();
        serviceResponse = new OnePassServiceResponse();
        memberStatusDAO = new MemberStatusDAO();
        bundleDAO = new BundleDAO();
        memberBundleDAO = new MemberBundleDAO();
        emailValidationDAO = new EmailValidationDAO();
        memberOnePassInfoDAO = new MemberOnePassInfoDAO();
    }

    /**
     * Create the user profile information.
     * 
     * @param dto
     *            the CreateOnePassUserProfileDTO
     * @return the OnePassServiceResponse object
     */
    public OnePassServiceResponse createUserProfileInfo(final CreateOnePassUserProfileDTO dto) {

        try {

            EntityManagerHelper.log("Start OnePassServiceImpl.createUserProfileInfo() ..", Level.INFO, null);
            
            EntityManagerHelper.beginTransaction();
            
            EntityManagerHelper.getEntityManager().setFlushMode(FlushModeType.COMMIT);

            try {
                serviceValidator.validService(dto);
            } catch (ServiceException ex) {
                serviceResponse.responseText = ex.getMessage();
                serviceResponse.status = TRANSACTION_FAILED;
                EntityManagerHelper.rollback();
                return serviceResponse;
            }
            
            Timestamp timeStamp = new Timestamp(System.currentTimeMillis());

            Email email = null;
            Member member = null;
            String accountNumber = dto.emailFields.accountNumber;

            String prodAbbr = StringUtils.getProdIdBySource(dto.accountFields.sourceId);

            List<Email> emailList = emailDAO.findByEmailAddress(dto.emailFields.emailAddress.trim());

            if (emailList != null && emailList.size() > 0) {
                email = emailDAO.findByEmailAddress(dto.emailFields.emailAddress.trim()).get(0);
            }

            if (email != null) {
                if (email.getMember() == null) {
                    member = new Member();
                    if (memberDAO.findByMemberName(dto.emailFields.emailAddress.trim()).size() > 0) {
                        member.setMemberName(UUID.randomUUID().getMostSignificantBits() + ":" + dto.emailFields.emailAddress.trim());
                    } else {
                        member.setMemberName(dto.emailFields.emailAddress.trim());
                    }
                    // member.setPassword(OneWayEncrypter.encryptString(dto.emailFields.password));
                    memberDAO.save(member);
                    email.setMember(member);
                    email.setEmailTypeId(EMAIL_PRIMARY_ID);
                    email.setEffectiveDate(timeStamp);
                    email.setNonMemberProfile(null);
                } else {
                    member = email.getMember();
                }
                emailDAO.update(email);
            } else {
                email = new Email();
                member = new Member();
                if (memberDAO.findByMemberName(dto.emailFields.emailAddress.trim()).size() > 0) {
                    member.setMemberName(UUID.randomUUID().getMostSignificantBits() + ":" + dto.emailFields.emailAddress.trim());
                } else {
                    member.setMemberName(dto.emailFields.emailAddress.trim());
                }
                // member.setPassword(OneWayEncrypter.encryptString(dto.emailFields.password));
                memberDAO.save(member);
                email.setMember(member);
                email.setEmailAddress(dto.emailFields.emailAddress.trim());
                email.setEmailTypeId(EMAIL_PRIMARY_ID);
                email.setEffectiveDate(timeStamp);
                emailDAO.save(email);
            }

            MemberOnePassInfo memberOnePassInfo = new MemberOnePassInfo();

            if (accountNumber != null && !"".equalsIgnoreCase(accountNumber.trim())) {

                accountNumber = accountNumber.trim();
                for (int i = accountNumber.length(); i < 10; i++) {
                    accountNumber = "0" + accountNumber;
                }

            }

            List<MemberOnePassInfo> memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active",
                    dto.emailFields.emailAddress.trim(), prodAbbr, ACTIVE_MEMBER);

            System.out.println("\n\n\n ****** memberOnePassInfoList " + memberOnePassInfoList);

            String lastName = dto.addressFields.lastName == null ? "" : dto.addressFields.lastName;
            String fullName = dto.addressFields.firstName + " " + lastName;

            if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {

                if (memberOnePassInfoList.size() > 1 || 
                        (memberOnePassInfoList.get(0).getAccountNumber() != null && 
                        !"".equals(memberOnePassInfoList.get(0).getAccountNumber()))) {
                    EntityManagerHelper.rollback();
                    throw new ServiceException(StringUtils.getBundleProperty("customerService.accountConfiguration.error"));
                }

                MemberOnePassInfo excMemberOnePassInfo = memberOnePassInfoList.get(0);

                if (accountNumber != null && !"".equalsIgnoreCase(accountNumber.trim())) {
                    excMemberOnePassInfo.setActive(INACTIVE_MEMBER);
                    memberOnePassInfoDAO.update(excMemberOnePassInfo);
                    memberOnePassInfo.setMemberOnePassRefId(excMemberOnePassInfo.getMemberOnePassInfoId());
                } else {
                    EntityManagerHelper.rollback();
                    throw new ServiceException(StringUtils.getBundleProperty("emailAddress.exist"));
                }

            }

            memberOnePassInfo.setMember(member);
            memberOnePassInfo.setPassword(OneWayEncrypter.encryptString(dto.emailFields.password));
            memberOnePassInfo.setEmailAddress(dto.emailFields.emailAddress.trim());
            memberOnePassInfo.setProdId(prodAbbr);
            memberOnePassInfo.setActive(ACTIVE_MEMBER);

            if (accountNumber != null && !"".equalsIgnoreCase(accountNumber.trim())) {
                memberOnePassInfo.setUserType("CDS");
                memberOnePassInfo.setAccountNumber(accountNumber);

                WSGResponse wsgr = null;
                WSG wsg = null;
                Customer customer = null;

                if (StringUtils.isIpadDevice(dto.accountFields.sourceId)) {
                    wsg = new WSG(StringUtils.getBundleProperty("com.readersdigest.onepass.OnePassResources", "cdsIpadAppId"), StringUtils.getBundleProperty(
                            "com.readersdigest.onepass.OnePassResources", "cdsIpadPassword"), prodAbbr);
                } else {
                    wsg = new WSG(StringUtils.getBundleProperty("com.readersdigest.onepass.OnePassResources", "cdsKindleAppId"), StringUtils.getBundleProperty(
                            "com.readersdigest.onepass.OnePassResources", "cdsKindlePassword"), prodAbbr);
                }

                wsgr = wsg.lookupCustomer(accountNumber);

                if (wsgr.isSuccess()) {

                    customer = (Customer) wsgr.getObjects().get(0);

                    if (customer.getEmail() == null || "".equals(customer.getEmail().trim())) {
                        serviceResponse.responseText = StringUtils.getBundleProperty("accountNumber.emailNotActivated");
                        serviceResponse.status = TRANSACTION_FAILED;
                        return serviceResponse;
                    } else if (!dto.emailFields.emailAddress.trim().equalsIgnoreCase(customer.getEmail().trim())) {
                        EntityManagerHelper.rollback();
                        serviceResponse.responseText = StringUtils.getBundleProperty("accountNumber.emailNotMatched");
                        serviceResponse.status = TRANSACTION_FAILED;
                        return serviceResponse;
                    }
                } else {
                    EntityManagerHelper.rollback();
                    serviceResponse.responseText = StringUtils.getBundleProperty("accountNumber.notValid");
                    serviceResponse.status = TRANSACTION_FAILED;
                    return serviceResponse;
                }

                if (customer != null) {
                    memberOnePassInfo.setZipCode(customer.getZipCode());
                    customer.setName(fullName.trim());
                    wsgr = wsg.updateCustomer(customer);
                    if (wsgr.isSuccess() && !wsgr.isSentToOffline()) {
                        memberOnePassInfo.setFullName(fullName.trim());
                    } else {
                        memberOnePassInfo.setFullName(customer.getName());
                    }
                }
            } else {
                memberOnePassInfo.setFullName(fullName.trim());
            }
            memberOnePassInfo.setCreateDate(timeStamp);
            memberOnePassInfoDAO.save(memberOnePassInfo);

            PostalAddress address = new PostalAddress();
            address.setMember(member);
            address.setFirstName(dto.addressFields.firstName);
            address.setLastName(dto.addressFields.lastName);
            address.setAddress1(dto.addressFields.address1);
            address.setAddress2(dto.addressFields.address2);
            address.setCity(dto.addressFields.city);
            address.setCountry(dto.addressFields.countryCode);

            // Only insert the state for Country USA and Canada
            if ("US".equalsIgnoreCase(dto.addressFields.countryCode) || "CA".equalsIgnoreCase(dto.addressFields.countryCode)) {
                address.setSubdivision(dto.addressFields.stateCode);
            }

            address.setZip(dto.addressFields.zip);
            address.setEffectiveDate(timeStamp);
            address.setCreateDate(timeStamp);

            AddressType addressType = addressTypeDAO.findById(ADDRESS_TYPE_ID);
            address.setAddressType(addressType);
            if (StringUtils.isPmDBPublication(prodAbbr)) {
                // Add the member and Opt In info in P&M database
                PMDBServiceManager pmDBManager = new PMDBServiceManager();
                pmDBManager.AddMember(prodAbbr, dto.emailFields.emailAddress.trim(), address);
                pmDBManager.AddOptIn(prodAbbr, dto.emailFields.emailAddress.trim(), dto.accountFields.preferenceFields);

            } else {
                addressDAO.save(address);
                OptStatusTransaction optStatusTransaction = new OptStatusTransaction();
                optStatusTransaction.setEmail(email);
                optStatusTransaction.setCreateDate(timeStamp);

                Source source = sourceDAO.findById(Integer.parseInt(dto.accountFields.sourceId));

                if (source != null) {
                    optStatusTransaction.setSource(source);
                } else {
                    EntityManagerHelper.rollback();
                    serviceResponse.responseText = StringUtils.getBundleProperty("sourceId.valid");
                    serviceResponse.status = TRANSACTION_FAILED;
                    return serviceResponse;
                }

                optStatusTransaction.setTrackingId(dto.accountFields.trackingId);

                optStatusTransactionDAO.save(optStatusTransaction);
                
                EntityManagerHelper.flush();
//              //  EntityManagerHelper.commit();
//
//                //EntityManagerHelper.beginTransaction();
//                
//                EntityManagerHelper.getEntityManager().setFlushMode(FlushModeType.COMMIT);
//                // refreshed the optStatusTransaction for getting the id
//                //optStatusTransaction = optStatusTransactionDAO.refresh(optStatusTransaction);

                Set<EmailAddressOptStatus> emailAddressOptStatuses = createEmailAddressOptStatus(optStatusTransaction, dto);

                optStatusTransaction.setEmailAddressOptStatuses(emailAddressOptStatuses);

                member.setOptStatusTransaction(optStatusTransaction);
                optStatusTransactionDAO.update(optStatusTransaction);

            }
            
            if(StringUtils.isPreAndETUpdate()) {
            	DigitalProfile profile = new DigitalProfile();
        		profile.setAddress1(dto.addressFields.address1);
        		profile.setAddress2(dto.addressFields.address2);
        		profile.setCity(dto.addressFields.city);
        		profile.setCountryCode(dto.addressFields.countryCode);
        		profile.setFirstName(dto.addressFields.firstName);
        		profile.setLastName(dto.addressFields.lastName);
        		profile.setLastUpdateDate(String.valueOf(System.currentTimeMillis()));//please use time miles in long and pass as a String
        		profile.setPostalCode(dto.addressFields.zip);
        		profile.setStateProvinceCode(dto.addressFields.stateCode);
        		profile.setEmailAddress(dto.emailFields.emailAddress.trim());
        		String sourceName = StringUtils.getSourceName(dto.accountFields.sourceId);
        		profile.setSource(sourceName); /// Set the Source Name
        		
        		// CreateSubscriptionPreferences POJO
        		SubscriptionPreferences subscriptionPreferences = new SubscriptionPreferences();
        		subscriptionPreferences.setEmailAddress(dto.emailFields.emailAddress.trim());
        		
        		Set<PreferenceDTO> preferenceFields = dto.accountFields.preferenceFields;
        		List<Preferences> preferencesList = new ArrayList<Preferences>();
        		
                for (PreferenceDTO preferenceDTO : preferenceFields) {
                	Preferences pre = new Preferences();
            		pre.setLastActivityDate(String.valueOf(System.currentTimeMillis()));//please use time miles in long and pass as a String
            		pre.setOptedIn(preferenceDTO.optIn);
            		//pre.setSubscriptionId(preferenceDTO.preferenceId);
            		pre.setSubscriptionId(StringUtils.getETSubscriptionId(preferenceDTO.preferenceId));
            		pre.setLastSource(sourceName); //set the source namr correctly
            		preferencesList.add(pre);
                }
                        
                // you need to use loop for multiple preferences to add in list
        		
        		subscriptionPreferences.setSubscriptionPreferences(preferencesList);

        		// Final DigitalProfileWithSubscription POJO will pass in service method with parameters
        		DigitalProfileWithSubscription digitalProfileWithSubscription = new DigitalProfileWithSubscription();
        		digitalProfileWithSubscription.setDigitalProfile(profile);
        		digitalProfileWithSubscription.setSubscriptionPreferences(subscriptionPreferences);
        		
        		ETExtensionServices eTExtensionServices = new ETExtensionServicesImpl();
        		ETResponse etResponse = eTExtensionServices.addUpdateDigitalProfileWithSubscriptions("onepass", digitalProfileWithSubscription);
        		
        		System.out.println("\n\n **********  etResponse.getCode() : " + etResponse.getCode());
        		System.out.println("\n\n **********  etResponse.getDescription() : " + etResponse.getDescription());
        		
        		if(etResponse.getDetailedMessages() != null) {
        			for(int i=0; i<etResponse.getDetailedMessages().length; i++) {
        				System.out.println("\n\n **********  etResponse.getDetailedMessage " + i +": " + etResponse.getDetailedMessages()[i]);
        			}
        		}
            }
            
            // Email Address verification for RD employees for free fulfillment
            String rdEmailPattern = getBundleStringValue("rdEmailRegEx");
            if (dto.emailFields.emailAddress.trim().toLowerCase().matches(rdEmailPattern)) {
                emailValidToken(dto.emailFields.emailAddress.trim().toLowerCase(), prodAbbr);
            }

            EntityManagerHelper.commit();

            

            EntityManagerHelper.log("End OnePassServiceImpl.createUserProfileInfo() ..", Level.INFO, null);
        } catch (ServiceException ex) {
            EntityManagerHelper.log("Error OnePassServiceImpl.createUserProfileInfo() ..", Level.ALL, ex);
            ex.printStackTrace();
            EntityManagerHelper.rollback();
            serviceResponse.responseText = ex.getMessage();
            serviceResponse.status = TRANSACTION_FAILED;
            return serviceResponse;

        } catch (Exception ex) {
            EntityManagerHelper.log("Error OnePassServiceImpl.createUserProfileInfo() ..", Level.ALL, ex);
            ex.printStackTrace();
            EntityManagerHelper.rollback();
            serviceResponse.responseText = ex.getMessage();
            serviceResponse.status = TRANSACTION_FAILED;
            return serviceResponse;

        } finally {
            EntityManagerHelper.clear();
            EntityManagerHelper.closeEntityManager();
        }

        serviceResponse.responseText = TRANSACTION_SUCCESS_RESPONSE_TEXT;
        serviceResponse.status = TRANSACTION_SUCCESS;
        return serviceResponse;

    }

    /**
     * Verify the email address and login details.
     * 
     * @param dto
     *            the OnePassUserLoginDTO
     * @return the OnePassServiceResponse object
     */
    public OnePassServiceResponse minimalRegistration(final CreateOnePassUserProfileDTO dto) {

        EntityManagerHelper.log("Start OnePassServiceImpl.minimalRegistration() ..", Level.INFO, null);

        try {
            
            EntityManagerHelper.beginTransaction();
            EntityManagerHelper.getEntityManager().setFlushMode(FlushModeType.COMMIT);
            
            try {
                serviceValidator.validMinimalRegistrationService(dto);
            } catch (ServiceException ex) {
                serviceResponse.responseText = ex.getMessage();
                serviceResponse.status = TRANSACTION_FAILED;
                EntityManagerHelper.rollback();
                EntityManagerHelper.log("Error OnePassServiceImpl.userLogin() ..", Level.INFO, ex);
                return serviceResponse;
            }

            
            
            Timestamp timeStamp = new Timestamp(System.currentTimeMillis());

            Member member = new Member();

            if (memberDAO.findByMemberName(dto.emailFields.emailAddress.trim()).size() > 0) {
                member.setMemberName(UUID.randomUUID().getMostSignificantBits() + ":" + dto.emailFields.emailAddress.trim());
            } else {
                member.setMemberName(dto.emailFields.emailAddress.trim());
            }
            // member.setPassword(OneWayEncrypter.encryptString(dto.emailFields.password));
            memberDAO.save(member);

            List<Email> emailList = emailDAO.findByEmailAddress(dto.emailFields.emailAddress.trim());

            Email email = null;

            if (emailList != null && emailList.size() > 0) {
                email = emailDAO.findByEmailAddress(dto.emailFields.emailAddress.trim()).get(0);
            }

            if (email != null) {
                if (email.getMember() == null) {
                    email.setMember(member);
                    email.setEmailTypeId(EMAIL_PRIMARY_ID);
                    email.setEffectiveDate(timeStamp);
                    email.setNonMemberProfile(null);
                } else {
                    member = email.getMember();
                }

                emailDAO.update(email);
            } else {
                email = new Email();
                email.setMember(member);
                email.setEmailAddress(dto.emailFields.emailAddress.trim());
                email.setEmailTypeId(EMAIL_PRIMARY_ID);
                email.setEffectiveDate(timeStamp);
                emailDAO.save(email);
            }

            MemberOnePassInfo memberOnePassInfo = new MemberOnePassInfo();

            String prodAbbr = StringUtils.getProdIdBySource(dto.accountFields.sourceId);
            memberOnePassInfo.setMember(member);
            memberOnePassInfo.setActive(ACTIVE_MEMBER);
            memberOnePassInfo.setPassword(OneWayEncrypter.encryptString(dto.emailFields.password));
            memberOnePassInfo.setEmailAddress(dto.emailFields.emailAddress.trim());
            memberOnePassInfo.setProdId(prodAbbr);
            memberOnePassInfo.setCreateDate(timeStamp);

            memberOnePassInfoDAO.save(memberOnePassInfo);

            if (StringUtils.isPmDBPublication(prodAbbr)) {
                // Add the member in P&M database
                PMDBServiceManager pmDBManager = new PMDBServiceManager();
                pmDBManager.AddMember(prodAbbr, dto.emailFields.emailAddress.trim(), null);
            }
            
            // Email Address verification for RD employees for free fulfillment
            String rdEmailPattern = getBundleStringValue("rdEmailRegEx");
            if (dto.emailFields.emailAddress.trim().toLowerCase().matches(rdEmailPattern)) {
                emailValidToken(dto.emailFields.emailAddress.trim().toLowerCase(), prodAbbr);
            }
            
            if(StringUtils.isPreAndETUpdate()) {
            	DigitalProfile profile = new DigitalProfile();
        		profile.setEmailAddress(dto.emailFields.emailAddress.trim());
        		String sourceName = StringUtils.getSourceName(dto.accountFields.sourceId);
        		profile.setSource(sourceName); /// Set the Source Name
        	
        		
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

            EntityManagerHelper.commit();

            
            EntityManagerHelper.log("End OnePassServiceImpl.createUserProfileInfo() ..", Level.INFO, null);
        } catch (ServiceException ex) {
            EntityManagerHelper.log("Error OnePassServiceImpl.createUserProfileInfo() ..", Level.ALL, ex);
            ex.printStackTrace();
            EntityManagerHelper.rollback();
            serviceResponse.responseText = ex.getMessage();
            serviceResponse.status = TRANSACTION_FAILED;
            return serviceResponse;

        } catch (Exception ex) {
            EntityManagerHelper.log("Error OnePassServiceImpl.createUserProfileInfo() ..", Level.ALL, ex);
            ex.printStackTrace();
            EntityManagerHelper.rollback();
            serviceResponse.responseText = ex.getMessage();
            serviceResponse.status = TRANSACTION_FAILED;
            return serviceResponse;

        } finally {
            EntityManagerHelper.clear();
            EntityManagerHelper.closeEntityManager();
        }

        serviceResponse.responseText = TRANSACTION_SUCCESS_RESPONSE_TEXT;
        serviceResponse.status = TRANSACTION_SUCCESS;
        return serviceResponse;
    }

    /**
     * Creates the email address opt status.
     * 
     * @param optStatusTransaction
     *            the opt status transaction
     * @param dto
     *            the dto
     * @return the sets the
     * @throws ServiceException
     *             the service exception
     */
    private Set<EmailAddressOptStatus> createEmailAddressOptStatus(OptStatusTransaction optStatusTransaction, CreateOnePassUserProfileDTO dto)
            throws ServiceException {

        EntityManagerHelper.log("Start OnePassServiceImpl.createEmailAddressOptStatus() ..", Level.INFO, null);

        Set<EmailAddressOptStatus> emailAddressOptStatuses = new HashSet<EmailAddressOptStatus>();

        try {
            Set<PreferenceDTO> preferenceFields = dto.accountFields.preferenceFields;

            for (PreferenceDTO preferenceDTO : preferenceFields) {
                UserPreference userPreference = userPreferenceDAO.findById(Integer.parseInt(preferenceDTO.preferenceId));
                if (userPreference != null) {
                    EmailAddressOptStatusId emailAddressOptStatusId = new EmailAddressOptStatusId(optStatusTransaction.getOptStatusTransactionId(),
                            userPreference.getUserPreferenceId());
                    OptStatus optStatus = new OptStatus();
                    if (preferenceDTO.optIn) {
                        optStatus.setOptStatusId(OPT_PREFERS);
                    } else {
                        optStatus.setOptStatusId(OPT_PREFERS_NOT);
                    }
                    emailAddressOptStatuses.add(new EmailAddressOptStatus(emailAddressOptStatusId, userPreference, optStatus, optStatusTransaction));
                } else {
                    throw new ServiceException(StringUtils.getBundleProperty("preference.valid"));
                }
            }

        } catch (Exception e) {
            EntityManagerHelper.rollback();
            e.printStackTrace();
            EntityManagerHelper.log("Error OnePassServiceImpl.createEmailAddressOptStatus() ..", Level.INFO, null);
            throw new ServiceException(e.getMessage());
        }

        EntityManagerHelper.log("End OnePassServiceImpl.createEmailAddressOptStatus() ..", Level.INFO, null);

        return emailAddressOptStatuses;
    }

    /**
     * Update the user profile information.
     * 
     * @param dto
     *            the UpdateOnePassUserProfileDTO
     * @return the OnePassServiceResponse object
     */
    public  OnePassServiceResponse updateUserProfileInfo(final UpdateOnePassUserProfileDTO dto) {

        try {

            EntityManagerHelper.log("Start OnePassServiceImpl.updateUserProfileInfo() ..", Level.INFO, null);

            EntityManagerHelper.beginTransaction();
            EntityManagerHelper.getEntityManager().setFlushMode(FlushModeType.COMMIT);
            
            try {
                serviceValidator.validUpdateService(dto);
            } catch (ServiceException ex) {
                serviceResponse.responseText = ex.getMessage();
                serviceResponse.status = TRANSACTION_FAILED;
                return serviceResponse;
            }

            Timestamp timeStamp = new Timestamp(System.currentTimeMillis());

            Email email = null;

            Member member = null;

            MemberOnePassInfo memberOnePassInfo = null;

            String prodAbbr = StringUtils.getProdIdBySource(dto.accountFields.sourceId);

            String accountNumber = dto.emailFields.accountNumber;

            System.out.println("\n\n\n\n ***** dto.emailFields.emailAddress : " + dto.header.emailAddress.trim());
            System.out.println("\n\n\n\n ***** dto.emailFields.memberOnePassInfoDAO : " + memberOnePassInfoDAO);

            List<MemberOnePassInfo> memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active",
                    dto.header.emailAddress.trim(), prodAbbr, ACTIVE_MEMBER);

            // List<MemberOnePassInfo> newMemberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress",
            // "prodId",dto.emailFields.emailAddress.trim(), prodAbbr);

            if (memberOnePassInfoList == null || memberOnePassInfoList.size() == 0) {
                serviceResponse.responseText = StringUtils.getBundleProperty("emailAddress.notExist");
                serviceResponse.status = TRANSACTION_FAILED;
                EntityManagerHelper.rollback();
                return serviceResponse;
            } else {
                memberOnePassInfo = memberOnePassInfoList.get(0);
                member = memberOnePassInfo.getMember();
            }
            System.out.println("\n\n\n &&&&&&&&&&&& 11111111111111111shanu in uddate");

            List<Email> emailList = emailDAO.findByEmailAddress(dto.header.emailAddress.trim());

            if (emailList != null && emailList.size() > 0) {
                email = emailList.get(0);
            }

            OptStatusTransaction optStatusTransaction = new OptStatusTransaction();

            if (dto.addressFields.firstName != null && !"".equals(dto.addressFields.firstName.trim())) {
                String lastName = dto.addressFields.lastName == null ? "" : dto.addressFields.lastName;
                String fullName = dto.addressFields.firstName + " " + lastName;
                memberOnePassInfo.setFullName(fullName.trim());
            }

            if (dto.emailFields.password != null) {
                memberOnePassInfo.setPassword(OneWayEncrypter.encryptString(dto.emailFields.password));
            }

            String pmEmailAddress = dto.header.emailAddress.trim();

            if (dto.emailFields.newEmailAddress != null && !"".equals(dto.emailFields.newEmailAddress.trim())
                    && !dto.header.emailAddress.trim().equalsIgnoreCase(dto.emailFields.newEmailAddress.trim())) {

                pmEmailAddress = dto.emailFields.newEmailAddress.trim();

                if (emailDAO.findByEmailAddress(dto.emailFields.newEmailAddress.trim()).size() > 0) {

                    Email existingEmail = emailDAO.findByEmailAddress(dto.emailFields.newEmailAddress.trim()).get(0);
                    if (existingEmail.getMember() == null) {
                        member = memberOnePassInfo.getMember();
                        existingEmail.setMember(member);

                    } else {
                        member = existingEmail.getMember();
                    }

                    existingEmail.setEmailTypeId(EMAIL_PRIMARY_ID);
                    existingEmail.setEffectiveDate(timeStamp);
                    emailDAO.update(existingEmail);
                    optStatusTransaction.setEmail(existingEmail);

                } else {
                    Email newEmail = new Email();
                    member = memberOnePassInfo.getMember();
                    newEmail.setMember(member);
                    newEmail.setEmailAddress(dto.emailFields.newEmailAddress.trim());
                    newEmail.setEmailTypeId(EMAIL_PRIMARY_ID);
                    newEmail.setEffectiveDate(timeStamp);
                    emailDAO.save(newEmail);
                    optStatusTransaction.setEmail(newEmail);
                }

                MemberOnePassInfo newMemberOnePassInfo = null;

                List<MemberOnePassInfo> newMemberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active",
                        dto.emailFields.newEmailAddress.trim(), prodAbbr, ACTIVE_MEMBER);
                if (newMemberOnePassInfoList != null && newMemberOnePassInfoList.size() > 0) {
                    newMemberOnePassInfo = newMemberOnePassInfoList.get(0);

                    if (newMemberOnePassInfo.getAccountNumber() != null && !"".equals(newMemberOnePassInfo.getAccountNumber().trim())) {
                        serviceResponse.responseText = StringUtils.getBundleProperty("emailAddress.exist");
                        serviceResponse.status = TRANSACTION_FAILED;
                        EntityManagerHelper.rollback();
                        return serviceResponse;
                    } else {
                        if (memberOnePassInfo.getAccountNumber() != null && !"".equals(memberOnePassInfo.getAccountNumber().trim())) {
                            System.out.println("\n\n\n ******** shakti 1111111111 newMemberOnePassInfoList.get(0).getEmailAddress()"
                                    + newMemberOnePassInfoList.get(0).getEmailAddress());
                            newMemberOnePassInfo.setActive(INACTIVE_MEMBER);
                            memberOnePassInfoDAO.update(newMemberOnePassInfo);

                            newMemberOnePassInfo = new MemberOnePassInfo();
                            memberOnePassInfo.setActive(INACTIVE_MEMBER);
                            newMemberOnePassInfo.setMemberOnePassRefId(memberOnePassInfo.getMemberOnePassInfoId());
                            newMemberOnePassInfo.setMember(member);
                            newMemberOnePassInfo.setActive(ACTIVE_MEMBER);
                            newMemberOnePassInfo.setAccountNumber(memberOnePassInfo.getAccountNumber());
                            newMemberOnePassInfo.setPassword(memberOnePassInfo.getPassword());
                            newMemberOnePassInfo.setZipCode(memberOnePassInfo.getZipCode());
                            newMemberOnePassInfo.setUserType(memberOnePassInfo.getUserType());
                            newMemberOnePassInfo.setFullName(memberOnePassInfo.getFullName());
                            newMemberOnePassInfo.setEmailAddress(dto.emailFields.newEmailAddress.trim());
                            newMemberOnePassInfo.setCreateDate(new Timestamp(System.currentTimeMillis()));
                            newMemberOnePassInfo.setProdId(prodAbbr);
                            memberOnePassInfoDAO.save(newMemberOnePassInfo);
                        } else {
                            serviceResponse.responseText = StringUtils.getBundleProperty("emailAddress.exist");
                            serviceResponse.status = TRANSACTION_FAILED;
                            EntityManagerHelper.rollback();
                            return serviceResponse;
                        }
                    }
                } else {
                    newMemberOnePassInfo = new MemberOnePassInfo();
                    memberOnePassInfo.setActive(INACTIVE_MEMBER);
                    newMemberOnePassInfo.setMemberOnePassRefId(memberOnePassInfo.getMemberOnePassInfoId());
                    newMemberOnePassInfo.setPassword(memberOnePassInfo.getPassword());
                    newMemberOnePassInfo.setMember(member);
                    newMemberOnePassInfo.setActive(ACTIVE_MEMBER);
                    if (memberOnePassInfo.getAccountNumber() != null && !"".equals(memberOnePassInfo.getAccountNumber().trim())) {
                        newMemberOnePassInfo.setAccountNumber(memberOnePassInfo.getAccountNumber());
                        newMemberOnePassInfo.setZipCode(memberOnePassInfo.getZipCode());
                        newMemberOnePassInfo.setUserType(memberOnePassInfo.getUserType());
                    }
                    newMemberOnePassInfo.setFullName(memberOnePassInfo.getFullName());
                    newMemberOnePassInfo.setEmailAddress(dto.emailFields.newEmailAddress.trim());
                    newMemberOnePassInfo.setCreateDate(new Timestamp(System.currentTimeMillis()));
                    newMemberOnePassInfo.setProdId(prodAbbr);
                    memberOnePassInfoDAO.save(newMemberOnePassInfo);
                }
            } else {
                optStatusTransaction.setEmail(email);
            }

            memberOnePassInfoDAO.update(memberOnePassInfo);

            PostalAddress newAddress = new PostalAddress();
            newAddress.setMember(member);
            newAddress.setFirstName(dto.addressFields.firstName);
            newAddress.setLastName(dto.addressFields.lastName);
            newAddress.setAddress1(dto.addressFields.address1);
            newAddress.setAddress2(dto.addressFields.address2);
            newAddress.setCity(dto.addressFields.city);
            newAddress.setCountry(dto.addressFields.countryCode);
            // Only insert the state for Country USA and Canada
            if ("US".equalsIgnoreCase(dto.addressFields.countryCode) || "CA".equalsIgnoreCase(dto.addressFields.countryCode)) {
                newAddress.setSubdivision(dto.addressFields.stateCode);
            }

            newAddress.setZip(dto.addressFields.zip);
            newAddress.setCreateDate(timeStamp);
            newAddress.setEffectiveDate(timeStamp);

            if (StringUtils.isPmDBPublication(prodAbbr)) {
                // Update the member in P&M database
                PMDBServiceManager pmDBManager = new PMDBServiceManager();
                pmDBManager.AddMember(prodAbbr, pmEmailAddress, newAddress);
                pmDBManager.AddOptIn(prodAbbr, pmEmailAddress, dto.accountFields.preferenceFields);
            } else {
                PostalAddress oldAddress = null;
                List<PostalAddress> postalAddressList = addressDAO.findByProperty("member", member);
                if (postalAddressList != null && postalAddressList.size() > 0) {
                    oldAddress = postalAddressList.get(0);
                }

                if (oldAddress == null || !newAddress.equals(oldAddress)) {
                    AddressType addressType = addressTypeDAO.findById(ADDRESS_TYPE_ID);
                    newAddress.setAddressType(addressType);
                    addressDAO.save(newAddress);
                }

                optStatusTransaction.setCreateDate(timeStamp);
                Source source = sourceDAO.findById(Integer.parseInt(dto.accountFields.sourceId));

                if (source != null) {
                    optStatusTransaction.setSource(source);
                } else {
                    EntityManagerHelper.rollback();
                    serviceResponse.responseText = StringUtils.getBundleProperty("sourceId.valid");
                    serviceResponse.status = TRANSACTION_FAILED;
                    return serviceResponse;
                }

                optStatusTransaction.setTrackingId(dto.accountFields.trackingId);

                List<OptStatusTransaction> optStatusTransactionList = optStatusTransactionDAO.findByProperties("email", "source", email, source);

                Set<EmailAddressOptHistory> emailAddressOptHistories = new HashSet<EmailAddressOptHistory>();
                for (OptStatusTransaction opStatusTrns : optStatusTransactionList) {
                    Set<EmailAddressOptStatus> emailAddressOptStatuses = opStatusTrns.getEmailAddressOptStatuses();
                    for (EmailAddressOptStatus emailAddOptStatus : emailAddressOptStatuses) {
                        emailAddressOptHistories.add(new EmailAddressOptHistory(emailAddOptStatus.getUserPreference(), emailAddOptStatus.getOptStatus(),
                                emailAddOptStatus.getOptStatusTransaction()));
                        if (emailAddressOptStatusDAO.findById(emailAddOptStatus.getId()) != null) {
                            emailAddressOptStatusDAO.delete(emailAddOptStatus);
                        }
                    }
                }

                optStatusTransaction.setEmailAddressOptHistories(emailAddressOptHistories);

                optStatusTransactionDAO.save(optStatusTransaction);

                EntityManagerHelper.flush();
                
                //EntityManagerHelper.commit();

                // refreshed the id for
              //optStatusTransaction = optStatusTransactionDAO.refresh(optStatusTransaction);
                // start the new transaction for opt transaction id
               // EntityManagerHelper.beginTransaction();
               // EntityManagerHelper.getEntityManager().setFlushMode(FlushModeType.COMMIT);
                Set<EmailAddressOptStatus> emailAddressOptStatuses = createEmailAddressOptStatus(optStatusTransaction, dto);
                optStatusTransaction.setEmailAddressOptStatuses(emailAddressOptStatuses);
                optStatusTransactionDAO.update(optStatusTransaction);
            }
            
            if(StringUtils.isPreAndETUpdate()) {
            	DigitalProfile profile = new DigitalProfile();
        		profile.setAddress1(dto.addressFields.address1);
        		profile.setAddress2(dto.addressFields.address2);
        		profile.setCity(dto.addressFields.city);
        		profile.setCountryCode(dto.addressFields.countryCode);
        		profile.setFirstName(dto.addressFields.firstName);
        		profile.setLastName(dto.addressFields.lastName);
        		profile.setLastUpdateDate(String.valueOf(System.currentTimeMillis()));//please use time miles in long and pass as a String
        		profile.setPostalCode(dto.addressFields.zip);
        		profile.setStateProvinceCode(dto.addressFields.stateCode);
        		profile.setEmailAddress(dto.header.emailAddress.trim());
        		String sourceName = StringUtils.getSourceName(dto.accountFields.sourceId);
        		profile.setSource(sourceName); /// Set the Source Name
        		
        		// CreateSubscriptionPreferences POJO
        		SubscriptionPreferences subscriptionPreferences = new SubscriptionPreferences();
        		subscriptionPreferences.setEmailAddress(dto.header.emailAddress.trim());
        		
        		Set<PreferenceDTO> preferenceFields = dto.accountFields.preferenceFields;
        		List<Preferences> preferencesList = new ArrayList<Preferences>();
        		
                for (PreferenceDTO preferenceDTO : preferenceFields) {
                	Preferences pre = new Preferences();
            		pre.setLastActivityDate(String.valueOf(System.currentTimeMillis()));//please use time miles in long and pass as a String
            		pre.setOptedIn(preferenceDTO.optIn);
            		//pre.setSubscriptionId(preferenceDTO.preferenceId);
            		pre.setSubscriptionId(StringUtils.getETSubscriptionId(preferenceDTO.preferenceId));
            		pre.setLastSource(sourceName);
            		preferencesList.add(pre);
                }
                        
                // you need to use loop for multiple preferences to add in list
        		
        		subscriptionPreferences.setSubscriptionPreferences(preferencesList);

        		// Final DigitalProfileWithSubscription POJO will pass in service method with parameters
        		DigitalProfileWithSubscription digitalProfileWithSubscription = new DigitalProfileWithSubscription();
        		digitalProfileWithSubscription.setDigitalProfile(profile);
        		digitalProfileWithSubscription.setSubscriptionPreferences(subscriptionPreferences);
        		
        		ETExtensionServices eTExtensionServices = new ETExtensionServicesImpl();
        		ETResponse etResponse = eTExtensionServices.addUpdateDigitalProfileWithSubscriptions("onepass", digitalProfileWithSubscription);
        		
        		System.out.println("\n\n **********  etResponse.getCode() : " + etResponse.getCode());
        		System.out.println("\n\n **********  etResponse.getDescription() : " + etResponse.getDescription());
        		
        		if(etResponse.getDetailedMessages() != null) {
        			for(int i=0; i<etResponse.getDetailedMessages().length; i++) {
        				System.out.println("\n\n **********  etResponse.getDetailedMessage " + i +": " + etResponse.getDetailedMessages()[i]);
        			}
        		}

            }

            EntityManagerHelper.commit();

            serviceResponse.primaryEmailAddress = memberOnePassInfo.getEmailAddress();

            EntityManagerHelper.log("End OnePassServiceImpl.updateUserProfileInfo() ..", Level.INFO, null);
        } catch (ServiceException ex) {
            EntityManagerHelper.log("Error OnePassServiceImpl.updateUserProfileInfo() ..", Level.ALL, ex);
            ex.printStackTrace();
            EntityManagerHelper.rollback();
            serviceResponse.responseText = ex.getMessage();
            serviceResponse.status = TRANSACTION_FAILED;
            return serviceResponse;

        } catch (Exception ex) {
            EntityManagerHelper.log("Error OnePassServiceImpl.updateUserProfileInfo() ..", Level.ALL, ex);
            ex.printStackTrace();
            EntityManagerHelper.rollback();
            serviceResponse.responseText = ex.getMessage();
            serviceResponse.status = TRANSACTION_FAILED;
            return serviceResponse;

        } finally {
            EntityManagerHelper.clear();
            EntityManagerHelper.closeEntityManager();
        }

        serviceResponse.responseText = TRANSACTION_SUCCESS_RESPONSE_TEXT;
        serviceResponse.status = TRANSACTION_SUCCESS;

        return serviceResponse;

    }

    /**
     * Update the user profile information.
     * 
     * @param dto
     *            the UpdateOnePassUserProfileDTO
     * @return the OnePassServiceResponse object
     */
    public  OnePassServiceResponse updateEmailProfileInfo(final UpdateOnePassUserProfileDTO dto) {

        try {

            EntityManagerHelper.log("Start OnePassServiceImpl.updateEmailProfileInfo() ..", Level.INFO, null);

            System.out.println("\n\n\n &&&&&&&&&&&& shanu in updateEmailProfileInfo");

            EntityManagerHelper.beginTransaction();
            
            EntityManagerHelper.getEntityManager().setFlushMode(FlushModeType.COMMIT);

            Timestamp timeStamp = new Timestamp(System.currentTimeMillis());

            Email email = null;

            Member member = null;

            MemberOnePassInfo memberOnePassInfo = null;

            String prodAbbr = StringUtils.getProdIdBySource(dto.accountFields.sourceId);

            System.out.println("\n\n\n\n ***** dto.emailFields.emailAddress : " + dto.header.emailAddress.trim());
            System.out.println("\n\n\n\n ***** dto.emailFields.memberOnePassInfoDAO : " + memberOnePassInfoDAO);

            List<MemberOnePassInfo> memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active",
                    dto.header.emailAddress.trim(), prodAbbr, ACTIVE_MEMBER);

            // List<MemberOnePassInfo> newMemberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress",
            // "prodId",dto.emailFields.emailAddress.trim(), prodAbbr);

            if (memberOnePassInfoList == null || memberOnePassInfoList.size() == 0) {
                serviceResponse.responseText = StringUtils.getBundleProperty("emailAddress.notExist");
                serviceResponse.status = TRANSACTION_FAILED;
                EntityManagerHelper.rollback();
                return serviceResponse;
            } else {
                memberOnePassInfo = memberOnePassInfoList.get(0);
                member = memberOnePassInfo.getMember();
            }
            System.out.println("\n\n\n &&&&&&&&&&&& 11111111111111111shanu in uddate");

            List<Email> emailList = emailDAO.findByEmailAddress(dto.header.emailAddress.trim());

            if (emailList != null && emailList.size() > 0) {
                email = emailList.get(0);
            }

            if (dto.emailFields.password != null) {
                memberOnePassInfo.setPassword(OneWayEncrypter.encryptString(dto.emailFields.password));
            }

            if (dto.emailFields.newEmailAddress != null && !"".equals(dto.emailFields.newEmailAddress.trim())
                    && !dto.header.emailAddress.trim().equalsIgnoreCase(dto.emailFields.newEmailAddress.trim())) {

                Email strEmail = null;

                if (emailDAO.findByEmailAddress(dto.emailFields.newEmailAddress.trim()).size() > 0) {

                    Email existingEmail = emailDAO.findByEmailAddress(dto.emailFields.newEmailAddress.trim()).get(0);
                    if (existingEmail.getMember() == null) {
                        member = memberOnePassInfo.getMember();
                        existingEmail.setMember(member);

                    } else {
                        member = existingEmail.getMember();
                    }

                    existingEmail.setEmailTypeId(EMAIL_PRIMARY_ID);
                    existingEmail.setEffectiveDate(timeStamp);
                    emailDAO.update(existingEmail);
                    strEmail = existingEmail;

                } else {
                    Email newEmail = new Email();
                    member = memberOnePassInfo.getMember();
                    newEmail.setMember(member);
                    newEmail.setEmailAddress(dto.emailFields.newEmailAddress.trim());
                    newEmail.setEmailTypeId(EMAIL_PRIMARY_ID);
                    newEmail.setEffectiveDate(timeStamp);
                    emailDAO.save(newEmail);
                    strEmail = newEmail;
                }

                MemberOnePassInfo newMemberOnePassInfo = null;

                List<MemberOnePassInfo> newMemberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active",
                        dto.emailFields.newEmailAddress.trim(), prodAbbr, ACTIVE_MEMBER);
                if (newMemberOnePassInfoList != null && newMemberOnePassInfoList.size() > 0) {
                    newMemberOnePassInfo = newMemberOnePassInfoList.get(0);

                    if (newMemberOnePassInfo.getAccountNumber() != null && !"".equals(newMemberOnePassInfo.getAccountNumber().trim())) {
                        serviceResponse.responseText = StringUtils.getBundleProperty("emailAddress.exist");
                        serviceResponse.status = TRANSACTION_FAILED;
                        EntityManagerHelper.rollback();
                        return serviceResponse;
                    } else {
                        if (memberOnePassInfo.getAccountNumber() != null && !"".equals(memberOnePassInfo.getAccountNumber().trim())) {
                            System.out.println("\n\n\n ******** shakti 1111111111 newMemberOnePassInfoList.get(0).getEmailAddress()"
                                    + newMemberOnePassInfoList.get(0).getEmailAddress());
                            newMemberOnePassInfo.setActive(INACTIVE_MEMBER);
                            memberOnePassInfoDAO.update(newMemberOnePassInfo);

                            newMemberOnePassInfo = new MemberOnePassInfo();
                            memberOnePassInfo.setActive(INACTIVE_MEMBER);
                            newMemberOnePassInfo.setMemberOnePassRefId(memberOnePassInfo.getMemberOnePassInfoId());
                            newMemberOnePassInfo.setMember(member);
                            newMemberOnePassInfo.setActive(ACTIVE_MEMBER);
                            newMemberOnePassInfo.setAccountNumber(memberOnePassInfo.getAccountNumber());
                            newMemberOnePassInfo.setPassword(memberOnePassInfo.getPassword());
                            newMemberOnePassInfo.setZipCode(memberOnePassInfo.getZipCode());
                            newMemberOnePassInfo.setUserType(memberOnePassInfo.getUserType());
                            newMemberOnePassInfo.setFullName(memberOnePassInfo.getFullName());
                            newMemberOnePassInfo.setEmailAddress(dto.emailFields.newEmailAddress.trim());
                            newMemberOnePassInfo.setCreateDate(new Timestamp(System.currentTimeMillis()));
                            newMemberOnePassInfo.setProdId(prodAbbr);
                            memberOnePassInfoDAO.save(newMemberOnePassInfo);
                        } else {
                            serviceResponse.responseText = StringUtils.getBundleProperty("emailAddress.exist");
                            serviceResponse.status = TRANSACTION_FAILED;
                            EntityManagerHelper.rollback();
                            return serviceResponse;
                        }
                    }
                } else {
                    newMemberOnePassInfo = new MemberOnePassInfo();
                    memberOnePassInfo.setActive(INACTIVE_MEMBER);
                    newMemberOnePassInfo.setMemberOnePassRefId(memberOnePassInfo.getMemberOnePassInfoId());
                    newMemberOnePassInfo.setPassword(memberOnePassInfo.getPassword());
                    newMemberOnePassInfo.setMember(member);
                    newMemberOnePassInfo.setActive(ACTIVE_MEMBER);
                    if (memberOnePassInfo.getAccountNumber() != null && !"".equals(memberOnePassInfo.getAccountNumber().trim())) {
                        newMemberOnePassInfo.setAccountNumber(memberOnePassInfo.getAccountNumber());
                        newMemberOnePassInfo.setZipCode(memberOnePassInfo.getZipCode());
                    }
                    newMemberOnePassInfo.setUserType(memberOnePassInfo.getUserType());
                    newMemberOnePassInfo.setFullName(memberOnePassInfo.getFullName());
                    newMemberOnePassInfo.setEmailAddress(dto.emailFields.newEmailAddress.trim());
                    newMemberOnePassInfo.setCreateDate(new Timestamp(System.currentTimeMillis()));
                    newMemberOnePassInfo.setProdId(prodAbbr);
                    memberOnePassInfoDAO.save(newMemberOnePassInfo);
                }

                memberOnePassInfoDAO.update(memberOnePassInfo);

                if (StringUtils.isPmDBPublication(prodAbbr)) {
                    // Update the member in P&M database
                    PMDBServiceManager pmDBManager = new PMDBServiceManager();
                    pmDBManager.AddMember(prodAbbr, strEmail.getEmailAddress(), null);
                } else {
                    Source source = sourceDAO.findById(Integer.parseInt(dto.accountFields.sourceId));
                    OptStatusTransaction optStatusTransaction = new OptStatusTransaction();
                    optStatusTransaction.setEmail(strEmail);
                    optStatusTransaction.setCreateDate(timeStamp);

                    if (source != null) {
                        optStatusTransaction.setSource(source);
                    } else {
                        EntityManagerHelper.rollback();
                        serviceResponse.responseText = StringUtils.getBundleProperty("sourceId.valid");
                        serviceResponse.status = TRANSACTION_FAILED;
                        return serviceResponse;
                    }

                    optStatusTransaction.setTrackingId(dto.accountFields.trackingId);
                    List<OptStatusTransaction> optStatusTransactionList = optStatusTransactionDAO.findByProperties("email", "source", email, source);
                    if (optStatusTransactionList != null && optStatusTransactionList.size() > 0) {
                        OptStatusTransaction opStatusTrns = optStatusTransactionList.get(0); // get the latest id
                        Set<EmailAddressOptStatus> emailAddressOptStatuses = opStatusTrns.getEmailAddressOptStatuses();
                        optStatusTransaction.setEmailAddressOptStatuses(emailAddressOptStatuses);
                    }

                    optStatusTransactionDAO.save(optStatusTransaction);
                }

                updateEmailAddressToCDS(dto.emailFields.accountNumber, strEmail.getEmailAddress(), dto.accountFields.sourceId, prodAbbr);
                emailValidToken(strEmail.getEmailAddress(), prodAbbr);
                serviceResponse.primaryEmailAddress = strEmail.getEmailAddress();
                
            } else {
                emailValidToken(dto.header.emailAddress.trim(), prodAbbr);
                serviceResponse.primaryEmailAddress = dto.header.emailAddress.trim();
            }
            
            EntityManagerHelper.commit();

            

            EntityManagerHelper.log("End OnePassServiceImpl.updateUserProfileInfo() ..", Level.INFO, null);
        } catch (ServiceException ex) {
            EntityManagerHelper.log("Error OnePassServiceImpl.updateUserProfileInfo() ..", Level.ALL, ex);
            ex.printStackTrace();
            EntityManagerHelper.rollback();
            serviceResponse.responseText = ex.getMessage();
            serviceResponse.status = TRANSACTION_FAILED;
            return serviceResponse;

        } catch (Exception ex) {
            EntityManagerHelper.log("Error OnePassServiceImpl.updateUserProfileInfo() ..", Level.ALL, ex);
            ex.printStackTrace();
            EntityManagerHelper.rollback();
            serviceResponse.responseText = ex.getMessage();
            serviceResponse.status = TRANSACTION_FAILED;
            return serviceResponse;

        } finally {
            EntityManagerHelper.clear();
            EntityManagerHelper.closeEntityManager();
        }

        serviceResponse.responseText = TRANSACTION_SUCCESS_RESPONSE_TEXT;
        serviceResponse.status = TRANSACTION_SUCCESS;

        return serviceResponse;

    }

    /*
     * (non-Javadoc)
     * 
     * @see com.readersdigest.onepass.service.impl.OnePassServiceImpl#resetForgetPasswordToken(java.lang.String)
     */
    /*public boolean emailValidToken(String emailAddress, String prodId) {

        EntityManagerHelper.log("Start OnePassServiceImpl.emailValidToken() ..", Level.INFO, null);
        String token = null;
        boolean flag = false;
        try {
           // EntityManagerHelper.beginTransaction();
           // EntityManagerHelper.getEntityManager().setFlushMode(FlushModeType.COMMIT);
           
            List<Email> emailList = emailDAO.findByEmailAddress(emailAddress.trim());

            if (emailList != null && emailList.size() > 0) {
                Email email = emailList.get(0);
                List<EmailValid> emailValidList = emailValidDAO.findByProperties("email.emailId", "prodId", email.getEmailId(), prodId);
                if (emailValidList != null && emailValidList.size() > 0) {
                    EmailValid emailValid = emailValidList.get(0);
                    token = emailValid.getToken();
                } else {
                    try {
                        EmailValid emailValid = new EmailValid();
                        emailValid.setEmail(email);
                        emailValid.setCreateDate(new Timestamp(System.currentTimeMillis()));
                        emailValid.setValid(INVALID_STRING);
                        emailValid.setProdId(prodId);
                        token = UUID.randomUUID().toString();
                        emailValid.setToken(token);
                        emailValidDAO.save(emailValid);
                        //EntityManagerHelper.commit();
                    } catch (Exception e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                        //EntityManagerHelper.rollback();
                        return flag;
                    } 

                }

            } else {
                return flag;
            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return flag;
        } 
        /*finally {
            EntityManagerHelper.clear();
            EntityManagerHelper.closeEntityManager();
        }*/

       /* String rdEmailPattern = getBundleStringValue("rdEmailRegEx");
        StringBuffer URL = null;
        String templateName = "";
        String emailContent = "";

        if (emailAddress.matches(rdEmailPattern)) {
            URL = new StringBuffer(getBundleStringValue("rdEmailValidationActionURL") + token);
            URL = URL.append("&appId=").append(prodId);
            templateName = getBundleStringValue("rdEmailValidationMailingTemplate");
            emailContent = getBundleStringValue("rdEmailValidationMailingTemplateContent");
            emailContent = emailContent.replaceAll("##url##", URL.toString());
        } else {
            URL = new StringBuffer(getBundleStringValue("emailValidationActionURL") + token);
            URL = URL.append("&appId=").append(prodId);
            templateName = getBundleStringValue("emailValidationMailingTemplate");
            emailContent = getBundleStringValue("emailValidationMailingTemplateContent_" + prodId);
            emailContent = emailContent.replaceAll("##url##", URL.toString());
        }

        try {
            EmailClient emailClient = new StrongMailClient();
            String strtxRecord = emailContent + "::" + emailAddress;
            System.out.println("\n\n\n ********** strtxRecord : " + strtxRecord);
            emailClient.send(strtxRecord, templateName);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;

    }*/
    
    /*
     * (non-Javadoc)
     * 
     * @see com.readersdigest.onepass.service.impl.OnePassServiceImpl#resetForgetPasswordToken(java.lang.String)
     */
    public boolean emailValidToken(String emailAddress, String prodId) {

        EntityManagerHelper.log("Start OnePassServiceImpl.emailValidToken() ..", Level.INFO, null);
        String token = null;
        boolean flag = false;
        try {
           // EntityManagerHelper.beginTransaction();
           // EntityManagerHelper.getEntityManager().setFlushMode(FlushModeType.COMMIT);
           
            List<EmailValidation> emailValidList = emailValidationDAO.findByProperties("emailAddress", "prodId", emailAddress, prodId);
            
            if (emailValidList != null && emailValidList.size() > 0) {
            	EmailValidation emailValid = emailValidList.get(0);
                token = emailValid.getToken();
            } else {
                try {
                    EmailValidation emailValid = new EmailValidation();
                    emailValid.setEmailAddress(emailAddress);
                    emailValid.setCreateDate(new Timestamp(System.currentTimeMillis()));
                    emailValid.setValid(INVALID_STRING);
                    emailValid.setProdId(prodId);
                    token = UUID.randomUUID().toString();
                    emailValid.setToken(token);
                    emailValidationDAO.save(emailValid);
                    //EntityManagerHelper.commit();
                } catch (Exception e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                    //EntityManagerHelper.rollback();
                    return flag;
                } 

            }
           
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return flag;
        } 
        /*finally {
            EntityManagerHelper.clear();
            EntityManagerHelper.closeEntityManager();
        }*/

        String rdEmailPattern = getBundleStringValue("rdEmailRegEx");
        StringBuffer URL = null;
        String templateName = "";
        String emailContent = "";

        if (emailAddress.matches(rdEmailPattern)) {
            URL = new StringBuffer(getBundleStringValue("rdEmailValidationActionURL") + token);
            URL = URL.append("&appId=").append(prodId);
            templateName = getBundleStringValue("rdEmailValidationMailingTemplate");
            emailContent = getBundleStringValue("rdEmailValidationMailingTemplateContent");
            emailContent = emailContent.replaceAll("##url##", URL.toString());
        } else {
            URL = new StringBuffer(getBundleStringValue("emailValidationActionURL") + token);
            URL = URL.append("&appId=").append(prodId);
            templateName = getBundleStringValue("emailValidationMailingTemplate");
            emailContent = getBundleStringValue("emailValidationMailingTemplateContent_" + prodId);
            emailContent = emailContent.replaceAll("##url##", URL.toString());
        }

        try {
            EmailClient emailClient = new StrongMailClient();
            String strtxRecord = emailContent + "::" + emailAddress;
            System.out.println("\n\n\n ********** strtxRecord : " + strtxRecord);
            emailClient.send(strtxRecord, templateName);
            flag = true;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return flag;

    }
    
    
    public OnePassServiceResponse updateEmailAddress(String oldEmailAddress, String newEmailAddress, String prodId) {
    	MemberOnePassInfo newMemberOnePassInfo = null;
    	MemberOnePassInfo memberOnePassInfo = null;
    	Member member = null;
        
      	if(prodId == null || "".equals(prodId.trim())) {
    		serviceResponse.responseText = "Product Id can not be blank";
            serviceResponse.status = TRANSACTION_FAILED;
            return serviceResponse;
    	}
        
        List<MemberOnePassInfo> memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active",
        		 oldEmailAddress.trim(), prodId, ACTIVE_MEMBER);

         // List<MemberOnePassInfo> newMemberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress",
         // "prodId",dto.emailFields.emailAddress.trim(), prodAbbr);

         if (memberOnePassInfoList == null || memberOnePassInfoList.size() == 0) {
             serviceResponse.responseText = StringUtils.getBundleProperty("emailAddress.notExist");
             serviceResponse.status = TRANSACTION_FAILED;
             return serviceResponse;
         } else {
             memberOnePassInfo = memberOnePassInfoList.get(0);
             member = memberOnePassInfo.getMember();
         }
         
    	try {
			EntityManagerHelper.beginTransaction();
			
			List<MemberOnePassInfo> newMemberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active",
			        newEmailAddress.trim(), prodId, ACTIVE_MEMBER);
			
			if (newMemberOnePassInfoList != null && newMemberOnePassInfoList.size() > 0) {
			    newMemberOnePassInfo = newMemberOnePassInfoList.get(0);

			    if (newMemberOnePassInfo.getAccountNumber() != null && !"".equals(newMemberOnePassInfo.getAccountNumber().trim())) {
			        serviceResponse.responseText = StringUtils.getBundleProperty("emailAddress.exist");
			        serviceResponse.status = TRANSACTION_FAILED;
			        EntityManagerHelper.rollback();
			        return serviceResponse;
			    } else {
			        if (memberOnePassInfo.getAccountNumber() != null && !"".equals(memberOnePassInfo.getAccountNumber().trim())) {
			            System.out.println("\n\n\n ******** shakti 1111111111 newMemberOnePassInfoList.get(0).getEmailAddress()"
			                    + newMemberOnePassInfoList.get(0).getEmailAddress());
			            newMemberOnePassInfo.setActive(INACTIVE_MEMBER);
			            memberOnePassInfoDAO.update(newMemberOnePassInfo);

			            newMemberOnePassInfo = new MemberOnePassInfo();
			            memberOnePassInfo.setActive(INACTIVE_MEMBER);
			            newMemberOnePassInfo.setMemberOnePassRefId(memberOnePassInfo.getMemberOnePassInfoId());
			            newMemberOnePassInfo.setMember(member);
			            newMemberOnePassInfo.setActive(ACTIVE_MEMBER);
			            newMemberOnePassInfo.setAccountNumber(memberOnePassInfo.getAccountNumber());
			            newMemberOnePassInfo.setPassword(memberOnePassInfo.getPassword());
			            newMemberOnePassInfo.setZipCode(memberOnePassInfo.getZipCode());
			            newMemberOnePassInfo.setUserType(memberOnePassInfo.getUserType());
			            newMemberOnePassInfo.setFullName(memberOnePassInfo.getFullName());
			            newMemberOnePassInfo.setEmailAddress(newEmailAddress.trim());
			            newMemberOnePassInfo.setCreateDate(new Timestamp(System.currentTimeMillis()));
			            newMemberOnePassInfo.setProdId(prodId);
			            memberOnePassInfoDAO.save(newMemberOnePassInfo);
			        } else {
			            serviceResponse.responseText = StringUtils.getBundleProperty("emailAddress.exist");
			            serviceResponse.status = TRANSACTION_FAILED;
			            EntityManagerHelper.rollback();
			            return serviceResponse;
			        }
			    }
			} else {
			    newMemberOnePassInfo = new MemberOnePassInfo();
			    memberOnePassInfo.setActive(INACTIVE_MEMBER);
			    newMemberOnePassInfo.setMemberOnePassRefId(memberOnePassInfo.getMemberOnePassInfoId());
			    newMemberOnePassInfo.setPassword(memberOnePassInfo.getPassword());
			    newMemberOnePassInfo.setMember(member);
			    newMemberOnePassInfo.setActive(ACTIVE_MEMBER);
			    if (memberOnePassInfo.getAccountNumber() != null && !"".equals(memberOnePassInfo.getAccountNumber().trim())) {
			        newMemberOnePassInfo.setAccountNumber(memberOnePassInfo.getAccountNumber());
			        newMemberOnePassInfo.setZipCode(memberOnePassInfo.getZipCode());
			    }
			    newMemberOnePassInfo.setUserType(memberOnePassInfo.getUserType());
			    newMemberOnePassInfo.setFullName(memberOnePassInfo.getFullName());
			    newMemberOnePassInfo.setEmailAddress(newEmailAddress.trim());
			    newMemberOnePassInfo.setCreateDate(new Timestamp(System.currentTimeMillis()));
			    newMemberOnePassInfo.setProdId(prodId);
			    memberOnePassInfoDAO.save(newMemberOnePassInfo);
			}

			memberOnePassInfoDAO.update(memberOnePassInfo);
			EntityManagerHelper.commit();
		} catch (Exception e) {
			
			serviceResponse.responseText = e.getMessage();
            serviceResponse.status = TRANSACTION_FAILED;
            EntityManagerHelper.rollback();
            return serviceResponse;
		}
    
        serviceResponse.responseText = TRANSACTION_SUCCESS_RESPONSE_TEXT;
        serviceResponse.status = TRANSACTION_SUCCESS;
        return serviceResponse;
    }
    
    
    public OnePassServiceResponse updateOnePassAllBrandsEmailAddress(String oldEmailAddress, String newEmailAddress) {
    	
    	if(oldEmailAddress == null || "".equalsIgnoreCase(oldEmailAddress)) {
        	serviceResponse.responseText = "Old email adrress can not be blank";
            serviceResponse.status = TRANSACTION_FAILED;
            return serviceResponse;
        }
        
        if(newEmailAddress == null || "".equalsIgnoreCase(newEmailAddress)) {
        	serviceResponse.responseText = "New email adrress can not be blank";
            serviceResponse.status = TRANSACTION_FAILED;
            return serviceResponse;
        }
        
        if(oldEmailAddress.equalsIgnoreCase(newEmailAddress)) {
        	serviceResponse.responseText = "Old email address and New email adrress can not be same";
            serviceResponse.status = TRANSACTION_FAILED;
            return serviceResponse;
        }
        
        List<MemberOnePassInfo> newMemberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "active",
        		newEmailAddress.trim(), ACTIVE_MEMBER);
        
        if(newMemberOnePassInfoList != null && newMemberOnePassInfoList.size() > 0) {
        	for(MemberOnePassInfo memberOnePassInfo : newMemberOnePassInfoList) {
        		if(memberOnePassInfo.getAccountNumber() != null) {
        			serviceResponse.responseText = "New Email Address is already Registered with other account number, please use different email address";
                    serviceResponse.status = TRANSACTION_FAILED;
                    return serviceResponse;
        		}
        	}
        }
        
                        
        List<MemberOnePassInfo> memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "active",
        		 oldEmailAddress.trim(), ACTIVE_MEMBER);
        if(memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
        	try {
				EntityManagerHelper.beginTransaction();
				for(MemberOnePassInfo memberOnePassInfo : memberOnePassInfoList) {
					memberOnePassInfo.setEmailAddress(newEmailAddress.trim());
					memberOnePassInfoDAO.update(memberOnePassInfo);
				}
				EntityManagerHelper.commit();
			} catch (Exception e) {
				serviceResponse.responseText = e.getMessage();
	            serviceResponse.status = TRANSACTION_FAILED;
	            EntityManagerHelper.rollback();
	            return serviceResponse;
			}
        } else {
        	 serviceResponse.responseText = StringUtils.getBundleProperty("emailAddress.notExist");
             serviceResponse.status = TRANSACTION_FAILED;
             return serviceResponse;
        }
           
        serviceResponse.responseText = TRANSACTION_SUCCESS_RESPONSE_TEXT;
        serviceResponse.status = TRANSACTION_SUCCESS;
        return serviceResponse;
    }
    
    
    
    public boolean updateEmailAddressToCDS(String accountNumber, String emailAddress, String sourceId, String prodAbbr) {
        // CDS update Start

        WSGResponse wsgr = null;
        Customer customer = null;
        WSG wsg = null;

        boolean isUpdated = false;

        //String prodAbbr = StringUtils.getProdId(appId);
        
        if (StringUtils.isIpadDevice(sourceId)) {
            wsg = new WSG(StringUtils.getBundleProperty("com.readersdigest.onepass.OnePassResources", "cdsIpadAppId"), StringUtils.getBundleProperty(
                    "com.readersdigest.onepass.OnePassResources", "cdsIpadPassword"), prodAbbr);
        } else {
            wsg = new WSG(StringUtils.getBundleProperty("com.readersdigest.onepass.OnePassResources", "cdsKindleAppId"), StringUtils.getBundleProperty(
                    "com.readersdigest.onepass.OnePassResources", "cdsKindlePassword"), prodAbbr);
        }
        
        try {

//            List<MemberOnePassInfo> memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "accountNumber", "active",
//                    emailAddress.trim(), prodAbbr, accountNumber, ACTIVE_MEMBER);

//            if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
                wsgr = wsg.lookupCustomer(accountNumber);
                if (wsgr.isSuccess()) {
                    customer = (Customer) wsgr.getObjects().get(0);
                    customer.setEmail(emailAddress);
                    wsgr = wsg.updateCustomer(customer);
                    if (wsgr.isSuccess()) {
                        EntityManagerHelper.log("CDS Updated: ", Level.INFO, null);
                        isUpdated = true;
                    }
                }
//            }
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        return isUpdated;
    }


    /**
     * Gets the bundle string value.
     * 
     * @param key
     *            the key
     * @return the bundle string value
     */
    public static String getBundleStringValue(String key) {
        return StringUtils.getBundleProperty("com.readersdigest.onepass.OnePassResources", key);
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.readersdigest.onepass.service.OnePassService#resetForgetPasswordToken(java.lang.String)
     */
    public OnePassServiceResponse resetForgetPasswordToken(String emailAddress, String sourceId) {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.readersdigest.onepass.service.OnePassService#updateNewPassword(java.lang.String, java.lang.String)
     */
    public OnePassServiceResponse updateNewPassword(String token, String password, String sourceId) {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.readersdigest.onepass.service.OnePassService#renewAuthToken(java.lang.String, java.lang.String, java.lang.String)
     */
    public OnePassServiceAdobeResponse renewAuthToken(String authToken, String appId, String appVersion) {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.readersdigest.onepass.service.OnePassService#signInWithCredentials(java.lang.String, java.lang.String, java.lang.String, java.lang.String,
     * java.lang.String)
     */
    public OnePassServiceAdobeResponse signInWithCredentials(String emailAddress, String password, String appId, String appVersion, String uuid) {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.readersdigest.onepass.service.OnePassService#entitlements(java.lang.String, java.lang.String, java.lang.String)
     */
    public OnePassServiceAdobeResponse entitlements(String authToken, String appId, String appVersion) {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.readersdigest.onepass.service.OnePassService#verifyEntitlement(java.lang.String, java.lang.String, java.lang.String, java.lang.String)
     */
    public OnePassServiceAdobeEntitledVerifyResponse verifyEntitlement(String authToken, String productId, String appId, String appVersion) {
        return null;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.readersdigest.onepass.service.OnePassService#updateCDSUserPassword(java.lang.String, java.lang.String)
     */
    public OnePassServiceAdobeResponse updateCDSUserPassword(String emailAddress, String password, String accountNumber, String appId) {
        return null;
    }

    public OnePassServiceAdobeResponse getUserInfo(String userName, String appId) {
        return null;
    }

    public boolean updateEmailValidity(String token) {
        return false;
    }

    public OnePassServiceResponse updateValidEmailAddress(String accountNumber, String oldEmailAddress, String newEmailAddress, String password,
            String sourceId, String appId) {
        return null;
    }
    
    public OnePassServiceAdobeResponse validCDSEmailAddress(String emailAddress, String appId) {
        return null;
    }

}
