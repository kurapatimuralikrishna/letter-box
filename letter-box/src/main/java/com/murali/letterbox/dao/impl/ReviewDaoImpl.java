package com.murali.letterbox.dao.impl;

import java.sql.ResultSet;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.murali.letterbox.constants.ReviewConstants;
import com.murali.letterbox.dao.ListDao;
import com.murali.letterbox.dao.MovieDao;
import com.murali.letterbox.dao.ReviewDao;
import com.murali.letterbox.model.Movie;
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
		return jdbcTemplate.query(ReviewConstants.GET_REVIEW, args, types,
				(ResultSet rs) -> {
					if (rs.next())
						return new Review(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4));
					else
						return null;
				});
	}

	@Override
	public List<Review> getMovieReviews(String mname) throws Exception {
		if (movieDao.getMovie(mname) == null)
			throw new Exception("No such movie");
		Object[] args = { mname };
		int[] types = { Types.INTEGER };
		return jdbcTemplate.query(ReviewConstants.GET_MOVIE_REVIEWS, args, types, (ResultSet rs) -> {
			List<Review> list = new ArrayList<>();
			while (rs.next())
				list.add(new Review(rs.getInt(1), rs.getString(2), rs.getFloat(3), rs.getString(4)));
			return list;
		});
	}

	@Override
	public List<Float> getAvgMovieRating(String mname) throws Exception {
		Movie movie = movieDao.getMovie(mname);
		if(movie==null) throw new Exception("No such movie");
		return jdbcTemplate.query(ReviewConstants.GET_MOVIE_RATINGS,(ResultSet rs)->{
			List<Float> list = new ArrayList<>();
			while(rs.next()) list.add(rs.getFloat(1));
			return list;
		});
	}

	@Override
	public List<Float> getListUserRatings(int uid, String lname) throws Exception {
		MovieList list = listDao.getList(uid, lname);
		if (list == null)
			throw new Exception("No such list");
		Object[] args = { list.getListId() };
		int[] types = { Types.INTEGER };
		return jdbcTemplate.query(ReviewConstants.GET_LIST_RATINGS, args, types, (ResultSet rs) -> {
					List<Float> list2 = new ArrayList<>();
					while (rs.next())
						list2.add(rs.getFloat(1));
					return list2;
				});
	}

	@Override
	public List<Review> getAllRveiews() {
		return jdbcTemplate.query(ReviewConstants.GET_ALL_REVIEWS, (ResultSet rs)->{
			List<Review> list = new ArrayList<>();
			while(rs.next()) list.add(new Review(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getString(4)));
			return list;
		});
	}

	@Override
	public Review postReview(int uid, String mname, Review review) throws Exception {
		if(getReview(uid,mname)!=null) throw new Exception("Such a review aldready exists");
		Object[] args = {review.getUserId(),review.getMovieName(),review.getRating(),review.getReview()};
		int[] types = {Types.INTEGER,Types.VARCHAR,Types.FLOAT,Types.VARCHAR};
		jdbcTemplate.update(ReviewConstants.POST_REVIEW,args,types);
		return getReview(uid,mname);
	}

	@Override
	public Review updateReview(int uid, String mname, Review review) throws Exception {
		if(getReview(uid,mname)==null) throw new Exception("No such review");
		Object[] args = {review.getRating(),review.getReview()};
		int[] types = {Types.FLOAT,Types.VARCHAR};
		jdbcTemplate.update(ReviewConstants.UPDATE_REVIEW,args,types);
		return getReview(uid,mname);
	}

	@Override
	public Review deleteReview(int uid, String mname) throws Exception {
		Review review = getReview(uid,mname);
		if(review==null) throw new Exception("No such review");
		Object[] args = {review.getUserId(),review.getMovieName()};
		int[] types = {Types.INTEGER,Types.VARCHAR};
		jdbcTemplate.update(ReviewConstants.DELETE_REVIEW,args,types);
		return review;
	}

}
