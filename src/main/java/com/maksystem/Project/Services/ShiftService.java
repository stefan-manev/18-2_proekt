package com.maksystem.Project.Services;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
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


	public List<Shift> getShifts()
	{
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String username = loggedInUser.getName();
		Employee e = this.employeeRepo.findByEmail(username).orElseThrow();
		return shiftRepo.findAllByEmployee(e);
	}

	public List<Shift> getLastShift(Employee employee, LocalDate localDateTime){
    	List<Shift> lastShift = shiftRepo.findByEmployeeAndDate(employee,localDateTime);
    	return lastShift;
	}

	public void startShift(){
		Shift shift = new Shift();
		LocalDateTime date = LocalDateTime.now();
		shift.setDate(date.toLocalDate());
		String time = date.getHour()+":"+date.getMinute();
		shift.setShift_start(time);
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String username = loggedInUser.getName();
		Employee employee = this.employeeRepo.findByEmail(username).orElseThrow();
		shift.setEmployee(employee);

    	shiftRepo.save(shift);
	}

	public void endShift(){

		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String username = loggedInUser.getName();
		Employee employee = this.employeeRepo.findByEmail(username).orElseThrow();
      LocalDate localDate = LocalDate.now();
      List<Shift> shifts = this.getLastShift(employee,localDate);
      Shift latest = shifts.get(shifts.size()-1);
		LocalDateTime date = LocalDateTime.now();
		String timeOut = date.getHour()+":"+date.getMinute();

		latest.setShift_end(timeOut);

    	shiftRepo.save(latest);
	}




	

	

}
