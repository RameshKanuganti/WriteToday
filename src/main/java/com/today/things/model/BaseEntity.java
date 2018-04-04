package com.today.things.model;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.sql.Timestamp;

@MappedSuperclass
public class BaseEntity {

    @Column(name = "created_on", updatable = false, nullable = false)
    @CreationTimestamp
    private Timestamp createdOn;

    @UpdateTimestamp
    @Column(name = "updated_on", nullable = false)
    private Timestamp updatedOn;


    public Timestamp getCreatedOn() {
        return createdOn;
    }

    public void setCreatedOn(Timestamp createdOn) {
        this.createdOn = createdOn;
    }

    public Timestamp getUpdatedOn() {
        return updatedOn;
    }

    public void setUpdatedOn(Timestamp updatedOn) {
        this.updatedOn = updatedOn;
    }
}
