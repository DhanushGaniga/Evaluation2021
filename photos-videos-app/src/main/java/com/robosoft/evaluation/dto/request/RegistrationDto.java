package com.robosoft.evaluation.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Data

/**
 * Instantiates a new registration dto.
 */
@NoArgsConstructor

/**
 * Instantiates a new registration dto.
 *
 * @param name the name
 * @param password the password
 * @param mobile the mobile
 * @param email the email
 */
@AllArgsConstructor
public class RegistrationDto {
	
	/** The name. */
	private String name;
	
	/** The password. */
	private String password;
	
	/** The mobile. */
	private String mobile;
	
	/** The email. */
	private String email;

}
