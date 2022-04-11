package com.murali.letterbox.dao;

import java.util.List;

import com.murali.letterbox.model.Review;

public interface ReviewDao {

	Review getReview(int uid, String mname);

	List<Review> getMovieReviews(String mname) throws Exception;

	List<List<Float>> getListUserRatings(int uid, String lname) throws Exception;

}
