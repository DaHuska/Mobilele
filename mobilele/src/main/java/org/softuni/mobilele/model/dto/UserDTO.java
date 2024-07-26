package org.softuni.mobilele.model.dto;

public record UserDTO(String firstName, String lastName, String username, String password) {
    @Override
    public String firstName() {
        return firstName;
    }

    @Override
    public String lastName() {
        return lastName;
    }

    @Override
    public String username() {
        return username;
    }

    @Override
    public String password() {
        return password;
    }
}
