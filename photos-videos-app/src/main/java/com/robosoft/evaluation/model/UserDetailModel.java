package com.robosoft.evaluation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class UserDetailModel.
 */
@Entity()
@Table(name = "tbl_user_detail")

/**
 * Gets the profile url.
 *
 * @return the profile url
 */
@Getter

/**
 * Sets the profile url.
 *
 * @param profileUrl the new profile url
 */
@Setter

/**
 * Instantiates a new user detail model.
 *
 * @param id the id
 * @param name the name
 * @param emailId the email id
 * @param mobileNo the mobile no
 * @param password the password
 * @param profileUrl the profile url
 */
@AllArgsConstructor

/**
 * Instantiates a new user detail model.
 */
@NoArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder
public class UserDetailModel {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "EuinSeq")
	@Column(name = "fld_id")
	private Integer id;
	
	/** The name. */
	@Column(name = "fld_user_name")
	private String name;
	
	/** The email id. */
	@Column(name = "fld_user_id")
	private String emailId;

	/** The mobile no. */
	@Column(name = "mobile")
	private String mobileNo;

	/** The password. */
	@Column(name = "password")
	private String password;
	
	/** The profile url. */
	@Column(name = "profileUrl")
	private String profileUrl;

}
