//package com.maksystem.Project.Services;
//
//import com.maksystem.Project.Models.*;
//import com.maksystem.Project.Repos.EmployeeRepo;
//import com.maksystem.Project.Repos.ProjectRepo;
//import com.maksystem.Project.Repos.WorkOnProjectRepo;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.Authentication;
//import org.springframework.security.core.annotation.AuthenticationPrincipal;
//import org.springframework.security.core.context.SecurityContextHolder;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.Optional;
//
//@Service
//public class WoPService {
//
////    @Autowired
////    private WorkOnProjectRepo workOnProjectRepo;
//
//    @Autowired
//    private ProjectRepo projectRepo;
//
//    @Autowired
//    private EmployeeRepo employeeRepo;
//
//    @Autowired SecurityService securityService;
//
//    String myEmail;
//
//    private Optional<Employee> whoAmI;
//    private Employee me;
//    private WorkOnProject wop;
//
//    public List<Project> getMyProjects() {
//        Authentication LIU = SecurityContextHolder.getContext().getAuthentication();
//        myEmail = LIU.getName();
////        myEmail = securityService.findLoggedInUserName();
//        System.out.println("\n\nRETURNING EMAIL:\n\n" + myEmail + "\n\n");
//        whoAmI = employeeRepo.findByEmail(myEmail);
//        me = whoAmI.get();
//        System.out.println("\n\nRETURNING EMPLOYEE OBJECT:\n\n" + me + "\n\n");
//        wop = workOnProjectRepo.findWorkOnProjectByEmployee(me);
//        System.out.println("\n\nRETURNING Project OBJECTs:\n\n" + wop + "\n\n");
//
//        return projectRepo.findAllByWops(wop);
//    }
//
//

//}
