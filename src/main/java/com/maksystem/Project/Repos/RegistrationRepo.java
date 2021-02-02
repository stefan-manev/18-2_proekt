package com.maksystem.Project.Repos;

import com.maksystem.Project.Models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationRepo extends JpaRepository<Registration, Integer> {
    public List<Registration> findAllByFName(String fname);
    public List<Registration> findAllByLName(String lname);
}
