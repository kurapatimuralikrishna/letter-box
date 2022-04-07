package com.murali.letterbox.dao;

import java.util.List;

import com.murali.letterbox.model.MovieList;

public interface ListDao {
	List<MovieList> getAllLists();
	String createList(MovieList list) throws Exception;
	MovieList getList(int userId, String lname) throws Exception;
	MovieList updateMovie(int uid, String name, MovieList list) throws Exception;
	MovieList deleteMovieList(int uid, String lname) throws Exception;
	String addMovieToList(int userId, String listName, String name) throws Exception;
	String removeMovieFromList(int uid, String lname, String movieName) throws Exception;
}