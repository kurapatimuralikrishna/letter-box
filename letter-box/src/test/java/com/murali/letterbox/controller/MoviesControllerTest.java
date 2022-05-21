package com.murali.letterbox.controller;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

import com.murali.letterbox.model.Movie;
import com.murali.letterbox.service.MovieService;

@RunWith(MockitoJUnitRunner.class)
public class MoviesControllerTest {
	@Mock
	MovieService service;
	@InjectMocks
	MoviesController controller;
	
	@Test
	public void getMovieTest() throws Exception {
		
		String str = "DHAMAAL";
		Movie movie = new Movie("","","",0.0f);
		Mockito.when(service.getMovie(ArgumentMatchers.anyString())).thenReturn(movie);
		
		controller.getMovie(str);
	}
	@Test
	public void getMovieNegativeTest() throws Exception {
		
		String str = "DHAMAAL";
		Movie movie = new Movie("","","",0.0f);
		Mockito.when(service.getMovie(ArgumentMatchers.anyString())).thenThrow(new NullPointerException());
		
		controller.getMovie(str);
		
	}
	
}
