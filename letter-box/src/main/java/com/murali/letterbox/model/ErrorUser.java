package com.murali.letterbox.model;

public class ErrorUser extends User {

	public ErrorUser(Exception e) {
		super(0,"", "", e.getClass().toString(), e.getMessage());
		// TODO Auto-generated constructor stub
	}
}
