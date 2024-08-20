package org.softuni.mobilele.model.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.softuni.mobilele.model.validation.DateNotInTheFuture;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "users")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @NotEmpty
    @Column(nullable = false)
    private String username;

    @NotEmpty
    @Column(nullable = false)
    private String password;

    @NotEmpty
    @Column(name = "first_name", nullable = false)
    private String firstName;

    @NotEmpty
    @Column(name = "last_name", nullable = false)
    private String lastName;

    @NotNull
    @Column(name = "is_active")
    private boolean isActive;

    @NotNull
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(
            name = "users_user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private List<UserRole> roles = new ArrayList<>();

    @Column(name = "image_url")
    private String imageURL;

    @NotNull
    @DateNotInTheFuture
    @Column
    private Date created;

    @NotNull
    @DateNotInTheFuture
    @Column
    private Date modified;

    public Long getId() {
        return id;
    }

    public UserEntity setId(Long id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public UserEntity setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public UserEntity setPassword(String password) {
        this.password = password;
        return this;
    }

    public String getFirstName() {
        return firstName;
    }

    public UserEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public boolean isActive() {
        return isActive;
    }

    public UserEntity setActive(boolean active) {
        isActive = active;
        return this;
    }

    public List<UserRole> getRoles() {
        return roles;
    }

    public UserEntity setRole(List<UserRole> roles) {
        this.roles = roles;
        return this;
    }

    public String getImageURL() {
        return imageURL;
    }

    public UserEntity setImageURL(String imageURL) {
        this.imageURL = imageURL;
        return this;
    }

    public Date getCreated() {
        return created;
    }

    public UserEntity setCreated(Date created) {
        this.created = created;
        return this;
    }

    public Date getModified() {
        return modified;
    }

    public UserEntity setModified(Date modified) {
        this.modified = modified;
        return this;
    }
}
