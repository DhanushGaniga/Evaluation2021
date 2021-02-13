package com.robosoft.evaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.robosoft.evaluation.model.UserFavouriteModel;

@Repository
public interface UserFavouriteRepository extends JpaRepository<UserFavouriteModel, Integer>{

	@Query("select entity from UserFavouriteModel entity where entity.userId.emailId = :userId and entity.files.id = :fileId")
	UserFavouriteModel getFavourite(@Param("userId") String userId, @Param("fileId") int videoOrImageId);
}
