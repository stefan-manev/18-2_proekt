//package com.maksystem.Project.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.RestController;
//
//import com.maksystem.Project.Models.Absence;
//import com.maksystem.Project.Models.Shift;
//import com.maksystem.Project.Models.Vacation;
//import com.maksystem.Project.Repos.VacationRepo;
//import com.maksystem.Project.Services.AbsenceService;
//import com.maksystem.Project.Services.DummyDataService;
//import com.maksystem.Project.Services.ShiftService;
//import com.maksystem.Project.Services.VacationService;
//
//@RestController
//public class TestController {
//
//	@GetMapping("/")
//	public String helloWorld() {
//		return "Hello World!";
//	}
//	private DummyDataService dummyDataService;
//	private VacationService vacationService;
//	private AbsenceService absenceService;
//	private ShiftService shiftService;
//
//	@Autowired
//	public TestController(DummyDataService dummyDataService, VacationService vacationService,
//			AbsenceService absenceService, ShiftService shiftService) {
//		super();
//		this.dummyDataService = dummyDataService;
//		this.vacationService = vacationService;
//		this.absenceService = absenceService;
//		this.shiftService = shiftService;
//	}
//
//	@GetMapping("/employee/{id}/vacation")
//	public List<Vacation> getVacation(@PathVariable Long id)
//	{
//		return vacationService.getVacation(id);
//
//	}
//
//	@GetMapping("/employee/{id}/absence")
//	public List<Absence> getAbsence(@PathVariable Long id)
//	{
//		return absenceService.getAbsences(id);
//
//	}
//	@GetMapping("/employee/{id}/shift")
//	public List<Shift> getShifts(@PathVariable Long id)
//	{
//		return shiftService.getShifts();
//
//	}
////	@GetMapping("/employee/{id}/{daysleft}/absence_update")
////	public void updateTotalDays(@PathVariable Long id, Integer daysleft)
////	{
////		 absenceService.updateTotalDays(id,daysleft);
////
////	}
//
//
//}
