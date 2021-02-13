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
 * Instantiates a new result info.
 *
 * @param code the code
 * @param message the message
 */
@AllArgsConstructor

/**
 * Instantiates a new result info.
 */
@NoArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */
@Builder
public class ResultInfo {

  /** The code. */
  private Integer code;
  
  /** The message. */
  private String message;
}
