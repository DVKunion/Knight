package com.njfu.exception;

public class UserIsNotExistException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserIsNotExistException(String msg){
		super(msg);
	}
}
