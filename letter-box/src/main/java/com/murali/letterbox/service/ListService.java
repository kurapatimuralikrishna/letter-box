package com.murali.letterbox.service;

import java.util.List;

import com.murali.letterbox.model.Movie;
import com.murali.letterbox.model.MovieList;


public interface ListService {

	List<MovieList> getAllLists();
	String createList(MovieList list) throws Exception;
	MovieList getList(int userId, String name) throws Exception;
	MovieList updateList(String name, Movie movie) throws Exception;
	MovieList deleteList(String name) throws Exception;
	String addMovieToList(int userId, String listName, String name);

}
