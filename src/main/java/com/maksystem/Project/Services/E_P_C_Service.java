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

import java.util.*;

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

    public List<Project> getProjectsByEmployee(String email) {
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
        List<Project> projectsList = new ArrayList<Project>(projects);
        Collections.sort(projectsList, new Comparator<Project>() {

            public int compare(Project p1, Project p2) {
                // compare two instance of `Score` and return `int` as result.
                return p1.getProject_id().compareTo(p2.getProject_id());
            }
        });
        return projectsList;
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
        List<Category> categoryList = new ArrayList<Category>(categories);
        Collections.sort(categoryList, new Comparator<Category>() {

            public int compare(Category c1, Category c2) {
                // compare two instance of `Score` and return `int` as result.
                return c1.getCategory_id().compareTo(c2.getCategory_id());
            }
        });
        return categoryList;
    }

}
