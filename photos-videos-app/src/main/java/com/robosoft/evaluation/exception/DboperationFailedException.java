package com.robosoft.evaluation.exception;

import org.springframework.http.HttpStatus;

import com.robosoft.evaluation.dto.response.ResultInfo;

/**
 * The Class DboperationFailedException.
 */
public class DboperationFailedException extends CustomizedException{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	 /**
 	 * Instantiates a new dboperation failed exception.
 	 *
 	 * @param errorCode the error code
 	 * @param errorMessage the error message
 	 */
 	public DboperationFailedException(Integer errorCode, String errorMessage) {
	        this.resultInfo = new ResultInfo(errorCode, errorMessage);
	        this.status = HttpStatus.OK;
	    }

}
