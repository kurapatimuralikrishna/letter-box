package com.murali.letterbox.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.murali.letterbox.model.ErrorMovie;
import com.murali.letterbox.model.Movie;
import com.murali.letterbox.service.MovieService;

@RestController
@RequestMapping("letterbox")
public class MoviesController {
	@Autowired
	MovieService service;

	@GetMapping(value = "/movies")
	public List<Movie> getAllMovies() {
		// getAllMovies();
		return service.getAllMovies();
	}

	@GetMapping(value = "/movies/{name}")
	public Movie getMovie(@PathVariable String name) {
		// get a specific movie
		try {
			return service.getMovie(name);
		}
		catch(Exception e) {
			System.err.println("Unexpected Exception: " + e.getClass().toString() + "\n" + e.getMessage());
			return new ErrorMovie(e.getClass().toString(),e.getMessage());
		}
	}

	@PostMapping(value = "/movies/addmovie")
	public String addMovie(@RequestBody Movie movie) {
		try {
			return service.addMovie(movie);
		} catch (Exception e) {
			return "Unexpected Exception: " + e.getClass().toString() + "\n" + e.getMessage();
		}
	}

	@PutMapping(value = "/movies/{name}/update")
	public Movie putMovie(@PathVariable String name, @RequestBody Movie movie) {
		try {
			return service.updateMovie(name, movie);
		} catch (Exception e) {
			System.err.println("Unexpected Exception: " + e.getClass().toString() + "\n" + e.getMessage());
			return new ErrorMovie(e.getClass().toString(),e.getMessage());
		}
	}

	@DeleteMapping("/movies/{name}/delete")
	public Movie deleteMovie(@PathVariable String name) {
		try {
			return service.deleteMovie(name);
		} catch (Exception e) {
			System.err.println("Unexpected Exception: " + e.getClass().toString() + "\n" + e.getMessage());
			return new ErrorMovie(e.getClass().toString(),e.getMessage());
		}
	}
}
