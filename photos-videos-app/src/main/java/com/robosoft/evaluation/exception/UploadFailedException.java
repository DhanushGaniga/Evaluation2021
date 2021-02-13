package com.robosoft.evaluation.exception;

import org.springframework.http.HttpStatus;

import com.robosoft.evaluation.constants.AppConstants;
import com.robosoft.evaluation.constants.ErrorCodes;
import com.robosoft.evaluation.dto.response.ResultInfo;
import com.robosoft.evaluation.exception.CustomizedException;


/**
 * The Class UploadFailedException.
 */
public class UploadFailedException extends CustomizedException{

	/** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	 /**
 	 * Instantiates a new upload failed exception.
 	 */
 	public UploadFailedException() {
	        this.resultInfo = new ResultInfo(AppConstants.UPLOAD_FAILED,  ErrorCodes.UPLOAD_FAILED_MESSAGE);
	        this.status = HttpStatus.OK;
	    }

}
