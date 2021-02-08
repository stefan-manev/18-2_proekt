package com.maksystem.Project.Services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.maksystem.Project.Models.Absence;
import com.maksystem.Project.Models.Category;
import com.maksystem.Project.Models.Employee;
import com.maksystem.Project.Models.Project;
import com.maksystem.Project.Models.Vacation;
import com.maksystem.Project.Repos.AbsenceRepo;
import com.maksystem.Project.Repos.EmployeeRepo;
import com.maksystem.Project.Repos.VacationRepo;

@Service
public class AbsenceService {
	private AbsenceRepo absenceRepo;
	private EmployeeRepo employeeRepo;
	
   
    @Autowired
    public AbsenceService(AbsenceRepo absenceRepo, EmployeeRepo employeeRepo) {
		super();
		this.absenceRepo = absenceRepo;
		this.employeeRepo = employeeRepo;
		
	}

	public List<Absence> getAbsences(Long id)
	{
		
		Employee employee= employeeRepo.findById(id).get();
		return absenceRepo.findAllByEmployee(employee);
	}
    
	public List<Absence> getAllAbsences() {
        return absenceRepo.findAll();
    }
	

    
//    public void updateTotalDays(Long id, Integer daysLeft) {
//    	    Employee employee= employeeRepo.findById(id).get();
//            Absence absence=new Absence();
//            absence.setTotal_days(daysLeft);
//            absenceRepo.save(absence);
//            
//        }





	

}