package com.maksystem.Project.Repos;

import com.maksystem.Project.Models.Employee;
import com.maksystem.Project.Models.HasRole;
import com.maksystem.Project.Models.HasRoleKey;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface HasRoleRepo extends JpaRepository<HasRole, HasRoleKey> {

    public List<HasRole> findAllByEmployee(Employee employee);
}
