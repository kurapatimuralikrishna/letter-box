package com.murali.letterbox.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.murali.letterbox.model.ErrorReview;
import com.murali.letterbox.model.Review;
import com.murali.letterbox.service.ReviewService;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("letterbox")
public class ReviewsController {
	@Autowired
	ReviewService service;
	
	@GetMapping("/reviews/{uid}/{mname}")
	public Review getReview(@PathVariable("uid") int uid, @PathVariable("mname") String mname) {
		try {
			Review view = service.getReview(uid,mname);
			if(view!=null) return view;
			throw new Exception("No such review");
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ErrorReview(e);
		}
		
	}
	
	@GetMapping("/reviews/movie/{mname}")
	public List<Review> getMovieReviews(@PathVariable String mname) {
		try {
			return service.getMovieReviews(mname);
		}
		catch (Exception e) {
			e.printStackTrace();
			List<Review> list = new ArrayList<Review>();
			list.add(new ErrorReview(e));
			return list;
		}
	}
	@GetMapping("reviews/list/{uid}/{lname}")
	public float getAvgListRating(@PathVariable("uid") int uid, @PathVariable("lname") String lname) {
		try{
			return service.getAvgListRating(uid,lname);
		}
		catch(Exception e) {
			e.printStackTrace();
			return -1;
		}
	}
	//@GetMapping("/reviews") //all reviews
}
