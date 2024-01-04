package com.masai.exception;

public class SomethingWentWrong extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SomethingWentWrong(String msg) {
		super(msg);
	}
}
