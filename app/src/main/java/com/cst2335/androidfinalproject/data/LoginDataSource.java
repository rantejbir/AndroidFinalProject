package com.cst2335.androidfinalproject.data;

import com.cst2335.androidfinalproject.data.model.LoggedInUser;

import java.io.IOException;

/**
 * Author:Daksh Sharma
 * Date updated: 8/4/2023
 * purpose:The LoginDataSource class's main function is to offer a method for authenticating users and returning
 * a LoggedInUser object to do so. The login method
 * uses the user's username and password as input parameters and makes an attempt to verify their identity.
 */
public class LoginDataSource {

    public Result<LoggedInUser> login(String username, String password) {

        try {
            // TODO: handle loggedInUser authentication
            LoggedInUser fakeUser =
                    new LoggedInUser(
                            java.util.UUID.randomUUID().toString(),
                            "Jane Doe");
            return new Result.Success<>(fakeUser);
        } catch (Exception e) {
            return new Result.Error(new IOException("Error logging in", e));
        }
    }

    public void logout() {
        // TODO: revoke authentication
    }
}