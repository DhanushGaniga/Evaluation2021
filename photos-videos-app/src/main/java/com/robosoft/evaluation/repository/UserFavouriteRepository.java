package com.robosoft.evaluation.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.robosoft.evaluation.model.UserFavouriteModel;

/**
 * The Interface UserFavouriteRepository.
 */
@Repository
public interface UserFavouriteRepository extends JpaRepository<UserFavouriteModel, Integer>{

	/**
	 * Gets the favourite.
	 *
	 * @param userId the user id
	 * @param videoOrImageId the video or image id
	 * @return the favourite
	 */
	@Query("select entity from UserFavouriteModel entity where entity.userId.emailId = :userId and entity.files.id = :fileId")
	UserFavouriteModel getFavourite(@Param("userId") String userId, @Param("fileId") int videoOrImageId);
	
	/**
	 * Gets the favourite.
	 *
	 * @param userId the user id
	 * @return the favourite
	 */
	@Query("select entity from UserFavouriteModel entity where entity.userId.emailId = :userId and entity.favourite =" +true)
	List<UserFavouriteModel> getFavourite(@Param("userId") String userId);
}
