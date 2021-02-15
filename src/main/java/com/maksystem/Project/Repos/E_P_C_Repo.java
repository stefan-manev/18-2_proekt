package com.maksystem.Project.Repos;

import com.maksystem.Project.Models.Emp_Proj_Cat;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface E_P_C_Repo extends JpaRepository<Emp_Proj_Cat, Long> {
//    Emp_Proj_Cat findByEmp_id(Long emp_id);

    List<Emp_Proj_Cat> findAllByEmp(Long emp); // use for my_projects.html
//    List<Emp_Proj_Cat> findAllByCat_id(Long cat_id);
//    List<Emp_Proj_Cat> findAllByProj_id(Long proj_id);
//    List<Emp_Proj_Cat> findAllByEmp_idAndAndProj_id(Long emp_id, Long proj_id); // use for category listings in my_projects.html
}
