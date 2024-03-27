package com.sample.exception;

public class AlreadyUsedEmailException extends ShopException{


	private static final long serialVersionUID = 5511708499620158769L;

	public AlreadyUsedEmailException(String message) {
		super(message);
	}
}
