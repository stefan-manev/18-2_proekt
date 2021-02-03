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
@Getter @Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long project_id;

    private String p_name;
    private String p_description;
    private boolean active;

    @OneToMany(mappedBy = "project")
    private Set<Category> categories;

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

    @Override
    public String toString() {
        return "Project{" +
                "Name='" + p_name + '\'' +
                ", Description='" + p_description + '\'' +
                '}';
    }
}
