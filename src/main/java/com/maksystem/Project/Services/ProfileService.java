package com.maksystem.Project.Services;

import com.maksystem.Project.Models.Profile;
import com.maksystem.Project.Repos.ProfileRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository repo;

    public List<Profile> listAll() {
        return repo.findAll();
    }

    public void save(Profile std) {
        repo.save(std);
    }

    public Profile get(long id) {
        return repo.findById(id).get();
    }

    public void delete(long id) {
        repo.deleteById(id);
    }



    public Profile createEmployee(Profile employee) {
        return repo.save(employee);

    }

    public List<Profile> getAllEmployees() {
        return repo.findAll();
    }

}