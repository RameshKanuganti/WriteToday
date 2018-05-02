package com.today.things.dto;

public class ActivityAnswerDTO {

    private Long id;

    private Long activityTypeId;

    private String activityTypeDetailId;

    private Long userAction;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getActivityTypeId() {
        return activityTypeId;
    }

    public void setActivityTypeId(Long activityTypeId) {
        this.activityTypeId = activityTypeId;
    }

    public String getActivityTypeDetailId() {
        return activityTypeDetailId;
    }

    public void setActivityTypeDetailId(String activityTypeDetailId) {
        this.activityTypeDetailId = activityTypeDetailId;
    }

    public Long getUserAction() {
        return userAction;
    }

    public void setUserAction(Long userAction) {
        this.userAction = userAction;
    }
}
