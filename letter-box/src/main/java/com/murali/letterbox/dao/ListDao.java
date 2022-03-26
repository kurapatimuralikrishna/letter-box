package com.murali.letterbox.dao;

import java.util.List;

import com.murali.letterbox.model.MovieList;

public interface ListDao {
	List<MovieList> getAllMovieLists();
	String addMovieList(MovieList list) throws Exception;
	MovieList getMovieList(String name) throws Exception;
	MovieList updateMovie(String name, MovieList list) throws Exception;
	MovieList deleteMovieList(String name) throws Exception;
}