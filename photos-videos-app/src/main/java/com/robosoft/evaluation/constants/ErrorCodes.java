package com.robosoft.evaluation.constants;

import com.robosoft.evaluation.dto.response.ResultInfo;

/**
 * The Class ErrorCodes.
 */
public class ErrorCodes {
	
	/** The Constant INTERNAL_SERVER_ERROR_CODE. */
	public static final Integer INTERNAL_SERVER_ERROR_CODE = -8000;
	
	/** The Constant INTERNAL_SERVER_ERROR. */
	public static final String INTERNAL_SERVER_ERROR = "Internal server Error";
	
	/** The Constant GENERAL_EXCEPTION. */
	public static final ResultInfo GENERAL_EXCEPTION = new ResultInfo(INTERNAL_SERVER_ERROR_CODE, INTERNAL_SERVER_ERROR);
	
	/** The Constant SUCCESS_MESSAGE. */
	public static final String SUCCESS_MESSAGE = "Success";
	
	/** The Constant UPLOAD_FAILED_MESSAGE. */
	public static final String UPLOAD_FAILED_MESSAGE = "Error while saving file" ;
	
	/** The Constant FETCH_DATA_FAILED_MESSAGE. */
	public static final String FETCH_DATA_FAILED_MESSAGE = "Error while fetching file" ;
	
	/** The Constant USER_ALREADY_EXIST_MESSAGE. */
	public static final String USER_ALREADY_EXIST_MESSAGE = "User is already exist.";
	
	/** The Constant USER_NOT_FOUND_MESSAGE. */
	public static final String USER_NOT_FOUND_MESSAGE = "User not exist.";
	
	/** The Constant DB_OPERATION_FAILED_MESSAGE. */
	public static final String DB_OPERATION_FAILED_MESSAGE = "Error in db operation" ;
	
	/** The Constant USER_SIGN_UP_MESSAGE. */
	public static final String USER_SIGN_UP_MESSAGE = "User registered successfully." ;
	
	/** The Constant USER_SIGN_IN_MESSAGE. */
	public static final String USER_SIGN_IN_MESSAGE = "User login successfully." ;
	
	/** The Constant LOGIN_FAILURE_MESSAGE. */
	public static final String LOGIN_FAILURE_MESSAGE = "login failed." ;
	
	/** The Constant FILE_NOT_FOUND_MESSAGE. */
	public static final String FILE_NOT_FOUND_MESSAGE = "File not found.";
	
	/** The Constant ADD_FAVOURITE_SUCCESS. */
	public static final String ADD_FAVOURITE_SUCCESS = "Added as faourite successfully";
	
	/** The Constant ADD_FAVOURITE_FAILED. */
	public static final String ADD_FAVOURITE_FAILED = "Added as faourite failed";
	
	/** The Constant FAVOURITE_NOT_FOUND. */
	public static final String FAVOURITE_NOT_FOUND = "No favourite pics found.";
	
	/** The Constant REMOVE_FAVOURITE_SUCCESS. */
	public static final String REMOVE_FAVOURITE_SUCCESS = "Removed from faourite.";

}
