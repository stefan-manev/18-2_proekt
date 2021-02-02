package com.maksystem.Project.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "shift")
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int shift_id;

    @Getter @Setter
    private String shift_start;
    @Getter @Setter
    private String shift_end;
    @Getter @Setter
    private float worked_hours;
    @Getter @Setter
    private float break_hours;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    @Getter @Setter
    private Employee employee;
}
