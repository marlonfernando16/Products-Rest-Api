package com.products.restapi.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Date;

import com.products.restapi.error.ResourceNotFoundDetails;
import com.products.restapi.error.ResourceNotFoundException;

@ControllerAdvice
public class RestExceptionHandler {

	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundException rnfException) {
		ResourceNotFoundDetails rnfDetails = new ResourceNotFoundDetails(
				"Resource not found",
				HttpStatus.NOT_FOUND.value(),
				rnfException.getMessage(),
				new Date().getTime(),
				rnfException.getClass().getName()
		);
		
		return new ResponseEntity<>(rnfDetails, HttpStatus.NOT_FOUND);
	}
}
