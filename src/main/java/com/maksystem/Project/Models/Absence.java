package com.maksystem.Project.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "absence")
@Getter @Setter
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long absence_id;

    private Date absence_start;
    private Date absence_end;

    private int total_days;

    @Enumerated(EnumType.STRING)
    private VacationStatus status;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


}
