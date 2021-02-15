package com.maksystem.Project.Repos;

import com.maksystem.Project.Models.Category;
import com.maksystem.Project.Models.Task;
import com.maksystem.Project.Models.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TaskRepo extends JpaRepository<Task, Long> {

//    Optional<Task> findTaskByName(String t_name);
    List<Task> findTasksByTaskStatus(TaskStatus taskStatus);
    List<Task> findTasksByTaskStatusAndCategory(TaskStatus taskStatus, Category category);
    List<Task> findAllByCategory(Category category);
//    List<Task> findTasksBy

}
