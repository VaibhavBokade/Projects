package com.sport.demo.exception;

public class TeamAlreadyExistException extends RuntimeException{

	public TeamAlreadyExistException(String msg) {
		super(msg);
	}

}
