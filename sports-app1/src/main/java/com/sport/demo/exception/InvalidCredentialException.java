package com.sport.demo.exception;

public class InvalidCredentialException extends RuntimeException{

	public InvalidCredentialException(String message) {
		super(message);
	}
}
