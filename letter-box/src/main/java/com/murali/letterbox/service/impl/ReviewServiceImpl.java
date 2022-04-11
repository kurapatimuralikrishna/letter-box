package com.murali.letterbox.service.impl;

import java.util.ArrayList;
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
	public Review getReview(int uid, String mname) {
		return dao.getReview(uid,mname);
	}

	@Override
	public List<Review> getMovieReviews(String mname) throws Exception {
		return dao.getMovieReviews(mname);
	}

	@Override
	public float getAvgListRating(int uid, String lname) throws Exception {
		List<List<Float>> list = dao.getListUserRatings(uid,lname);
		float sum;
		int count;
		for(List<Float> l:list) {
			for(Float f : l) {
				sum+=f;
				count++;
			}
		}
		return sum/count;
	}
	
}
