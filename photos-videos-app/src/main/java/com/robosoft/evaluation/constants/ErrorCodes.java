package com.robosoft.evaluation.constants;

import com.robosoft.evaluation.dto.response.ResultInfo;

public class ErrorCodes {
	
	public static final Integer INTERNAL_SERVER_ERROR_CODE = -8000;
	public static final String INTERNAL_SERVER_ERROR = "Internal server Error";
	
	public static final ResultInfo GENERAL_EXCEPTION = new ResultInfo(INTERNAL_SERVER_ERROR_CODE, INTERNAL_SERVER_ERROR);
	public static final Integer UPLOAD_FAILED = -100 ;

}
