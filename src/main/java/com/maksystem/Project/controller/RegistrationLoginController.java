package com.maksystem.Project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.maksystem.Project.Repos.EmployeeRepo;
import com.maksystem.Project.Services.RegistrationService;
import com.maksystem.Project.Services.UserService;
import com.maksystem.Project.requests.ApprovedRequest;
import com.maksystem.Project.requests.PendingRequest;
import com.maksystem.Project.requests.RegistrationRequest;

import lombok.AllArgsConstructor;

@AllArgsConstructor
@Controller
public class RegistrationLoginController {

	private final RegistrationService registrationService;
	private final EmployeeRepo employeeRepository;
	private final UserService userService;

	@GetMapping("/index")
	public String registrationForm(Model model) {
		model.addAttribute("employee", new RegistrationRequest());
		return "index";
	}

	@PostMapping("/index")
	public String register(@ModelAttribute("employee") RegistrationRequest registrationRequest) {
		registrationService.register(registrationRequest);
		return "print wait for approval or sth"; // ili nekoja druga strana kaj shto ke pisuva,c ekajte da ve approve
	}

	@GetMapping("/users")
	public String pendingRequests(Model model) {
		model.addAttribute("requests", userService.notEnabledEmployees());
		return "users";
	}

	@GetMapping("/ApproveEmployeeForm/{email}")
	public String approveEmployee(@PathVariable(value = "email") String email, Model model) {
		PendingRequest pr = employeeRepository.findByEmailExisting(email);
		model.addAttribute("approval", pr);
		model.addAttribute("new_info", new ApprovedRequest(email));

		return "approve_employee";

	}


	@PostMapping("/ApproveEmployeeForm") //@PathVariable(value = "email") String email,
	public String saveEmployee(@ModelAttribute("new_info") ApprovedRequest e) {
		// update approved employee
		userService.approveRequest(e.getRole(), e.getPosition(), e.getSalary(), e.getEmail());
		// int approved= employeeRepository.enableEmployee(e.getEmail());

		return "loginform";

	}

	@GetMapping("/declineEmployee/{email}")
	public String deleteEmployee(@PathVariable(value = "email") String email, Model model) {

		userService.deleteEmployee(email);
		return "redirect:/";

		// call delete employee method

	}

}
