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
    @Getter @Setter
    private String password;
    @Getter @Setter
    private String password_conf;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Getter @Setter
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
