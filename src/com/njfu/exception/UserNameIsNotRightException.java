package com.njfu.exception;

public class UserNameIsNotRightException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public UserNameIsNotRightException(String msg){
		super(msg);
	}
}
