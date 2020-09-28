package com.semi.goWithBoard.model.vo;

import java.util.Date;

public class GComment {
	
	private int gowithNo;
	private String userId;
	private String gComment;
	private int commentPosition;
	private int replyPosition;
	private Date writeDate;
	
	public GComment() {
		// TODO Auto-generated constructor stub
	}

	public GComment(int gowithNo, String userId, String gComment, int commentPosition, int replyPosition,
			Date writeDate) {
		super();
		this.gowithNo = gowithNo;
		this.userId = userId;
		this.gComment = gComment;
		this.commentPosition = commentPosition;
		this.replyPosition = replyPosition;
		this.writeDate = writeDate;
	}

	public int getGowithNo() {
		return gowithNo;
	}

	public void setGowithNo(int gowithNo) {
		this.gowithNo = gowithNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getgComment() {
		return gComment;
	}

	public void setgComment(String gComment) {
		this.gComment = gComment;
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

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	@Override
	public String toString() {
		return "GComment [gowithNo=" + gowithNo + ", userId=" + userId + ", gComment=" + gComment + ", commentPosition="
				+ commentPosition + ", replyPosition=" + replyPosition + ", writeDate=" + writeDate + "]";
	}
	
	
}
