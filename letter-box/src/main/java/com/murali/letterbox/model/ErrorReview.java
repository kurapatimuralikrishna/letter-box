package com.murali.letterbox.model;

public class ErrorReview extends Review {

	public ErrorReview(Exception e) {
		super(0, e.getClass().toString(), 0f,e.getMessage());
	}
	
}
