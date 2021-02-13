package com.robosoft.evaluation.exception;

import org.springframework.http.HttpStatus;

import com.robosoft.evaluation.dto.response.ResultInfo;

public class DboperationFailedException extends CustomizedException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 public DboperationFailedException(Integer errorCode, String errorMessage) {
	        this.resultInfo = new ResultInfo(errorCode, errorMessage);
	        this.status = HttpStatus.OK;
	    }

}
