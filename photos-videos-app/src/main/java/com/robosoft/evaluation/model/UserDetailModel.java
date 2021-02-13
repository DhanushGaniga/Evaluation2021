package com.robosoft.evaluation.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.ColumnTransformer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity()
@Table(name = "tbl_user_detail")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserDetailModel {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "EuinSeq")
	@Column(name = "fld_id")
	private Integer id;
	
	@Column(name = "fld_user_name")
	private String name;
	
	@Column(name = "fld_user_id")
	private String email;

	@Column(name = "mobile")
	private String mobileNo;

	@Column(name = "password")
	private String password;
	
	
	// @Column(name = "profileUrl")
	// private String profileUrl;

}
