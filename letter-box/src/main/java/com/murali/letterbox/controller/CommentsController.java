package com.murali.letterbox.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping(value = "/comments/{cid}")
	public Comment getComment(@PathVariable int cid) {
		try {
			return service.getComment(cid);
		} catch (Exception e) {
			e.printStackTrace();
			return new ErrorComment(e);
		}
	}

	@GetMapping(value = "/comments/{cid}/replies")
	public List<Comment> getReplies(@PathVariable int cid) {
		try {
			return service.getReplies(cid);
		} catch (Exception e) {
			e.printStackTrace();
			List<Comment> errors = new ArrayList<>();
			errors.add(new ErrorComment(e));
			return errors;
		}
	}

	@GetMapping(value = "/lists/{uid}/{lname}/comments")
	public List<Comment> getListComments(@PathVariable("uid") int uid, @PathVariable("lname") String lname) {
		try {
			return service.getListComments(uid, lname);
		} catch (Exception e) {
			e.printStackTrace();
			List<Comment> errors = new ArrayList<>();
			errors.add(new ErrorComment(e));
			return errors;
		}
	}

	@GetMapping(value = "users/{uid}/comments")
	public List<Comment> getUserComments(@PathVariable int uid) {
		try {
			return service.getUserComments(uid);
		} catch (Exception e) {
			e.printStackTrace();
			List<Comment> errors = new ArrayList<>();
			errors.add(new ErrorComment(e));
			return errors;
		}
	}

	@GetMapping(value = "comments")
	public List<Comment> getAllComments() {
		return service.getAllComments();
	}

	@PostMapping(value = "lists/{listUid}/{lname}/addcomment")
	public Comment addRootComment(@PathVariable("listUid") int listUid, @PathVariable("lname") String lname,
			@RequestBody Comment comment) {
		try {
			return service.addRootComment(listUid, lname, comment);
		} catch (Exception e) {
			e.printStackTrace();
			return new ErrorComment(e);
		}
	}

	@PostMapping(value = "lists/{listUid}/{lname}/addcomment/{cid}")
	public Comment addReply(@PathVariable("listUid") int listUid, @PathVariable("lname") String lname,
			@PathVariable("cid") int cid, @RequestBody Comment comment) {
		try {
			return service.addReply(listUid, lname, cid, comment);
		} catch (Exception e) {
			e.printStackTrace();
			return new ErrorComment(e);
		}
	}

	@PutMapping(value = "lists/{uid}/{lname}/{cid}/update")
	public Comment editComment(@PathVariable("listUid") int listUid, @PathVariable("lname") String lname,
			@PathVariable("cid") int cid, @RequestBody Comment comment) {
		try {
			return service.editComment(listUid, lname, cid, comment);
		} catch (Exception e) {
			e.printStackTrace();
			return new ErrorComment(e);
		}
	}

	@DeleteMapping(value = "lists/{uid}/{lname}/{cid}/delete")
	public Comment deleteComment(@PathVariable("listUid") int listUid, @PathVariable("lname") String lname,
			@PathVariable("cid") int cid) {
		try {
			return service.deleteComment(listUid, lname, cid);
		} catch (Exception e) {
			e.printStackTrace();
			return new ErrorComment(e);
		}
	}
}
