package com.murali.letterbox.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.murali.letterbox.dao.ListDao;
import com.murali.letterbox.model.MovieList;
import com.murali.letterbox.service.ListService;

@Service
public class ListServiceImpl implements ListService {

	@Autowired
	ListDao dao;

	@Override
	public List<MovieList> getAllLists() {
		return dao.getAllLists();
	}

	@Override
	public String createList(MovieList list) throws Exception {
		return dao.createList(list);
	}

	@Override
	public MovieList getList(int userId, String name) throws Exception {
		return dao.getList(userId, name);
	}

	@Override
	public MovieList deleteList(int uid,String lname) throws Exception {
		return dao.deleteMovieList(uid,lname);
	}

	@Override
	public String addMovieToList(int userId, String listName, String name) throws Exception{
		return dao.addMovieToList(userId, listName, name);
	}

	@Override
	public MovieList updateList(int uid, String lname, MovieList list) throws Exception {
		return dao.updateMovie(uid, lname, list);
	}

	@Override
	public String removeMovieFromList(int uid, String lname, String movieName) throws Exception {
		return dao.removeMovieFromList(uid,lname,movieName);
	}
}
