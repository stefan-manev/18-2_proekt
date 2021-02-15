package com.maksystem.Project.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
@Getter @Setter
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long category_id;

    private String c_name;

    private String c_description;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

//    @ManyToMany
//    @JoinTable(name = "employee_category", joinColumns = @JoinColumn(name = "category_id"), inverseJoinColumns = @JoinColumn(name = "employee_id"))
//    private Set<Employee> employees = new HashSet<>();

    @OneToMany(mappedBy = "category")
    private Set<Task> tasks;

//    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
//    private Collection<WorkOnProject> wops = new ArrayList<>();

    public Long getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Long category_id) {
        this.category_id = category_id;
    }

    public String getC_name() {
        return c_name;
    }

    public void setC_name(String c_name) {
        this.c_name = c_name;
    }

    public String getC_description() {
        return c_description;
    }

    public void setC_description(String c_description) {
        this.c_description = c_description;
    }

//    public Project getProject() {
//        return project;
//    }
//
//    public void setProject(Project project) {
//        this.project = project;
//    }
//
//    public Set<Task> getTasks() {
//        return tasks;
//    }
//
//    public void setTasks(Set<Task> tasks) {
//        this.tasks = tasks;
//    }
}
