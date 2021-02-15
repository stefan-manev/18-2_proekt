//package com.maksystem.Project.Models;
//
//import lombok.Getter;
//import lombok.Setter;
//
//import javax.persistence.*;
//
//@Entity
//@Getter
//@Setter
//public class WorkOnProject {
//
//    @EmbeddedId
//    private WorkOnProjectKey id = new WorkOnProjectKey();
//
//    @ManyToOne
//    @MapsId("employeeId")
//    @JoinColumn(name = "employee_id")
//    private Employee employee;
//
//    @ManyToOne
//    @MapsId("projectId")
//    @JoinColumn(name = "project_id")
//    private Project project;
//
//    @ManyToOne
//    @MapsId("categoryId")
//    @JoinColumn(name = "category_id")
//    private Category category;
//
//}
