package com.maksystem.Project.Services;

import com.maksystem.Project.Models.Category;
import com.maksystem.Project.Models.Task;
import com.maksystem.Project.Models.TaskStatus;
import com.maksystem.Project.Repos.CategoryRepo;
import com.maksystem.Project.Repos.TaskRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class TaskService {

    @Autowired
    private TaskRepo taskRepo;

    @Autowired
    private CategoryRepo categoryRepo;

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

    public List<Task> getTasksToDo() {
        return taskRepo.findTasksByTaskStatus(TaskStatus.TODO);
    }
    public List<Task> getTasksInProgress() {
        return taskRepo.findTasksByTaskStatus(TaskStatus.INPROGRESS);
    }
    public List<Task> getTasksOnReview() {
        return taskRepo.findTasksByTaskStatus(TaskStatus.ONREVIEW);
    }
    public List<Task> getTasksFinished() {
        return taskRepo.findTasksByTaskStatus(TaskStatus.FINISHED);
    }

    public List<Task> getTasksToDoByCat(String catId) {
        Category cat = categoryRepo.getOne(Long.parseLong(catId));
        return taskRepo.findTasksByTaskStatusAndCategory(TaskStatus.TODO, cat);
    }
    public List<Task> getTasksInProgressByCat(String catId) {
        Category cat = categoryRepo.getOne(Long.parseLong(catId));
        return taskRepo.findTasksByTaskStatusAndCategory(TaskStatus.INPROGRESS, cat);
    }
    public List<Task> getTasksOnReviewByCat(String catId) {
        Category cat = categoryRepo.getOne(Long.parseLong(catId));
        return taskRepo.findTasksByTaskStatusAndCategory(TaskStatus.ONREVIEW, cat);
    }
    public List<Task> getTasksFinishedByCat(String catId) {
        Category cat = categoryRepo.getOne(Long.parseLong(catId));
        return taskRepo.findTasksByTaskStatusAndCategory(TaskStatus.FINISHED, cat);
    }


//    LONG
//    public List<Task> getTasksToDoByCat(Long catId) {
//        Category cat = categoryRepo.getOne(catId);
//        return taskRepo.findTasksByTaskStatusAndCategory(TaskStatus.TODO, cat);
//    }
//    public List<Task> getTasksInProgressByCat(Long catId) {
//        Category cat = categoryRepo.getOne(catId);
//        return taskRepo.findTasksByTaskStatusAndCategory(TaskStatus.INPROGRESS, cat);
//    }
//    public List<Task> getTasksOnReviewByCat(Long catId) {
//        Category cat = categoryRepo.getOne(catId);
//        return taskRepo.findTasksByTaskStatusAndCategory(TaskStatus.ONREVIEW, cat);
//    }
//    public List<Task> getTasksFinishedByCat(Long catId) {
//        Category cat = categoryRepo.getOne(catId);
//        return taskRepo.findTasksByTaskStatusAndCategory(TaskStatus.FINISHED, cat);
//    }


//    public Task editTask(Long id, Task task) {
//        Task task1 = task;
//        task1.setTask_id(id);
//
//        try {
//            taskRepo.save(task1);
//            return task1;
//        } catch (Exception e) {
//            e.printStackTrace();
//            return null;
//        }
//    }

    public void deleteTask(Task task) {
        taskRepo.delete(task);
    }
//
//    public List<Task> getAllTasksForCategoryId(Long id) {
//        return (List<Task>) categoryRepo.getOne(id).getTasks();
//    }

//    public void addNewTask(Task task) {
//        Optional<Task> taskByName = taskRepo.findTaskByName(task.getT_name());
//        if (taskByName.isPresent()){
//            throw new IllegalStateException("Task already exists");
//        }
//        taskRepo.save(task);
//        System.out.println("New task added.");
//    }

    public void removeTaskById(Long t_id) {
        Boolean categoryExists = taskRepo.existsById(t_id);
        if (!categoryExists) {
            throw new IllegalStateException("Category with id " + t_id + " doesn't exist in the database.");
        }
        taskRepo.deleteById(t_id);
    }

    public void updateTask(Long t_id, String t_name, String t_description, TaskStatus taskStatus) {

        Task task = taskRepo.findById(t_id).
                orElseThrow(
                        () -> new IllegalStateException("Task with id " + t_id + " not found in the database")
                );
        if (t_name != null && t_name.length() > 0 && !Objects.equals(task.getT_name(), t_name)) {
            task.setT_name(t_name);
        }
        if (t_description != null && t_description.length() > 0 && !Objects.equals(task.getT_description(), t_description)) {
            task.setT_description(t_description);
        }
        if (!Objects.equals(task.getTaskStatus(), taskStatus)) {
            task.setTaskStatus(taskStatus);
        }

    }

    public static <T extends Enum<T>> T getEnumFromString(Class<T> c, String string) {
        if( c != null && string != null ) {
            try {
                return Enum.valueOf(c, string.trim().toUpperCase());
            } catch(IllegalArgumentException ex) {
            }
        }
        return null;
    }

    public void changeTaskStatus(String t_id, TaskStatus taskStatus) {
        Long longId = Long.parseLong(t_id);
        Task taskToUpdate = taskRepo.findById(longId).
                orElseThrow(
                        () -> new IllegalStateException("Task with id " + longId + " not found in the database")
                );
        if (!Objects.equals(taskToUpdate.getTaskStatus(), taskStatus)) {
            taskToUpdate.setTaskStatus(taskStatus);
            taskRepo.save(taskToUpdate);
        }
    }
}
