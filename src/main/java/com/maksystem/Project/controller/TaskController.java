package com.maksystem.Project.controller;

import com.maksystem.Project.Models.TaskStatus;
import com.maksystem.Project.Services.E_P_C_Service;
import com.maksystem.Project.Services.TaskService;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
//@RequestMapping(path = "tasks")
public class TaskController {

    private final TaskService taskService;
    private final E_P_C_Service e_p_c_service;

    public TaskController(TaskService taskService, E_P_C_Service e_p_c_service) {
        this.taskService = taskService;
        this.e_p_c_service = e_p_c_service;
    }

//    @GetMapping("tasks")
//    public String getTasks(Model model) {
//
//        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
//        String email = loggedInUser.getName();
//        model.addAttribute("employee_projects", e_p_c_service.getProjectsByEmployee(email));
//
//        model.addAttribute("tasks_to_do", taskService.getTasksToDo());
//
//        model.addAttribute("tasks_in_progress", taskService.getTasksInProgress());
//
//        model.addAttribute("tasks_on_review", taskService.getTasksOnReview());
//
//        model.addAttribute("tasks_finished", taskService.getTasksFinished());
//
//        return "task";
//
//    }


//        @GetMapping("tasks/{category}")
//        @ResponseBody
//        public String getTasksByCat(@RequestParam(value = "category") String catId, Model model) {
//
//        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
//        String email = loggedInUser.getName();
//        model.addAttribute("employee_projects", e_p_c_service.getProjectsByEmployee(email));
//
//        model.addAttribute("tasks_to_do", taskService.getTasksToDoByCat(catId));
//            System.out.println("\n\n\n" + taskService.getTasksToDoByCat(catId));
//        model.addAttribute("tasks_in_progress", taskService.getTasksInProgressByCat(catId));
//            System.out.println("\n\n\n" + taskService.getTasksInProgressByCat(catId));
//        model.addAttribute("tasks_on_review", taskService.getTasksOnReviewByCat(catId));
//
//        model.addAttribute("tasks_finished", taskService.getTasksFinishedByCat(catId));
//
//        return "task";
//
//    }

    @GetMapping(value="tasks")
    public String getTasksByCat(@RequestParam(value = "category", required = false) String catId, Model model) {

        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
        String email = loggedInUser.getName();
        model.addAttribute("employee_projects", e_p_c_service.getProjectsByEmployee(email));

            if (catId != null) {
                model.addAttribute("tasks_to_do", taskService.getTasksToDoByCat(catId));
                model.addAttribute("tasks_in_progress", taskService.getTasksInProgressByCat(catId));
                model.addAttribute("tasks_on_review", taskService.getTasksOnReviewByCat(catId));
                model.addAttribute("tasks_finished", taskService.getTasksFinishedByCat(catId));
            }

        return "tasks";

    }

//    @PostMapping("tasks/{category}")
//    @ResponseBody
//    public String getTasksByCat(@ModelAttribute Category category, Model model) {
//
//        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
//        String email = loggedInUser.getName();
//        model.addAttribute("employee_projects", e_p_c_service.getProjectsByEmployee(email));
//
//        model.addAttribute("tasks_to_do", taskService.getTasksToDoByCat(category.getCategory_id().toString()));
//        System.out.println("\n\n\n" + taskService.getTasksToDoByCat(category.getCategory_id().toString()));
//        model.addAttribute("tasks_in_progress", taskService.getTasksInProgressByCat(category.getCategory_id().toString()));
//        System.out.println("\n\n\n" + taskService.getTasksInProgressByCat(category.getCategory_id().toString()));
//        model.addAttribute("tasks_on_review", taskService.getTasksOnReviewByCat(category.getCategory_id().toString()));
//
//        model.addAttribute("tasks_finished", taskService.getTasksFinishedByCat(category.getCategory_id().toString()));
//
//        return "task";
//
//    }


//    LONG
//    @GetMapping("tasks/{category}")
//    @ResponseBody
//    public String getTasksByCat(@RequestParam(value = "category") Long catId, Model model) {
//
//        Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
//        String email = loggedInUser.getName();
//        model.addAttribute("employee_projects", e_p_c_service.getProjectsByEmployee(email));
//
//        model.addAttribute("tasks_to_do", taskService.getTasksToDoByCat(catId));
//        System.out.println("\n\n\n" + taskService.getTasksToDoByCat(catId));
//        model.addAttribute("tasks_in_progress", taskService.getTasksInProgressByCat(catId));
//        System.out.println("\n\n\n" + taskService.getTasksInProgressByCat(catId));
//        model.addAttribute("tasks_on_review", taskService.getTasksOnReviewByCat(catId));
//
//        model.addAttribute("tasks_finished", taskService.getTasksFinishedByCat(catId));
//
//        return "task";
//
//    }

//    @GetMapping("/tasks/{cat_id}")
//    public String getTasksByCatId(@PathVariable(value = "cat_id") String catId, Model model) {
//        model.("")
//    }

//    @PostMapping
//    public void registerNewTask(@RequestBody Task task) {
//        taskService.addNewTask(task);
//    }

    @DeleteMapping(path = "{t_id}")
    public void deleteTask(@PathVariable("t_id") Long t_id) {
        taskService.removeTaskById(t_id);
    }

    @PutMapping(path = "{t_id}")
    public void updateTask(@PathVariable("t_id") Long t_id,
                           @RequestParam(required = false) String t_name,
                           @RequestParam(required = false) String t_description,
                           @RequestParam(required = false) TaskStatus taskStatus) {
        taskService.updateTask(t_id, t_name, t_description, taskStatus);
    }

}
