package com.maksystem.Project.Services;
import com.maksystem.Project.Models.Employee;
import com.maksystem.Project.Models.HasRole;
import com.maksystem.Project.Models.Role;
import com.maksystem.Project.Repos.EmployeeRepo;
import com.maksystem.Project.Repos.HasRoleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserService implements UserDetailsService {

    @Autowired
    private EmployeeRepo employeeRepo;

    @Autowired
    private HasRoleRepo hasRoleRepo;


    @Override
    @Transactional()
    public UserDetails loadUserByUsername(String username) {

        Employee employee = employeeRepo.findEmployeeByEmail(username);

        if (employee == null) throw new UsernameNotFoundException(username);

        Set<GrantedAuthority> grantedAuthoritySet = new HashSet<>();

        List<HasRole> roles = hasRoleRepo.findAllByEmployee(employee);

        List<Role> rols = new ArrayList<>();

        for (HasRole hs : roles) {
            rols.add(hs.getRole());
        }

        for (Role r : rols) {
            grantedAuthoritySet.add(new SimpleGrantedAuthority(r.getRoleType().toString()));

            return new User(employee.getEmail(), employee.getPassword(), grantedAuthoritySet);
        }

        return null;
    }

}
