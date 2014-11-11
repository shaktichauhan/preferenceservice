package com.readersdigest.onepass.db;

import java.sql.Timestamp;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

/**
 * Email entity. @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */
@Entity
@Table(name = "email", schema = "dbo", catalog = "registration", uniqueConstraints = @UniqueConstraint(columnNames = "email_address"))
public class Email implements java.io.Serializable {

    // Fields
    private static final long serialVersionUID = 1L;
    private Integer emailId;
    private Member member;
    private String emailAddress;
    private Integer emailTypeId;
    private Timestamp effectiveDate;
    private Integer nonMemberProfile;
    private Integer softBounce;
    private Integer hardBounce;
    private String legacyEpid;
    private Timestamp softBounceLastIncrementDate;
    private Timestamp hardBounceLastIncrementDate;
    private String epid;
    private Set<OptStatusTransaction> optStatusTransactions = new HashSet<OptStatusTransaction>(0);

    // Constructors

    // Property accessors
    @Id
    @Column(name = "email_id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getEmailId() {
        return this.emailId;
    }

    public void setEmailId(Integer emailId) {
        this.emailId = emailId;
    }

//    @Column(name = "member_id")
//    public Integer getMemberId() {
//        return this.memberId;
//    }
//
//    public void setMemberId(Integer memberId) {
//        this.memberId = memberId;
//    }
    
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    public Member getMember() {
        return this.member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @Column(name = "email_address", unique = true, nullable = false, length = 100)
    public String getEmailAddress() {
        return this.emailAddress;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    @Column(name = "email_type_id")
    public Integer getEmailTypeId() {
        return this.emailTypeId;
    }

    public void setEmailTypeId(Integer emailTypeId) {
        this.emailTypeId = emailTypeId;
    }

    @Column(name = "effective_date", length = 23)
    public Timestamp getEffectiveDate() {
        return this.effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Column(name = "non_member_profile")
    public Integer getNonMemberProfile() {
        return this.nonMemberProfile;
    }

    public void setNonMemberProfile(Integer nonMemberProfile) {
        this.nonMemberProfile = nonMemberProfile;
    }

    @Column(name = "soft_bounce")
    public Integer getSoftBounce() {
        return this.softBounce;
    }

    public void setSoftBounce(Integer softBounce) {
        this.softBounce = softBounce;
    }

    @Column(name = "hard_bounce")
    public Integer getHardBounce() {
        return this.hardBounce;
    }

    public void setHardBounce(Integer hardBounce) {
        this.hardBounce = hardBounce;
    }

    @Column(name = "legacy_epid", nullable = false, insertable = false, updatable = false, length = 36)
    public String getLegacyEpid() {
        return this.legacyEpid;
    }

    public void setLegacyEpid(String legacyEpid) {
        this.legacyEpid = legacyEpid;
    }

    @Column(name = "soft_bounce_last_increment_date", length = 23)
    public Timestamp getSoftBounceLastIncrementDate() {
        return this.softBounceLastIncrementDate;
    }

    public void setSoftBounceLastIncrementDate(Timestamp softBounceLastIncrementDate) {
        this.softBounceLastIncrementDate = softBounceLastIncrementDate;
    }

    @Column(name = "hard_bounce_last_increment_date", length = 23)
    public Timestamp getHardBounceLastIncrementDate() {
        return this.hardBounceLastIncrementDate;
    }

    public void setHardBounceLastIncrementDate(Timestamp hardBounceLastIncrementDate) {
        this.hardBounceLastIncrementDate = hardBounceLastIncrementDate;
    }

    @Column(name = "epid", length = 400,insertable = false, updatable = false)
    public String getEpid() {
        return this.epid;
    }

    public void setEpid(String epid) {
        this.epid = epid;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "email")
    public Set<OptStatusTransaction> getOptStatusTransactions() {
        return this.optStatusTransactions;
    }

    public void setOptStatusTransactions(Set<OptStatusTransaction> optStatusTransactions) {
        this.optStatusTransactions = optStatusTransactions;
    }

}