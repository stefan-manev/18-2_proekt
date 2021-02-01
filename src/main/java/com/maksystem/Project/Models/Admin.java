package com.maksystem.Project.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.Set;

@Entity
@Table(name = "admin")
public class Admin extends Employee{

    @OneToMany(mappedBy = "admin")
    @Getter @Setter
    private Set<Project> adminProjects;

}
