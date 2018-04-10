package com.today.things.dto;

import com.today.things.model.BaseEntity;
import com.today.things.model.TodayUser;
import com.today.things.model.UserActivity;

import java.sql.Timestamp;

public class ActivityLogDTO extends BaseEntity {

    private UserActivity activity;

    private String description;

    private TodayUser todayUser;

    private Timestamp loggedActivityDate;

    public UserActivity getActivity() {
        return activity;
    }

    public void setActivity(UserActivity activity) {
        this.activity = activity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TodayUser getTodayUser() {
        return todayUser;
    }

    public void setTodayUser(TodayUser todayUser) {
        this.todayUser = todayUser;
    }

    public Timestamp getLoggedActivityDate() {
        return loggedActivityDate;
    }

    public void setLoggedActivityDate(Timestamp loggedActivityDate) {
        this.loggedActivityDate = loggedActivityDate;
    }
}
