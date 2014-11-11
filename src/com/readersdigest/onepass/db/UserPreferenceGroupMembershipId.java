package com.readersdigest.onepass.db;

import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 * UserPreferenceGroupMembershipId entity. @author Wilson Soethe Cursino -
 * wilson.cursino@rd.com
 */
@Embeddable
public class UserPreferenceGroupMembershipId implements java.io.Serializable {

    // Fields
    private static final long serialVersionUID = 1L;
    private Integer userPreferenceGroupId;
    private Integer userPreferenceId;

    // Constructors

    /** default constructor */
    public UserPreferenceGroupMembershipId() {
    }

    /** full constructor */
    public UserPreferenceGroupMembershipId(Integer userPreferenceGroupId, Integer userPreferenceId) {
        this.userPreferenceGroupId = userPreferenceGroupId;
        this.userPreferenceId = userPreferenceId;
    }

    // Property accessors

    @Column(name = "user_preference_group_id", nullable = false)
    public Integer getUserPreferenceGroupId() {
        return this.userPreferenceGroupId;
    }

    public void setUserPreferenceGroupId(Integer userPreferenceGroupId) {
        this.userPreferenceGroupId = userPreferenceGroupId;
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
        if (!(other instanceof UserPreferenceGroupMembershipId))
            return false;
        UserPreferenceGroupMembershipId castOther = (UserPreferenceGroupMembershipId) other;

        return ((this.getUserPreferenceGroupId() == castOther.getUserPreferenceGroupId()) || (this.getUserPreferenceGroupId() != null
                && castOther.getUserPreferenceGroupId() != null && this.getUserPreferenceGroupId().equals(castOther.getUserPreferenceGroupId())))
                && ((this.getUserPreferenceId() == castOther.getUserPreferenceId()) || (this.getUserPreferenceId() != null
                        && castOther.getUserPreferenceId() != null && this.getUserPreferenceId().equals(castOther.getUserPreferenceId())));
    }

    public int hashCode() {
        int result = 17;

        result = 37 * result + (getUserPreferenceGroupId() == null ? 0 : this.getUserPreferenceGroupId().hashCode());
        result = 37 * result + (getUserPreferenceId() == null ? 0 : this.getUserPreferenceId().hashCode());
        return result;
    }

}