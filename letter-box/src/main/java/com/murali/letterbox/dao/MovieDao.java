package com.murali.letterbox.dao;

import java.util.List;

import com.murali.letterbox.model.Movie;

public interface MovieDao {
	List<Movie> getAllMovies();
	String addMovie(Movie movie) throws Exception;
	Movie getMovie(String name) throws Exception;
	Movie updateMovie(String name, Movie movie) throws Exception;
	Movie deleteMovie(String name) throws Exception;
}
