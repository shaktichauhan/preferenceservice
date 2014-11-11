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
 * PostalAddress entity. @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */
@Entity
@Table(name = "postal_address", schema = "dbo", catalog = "registration")
public class PostalAddress implements java.io.Serializable {

    // Fields
    private static final long serialVersionUID = 1L;
    private Integer postalAddressId;
    private String subdivision;
    private Member member;
    private AddressType addressType;
    private String country;
    private String firstName;
    private String middleName;
    private String lastName;
    private String title;
    private String address1;
    private String address2;
    private String address3;
    private String address4;
    private String city;
    private String zip;
    private String valid;
    private String postalCleansedAddress1;
    private String postalCleansedCity;
    private String postalCleansedState;
    private String postalCleansedZip;
    private String postalCleansedCounty;
    private Timestamp effectiveDate;
    private Timestamp createDate;
    private String isPending;
    private Timestamp postalCleansedDt;
    // Constructors

    /** default constructor */
    public PostalAddress() {
    }

    /** minimal constructor */
    public PostalAddress(AddressType addressType, Timestamp effectiveDate) {
        this.addressType = addressType;
        this.effectiveDate = effectiveDate;
    }

    /** full constructor */
    public PostalAddress(String subdivision, Member member, AddressType addressType, String country, String firstName,
            String middleName, String lastName, String title, String address1, String address2, String address3, String address4, String city, String zip,
            String valid, String postalCleansedAddress1, String postalCleansedCity, String postalCleansedState, String postalCleansedZip,
            String postalCleansedCounty, Timestamp effectiveDate, Timestamp createDate, String isPending, Timestamp postalCleansedDt) {
       this.subdivision = subdivision;
        this.member = member;
        this.addressType = addressType;
        this.country = country;
        this.firstName = firstName;
        this.middleName = middleName;
        this.lastName = lastName;
        this.title = title;
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.address4 = address4;
        this.city = city;
        this.zip = zip;
        this.valid = valid;
        this.postalCleansedAddress1 = postalCleansedAddress1;
        this.postalCleansedCity = postalCleansedCity;
        this.postalCleansedState = postalCleansedState;
        this.postalCleansedZip = postalCleansedZip;
        this.postalCleansedCounty = postalCleansedCounty;
        this.effectiveDate = effectiveDate;
        this.createDate = createDate;
        this.isPending = isPending;
        this.postalCleansedDt = postalCleansedDt;
    }

    // Property accessors
    @Id
    @Column(name = "postal_address_id", unique = true, nullable = false)
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Integer getPostalAddressId() {
        return this.postalAddressId;
    }

    public void setPostalAddressId(Integer postalAddressId) {
        this.postalAddressId = postalAddressId;
    }

    @Column(name = "subdivision_code", length = 7)
    public String getSubdivision() {
        return this.subdivision;
    }

    public void setSubdivision(String subdivision) {
        this.subdivision = subdivision;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "member_id")
    public Member getMember() {
        return this.member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "address_type_id", nullable = false)
    public AddressType getAddressType() {
        return this.addressType;
    }

    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    @Column(name = "country_code", length = 2)
    public String getCountry() {
        return this.country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Column(name = "first_name", length = 50)
    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    @Column(name = "middle_name", length = 50)
    public String getMiddleName() {
        return this.middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    @Column(name = "last_name", length = 50)
    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Column(name = "title", length = 50)
    public String getTitle() {
        return this.title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Column(name = "address1", length = 100)
    public String getAddress1() {
        return this.address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    @Column(name = "address2", length = 100)
    public String getAddress2() {
        return this.address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    @Column(name = "address3", length = 100)
    public String getAddress3() {
        return this.address3;
    }

    public void setAddress3(String address3) {
        this.address3 = address3;
    }

    @Column(name = "address4", length = 100)
    public String getAddress4() {
        return this.address4;
    }

    public void setAddress4(String address4) {
        this.address4 = address4;
    }

    @Column(name = "city", length = 50)
    public String getCity() {
        return this.city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Column(name = "zip", length = 30)
    public String getZip() {
        return this.zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    @Column(name = "valid", length = 1)
    public String getValid() {
        return this.valid;
    }

    public void setValid(String valid) {
        this.valid = valid;
    }

    @Column(name = "postal_cleansed_address1", length = 50)
    public String getPostalCleansedAddress1() {
        return this.postalCleansedAddress1;
    }

    public void setPostalCleansedAddress1(String postalCleansedAddress1) {
        this.postalCleansedAddress1 = postalCleansedAddress1;
    }

    @Column(name = "postal_cleansed_city", length = 30)
    public String getPostalCleansedCity() {
        return this.postalCleansedCity;
    }

    public void setPostalCleansedCity(String postalCleansedCity) {
        this.postalCleansedCity = postalCleansedCity;
    }

    @Column(name = "postal_cleansed_state", length = 2)
    public String getPostalCleansedState() {
        return this.postalCleansedState;
    }

    public void setPostalCleansedState(String postalCleansedState) {
        this.postalCleansedState = postalCleansedState;
    }

    @Column(name = "postal_cleansed_zip", length = 10)
    public String getPostalCleansedZip() {
        return this.postalCleansedZip;
    }

    public void setPostalCleansedZip(String postalCleansedZip) {
        this.postalCleansedZip = postalCleansedZip;
    }

    @Column(name = "postal_cleansed_county", length = 50)
    public String getPostalCleansedCounty() {
        return this.postalCleansedCounty;
    }

    public void setPostalCleansedCounty(String postalCleansedCounty) {
        this.postalCleansedCounty = postalCleansedCounty;
    }

    @Column(name = "effective_date", nullable = false, length = 23)
    public Timestamp getEffectiveDate() {
        return this.effectiveDate;
    }

    public void setEffectiveDate(Timestamp effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    @Column(name = "create_date", length = 23)
    public Timestamp getCreateDate() {
        return this.createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
    }

    @Column(name = "is_pending", length = 1)
    public String getIsPending() {
        return this.isPending;
    }

    public void setIsPending(String isPending) {
        this.isPending = isPending;
    }

    @Column(name = "postal_cleansed_dt", length = 23)
    public Timestamp getPostalCleansedDt() {
        return this.postalCleansedDt;
    }

    public void setPostalCleansedDt(Timestamp postalCleansedDt) {
        this.postalCleansedDt = postalCleansedDt;
    }
   
}