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
	public Movie getMovie(String name) throws Exception {
		Object[] names = {name};
		int[] types = {Types.VARCHAR};
		Movie movie = jdbcTemplate.query("SELECT * FROM movies WHERE movie_name = ?",names,types, (ResultSet rs) -> {
			if(rs.next())
				return new Movie(rs.getString("movie_name"), rs.getString("director"), rs.getString("lang"),
						rs.getFloat("rating"));
			else return null;
		});
		return movie;
	}

	@Override
	public List<Movie> getAllMovies() {
		List<Movie> movies = new ArrayList<>();
		jdbcTemplate.query(SqlConstants.GET_ALL_MOVIES, (ResultSet rs) -> {
			Movie movie = new Movie(rs.getString("movie_name"), rs.getString("director"), rs.getString("lang"),
					rs.getFloat("rating"));
			movies.add(movie);
		});
		return movies;
	}

	@Override
	public String addMovie(Movie movie) throws Exception {
		String sql = "INSERT INTO MOVIES(movie_name,director,lang,rating)" + " VALUES(?,?,?,?)";
		Object[] obj = { movie.getName(), movie.getDirector(), movie.getLang(), movie.getRating() };
		int[] types = { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.FLOAT };
		jdbcTemplate.update(sql, obj, types);

		return "Done";
	}

	@Override
	public Movie updateMovie(String name, Movie movie) throws Exception {
		if (movie.getName().equalsIgnoreCase(name)) {
			String sql = "UPDATE MOVIES SET movie_name=?,director=?,lang=?,rating=? WHERE movie_name = ?";
			Object[] obj = { movie.getName(), movie.getDirector(), movie.getLang(), movie.getRating(), name };
			int[] types = { Types.VARCHAR, Types.VARCHAR, Types.VARCHAR, Types.FLOAT, Types.VARCHAR };
			jdbcTemplate.update(sql, obj, types);
		} else {
			throw new Exception("Can't update name of movie");
		}
		return getMovie(movie.getName());
	}

	@Override
	public Movie deleteMovie(String name) throws Exception {
		Movie movie = getMovie(name);
		String sql = "DELETE FROM MOVIES WHERE movie_name=?";
		Object[] obj = { name };
		int[] types = { Types.VARCHAR };
		jdbcTemplate.update(sql, obj, types);
		return movie;
	}

}
