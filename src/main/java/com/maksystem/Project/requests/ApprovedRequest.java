package com.maksystem.Project.requests;

import com.maksystem.Project.Models.RoleTypes;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class ApprovedRequest {

	private String position;
	private int salary;
	private RoleTypes role;
	private String email;
	
	public ApprovedRequest(String email) {
		
		this.email = email;
	}
	
	
}
