package com.cg.Student.exception;

import java.util.Date;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class StudentExceptionHandler  extends ResponseEntityExceptionHandler{
	
	

		@ExceptionHandler(Exception.class)
		  public final ResponseEntity<Object> handleAllExceptions(Exception ex, WebRequest request) {
		    StudentErrorDetails errorDetails = new StudentErrorDetails(new Date(), ex.getMessage(),
		        request.getDescription(false));
		    return new ResponseEntity(errorDetails, HttpStatus.INTERNAL_SERVER_ERROR);
		  }

		  @ExceptionHandler(StudentnotfoundException.class)
		  public final ResponseEntity<Object> handleUserNotFoundException(StudentnotfoundException ex, WebRequest request) {
			  StudentErrorDetails errorDetails = new StudentErrorDetails(new Date(), ex.getMessage(),
		        request.getDescription(false));
		    return new ResponseEntity(errorDetails, HttpStatus.NOT_FOUND);
		  }

		  @Override
		  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
		      HttpHeaders headers, HttpStatus status, WebRequest request) {
		
			  StudentErrorDetails errorDetails = new StudentErrorDetails(new Date(), "Validation Failed",
		        ex.getBindingResult().toString());
		    return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
		  } 
	}

