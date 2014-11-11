package com.readersdigest.onepass.db;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * EmailAddressOptStatus entity. @author Wilson Soethe Cursino -
 * wilson.cursino@rd.com
 */
@Entity
@Table(name = "email_address_opt_status", schema = "dbo", catalog = "registration")
public class EmailAddressOptStatus implements java.io.Serializable {

    // Fields
    private static final long serialVersionUID = 1L;
    private EmailAddressOptStatusId id;
    private UserPreference userPreference;
    private OptStatus optStatus;
    private OptStatusTransaction optStatusTransaction;

    // Constructors

    /** default constructor */
    public EmailAddressOptStatus() {
    }

    /** full constructor */
    public EmailAddressOptStatus(EmailAddressOptStatusId id, UserPreference userPreference, OptStatus optStatus, OptStatusTransaction optStatusTransaction) {
        this.id = id;
        this.userPreference = userPreference;
        this.optStatus = optStatus;
        this.optStatusTransaction = optStatusTransaction;
    }

    // Property accessors
    @EmbeddedId
    @AttributeOverrides({ @AttributeOverride(name = "optStatusTransactionId", column = @Column(name = "opt_status_transaction_id", nullable = false)),
            @AttributeOverride(name = "userPreferenceId", column = @Column(name = "user_preference_id", nullable = false)) })
    public EmailAddressOptStatusId getId() {
        return this.id;
    }

    public void setId(EmailAddressOptStatusId id) {
        this.id = id;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_preference_id", nullable = false, insertable = false, updatable = false)
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
    @JoinColumn(name = "opt_status_transaction_id", nullable = false, insertable = false, updatable = false)
    public OptStatusTransaction getOptStatusTransaction() {
        return this.optStatusTransaction;
    }

    public void setOptStatusTransaction(OptStatusTransaction optStatusTransaction) {
        this.optStatusTransaction = optStatusTransaction;
    }

}