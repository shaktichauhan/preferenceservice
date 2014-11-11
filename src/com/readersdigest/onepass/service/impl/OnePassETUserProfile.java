package com.readersdigest.onepass.service.impl;

import java.util.List;
import java.util.logging.Level;

import com.readersdigest.exacttarget.client.ETExtensionServices;
import com.readersdigest.exacttarget.client.impl.ETExtensionServicesImpl;
import com.readersdigest.exacttarget.dto.ETResponse;
import com.readersdigest.exacttarget.dto.GetSubscriptionPreferencesRequest;
import com.readersdigest.exacttarget.dto.Preferences;
import com.readersdigest.onepass.db.EntityManagerHelper;
import com.readersdigest.onepass.db.IMemberOnePassInfoDAO;
import com.readersdigest.onepass.db.MemberOnePassInfo;
import com.readersdigest.onepass.db.MemberOnePassInfoDAO;
import com.readersdigest.onepass.exception.ServiceException;
import com.readersdigest.onepass.util.StringUtils;

/**
 *The Class OnePassUserProfile.
 *
 *@author shsingh
 *
 *        Class OnePassUserProfile contains methods to
 *        provide the user profile details
 */
public class OnePassETUserProfile {

        /**The memberOnePassInfoDAO. */
    private IMemberOnePassInfoDAO memberOnePassInfoDAO;
    
	private ETResponse etResponse;
    
    private MemberOnePassInfo memberOnePassInfo;
    
    /**The member. */
    private List<MemberOnePassInfo> memberOnePassInfoList;

    /**
     *Instantiates a new one pass user profile.
     */
    public OnePassETUserProfile() {
    }

    /**
     *Instantiates a new one pass user profile.
     *
     *@param emailAddress
     *           the email address
     *@param sourceId
     *           the source id
     */
    public OnePassETUserProfile(String emailAddress, String sourceId) {

        try {

            memberOnePassInfoDAO = new MemberOnePassInfoDAO();
             
   
            //EntityManagerHelper.beginTransaction();
            
            String prodAbbr = StringUtils.getProdIdBySource(sourceId);
            
            System.out.println("\n\n\n ******* emailAddress : " + emailAddress);
            try {
                
                long accountNumber = Long.parseLong(emailAddress.trim());
                String strAccountNumber = String.valueOf(accountNumber);
                int accountLength = strAccountNumber.length();
                for(int i=accountLength; i < 10; i++) {
                    strAccountNumber = "0" + strAccountNumber;
                }
                
             //   memberInfoList = memberInfoDAO.findByAccountNumber(strAccountNumber);
                memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("accountNumber", "prodId", "active",strAccountNumber, prodAbbr, OnePassServiceImpl.ACTIVE_MEMBER);

                
                if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
                    memberOnePassInfo = memberOnePassInfoDAO.refresh(memberOnePassInfoList.get(0));
                }
                
            } catch(Exception ex) {
                EntityManagerHelper.log("ERROR Check for Email Address ..", Level.INFO, null);
                
                memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active",emailAddress, prodAbbr, OnePassServiceImpl.ACTIVE_MEMBER);
             
                if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
                    memberOnePassInfo = memberOnePassInfoDAO.refresh(memberOnePassInfoList.get(0));
                } else {
                    emailAddress = updatedUserName(emailAddress, prodAbbr);
                    
                    memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active",emailAddress, prodAbbr, OnePassServiceImpl.ACTIVE_MEMBER);
                    
                    if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
                        memberOnePassInfo = memberOnePassInfoDAO.refresh(memberOnePassInfoList.get(0));
                    }
                  
                }
            }

            if(memberOnePassInfo != null) {
            	 GetSubscriptionPreferencesRequest subscriptionPreferences = new GetSubscriptionPreferencesRequest();
                 subscriptionPreferences.setEmailAddress(memberOnePassInfo.getEmailAddress());
                 
                 //get Brand name on the basis of siource id 
                 subscriptionPreferences.setBrand(StringUtils.getBrandName(sourceId));
                 ETExtensionServices eTExtensionServices = new ETExtensionServicesImpl();
                 etResponse = eTExtensionServices.getSubscriptionPreferences("onepass", subscriptionPreferences);
         		
         		System.out.println("\n\n **********  etResponse.getCode() : " + etResponse.getCode());
         		System.out.println("\n\n **********  etResponse.getDescription() : " + etResponse.getDescription());
         		
         		System.out.println("\n\n **********  etResponse.getDescription() : " + etResponse.getTransactionDate());
         		if(etResponse.getDetailedMessages() != null) {
         			for(int i=0; i<etResponse.getDetailedMessages().length; i++) {
         				System.out.println("\n\n **********  etResponse.getDetailedMessage " + i +": " + etResponse.getDetailedMessages()[i]);
         			}
         		}
         		
         		if(etResponse.getSubscriptionPreferences() != null && etResponse.getSubscriptionPreferences().size()>0) {
         			for(int i=0; i<etResponse.getSubscriptionPreferences().size(); i++) {
         				Preferences pre = etResponse.getSubscriptionPreferences().get(i);
         				System.out.println("\n\n **********  pre.getLastPromotionKey() " + i +": " +pre.getLastPromotionKey());
         				System.out.println("\n\n **********  pre.getLastActivityDate() " + i +": " +pre.getLastActivityDate());
         				System.out.println("\n\n **********  pre.getSubscriptionId() " + i +": " +pre.getSubscriptionId());
         				System.out.println("\n\n **********  pre.getLastSource() " + i +": " +pre.getLastSource());
         			}
         		}
                 
            }
           
            EntityManagerHelper.log("End OnePassServiceImpl.createUserProfileInfo() ..", Level.INFO, null);
        } catch (ServiceException ex) {
            //EntityManagerHelper.rollback();
            EntityManagerHelper.log("Error OnePassServiceImpl.createUserProfileInfo() ..", Level.ALL, ex);
            ex.printStackTrace();

        } catch (Exception ex) {
            //EntityManagerHelper.rollback();
            EntityManagerHelper.log("Error OnePassServiceImpl.createUserProfileInfo() ..", Level.ALL, ex);
            ex.printStackTrace();

        }

    }
    
    public String updatedUserName(String userName, String prodAbbr) {
        
         List<MemberOnePassInfo> memberOnePassInfoList = null;
         
         memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active",userName.trim(), prodAbbr, OnePassServiceImpl.INACTIVE_MEMBER);
         
         try {
             if(memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
                 for(MemberOnePassInfo memberOnePassInfo : memberOnePassInfoList) {
                    // MemberOnePassInfo memberOnePassInfo = memberOnePassInfoList.get(0); // latest inactive user email address
                     memberOnePassInfo = memberOnePassInfoDAO.refresh(memberOnePassInfo);
                     Integer memberReferenceId = memberOnePassInfo.getMemberOnePassInfoId();
      
                     boolean loopFlag = true;
                     int counter = 0; // for prevention of indefinite loop in any case
                     do
                     {
                         System.out.println("\n\n\n ****** memberReferenceId " + memberReferenceId);
                         List<MemberOnePassInfo> loMemberOnePassInfoList = memberOnePassInfoDAO.findByProperties("memberOnePassRefId", "prodId", memberReferenceId, prodAbbr);
                         if(loMemberOnePassInfoList != null && loMemberOnePassInfoList.size() > 0) {
                             if(OnePassServiceImpl.ACTIVE_MEMBER.equals(loMemberOnePassInfoList.get(0).getActive())) {
                                 return loMemberOnePassInfoList.get(0).getEmailAddress();
                             } else {
                                   memberReferenceId = loMemberOnePassInfoList.get(0).getMemberOnePassInfoId();
                             }
                         } else {
                             loopFlag = false;
                         }
                         
                         counter = counter + 1;
                         
                     } while (loopFlag && counter < 20);
                 }
             }
         } catch (Exception e) {
             // TODO Auto-generated catch block
             e.printStackTrace();
             return userName.trim();
         }
         return userName.trim();
     }

    
    public ETResponse getEtResponse() {
			return etResponse;
		}

		public void setEtResponse(ETResponse etResponse) {
			this.etResponse = etResponse;
		}

		public MemberOnePassInfo getMemberOnePassInfo() {
			return memberOnePassInfo;
		}

		public void setMemberOnePassInfo(MemberOnePassInfo memberOnePassInfo) {
			this.memberOnePassInfo = memberOnePassInfo;
		}

    
}
