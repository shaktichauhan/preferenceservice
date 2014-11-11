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
 * AddressType entity. @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */
@Entity
@Table(name = "address_type", schema = "dbo", catalog = "registration")
public class AddressType implements java.io.Serializable {

    // Fields
    private static final long serialVersionUID = 1L;
    private Integer addressTypeId;
    private String addressTypeName;
    private String description;
    private Set<PostalAddress> postalAddresses = new HashSet<PostalAddress>(0);

    // Constructors

    /** default constructor */
    public AddressType() {
    }

    /** minimal constructor */
    public AddressType(Integer addressTypeId, String addressTypeName, String description) {
        this.addressTypeId = addressTypeId;
        this.addressTypeName = addressTypeName;
        this.description = description;
    }

    /** full constructor */
    public AddressType(Integer addressTypeId, String addressTypeName, String description, Set<PostalAddress> postalAddresses) {
        this.addressTypeId = addressTypeId;
        this.addressTypeName = addressTypeName;
        this.description = description;
        this.postalAddresses = postalAddresses;
    }

    // Property accessors
    @Id
    @Column(name = "address_type_id", unique = true, nullable = false)
    public Integer getAddressTypeId() {
        return this.addressTypeId;
    }

    public void setAddressTypeId(Integer addressTypeId) {
        this.addressTypeId = addressTypeId;
    }

    @Column(name = "address_type_name", nullable = false, length = 50)
    public String getAddressTypeName() {
        return this.addressTypeName;
    }

    public void setAddressTypeName(String addressTypeName) {
        this.addressTypeName = addressTypeName;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "addressType")
    public Set<PostalAddress> getPostalAddresses() {
        return this.postalAddresses;
    }

    public void setPostalAddresses(Set<PostalAddress> postalAddresses) {
        this.postalAddresses = postalAddresses;
    }

}