package com.maksystem.Project.Repos;

import com.maksystem.Project.Models.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task, Long> {
}
