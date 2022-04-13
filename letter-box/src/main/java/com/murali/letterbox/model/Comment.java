package com.murali.letterbox.model;

public class Comment {
	private int commentId;
	private int userId;
	private int listId;
	private int rootCommentId;
	private String description;
	public Comment(int commentId, int userId, int listId, int rootCommentId, String description) {
		super();
		this.commentId = commentId;
		this.userId = userId;
		this.listId = listId;
		this.rootCommentId = rootCommentId;
		this.description = description;
	}
	public int getUserId() {
		return userId;
	}
	public int getListId() {
		return listId;
	}
	public String getDescription() {
		return description;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setListName(int listId) {
		this.listId = listId;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getCommentId() {
		return commentId;
	}
	public void setCommentId(int commentId) {
		this.commentId = commentId;
	}
	public int getRootCommentId() {
		return rootCommentId;
	}
	public void setRootCommentId(int rootCommentId) {
		this.rootCommentId = rootCommentId;
	}
}
