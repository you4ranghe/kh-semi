package com.semi.payment.model.vo;

import java.sql.Date;

public class Payment {

	private String poNum;
	private String poType;
	private String poDate;
	private Date pDateStart;
	private int totalPrice;
	private int pNum;
	private String userId;
	private int pCountA;
	private int pCountC;
	private String payUserNam;
	private String payAddress;
	private String payPhone;
	private String payEmail;
	
	
	
	public Payment() {
		// TODO Auto-generated constructor stub
	}



	public Payment(String poNum, String poType, String poDate, Date pDateStart, int totalPrice, int pNum, String userId,
			int pCountA, int pCountC, String payUserNam, String payAddress, String payPhone, String payEmail) {
		super();
		this.poNum = poNum;
		this.poType = poType;
		this.poDate = poDate;
		this.pDateStart = pDateStart;
		this.totalPrice = totalPrice;
		this.pNum = pNum;
		this.userId = userId;
		this.pCountA = pCountA;
		this.pCountC = pCountC;
		this.payUserNam = payUserNam;
		this.payAddress = payAddress;
		this.payPhone = payPhone;
		this.payEmail = payEmail;
	}



	public String getPoNum() {
		return poNum;
	}



	public void setPoNum(String poNum) {
		this.poNum = poNum;
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



	public String getPayUserNam() {
		return payUserNam;
	}



	public void setPayUserNam(String payUserNam) {
		this.payUserNam = payUserNam;
	}



	public String getPayAddress() {
		return payAddress;
	}



	public void setPayAddress(String payAddress) {
		this.payAddress = payAddress;
	}



	public String getPayPhone() {
		return payPhone;
	}



	public void setPayPhone(String payPhone) {
		this.payPhone = payPhone;
	}



	public String getPayEmail() {
		return payEmail;
	}



	public void setPayEmail(String payEmail) {
		this.payEmail = payEmail;
	}



	@Override
	public String toString() {
		return "Payment [poNum=" + poNum + ", poType=" + poType + ", poDate=" + poDate + ", pDateStart=" + pDateStart
				+ ", totalPrice=" + totalPrice + ", pNum=" + pNum + ", userId=" + userId + ", pCountA=" + pCountA
				+ ", pCountC=" + pCountC + ", payUserNam=" + payUserNam + ", payAddress=" + payAddress + ", payPhone="
				+ payPhone + ", payEmail=" + payEmail + "]";
	}


	
	
	
	
	
	
	
	
	
	
	
	


	
	
}
	
	
	