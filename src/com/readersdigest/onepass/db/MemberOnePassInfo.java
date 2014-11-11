package com.readersdigest.onepass.db;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * MemberInfo entity. @author shsingh - shakti_singh@consultant.rd.com
 */
@Entity
@Table(name = "member_onepass_info", schema = "dbo", catalog = "registration")
public class MemberOnePassInfo implements java.io.Serializable {

    // Fields
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    private Integer memberOnePassInfoId;

    private Member member;

    private String password;
    
    private String emailAddress;

    private String accountNumber;
    
    private String fullName;

    private String zipCode;

    private Timestamp createDate;

    private String prodId;
    
    private Integer memberOnePassRefId;
    
    private String active;

    private String userType;

    @Id
    @Column(name = "member_onepass_info_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getMemberOnePassInfoId() {
        return this.memberOnePassInfoId;
    }

    public void setMemberOnePassInfoId(Integer memberOnePassInfoId) {
        this.memberOnePassInfoId = memberOnePassInfoId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    public Member getMember() {
        return this.member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Column(name = "create_date", length = 23)
    public Timestamp getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    @Column(name = "email_address")
    public String getEmailAddress() {
        return emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Column(name = "account_number")
    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
    
    @Column(name = "full_name")
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }
    
    

    @Column(name = "zip_code")
    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    @Column(name = "prod_id")
    public String getProdId() {
        return prodId;
    }

    public void setProdId(String prodId) {
        this.prodId = prodId;
    }

    @Column(name = "user_type")
    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }
    
    @Column(name = "active")
    public String getActive() {
        return active;
    }

    public void setActive(String active) {
        this.active = active;
    }
    
    @Column(name = "member_onepass_ref_id")
    public Integer getMemberOnePassRefId() {
        return memberOnePassRefId;
    }

    public void setMemberOnePassRefId(Integer memberOnePassRefId) {
        this.memberOnePassRefId = memberOnePassRefId;
    }
    
}
