package com.maksystem.Project.Services;

import com.maksystem.Project.Models.Category;
import com.maksystem.Project.Models.Task;
import com.maksystem.Project.Repos.CategoryRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepo categoryRepo;

    public List<Category> getAllCategories() {
        return categoryRepo.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepo.getOne(id);
    }

    public Category saveCategory(Category category) {
        if (category != null) {
            categoryRepo.save(category);
            return category;
        }

        return null;
    }

    public void deleteCategory(Category category) {
        categoryRepo.delete(category);
    }

    public String addTask(Task task, Category category) {
        Set<Task> tasks = category.getTasks();
        tasks.add(task);

        category.setTasks(tasks);

        try {
            categoryRepo.save(category);
            return "Task added";
        } catch (Exception e) {
            e.printStackTrace();
            return "Something went wrong";
        }
    }
}
