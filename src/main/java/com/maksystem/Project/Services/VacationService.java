package com.maksystem.Project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maksystem.Project.Models.Employee;
import com.maksystem.Project.Models.Vacation;
import com.maksystem.Project.Repos.EmployeeRepo;
import com.maksystem.Project.Repos.VacationRepo;

@Service
public class VacationService {
	private VacationRepo vacationRepo;
	private EmployeeRepo employeeRepo;
	
    @Autowired
	public VacationService(VacationRepo vacationRepo, EmployeeRepo employeeRepo) {
		
		this.vacationRepo = vacationRepo;
		this.employeeRepo = employeeRepo;
	}

	public List<Vacation> getVacation(Long id)
	{
		
		Employee employee= employeeRepo.findById(id).get();
		return vacationRepo.findAllByEmployee(employee);
		
		
	}

}
