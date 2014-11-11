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
 * UserPreference entity. @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */
@Entity
@Table(name = "user_preference", schema = "dbo", catalog = "registration")
public class UserPreference implements java.io.Serializable {

    // Fields
    private static final long serialVersionUID = 1L;
    private Integer userPreferenceId;
    private String userPreferenceName;
    private String userPreferenceDesc;
    private String displayName;
    private String tagLine;
    private Integer cheetahMailListId;
    private Set<EmailAddressOptHistory> emailAddressOptHistories = new HashSet<EmailAddressOptHistory>(0);
    private Set<UserPreferenceGroupMembership> userPreferenceGroupMemberships = new HashSet<UserPreferenceGroupMembership>(0);
    private Set<EmailAddressOptStatus> emailAddressOptStatuses = new HashSet<EmailAddressOptStatus>(0);

    // Constructors

    /** default constructor */
    public UserPreference() {
    }

    /** minimal constructor */
    public UserPreference(Integer userPreferenceId) {
        this.userPreferenceId = userPreferenceId;
    }

    /** full constructor */
    public UserPreference(Integer userPreferenceId, String userPreferenceName, String userPreferenceDesc, String displayName, String tagLine,
            Integer cheetahMailListId, Set<EmailAddressOptHistory> emailAddressOptHistories, Set<UserPreferenceGroupMembership> userPreferenceGroupMemberships,
            Set<EmailAddressOptStatus> emailAddressOptStatuses) {
        this.userPreferenceId = userPreferenceId;
        this.userPreferenceName = userPreferenceName;
        this.userPreferenceDesc = userPreferenceDesc;
        this.displayName = displayName;
        this.tagLine = tagLine;
        this.cheetahMailListId = cheetahMailListId;
        this.emailAddressOptHistories = emailAddressOptHistories;
        this.userPreferenceGroupMemberships = userPreferenceGroupMemberships;
        this.emailAddressOptStatuses = emailAddressOptStatuses;
    }

    // Property accessors
    @Id
    @Column(name = "user_preference_id", unique = true, nullable = false)
    public Integer getUserPreferenceId() {
        return this.userPreferenceId;
    }

    public void setUserPreferenceId(Integer userPreferenceId) {
        this.userPreferenceId = userPreferenceId;
    }

    @Column(name = "user_preference_name", length = 50)
    public String getUserPreferenceName() {
        return this.userPreferenceName;
    }

    public void setUserPreferenceName(String userPreferenceName) {
        this.userPreferenceName = userPreferenceName;
    }

    @Column(name = "user_preference_desc", length = 2000)
    public String getUserPreferenceDesc() {
        return this.userPreferenceDesc;
    }

    public void setUserPreferenceDesc(String userPreferenceDesc) {
        this.userPreferenceDesc = userPreferenceDesc;
    }

    @Column(name = "display_name", length = 50)
    public String getDisplayName() {
        return this.displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    @Column(name = "tag_line", length = 70)
    public String getTagLine() {
        return this.tagLine;
    }

    public void setTagLine(String tagLine) {
        this.tagLine = tagLine;
    }

    @Column(name = "cheetah_mail_list_id")
    public Integer getCheetahMailListId() {
        return this.cheetahMailListId;
    }

    public void setCheetahMailListId(Integer cheetahMailListId) {
        this.cheetahMailListId = cheetahMailListId;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userPreference")
    public Set<EmailAddressOptHistory> getEmailAddressOptHistories() {
        return this.emailAddressOptHistories;
    }

    public void setEmailAddressOptHistories(Set<EmailAddressOptHistory> emailAddressOptHistories) {
        this.emailAddressOptHistories = emailAddressOptHistories;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userPreference")
    public Set<UserPreferenceGroupMembership> getUserPreferenceGroupMemberships() {
        return this.userPreferenceGroupMemberships;
    }

    public void setUserPreferenceGroupMemberships(Set<UserPreferenceGroupMembership> userPreferenceGroupMemberships) {
        this.userPreferenceGroupMemberships = userPreferenceGroupMemberships;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userPreference")
    public Set<EmailAddressOptStatus> getEmailAddressOptStatuses() {
        return this.emailAddressOptStatuses;
    }

    public void setEmailAddressOptStatuses(Set<EmailAddressOptStatus> emailAddressOptStatuses) {
        this.emailAddressOptStatuses = emailAddressOptStatuses;
    }

}