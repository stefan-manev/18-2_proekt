package com.maksystem.Project.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "shift")
@Getter @Setter
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shift_id;

    private String shift_start;
    private String shift_end;
    private float worked_hours;
    private float break_hours;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;
}
