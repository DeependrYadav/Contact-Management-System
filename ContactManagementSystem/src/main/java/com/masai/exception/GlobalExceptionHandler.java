package com.masai.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.NoHandlerFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(Exception.class)
	public ResponseEntity<MyExceptionClass> exception(Exception ex, WebRequest web){
		MyExceptionClass myExceptionClass = new MyExceptionClass(ex.getMessage(), web.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<MyExceptionClass>(myExceptionClass,HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(SomethingWentWrong.class)
	public ResponseEntity<MyExceptionClass> exception(SomethingWentWrong ex, WebRequest web){
		MyExceptionClass myExceptionClass = new MyExceptionClass(ex.getMessage(), web.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<MyExceptionClass>(myExceptionClass,HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(NoHandlerFoundException.class)
	public ResponseEntity<MyExceptionClass> exception(NoHandlerFoundException ex, WebRequest web){
		MyExceptionClass myExceptionClass = new MyExceptionClass(ex.getMessage(), web.getDescription(false), LocalDateTime.now());
		return new ResponseEntity<MyExceptionClass>(myExceptionClass,HttpStatus.BAD_REQUEST);
	}
}
