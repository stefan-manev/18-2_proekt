package com.maksystem.Project.Models;


import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.util.*;

@Entity
@DynamicUpdate
@Table(name = "project")
@Getter @Setter
public class Project {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long project_id;

    private String p_name;

    private String p_description;

//    private boolean active;

    @OneToMany(mappedBy = "project")
    @Getter @Setter
    private List<Category> categories;

//    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
//    private Collection<WorkOnProject> wops = new ArrayList<>();

    @Enumerated(EnumType.STRING)
    private ProjectStatus projectStatus;

    @Override
    public String toString() {
        return "Project{" +
                "Name='" + p_name + '\'' +
                ", Description='" + p_description + '\'' +
                '}';
    }

    public void setCategories(List<Category> categories) {
        Set<Category> distinctCats = new HashSet<>();
        categories.forEach(category -> {
            distinctCats.add(category);
        });
        categories = new ArrayList<>(distinctCats);
        Collections.sort(categories, new Comparator<Category>() {
            @Override
            public int compare(Category c1, Category c2) {
                return c1.getCategory_id().compareTo(c2.getCategory_id());
            }
        });
        this.categories = categories;
    }

    public List<Category> getCategories() {
        Collections.sort(this.categories, new Comparator<Category>() {
            @Override
            public int compare(Category c1, Category c2) {
                return c1.getCategory_id().compareTo(c2.getCategory_id());
            }
        });
        return this.categories;
    }
}
