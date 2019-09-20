package com.revature.exceptions;

public class OverdraftException extends Exception{
	private static final long serialVersionUID = 1L;

	public OverdraftException() {
		System.out.println("Insufficient funds, try again next time");
	}
}