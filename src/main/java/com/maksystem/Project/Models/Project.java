package com.maksystem.Project.Models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DynamicUpdate
@Table(name = "project")
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int project_id;

    @Getter @Setter
    private String p_name;
    @Getter @Setter
    private String p_description;
    @Getter @Setter
    private boolean active;

    @OneToMany(mappedBy = "project")
    @Getter @Setter
    private Set<Task> tasks;

    @ManyToOne
    @JoinColumn(name = "admin")
    @Getter @Setter
    private Admin admin;

    @ManyToMany(fetch = FetchType.LAZY, cascade = { CascadeType.PERSIST, CascadeType.MERGE})
    @Getter @Setter
    private Set<Employee> employees = new HashSet<>();

    @Override
    public String toString() {
        return "Project{" +
                "Name='" + p_name + '\'' +
                ", Description='" + p_description + '\'' +
                '}';
    }
}
