package com.cst2335.androidfinalproject.data;

import com.cst2335.androidfinalproject.data.model.LogInUser;

import java.io.IOException;

/**
 * Author:Daksh Sharma
 * Date updated: 8/4/2023
 * purpose:The LoginDataSource class's main function is to offer a method for authenticating users and returning
 * a LogInUser object to do so. The login method
 * uses the user's username and password as input parameters and makes an attempt to verify their identity.
 */
public class LoginDataSource {

    public resultModel<LogInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            LogInUser fakeUser =
                    new LogInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");
            return new resultModel.Success<>(fakeUser);
        } catch (Exception e) {
            return new resultModel.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}