package com.robosoft.evaluation.dto.response;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Gets the files.
 *
 * @return the files
 */
@Getter

/**
 * Sets the files.
 *
 * @param files the new files
 */
@Setter

/**
 * Instantiates a new return values.
 */
@NoArgsConstructor

/**
 * Instantiates a new return values.
 *
 * @param files the files
 */
@AllArgsConstructor
public class ReturnValues {
	
	/** The files. */
	@JsonProperty("data")
	private List<FileReturnValue> files;

}
