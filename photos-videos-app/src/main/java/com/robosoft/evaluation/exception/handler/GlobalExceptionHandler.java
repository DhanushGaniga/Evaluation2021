package com.robosoft.evaluation.exception.handler;


import com.robosoft.evaluation.dto.response.GenericServerResponse;
import com.robosoft.evaluation.exception.CustomizedException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletResponse;


@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    private static final String DEFAULT_EXCEPTION_CAUSE_FORMAT = "Exception : {} , Cause : {}";

    @ExceptionHandler(CustomizedException.class)
    public ResponseEntity<GenericServerResponse> handleGeneralBentoException(final HttpServletResponse response, CustomizedException e) {
        log.error(DEFAULT_EXCEPTION_CAUSE_FORMAT, e.getClass(), e.getMessage());
        String errMsg = e.getResultInfo().getMessage() != null ? e.getResultInfo().getMessage() : e.getMessage();
        GenericServerResponse serverResponse = new GenericServerResponse(e.getResultInfo().getCode(), errMsg, null);
        return new ResponseEntity<>(serverResponse, e.getStatus());
    }

}
