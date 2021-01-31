package com.maksystem.Project.Models;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "vacation")
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vacation_id;

    private Date vacation_start;
    private Date vacation_end;
    private static int total_days;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    public int getVacation_id() {
        return vacation_id;
    }

    public void setVacation_id(int vacation_id) {
        this.vacation_id = vacation_id;
    }

    public Date getVacation_start() {
        return vacation_start;
    }

    public void setVacation_start(Date vacation_start) {
        this.vacation_start = vacation_start;
    }

    public Date getVacation_end() {
        return vacation_end;
    }

    public void setVacation_end(Date vacation_end) {
        this.vacation_end = vacation_end;
    }

    public static int getTotal_days() {
        return total_days;
    }

    public static void setTotal_days(int total_days) {
        Vacation.total_days = total_days;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }
}
