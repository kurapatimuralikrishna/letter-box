package com.murali.letterbox.service;

import java.util.List;

import com.murali.letterbox.model.Comment;

public interface CommentService {

	Comment getComment(int cid);

	List<Comment> getReplies(int cid) throws Exception;

}
