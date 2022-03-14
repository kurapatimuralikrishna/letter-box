package com.murali.letterbox.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murali.letterbox.dao.MovieDao;
import com.murali.letterbox.model.Movie;
import com.murali.letterbox.service.MovieService;
@Service
public class MovieServiceImpl implements MovieService {

	@Autowired
	MovieDao dao;
	@Override
	public List<Movie> getAllMovies() {
		return dao.getAllMovies();
	}

	@Override
	public String addMovie(Movie movie) throws Exception {
		
		return dao.addMovie(movie);
	}

	@Override
	public Movie getMovie(String name) throws Exception {
		
		return dao.getMovie(name);
	}

	@Override
	public Movie updateMovie(String name, Movie movie) throws Exception {
		return dao.updateMovie(name,movie);
	}

	@Override
	public Movie deleteMovie(String name) throws Exception {
		return dao.deleteMovie(name);
	}

}
