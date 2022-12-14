package com.acks.homecontroller;

import java.util.HashMap;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class validationhandeler  extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		// TODO Auto-generated method stub
		HashMap<String, String> errors = new HashMap<>();
		ex.getBindingResult().getAllErrors().forEach((error)->{ String fieldname=((FieldError)error).getField();
		String message=error.getDefaultMessage();
		errors.put(fieldname, message);
		
		});
	
	return new ResponseEntity<Object>(errors,HttpStatus.BAD_REQUEST);


}}
