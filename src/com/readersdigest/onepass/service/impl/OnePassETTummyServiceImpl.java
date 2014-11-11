package com.readersdigest.onepass.service.impl;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.UUID;

import com.readersdigest.exacttarget.client.ETExtensionServices;
import com.readersdigest.exacttarget.client.impl.ETExtensionServicesImpl;
import com.readersdigest.exacttarget.dto.DigitalProfile;
import com.readersdigest.exacttarget.dto.DigitalProfileWithSubscription;
import com.readersdigest.exacttarget.dto.ETResponse;
import com.readersdigest.exacttarget.dto.Preferences;
import com.readersdigest.exacttarget.dto.SubscriptionPreferences;
import com.readersdigest.onepass.db.EntityManagerHelper;
import com.readersdigest.onepass.db.IMemberDAO;
import com.readersdigest.onepass.db.IMemberOnePassInfoDAO;
import com.readersdigest.onepass.db.IMemberOnePassTummyDAO;
import com.readersdigest.onepass.db.Member;
import com.readersdigest.onepass.db.MemberDAO;
import com.readersdigest.onepass.db.MemberOnePassInfo;
import com.readersdigest.onepass.db.MemberOnePassInfoDAO;
import com.readersdigest.onepass.db.MemberOnePassTummy;
import com.readersdigest.onepass.db.MemberOnePassTummyDAO;
import com.readersdigest.onepass.db.TummyAnswers;
import com.readersdigest.onepass.dto.OnePassTummyServiceResponse;
import com.readersdigest.onepass.dto.OnePassTummyUserProfileDTO;
import com.readersdigest.onepass.dto.PreferenceDTO;
import com.readersdigest.onepass.dto.SurveyFieldDTO;
import com.readersdigest.onepass.exception.ServiceException;
import com.readersdigest.onepass.util.StringUtils;

// TODO: Auto-generated Javadoc
/**
 * The Class OnePassTummyServiceImpl.
 * 
 * @author shsingh
 * 
 */

public class OnePassETTummyServiceImpl extends OnePassTummyServiceImpl {

    /** The member dao. */
    private IMemberDAO memberDAO;


    /** The member one pass info dao. */
    private IMemberOnePassInfoDAO memberOnePassInfoDAO;

    /** The member one pass tummy dao. */
    private IMemberOnePassTummyDAO memberOnePassTummyDAO;



    /** The Constant ACTIVE_MEMBER. */
    public static final String ACTIVE_MEMBER = "A";

    /** The Constant INACTIVE_MEMBER. */
    public static final String INACTIVE_MEMBER = "I";

    /**
     * The Constructor.
     */
    public OnePassETTummyServiceImpl() {
        memberDAO = new MemberDAO();
        memberOnePassInfoDAO = new MemberOnePassInfoDAO();
        memberOnePassTummyDAO = new MemberOnePassTummyDAO();

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
        		if("10125".equalsIgnoreCase(preferenceDTO.preferenceId)) {
        			pre.setSubscriptionId("9"); //only for 21 day tummy app
        		} else{
        			pre.setSubscriptionId(preferenceDTO.preferenceId);
        		}
        		
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
