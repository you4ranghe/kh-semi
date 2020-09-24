package com.semi.review.model.vo;

import java.sql.Date;

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
	private int reviewLevel;
	private int productRef;
	private int reviewRef;
	
	
	public Review() {
		// TODO Auto-generated constructor stub
	}


	public Review(int reviewNum, int reviewScore, String reviewTitle, String reviewContents, String reviewWriter,
			String poNum, Date registerDate, int reviewViews, int pNum, int reviewLevel, int productRef,
			int reviewRef) {
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
		this.reviewLevel = reviewLevel;
		this.productRef = productRef;
		this.reviewRef = reviewRef;
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


	public int getReviewLevel() {
		return reviewLevel;
	}


	public void setReviewLevel(int reviewLevel) {
		this.reviewLevel = reviewLevel;
	}


	public int getProductRef() {
		return productRef;
	}


	public void setProductRef(int productRef) {
		this.productRef = productRef;
	}


	public int getReviewRef() {
		return reviewRef;
	}


	public void setReviewRef(int reviewRef) {
		this.reviewRef = reviewRef;
	}


	@Override
	public String toString() {
		return "Review [reviewNum=" + reviewNum + ", reviewScore=" + reviewScore + ", reviewTitle=" + reviewTitle
				+ ", reviewContents=" + reviewContents + ", reviewWriter=" + reviewWriter + ", poNum=" + poNum
				+ ", registerDate=" + registerDate + ", reviewViews=" + reviewViews + ", pNum=" + pNum
				+ ", reviewLevel=" + reviewLevel + ", productRef=" + productRef + ", reviewRef=" + reviewRef + "]";
	}


	
	
	
	
	
	
	
}
