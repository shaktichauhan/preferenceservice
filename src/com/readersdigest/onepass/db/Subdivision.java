package com.readersdigest.onepass.db;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Subdivision entity.@author Wilson Soethe Cursino - wilson.cursino@rd.com
 */
@Entity
@Table(name = "subdivision", schema = "dbo", catalog = "registration")
public class Subdivision implements java.io.Serializable {

    // Fields
    private static final long serialVersionUID = 1L;
    private String subdivisionCode;
    private Country country;
    private String subdivisionName1;
    private String subdivisionName2;
    private String subdivisionName3;
    private String regionalDivision;
    private String subdivisionCategory;
    private String i3cSubdivisionCode;
    // Constructors

    /** default constructor */
    public Subdivision() {
    }

    /** minimal constructor */
    public Subdivision(String subdivisionCode, Country country, String subdivisionName1) {
        this.subdivisionCode = subdivisionCode;
        this.country = country;
        this.subdivisionName1 = subdivisionName1;
    }

    /** full constructor */
    public Subdivision(String subdivisionCode, Country country, String subdivisionName1, String subdivisionName2, String subdivisionName3,
            String regionalDivision, String subdivisionCategory, String i3cSubdivisionCode) {
        this.subdivisionCode = subdivisionCode;
        this.country = country;
        this.subdivisionName1 = subdivisionName1;
        this.subdivisionName2 = subdivisionName2;
        this.subdivisionName3 = subdivisionName3;
        this.regionalDivision = regionalDivision;
        this.subdivisionCategory = subdivisionCategory;
        this.i3cSubdivisionCode = i3cSubdivisionCode;
    }

    // Property accessors
    @Id
    @Column(name = "subdivision_code", unique = true, nullable = false, length = 7)
    public String getSubdivisionCode() {
        return this.subdivisionCode;
    }

    public void setSubdivisionCode(String subdivisionCode) {
        this.subdivisionCode = subdivisionCode;
    }

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "country_code", nullable = false)
    public Country getCountry() {
        return this.country;
    }

    public void setCountry(Country country) {
        this.country = country;
    }

    @Column(name = "subdivision_name_1", nullable = false, length = 100)
    public String getSubdivisionName1() {
        return this.subdivisionName1;
    }

    public void setSubdivisionName1(String subdivisionName1) {
        this.subdivisionName1 = subdivisionName1;
    }

    @Column(name = "subdivision_name_2", length = 100)
    public String getSubdivisionName2() {
        return this.subdivisionName2;
    }

    public void setSubdivisionName2(String subdivisionName2) {
        this.subdivisionName2 = subdivisionName2;
    }

    @Column(name = "subdivision_name_3", length = 100)
    public String getSubdivisionName3() {
        return this.subdivisionName3;
    }

    public void setSubdivisionName3(String subdivisionName3) {
        this.subdivisionName3 = subdivisionName3;
    }

    @Column(name = "regional_division", length = 10)
    public String getRegionalDivision() {
        return this.regionalDivision;
    }

    public void setRegionalDivision(String regionalDivision) {
        this.regionalDivision = regionalDivision;
    }

    @Column(name = "subdivision_category", length = 50)
    public String getSubdivisionCategory() {
        return this.subdivisionCategory;
    }

    public void setSubdivisionCategory(String subdivisionCategory) {
        this.subdivisionCategory = subdivisionCategory;
    }

    @Column(name = "i3c_subdivision_code", length = 7)
    public String getI3cSubdivisionCode() {
        return this.i3cSubdivisionCode;
    }

    public void setI3cSubdivisionCode(String i3cSubdivisionCode) {
        this.i3cSubdivisionCode = i3cSubdivisionCode;
    }

}