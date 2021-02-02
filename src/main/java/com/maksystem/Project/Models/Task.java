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

    @Enumerated(EnumType.STRING)
    @Getter @Setter
    private TaskStatus taskStatus;

    @ManyToOne
    @JoinColumn(name = "category_id")
    @Getter @Setter
    private Category category;

    @Override
    public String toString() {
        return "Task{" +
                "t_name='" + t_name + '\'' +
                ", t_description='" + t_description + '\'' +
                '}';
    }
}
