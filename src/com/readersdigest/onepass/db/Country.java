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
 * Country entity.@author Wilson Soethe Cursino - wilson.cursino@rd.com
 */
@Entity
@Table(name = "country", schema = "dbo", catalog = "registration")
public class Country implements java.io.Serializable {

    // Fields

    private static final long serialVersionUID = 1L;
    private String countryCode;
    private String countryName;
    private String descriptiveInformation;
    private Set<Subdivision> subdivisions = new HashSet<Subdivision>(0);

    // Constructors

    /** default constructor */
    public Country() {
    }

    /** minimal constructor */
    public Country(String countryCode, String countryName, String descriptiveInformation) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.descriptiveInformation = descriptiveInformation;
    }

    /** full constructor */
    public Country(String countryCode, String countryName, String descriptiveInformation, Set<Subdivision> subdivisions) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.descriptiveInformation = descriptiveInformation;
        this.subdivisions = subdivisions;
    }

    // Property accessors
    @Id
    @Column(name = "country_code", unique = true, nullable = false, length = 2)
    public String getCountryCode() {
        return this.countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    @Column(name = "country_name", nullable = false, length = 100)
    public String getCountryName() {
        return this.countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    @Column(name = "descriptive_information", nullable = false, length = 4000)
    public String getDescriptiveInformation() {
        return this.descriptiveInformation;
    }

    public void setDescriptiveInformation(String descriptiveInformation) {
        this.descriptiveInformation = descriptiveInformation;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "country")
    public Set<Subdivision> getSubdivisions() {
        return this.subdivisions;
    }

    public void setSubdivisions(Set<Subdivision> subdivisions) {
        this.subdivisions = subdivisions;
    }

}