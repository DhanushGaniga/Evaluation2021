package com.robosoft.evaluation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * The Class UserFavouriteModel.
 */
@Entity()
@Table(name = "tbl_user_favourite")

/**
 * Checks if is favourite.
 *
 * @return true, if is favourite
 */
@Getter

/**
 * Sets the favourite.
 *
 * @param favourite the new favourite
 */
@Setter

/**
 * Instantiates a new user favourite model.
 *
 * @param id the id
 * @param userId the user id
 * @param files the files
 * @param favourite the favourite
 */
@AllArgsConstructor

/**
 * Instantiates a new user favourite model.
 */
@NoArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder
public class UserFavouriteModel {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "EuinSeq")
	@Column(name = "fld_id")
	private Integer id;
	
	/** The user id. */
	@ManyToOne
	@JoinColumn(name = "fld_user_id")
	private UserDetailModel userId;
	
	/** The files. */
	@ManyToOne
	@JoinColumn(name = "fld_favourite_files")
	private UploadedFileModel files;
	
	/** The favourite. */
	@Column(name = "fld_is_favourite")
	private boolean favourite;
}
