package com.cst2335.androidfinalproject.data;

import java.io.IOException;

/**
 * @author samar
 * Users can log in and out of an application using the authentication mechanism represented by this Java class, LoginDataSource.
 * The login() method tries to authenticate the user by accepting a username and password as inputs. For testing reasons, the function
 * currently creates a fake LoggedInUser object with the name "Jane Doe" and a randomly generated UUID. The method returns a Result if
 * any exceptions are thrown during the authentication procedure.error
 * message and error object. Although it is not currently implemented, the logout() method is meant to revoke authentication.
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

    }
}