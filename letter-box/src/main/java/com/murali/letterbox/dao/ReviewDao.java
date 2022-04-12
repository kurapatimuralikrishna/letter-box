package com.murali.letterbox.dao;

import java.util.List;

import com.murali.letterbox.model.Review;

public interface ReviewDao {

	Review getReview(int uid, String mname);

	List<Review> getMovieReviews(String mname) throws Exception;

	List<Float> getListUserRatings(int uid, String lname) throws Exception;

	List<Float> getAvgMovieRating(String mname) throws Exception;

	List<Review> getAllRveiews();

	Review postReview(int uid, String mname, Review review) throws Exception;

	Review updateReview(int uid, String mname, Review review) throws Exception;

	Review deleteReview(int uid, String mname) throws Exception;

}
