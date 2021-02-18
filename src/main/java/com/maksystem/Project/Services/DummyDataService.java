//package com.maksystem.Project.Services;
//
//
//import java.sql.Date;
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import com.maksystem.Project.Models.Absence;
//import com.maksystem.Project.Models.Employee;
//import com.maksystem.Project.Models.Shift;
//import com.maksystem.Project.Models.Vacation;
//import com.maksystem.Project.Repos.AbsenceRepo;
//import com.maksystem.Project.Repos.EmployeeRepo;
//import com.maksystem.Project.Repos.ShiftRepo;
//import com.maksystem.Project.Repos.VacationRepo;
//
//
//@Service
//public class DummyDataService {
//
//
//	private final AbsenceRepo absenceRepo;
//
//	private final ShiftRepo shiftRepo;
//
//	private final VacationRepo vacationRepo;
//
//	private final EmployeeRepo emoployeeRepo;
//
//	public DummyDataService(AbsenceRepo absenceRepo, ShiftRepo shiftRepo, VacationRepo vacationRepo,
//			EmployeeRepo emoployeeRepo) {
//
//		this.absenceRepo = absenceRepo;
//		this.shiftRepo = shiftRepo;
//		this.vacationRepo = vacationRepo;
//		this.emoployeeRepo = emoployeeRepo;
//		insertData();
//	}
//
//	public void insertData()
//	{
//		 Employee employee= new Employee();
//		 employee.setBirthday(new Date(20L));
//		 employee.setEmail("aleksandramanolceva2@yahoo.com");
//		 employee.setSalary(1500);
//		 emoployeeRepo.save(employee);
//		 Vacation vacation=new Vacation();
//		 vacation.setTotal_days(22);
//		 vacation.setEmployee(employee);
//		 vacationRepo.save(vacation);
//		 Absence absence=new Absence();
//		 absence.setTotal_days(10);
//		 absence.setEmployee(employee);
//		 absenceRepo.save(absence);
//		 Shift shift=new Shift();
//		 shift.setBreak_hours(5);
//		 shift.setWorked_hours(10);
//		 shift.setEmployee(employee);
//		 shiftRepo.save(shift);
//	}
//
//
//
//
//}
