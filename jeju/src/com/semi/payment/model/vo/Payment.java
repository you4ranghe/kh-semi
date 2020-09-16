package com.semi.payment.model.vo;

import java.sql.Date;

public class Payment {

	private String poNum;
	private int pNum;
	private String poType;
	private String poDate;
	private int pCountA;
	private int pCountC;
	private String pDateStart;
	private String pDateFinish;
	private String pTime;
	private int totalPrice;
	
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}


	public Payment(String poNum, int pNum, String poType, String poDate, int pCountA, int pCountC, String pDateStart,
			String pDateFinish, String pTime, int totalPrice) {
		super();
		this.poNum = poNum;
		this.pNum = pNum;
		this.poType = poType;
		this.poDate = poDate;
		this.pCountA = pCountA;
		this.pCountC = pCountC;
		this.pDateStart = pDateStart;
		this.pDateFinish = pDateFinish;
		this.pTime = pTime;
		this.totalPrice = totalPrice;
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


	public String getPoType() {
		return poType;
	}


	public void setPoType(String poType) {
		this.poType = poType;
	}


	public String getPoDate() {
		return poDate;
	}


	public void setPoDate(String poDate) {
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


	public String getpDateFinish() {
		return pDateFinish;
	}


	public void setpDateFinish(String pDateFinish) {
		this.pDateFinish = pDateFinish;
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


	@Override
	public String toString() {
		return "Payment [poNum=" + poNum + ", pNum=" + pNum + ", poType=" + poType + ", poDate=" + poDate + ", pCountA="
				+ pCountA + ", pCountC=" + pCountC + ", pDateStart=" + pDateStart + ", pDateFinish=" + pDateFinish
				+ ", pTime=" + pTime + ", totalPrice=" + totalPrice + "]";
	}


	

	
	
	
	
	
}
