package com.maksystem.Project.Repos;

import com.maksystem.Project.Models.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	public Employee findEmployeeByEmail(String email);
}
