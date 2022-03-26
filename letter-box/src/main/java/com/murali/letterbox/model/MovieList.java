package com.murali.letterbox.model;

import java.util.List;

public class MovieList {
	private int listId;

	public int getListId() {
		return listId;
	}

	public void setListId(int listId) {
		this.listId = listId;
	}

	private int userId;
	private String listName;
	private List<String> movieNames;

	public MovieList(int listId, int userId, String listName, List<String> movieNames) {
		super();
		this.listId = listId;
		this.userId = userId;
		this.listName = listName;
		this.movieNames = movieNames;
	}

	public int getUserId() {
		return userId;
	}

	public String getListName() {
		return listName;
	}

	public List<String> getMovieNames() {
		return movieNames;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public void setListName(String listName) {
		this.listName = listName;
	}

	public void setMovieNames(List<String> movieNames) {
		this.movieNames = movieNames;
	}

	public void addMovie(Movie movie) {
		this.movieNames.add(movie.getName());
	}

	public void addMovie(String name) {
		this.movieNames.add(name);
	}

	@Override
	public String toString() {
		return "MovieList [listId=" + listId + "\n userId=" + userId + "\n listName=" + listName + "\n movieNames="
				+ movieNames.toString() + "]";
	}
}
