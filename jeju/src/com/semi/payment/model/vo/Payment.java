package com.semi.payment.model.vo;

import java.sql.Date;
import java.util.Arrays;

public class Payment {

	private String poNum;
	private int pNum;
	private String poType;
	private String poDate;
	private String pCountA;
	private String pCountC;
	private String pDateStart;
	private String pDateFinish;
	private String pTime;
	private String totalPrice;
	
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}


	public Payment(String poNum, int pNum, String poType, String poDate, String pCountA, String pCountC,
			String pDateStart, String pDateFinish, String pTime, String totalPrice) {
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


	public String getpCountA() {
		return pCountA;
	}


	public void setpCountA(String pCountA) {
		this.pCountA = pCountA;
	}


	public String getpCountC() {
		return pCountC;
	}


	public void setpCountC(String pCountC) {
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


	public String getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(String totalPrice) {
		this.totalPrice = totalPrice;
	}


	@Override
	public String toString() {
		return "Payment [poNum=" + poNum + ", pNum=" + pNum + ", poType=" + poType + ", poDate=" + poDate + ", pCountA="
				+ pCountA + ", pCountC=" + pCountC + ", pDateStart=" + pDateStart + ", pDateFinish=" + pDateFinish
				+ ", pTime=" + pTime + ", totalPrice=" + totalPrice + "]";
	}



	
	
	
	
	
}
