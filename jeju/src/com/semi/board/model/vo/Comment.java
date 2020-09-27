package com.semi.board.model.vo;

public class Comment {
	
	private String userId;
	private int boardNo;
	private String commentContent;
	private int commentPosition;
	private int replyPosition;
	
	public Comment() {
		// TODO Auto-generated constructor stub
	}

	public Comment(String userId, int boardNo, String commentContent, int commentPosition, int replyPosition) {
		super();
		this.userId = userId;
		this.boardNo = boardNo;
		this.commentContent = commentContent;
		this.commentPosition = commentPosition;
		this.replyPosition = replyPosition;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getCommentContent() {
		return commentContent;
	}

	public void setCommentContent(String commentContent) {
		this.commentContent = commentContent;
	}

	public int getCommentPosition() {
		return commentPosition;
	}

	public void setCommentPosition(int commentPosition) {
		this.commentPosition = commentPosition;
	}

	public int getReplyPosition() {
		return replyPosition;
	}

	public void setReplyPosition(int replyPosition) {
		this.replyPosition = replyPosition;
	}

	@Override
	public String toString() {
		return "Comment [userId=" + userId + ", boardNo=" + boardNo + ", commentContent=" + commentContent
				+ ", commentPosition=" + commentPosition + ", replyPosition=" + replyPosition + "]";
	}

	
}