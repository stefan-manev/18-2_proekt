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

    private String fname;
    private String lname;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    private String email;
    private float salary;
    private String position;
    private String password;
    private String password_conf;

    @Override
    public String toString() {
        return String.format("Employee: %s %s", getFname(), getLname());
    }
}
