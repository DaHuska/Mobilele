package org.softuni.mobilele.util;

import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {
    String username;

    String password;

    String firstName;

    String lastName;

    boolean isLogged;

    public void login(String firstName, String lastName, String username) {
        this.username = username;
        this.firstName = firstName;
        this.lastName = lastName;
        this.isLogged = true;
    }

    public void logout() {
        this.username = null;
        this.firstName = null;
        this.lastName = null;
        this.isLogged = false;
    }

    public String getUsername() {
        return username;
    }

    public CurrentUser setUsername(String username) {
        this.username = username;

        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public CurrentUser setFirstName(String firstName) {
        this.firstName = firstName;

        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public CurrentUser setLastName(String lastName) {
        this.lastName = lastName;

        return this;
    }

    public boolean isLogged() {
        return isLogged;
    }

    public CurrentUser setLogged(boolean logged) {
        isLogged = logged;

        return this;
    }
}
