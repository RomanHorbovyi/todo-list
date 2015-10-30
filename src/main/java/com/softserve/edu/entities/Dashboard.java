package com.softserve.edu.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Created by Roman on 30.10.2015.
 *
 */

@Entity
@Table(name = "DASHBOARDS")
public class Dashboard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "DASHBOARD_ID")
    private Integer dashboardId;

    @Column(name = "DASHBOARD_NAME")
    private String name;

    @Column(name = "DASHBOARD_DESCRIPTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "USER_ID")
    private User author;

    @ManyToMany
    @JoinTable(name = "USERS_DASHBOARDS", joinColumns = @JoinColumn(name = "DASHBOARD_ID"),
            inverseJoinColumns = @JoinColumn(name = "USER_ID"))
    private Set<User> assignedList = new HashSet<User>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "dashboard")
    private List<Task> taskList = new ArrayList<Task>();

    @Column(name = "DASHBOARD_STATUS")
    private boolean status = false;

    public Dashboard() {}

    public Integer getDashboardId() {
        return dashboardId;
    }

    public void setDashboardId(Integer dashboardId) {
        this.dashboardId = dashboardId;
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

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Set<User> getAssignedList() {
        return assignedList;
    }

    public void setAssignedList(Set<User> assignedList) {
        this.assignedList = assignedList;
    }
}
