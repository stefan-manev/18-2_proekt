package com.maksystem.Project.Repos;

import com.maksystem.Project.Models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationRepo extends JpaRepository<Registration, Long> {
    public List<Registration> findRegistrationsByFname(String name);
    public List<Registration> findRegistrationsByLname(String name);
}
