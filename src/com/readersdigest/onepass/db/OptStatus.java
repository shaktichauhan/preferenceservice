package com.readersdigest.onepass.db;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * OptStatus entity. @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */
@Entity
@Table(name = "opt_status", schema = "dbo", catalog = "registration")
public class OptStatus implements java.io.Serializable {

    // Fields
    private static final long serialVersionUID = 1L;
    private Integer optStatusId;
    private String optStatusName;
    private String description;
    private Set<EmailAddressOptStatus> emailAddressOptStatuses = new HashSet<EmailAddressOptStatus>(0);
    private Set<EmailAddressOptHistory> emailAddressOptHistories = new HashSet<EmailAddressOptHistory>(0);

    // Constructors

    /** default constructor */
    public OptStatus() {
    }

    /** minimal constructor */
    public OptStatus(Integer optStatusId, String optStatusName, String description) {
        this.optStatusId = optStatusId;
        this.optStatusName = optStatusName;
        this.description = description;
    }

    /** full constructor */
    public OptStatus(Integer optStatusId, String optStatusName, String description, Set<EmailAddressOptStatus> emailAddressOptStatuses,
            Set<EmailAddressOptHistory> emailAddressOptHistories) {
        this.optStatusId = optStatusId;
        this.optStatusName = optStatusName;
        this.description = description;
        this.emailAddressOptStatuses = emailAddressOptStatuses;
        this.emailAddressOptHistories = emailAddressOptHistories;
    }

    // Property accessors
    @Id
    @Column(name = "opt_status_id", unique = true, nullable = false)
    public Integer getOptStatusId() {
        return this.optStatusId;
    }

    public void setOptStatusId(Integer optStatusId) {
        this.optStatusId = optStatusId;
    }

    @Column(name = "opt_status_name", nullable = false, length = 50)
    public String getOptStatusName() {
        return this.optStatusName;
    }

    public void setOptStatusName(String optStatusName) {
        this.optStatusName = optStatusName;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "optStatus")
    public Set<EmailAddressOptStatus> getEmailAddressOptStatuses() {
        return this.emailAddressOptStatuses;
    }

    public void setEmailAddressOptStatuses(Set<EmailAddressOptStatus> emailAddressOptStatuses) {
        this.emailAddressOptStatuses = emailAddressOptStatuses;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "optStatus")
    public Set<EmailAddressOptHistory> getEmailAddressOptHistories() {
        return this.emailAddressOptHistories;
    }

    public void setEmailAddressOptHistories(Set<EmailAddressOptHistory> emailAddressOptHistories) {
        this.emailAddressOptHistories = emailAddressOptHistories;
    }

}