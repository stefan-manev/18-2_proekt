package com.maksystem.Project.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

import org.springframework.format.annotation.DateTimeFormat;

import java.sql.Date;

@Entity
@Table(name = "absence")
@Getter @Setter
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long absence_id;


    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date absence_start;
   
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date absence_end;

    private String comment;

    private int total_days;

    @Enumerated(EnumType.STRING)
    private VacationStatus status=VacationStatus.PENDING;
    
    @Enumerated(EnumType.STRING)
    private AbsenceType type;
    
    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
  

}
