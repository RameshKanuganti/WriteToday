package com.today.things.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ActivityType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    @OneToMany(mappedBy = "activityType")
    private List<ActivityTypeDetails> activityTypeDetails;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;

    }

    public List<ActivityTypeDetails> getActivityTypeDetails() {
        return activityTypeDetails;
    }

    public void setActivityTypeDetails(List<ActivityTypeDetails> activityTypeDetails) {
        this.activityTypeDetails = activityTypeDetails;
    }
}
