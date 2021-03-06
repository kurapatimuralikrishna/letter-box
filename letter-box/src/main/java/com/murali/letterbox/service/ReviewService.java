package com.murali.letterbox.service;

import java.util.List;

import com.murali.letterbox.model.Review;

public interface ReviewService {

	Review getReview(int uid, String mname) throws Exception;

	List<Review> getMovieReviews(String mname) throws Exception;

	float getAvgListRating(int uid, String lname) throws Exception;

	float getAvgMovieRating(String mname) throws Exception;

	List<Review> getAllReviews();

	Review postReview(int uid, String mname, Review review) throws Exception;

	Review updateReview(int uid, String mname, Review review) throws Exception;

	Review deleteReview(int uid, String mname) throws Exception;
}
