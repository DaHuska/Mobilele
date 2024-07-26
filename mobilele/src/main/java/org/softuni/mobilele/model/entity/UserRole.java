package org.softuni.mobilele.model.entity;

import jakarta.persistence.*;
import org.softuni.mobilele.model.enums.RoleType;

@Entity
@Table(name = "user_roles")
public class UserRole {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    Long id;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    RoleType role;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public RoleType getRoleType() {
        return role;
    }

    public void setRoleType(RoleType roleType) {
        this.role = roleType;
    }
}
