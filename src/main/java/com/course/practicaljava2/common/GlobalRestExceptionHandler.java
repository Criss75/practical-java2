package com.course.practicaljava2.common;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.course.practicaljava2.exception.IllegalApiParamException;
import com.course.practicaljava2.rest.domain.ErrorResponse;

@RestControllerAdvice
public class GlobalRestExceptionHandler {

	private static final Logger log = LoggerFactory.getLogger(GlobalRestExceptionHandler.class);

	@ExceptionHandler(IllegalApiParamException.class)
	public ResponseEntity<ErrorResponse> handleIllegalApiParamException(IllegalApiParamException ex) {
		var errorMessage = "Exception IllegalApiParamException: from GlobalRestExceptionHandler: " + ex.getMessage();
		log.warn(errorMessage);

		var errorResponse = new ErrorResponse(errorMessage, System.currentTimeMillis());
		return new ResponseEntity(errorResponse, null, HttpStatus.BAD_REQUEST);
	}
}
