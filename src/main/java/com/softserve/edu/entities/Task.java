package com.softserve.edu.entities;

import javax.persistence.*;

/**
 * Created by Roman on 30.10.2015.
 *
 */

@Entity
@Table(name = "TASKS")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "TASK_ID")
    private Integer taskId;

    @Column(name = "TASK_NAME")
    private String name;

    @Column(name = "TASK_DESCRIPTION")
    private String description;

    @Column(name = "TASK_STATUS")
    private boolean status = false;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User assignee;

    @ManyToOne
    @JoinColumn(name = "DASHBOARD_ID")
    private Dashboard dashboard;

    @ManyToOne
    @JoinColumn(name = "PARRENT_ID")
    private Task parrent;

    public Task() {}

    public Integer getTaskId() {
        return taskId;
    }

    public void setTaskId(Integer taskId) {
        this.taskId = taskId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public Dashboard getDashboard() {
        return dashboard;
    }

    public void setDashboard(Dashboard dashboard) {
        this.dashboard = dashboard;
    }

    public Task getParrent() {
        return parrent;
    }

    public void setParrent(Task parrent) {
        this.parrent = parrent;
    }
}
