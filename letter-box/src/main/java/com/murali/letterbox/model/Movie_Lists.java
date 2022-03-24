package com.murali.letterbox.model;

import java.util.List;

public class Movie_Lists {
	private int userId;
	private String listName;
	private List<String> movieName;
	public Movie_Lists(int userId, String listName, List<String> movieName) {
		super();
		this.userId = userId;
		this.listName = listName;
		this.movieName = movieName;
	}
	public int getUserId() {
		return userId;
	}
	public String getListName() {
		return listName;
	}
	public List<String> getMovieName() {
		return movieName;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setListName(String listName) {
		this.listName = listName;
	}
	public void setMovieName(List<String> movieName) {
		this.movieName = movieName;
	}
}
