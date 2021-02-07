package com.maksystem.Project.Repos;

import com.maksystem.Project.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo extends JpaRepository<Category, Long> {
}
