package com.ems.springboot.departmententity;


import jakarta.persistence.*;

@Entity
@Table(name = "Department")
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int department_id;

    @Column(name = "department_name", nullable = false, unique = true)
    private String departmentName;

    @Column(name = "location")
    private String location;

    // Getters and Setters

    public int getDepartmentId() {
        return department_id;
    }

    public void setDepartmentId(int department_id) {
        this.department_id = department_id;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}