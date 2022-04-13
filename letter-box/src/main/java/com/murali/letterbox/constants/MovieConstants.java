package com.murali.letterbox.constants;

public class MovieConstants {
	public static final String GET_ALL_MOVIES = 
			"SELECT * FROM movies";
	public static final String GET_MOVIE = "SELECT * FROM movies WHERE movie_name = ?";
	public static final String ADD_MOVIE = "INSERT INTO MOVIES(movie_name,director,lang,rating)" + " VALUES(?,?,?,?)";
	public static final String UPDATE_MOVIE = "UPDATE MOVIES SET movie_name=?,director=?,lang=?,rating=? WHERE movie_name = ?";
	public static final String DELETE_MOVIE = "DELETE FROM MOVIES WHERE movie_name=?";

	
}
