package org.softuni.mobilele.util;

import org.softuni.mobilele.model.entity.UserRole;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.SessionScope;

@Component
@SessionScope
public class CurrentUser {
    private String username;

    private String firstName;

    private String lastName;

    private UserRole role;

    boolean isLogged;

    public void login(String firstName, String lastName, String username, UserRole role) {
        setUsername(username);
        setFirstName(firstName);
        setLastName(lastName);
        setRole(role);
        setLogged(true);
    }

    public void logout() {
        setUsername(null);
        setFirstName(null);
        setLastName(null);
        setRole(null);
        setLogged(false);
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

    public UserRole getRole() {
        return role;
    }

    public void setRole(UserRole role) {
        this.role = role;
    }
}
