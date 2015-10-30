package com.softserve.edu.entities;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Roman on 30.10.2015.
 *
 */

@Entity
@Table(name = "USERS")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "USER_ID")
    private Integer userId;

    @Column(name = "LOGIN")
    private String login;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name = "LAST_NAME")
    private String lastName;

    @Column(name = "PASSWORD")
    private String password;

    @Column(name = "EMAIL")
    private String email;

    /* @OneToMany(mappedBy = "assignee")
    private List<Task> taskList = new ArrayList<Task>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "author")
    private List<Dashboard> dashboardList = new ArrayList<Dashboard>();

    private List<Dashboard> assignedToDashboards = new ArrayList<Dashboard>(); */

    public User() {}

    public User(String login, String email, String password) {
        this.login = login;
        this.email = email;
        this.password = password;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    /* public List<Dashboard> getDashboardList() {
        return dashboardList;
    }

    public void setDashboardList(List<Dashboard> dashboardList) {
        this.dashboardList = dashboardList;
    }

    public List<Task> getTaskList() {
        return taskList;
    }

    public void setTaskList(List<Task> taskList) {
        this.taskList = taskList;
    }

    public List<Dashboard> getAssignedToDashboards() {
        return assignedToDashboards;
    }

    public void setAssignedToDashboards(List<Dashboard> assignedToDashboards) {
        this.assignedToDashboards = assignedToDashboards;
    } */
}
