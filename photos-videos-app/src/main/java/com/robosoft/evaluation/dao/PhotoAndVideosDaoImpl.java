package com.robosoft.evaluation.dao;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.robosoft.evaluation.constants.AppConstants;
import com.robosoft.evaluation.constants.ErrorCodes;
import com.robosoft.evaluation.exception.DboperationFailedException;
import com.robosoft.evaluation.model.UploadedFileModel;
import com.robosoft.evaluation.model.UserDetailModel;
import com.robosoft.evaluation.model.UserFavouriteModel;
import com.robosoft.evaluation.repository.UploadedFileRepository;
import com.robosoft.evaluation.repository.UserDetailRepository;
import com.robosoft.evaluation.repository.UserFavouriteRepository;


/**
 * The Class PhotoAndVideosDaoImpl.
 */
@Component
public  class PhotoAndVideosDaoImpl implements PhotoAndVideosDao{
	
	/** The uploaded file repository. */
	@Autowired
	private UploadedFileRepository uploadedFileRepository;
	
	/** The user detail repository. */
	@Autowired
	private UserDetailRepository userDetailRepository;
	
	/** The user favourite repository. */
	@Autowired
	private UserFavouriteRepository userFavouriteRepository;

	/**
	 * Save image.
	 *
	 * @param category the category
	 * @param path the path
	 * @param fileName the file name
	 * @param id the id
	 * @return the uploaded file model
	 */
	@Override
	public UploadedFileModel saveImage(String category, String path, String fileName, String id) {
		try {
			UserDetailModel userDetail = userDetailRepository.findByEmailId(id);
			UploadedFileModel uploadedeFile = UploadedFileModel.builder().fileName(fileName)
					.filePath(path).fileType(1).category(category)
					.uploadedBy(userDetail)
					.createdTime(new Date()).build();
			return uploadedFileRepository.save(uploadedeFile);
		}catch (Exception e) {
			e.printStackTrace();
			throw new DboperationFailedException(AppConstants.DB_OPERATION_FAILED, ErrorCodes.UPLOAD_FAILED_MESSAGE);
		}
		
	}

	/**
	 * Save video.
	 *
	 * @param category the category
	 * @param path the path
	 * @param fileName the file name
	 * @param id the id
	 * @return the uploaded file model
	 */
	@Override
	public UploadedFileModel saveVideo(String category, String path, String fileName, String id) {
		try {
			UserDetailModel userDetail = userDetailRepository.findByEmailId(id);
			UploadedFileModel uploadedeFile = UploadedFileModel.builder().fileName(fileName)
					.filePath(path).fileType(2).category(category)
					.uploadedBy(userDetail)
					.createdTime(new Date()).build();
			return uploadedFileRepository.save(uploadedeFile);
		}catch (Exception e) {
			e.printStackTrace();
			throw new DboperationFailedException(AppConstants.DB_OPERATION_FAILED, ErrorCodes.UPLOAD_FAILED_MESSAGE);
		}
	}

	/**
	 * Gets the files.
	 *
	 * @param type the type
	 * @param paging the paging
	 * @return the files
	 */
	@Override
	public Page<UploadedFileModel> getFiles(Integer type, Pageable paging) {
		try {
			return uploadedFileRepository.findByFileType(type, paging);
		}catch (Exception e) {
			e.printStackTrace();
			throw new DboperationFailedException(AppConstants.DB_OPERATION_FAILED, ErrorCodes.FETCH_DATA_FAILED_MESSAGE);
		}
	}

	/**
	 * Find user by email.
	 *
	 * @param emailID the email ID
	 * @return the user detail model
	 */
	@Override
	public UserDetailModel findUserByEmail(String emailID) {
		try {
			return userDetailRepository.findByEmailId(emailID);
		}catch (Exception e) {
			e.printStackTrace();
			throw new DboperationFailedException(AppConstants.DB_OPERATION_FAILED, ErrorCodes.FETCH_DATA_FAILED_MESSAGE);
		}
		
	}

	/**
	 * Save.
	 *
	 * @param entity the entity
	 * @return the user detail model
	 */
	@Override
	public UserDetailModel save(UserDetailModel entity) {
		try {
			 return userDetailRepository.save(entity);
		}catch (Exception e) {
			e.printStackTrace();
			throw new DboperationFailedException(AppConstants.DB_OPERATION_FAILED, ErrorCodes.DB_OPERATION_FAILED_MESSAGE);
		}
	}

	/**
	 * Gets the file.
	 *
	 * @param id the id
	 * @return the file
	 */
	@Override
	public Optional<UploadedFileModel> getFile(Integer id) {
		try {
			return uploadedFileRepository.findById(id);
		}catch (Exception e) {
			e.printStackTrace();
			throw new DboperationFailedException(AppConstants.DB_OPERATION_FAILED, ErrorCodes.FETCH_DATA_FAILED_MESSAGE);
		}
		
	}

	/**
	 * Adds the favourite.
	 *
	 * @param files the files
	 * @param userData the user data
	 * @return the user favourite model
	 */
	@Override
	public UserFavouriteModel addFavourite(UploadedFileModel files, UserDetailModel userData) {
		try {
			UserFavouriteModel favourites = new UserFavouriteModel();
			favourites.setUserId(userData);
			favourites.setFiles(files);
			favourites.setFavourite(true);
			 return userFavouriteRepository.save(favourites);
		}catch (Exception e) {
			e.printStackTrace();
			throw new DboperationFailedException(AppConstants.DB_OPERATION_FAILED, ErrorCodes.DB_OPERATION_FAILED_MESSAGE);
		}
	}
	
	/**
	 * Gets the favourite.
	 *
	 * @param userId the user id
	 * @param videoOrImageId the video or image id
	 * @return the favourite
	 */
	@Override
	public UserFavouriteModel getFavourite(String userId, int videoOrImageId) {
		try {
			 return userFavouriteRepository.getFavourite(userId, videoOrImageId);
		}catch (Exception e) {
			e.printStackTrace();
			throw new DboperationFailedException(AppConstants.DB_OPERATION_FAILED, ErrorCodes.DB_OPERATION_FAILED_MESSAGE);
		}
	}

	/**
	 * Removes the favourite.
	 *
	 * @param entiry the entiry
	 * @return the user favourite model
	 */
	@Override
	public UserFavouriteModel removeFavourite(UserFavouriteModel entiry) {
		try {
				entiry.setFavourite(false);
				return userFavouriteRepository.save(entiry);
		}catch (Exception e) {
			e.printStackTrace();
			throw new DboperationFailedException(AppConstants.DB_OPERATION_FAILED, ErrorCodes.DB_OPERATION_FAILED_MESSAGE);
		}
	}

	/**
	 * Gets the favourite.
	 *
	 * @param userId the user id
	 * @return the favourite
	 */
	@Override
	public List<UserFavouriteModel> getFavourite(String userId) {
		try {
			 return userFavouriteRepository.getFavourite(userId);
		}catch (Exception e) {
			e.printStackTrace();
			throw new DboperationFailedException(AppConstants.DB_OPERATION_FAILED, ErrorCodes.DB_OPERATION_FAILED_MESSAGE);
		}
	}

	
	/**
	 * Gets the trending photos.
	 *
	 * @return the trending photos
	 */
	@Override
	public UploadedFileModel getTrendingPhotos() {
		try {
			 return uploadedFileRepository.getTrendingPhotos();
		}catch (Exception e) {
			e.printStackTrace();
			throw new DboperationFailedException(AppConstants.DB_OPERATION_FAILED, ErrorCodes.DB_OPERATION_FAILED_MESSAGE);
		}
		
	}

}
