package com.robosoft.evaluation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationDto {
	
	private String name;
	private String password;
	private String mobile;
	private String email;

}
