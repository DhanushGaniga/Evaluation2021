package com.robosoft.evaluation.service;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.robosoft.evaluation.constants.AppConstants;
import com.robosoft.evaluation.constants.ErrorCodes;
import com.robosoft.evaluation.dto.response.GenericServerResponse;

@Component
public class CommonServiceImpl {
	
	public ResponseEntity<GenericServerResponse> generateSuccessResponse(Object responseObject) {
    	GenericServerResponse serverResponse = GenericServerResponse.builder().status(AppConstants.DEFAULT_SUCCESS_CODE)
    											.message(ErrorCodes.SUCCESS_MESSAGE).data(responseObject).build();
        return new ResponseEntity<>(serverResponse, HttpStatus.OK);
    }

}
