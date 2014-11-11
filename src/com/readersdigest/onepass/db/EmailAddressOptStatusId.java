package com.readersdigest.onepass.db;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * EmailAddressOptStatusId entity. @author Wilson Soethe Cursino -
 * wilson.cursino@rd.com
 */
@Embeddable
public class EmailAddressOptStatusId implements java.io.Serializable {

    // Fields
    private static final long serialVersionUID = 1L;
    private Integer optStatusTransactionId;
    private Integer userPreferenceId;

    // Constructors

    /** default constructor */
    public EmailAddressOptStatusId() {
    }

    /** full constructor */
    public EmailAddressOptStatusId(Integer optStatusTransactionId, Integer userPreferenceId) {
        this.optStatusTransactionId = optStatusTransactionId;
        this.userPreferenceId = userPreferenceId;
    }

    // Property accessors

    @Column(name = "opt_status_transaction_id", nullable = false)
    public Integer getOptStatusTransactionId() {
        return this.optStatusTransactionId;
    }

    public void setOptStatusTransactionId(Integer optStatusTransactionId) {
        this.optStatusTransactionId = optStatusTransactionId;
    }

    @Column(name = "user_preference_id", nullable = false)
    public Integer getUserPreferenceId() {
        return this.userPreferenceId;
    }

    public void setUserPreferenceId(Integer userPreferenceId) {
        this.userPreferenceId = userPreferenceId;
    }

    public boolean equals(Object other) {
        if ((this == other))
            return true;
        if ((other == null))
            return false;
        if (!(other instanceof EmailAddressOptStatusId))
            return false;
        EmailAddressOptStatusId castOther = (EmailAddressOptStatusId) other;

        return ((this.getOptStatusTransactionId() == castOther.getOptStatusTransactionId()) || (this.getOptStatusTransactionId() != null
                && castOther.getOptStatusTransactionId() != null && this.getOptStatusTransactionId().equals(castOther.getOptStatusTransactionId())))
                && ((this.getUserPreferenceId() == castOther.getUserPreferenceId()) || (this.getUserPreferenceId() != null
                        && castOther.getUserPreferenceId() != null && this.getUserPreferenceId().equals(castOther.getUserPreferenceId())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (getOptStatusTransactionId() == null ? 0 : this.getOptStatusTransactionId().hashCode());
        result = 37 * result + (getUserPreferenceId() == null ? 0 : this.getUserPreferenceId().hashCode());
        return result;
    }

}