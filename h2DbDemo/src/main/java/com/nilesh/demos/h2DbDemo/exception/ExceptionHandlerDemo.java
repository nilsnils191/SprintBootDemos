package com.nilesh.demos.h2DbDemo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerDemo extends ResponseEntityExceptionHandler
{

	@ExceptionHandler(NotFoundException.class)
	public final ResponseEntity<ExceptionMessage> notFoundException(NotFoundException ne,WebRequest re) {
		ExceptionMessage exceptionMessage = new ExceptionMessage();
		exceptionMessage.setError("Error occurred");
		exceptionMessage.setMessage(ne.getMessage());
		exceptionMessage.setStatus(HttpStatus.NO_CONTENT);
        return new ResponseEntity<ExceptionMessage>(exceptionMessage, HttpStatus.NOT_FOUND);
	}
}
