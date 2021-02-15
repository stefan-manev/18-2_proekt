package com.maksystem.Project.Services;

import com.maksystem.Project.Models.Category;
import com.maksystem.Project.Models.Emp_Proj_Cat;
import com.maksystem.Project.Models.Employee;
import com.maksystem.Project.Models.Project;
import com.maksystem.Project.Repos.CategoryRepo;
import com.maksystem.Project.Repos.E_P_C_Repo;
import com.maksystem.Project.Repos.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class E_P_C_Service {

    @Autowired
    private E_P_C_Repo e_p_c_repo;

    @Autowired
    private ProjectRepo projectRepo;

    @Autowired
    private CategoryRepo categoryRepo;

    private EmployeeService employeeService;

    public E_P_C_Service(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public Set<Project> getProjectsByEmployee(String email) {
        Employee me = employeeService.findByEmail(email);
        Long me_id = me.getEmployee_id();
        List<Emp_Proj_Cat> thingsIWorkOn = new ArrayList<>();
        thingsIWorkOn = e_p_c_repo.findAllByEmp(me_id);
        Set<Project> projects = new HashSet<>();
        thingsIWorkOn.forEach(row -> { // gets project_id from emp_proj_cat, gets project by id, adds project to list
            projects.add(
                    projectRepo.getOne(row.getProj_id())
            );
        });
        return projects;
    }

    public List<Category> getCategoriesByEmployee(String email) {
        Employee me = employeeService.findByEmail(email);
        Long me_id = me.getEmployee_id();
        List<Emp_Proj_Cat> thingsIWorkOn = new ArrayList<>();
        thingsIWorkOn = e_p_c_repo.findAllByEmp(me_id);
        List<Category> categories = new ArrayList<>();
        thingsIWorkOn.forEach(row -> {
            categories.add(
                    categoryRepo.getOne(row.getCat_id())
            );
        });
        return categories;
    }

}
