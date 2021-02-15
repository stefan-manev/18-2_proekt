package com.maksystem.Project.Repos;

import com.maksystem.Project.Models.Project;
//import com.maksystem.Project.Models.WorkOnProject;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProjectRepo extends JpaRepository<Project, Long> {
//    List<Project> findAllByWops(WorkOnProject workOnProject);
}
