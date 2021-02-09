package com.maksystem.Project.requests;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

// attributes to be displayed in pending request completion form 
@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
public class PendingRequest {
	private String firstName;
	private String lastName;
	private String email;
}
