package com.robosoft.evaluation.dto.response;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class GenericServerResponse {

	  private Integer status;
	  
	  private String message;
	
	  private Object data;
	  
	  private Errors error;
	  
	  public GenericServerResponse(Integer code, String message, Object data) {
			super();
			this.status = code;
			this.message = message;
			this.data = data;
		}

}
