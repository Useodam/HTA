package com.sample.exception;

public class AlreadyUsedIdException extends ShopException{

	private static final long serialVersionUID = 7470406665500628083L;

	public AlreadyUsedIdException(String message) {
		super(message);
	}
}
