package com.murali.letterbox.model;

public class Review {
	private int userId;
	private String movieName;
	private float rating;
	private String review;
	
	public Review(int userId, String movieName, float rating, String review) {
		super();
		this.userId = userId;
		this.movieName = movieName;
		this.rating = rating;
		this.review = review;
	}
	
	public int getUserId() {
		return userId;
	}
	public String getMovieName() {
		return movieName;
	}
	public float getRating() {
		return rating;
	}
	public String getReview() {
		return review;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
	public void setReview(String review) {
		this.review = review;
	}
}
