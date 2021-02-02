package com.maksystem.Project.Repos;

import com.maksystem.Project.Models.Registration;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface RegistrationRepo extends JpaRepository<Registration, Long> {
//    public List<Registration> findRegistrationsByF_name(String fname);
//    public List<Registration> findRegistrationsByL_name(String lname);
}
