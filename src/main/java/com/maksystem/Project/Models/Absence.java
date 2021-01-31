package com.maksystem.Project.Models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "absence")
public class Absence {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int absence_id;

    private Date absence_start;
    private Date absence_end;

    private static int total_days;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public int getAbsence_id() {
        return absence_id;
    }

    public void setAbsence_id(int absence_id) {
        this.absence_id = absence_id;
    }

    public Date getAbsence_start() {
        return absence_start;
    }

    public void setAbsence_start(Date absence_start) {
        this.absence_start = absence_start;
    }

    public Date getAbsence_end() {
        return absence_end;
    }

    public void setAbsence_end(Date absence_end) {
        this.absence_end = absence_end;
    }

    public static int getTotal_days() {
        return total_days;
    }

    public static void setTotal_days(int total_days) {
        Absence.total_days = total_days;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
