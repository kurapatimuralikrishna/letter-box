package com.murali.letterbox.model;

public class Movie {
	String name;
	String director;
	String lang;
	float rating;
	
	
	public Movie(String name, String director, String lang, float rating) {
		super();
		this.name = name;
		this.director = director;
		this.lang = lang;
		this.rating = rating;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDirector() {
		return director;
	}
	public void setDirector(String director) {
		this.director = director;
	}
	public String getLang() {
		return lang;
	}
	public void setLang(String lang) {
		this.lang = lang;
	}
	public float getRating() {
		return rating;
	}
	public void setRating(float rating) {
		this.rating = rating;
	}
}
