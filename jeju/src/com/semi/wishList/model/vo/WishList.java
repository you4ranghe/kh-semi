package com.semi.wishList.model.vo;

public class WishList {

	private String userId;
	private int pNum;
	
	
	public WishList() {
		// TODO Auto-generated constructor stub
	}


	public WishList(String userId, int pNum) {
		super();
		this.userId = userId;
		this.pNum = pNum;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public int getpNum() {
		return pNum;
	}


	public void setpNum(int pNum) {
		this.pNum = pNum;
	}


	@Override
	public String toString() {
		return "WishList [userId=" + userId + ", pNum=" + pNum + "]";
	}

	
	
	
	
	
	
	
	
}
