package com.murali.letterbox.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murali.letterbox.dao.ReviewDao;
import com.murali.letterbox.model.Review;
import com.murali.letterbox.service.ReviewService;

@Service
public class ReviewServiceImpl implements ReviewService {

	@Autowired
	ReviewDao dao;

	@Override
	public Review getReview(int uid, String mname) throws Exception{
		Review view = dao.getReview(uid, mname);
		if (view != null)
			return view;
		throw new Exception("No such review");
	}

	@Override
	public List<Review> getMovieReviews(String mname) throws Exception {
		return dao.getMovieReviews(mname);
	}

	@Override
	public float getAvgListRating(int uid, String lname) throws Exception {
		List<Float> list = dao.getListUserRatings(uid, lname);
		float sum = 0.0f;
		int count = 0;
		for (Float f : list) {
			sum += f;
			count++;
		}
		if (count == 0)
			return -1;
		return sum / count;
	}

	@Override
	public float getAvgMovieRating(String mname) throws Exception {
		List<Float> list = dao.getAvgMovieRating(mname);
		float sum = 0.0f;
		int count = 0;
		for (Float f : list) {
			sum += f;
			count++;
		}
		if (count == 0)
			return -1;
		return sum / count;
	}

	@Override
	public List<Review> getAllReviews() {
		return dao.getAllRveiews();
	}

	@Override
	public Review postReview(int uid, String mname, Review review) throws Exception {
		return dao.postReview(uid,mname,review);
	}

	@Override
	public Review updateReview(int uid, String mname, Review review) throws Exception {
		return dao.updateReview(uid,mname,review);
	}

	@Override
	public Review deleteReview(int uid, String mname) throws Exception {
		return dao.deleteReview(uid,mname);
	}

}
