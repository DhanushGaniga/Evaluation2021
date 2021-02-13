package com.robosoft.evaluation.constants;

import com.robosoft.evaluation.dto.response.ResultInfo;

public class ErrorCodes {
	
	public static final Integer INTERNAL_SERVER_ERROR_CODE = -8000;
	public static final String INTERNAL_SERVER_ERROR = "Internal server Error";
	public static final ResultInfo GENERAL_EXCEPTION = new ResultInfo(INTERNAL_SERVER_ERROR_CODE, INTERNAL_SERVER_ERROR);
	public static final String SUCCESS_MESSAGE = "Success";
	public static final String UPLOAD_FAILED_MESSAGE = "Error while saving file" ;
	public static final String FETCH_DATA_FAILED_MESSAGE = "Error while fetching file" ;
	public static final String USER_ALREADY_EXIST_MESSAGE = "User is already exist.";
	public static final String USER_NOT_FOUND_MESSAGE = "User not exist.";
	public static final String DB_OPERATION_FAILED_MESSAGE = "Error while saving data to db." ;
	public static final String USER_SIGN_UP_MESSAGE = "User registered successfully." ;
	public static final String USER_SIGN_IN_MESSAGE = "User login successfully." ;
	public static final String LOGIN_FAILURE_MESSAGE = "login failed." ;
	public static final String FILE_NOT_FOUND_MESSAGE = "File not found.";
	public static final String ADD_FAVOURITE_SUCCESS = "Added as faourite successfully";
	public static final String ADD_FAVOURITE_FAILED = "Added as faourite failed";
	public static final String FAVOURITE_NOT_FOUND = "No favourite pics found.";
	public static final String REMOVE_FAVOURITE_SUCCESS = "Removed from faourite.";

}
