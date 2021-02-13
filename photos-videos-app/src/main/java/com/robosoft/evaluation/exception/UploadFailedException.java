package com.robosoft.evaluation.exception;

import org.springframework.http.HttpStatus;

import com.robosoft.evaluation.constants.AppConstants;
import com.robosoft.evaluation.constants.ErrorCodes;
import com.robosoft.evaluation.dto.response.ResultInfo;
import com.robosoft.evaluation.exception.CustomizedException;

public class UploadFailedException extends CustomizedException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	 public UploadFailedException() {
	        this.resultInfo = new ResultInfo(ErrorCodes.UPLOAD_FAILED,  AppConstants.PHOTO_UPLOAD_FAILED_MESSAGE);
	        this.status = HttpStatus.OK;
	    }

}
