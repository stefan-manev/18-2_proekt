package com.maksystem.Project.Services;

import com.maksystem.Project.Models.Task;
import com.maksystem.Project.Repos.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServices {

    @Autowired
    private TaskRepo taskRepo;

    public List<Task> getAllTasks() {
        return taskRepo.findAll();
    }

    public Task getTaskById(Long id) {
        return taskRepo.getOne(id);
    }

    public Task createTask(Task task) {
        if (task != null) {
            taskRepo.save(task);
            return task;
        }

        return null;
    }

    public Task editTask(Long id, Task task) {
        Task task1 = task;
        task1.setTask_id(id);

        try {
            taskRepo.save(task1);
            return task1;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public void deleteTask(Task task) {
        taskRepo.delete(task);
    }
}
