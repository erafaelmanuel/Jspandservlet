package com.erm.sample.jee.exception;

public class LoginException extends Exception {
	
	private static final long serialVersionUID = 54654238723874781L;

	public LoginException() {
		super();
	}
	
	public LoginException(final String message) {
		super(message);
	}

}
