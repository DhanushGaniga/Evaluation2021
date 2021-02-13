package com.robosoft.evaluation.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.robosoft.evaluation.constants.AppConstants;
import com.robosoft.evaluation.constants.ErrorCodes;
import com.robosoft.evaluation.dao.PhotoAndVideosDao;
import com.robosoft.evaluation.dto.request.LoginData;
import com.robosoft.evaluation.dto.request.RegistrationDto;
import com.robosoft.evaluation.dto.response.GenericServerResponse;
import com.robosoft.evaluation.model.UploadedFileModel;
import com.robosoft.evaluation.model.UserDetailModel;
import com.robosoft.evaluation.model.UserFavouriteModel;
import com.robosoft.evaluation.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private PhotoAndVideosDao photoAndVideosDao;
	@Autowired
	private CommonServiceImpl commonServiceImpl;
	
	@Override
	public ResponseEntity<GenericServerResponse> addUser(RegistrationDto user) {
		
		System.out.println(user.getEmail());
		UserDetailModel userModel = new UserDetailModel();
		
		userModel = photoAndVideosDao.findUserByEmail(user.getEmail());
		if(userModel != null) {
			return commonServiceImpl.generateFailureResponse(AppConstants.USER_ALREADY_EXIST, ErrorCodes.USER_ALREADY_EXIST_MESSAGE);
		}
		userModel.setEmailId(user.getEmail());
		userModel.setMobileNo(user.getMobile());
		userModel.setName(user.getName());
		userModel.setPassword(user.getPassword());
		photoAndVideosDao.save(userModel);
	
		return commonServiceImpl.generateSuccessResponse(AppConstants.DEFAULT_SUCCESS_CODE, ErrorCodes.USER_SIGN_UP_MESSAGE);
	}

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

	@Override
	public ResponseEntity<GenericServerResponse> removeFavourite(String userId, int videoOrImageId) {
		UserFavouriteModel favourite = photoAndVideosDao.getFavourite(userId, videoOrImageId);
		if(!favourite.isFavourite()) {
			return commonServiceImpl.generateFailureResponse(AppConstants.DEFAULT_ERROR_STCODE, ErrorCodes.FAVOURITE_NOT_FOUND);	
		}	
		photoAndVideosDao.removeFavourite(favourite);
		return commonServiceImpl.generateSuccessResponse(AppConstants.DEFAULT_SUCCESS_CODE, ErrorCodes.REMOVE_FAVOURITE_SUCCESS);
		
	}
	
	

}
