package com.maksystem.Project.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "vacation")
@Getter @Setter
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vacation_id;

    private Date vacation_start;
    private Date vacation_end;
    private int total_days;

    @Enumerated(EnumType.STRING)
    private VacationStatus status;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
