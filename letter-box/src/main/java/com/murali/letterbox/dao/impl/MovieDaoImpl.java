package com.murali.letterbox.dao.impl;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.murali.letterbox.constants.SqlConstants;
import com.murali.letterbox.dao.MovieDao;
import com.murali.letterbox.model.Movie;

@Component
public class MovieDaoImpl implements MovieDao {

	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public MovieDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Movie getMovie(String name) throws Exception{
		List<Movie> movies = new ArrayList<>();
		jdbcTemplate.query(SqlConstants.GET_ALL_MOVIES, (ResultSet rs) -> {
			if(rs.getString("NAME").equals(name)) {
				movies.add(new Movie(rs.getString("NAME"), rs.getString("DIRECTOR"), rs.getString("LANG"),
						rs.getFloat("RATING")));
			}
		});
		return movies.get(0);
	}

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movies = new ArrayList<>();
		jdbcTemplate.query(SqlConstants.GET_ALL_MOVIES, (ResultSet rs) -> {
			Movie movie = new Movie(rs.getString("NAME"), rs.getString("DIRECTOR"), rs.getString("LANG"),
					rs.getFloat("RATING"));
			movies.add(movie);
		});
		return movies;
	}

	@Override
	public String addMovie(Movie movie) throws Exception {
		String sql = "INSERT INTO MOVIES(NAME,DIRECTOR,LANG,RATING)" + " VALUES(?,?,?,?)";
		Object[] obj = { movie.getName(), movie.getDirector(), movie.getLang(), movie.getRating() };
		int[] types = { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.FLOAT };
		jdbcTemplate.update(sql, obj, types);

		return "Done";
	}

	@Override
	public Movie updateMovie(String name, Movie movie) throws Exception{
		String sql = "UPDATE MOVIES SET NAME=?,DIRECTOR=?,LANG=?,RATING=? WHERE NAME = ?";
		Object[] obj = { movie.getName(), movie.getDirector(), movie.getLang(), movie.getRating(), name };
		int[] types = { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.FLOAT, Types.VARCHAR };
		jdbcTemplate.update(sql, obj, types);
		return getMovie(movie.getName());
	}

	@Override
	public Movie deleteMovie(String name) throws Exception {
		Movie movie = getMovie(name);
		String sql = "DELETE FROM MOVIES WHERE NAME=?";
		Object[] obj = {name};
		int[] types = {Types.VARCHAR};
		jdbcTemplate.update(sql, obj, types);
		return movie;
	}

}
