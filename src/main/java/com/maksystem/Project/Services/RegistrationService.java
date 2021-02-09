package com.maksystem.Project.Services;


import com.maksystem.Project.Models.Employee;
import com.maksystem.Project.Models.HasRole;
import com.maksystem.Project.Models.Registration;
import com.maksystem.Project.Models.Role;
import com.maksystem.Project.Repos.HasRoleRepo;
import com.maksystem.Project.Repos.RegistrationRepo;
import com.maksystem.Project.email.EmailValidator;
import com.maksystem.Project.requests.RegistrationRequest;

import lombok.AllArgsConstructor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// ke se potsreduva
@Service
@AllArgsConstructor
public class RegistrationService {
	
	
	private final UserService userService;
	private final EmailValidator emailValidator;

	public String register(RegistrationRequest request) {
		boolean isValidEmail = emailValidator.test(request.getEmail());
		if (request.getFirst_name() != null
				&& request.getLast_name() != null 
				&& request.getEmail() != null
				&& request.getBday() != null
				&& request.getPassword() != null
				&& request.getPassword_confirmation() != null) {
			
			if (isValidEmail) {
				if (request.getPassword().equals(request.getPassword_confirmation())) {

					// registracija na employee-to
					userService.signUp(new Employee(request.getFirst_name(), request.getLast_name(),
							request.getEmail(), request.getPhone(), request.getBday(), request.getPassword()));

					return "success";
				} else {
					// ne matching passwords
					throw new IllegalStateException("password is not matching, please try again");
				}
			} else {
				// nevaliden email
				throw new IllegalStateException("email not valid");
			}

		} else {
			// missing fields
			throw new IllegalStateException("missing fieldss");
		}
	}
}
