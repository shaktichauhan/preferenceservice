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
 * Source entity. @author Wilson Soethe Cursino - wilson.cursino@rd.com
 */
@Entity
@Table(name = "source", schema = "dbo", catalog = "registration")
public class Source implements java.io.Serializable {

    // Fields
    private static final long serialVersionUID = 1L;
    private Integer sourceId;
    private String sourceName;
    private String description;
    private Set<OptStatusTransaction> optStatusTransactions = new HashSet<OptStatusTransaction>(0);

    // Constructors

    /** default constructor */
    public Source() {
    }

    /** minimal constructor */
    public Source(Integer sourceId, String sourceName, String description) {
        this.sourceId = sourceId;
        this.sourceName = sourceName;
        this.description = description;
    }

    /** full constructor */
    public Source(Integer sourceId, String sourceName, String description, Set<OptStatusTransaction> optStatusTransactions) {
        this.sourceId = sourceId;
        this.sourceName = sourceName;
        this.description = description;
        this.optStatusTransactions = optStatusTransactions;
    }

    // Property accessors
    @Id
    @Column(name = "source_id", unique = true, nullable = false)
    public Integer getSourceId() {
        return this.sourceId;
    }

    public void setSourceId(Integer sourceId) {
        this.sourceId = sourceId;
    }

    @Column(name = "source_name", nullable = false, length = 50)
    public String getSourceName() {
        return this.sourceName;
    }

    public void setSourceName(String sourceName) {
        this.sourceName = sourceName;
    }

    @Column(name = "description", nullable = false)
    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY, mappedBy = "source")
    public Set<OptStatusTransaction> getOptStatusTransactions() {
        return this.optStatusTransactions;
    }

    public void setOptStatusTransactions(Set<OptStatusTransaction> optStatusTransactions) {
        this.optStatusTransactions = optStatusTransactions;
    }

}