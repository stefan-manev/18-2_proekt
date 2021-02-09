package com.maksystem.Project.requests;

import java.sql.Date;

import org.springframework.stereotype.Component;

import lombok.*;

// attributes entered in registration form
@AllArgsConstructor
@Getter
@Setter
@ToString
@NoArgsConstructor
public class RegistrationRequest {
	
	private String first_name;
	private String last_name;
	private String email;
	private String phone;
	private String password;
	private String password_confirmation;
	private Date bday;
	private String position;
	private String role;
	private int salary;
}
