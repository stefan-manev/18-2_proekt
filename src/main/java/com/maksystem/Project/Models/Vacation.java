package com.maksystem.Project.Models;

import javax.persistence.*;

@Entity
@Table(name = "vacation")
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int vacation_id;

    
}
