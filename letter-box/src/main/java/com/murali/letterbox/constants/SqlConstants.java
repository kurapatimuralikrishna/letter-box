package com.murali.letterbox.constants;

public class SqlConstants {
	public static final String GET_ALL_MOVIES="SELECT * FROM movies";
	public static final String GET_ALL_LISTS="SELECT * FROM movie_lists ml JOIN movies_inlist mil ON ml.list_id=mil.list_id";
}
