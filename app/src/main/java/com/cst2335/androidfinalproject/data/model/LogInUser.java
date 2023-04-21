package com.cst2335.androidfinalproject.data.model;

/**
 * Author:Daksh Sharma
 * Date updated: 8/4/2023
 * purpose:A user who has successfully logged into the programme is represented by the class LoggedInUser. When a new LoggedInUser object is created, its two private properties, userId and displayName. A user's userId field serves
 * as a distinctive identification, while the displayName field serves as a name that may be seen by other users.
 */
public class LogInUser {


    private String userId;
    private String displayName;


    public LogInUser(String userId, String displayName) {
        this.userId = userId;
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }

    public String getUserId() {
        return userId;
    }


}