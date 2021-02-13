package com.robosoft.evaluation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class FileReturnValue {
	
	private String filePath;
	private String fileOwner;
	private boolean favourite = false;
	private String ownerProfilePath;
	
	private String file;

}
