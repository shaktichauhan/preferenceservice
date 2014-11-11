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
@Table(name = "member_info", schema = "dbo", catalog = "registration")
public class MemberInfo implements java.io.Serializable {

    // Fields
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;

    /** The member info id. */
    private Integer memberInfoId;

    /** The member. */
    private Member member;

    /** The language id. */
    private String languageId;

    /** The account number. */
    private String accountNumber;

    /** The gender. */
    private String gender;

    /** The date of birth. */
    private Timestamp dateOfBirth;

    /** The discussion alias. */
    private String discussionAlias;

    /** The country code. */
    private String countryCode;
    
    /** The CDS Prod IP. */
    private String cdsProdId;

    
    /**
     * Gets the member info id.
     *
     * @return the member info id
     */
    @Id
    @Column(name = "member_info_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getMemberInfoId() {
        return this.memberInfoId;
    }

    /**
     * Sets the member info id.
     *
     * @param memberInfoId the new member info id
     */
    public void setMemberInfoId(Integer memberInfoId) {
        this.memberInfoId = memberInfoId;
    }

    /**
     * Gets the member.
     * 
     * @return the member
     */
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    public Member getMember() {
        return this.member;
    }

    /**
     * Sets the member.
     * 
     * @param member
     *            the new member
     */
    public void setMember(Member member) {
        this.member = member;
    }

    /**
     * Gets the date of birth.
     *
     * @return the date of birth
     */
    @Column(name = "date_of_birth", length = 23)
    public Timestamp getDateOfBirth() {
        return this.dateOfBirth;
    }

    /**
     * Sets the date of birth.
     *
     * @param dateOfBirth the new date of birth
     */
    public void setDateOfBirth(Timestamp dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    /**
     * Gets the language id.
     *
     * @return the language id
     */
    @Column(name = "language_id")
    public String getLanguageId() {
        return languageId;
    }

    /**
     * Sets the language id.
     *
     * @param languageId the new language id
     */
    public void setLanguageId(String languageId) {
        this.languageId = languageId;
    }

    /**
     * Gets the account number.
     *
     * @return the account number
     */
    @Column(name = "tops_account_number")
    public String getAccountNumber() {
        return accountNumber;
    }

    /**
     * Sets the account number.
     *
     * @param accountNumber the new account number
     */
    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }

    /**
     * Gets the gender.
     *
     * @return the gender
     */
    @Column(name = "gender")
    public String getGender() {
        return gender;
    }

    /**
     * Sets the gender.
     *
     * @param gender the new gender
     */
    public void setGender(String gender) {
        this.gender = gender;
    }

    /**
     * Gets the discussion alias.
     *
     * @return the discussion alias
     */
    @Column(name = "discussion_alias")
    public String getDiscussionAlias() {
        return discussionAlias;
    }

    /**
     * Sets the discussion alias.
     *
     * @param discussionAlias the new discussion alias
     */
    public void setDiscussionAlias(String discussionAlias) {
        this.discussionAlias = discussionAlias;
    }

    /**
     * Gets the country code.
     *
     * @return the country code
     */
    @Column(name = "tops_country_code")
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the country code.
     *
     * @param countryCode the new country code
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Gets the cds prod id.
     *
     * @return the cds prod id
     */
    @Column(name = "cds_prod_id")
    public String getCdsProdId() {
        return cdsProdId;
    }

    /**
     * Sets the cds prod id.
     *
     * @param cdsProdId the new cds prod id
     */
    public void setCdsProdId(String cdsProdId) {
        this.cdsProdId = cdsProdId;
    }

}
