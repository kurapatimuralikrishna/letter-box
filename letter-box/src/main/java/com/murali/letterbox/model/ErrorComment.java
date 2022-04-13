package com.murali.letterbox.model;

public class ErrorComment extends Comment{

	public ErrorComment(Exception e) {
		super(0,0,0,0,e.getClass().toString()+"\n"+e.getMessage());
	}

}
