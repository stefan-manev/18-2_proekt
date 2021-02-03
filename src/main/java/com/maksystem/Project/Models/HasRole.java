package com.maksystem.Project.Models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.Table;

@Entity
@Table
@Getter @Setter
public class HasRole {

    @ManyToOne
    @MapsId("employee")
    private Employee employee;

    @ManyToOne
    @MapsId("role")
    private Role role;
}
