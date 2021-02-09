package com.maksystem.Project.controller;

import com.maksystem.Project.Models.Shift;
import com.maksystem.Project.Services.ShiftService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.time.LocalDateTime;
import java.util.List;

@Controller
@RequestMapping("/employee")
public class EmployeeHomeController {

    private final ShiftService shiftService;

    public EmployeeHomeController(ShiftService shiftService) {
        this.shiftService = shiftService;
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
}