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
	@Column(name="picture")
	private String picture=null;

//	@OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
//	private Collection<WorkOnProject> wops = new ArrayList<>();
//
//	@ManyToMany(mappedBy = "employees")
//	private Set<Category> categories = new HashSet<>();

//	without pic
	public Employee(String firstName, String lastName, String email, String phone, Date birthday, String password) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.phone = phone;
		this.birthday = birthday;
		this.password = password;
		this.enabled = false;

	}

//	with pic
	public Employee(String fname, String lname, Date birthday, String email,
					String position, String password, String picture) {

		this.firstName = fname;
		this.lastName = lname;
		this.birthday = birthday;
		this.email = email;
		this.position = position;
		this.password = password;
		this.picture = picture;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
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

 

//package com.maksystem.Project.Model;
//
//		import java.sql.Date;
//
//		import javax.persistence.Column;
//		import javax.persistence.Entity;
//		import javax.persistence.GeneratedValue;
//		import javax.persistence.GenerationType;
//		import javax.persistence.Id;
//		import javax.persistence.Table;
//
//		import org.springframework.format.annotation.DateTimeFormat;

//@Entity
//@Table (name="employee")
//public class Employee {
//	@Id
//	@GeneratedValue(strategy= GenerationType.IDENTITY)
//	@Column(name="employee_id")
//	private int employee_id=1;
//	@Column(name="fname")
//	private String fname=null;
//	@Column(name="lname")
//	private String lname=null;
//	@Column(name="birthday")
//	private String birthday=null;
//	@Column(name="email")
//	private String email=null;
//	@Column(name="")
//	private Long salary=null;
//	@Column(name="position")
//	private String position=null;
//	@Column(name="password")
//	private String password=null;
//	@Column(name="password_conf")
//	private String password_conf=null;
//	@Column(name="picture")
//	private String picture=null;
//
//	public Employee() {
//
//	}
//
//	public Employee(int employee_id, String fname, String lname, String birthday, String email, Long salary,
//					String position, String password, String password_conf, String picture) {
//
//		this.employee_id = employee_id;
//		this.fname = fname;
//		this.lname = lname;
//		this.birthday = birthday;
//		this.email = email;
//		this.salary = salary;
//		this.position = position;
//		this.password = password;
//		this.password_conf = password_conf;
//		this.picture = picture;
//	}
//
//	public int getEmployee_id() {
//		return employee_id;
//	}
//
//	public void setEmployee_id(int employee_id) {
//		this.employee_id = employee_id;
//	}
//
//	public String getFname() {
//		return fname;
//	}
//
//	public void setFname(String fname) {
//		this.fname = fname;
//	}
//
//	public String getLname() {
//		return lname;
//	}
//
//	public void setLname(String lname) {
//		this.lname = lname;
//	}
//
//	public String getBirthday() {
//		return birthday;
//	}
//
//	public void setBirthday(String birthday) {
//		this.birthday = birthday;
//	}
//
//	public String getEmail() {
//		return email;
//	}
//
//	public void setEmail(String email) {
//		this.email = email;
//	}
//
//	public Long getSalary() {
//		return salary;
//	}
//
//	public void setSalary(Long salary) {
//		this.salary = salary;
//	}
//
//	public String getPosition() {
//		return position;
//	}
//
//	public void setPosition(String position) {
//		this.position = position;
//	}
//
//	public String getPassword() {
//		return password;
//	}
//
//	public void setPassword(String password) {
//		this.password = password;
//	}
//
//	public String getPassword_conf() {
//		return password_conf;
//	}
//
//	public void setPassword_conf(String password_conf) {
//		this.password_conf = password_conf;
//	}
//
//	public String getPicture() {
//		return picture;
//	}
//
//	public void setPicture(String picture) {
//		this.picture = picture;
//	}
//
//
//
//}