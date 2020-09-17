package com.semi.payment.model.vo;

import java.sql.Date;
import java.util.Arrays;

public class Payment {

	private String poNum;
	private int pNum;
	private Date poType;
	private Date poDate;
	private int pCountA;
	private int pCountC;
	private String pDateStart;
	private String pTime;
	private int totalPrice;
	private String userId;
	
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}


	public Payment(String poNum, int pNum, Date poType, Date poDate, int pCountA, int pCountC, String pDateStart,
			String pTime, int totalPrice, String userId) {
		super();
		this.poNum = poNum;
		this.pNum = pNum;
		this.poType = poType;
		this.poDate = poDate;
		this.pCountA = pCountA;
		this.pCountC = pCountC;
		this.pDateStart = pDateStart;
		this.pTime = pTime;
		this.totalPrice = totalPrice;
		this.userId = userId;
	}


	public String getPoNum() {
		return poNum;
	}


	public void setPoNum(String poNum) {
		this.poNum = poNum;
	}


	public int getpNum() {
		return pNum;
	}


	public void setpNum(int pNum) {
		this.pNum = pNum;
	}


	public Date getPoType() {
		return poType;
	}


	public void setPoType(Date poType) {
		this.poType = poType;
	}


	public Date getPoDate() {
		return poDate;
	}


	public void setPoDate(Date poDate) {
		this.poDate = poDate;
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


	public String getpDateStart() {
		return pDateStart;
	}


	public void setpDateStart(String pDateStart) {
		this.pDateStart = pDateStart;
	}


	public String getpTime() {
		return pTime;
	}


	public void setpTime(String pTime) {
		this.pTime = pTime;
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


	@Override
	public String toString() {
		return "Payment [poNum=" + poNum + ", pNum=" + pNum + ", poType=" + poType + ", poDate=" + poDate + ", pCountA="
				+ pCountA + ", pCountC=" + pCountC + ", pDateStart=" + pDateStart + ", pTime=" + pTime + ", totalPrice="
				+ totalPrice + ", userId=" + userId + "]";
	}


	
	
	
	
	
	
	
}
