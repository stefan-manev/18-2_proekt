package com.maksystem.Project.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
@Table(name = "vacation")
@Getter @Setter
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long vacation_id;


    @Getter @Setter
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date vacation_start;
    @Getter @Setter
    @DateTimeFormat(pattern="yyyy-MM-dd")

    private Date vacation_end;
    private int total_days;

    @Enumerated(EnumType.STRING)
    private VacationStatus status= VacationStatus.PENDING;
    
    @Enumerated(EnumType.STRING)
    private VacationType type;
    
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
