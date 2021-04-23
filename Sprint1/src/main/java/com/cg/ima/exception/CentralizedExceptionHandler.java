package com.cg.ima.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class CentralizedExceptionHandler {
	
	@ResponseStatus(code = HttpStatus.NOT_FOUND)
	@ExceptionHandler(InvalidEmployeeException.class)
	public String handleStudentNotFound(InvalidEmployeeException e)
	{
		return e.getMessage();
	}
}
