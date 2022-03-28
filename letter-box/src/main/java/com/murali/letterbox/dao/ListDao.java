package com.murali.letterbox.dao;

import java.util.List;

import com.murali.letterbox.model.MovieList;

public interface ListDao {
	List<MovieList> getAllLists();
	String createList(MovieList list) throws Exception;
	MovieList getList(int userId, String name) throws Exception;
	MovieList updateMovie(String name, MovieList list) throws Exception;
	MovieList deleteMovieList(String name) throws Exception;
	String addMovieToList(int userId, String listName, String name);
}