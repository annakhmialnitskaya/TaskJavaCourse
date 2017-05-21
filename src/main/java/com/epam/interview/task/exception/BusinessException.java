package com.epam.interview.task.exception;

public class BusinessException extends Exception {

	public BusinessException(String message, char incorrectParameter) {
		super(String.format(message, incorrectParameter));
	}

}
