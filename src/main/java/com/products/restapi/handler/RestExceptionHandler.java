package com.products.restapi.handler;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.products.restapi.error.ResourceNotFoundDetails;
import com.products.restapi.error.ResourceNotFoundException;
import com.products.restapi.error.ValidationErrorDetails;

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
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException manvException) {
		List<FieldError> fieldErrors = manvException.getBindingResult().getFieldErrors();
		
		String fields = fieldErrors.stream().map(FieldError::getField).collect(Collectors.joining(","));
		String fieldMessages = fieldErrors.stream().map(FieldError::getDefaultMessage).collect(Collectors.joining(","));

		ValidationErrorDetails manvDetails = new ValidationErrorDetails(
				"Field Validation Error",
				HttpStatus.NOT_FOUND.value(),
				"Field Validation Error",
				new Date().getTime(),
				manvException.getClass().getName(),
				fields,
				fieldMessages
		);
		
		return new ResponseEntity<>(manvDetails, HttpStatus.NOT_FOUND);
	}
}
