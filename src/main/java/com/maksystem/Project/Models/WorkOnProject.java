package com.maksystem.Project.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "workonproject")
@Getter @Setter
public class WorkOnProject {

    @EmbeddedId
    private WorkOnProjectKey id;

    @ManyToOne
    @MapsId("employee")
    private Employee employee;

    @ManyToOne
    @MapsId("project")
    private Project projectl;

    @ManyToOne
    @MapsId("category")
    private Category category;
}
