package com.maksystem.Project.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "hasrole")
@Getter @Setter
public class HasRole {

    @EmbeddedId
    private HasRoleKey id;

    @ManyToOne
    @MapsId("employee")
    private Employee employee;

    @ManyToOne
    @MapsId("role")
    private Role role;
}
