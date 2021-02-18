package com.maksystem.Project.controller;

import com.maksystem.Project.Models.Profile;
import com.maksystem.Project.Services.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
public class ProfileController {

    @Autowired
    private ProfileService service;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        List<Profile> listavraboten = service.listAll();
        model.addAttribute("listavraboten", listavraboten);
        System.out.print("Get / ");
        return "info";
    }

    @GetMapping("/admin")
    public String adminView(Model model) {
        List<Profile> listavraboten = service.listAll();
        model.addAttribute("listavraboten", listavraboten);
        System.out.print("Get / ");
        return "admin";
    }

    @GetMapping("/new")
    public String add(Model model) {
        model.addAttribute("profile", new Profile());
        return "new";
    }

    @GetMapping("/header")
    public String header(Model model) {

        return "header";
    }

    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public String saveStudent(@ModelAttribute("profile") Profile std) //"admin"
    {
        service.save(std);
        return "redirect:/admin";
    }

    @RequestMapping("/edit/{id}")
    public ModelAndView showEditStudentPage(@PathVariable(name = "id") int id) {
        ModelAndView mav = new ModelAndView("new");
        Profile std = service.get(id);
        mav.addObject("profile", std);
        return mav;

    }
    @RequestMapping("/delete/{id}")
    public String deletestudent(@PathVariable(name = "id") int id) {
        service.delete(id);
        return "redirect:/admin";
    }


}