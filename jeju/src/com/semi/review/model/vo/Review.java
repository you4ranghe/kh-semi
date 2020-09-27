package com.semi.review.model.vo;

import java.util.Date;

public class Review {

	private int reviewNum;
	private int reviewScore;
	private String reviewTitle;
	private String reviewContents;
	private String reviewWriter;
	private String poNum;
	private Date registerDate;
	private int reviewViews;
	private int pNum;
	private String userId;
	
	
	public Review() {
		// TODO Auto-generated constructor stub
	}


	public Review(int reviewNum, int reviewScore, String reviewTitle, String reviewContents, String reviewWriter,
			String poNum, Date registerDate, int reviewViews, int pNum, String userId) {
		super();
		this.reviewNum = reviewNum;
		this.reviewScore = reviewScore;
		this.reviewTitle = reviewTitle;
		this.reviewContents = reviewContents;
		this.reviewWriter = reviewWriter;
		this.poNum = poNum;
		this.registerDate = registerDate;
		this.reviewViews = reviewViews;
		this.pNum = pNum;
		this.userId = userId;
	}


	public int getReviewNum() {
		return reviewNum;
	}


	public void setReviewNum(int reviewNum) {
		this.reviewNum = reviewNum;
	}


	public int getReviewScore() {
		return reviewScore;
	}


	public void setReviewScore(int reviewScore) {
		this.reviewScore = reviewScore;
	}


	public String getReviewTitle() {
		return reviewTitle;
	}


	public void setReviewTitle(String reviewTitle) {
		this.reviewTitle = reviewTitle;
	}


	public String getReviewContents() {
		return reviewContents;
	}


	public void setReviewContents(String reviewContents) {
		this.reviewContents = reviewContents;
	}


	public String getReviewWriter() {
		return reviewWriter;
	}


	public void setReviewWriter(String reviewWriter) {
		this.reviewWriter = reviewWriter;
	}


	public String getPoNum() {
		return poNum;
	}


	public void setPoNum(String poNum) {
		this.poNum = poNum;
	}


	public Date getRegisterDate() {
		return registerDate;
	}


	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}


	public int getReviewViews() {
		return reviewViews;
	}


	public void setReviewViews(int reviewViews) {
		this.reviewViews = reviewViews;
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
		return "Review [reviewNum=" + reviewNum + ", reviewScore=" + reviewScore + ", reviewTitle=" + reviewTitle
				+ ", reviewContents=" + reviewContents + ", reviewWriter=" + reviewWriter + ", poNum=" + poNum
				+ ", registerDate=" + registerDate + ", reviewViews=" + reviewViews + ", pNum=" + pNum + ", userId="
				+ userId + "]";
	}



	
	
	
	
	
	
}
