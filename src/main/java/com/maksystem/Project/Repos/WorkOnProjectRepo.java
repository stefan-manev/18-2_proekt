package com.maksystem.Project.Repos;

import com.maksystem.Project.Models.WorkOnProject;
import com.maksystem.Project.Models.WorkOnProjectKey;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkOnProjectRepo extends JpaRepository<WorkOnProject, WorkOnProjectKey> {
}
