package com.robosoft.evaluation.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.robosoft.evaluation.constants.AppConstants;
import com.robosoft.evaluation.constants.ErrorCodes;
import com.robosoft.evaluation.dto.response.Errors;
import com.robosoft.evaluation.dto.response.GenericServerResponse;

/**
 * The Class CommonServiceImpl.
 */
@Component
public class CommonServiceImpl {
	
	/**
	 * Generate success response.
	 *
	 * @param responseObject the response object
	 * @return the response entity
	 */
	public ResponseEntity<GenericServerResponse> generateSuccessResponse(Object responseObject) {
    	GenericServerResponse serverResponse = GenericServerResponse.builder().status(AppConstants.DEFAULT_SUCCESS_CODE)
    											.message(ErrorCodes.SUCCESS_MESSAGE).data(responseObject).build();
        return new ResponseEntity<>(serverResponse, HttpStatus.OK);
    }
	
	/**
	 * Generate failure response.
	 *
	 * @param errorCode the error code
	 * @param errorMessage the error message
	 * @return the response entity
	 */
	public ResponseEntity<GenericServerResponse> generateFailureResponse(Integer errorCode,String errorMessage) {
		GenericServerResponse serverResponse = null;//GenericServerResponse.builder().code(errorCode).message(errorMessage).build();
		if(errorCode<0) {
			serverResponse=GenericServerResponse.builder()
					      .status(AppConstants.DEFAULT_ERROR_STCODE)
					      .error(Errors.builder().errorCode(errorCode).errorMessage(errorMessage).build()).build();
		}
		return new ResponseEntity<>(serverResponse, HttpStatus.OK);
	}
	
	 /**
 	 * Generate success response.
 	 *
 	 * @param successCode the success code
 	 * @param message the message
 	 * @return the response entity
 	 */
 	public ResponseEntity<GenericServerResponse> generateSuccessResponse(Integer successCode,String message) {
			GenericServerResponse serverResponse = GenericServerResponse.builder().status(successCode).message(message).build();
			return new ResponseEntity<>(serverResponse, HttpStatus.OK);
		}

}
