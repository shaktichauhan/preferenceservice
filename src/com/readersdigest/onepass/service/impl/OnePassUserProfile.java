package com.readersdigest.onepass.service.impl;

import java.util.List;
import java.util.logging.Level;

import com.readersdigest.onepass.db.Email;
import com.readersdigest.onepass.db.EmailDAO;
import com.readersdigest.onepass.db.EntityManagerHelper;
import com.readersdigest.onepass.db.IEmailDAO;
import com.readersdigest.onepass.db.IMemberDAO;
import com.readersdigest.onepass.db.IMemberInfoDAO;
import com.readersdigest.onepass.db.IMemberOnePassInfoDAO;
import com.readersdigest.onepass.db.IOptStatusTransactionDAO;
import com.readersdigest.onepass.db.IPostalAddressDAO;
import com.readersdigest.onepass.db.ISourceDAO;
import com.readersdigest.onepass.db.Member;
import com.readersdigest.onepass.db.MemberDAO;
import com.readersdigest.onepass.db.MemberInfo;
import com.readersdigest.onepass.db.MemberInfoDAO;
import com.readersdigest.onepass.db.MemberOnePassInfo;
import com.readersdigest.onepass.db.MemberOnePassInfoDAO;
import com.readersdigest.onepass.db.OptStatusTransaction;
import com.readersdigest.onepass.db.OptStatusTransactionDAO;
import com.readersdigest.onepass.db.PostalAddress;
import com.readersdigest.onepass.db.PostalAddressDAO;
import com.readersdigest.onepass.db.Source;
import com.readersdigest.onepass.db.SourceDAO;
import com.readersdigest.onepass.exception.ServiceException;
import com.readersdigest.onepass.service.OnePassService;
import com.readersdigest.onepass.util.StringUtils;

/**
 *The Class OnePassUserProfile.
 *
 *@author shsingh
 *
 *        Class OnePassUserProfile contains methods to
 *        provide the user profile details
 */
public class OnePassUserProfile {

    /**The member dao. */
    private IMemberDAO memberDAO;

    /**The address dao. */
    private IPostalAddressDAO addressDAO;

    /**The email dao. */
    private IEmailDAO emailDAO;

    /**The opt status transaction dao. */
    private IOptStatusTransactionDAO optStatusTransactionDAO;

    /**The source dao. */
    private ISourceDAO sourceDAO;
    
    /**The memberInfoDAO. */
    private IMemberInfoDAO memberInfoDAO;
    
    /**The memberOnePassInfoDAO. */
    private IMemberOnePassInfoDAO memberOnePassInfoDAO;

    /**The member. */
    private Member member;
    
    /**The member. */
    private List<MemberInfo> memberInfoList;
    
    /**The member. */
    private List<MemberOnePassInfo> memberOnePassInfoList;

    /**The address. */
    private PostalAddress address;

    /**The email. */
    private Email email;

    /**The opt status transaction. */
    private OptStatusTransaction optStatusTransaction;

    /**
     *Instantiates a new one pass user profile.
     */
    public OnePassUserProfile() {
    }

    /**
     *Instantiates a new one pass user profile.
     *
     *@param emailAddress
     *           the email address
     *@param sourceId
     *           the source id
     */
    public OnePassUserProfile(String emailAddress, String sourceId) {

        try {

            memberDAO = new MemberDAO();
            addressDAO = new PostalAddressDAO();
            emailDAO = new EmailDAO();
            sourceDAO = new SourceDAO();
            memberInfoDAO = new MemberInfoDAO();
            memberOnePassInfoDAO = new MemberOnePassInfoDAO();
             
            optStatusTransactionDAO = new OptStatusTransactionDAO();
            List<Email> emailList = null;
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
                    MemberOnePassInfo memberOnePassInfo = memberOnePassInfoDAO.refresh(memberOnePassInfoList.get(0));
                    member = memberOnePassInfo.getMember();
                    email = emailDAO.findByEmailAddress(memberOnePassInfo.getEmailAddress()).get(0);
                    
//                    for (MemberInfo memberInfo : memberInfoList) {
//                        memberInfo = memberInfoDAO.refresh(memberInfo);
//                        if ("CDS".equals(memberInfo.getDiscussionAlias())) {
//                            emailList = emailDAO.findByMemberId(memberInfo.getMember().getMemberId());
//                            if (emailList != null && emailList.size() > 0) {
//                                for(Email tEmail : emailList) {
//                                    tEmail = emailDAO.refresh(tEmail);
//                                    if (tEmail.getEmailTypeId().intValue() == OnePassServiceImpl.EMAIL_PRIMARY_ID) {
//                                        member = tEmail.getMember();
//                                        email = tEmail;
//                                        break;
//                                    }
//                                }
//                            } 
//                        }
//                    }
                }
                
            } catch(Exception ex) {
                EntityManagerHelper.log("ERROR Check for Email Address ..", Level.INFO, null);
                
                memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active",emailAddress, prodAbbr, OnePassServiceImpl.ACTIVE_MEMBER);
             
                if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
                    MemberOnePassInfo memberOnePassInfo = memberOnePassInfoDAO.refresh(memberOnePassInfoList.get(0));
                    member = memberOnePassInfo.getMember();
                    email = emailDAO.findByEmailAddress(memberOnePassInfo.getEmailAddress()).get(0);
                } else {
                    emailAddress = updatedUserName(emailAddress, prodAbbr);
                    
                    memberOnePassInfoList = memberOnePassInfoDAO.findByProperties("emailAddress", "prodId", "active",emailAddress, prodAbbr, OnePassServiceImpl.ACTIVE_MEMBER);
                    
                    if (memberOnePassInfoList != null && memberOnePassInfoList.size() > 0) {
                        MemberOnePassInfo memberOnePassInfo = memberOnePassInfoDAO.refresh(memberOnePassInfoList.get(0));
                        member = memberOnePassInfo.getMember();
                        email = emailDAO.findByEmailAddress(memberOnePassInfo.getEmailAddress()).get(0);
                    }
                  
                }
            }

            System.out.println("\n\n\n ******emailAddress member : " + member);
            if(member != null) {
         
                List<PostalAddress> listAddress = addressDAO.findByProperty("member", member);
                
//                if(memberInfoList == null || memberInfoList.size() == 0){
//                    memberInfoList = memberInfoDAO.findByMemberId(member.getMemberId());
//                }
                
                if (listAddress != null && listAddress.size() > 0 ) {
                    address = listAddress.get(0);
                }
                System.out.println("\n\n\n ******address : " + address);
                System.out.println("\n\n\n ******email : " + email);
                
                if (email != null) {
                    if(sourceId != null && !"".equalsIgnoreCase(sourceId.trim())) {
                        Source source = sourceDAO.findById(Integer.parseInt(sourceId));
                        List<OptStatusTransaction> listTransaction = optStatusTransactionDAO.findByProperties("email", "source", email, source);
                        if(listTransaction != null && listTransaction.size() > 0) {
                            optStatusTransaction = listTransaction.get(0);
                        }
                    }
                }
            }
           // EntityManagerHelper.commit();
 
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

    /**
     *Gets the member.
     *
     *@return the member
     */
    public final Member getMember() {
        return member;
    }

    /**
     *Sets the member.
     *
     *@param member
     *           the new member
     */
    public final void setMember(final Member member) {
        this.member = member;
    }

    /**
     *Gets the address.
     *
     *@return the address
     */
    public final PostalAddress getAddress() {
        return address;
    }

    /**
     *Sets the address.
     *
     *@param address
     *           the new address
     */
    public final void setAddress(final PostalAddress address) {
        this.address = address;
    }

    /**
     *Gets the email.
     *
     *@return the email
     */
    public final Email getEmail() {
        return email;
    }

    /**
     *Sets the email.
     *
     *@param email
     *           the new email
     */
    public final void setEmail(final Email email) {
        this.email = email;
    }

    /**
     *Gets the opt status transaction.
     *
     *@return the opt status transaction
     */
    public final OptStatusTransaction getOptStatusTransaction() {
        return optStatusTransaction;
    }

    /**
     *Sets the opt status transaction.
     *
     *@param optStatusTransaction
     *           the new opt status transaction
     */
    public final void setOptStatusTransaction(final OptStatusTransaction optStatusTransaction) {
        this.optStatusTransaction = optStatusTransaction;
    }


    public final List<MemberInfo> getMemberInfoList() {
        return memberInfoList;
    }

    public  final void setMemberInfoList(List<MemberInfo> memberInfoList) {
        this.memberInfoList = memberInfoList;
    }
    
    public final List<MemberOnePassInfo> getMemberOnePassInfoList() {
        return memberOnePassInfoList;
    }

    public  final void setMemberOnePassInfoList(List<MemberOnePassInfo> memberOnePassInfoList) {
        this.memberOnePassInfoList = memberOnePassInfoList;
    }
    
    
}
