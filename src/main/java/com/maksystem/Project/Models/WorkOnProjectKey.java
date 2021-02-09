package com.maksystem.Project.Models;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@Getter @Setter
@EqualsAndHashCode
public class WorkOnProjectKey implements Serializable {

    private Long employee;

    private Long project;

    private Long category;

}
