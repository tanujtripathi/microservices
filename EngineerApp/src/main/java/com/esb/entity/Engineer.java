package com.esb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Engineer {

    @Id
    @Column(name = "ID")
    private Long id;

    @Column(name = "EIN")
    public Long ein;

    @Column(name = "REFERENCE_NUMBER")
    public Long referenceNumber;

    @Column(name = "AVAILABLE")
    public String available;

    public Engineer() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getEin() {
        return ein;
    }

    public void setEin(Long ein) {
        this.ein = ein;
    }

    public Long getReferenceNumber() {
        return referenceNumber;
    }

    public void setReferenceNumber(Long referenceNumber) {
        this.referenceNumber = referenceNumber;
    }

    public String getAvailable() {
        return available;
    }

    public void setAvailable(String available) {
        this.available = available;
    }

    @Override
    public String toString() {
        return "Engineer{" +
                "id=" + id +
                ", ein=" + ein +
                ", referenceNumber=" + referenceNumber +
                ", available='" + available + '\'' +
                '}';
    }
}

