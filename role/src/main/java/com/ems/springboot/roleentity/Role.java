package com.ems.springboot.roleentity;

import jakarta.persistence.*;

@Entity
@Table(name = "Role")
public class Role {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int roleId; // Follow camelCase naming convention

    @Column(name = "role_name", nullable = false, unique = true)
    private String roleName; // Follow camelCase naming convention

    @Column(name = "description")
    private String description;

    public int getRoleId() {
        return roleId; // Match method name with field
    }

    public void setRoleId(int roleId) {
        this.roleId = roleId; // Match method name with field
    }

    public String getRoleName() {
        return roleName; // Match method name with field
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName; // Match method name with field
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
