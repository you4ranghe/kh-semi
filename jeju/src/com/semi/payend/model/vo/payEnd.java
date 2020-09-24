package com.semi.payend.model.vo;

import java.sql.Date;

public class payEnd {
	private int payNum;
	private String payType;
	private Date payDate;
	private int totalPrice;
	private int productNum;
	private String userId;
	private int childNum;
	private int adultNum;
	private String dateStart;
	private String payName;
	private String payAddress;
	private String payPhone;
	private String payEmail;
	
	
	public payEnd() {
		// TODO Auto-generated constructor stub
	}


	public payEnd(int payNum, String payType, Date payDate, int totalPrice, int productNum, String userId, int childNum,
			int adultNum, String dateStart, String payName, String payAddress, String payPhone, String payEmail) {
		super();
		this.payNum = payNum;
		this.payType = payType;
		this.payDate = payDate;
		this.totalPrice = totalPrice;
		this.productNum = productNum;
		this.userId = userId;
		this.childNum = childNum;
		this.adultNum = adultNum;
		this.dateStart = dateStart;
		this.payName = payName;
		this.payAddress = payAddress;
		this.payPhone = payPhone;
		this.payEmail = payEmail;
	}


	public int getPayNum() {
		return payNum;
	}


	public void setPayNum(int payNum) {
		this.payNum = payNum;
	}


	public String getPayType() {
		return payType;
	}


	public void setPayType(String payType) {
		this.payType = payType;
	}


	public Date getPayDate() {
		return payDate;
	}


	public void setPayDate(Date payDate) {
		this.payDate = payDate;
	}


	public int getTotalPrice() {
		return totalPrice;
	}


	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}


	public int getProductNum() {
		return productNum;
	}


	public void setProductNum(int productNum) {
		this.productNum = productNum;
	}


	public String getUserId() {
		return userId;
	}


	public void setUserId(String userId) {
		this.userId = userId;
	}


	public int getChildNum() {
		return childNum;
	}


	public void setChildNum(int childNum) {
		this.childNum = childNum;
	}


	public int getAdultNum() {
		return adultNum;
	}


	public void setAdultNum(int adultNum) {
		this.adultNum = adultNum;
	}


	public String getDateStart() {
		return dateStart;
	}


	public void setDateStart(String dateStart) {
		this.dateStart = dateStart;
	}


	public String getPayName() {
		return payName;
	}


	public void setPayName(String payName) {
		this.payName = payName;
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
		return "payEnd [payNum=" + payNum + ", payType=" + payType + ", payDate=" + payDate + ", totalPrice="
				+ totalPrice + ", productNum=" + productNum + ", userId=" + userId + ", childNum=" + childNum
				+ ", adultNum=" + adultNum + ", dateStart=" + dateStart + ", payName=" + payName + ", payAddress="
				+ payAddress + ", payPhone=" + payPhone + ", payEmail=" + payEmail + "]";
	}
	
	
	

}
