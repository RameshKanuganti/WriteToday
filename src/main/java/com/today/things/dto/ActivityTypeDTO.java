package com.today.things.dto;

import com.today.things.model.ActivityTypeDetails;

import java.util.List;

public class ActivityTypeDTO {

    private Long id;

    private String name;

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
