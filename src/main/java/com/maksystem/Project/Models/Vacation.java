package com.maksystem.Project.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "vacation")
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int vacation_id;

    @Getter @Setter
    private Date vacation_start;
    @Getter @Setter
    private Date vacation_end;
    @Getter @Setter
    private static int total_days;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @Getter @Setter
    private Employee employee;

}
