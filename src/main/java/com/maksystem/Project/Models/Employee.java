package com.maksystem.Project.Models;

import org.hibernate.annotations.DynamicUpdate;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "employee")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int employee_id;

    private String e_Fname;
    private String e_Lname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date e_birthday;

    private String email;
    private float salary;
    private String position;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "employee_project", joinColumns = { @JoinColumn(name = "employee_id")}, inverseJoinColumns = { @JoinColumn(name = "project_id")})
    private Set<Project> projects = new HashSet<>();

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public String getE_Fname() {
        return e_Fname;
    }

    public void setE_Fname(String e_Fname) {
        this.e_Fname = e_Fname;
    }

    public String getE_Lname() {
        return e_Lname;
    }

    public void setE_Lname(String e_Lname) {
        this.e_Lname = e_Lname;
    }

    public Date getE_birthday() {
        return e_birthday;
    }

    public void setE_birthday(Date e_birthday) {
        this.e_birthday = e_birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public float getSalary() {
        return salary;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return String.format("Employee: %s %s", getE_Fname(), getE_Lname());
    }
}
