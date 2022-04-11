package com.murali.letterbox.model;

public class Comment {
	private int commentId;
	private int userId;
	private String listName;
	private int rootCommentId;
	private String description;
	public Comment(int commentId, int userId, String listName, int rootCommentId, String description) {
		super();
		this.commentId = commentId;
		this.userId = userId;
		this.listName = listName;
		this.rootCommentId = rootCommentId;
		this.description = description;
	}
	public int getUserId() {
		return userId;
	}
	public String getListName() {
		return listName;
	}
	public String getDescription() {
		return description;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setListName(String listName) {
		this.listName = listName;
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
