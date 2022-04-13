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

import com.murali.letterbox.constants.ListConstants;
import com.murali.letterbox.dao.ListDao;
import com.murali.letterbox.dao.MovieDao;
import com.murali.letterbox.model.MovieList;

@Component
public class ListDaoImpl implements ListDao {

	@Autowired
	MovieDao movieDao;
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public ListDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public MovieList getList(int userId, String lname) throws Exception {
		MovieList list = null;
		Object args[] = { userId, lname };
		int[] types = { Types.INTEGER, Types.VARCHAR };
		list = jdbcTemplate.query((ListConstants.GET_LIST), args, types, (ResultSet rs) -> {
			MovieList newList = null;
			List<String> names = new ArrayList<>();
			if (rs.next()) {
				if(rs.getString(6)!=null) names.add(rs.getString(6));
				newList = new MovieList(rs.getInt(1), rs.getInt(2), rs.getString(3), names);
			} else
				return null;
			while (rs.next()) {
				newList.addMovie(rs.getString(6));
			}
			return newList;
		});
		return list;
	}

	@Override
	public List<MovieList> getAllLists() {
		List<MovieList> list = new ArrayList<>();

		ResultSetExtractor<List<MovieList>> rsh = (ResultSet rs) -> {
			List<MovieList> list2 = new ArrayList<>();
			if (rs.next()) {
				List<String> names = new ArrayList<>();
				if(rs.getString(6)!=null) names.add(rs.getString(6));
				list2.add(new MovieList(rs.getInt(1), rs.getInt(2), rs.getString(3), names));
			} else
				return null;
			while (rs.next()) {
				if (rs.getInt(1) == list2.get(list2.size() - 1).getListId()) {
					if(rs.getString(6)!=null) list2.get(list2.size() - 1).addMovie(rs.getString(6));
				} else {
					List<String> names = new ArrayList<>();
					if(rs.getString(6)!=null) names.add(rs.getString(6));
					list2.add(new MovieList(rs.getInt(1), rs.getInt(2), rs.getString(3), names));
				}
			}
			return list2;
		};

		list = jdbcTemplate.query(ListConstants.GET_ALL_LISTS, rsh);
		return list;
	}

	@Override
	public String createList(MovieList list) throws Exception {
		MovieList list2 = getList(list.getUserId(), list.getListName());
		if (list2 != null)
			throw new SQLDataException("Such a list aldready exists");
		Object args[] = { list.getUserId(), list.getListName() };
		int[] types = { Types.INTEGER, Types.VARCHAR };
		jdbcTemplate.update(ListConstants.CREATE_NEW_LIST, args, types);
		List<String> names = list.getMovieNames();
		for (String k : names) {
			addMovieToList(list.getUserId(), list.getListName(), k);
		}
		return "Done";
	}

	@Override
	public String addMovieToList(int userId, String listName, String name) throws Exception {
		Object args[] = { userId, listName };
		int[] types = { Types.INTEGER, Types.VARCHAR };
		int lid = jdbcTemplate.query(ListConstants.GET_LIST_ID, args, types, (ResultSet rs) -> {
			if (rs.next())
				return rs.getInt(1);
			else
				return 0;
		});
		if (lid == 0)
			throw new Exception("No such list");
		if(movieDao.getMovie(name)==null) throw new Exception("No such movie");
		String str = "SELECT movie_name\r\n" + "FROM movies_inlist\r\n" + "WHERE list_id=? AND movie_name=?;";
		Object[] args5 ={lid,name};
		int[] types5 = { Types.INTEGER, Types.VARCHAR };
		if (jdbcTemplate.query(str,args5,types5, (ResultSet rs) -> {
			if (rs.next())
				return true;
			else
				return false;
		})) {
			throw new Exception("List aldready contains this movie");
		}
		Object args2[] = { lid, name };
		jdbcTemplate.update(ListConstants.ADD_MOVIE_TOLIST, args2, types);
		return name;
	}

	@Override
	public MovieList deleteMovieList(int uid, String lname) throws Exception {
		Object args[] = { uid, lname };
		int[] types = { Types.INTEGER, Types.VARCHAR };
		int lid = jdbcTemplate.query(ListConstants.GET_LIST_ID, args, types, (ResultSet rs) -> {
			if (rs.next())
				return rs.getInt(1);
			else
				return 0;
		});
		if (lid == 0)
			throw new Exception("No such list");
		MovieList list = getList(uid, lname);
		Object[] args2 = { lid };
		int[] types2 = { Types.INTEGER };
		jdbcTemplate.update(ListConstants.DELETE_MOVIES_OFLIST, args2, types2);
		Object[] args3 = { lid };
		int[] types3 = { Types.INTEGER };
		jdbcTemplate.update(ListConstants.DELETE_MOVIE_LIST, args3, types3);
		return list;
	}

	@Override
	public MovieList updateMovie(int uid, String lname, MovieList list) throws Exception {
		// TODO check sign-in
		List<String> names = list.getMovieNames();
		Object args[] = { uid, lname };
		int[] types = { Types.INTEGER, Types.VARCHAR };
		int lid = jdbcTemplate.query(ListConstants.GET_LIST_ID, args, types, (ResultSet rs) -> {
			if (rs.next())
				return rs.getInt(1);
			else
				return 0;
		});
		if (lid == 0)
			throw new Exception("No such list");
		Object args2[] = { list.getListName(), uid, lname };
		int[] types2 = { Types.VARCHAR, Types.INTEGER, Types.VARCHAR };
		jdbcTemplate.update(ListConstants.UPDATE_LIST_NAME, args2, types2);
		Object[] args3 = { lid };
		int[] types3 = { Types.INTEGER };
		for(String k:names) {
			if(movieDao.getMovie(k)==null) throw new Exception("List contains invalid movies)");
		}
		jdbcTemplate.update(ListConstants.DELETE_MOVIES_OFLIST, args3, types3);
		for (String k : names) {
			Object[] args4 = { lid, k };
			int[] types4 = { Types.INTEGER, Types.VARCHAR };
			jdbcTemplate.update(ListConstants.ADD_MOVIE_TOLIST, args4, types4);
		}
		return getList(list.getUserId(), list.getListName());

	}

	@Override
	public String removeMovieFromList(int uid, String lname, String movieName) throws Exception {
		Object args[] = { uid, lname };
		int[] types = { Types.INTEGER, Types.VARCHAR };
		int lid = jdbcTemplate.query(ListConstants.GET_LIST_ID, args, types, (ResultSet rs) -> {
			if (rs.next())
				return rs.getInt(1);
			else
				return 0;
		});
		if (lid == 0)
			throw new Exception("No such list");
		Object args2[] = { lid, movieName };
		int[] types2 = { Types.INTEGER, Types.VARCHAR };
		int num = jdbcTemplate.update(ListConstants.DELETE_MOVIE_FROMLIST, args2, types2);
		if (num == 0)
			throw new Exception("No such movie");
		return movieName;
	}

}
