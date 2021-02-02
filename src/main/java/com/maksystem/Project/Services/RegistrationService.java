package com.maksystem.Project.Services;

import com.maksystem.Project.Models.Registration;
import com.maksystem.Project.Repos.RegistrationRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationService {

    @Autowired
    private RegistrationRepo registrationRepo;

    public List<Registration> getAllRegistrations() {
        return registrationRepo.findAll();
    }

    public Registration addRegistration(Registration registration) {

        if (registration != null && hasAllComps(registration)) {
            registrationRepo.save(registration);
        }

        return registration;
    }

    public Registration getById(Integer id) {
        return registrationRepo.getOne(id);
    }

    public List<Registration> getByfName(String fname) {
        return registrationRepo.findAllByFName(fname);
    }

    public List<Registration> getBylName(String lname) {
        return registrationRepo.findAllByLName(lname);
    }

    public Registration editRegistration(Integer id, Registration registration) {

        if (getById(id) == null) return null;

        Registration reg = getById(id);

        reg.updateRegistration(registration);

        try {
            registrationRepo.save(reg);
            return reg;
        } catch (Exception e) {
            return null;
        }

    }

    public String deleteRegistration(Integer id) {
        try {
            registrationRepo.deleteById(id);
            return "DELETED";
        } catch (Exception e) {
            return "NOTDELETED";
        }

    }

    private boolean hasAllComps(Registration registration) {
        if (registration.getF_name() != null &&
            registration.getL_name() != null &&
            registration.getBirthday() != null &&
            registration.getPassword() != null &&
            registration.getPassword_conf() != null &&
            registration.getEmail() != null) {
            return true;
        }
        return false;
    }
}
