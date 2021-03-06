package com.maksystem.Project.Services;

import com.maksystem.Project.Models.Employee;
import com.maksystem.Project.Models.Role;
import com.maksystem.Project.Repos.EmployeeRepo;
import com.maksystem.Project.Repos.RoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
// ne go koristime za najava i registracija
// to ask dragan
@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private RoleRepo roleRepo;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    public List<Employee> getAllEmployees() {
        return employeeRepo.findAll();
    }

    public Employee getEmployeeById(Long id) {
        return employeeRepo.getOne(id);
    }

	/*
	 * public Employee insertEmployee(Employee employee) {
	 * employee.setPassword(bCryptPasswordEncoder.encode(employee.getPassword()));
	 * employee.setPassword_conf(bCryptPasswordEncoder.encode(employee.
	 * getPassword_conf()));
	 * 
	 * employeeRepo.save(employee);
	 * 
	 * return employee; }
	 */

    public Employee findByEmail(String email){
        return employeeRepo.findByEmail(email).orElseThrow();
    }
}
