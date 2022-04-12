package com.murali.letterbox.constants;

public class ReviewConstants {

	public static final String GET_REVIEW = "SELECT * FROM movie_reviews WHERE user_id=? AND movie_name = ?;";
	public static final String GET_MOVIE_REVIEWS = "SELECT * FROM movie_reviews WHERE movie_name = ?;";
	public static final String GET_MOVIE_RATINGS = "SELECT rating FROM movie_reviews WHERE movie_name = ?;";
	public static final String GET_LIST_RATINGS = "SELECT rating\r\n" + "FROM movie_reviews mr\r\n"
			+ "JOIN movies_inlist mil\r\n" + "	ON mr.movie_name = mil.movie_name" + "WHERE mil.list_id=?";
	public static final String GET_ALL_REVIEWS = "SELECT * FROM movie_reviews";
	public static final String POST_REVIEW = "INSERT INTO movie_reviews VALUES (?,?,?,?)";
	public static final String UPDATE_REVIEW = "UPDATE movie_reviews SET rating=?,review=?";
	public static final String DELETE_REVIEW = "DELETE FROM movie_reviews WHERE user_id=? AND movie_name=?";
}
