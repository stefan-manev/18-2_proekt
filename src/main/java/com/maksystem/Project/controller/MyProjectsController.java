package com.maksystem.Project.controller;

//import com.maksystem.Project.Services.WoPService;
import com.maksystem.Project.Services.E_P_C_Service;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(path = "/my_projects")
public class MyProjectsController {

  private final E_P_C_Service e_p_c_service;

    public MyProjectsController (E_P_C_Service e_p_c_service) {
        this.e_p_c_service = e_p_c_service;
    }

    @GetMapping
    public String getMyProjects(Model model) {
        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String email = loggedInUser.getName();
        model.addAttribute("myProjects", e_p_c_service.getProjectsByEmployee(email));
        model.addAttribute("myCategories", e_p_c_service.getCategoriesByEmployee(email));
        return "my_projects";
    }

    // maybe map multiple models, or figure out the mapping if going for single models
//    @GetMapping
//    public String getMyCategories(Model model) {
//        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
//        String email = loggedInUser.getName();
//        model.addAttribute("myCategories", e_p_c_service.getCategoriesByEmployee(email));
//        return "my_projects";
//    }

}
