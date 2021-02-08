package com.maksystem.Project.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maksystem.Project.Models.Employee;
import com.maksystem.Project.Models.Vacation;

public interface VacationRepo extends JpaRepository<Vacation, Long> {
	
	List<Vacation> findAllByEmployee(Employee employee);

}
