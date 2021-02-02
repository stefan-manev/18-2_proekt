package com.maksystem.Project.Models;

import lombok.Getter;
import lombok.Setter;
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
    @Getter @Setter
    private int employee_id;

    @Getter @Setter
    private String e_Fname;
    @Getter @Setter
    private String e_Lname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Getter @Setter
    private Date e_birthday;

    @Getter @Setter
    private String email;
    @Getter @Setter
    private float salary;
    @Getter @Setter
    private String position;
    @Getter @Setter
    private String password;
    @Getter @Setter
    private String password_conf;

    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
    @JoinTable(name = "employee_project", joinColumns = { @JoinColumn(name = "employee_id")}, inverseJoinColumns = { @JoinColumn(name = "project_id")})
    @Getter @Setter
    private Set<Project> projects = new HashSet<>();



    @Override
    public String toString() {
        return String.format("Employee: %s %s", getE_Fname(), getE_Lname());
    }
}
