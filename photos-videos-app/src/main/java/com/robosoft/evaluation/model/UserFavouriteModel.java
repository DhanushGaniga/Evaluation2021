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

@Entity()
@Table(name = "tbl_user_favourite")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserFavouriteModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "EuinSeq")
	@Column(name = "fld_id")
	private Integer id;
	
//	@ManyToOne
//	@JoinColumn(name = "fld_user_id")
//	private UserDetailModel userId;
//	
//	@ManyToOne
//	@JoinColumn(name = "fld_favourite_files")
//	private UploadedFileModel files;
}
