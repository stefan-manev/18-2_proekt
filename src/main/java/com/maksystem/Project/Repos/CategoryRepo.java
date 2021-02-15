package com.maksystem.Project.Repos;

import com.maksystem.Project.Models.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
//    List<Category> findCategoryByEmployees
}
