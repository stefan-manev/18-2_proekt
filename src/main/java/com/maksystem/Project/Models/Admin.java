package com.maksystem.Project.Models;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "admin")
public class Admin extends Employee{

    @OneToMany(mappedBy = "admin")
    private Set<Project> adminProjects;

    public Set<Project> getAdminProjects() {
        return adminProjects;
    }

    public void setAdminProjects(Set<Project> projects) {
        this.adminProjects = projects;
    }
}
