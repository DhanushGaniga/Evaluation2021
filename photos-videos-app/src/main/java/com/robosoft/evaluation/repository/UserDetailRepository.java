package com.robosoft.evaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robosoft.evaluation.model.UserDetailModel;

/**
 * The Interface UserDetailRepository.
 */
@Repository
public interface UserDetailRepository extends JpaRepository<UserDetailModel, Integer>{
	
	/**
	 * Find by email id.
	 *
	 * @param emailID the email ID
	 * @return the user detail model
	 */
	UserDetailModel findByEmailId(String emailID);
	
}
