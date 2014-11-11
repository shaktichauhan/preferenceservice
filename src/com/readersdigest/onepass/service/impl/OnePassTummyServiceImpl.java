package com.readersdigest.onepass.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import java.util.logging.Level;

import com.readersdigest.exacttarget.client.ETExtensionServices;
import com.readersdigest.exacttarget.client.impl.ETExtensionServicesImpl;
import com.readersdigest.exacttarget.dto.DigitalProfile;
import com.readersdigest.exacttarget.dto.DigitalProfileWithSubscription;
import com.readersdigest.exacttarget.dto.ETResponse;
import com.readersdigest.exacttarget.dto.Preferences;
import com.readersdigest.exacttarget.dto.SubscriptionPreferences;
import com.readersdigest.onepass.db.Email;
import com.readersdigest.onepass.db.EmailAddressOptStatus;
import com.readersdigest.onepass.db.EmailAddressOptStatusDAO;
import com.readersdigest.onepass.db.EmailAddressOptStatusId;
import com.readersdigest.onepass.db.EmailDAO;
import com.readersdigest.onepass.db.EntityManagerHelper;
import com.readersdigest.onepass.db.IEmailAddressOptStatusDAO;
import com.readersdigest.onepass.db.IEmailDAO;
import com.readersdigest.onepass.db.IMemberDAO;
import com.readersdigest.onepass.db.IMemberOnePassInfoDAO;
import com.readersdigest.onepass.db.IMemberOnePassTummyDAO;
import com.readersdigest.onepass.db.IOptStatusTransactionDAO;
import com.readersdigest.onepass.db.ISourceDAO;
import com.readersdigest.onepass.db.ITummyDeviceDAO;
import com.readersdigest.onepass.db.IUserPreferenceDAO;
import com.readersdigest.onepass.db.Member;
import com.readersdigest.onepass.db.MemberDAO;
import com.readersdigest.onepass.db.MemberOnePassInfo;
import com.readersdigest.onepass.db.MemberOnePassInfoDAO;
import com.readersdigest.onepass.db.MemberOnePassTummy;
import com.readersdigest.onepass.db.MemberOnePassTummyDAO;
import com.readersdigest.onepass.db.OptStatus;
import com.readersdigest.onepass.db.OptStatusTransaction;
import com.readersdigest.onepass.db.OptStatusTransactionDAO;
import com.readersdigest.onepass.db.Source;
import com.readersdigest.onepass.db.SourceDAO;
import com.readersdigest.onepass.db.TummyAnswers;
import com.readersdigest.onepass.db.TummyDevice;
import com.readersdigest.onepass.db.TummyDeviceDAO;
import com.readersdigest.onepass.db.UserPreference;
import com.readersdigest.onepass.db.UserPreferenceDAO;
import com.readersdigest.onepass.dto.AccountDTO;
import com.readersdigest.onepass.dto.CreateOnePassUserProfileDTO;
import com.readersdigest.onepass.dto.EmailDTO;
import com.readersdigest.onepass.dto.HeaderDTO;
import com.readersdigest.onepass.dto.OnePassServiceResponse;
import com.readersdigest.onepass.dto.OnePassTummyServiceResponse;
import com.readersdigest.onepass.dto.OnePassTummyUserProfileDTO;
import com.readersdigest.onepass.dto.PreferenceDTO;
import com.readersdigest.onepass.dto.SurveyFieldDTO;
import com.readersdigest.onepass.dto.UpdateOnePassUserProfileDTO;
import com.readersdigest.onepass.exception.ServiceException;
import com.readersdigest.onepass.service.OnePassTummyService;
import com.readersdigest.onepass.util.StringUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class OnePassTummyServiceImpl.
 * 
 * @author shsingh
 * 
 */

public class OnePassTummyServiceImpl implements OnePassTummyService {

    /** The member dao. */
    private IMemberDAO memberDAO;

    /** The email dao. */
    private IEmailDAO emailDAO;

    /** The member one pass info dao. */
    private IMemberOnePassInfoDAO memberOnePassInfoDAO;

    /** The member one pass tummy dao. */
    private IMemberOnePassTummyDAO memberOnePassTummyDAO;

    /** The tummy device dao. */
    private ITummyDeviceDAO tummyDeviceDAO;

    /** The opt status transaction dao. */
    private IOptStatusTransactionDAO optStatusTransactionDAO;

    /** The source dao. */
    private ISourceDAO sourceDAO;

    /** The user preference dao. */
    private IUserPreferenceDAO userPreferenceDAO;

    /** The email address opt status dao. */
    private IEmailAddressOptStatusDAO emailAddressOptStatusDAO;

    /** The Constant ACTIVE_MEMBER. */
    public static final String ACTIVE_MEMBER = "A";

    /** The Constant INACTIVE_MEMBER. */
    public static final String INACTIVE_MEMBER = "I";

    /**
     * The Constructor.
     */
    public OnePassTummyServiceImpl() {
        memberDAO = new MemberDAO();
        emailDAO = new EmailDAO();
        memberOnePassInfoDAO = new MemberOnePassInfoDAO();
        memberOnePassTummyDAO = new MemberOnePassTummyDAO();
        emailAddressOptStatusDAO = new EmailAddressOptStatusDAO();
        tummyDeviceDAO = new TummyDeviceDAO();
        sourceDAO = new SourceDAO();
        optStatusTransactionDAO = new OptStatusTransactionDAO();
        userPreferenceDAO = new UserPreferenceDAO();
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.readersdigest.onepass.service.OnePassTummyService#authenticationBHEorder(java.lang.String, java.lang.String)
     */
    public OnePassTummyServiceResponse authenticationBHEorder(String emailAddress, String deviceId, String appId) {

        OnePassTummyServiceResponse response = new OnePassTummyServiceResponse();
        List<MemberOnePassInfo> memberOnePassInfoList = null;

        try {

            try {
                new ServiceValidator().validEmail(emailAddress);
            } catch (ServiceException e) {
                response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
                response.paidUser = "N";
                response.status = getBundleStringValue("transactionFailed");
                response.responseText = e.getMessage();
                return response;
            }

            if (deviceId == null || "".equals(deviceId)) {
                deviceId = getBundleStringValue("tummy_default_device");
            }

            System.out.println("\n\n ******* app Id " + appId);
            if(appId != null && getBundleStringValue("diy_prodAbbr").equalsIgnoreCase(appId)) {
               	 memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active", emailAddress.trim(), getBundleStringValue("diy_prodAbbr"), ACTIVE_MEMBER);
            	 if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
                     MemberOnePassInfo memberOnePassInfo = memberOnePassInfoList.get(0);
                     memberOnePassInfo = memberOnePassInfoDAO.refresh(memberOnePassInfo);
                     if (getBundleStringValue("diy_paid_usertype").equalsIgnoreCase(memberOnePassInfo.getUserType())) {
                    	 response.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
                         response.paidUser = "Y";
                         response.status = getBundleStringValue("transactionSuccess");
                         response.responseText = getBundleStringValue("transactionSuccessMessage");
                     } else {
                    	 response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
                         response.paidUser = "N";
                         response.status = getBundleStringValue("transactionFailed");
                         response.responseText = StringUtils.getBundleProperty("emailAddress.nonpurchase.user");
                     }
            	 } else {
            		 response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
                     response.paidUser = "N";
                     response.status = getBundleStringValue("transactionFailed");
                     response.responseText = StringUtils.getBundleProperty("emailAddress.nonpurchase.user");
            	 }
            	 
            	 return response;
            }
            
            EntityManagerHelper.beginTransaction();
            String prodAbbr = getBundleStringValue("tummy_prodAbbr");
            String tummy_device_limit = getBundleStringValue("tummy_user_device_limit");

            memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active", emailAddress.trim(), prodAbbr, ACTIVE_MEMBER);
            if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
                MemberOnePassInfo memberOnePassInfo = memberOnePassInfoList.get(0);
                memberOnePassInfo = memberOnePassInfoDAO.refresh(memberOnePassInfo);

                if (getBundleStringValue("tummy_paid_usertype").equalsIgnoreCase(memberOnePassInfo.getUserType())) {
                    List<TummyDevice> tummyDeviceList = tummyDeviceDAO.findByProperty("memberOnePassInfo.memberOnePassInfoId",
                            memberOnePassInfo.getMemberOnePassInfoId());
                    if (tummyDeviceList != null) {
                        boolean createFlag = true;
                        for (TummyDevice tummyDevice : tummyDeviceList) {
                            if (deviceId.equals(tummyDevice.getDeviceId())) {
                                createFlag = false;
                                break;
                            }
                        }

                        System.out.println("\n\n\n ********tummyDeviceList.size() " + tummyDeviceList.size());
                        if (createFlag) {
                            if (tummyDeviceList.size() >= Integer.parseInt(tummy_device_limit)) {
                                response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
                                response.paidUser = "N";
                                response.status = getBundleStringValue("transactionFailed");
                                response.responseText = StringUtils.getBundleProperty("emailAddress.excessDevices");
                            } else {
                                TummyDevice tummyDevice = new TummyDevice();
                                tummyDevice.setMemberOnePassInfo(memberOnePassInfo);
                                tummyDevice.setDeviceId(deviceId);
                                tummyDeviceDAO.save(tummyDevice);
                                response.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
                                response.paidUser = "Y";
                                response.status = getBundleStringValue("transactionSuccess");
                                response.responseText = getBundleStringValue("transactionSuccessMessage");
                            }
                        } else {
                            response.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
                            response.paidUser = "Y";
                            response.status = getBundleStringValue("transactionSuccess");
                            response.responseText = getBundleStringValue("transactionSuccessMessage");
                        }

                    } else {
                        TummyDevice tummyDevice = new TummyDevice();
                        tummyDevice.setMemberOnePassInfo(memberOnePassInfo);
                        tummyDevice.setDeviceId(deviceId);
                        tummyDeviceDAO.save(tummyDevice);
                        response.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
                        response.paidUser = "Y";
                        response.status = getBundleStringValue("transactionSuccess");
                        response.responseText = getBundleStringValue("transactionSuccessMessage");
                    }

                } else {
                    response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
                    response.paidUser = "N";
                    response.status = getBundleStringValue("transactionFailed");
                    response.responseText = StringUtils.getBundleProperty("emailAddress.nonpurchase.user");
                }

            } else {
                response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
                response.paidUser = "N";
                response.status = getBundleStringValue("transactionFailed");
                response.responseText = StringUtils.getBundleProperty("emailAddress.notRegistered");
            }

            EntityManagerHelper.commit();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            EntityManagerHelper.rollback();
            response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
            response.paidUser = "N";
            response.responseText = e.getMessage();
            e.printStackTrace();
        } finally {
            EntityManagerHelper.clear();
            EntityManagerHelper.closeEntityManager();
        }

        return response;
    }

    /*
     * (non-Javadoc)
     * 
     * @see com.readersdigest.onepass.service.OnePassTummyService#tummyOnePassProfile(com.readersdigest.onepass.dto.OnePassTummyUserProfileDTO)
     */
    public OnePassTummyServiceResponse tummyOnePassProfile(OnePassTummyUserProfileDTO dto) {
        OnePassTummyServiceResponse response = new OnePassTummyServiceResponse();

        try {

            try {
                new ServiceValidator().validTummyService(dto);
            } catch (ServiceException e) {
                response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
                response.status = getBundleStringValue("transactionFailed");
                response.responseText = e.getMessage();
                return response;
            }

            EntityManagerHelper.beginTransaction();

            String prodAbbr = getBundleStringValue("tummy_prodAbbr");

            Timestamp timeStamp = new Timestamp(System.currentTimeMillis());

            Member member = null;
            List<Member> memberList = memberDAO.findByMemberName(dto.emailFields.emailAddress.trim());
            if (memberList != null && memberList.size() > 0) {
                member = memberList.get(0);
          //      member.setMemberName(UUID.randomUUID().getMostSignificantBits() + ":" + dto.emailFields.emailAddress.trim());
            } else {
                member = new Member();
                member.setMemberName(dto.emailFields.emailAddress.trim());
                memberDAO.save(member);
            }

            List<Email> emailList = emailDAO.findByEmailAddress(dto.emailFields.emailAddress.trim());

            Email email = null;

            if (emailList != null && emailList.size() > 0) {
                email = emailDAO.findByEmailAddress(dto.emailFields.emailAddress.trim()).get(0);
            }

            if (email != null) {
                if (email.getMember() == null) {
                    email.setMember(member);
                    email.setEmailTypeId(OnePassServiceImpl.EMAIL_PRIMARY_ID);
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
                email.setEmailTypeId(OnePassServiceImpl.EMAIL_PRIMARY_ID);
                email.setEffectiveDate(timeStamp);
                emailDAO.save(email);
            }

            MemberOnePassInfo memberOnePassInfo = null;

            List<MemberOnePassInfo> memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active",
                    dto.emailFields.emailAddress.trim(), prodAbbr, ACTIVE_MEMBER);

            if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
            	memberOnePassInfo = memberOnePassInfoList.get(0);
                if(dto.accountFields != null && dto.accountFields.paidUser != null &&
                        "Y".equalsIgnoreCase(dto.accountFields.paidUser)) {
                	System.out.println("\n\n\n ************ Tumy Paid for existing users");
                    memberOnePassInfo.setUserType(getBundleStringValue("tummy_paid_usertype"));
                    memberOnePassInfoDAO.update(memberOnePassInfo);
                } 
            } else {
                memberOnePassInfo = new MemberOnePassInfo();

                memberOnePassInfo.setMember(member);
                memberOnePassInfo.setActive(ACTIVE_MEMBER);
                memberOnePassInfo.setEmailAddress(dto.emailFields.emailAddress.trim());
                memberOnePassInfo.setProdId(prodAbbr);
                if(dto.accountFields != null && dto.accountFields.paidUser != null &&
                        "Y".equalsIgnoreCase(dto.accountFields.paidUser)) {
                    memberOnePassInfo.setUserType(getBundleStringValue("tummy_paid_usertype"));
                } else {
                    memberOnePassInfo.setUserType(getBundleStringValue("tummy_unpaid_usertype"));
                }
                
                if(dto.addressFields != null) {
                    if(dto.addressFields.firstName != null && !"".equals(dto.addressFields.firstName.trim())) {
                        String customerName = dto.addressFields.firstName.trim();
                        if(dto.addressFields.lastName != null && !"".equals(dto.addressFields.lastName.trim())) {
                            customerName = customerName + " " + dto.addressFields.lastName.trim();
                        }
                        memberOnePassInfo.setFullName(customerName);
                    }
                }
                
                memberOnePassInfo.setCreateDate(timeStamp);
                memberOnePassInfoDAO.save(memberOnePassInfo);

            }

            MemberOnePassTummy memberOnePassTummy = new MemberOnePassTummy();
            memberOnePassTummy.setMemberOnePassInfo(memberOnePassInfo);
            memberOnePassTummy.setCreateDate(timeStamp);
            memberOnePassTummy.setWeight(dto.weight);
            Set<TummyAnswers> tummyAnswerSet = new HashSet<TummyAnswers>();

            if(dto.surveyFields != null) {
                Iterator<SurveyFieldDTO> iterator = dto.surveyFields.iterator();
                while (iterator.hasNext()) {
                    SurveyFieldDTO surveyDTO = iterator.next();
                    TummyAnswers tummyAnswer = new TummyAnswers();
                    tummyAnswer.setMemberOnePassTummy(memberOnePassTummy);
                    tummyAnswer.setQuestionId(Integer.parseInt(surveyDTO.questionId));
                    tummyAnswer.setAnswer(surveyDTO.answer);
                    tummyAnswer.setCreateDate(timeStamp);
                    tummyAnswerSet.add(tummyAnswer);
                }
            }

            memberOnePassTummy.setTummyAnswerses(tummyAnswerSet);
            memberOnePassTummyDAO.save(memberOnePassTummy);

            OptStatusTransaction optStatusTransaction = new OptStatusTransaction();
            optStatusTransaction.setEmail(email);
            optStatusTransaction.setCreateDate(timeStamp);

            Source source = sourceDAO.findById(Integer.parseInt(dto.accountFields.sourceId));

            if (source != null) {
                optStatusTransaction.setSource(source);
            }

            optStatusTransaction.setTrackingId(dto.accountFields.trackingId);

            optStatusTransactionDAO.save(optStatusTransaction);

            EntityManagerHelper.flush();

            try {
                Set<EmailAddressOptStatus> emailAddressOptStatuses = createEmailAddressOptStatus(optStatusTransaction, dto);

                optStatusTransaction.setEmailAddressOptStatuses(emailAddressOptStatuses);

                member.setOptStatusTransaction(optStatusTransaction);
                optStatusTransactionDAO.update(optStatusTransaction);

            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            if(StringUtils.isPreAndETUpdate()) {
            	DigitalProfile profile = new DigitalProfile();

         		profile.setLastUpdateDate(String.valueOf(System.currentTimeMillis()));//please use time miles in long and pass as a String
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
             		// hard coded condition coz.. the app is already live
             		
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

            response.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
            response.status = getBundleStringValue("transactionSuccess");
            response.responseText = getBundleStringValue("transactionSuccessMessage");
            if(getBundleStringValue("tummy_paid_usertype").equalsIgnoreCase(memberOnePassInfo.getUserType())) {
                response.paidUser = "Y";
            } else {
                response.paidUser = "N";
            }
    
            EntityManagerHelper.commit();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            EntityManagerHelper.rollback();
            response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
            response.status = getBundleStringValue("transactionFailed");
            response.responseText = e.getMessage();
            e.printStackTrace();
        } finally {
            EntityManagerHelper.clear();
            EntityManagerHelper.closeEntityManager();
        }

        return response;
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
    private Set<EmailAddressOptStatus> createEmailAddressOptStatus(OptStatusTransaction optStatusTransaction, OnePassTummyUserProfileDTO dto)
            throws ServiceException {

        EntityManagerHelper.log("Start OnePassTummyServiceImpl.createEmailAddressOptStatus() ..", Level.INFO, null);

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
                        optStatus.setOptStatusId(OnePassServiceImpl.OPT_PREFERS);
                    } else {
                        optStatus.setOptStatusId(OnePassServiceImpl.OPT_PREFERS_NOT);
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

    /*
     * (non-Javadoc)
     * 
     * @see com.readersdigest.onepass.service.OnePassTummyService#createOnePassBHEUser(java.lang.String)
     */
    public OnePassTummyServiceResponse createOnePassBHEUser(String emailAddress, String appId) {
        OnePassTummyServiceResponse response = new OnePassTummyServiceResponse();

        try {

            try {
                new ServiceValidator().validEmail(emailAddress);
            } catch (ServiceException e) {
                response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
                response.status = getBundleStringValue("transactionFailed");

                response.responseText = e.getMessage();
                return response;
            }

            EntityManagerHelper.beginTransaction();
            String prodAbbr = "";
            String usertype = "";
           
            if(appId != null && getBundleStringValue("diy_prodAbbr").equalsIgnoreCase(appId)) {
            	prodAbbr = getBundleStringValue("diy_prodAbbr");
            	usertype = getBundleStringValue("diy_paid_usertype");
            } else {
            	prodAbbr = getBundleStringValue("tummy_prodAbbr");;
            	usertype = getBundleStringValue("tummy_paid_usertype");
            }
            		

            Timestamp timeStamp = new Timestamp(System.currentTimeMillis());

            Member member = new Member();

            if (memberDAO.findByMemberName(emailAddress).size() > 0) {
                member.setMemberName(UUID.randomUUID().getMostSignificantBits() + ":" + emailAddress.trim());
            } else {
                member.setMemberName(emailAddress);
            }

            memberDAO.save(member);

            List<Email> emailList = emailDAO.findByEmailAddress(emailAddress.trim());

            Email email = null;

            if (emailList != null && emailList.size() > 0) {
                email = emailDAO.findByEmailAddress(emailAddress.trim()).get(0);
            }

            if (email != null) {
                if (email.getMember() == null) {
                    email.setMember(member);
                    email.setEmailTypeId(OnePassServiceImpl.EMAIL_PRIMARY_ID);
                    email.setEffectiveDate(timeStamp);
                    email.setNonMemberProfile(null);
                } else {
                    member = email.getMember();
                }

                emailDAO.update(email);
            } else {
                email = new Email();
                email.setMember(member);
                email.setEmailAddress(emailAddress.trim());
                email.setEmailTypeId(OnePassServiceImpl.EMAIL_PRIMARY_ID);
                email.setEffectiveDate(timeStamp);
                emailDAO.save(email);
            }

            MemberOnePassInfo memberOnePassInfo = null;

            List<MemberOnePassInfo> memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active", emailAddress.trim(),
                    prodAbbr, ACTIVE_MEMBER);

            if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
                memberOnePassInfo = memberOnePassInfoList.get(0);
                memberOnePassInfo.setUserType(usertype);
                memberOnePassInfoDAO.update(memberOnePassInfo);
            } else {
                memberOnePassInfo = new MemberOnePassInfo();

                memberOnePassInfo.setMember(member);
                memberOnePassInfo.setActive(ACTIVE_MEMBER);
                memberOnePassInfo.setEmailAddress(emailAddress.trim());
                memberOnePassInfo.setProdId(prodAbbr);
                memberOnePassInfo.setUserType(usertype);
                memberOnePassInfo.setCreateDate(timeStamp);
                memberOnePassInfoDAO.save(memberOnePassInfo);

            }
            
            if(StringUtils.isPreAndETUpdate()) {
            	DigitalProfile profile = new DigitalProfile();
         		profile.setEmailAddress(emailAddress.trim());
         		
         		//String sourceName = StringUtils.getSourceName(dto.accountFields.sourceId);
         		//profile.setSource(sourceName); /// Set the Source Name
         	
         		
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

            response.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
            response.status = getBundleStringValue("transactionSuccess");
            response.responseText = getBundleStringValue("transactionSuccessMessage");

            EntityManagerHelper.commit();

        } catch (Exception e) {
            // TODO Auto-generated catch block
            EntityManagerHelper.rollback();
            response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
            response.status = getBundleStringValue("transactionFailed");
            response.responseText = e.getMessage();
            e.printStackTrace();
        } finally {
            EntityManagerHelper.clear();
            EntityManagerHelper.closeEntityManager();
        }

        return response;

    }
    
    public final OnePassTummyServiceResponse updateEmailAddress(String oldEmailAddress, String newEmailAddress,String sourceId, String appId) {

        OnePassServiceResponse serviceResponse = new OnePassServiceResponse();
        OnePassTummyServiceResponse response = new OnePassTummyServiceResponse();
        
        UpdateOnePassUserProfileDTO dto = new UpdateOnePassUserProfileDTO();
        dto.header = new HeaderDTO();
        dto.emailFields = new EmailDTO();
        dto.accountFields = new AccountDTO();
        dto.accountFields.preferenceFields = new HashSet<PreferenceDTO>();
        dto.header.emailAddress = oldEmailAddress;
        dto.emailFields.newEmailAddress = newEmailAddress;
        dto.accountFields.sourceId = sourceId;
      
        serviceResponse = new OnePassServiceImpl().updateEmailProfileInfo(dto);
        if(OnePassServiceImpl.TRANSACTION_SUCCESS.equalsIgnoreCase(serviceResponse.status)) {
            try {
                List<MemberOnePassInfo> memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active", newEmailAddress.trim(), appId, ACTIVE_MEMBER);
                
                if(memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
                    MemberOnePassInfo memberOnePassInfo = memberOnePassInfoList.get(0);
                    List<MemberOnePassInfo> oldMemberOnePassInfoList = memberOnePassInfoDAO.findByProperties("memberOnePassInfoId", "prodId", memberOnePassInfo.getMemberOnePassRefId(), appId);
                    
                    if(oldMemberOnePassInfoList != null && oldMemberOnePassInfoList.size() > 0) {
                        MemberOnePassInfo oldMemberOnePassInfo = oldMemberOnePassInfoList.get(0);
                        List<MemberOnePassTummy> memberOnePassTummyList = memberOnePassTummyDAO.findByProperty("memberOnePassInfo.memberOnePassInfoId", oldMemberOnePassInfo.getMemberOnePassInfoId());
                        if(memberOnePassTummyList != null && memberOnePassTummyList.size() > 0) {
                            try {
                                EntityManagerHelper.beginTransaction();
                                MemberOnePassTummy memberOnePassTummy = memberOnePassTummyList.get(0);
                                memberOnePassTummy.setMemberOnePassInfo(memberOnePassInfo);
                                memberOnePassTummyDAO.update(memberOnePassTummy);
                                EntityManagerHelper.commit();
                            } catch (Exception e) {
                                // TODO Auto-generated catch block
                                e.printStackTrace();
                                EntityManagerHelper.rollback();
                              
                            } finally {
                                EntityManagerHelper.clear();
                                EntityManagerHelper.closeEntityManager();
                            }
                        }
                    }
                }
            } catch (Exception e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            
            response.httpResponseCode = getBundleStringValue("serviceSuccessStatusCode");
            response.status = getBundleStringValue("transactionSuccess");
            response.responseText = getBundleStringValue("transactionSuccessMessage");
            
        } else {
            response.httpResponseCode = getBundleStringValue("serviceFailedStatusCode");
            response.status = getBundleStringValue("transactionFailed");
            response.responseText = serviceResponse.responseText;
        }
        
        
   
        return response;

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

}
