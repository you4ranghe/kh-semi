package com.semi.wishList.model.vo;

public class WishList {

	private String userId;

	private int productNum;
	private String pageAddress;

	public WishList() {
		// TODO Auto-generated constructor stub
	}


	public WishList(String userId, int productNum, String pageAddress) {
		super();
		this.userId = userId;
		this.productNum = productNum;
		this.pageAddress = pageAddress;
	}


	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}


	public int getProductNum() {
		return productNum;
	}

	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}

	public String getPageAddress() {
		return pageAddress;
	}

	public void setPageAddress(String pageAddress) {
		this.pageAddress = pageAddress;
	}

	@Override
	public String toString() {
		return "WishListEnroll [userId=" + userId + ", productNum=" + productNum + ", pageAddress=" + pageAddress + "]";
	}




}
