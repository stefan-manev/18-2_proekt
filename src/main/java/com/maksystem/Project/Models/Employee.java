package com.maksystem.Project.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "employee")
@Getter @Setter
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employee_id;

    private String e_Fname;
    private String e_Lname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date e_birthday;

    private String email;
    private float salary;
    private String position;
    private String password;
    private String password_conf;

    @ManyToMany
    private Set<Role> roles;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "employee_project", joinColumns = { @JoinColumn(name = "employee_id")}, inverseJoinColumns = { @JoinColumn(name = "project_id")})
    private Set<Project> projects = new HashSet<>();



    @Override
    public String toString() {
        return String.format("Employee: %s %s", getE_Fname(), getE_Lname());
    }
}
