package com.maksystem.Project.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
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


    @OneToMany(mappedBy = "category")
    private Set<Task> tasks;
}
