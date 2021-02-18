package com.maksystem.Project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;

import org.springframework.security.core.context.SecurityContextHolder;

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
        List<Shift> allShifts = shiftService.getShifts();
        model.addAttribute("allShifts", allShifts);
        return "employee/master-template";
    }

    @PostMapping("/start")
    public String startShift(Model model){
        shiftService.startShift();
        return "redirect:/employee";
    }




    @PostMapping("/stop")
    public String endShift(){
        shiftService.endShift();
        return "redirect:/employee";
    }

    @RequestMapping("/profil")
    public String v(Model model)
    {
        List<Employee> listemp = employeeService.getAllEmployees();
        model.addAttribute("listemp", listemp);

        return "profil";
    }
}