package com.maksystem.Project.Services;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

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

	

    public ShiftService(ShiftRepo shiftRepo, EmployeeRepo employeeRepo) {
		this.shiftRepo = shiftRepo;
		this.employeeRepo = employeeRepo;
	}


	public List<Shift> getShifts(Long id)
	{
		Employee employee = employeeRepo.findById(Long.valueOf(2)).orElseThrow();
		return shiftRepo.findAllByEmployee(employee);
	}

	public void startShift(){
		Shift shift = new Shift();
		LocalDateTime date = LocalDateTime.now();
		shift.setDate(date.toLocalDate());
		String time = date.getHour()+":"+date.getMinute();
		shift.setShift_start(time);

    	shiftRepo.save(shift);
	}

	public void endShift(Shift s, String timeOut){
    	Shift alreadyStartedShift = shiftRepo.findById(s.getShift_id()).orElseThrow();
    	alreadyStartedShift.setShift_end(timeOut);

    	shiftRepo.save(alreadyStartedShift);
	}




	

	

}
