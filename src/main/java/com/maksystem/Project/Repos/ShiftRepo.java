package com.maksystem.Project.Repos;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import com.maksystem.Project.Models.Absence;
import com.maksystem.Project.Models.Employee;
import com.maksystem.Project.Models.Shift;
import org.springframework.stereotype.Repository;

@Repository
public interface ShiftRepo extends JpaRepository <Shift,Long> {
	List<Shift> findAllByEmployee(Employee employee);

	Shift findByEmployeeAndDate(Employee employee, LocalDate localDateTime);

}
