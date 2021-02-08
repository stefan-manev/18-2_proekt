package com.maksystem.Project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maksystem.Project.Models.Absence;
import com.maksystem.Project.Models.Employee;
import com.maksystem.Project.Models.Shift;
import com.maksystem.Project.Repos.AbsenceRepo;
import com.maksystem.Project.Repos.EmployeeRepo;
import com.maksystem.Project.Repos.ShiftRepo;

@Service
public class ShiftService {
	
	private ShiftRepo shiftRepo;
	private EmployeeRepo employeeRepo;
	
   
    @Autowired
    public ShiftService(ShiftRepo shiftRepo, EmployeeRepo employeeRepo) {
		super();
		this.shiftRepo = shiftRepo;
		this.employeeRepo = employeeRepo;
	}


	public List<Shift> getShifts(Long id)
	{
		
		Employee employee= employeeRepo.findById(id).get();
		return shiftRepo.findAllByEmployee(employee);
	}


	

	

}
