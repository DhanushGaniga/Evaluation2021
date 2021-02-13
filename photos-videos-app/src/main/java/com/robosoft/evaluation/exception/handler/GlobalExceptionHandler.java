package com.robosoft.evaluation.exception.handler;


import com.robosoft.evaluation.dto.response.GenericServerResponse;
import com.robosoft.evaluation.exception.CustomizedException;

import lombok.extern.slf4j.Slf4j;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import javax.servlet.http.HttpServletResponse;


/**
 * The Class GlobalExceptionHandler.
 */
@ControllerAdvice

/** The Constant log. */
@Slf4j
public class GlobalExceptionHandler {

    /** The Constant DEFAULT_EXCEPTION_CAUSE_FORMAT. */
    private static final String DEFAULT_EXCEPTION_CAUSE_FORMAT = "Exception : {} , Cause : {}";

    /**
     * Handle general bento exception.
     *
     * @param response the response
     * @param e the e
     * @return the response entity
     */
    @ExceptionHandler(CustomizedException.class)
    public ResponseEntity<GenericServerResponse> handleGeneralBentoException(final HttpServletResponse response, CustomizedException e) {
        log.error(DEFAULT_EXCEPTION_CAUSE_FORMAT, e.getClass(), e.getMessage());
        String errMsg = e.getResultInfo().getMessage() != null ? e.getResultInfo().getMessage() : e.getMessage();
        GenericServerResponse serverResponse = new GenericServerResponse(e.getResultInfo().getCode(), errMsg, null);
        return new ResponseEntity<>(serverResponse, e.getStatus());
    }

}
