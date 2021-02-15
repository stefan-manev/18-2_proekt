package com.maksystem.Project.Services;

import com.maksystem.Project.Models.*;
import com.maksystem.Project.Repos.ProjectRepo;
//import com.maksystem.Project.Repos.WorkOnProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

//    @Autowired
//    private WorkOnProjectRepo workOnProjectRepo;


    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }

    public Project getProjectById(Long id) {
        return projectRepo.getOne(id);
    }

    public Project addProject(Project project) {
        if (project != null) {
            projectRepo.save(project);
            return project;
        }

        return null;
    }

    public Project editProject(Long id, Project project) {
        Project p = getProjectById(id);

        if (p != null) {
            project.setProject_id(id);
            projectRepo.save(project);
            return project;
        }

        return null;
    }

    public void deleteProject(Project project) {
        projectRepo.delete(project);
    }

//    public String addemployee(Employee employee, Project project) {
//        WorkOnProject wkp = new WorkOnProject();
//
//        WorkOnProjectKey wkpKey = new WorkOnProjectKey();
//        wkpKey.setEmployeeId(employee.getEmployee_id());
//        wkpKey.setProjectId(project.getProject_id());
//
//        wkp.setEmployee(employee);
//        wkp.setProject(project);
//        wkp.setId(wkpKey);
//
//        try {
//            workOnProjectRepo.save(wkp);
//            return "Employee added";
//        } catch (Exception e) {
//            e.printStackTrace();
//            return "Error occurred";
//        }
//
//    }

    public String addCategory(Category category, Project project) {
        Set<Category> categories = project.getCategories();
        categories.add(category);
        project.setCategories(categories);

        try {
            projectRepo.save(project);
            return "Category added";
        } catch (Exception e) {
            return "Can't add category";
        }
    }


}
