package com.maksystem.Project.Models;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name = "registration")
@Getter @Setter
public class Registration {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registration_id;

    private String f_name;
    private String l_name;
    private String email;
    private String password;
    private String password_conf;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public Registration updateRegistration(Registration registration) {
        try {
            this.f_name = registration.f_name;
            this.l_name = registration.l_name;
            this.birthday = registration.birthday;
            this.email = registration.email;
            this.password = registration.password;
            this.password_conf = registration.password_conf;

            return this;
        } catch (Exception e) {
            return null;
        }
    }

}
