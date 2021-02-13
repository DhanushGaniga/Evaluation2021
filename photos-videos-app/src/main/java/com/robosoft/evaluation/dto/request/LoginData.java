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
 * Instantiates a new login data.
 *
 * @param email the email
 * @param password the password
 */
@AllArgsConstructor

/**
 * Instantiates a new login data.
 */
@NoArgsConstructor
public class LoginData {

	/** The email. */
	private String email;
	
	/** The password. */
	private String password;
}
