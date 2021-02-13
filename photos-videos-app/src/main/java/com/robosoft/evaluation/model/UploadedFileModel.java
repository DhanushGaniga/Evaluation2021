package com.robosoft.evaluation.model;

import java.util.Date;

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

@Entity()
@Table(name = "tbl_uploaded_file")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UploadedFileModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "EuinSeq")
	@Column(name = "fld_id")
	private Integer id;
	
	@Column(name = "fld_file_name")
	private String fileName;
	
	@Column(name = "fld_file_path")
	private String filePath;
	
	@Column(name = "fld_file_type")
	private Integer fileType;
	
	@Column(name = "fld_view_count")
	private Integer viewCount;
	
	@Column(name = "fld_category")
	private String category; 
	
	@Column(name = "fld_created_time")
	private Date createdTime;

}
