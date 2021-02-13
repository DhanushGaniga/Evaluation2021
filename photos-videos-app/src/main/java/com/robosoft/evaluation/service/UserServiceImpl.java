package com.robosoft.evaluation.service;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.robosoft.evaluation.constants.AppConstants;
import com.robosoft.evaluation.constants.ErrorCodes;
import com.robosoft.evaluation.dao.PhotoAndVideosDao;
import com.robosoft.evaluation.dto.request.LoginData;
import com.robosoft.evaluation.dto.request.RegistrationDto;
import com.robosoft.evaluation.dto.response.FileReturnValue;
import com.robosoft.evaluation.dto.response.GenericServerResponse;
import com.robosoft.evaluation.dto.response.ReturnValues;
import com.robosoft.evaluation.model.UploadedFileModel;
import com.robosoft.evaluation.model.UserDetailModel;
import com.robosoft.evaluation.model.UserFavouriteModel;
import com.robosoft.evaluation.service.UserService;

/**
 * The Class UserServiceImpl.
 */
@Service
public class UserServiceImpl implements UserService{

	/** The photo and videos dao. */
	@Autowired
	private PhotoAndVideosDao photoAndVideosDao;
	
	/** The common service impl. */
	@Autowired
	private CommonServiceImpl commonServiceImpl;
	
	/**
	 * Adds the user.
	 *
	 * @param user the user
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<GenericServerResponse> addUser(RegistrationDto user) {
		
		UserDetailModel userModel = photoAndVideosDao.findUserByEmail(user.getEmail());
		if(userModel != null) {
			return commonServiceImpl.generateFailureResponse(AppConstants.USER_ALREADY_EXIST, ErrorCodes.USER_ALREADY_EXIST_MESSAGE);
		}
		UserDetailModel userEntity = new UserDetailModel();
		userEntity.setEmailId(user.getEmail());
		userEntity.setMobileNo(user.getMobile());
		userEntity.setName(user.getName());
		userEntity.setPassword(user.getPassword());
		photoAndVideosDao.save(userEntity);
	
		return commonServiceImpl.generateSuccessResponse(AppConstants.DEFAULT_SUCCESS_CODE, ErrorCodes.USER_SIGN_UP_MESSAGE);
	}

	/**
	 * Login.
	 *
	 * @param user the user
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<GenericServerResponse> login(LoginData user) {
		
		UserDetailModel userData = new UserDetailModel();
		userData = photoAndVideosDao.findUserByEmail(user.getEmail());
		
		String password = userData.getPassword();
		
		if(password.equals(user.getPassword()))
		{
			return commonServiceImpl.generateSuccessResponse(AppConstants.DEFAULT_SUCCESS_CODE, ErrorCodes.USER_SIGN_IN_MESSAGE);	
		}
		return commonServiceImpl.generateFailureResponse(AppConstants.DEFAULT_ERROR_STCODE, ErrorCodes.LOGIN_FAILURE_MESSAGE);	

	}

	/**
	 * Adds the to favourite.
	 *
	 * @param userId the user id
	 * @param videoOrImageId the video or image id
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<GenericServerResponse> addToFavourite(String userId, int videoOrImageId) {
		try {
			UserDetailModel userData = photoAndVideosDao.findUserByEmail(userId);
			if(userData == null) {
				return commonServiceImpl.generateFailureResponse(AppConstants.USER_ALREADY_EXIST, ErrorCodes.USER_NOT_FOUND_MESSAGE);
			}
			Optional<UploadedFileModel> entity = photoAndVideosDao.getFile(videoOrImageId);
			if(!entity.isPresent()) {
				return commonServiceImpl.generateFailureResponse(AppConstants.USER_ALREADY_EXIST, ErrorCodes.FILE_NOT_FOUND_MESSAGE);
			}
				
			
			photoAndVideosDao.addFavourite(entity.get(), userData);
			return commonServiceImpl.generateSuccessResponse(AppConstants.DEFAULT_SUCCESS_CODE, ErrorCodes.ADD_FAVOURITE_SUCCESS);
		}
		catch (Exception e) {
			return commonServiceImpl.generateFailureResponse(AppConstants.DEFAULT_ERROR_STCODE, ErrorCodes.ADD_FAVOURITE_FAILED);	
		}
	}

	/**
	 * Removes the favourite.
	 *
	 * @param userId the user id
	 * @param videoOrImageId the video or image id
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<GenericServerResponse> removeFavourite(String userId, int videoOrImageId) {
		UserFavouriteModel favourite = photoAndVideosDao.getFavourite(userId, videoOrImageId);
		if(!favourite.isFavourite()) {
			return commonServiceImpl.generateFailureResponse(AppConstants.DEFAULT_ERROR_STCODE, ErrorCodes.FAVOURITE_NOT_FOUND);	
		}	
		photoAndVideosDao.removeFavourite(favourite);
		return commonServiceImpl.generateSuccessResponse(AppConstants.DEFAULT_SUCCESS_CODE, ErrorCodes.REMOVE_FAVOURITE_SUCCESS);
		
	}

	/**
	 * Gets the to favourite.
	 *
	 * @param userId the user id
	 * @return the to favourite
	 */
	@Override
	public ResponseEntity<GenericServerResponse> getToFavourite(String userId) {
		List<UserFavouriteModel> favourite = photoAndVideosDao.getFavourite(userId);
		ReturnValues returnValue = new ReturnValues();
		List<FileReturnValue> files = new ArrayList<FileReturnValue>();
		if(favourite == null || favourite.isEmpty()) {
			return commonServiceImpl.generateSuccessResponse(returnValue);
		}
		for(UserFavouriteModel entity : favourite) {
			FileReturnValue data = new FileReturnValue();
			data.setFilePath(entity.getFiles() == null ?"":entity.getFiles().getFilePath());
			data.setFileOwner(entity.getFiles() == null?"":entity.getFiles().getUploadedBy().getName());
			data.setOwnerProfilePath(entity.getFiles() == null?"":entity.getFiles().getUploadedBy().getProfileUrl());
			if(entity.getFiles().getFileType() == 1) {
				data.setFileType("image/jpg");
			}
			else {
				data.setFileType("video/mp4");
			}
			data.setFileId(entity.getFiles().getId());
			files.add(data);
		}
		returnValue.setFiles(files);
		return commonServiceImpl.generateSuccessResponse(returnValue);
		
	}

}
