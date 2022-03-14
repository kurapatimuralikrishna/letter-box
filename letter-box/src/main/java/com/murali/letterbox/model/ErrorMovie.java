package com.murali.letterbox.model;

public class ErrorMovie extends Movie{

	public ErrorMovie(String ErrorName, String ErrorMessage) {
		super(ErrorName, ErrorMessage, " ", 0.0f);
	}

}
