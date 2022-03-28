package com.murali.letterbox.constants;

public class SqlConstants {
	public static final String GET_ALL_MOVIES = 
			"SELECT * FROM movies";

	public static final String GET_ALL_LISTS = 
			"SELECT * FROM movie_lists ml JOIN movies_inlist mil ON ml.list_id=mil.list_id;";
	public static final String GET_LIST = 
			"SELECT *\r\n"
			+ "FROM movie_lists ml\r\n"
			+ "JOIN movies_inlist mil\r\n"
			+ "	ON ml.list_id = mil.list_id\r\n"
			+ "WHERE ml.user_id = ? AND ml.list_name = ?;";
	public static final String CREATE_NEW_LIST = 
			"INSERT INTO movie_lists\r\n"
			+ "VALUES (?,?);";
}
