package com.cst2335.androidfinalproject.data.model;

/**
 * Author:Daksh Sharma
 * Date updated: 8/4/2023
 * purpose:A user who has successfully logged into the programme is represented by the class LogInUser. When a new LogInUser object is created, its two private properties, userId and displayName. A user's userId field serves
 * as a distinctive identification, while the displayName field serves as a name that may be seen by other users.
 */
public class LogInUser {

    private String idUser;
    private String displayName;


    public LogInUser(String idUser, String displayName) {
        this.idUser = idUser;
        this.displayName = displayName;
    }
    public String getDisplayName() {
        return displayName;
    }

    public String getIdUser() {
        return idUser;
    }


}