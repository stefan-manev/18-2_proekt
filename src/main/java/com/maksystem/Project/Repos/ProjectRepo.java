package com.maksystem.Project.Repos;

import com.maksystem.Project.Models.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Long> {
}
