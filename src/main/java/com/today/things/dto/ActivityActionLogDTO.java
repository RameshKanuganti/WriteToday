package com.today.things.dto;

import com.today.things.model.BaseEntity;

import java.util.ArrayList;
import java.util.List;

public class ActivityActionLogDTO extends BaseEntity {
    private Long id;

    private List<ActivityAnswerDTO> activityAnswerDTOList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<ActivityAnswerDTO> getActivityAnswerDTOList() {
        return activityAnswerDTOList;
    }

    public void setActivityAnswerDTOList(List<ActivityAnswerDTO> activityAnswerDTOList) {
        this.activityAnswerDTOList = activityAnswerDTOList;
    }
}
