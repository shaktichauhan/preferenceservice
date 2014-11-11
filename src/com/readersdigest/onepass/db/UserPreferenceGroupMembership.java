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
 * UserPreferenceGroupMembership entity. @author Wilson Soethe Cursino -
 * wilson.cursino@rd.com
 */
@Entity
@Table(name = "user_preference_group_membership", schema = "dbo", catalog = "registration")
public class UserPreferenceGroupMembership implements java.io.Serializable {

    // Fields
    private static final long serialVersionUID = 1L;
    private UserPreferenceGroupMembershipId id;
    private UserPreference userPreference;
    private UserPreferenceGroup userPreferenceGroup;
    private Integer displayOrder;
    private Integer checked;
    private Integer hidden;

    // Constructors

    /** default constructor */
    public UserPreferenceGroupMembership() {
    }

    /** minimal constructor */
    public UserPreferenceGroupMembership(UserPreferenceGroupMembershipId id, UserPreference userPreference, UserPreferenceGroup userPreferenceGroup,
            Integer displayOrder, Integer checked, Integer hidden) {
        this.id = id;
        this.userPreference = userPreference;
        this.userPreferenceGroup = userPreferenceGroup;
        this.displayOrder = displayOrder;
        this.checked = checked;
        this.hidden = hidden;
    }

    // Property accessors
    @EmbeddedId
    @AttributeOverrides({ @AttributeOverride(name = "userPreferenceGroupId", column = @Column(name = "user_preference_group_id", nullable = false)),
            @AttributeOverride(name = "userPreferenceId", column = @Column(name = "user_preference_id", nullable = false)) })
    public UserPreferenceGroupMembershipId getId() {
        return this.id;
    }

    public void setId(UserPreferenceGroupMembershipId id) {
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
    @JoinColumn(name = "user_preference_group_id", nullable = false, insertable = false, updatable = false)
    public UserPreferenceGroup getUserPreferenceGroup() {
        return this.userPreferenceGroup;
    }

    public void setUserPreferenceGroup(UserPreferenceGroup userPreferenceGroup) {
        this.userPreferenceGroup = userPreferenceGroup;
    }

    @Column(name = "display_order", nullable = false)
    public Integer getDisplayOrder() {
        return this.displayOrder;
    }

    public void setDisplayOrder(Integer displayOrder) {
        this.displayOrder = displayOrder;
    }

    @Column(name = "checked", nullable = false)
    public Integer getChecked() {
        return this.checked;
    }

    public void setChecked(Integer checked) {
        this.checked = checked;
    }

    @Column(name = "hidden", nullable = false)
    public Integer getHidden() {
        return this.hidden;
    }

    public void setHidden(Integer hidden) {
        this.hidden = hidden;
    }

}