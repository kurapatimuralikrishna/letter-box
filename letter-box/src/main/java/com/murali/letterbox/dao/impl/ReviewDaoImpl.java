package com.murali.letterbox.dao.impl;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Component;

import com.murali.letterbox.dao.ListDao;
import com.murali.letterbox.dao.MovieDao;
import com.murali.letterbox.dao.ReviewDao;
import com.murali.letterbox.model.MovieList;
import com.murali.letterbox.model.Review;

@Component
public class ReviewDaoImpl implements ReviewDao {

	@Autowired
	MovieDao movieDao;
	@Autowired
	ListDao listDao;
	private final JdbcTemplate jdbcTemplate;

	@Autowired
	public ReviewDaoImpl(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	@Override
	public Review getReview(int uid, String mname) {
		Object[] args = { uid, mname };
		int[] types = { Types.INTEGER, Types.INTEGER };
		return jdbcTemplate.query("SELECT * FROM movie_reviews WHERE user_id=? AND movie_name = ?;", args, types,
				(ResultSet rs) -> {
					if (rs.next())
						return new Review(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4));
					else
						return null;
				});
	}

	@Override
	public List<Review> getMovieReviews(String mname) throws Exception {
		if(movieDao.getMovie(mname)==null) throw new Exception("No such movie"); 
		Object[] args = { mname };
		int[] types = { Types.INTEGER };
		return jdbcTemplate.query("SELECT * FROM movie_reviews WHERE movie_name = ?;", args, types,
				(ResultSet rs) -> {
					List<Review> list = new ArrayList<>();
					while (rs.next())
						list.add(new Review(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4)));
					return list;
				});
	}

	@Override
	public List<List<Float>> getListUserRatings(int uid, String lname) throws Exception {
		if(listDao.getList(uid, lname)==null) throw new Exception("No such list");
		
		ResultSetExtractor<List<MovieList>> rsh = (ResultSet rs) -> {
			List<List<Float>> list2 = new ArrayList<>();
			if (rs.next()) {
				List<Float> ratings = new ArrayList<>();
				if(rs.getString(6)!=null) ratings.add(movieDao.getMovie(rs.getString(6));
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
		return null;
	}

}
