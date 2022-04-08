package com.murali.letterbox.constants;

public class SqlConstants {
	public static final String GET_ALL_MOVIES = 
			"SELECT * FROM movies";

	public static final String GET_ALL_LISTS = 
			"SELECT * FROM movie_lists ml LEFT JOIN movies_inlist mil ON ml.list_id=mil.list_id ORDER BY ml.list_id;";
	public static final String GET_LIST = 
			"SELECT *\r\n"
			+ "FROM movie_lists ml\r\n"
			+ "LEFT JOIN movies_inlist mil\r\n"
			+ "	ON ml.list_id = mil.list_id\r\n"
			+ "WHERE ml.user_id = ? AND ml.list_name = ?;";
	public static final String CREATE_NEW_LIST = 
			"INSERT INTO movie_lists(user_id,list_name)\r\n"
			+ "VALUES (?,?);";
	public static final String GET_LIST_ID =
			"SELECT list_id\r\n"
			+ "FROM movie_lists\r\n"
			+ "WHERE user_id=? AND list_name=?;";

	public static final String ADD_MOVIE_TOLIST = 
			"INSERT INTO movies_inlist(list_id,movie_name)\r\n"
			+ "VALUES\r\n"
			+ "	(?,?);";

	public static final String UPDATE_LIST_NAME = 
			"UPDATE movie_lists\r\n"
			+ "SET list_name= ?\r\n"
			+ "WHERE user_id=? AND list_name=?;";
	
	public static final String DELETE_MOVIES_OFLIST = 
			"DELETE FROM movies_inlist\r\n"
			+ "WHERE list_id=?;";

	public static final String DELETE_MOVIE_FROMLIST = 
			"DELETE FROM movies_inlist\r\n"
			+ "WHERE list_id=? AND movie_name=?;";

	public static final String DELETE_MOVIE_LIST = 
			"DELETE FROM MOVIE_LISTS\r\n"
			+ "WHERE list_id=?;";
}
