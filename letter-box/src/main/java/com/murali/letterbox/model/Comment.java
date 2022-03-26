package com.murali.letterbox.model;

public class Comment {
	private int userId;
	private String listId;
	private Comment rootComment;
	private String description;
	public Comment(int userId, String listName, Comment rootComment, String description) {
		super();
		this.userId = userId;
		this.listId = listName;
		this.rootComment = rootComment;
		this.description = description;
	}
	public int getUserId() {
		return userId;
	}
	public String getListName() {
		return listId;
	}
	public Comment getRootComment() {
		return rootComment;
	}
	public String getDescription() {
		return description;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public void setListName(String listName) {
		this.listId = listName;
	}
	public void setRootComment(Comment rootComment) {
		this.rootComment = rootComment;
	}
	public void setDescription(String description) {
		this.description = description;
	}
}
