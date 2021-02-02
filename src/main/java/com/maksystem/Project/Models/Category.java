package com.maksystem.Project.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int category_id;

    @Getter @Setter
    private String c_name;
    @Getter @Setter
    private String c_description;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @Getter @Setter
    private Project project;


    @OneToMany(mappedBy = "category")
    @Getter @Setter
    private Set<Task> tasks;
}
