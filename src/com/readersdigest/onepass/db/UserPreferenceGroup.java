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
 * UserPreferenceGroup entity. @author Wilson Soethe Cursino -
 * wilson.cursino@rd.com
 */
@Entity
@Table(name = "user_preference_group", schema = "dbo", catalog = "registration")
public class UserPreferenceGroup implements java.io.Serializable {

    // Fields
    private static final long serialVersionUID = 1L;
    private Integer userPreferenceGroupId;
    private String userPreferenceGroupName;
    private Set<UserPreferenceGroupMembership> userPreferenceGroupMemberships = new HashSet<UserPreferenceGroupMembership>(0);

    // Constructors

    /** default constructor */
    public UserPreferenceGroup() {
    }

    /** minimal constructor */
    public UserPreferenceGroup(Integer userPreferenceGroupId, String userPreferenceGroupName) {
        this.userPreferenceGroupId = userPreferenceGroupId;
        this.userPreferenceGroupName = userPreferenceGroupName;
    }

    /** full constructor */
    public UserPreferenceGroup(Integer userPreferenceGroupId, String userPreferenceGroupName, Set<UserPreferenceGroupMembership> userPreferenceGroupMemberships) {
        this.userPreferenceGroupId = userPreferenceGroupId;
        this.userPreferenceGroupName = userPreferenceGroupName;
        this.userPreferenceGroupMemberships = userPreferenceGroupMemberships;
    }

    // Property accessors
    @Id
    @Column(name = "user_preference_group_id", unique = true, nullable = false)
    public Integer getUserPreferenceGroupId() {
        return this.userPreferenceGroupId;
    }

    public void setUserPreferenceGroupId(Integer userPreferenceGroupId) {
        this.userPreferenceGroupId = userPreferenceGroupId;
    }

    @Column(name = "user_preference_group_name", nullable = false, length = 50)
    public String getUserPreferenceGroupName() {
        return this.userPreferenceGroupName;
    }

    public void setUserPreferenceGroupName(String userPreferenceGroupName) {
        this.userPreferenceGroupName = userPreferenceGroupName;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "userPreferenceGroup")
    public Set<UserPreferenceGroupMembership> getUserPreferenceGroupMemberships() {
        return this.userPreferenceGroupMemberships;
    }

    public void setUserPreferenceGroupMemberships(Set<UserPreferenceGroupMembership> userPreferenceGroupMemberships) {
        this.userPreferenceGroupMemberships = userPreferenceGroupMemberships;
    }

}