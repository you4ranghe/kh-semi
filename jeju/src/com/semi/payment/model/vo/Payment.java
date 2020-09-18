package com.semi.payment.model.vo;

import java.sql.Date;

public class Payment {

	private Date pDateStart;
	private int totalPrice;
	private String userId;
	private int pCountA;
	private int pCountC;
	
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}


	public Payment(Date pDateStart, int totalPrice, String userId, int pCountA, int pCountC) {
		super();
		this.pDateStart = pDateStart;
		this.totalPrice = totalPrice;
		this.userId = userId;
		this.pCountA = pCountA;
		this.pCountC = pCountC;
	}


	public Date getpDateStart() {
		return pDateStart;
	}


	public void setpDateStart(Date pDateStart) {
		this.pDateStart = pDateStart;
	}


	public int getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public int getpCountA() {
		return pCountA;
	}


	public void setpCountA(int pCountA) {
		this.pCountA = pCountA;
	}


	public int getpCountC() {
		return pCountC;
	}


	public void setpCountC(int pCountC) {
		this.pCountC = pCountC;
	}


	@Override
	public String toString() {
		return "Payment [pDateStart=" + pDateStart + ", totalPrice=" + totalPrice + ", userId=" + userId + ", pCountA="
				+ pCountA + ", pCountC=" + pCountC + "]";
	}


	
	
	
}
	
	
	