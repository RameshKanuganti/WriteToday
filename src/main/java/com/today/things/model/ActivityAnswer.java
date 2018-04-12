package com.today.things.model;

import javax.persistence.*;

@Entity
public class ActivityAnswer {

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "activity_type_id")
    private Long activityTypeId;

    @Column(name = "activity_type_detail_id")
    private String activityTypeDetailId;

    @Column(name = "user_action")
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
