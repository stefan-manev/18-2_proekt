package com.maksystem.Project.Models;

import javax.persistence.*;

@Entity
@Table(name = "emp_proj_cat")
public class Emp_Proj_Cat {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long emp;

    private Long proj;

    private Long cat;

    public Emp_Proj_Cat() {}

    public Emp_Proj_Cat(Long emp_id, Long proj_id, Long cat_id) {
        this.emp = emp_id;
        this.proj = proj_id;
        this.cat = cat_id;
    }

    public Long getEmp_id() {
        return emp;
    }

    public void setEmp_id(Long emp_id) {
        this.emp = emp;
    }

    public Long getProj_id() {
        return proj;
    }

    public void setProj_id(Long proj_id) {
        this.proj = proj;
    }

    public Long getCat_id() {
        return cat;
    }

    public void setCat_id(Long cat_id) {
        this.cat = cat;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public Long getId() {
        return id;
    }
}
