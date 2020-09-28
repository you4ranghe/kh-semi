package com.semi.review.model.vo;

public class ReviewConfirm {

	private int pNum;
	private String userId;
	
	public ReviewConfirm() {
		// TODO Auto-generated constructor stub
	}

	public ReviewConfirm(int pNum, String userId) {
		super();
		this.pNum = pNum;
		this.userId = userId;
	}

	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	@Override
	public String toString() {
		return "ReviewConfirm [pNum=" + pNum + ", userId=" + userId + "]";
	}
	
	
	
	
	
}
