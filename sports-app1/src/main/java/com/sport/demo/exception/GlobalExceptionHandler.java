package com.sport.demo.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(InvalidCredentialException.class)
	public ResponseEntity<String> invalidCredentialException(InvalidCredentialException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<String> resourceNotFoundException(ResourceNotFoundException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler(UserAlreadyExistException.class)
	public ResponseEntity<String> userAlreadyExistException(UserAlreadyExistException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> methodArgumentNotValidException(MethodArgumentNotValidException ex){
		final Map<String, String> map= new HashMap<>();
		ex.getFieldErrors().stream().forEach(error -> map.put(error.getField(), error.getDefaultMessage()));
		return new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(SportAlreadyExistException.class)
	public ResponseEntity<String> sportAlreadyExistException(SportAlreadyExistException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(TeamAlreadyExistException.class)
	public ResponseEntity<String> teamAlreadyExistException(TeamAlreadyExistException ex){
		return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
	}
	
}
