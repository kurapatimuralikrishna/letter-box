package com.murali.letterbox.dao.impl;

import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.murali.letterbox.constants.SqlConstants;
import com.murali.letterbox.dao.ListDao;
import com.murali.letterbox.model.MovieList;

@Component
public class ListDaoImpl implements ListDao{
	
	private final JdbcTemplate jdbcTemplate;
	@Autowired
	public ListDaoImpl (JdbcTemplate jdbcTemplate) {
	    this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public List<MovieList> getAllMovieLists() {
		List<MovieList> list = new ArrayList<>();
		
		ResultSetExtractor <List<MovieList>> rsh = (ResultSet rs) -> {
			List<MovieList> list2 = new ArrayList<>();
			if(rs.next()) {
				List<String> names = new ArrayList<>();
				names.add(rs.getString(6));
				list2.add(new MovieList(rs.getInt(1), rs.getInt(2), rs.getString(3), names));
			}
			while(rs.next()) {
				if(rs.getInt(1) == list2.get(list2.size()-1).getListId()) {
					list2.get(list2.size()-1).addMovie(rs.getString(6));
				}
				else {
					List<String> names = new ArrayList<>();
					names.add(rs.getString(6));
					list2.add(new MovieList(rs.getInt(1), rs.getInt(2), rs.getString(3), names));
				}
			}
			return list2;
		};
		
		list = jdbcTemplate.query(SqlConstants.GET_ALL_LISTS, rsh);
		return list;
	}

	@Override
	public String addMovieList(MovieList list) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieList getMovieList(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieList updateMovie(String name, MovieList list) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public MovieList deleteMovieList(String name) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

}
