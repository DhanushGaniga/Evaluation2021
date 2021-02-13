package com.robosoft.evaluation.exception;

import com.robosoft.evaluation.constants.ErrorCodes;
import com.robosoft.evaluation.dto.response.ResultInfo;

import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;

/**
 * The Class CustomizedException.
 */
public class CustomizedException extends RuntimeException{

    /** The Constant serialVersionUID. */
	private static final long serialVersionUID = 1L;
	
	/** The result info. */
	protected ResultInfo resultInfo = ErrorCodes.GENERAL_EXCEPTION;
    
    /** The status. */
    protected HttpStatus status = HttpStatus.INTERNAL_SERVER_ERROR;

    /**
     * Instantiates a new customized exception.
     */
    public CustomizedException() {
        super();
    }

    /**
     * Instantiates a new customized exception.
     *
     * @param msg the msg
     */
    public CustomizedException(@Nullable String msg) {
        super(msg);
    }

    /**
     * Instantiates a new customized exception.
     *
     * @param status the status
     * @param msg the msg
     */
    public CustomizedException(HttpStatus status, @Nullable String msg) {
        super(msg);
        this.status = status;
    }

    /**
     * Instantiates a new customized exception.
     *
     * @param status the status
     * @param msg the msg
     * @param resultInfo the result info
     */
    public CustomizedException(HttpStatus status, @Nullable String msg, ResultInfo resultInfo) {
        super(msg);
        this.resultInfo = new ResultInfo(resultInfo.getCode(), resultInfo.getMessage());
        this.status = status;
    }

    /**
     * Gets the result info.
     *
     * @return the result info
     */
    public ResultInfo getResultInfo() {
        return resultInfo;
    }

    /**
     * Sets the result info.
     *
     * @param resultInfo the new result info
     */
    public void setResultInfo(ResultInfo resultInfo) {
        this.resultInfo = resultInfo;
    }

    /**
     * Gets the status.
     *
     * @return the status
     */
    public HttpStatus getStatus() {
        return status;
    }

    /**
     * Sets the status.
     *
     * @param status the new status
     */
    public void setStatus(HttpStatus status) {
        this.status = status;
    }

}
