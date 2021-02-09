package com.maksystem.Project.controller;

import com.maksystem.Project.Models.Employee;
import com.maksystem.Project.Models.Shift;
import com.maksystem.Project.Services.EmployeeService;
import com.maksystem.Project.Services.ShiftService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDate;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeHomeController {

    private final ShiftService shiftService;
    private final EmployeeService employeeService;

    public EmployeeHomeController(ShiftService shiftService, EmployeeService employeeService) {
        this.shiftService = shiftService;
        this.employeeService = employeeService;
    }

    @GetMapping
    public String getHomepage(Model model){
        List<Shift> allShifts = shiftService.getShifts(Long.valueOf(2));
        model.addAttribute("allShifts", allShifts);
        return "employee/master-template";
    }

    @PostMapping("/start")
    public String startShift(Model model){
        //model.addAttribute("shift", new Shift());

        shiftService.startShift();
        return "employee/master-template";
    }


    @PostMapping("/stop")
    public String endShift(Model model){
        //model.addAttribute("shift", new Shift());
        Employee employee = employeeService.getEmployeeById(Long.valueOf(2));
        LocalDate localDate = LocalDate.now();
        Shift shift = shiftService.getLastShift(employee,localDate );
        shiftService.endShift(shift);
        return "employee/master-template";
    }
}