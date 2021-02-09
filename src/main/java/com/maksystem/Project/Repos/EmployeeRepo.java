package com.maksystem.Project.Repos;

import com.maksystem.Project.Models.Employee;
import com.maksystem.Project.Models.RoleTypes;
import com.maksystem.Project.requests.PendingRequest;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.RepositoryDefinition;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional(readOnly=true)
public interface EmployeeRepo extends JpaRepository<Employee, Long> {
	
	// za avtentikacija
	Optional<Employee> findByEmail(@Param("email") String email);
	
	// za pending requests to be approved
	@Query("select new maksystem.login_registration.model.PendingRequest(e.firstName, e.lastName, e.email) "
			+ "from Employee e where e.email = :email")
	PendingRequest findByEmailExisting(String email);

	@Transactional
	@Modifying
	void deleteByEmail(String email);

	@Query("select new maksystem.login_registration.model.PendingRequest(e.firstName, e.lastName, e.email) "
			+ "from Employee e where e.enabled = false")
	List<PendingRequest> listPendingRequests();


	@Transactional
	@Modifying
	@Query("update Employee e " + "set e.role=:role, e.position=:position, e.salary = :salary, e.enabled=true "
			+ "where e.email = :email")
	void completeRegistration(@Param("role") RoleTypes role, @Param("position") String position,
			@Param("salary") int salary, @Param("email") String email);
	


}
