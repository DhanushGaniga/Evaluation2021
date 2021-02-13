package com.robosoft.evaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robosoft.evaluation.model.UserDetailModel;

@Repository
public interface UserDetailRepository extends JpaRepository<UserDetailModel, Integer>{
	
	UserDetailModel findByEmailId(String emailID);
	
}
