package com.robosoft.evaluation.dto.response;

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
 * Instantiates a new generic server response.
 */
@NoArgsConstructor

/**
 * Instantiates a new generic server response.
 *
 * @param status the status
 * @param message the message
 * @param data the data
 * @param error the error
 */
@AllArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder
public class GenericServerResponse {

	  /** The status. */
  	private Integer status;
	  
	  /** The message. */
  	private String message;
	
	  /** The data. */
  	private Object data;
	  
	  /** The error. */
  	private Errors error;
	  
	  /**
  	 * Instantiates a new generic server response.
  	 *
  	 * @param code the code
  	 * @param message the message
  	 * @param data the data
  	 */
  	public GenericServerResponse(Integer code, String message, Object data) {
			super();
			this.status = code;
			this.message = message;
			this.data = data;
		}

}
