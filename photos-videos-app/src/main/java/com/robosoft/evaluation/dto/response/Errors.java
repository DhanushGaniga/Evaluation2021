package com.robosoft.evaluation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Data

/**
 * Instantiates a new errors.
 *
 * @param errorCode the error code
 * @param errorMessage the error message
 */
@AllArgsConstructor

/**
 * Instantiates a new errors.
 */
@NoArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder
public class Errors {

    /** The error code. */
    @JsonProperty("errorCode")
    private Integer errorCode;
    
    /** The error message. */
    @JsonProperty("errorMessage")
    private String errorMessage;
}