package com.robosoft.evaluation.dto.response;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Errors {

    @JsonProperty("errorCode")
    private Integer errorCode;
    
    @JsonProperty("errorMessage")
    private String errorMessage;
}