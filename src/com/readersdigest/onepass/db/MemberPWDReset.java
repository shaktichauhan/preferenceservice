package com.readersdigest.onepass.db;

import java.sql.Timestamp;

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
 * MemberPWDReset entity. @author shsingh - shakti_singh@consultant.rd.com
 */
@Entity
@Table(name = "member_pwd_reset", schema = "dbo", catalog = "registration")
public class MemberPWDReset implements java.io.Serializable {

    // Fields
    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = 1L;
    
    /** The member pwd id. */
    private Integer memberPWDId;
    
    /** The member. */
    private Member member;
    
    /** The token. */
    private String token;
    
    /** The create date. */
    private Timestamp createDate;
    
    /** The member pwd id. */
    private Integer memberOnePassId;

    /**
     * Gets the member pwd id.
     *
     * @return the member pwd id
     */
    @Id
    @Column(name = "member_pwd_id", unique = true, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getMemberPWDId() {
        return this.memberPWDId;
    }

    /**
     * Sets the member pwd id.
     *
     * @param memberPWDId the new member pwd id
     */
    public void setMemberPWDId(Integer memberPWDId) {
        this.memberPWDId = memberPWDId;
    }

    /**
     * Gets the member.
     *
     * @return the member
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    public Member getMember() {
        return this.member;
    }

    /**
     * Sets the member.
     *
     * @param member the new member
     */
    public void setMember(Member member) {
        this.member = member;
    }

    /**
     * Gets the creates the date.
     *
     * @return the creates the date
     */
    @Column(name = "create_date", length = 23)
    public Timestamp getCreateDate() {
        return this.createDate;
    }

    /**
     * Sets the creates the date.
     *
     * @param createDate the new creates the date
     */
    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    /**
     * Gets the token.
     *
     * @return the token
     */
    @Column(name = "token")
    public String getToken() {
        return this.token;
    }

    /**
     * Sets the token.
     *
     * @param token the new token
     */
    public void setToken(String token) {
        this.token = token;
    }

    /**
     * Gets the memberOnePass.
     *
     * @return the token
     */
    @Column(name = "member_onepass_info")
	public Integer getMemberOnePassId() {
		return memberOnePassId;
	}

	public void setMemberOnePassId(Integer memberOnePassId) {
		this.memberOnePassId = memberOnePassId;
	}

    
}
