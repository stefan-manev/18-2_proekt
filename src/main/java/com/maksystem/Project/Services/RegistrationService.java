package com.maksystem.Project.Services;

import com.maksystem.Project.Models.Employee;
import com.maksystem.Project.Models.Registration;
import com.maksystem.Project.Models.Role;
import com.maksystem.Project.Repos.EmployeeRepo;
import com.maksystem.Project.Repos.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepo registrationRepo;

    @Autowired
    private EmployeeService employeeService;

    public List<Registration> getAllRegistrations() {
        return registrationRepo.findAll();
    }

    public Registration addRegistration(Registration registration) {

        if (registration != null && hasAllComps(registration)) {
            registrationRepo.save(registration);
        }

        return registration;
    }

    public Registration getById(Long id) {
        return registrationRepo.getOne(id);
    }

    public List<Registration> getByName(String name) {
        return registrationRepo.findRegistrationsByFname(name);
    }

    public List<Registration> getByLastName(String name) {
        return registrationRepo.findRegistrationsByLname(name);
    }

    public Registration editRegistration(Long id, Registration registration) {

        if (getById(id) == null) return null;

        Registration reg = getById(id);

        reg.updateRegistration(registration);

        try {
            registrationRepo.save(reg);
            return reg;
        } catch (Exception e) {
            return null;
        }

    }

    public String deleteRegistration(Long id) {
        try {
            registrationRepo.deleteById(id);
            return "DELETED";
        } catch (Exception e) {
            return "NOTDELETED";
        }

    }

    private boolean hasAllComps(Registration registration) {
        if (registration.getFname() != null &&
            registration.getLname() != null &&
            registration.getBirthday() != null &&
            registration.getPassword() != null &&
            registration.getPassword_conf() != null &&
            registration.getEmail() != null) {
            return true;
        }
        return false;
    }

    public boolean aprove(Registration registration, Role role, String position, float salary) {
        Employee employee = new Employee();
        employee.setFname(registration.getFname());
        employee.setLname(registration.getLname());
        employee.setBirthday(registration.getBirthday());
        employee.setEmail(registration.getEmail());
        employee.setPassword(registration.getPassword());
        employee.setPassword_conf(registration.getPassword_conf());

        Set<Role> set = new HashSet<>();
        set.add(role);
        employee.setRoles(set);

        employee.setPosition(position);
        employee.setSalary(salary);

        try {
            employeeService.insertEmployee(employee);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
