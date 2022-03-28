package com.murali.letterbox.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLDataException;
import java.sql.Types;
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
	public MovieList getList(int userId, String name) throws Exception {
		MovieList list = null;
		Object args[] = {userId,name};
		int[] types = {Types.INTEGER, Types.VARCHAR};
		list = jdbcTemplate.query((SqlConstants.GET_LIST),args,types,(ResultSet rs) -> {
			MovieList newList = null;
			List<String> names = new ArrayList<>();
			if(rs.next()) {
				names.add(rs.getString(4));
				newList = new MovieList(rs.getInt(1), rs.getInt(2), rs.getString(3), names);
			}
			else return null;
			while(rs.next()) {
				newList.getMovieNames().add(rs.getString(4));
			}
			return newList;
		}
		);
		if(list==null)  throw new SQLDataException("No such Entry Exists");
		return list;
	}
	
	@Override
	public List<MovieList> getAllLists() {
		List<MovieList> list = new ArrayList<>();
		
		ResultSetExtractor <List<MovieList>> rsh = (ResultSet rs) -> {
			List<MovieList> list2 = new ArrayList<>();
			if(rs.next()) {
				List<String> names = new ArrayList<>();
				names.add(rs.getString(6));
				list2.add(new MovieList(rs.getInt(1), rs.getInt(2), rs.getString(3), names));
			}
			else return null;
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
	public String createList(MovieList list) throws Exception {
		Object args[] = {list.getUserId(),list.getListName()};
		int[] types = {Types.INTEGER,Types.VARCHAR};
		jdbcTemplate.update(SqlConstants.CREATE_NEW_LIST, args, types);
		return "Done";
	}
	
	@Override
	public String addMovieToList(int userId, String listName, String name) {
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
