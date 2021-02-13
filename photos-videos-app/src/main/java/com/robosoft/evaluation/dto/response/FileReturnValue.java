package com.robosoft.evaluation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Gets the file.
 *
 * @return the file
 */
@Getter

/**
 * Sets the file.
 *
 * @param file the new file
 */
@Setter

/**
 * Instantiates a new file return value.
 */
@NoArgsConstructor

/**
 * Instantiates a new file return value.
 *
 * @param filePath the file path
 * @param fileOwner the file owner
 * @param favourite the favourite
 * @param ownerProfilePath the owner profile path
 * @param fileType the file type
 * @param file the file
 */
@AllArgsConstructor
public class FileReturnValue {
	
	/** The file path. */
	private String filePath;
	
	/** The file owner. */
	private String fileOwner;
	
	/** The favourite. */
	private boolean favourite = false;
	
	/** The owner profile path. */
	private String ownerProfilePath;
	
	/** The file type. */
	private String fileType;
	
	/** The file. */
	private String file;
	
	/** The file id. */
	private Integer fileId;

}
