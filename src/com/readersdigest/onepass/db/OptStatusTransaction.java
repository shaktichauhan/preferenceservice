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

/**
 * OptStatusTransaction entity. @author Wilson Soethe Cursino -
 * wilson.cursino@rd.com
 */
@Entity
@Table(name = "opt_status_transaction", schema = "dbo", catalog = "registration")
public class OptStatusTransaction implements java.io.Serializable {

    // Fields
    private static final long serialVersionUID = 1L;
    private Integer optStatusTransactionId;
    private Source source;
    private String trackingId;
    private Email email;
    private Timestamp createDate;
    private Set<EmailAddressOptStatus> emailAddressOptStatuses = new HashSet<EmailAddressOptStatus>(0);
    private Set<Member> members = new HashSet<Member>(0);
    private Set<EmailAddressOptHistory> emailAddressOptHistories = new HashSet<EmailAddressOptHistory>(0);

    // Constructors

    /** default constructor */
    public OptStatusTransaction() {
    }

    /** minimal constructor */
    public OptStatusTransaction(Email email, Timestamp createDate) {
        this.email = email;
        this.createDate = createDate;
    }

    /** full constructor */
    public OptStatusTransaction(Source source, String trackingId, Email email, Timestamp createDate,
            Set<EmailAddressOptStatus> emailAddressOptStatuses, Set<Member> members, Set<EmailAddressOptHistory> emailAddressOptHistories) {
        this.source = source;
        this.trackingId = trackingId;
        this.email = email;
        this.createDate = createDate;
        this.emailAddressOptStatuses = emailAddressOptStatuses;
        this.members = members;
        this.emailAddressOptHistories = emailAddressOptHistories;
    }

    // Property accessors
    @Id
    @Column(name = "opt_status_transaction_id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getOptStatusTransactionId() {
        return this.optStatusTransactionId;
    }

    public void setOptStatusTransactionId(Integer optStatusTransactionId) {
        this.optStatusTransactionId = optStatusTransactionId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_id")
    public Source getSource() {
        return this.source;
    }

    public void setSource(Source source) {
        this.source = source;
    }

    @Column(name = "tracking_id", nullable = false, length = 50)
    public String getTrackingId() {
        return this.trackingId;
    }

    public void setTrackingId(String trackingId) {
        this.trackingId = trackingId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "email_id", nullable = false)
    public Email getEmail() {
        return this.email;
    }

    public void setEmail(Email email) {
        this.email = email;
    }

    @Column(name = "create_date", nullable = false, length = 23)
    public Timestamp getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "optStatusTransaction")
    public Set<EmailAddressOptStatus> getEmailAddressOptStatuses() {
        return this.emailAddressOptStatuses;
    }

    public void setEmailAddressOptStatuses(Set<EmailAddressOptStatus> emailAddressOptStatuses) {
        this.emailAddressOptStatuses = emailAddressOptStatuses;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "optStatusTransaction")
    public Set<Member> getMembers() {
        return this.members;
    }

    public void setMembers(Set<Member> members) {
        this.members = members;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "optStatusTransaction")
    public Set<EmailAddressOptHistory> getEmailAddressOptHistories() {
        return this.emailAddressOptHistories;
    }

    public void setEmailAddressOptHistories(Set<EmailAddressOptHistory> emailAddressOptHistories) {
        this.emailAddressOptHistories = emailAddressOptHistories;
    }

}