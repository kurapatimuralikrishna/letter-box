package com.murali.letterbox.service;

import java.util.List;

import com.murali.letterbox.model.MovieList;

public interface ListService {

	List<MovieList> getAllLists();

	String createList(MovieList list) throws Exception;

	MovieList getList(int userId, String name) throws Exception;

	MovieList deleteList(int uid, String lname) throws Exception;

	String addMovieToList(int userId, String listName, String name) throws Exception;

	String removeMovieFromList(int uid, String lname, String movieName) throws Exception;

	MovieList updateList(int uid, String lname, MovieList list) throws Exception;

}
