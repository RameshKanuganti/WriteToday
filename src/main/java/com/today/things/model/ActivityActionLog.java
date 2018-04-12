package com.today.things.model;

import javax.persistence.*;
import java.util.List;

@Entity
public class ActivityActionLog extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @OneToMany
    private List<ActivityAnswer> activityAnswerList;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ActivityAnswer> getActivityAnswerList() {
        return activityAnswerList;
    }

    public void setActivityAnswerList(List<ActivityAnswer> activityAnswerList) {
        this.activityAnswerList = activityAnswerList;
    }
}
