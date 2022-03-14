package com.murali.letterbox.service;

import java.util.List;

import com.murali.letterbox.model.Movie;

public interface MovieService {
	List<Movie> getAllMovies();
	String addMovie(Movie movie) throws Exception;
	Movie getMovie(String movie) throws Exception;
	Movie updateMovie(String name, Movie movie) throws Exception;
	Movie deleteMovie(String name) throws Exception;
}
