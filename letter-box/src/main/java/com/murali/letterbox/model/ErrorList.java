package com.murali.letterbox.model;

import java.util.ArrayList;
import java.util.List;

public class ErrorList extends MovieList {

	public ErrorList(Exception e) {
		super(0, 0, "", null);
		List<String> names = new ArrayList<>();
		names.add(e.getMessage());
		this.setListName(e.getClass().toString());
		this.setMovieNames(names);
		
	}

}
