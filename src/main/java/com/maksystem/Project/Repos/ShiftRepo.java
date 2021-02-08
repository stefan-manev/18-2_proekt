package com.maksystem.Project.Repos;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.maksystem.Project.Models.Absence;
import com.maksystem.Project.Models.Employee;
import com.maksystem.Project.Models.Shift;

public interface ShiftRepo extends JpaRepository <Shift,Long> {
	List<Shift> findAllByEmployee(Employee employee);
}
