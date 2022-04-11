package com.murali.letterbox.service;

import java.util.List;

import com.murali.letterbox.model.Review;

public interface ReviewService {

	Review getReview(int uid, String mname);

	List<Review> getMovieReviews(String mname) throws Exception;

	float getAvgListRating(int uid, String lname) throws Exception;
}
