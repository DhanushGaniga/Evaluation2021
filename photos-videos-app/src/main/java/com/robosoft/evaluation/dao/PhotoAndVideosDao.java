package com.robosoft.evaluation.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.robosoft.evaluation.model.UploadedFileModel;
import com.robosoft.evaluation.model.UserDetailModel;
import com.robosoft.evaluation.model.UserFavouriteModel;

/**
 * The Interface PhotoAndVideosDao.
 */
public interface PhotoAndVideosDao {
	
	/**
	 * Save image.
	 *
	 * @param category the category
	 * @param path the path
	 * @param fileName the file name
	 * @param id the id
	 * @return the uploaded file model
	 */
	UploadedFileModel saveImage(String category, String path, String fileName, String id);
	
	/**
	 * Save video.
	 *
	 * @param category the category
	 * @param path the path
	 * @param fileName the file name
	 * @param id the id
	 * @return the uploaded file model
	 */
	UploadedFileModel saveVideo(String category, String path, String fileName, String id);
	
	/**
	 * Gets the files.
	 *
	 * @param type the type
	 * @param paging the paging
	 * @return the files
	 */
	Page<UploadedFileModel> getFiles(Integer type, Pageable paging);
	
	/**
	 * Find user by email.
	 *
	 * @param emailID the email ID
	 * @return the user detail model
	 */
	UserDetailModel findUserByEmail(String emailID);
	
	/**
	 * Save.
	 *
	 * @param entity the entity
	 * @return the user detail model
	 */
	UserDetailModel save(UserDetailModel entity);
	
	/**
	 * Gets the file.
	 *
	 * @param id the id
	 * @return the file
	 */
	Optional<UploadedFileModel> getFile(Integer id);
	
	/**
	 * Adds the favourite.
	 *
	 * @param files the files
	 * @param userData the user data
	 * @return the user favourite model
	 */
	UserFavouriteModel addFavourite(UploadedFileModel files, UserDetailModel userData);
	
	/**
	 * Gets the favourite.
	 *
	 * @param userId the user id
	 * @param videoOrImageId the video or image id
	 * @return the favourite
	 */
	UserFavouriteModel getFavourite(String userId, int videoOrImageId);
	
	/**
	 * Removes the favourite.
	 *
	 * @param entiry the entiry
	 * @return the user favourite model
	 */
	UserFavouriteModel removeFavourite(UserFavouriteModel entiry);
	
	/**
	 * Gets the favourite.
	 *
	 * @param userId the user id
	 * @return the favourite
	 */
	List<UserFavouriteModel> getFavourite(String userId);
	

	/**
	 * Gets the trending photos.
	 *
	 * @return the trending photos
	 */
	UploadedFileModel getTrendingPhotos();
}
