package org.softuni.mobilele.model.dto;

import jakarta.validation.constraints.NotEmpty;
import org.softuni.mobilele.model.validation.ExistingUsername;

import java.util.Objects;

public final class UserLoginDTO {
    @NotEmpty
    @ExistingUsername
    private String username;

    @NotEmpty
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
