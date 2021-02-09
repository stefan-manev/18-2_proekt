package com.maksystem.Project.Models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Table(name = "shift")
@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Shift {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long shift_id;
    
    private String shift_start;
    private String shift_end;

    private LocalDate date;
    private float worked_hours;
    private float break_hours;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;


}
