package com.maksystem.Project.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.maksystem.Project.Models.Absence;
import com.maksystem.Project.Models.Employee;


public interface AbsenceRepo extends JpaRepository<Absence, Long> {
	
	List<Absence> findAllByEmployee(Employee employee);

	//void updateTotalDays(Long id, Integer daysLeft);
}
