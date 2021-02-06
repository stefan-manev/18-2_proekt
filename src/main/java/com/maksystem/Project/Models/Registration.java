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

    @Getter
    @Setter
    private Long registration_id;

    private String fname;
    private String lname;

    @Getter
    @Setter
    private String f_name;
    @Getter @Setter
    private String l_name;
    @Getter @Setter
    private String email;
    private String password;
    private String password_conf;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date birthday;

    public Registration updateRegistration(Registration registration) {
        try {
            this.fname = registration.fname;
            this.lname = registration.lname;
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
