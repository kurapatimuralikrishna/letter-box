package com.murali.letterbox.constants;

public class SqlConstants {
	public static final String GET_ALL_MOVIES="SELECT * FROM movies";
	public static final String GET_ALL_LISTS="SELECT * FROM movie_lists JOIN movies_inlists mil ON lisy_id=mil.list_id";
}
