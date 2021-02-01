package com.maksystem.Project.Models;

import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.Objects;

@Entity
@DynamicUpdate
@Table(name = "task")
public class Task {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int task_id;

    @Getter @Setter
    private String t_name;
    @Getter @Setter
    private String t_description;

    @Getter @Setter
    private boolean active;

    @ManyToOne
    @JoinColumn(name = "project_id")
    @Getter @Setter
    private Project project;

    @Override
    public String toString() {
        return "Task{" +
                "t_name='" + t_name + '\'' +
                ", t_description='" + t_description + '\'' +
                '}';
    }
}
