package com.today.things.dto;

import java.util.ArrayList;
import java.util.List;

public class ActivityQuestionDTO {

    private Long id;

    private String activityName;

    private Long activityTypeId = 0l;

    private String activityTypeName = "NA";

    private List<ActivityTypeDetailsDTO> activityTypeDetailsDTOList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public Long getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(Long activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public String getActivityTypeName() {
        return activityTypeName;
    }

    public void setActivityTypeName(String activityTypeName) {
        this.activityTypeName = activityTypeName;
    }

    public List<ActivityTypeDetailsDTO> getActivityTypeDetailsDTOList() {
        return activityTypeDetailsDTOList;
    }

    public void setActivityTypeDetailsDTOList(List<ActivityTypeDetailsDTO> activityTypeDetailsDTOList) {
        this.activityTypeDetailsDTOList = activityTypeDetailsDTOList;
    }
}
