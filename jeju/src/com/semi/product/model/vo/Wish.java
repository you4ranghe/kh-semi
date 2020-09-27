package com.semi.product.model.vo;

public class Wish {
	private String userId;
	private int pNum;
	
	public Wish() {
		// TODO Auto-generated constructor stub
	}

	
	public Wish(String userId, int pNum) {
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
		return "Wish [userId=" + userId + ", pNum=" + pNum + "]";
	}
	
	
	
}