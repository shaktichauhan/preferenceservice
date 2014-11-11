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
 * Member entity. @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */
@Entity
@Table(name = "member", schema = "dbo", catalog = "registration", uniqueConstraints = @UniqueConstraint(columnNames = "member_name"))
public class Member implements java.io.Serializable {

    // Fields
    private static final long serialVersionUID = 1L;
    private Integer memberId;
    private OptStatusTransaction optStatusTransaction;
    private String memberName;
    private String password;
    private String passwordHintQuestion;
    private String passwordHintAnswer;
    private Timestamp passwordExpirationDate;
    private String lastLoginIpAddress;
    private String cookieGuid;
    private Set<PostalAddress> postalAddresses = new HashSet<PostalAddress>(0);

    // Constructors

    /** default constructor */
    public Member() {
    }

    /** minimal constructor */
    public Member(String memberName) {
        this.memberName = memberName;
    }

    /** full constructor */
    public Member(OptStatusTransaction optStatusTransaction, String memberName, String password, String passwordHintQuestion,
            String passwordHintAnswer, Timestamp passwordExpirationDate, String lastLoginIpAddress, String cookieGuid, Set<PostalAddress> postalAddresses) {
       this.optStatusTransaction = optStatusTransaction;
        this.memberName = memberName;
        this.password = password;
        this.passwordHintQuestion = passwordHintQuestion;
        this.passwordHintAnswer = passwordHintAnswer;
        this.passwordExpirationDate = passwordExpirationDate;
        this.lastLoginIpAddress = lastLoginIpAddress;
        this.cookieGuid = cookieGuid;
        this.postalAddresses = postalAddresses;
    }

    // Property accessors
    @Id
    @Column(name = "member_id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getMemberId() {
        return this.memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "opt_status_transaction_id")
    public OptStatusTransaction getOptStatusTransaction() {
        return this.optStatusTransaction;
    }

    public void setOptStatusTransaction(OptStatusTransaction optStatusTransaction) {
        this.optStatusTransaction = optStatusTransaction;
    }

    @Column(name = "member_name", unique = true, nullable = false, length = 100)
    public String getMemberName() {
        return this.memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    @Column(name = "password", length = 50)
    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "password_hint_question", length = 100)
    public String getPasswordHintQuestion() {
        return this.passwordHintQuestion;
    }

    public void setPasswordHintQuestion(String passwordHintQuestion) {
        this.passwordHintQuestion = passwordHintQuestion;
    }

    @Column(name = "password_hint_answer", length = 100)
    public String getPasswordHintAnswer() {
        return this.passwordHintAnswer;
    }

    public void setPasswordHintAnswer(String passwordHintAnswer) {
        this.passwordHintAnswer = passwordHintAnswer;
    }

    @Column(name = "password_expiration_date", length = 23)
    public Timestamp getPasswordExpirationDate() {
        return this.passwordExpirationDate;
    }

    public void setPasswordExpirationDate(Timestamp passwordExpirationDate) {
        this.passwordExpirationDate = passwordExpirationDate;
    }

    @Column(name = "last_login_ip_address", length = 15)
    public String getLastLoginIpAddress() {
        return this.lastLoginIpAddress;
    }

    public void setLastLoginIpAddress(String lastLoginIpAddress) {
        this.lastLoginIpAddress = lastLoginIpAddress;
    }

    @Column(name = "cookie_guid", length = 36)
    public String getCookieGuid() {
        return this.cookieGuid;
    }

    public void setCookieGuid(String cookieGuid) {
        this.cookieGuid = cookieGuid;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "member")
    public Set<PostalAddress> getPostalAddresses() {
        return this.postalAddresses;
    }

    public void setPostalAddresses(Set<PostalAddress> postalAddresses) {
        this.postalAddresses = postalAddresses;
    }

}