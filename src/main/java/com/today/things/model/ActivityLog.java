package com.today.things.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import java.sql.Timestamp;

@Entity
public class ActivityLog extends BaseEntity {

    @Id
    private Long id;

    @ManyToOne
    private UserActivity activity;

    @Column(name = "description")
    private String description;

    @ManyToOne
    private TodayUser todayUser;

    @CreationTimestamp
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
