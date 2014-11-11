package com.readersdigest.onepass.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * EmailAddressOptHistory entity. @author Wilson Soethe Cursino -
 * wilson.cursino@rd.com
 */
@Entity
@Table(name = "email_address_opt_history", schema = "dbo", catalog = "registration")
public class EmailAddressOptHistory implements java.io.Serializable {

    // Fields
    private static final long serialVersionUID = 1L;
    private Integer emailAddressOptHistoryId;
    private UserPreference userPreference;
    private OptStatus optStatus;
    private OptStatusTransaction optStatusTransaction;

    // Constructors

    /** default constructor */
    public EmailAddressOptHistory() {
    }

    /** full constructor */
    public EmailAddressOptHistory(UserPreference userPreference, OptStatus optStatus,
            OptStatusTransaction optStatusTransaction) {
        this.userPreference = userPreference;
        this.optStatus = optStatus;
        this.optStatusTransaction = optStatusTransaction;
    }

    // Property accessors
    @Id
    @Column(name = "email_address_opt_history_id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getEmailAddressOptHistoryId() {
        return this.emailAddressOptHistoryId;
    }

    public void setEmailAddressOptHistoryId(Integer emailAddressOptHistoryId) {
        this.emailAddressOptHistoryId = emailAddressOptHistoryId;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_preference_id", nullable = false)
    public UserPreference getUserPreference() {
        return this.userPreference;
    }

    public void setUserPreference(UserPreference userPreference) {
        this.userPreference = userPreference;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "opt_status_id", nullable = false)
    public OptStatus getOptStatus() {
        return this.optStatus;
    }

    public void setOptStatus(OptStatus optStatus) {
        this.optStatus = optStatus;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "opt_status_transaction_id", nullable = false)
    public OptStatusTransaction getOptStatusTransaction() {
        return this.optStatusTransaction;
    }

    public void setOptStatusTransaction(OptStatusTransaction optStatusTransaction) {
        this.optStatusTransaction = optStatusTransaction;
    }

}