package com.robosoft.evaluation.model;

import java.util.Date;

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
 * The Class UploadedFileModel.
 */
@Entity()
@Table(name = "tbl_uploaded_file")

/**
 * Gets the uploaded by.
 *
 * @return the uploaded by
 */
@Getter

/**
 * Sets the uploaded by.
 *
 * @param uploadedBy the new uploaded by
 */
@Setter

/**
 * Instantiates a new uploaded file model.
 *
 * @param id the id
 * @param fileName the file name
 * @param filePath the file path
 * @param fileType the file type
 * @param viewCount the view count
 * @param category the category
 * @param createdTime the created time
 * @param uploadedBy the uploaded by
 */
@AllArgsConstructor

/**
 * Instantiates a new uploaded file model.
 */
@NoArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder
public class UploadedFileModel {
	
	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "EuinSeq")
	@Column(name = "fld_id")
	private Integer id;
	
	/** The file name. */
	@Column(name = "fld_file_name")
	private String fileName;
	
	/** The file path. */
	@Column(name = "fld_file_path")
	private String filePath;
	
	/** The file type. */
	@Column(name = "fld_file_type")
	private Integer fileType;
	
	/** The view count. */
	@Column(name = "fld_view_count")
	private Integer viewCount;
	
	/** The category. */
	@Column(name = "fld_category")
	private String category; 
	
	/** The created time. */
	@Column(name = "fld_uploaded_time")
	private Date createdTime;
	
	/** The uploaded by. */
	@ManyToOne
	@JoinColumn(name = "fld_uploaded_by")
	private UserDetailModel uploadedBy;

}
