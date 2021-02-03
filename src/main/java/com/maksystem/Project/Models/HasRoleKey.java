package com.maksystem.Project.Models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;

@Embeddable
@Getter @Setter
@EqualsAndHashCode
public class HasRoleKey {

    private Long employee;

    private Long role;
}
