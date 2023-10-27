package com.ca.patient.exception;

public class CustomException extends RuntimeException {

	private static final long serialVersionUID = -1799967365424158363L;

	public CustomException(String message) {
		super(message);
	}

	public CustomException(String message, Throwable cause) {
		super(message, cause);
	}
}
