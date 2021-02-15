package com.maksystem.Project.Models;

import com.sun.istack.Nullable;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.sql.Date;
import java.util.*;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@Table(name = "employee")
@Getter @Setter
@EqualsAndHashCode
@NoArgsConstructor
public class Employee implements UserDetails {


	@Id
	@GeneratedValue(
			strategy = GenerationType.SEQUENCE
	)
	private Long employee_id;
	private String firstName;
	private String lastName;
	private String email;
	private String phone;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birthday;
	private String password;
	@Enumerated(EnumType.STRING)
	private RoleTypes role;
	@Nullable
	private Integer salary;
	private String position;
	private Boolean enabled;

//	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
//	private Collection<WorkOnProject> wops = new ArrayList<>();
//
//	@ManyToMany(mappedBy = "employees")
//	private Set<Category> categories = new HashSet<>();

	public Employee(String firstName, String lastName, String email, String phone, Date birthday, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.birthday = birthday;
		this.password = password;
		this.enabled = false;

	}


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		SimpleGrantedAuthority authority =
				new SimpleGrantedAuthority(role.name());
		return Collections.singletonList(authority);
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return email;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return enabled;
	}


	@Override
	public String toString() {
		return String.format("Employee: %s %s", getFirstName(), getLastName());
	}


}

//    @ManyToMany(fetch = FetchType.LAZY,cascade = {CascadeType.PERSIST, CascadeType.MERGE})
//
//    @JoinTable(name = "employee_project", joinColumns = { @JoinColumn(name = "employee_id")}, inverseJoinColumns = { @JoinColumn(name = "project_id")})
//
//    @Getter @Setter
//    private Set<Project> projects = new HashSet<>();}

 
