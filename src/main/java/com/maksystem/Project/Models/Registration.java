package com.maksystem.Project.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "registration")
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter @Setter
    private int registration_id;

    @Getter @Setter
    private String f_name;
    @Getter @Setter
    private String l_name;
    @Getter @Setter
    private String email;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Getter @Setter
    private Date birthday;

}
