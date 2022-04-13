package com.murali.letterbox.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.murali.letterbox.model.Comment;
import com.murali.letterbox.model.ErrorComment;
import com.murali.letterbox.service.CommentService;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("letterbox")
public class CommentsController {
	
	@Autowired
	CommentService service;
	
	@GetMapping(value="/comments/{cid}")
	public Comment getComment(@PathVariable int cid) {
		try {
			Comment comment = service.getComment(cid);
			if(comment==null) throw new Exception("No such comment exists");
			return comment;
		}
		catch(Exception e) {
			e.printStackTrace();
			return new ErrorComment(e);
		}
	}
	
	@GetMapping(value="/comments/{cid}/replies")
	public List<Comment> getReplies(@PathVariable int cid){
		try {
			return service.getReplies(cid);
		}
		catch(Exception e) {
			e.printStackTrace();
			List<Comment> list = new ArrayList<>();
			list.add(new ErrorComment(e));
			return list;
		}
	}
	//@GetMapping(value="/lists/{uid}/{lname}/comments")
	//public Commnet getListComments()
}
