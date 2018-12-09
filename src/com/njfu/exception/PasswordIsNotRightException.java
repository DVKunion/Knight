package com.njfu.exception;

public class PasswordIsNotRightException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PasswordIsNotRightException(String msg){
		super(msg);
	}
}
