package org.tapa.customer.controller;

import java.sql.SQLIntegrityConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.tapa.customer.exception.OrderNotFoundException;

/**
 * GlobalExceptionHandler- handle various exceptions thrown by the application.
 */
@ControllerAdvice
public class GlobalExceptionHandler {

	/**
	 * @return ResponseEntity string message for the exception.
	 */
	@ExceptionHandler(OrderNotFoundException.class)
	public ResponseEntity<String> orderNotFoundException(OrderNotFoundException ex) {
		String message = ex.getMessage();
		return new ResponseEntity<String>(message, HttpStatus.NOT_FOUND);
	}

	/**
	 * Invalid format
	 */
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ResponseEntity<String> handleInvalidData(HttpMessageNotReadableException ex) {
		String message = ex.getMessage();
		return new ResponseEntity<>("Invalid Type of Data, Enter correct Format", HttpStatus.BAD_REQUEST);
	}

	@ExceptionHandler(SQLIntegrityConstraintViolationException.class)
	public ResponseEntity<String> handleInvalidData(SQLIntegrityConstraintViolationException ex) {
		String message = ex.getMessage();
		return new ResponseEntity<>(message, HttpStatus.BAD_REQUEST);
	}

	/**
	 * for invalid url .
	 */
	@ExceptionHandler(MethodArgumentTypeMismatchException.class)
	public ResponseEntity<String> handleInvalidData(MethodArgumentTypeMismatchException ex) {
		String message = ex.getMessage();
		return new ResponseEntity<>("Invalid Url, Give integer value", HttpStatus.BAD_REQUEST);
	}
	
	/**
	 * Data cannot be null.
	 */
	@ExceptionHandler(DataIntegrityViolationException.class)
	public ResponseEntity<String> handleInvalidData(DataIntegrityViolationException ex) {
		String message = ex.getMessage();
		return new ResponseEntity<>("Data Cannot be Null.", HttpStatus.BAD_REQUEST);
	}

}
