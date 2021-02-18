package com.maksystem.Project.Models;

import javax.persistence.*;

@Entity
@Table(name="profile")
public class Profile {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="project")
    private String project;

    @Column(name="first_name")
    private String firstName;

    @Column(name="last_name")
    private String lastName;

    @Column(name="profilePicPath")
    private String profilePicPath;

    public Profile() {

    }

    public Profile(String firstName, String lastName, String profilePicPath) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.profilePicPath = profilePicPath;
    }

    public Profile(Long id, String project, String firstName, String lastName, String profilePicPath) {

        this.id = id;
        this.project=project;
        this.firstName=firstName;
        this.lastName=lastName;
        this.profilePicPath = profilePicPath;


    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }



    public String getProject() {
        return project;
    }
    public void setProject (String project) {
        this.project = project;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName (String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName (String lastName) {
        this.lastName = lastName;
    }
    public String getProfilePicPath() {
        return profilePicPath;
    }

    public void setProfilePicPath(String profilePicPath) {
        this.profilePicPath = profilePicPath;
    }



}