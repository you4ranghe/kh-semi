package com.semi.product.model.vo;

import java.util.Date;

public class Product {
	private int pdNum;
	private String pdName;
	private int pdPricea;
	private int pdPricec;
	private String pdimgPath;
	private int pdScore;
	private Date pdDateStart;
	private String pdPlace;
	private String pdWish;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int pdNum, String pdName, int pdPricea, int pdPricec, String pdimgPath, int pdScore,
			Date pdDateStart, String pdPlace, String pdWish) {
		super();
		this.pdNum = pdNum;
		this.pdName = pdName;
		this.pdPricea = pdPricea;
		this.pdPricec = pdPricec;
		this.pdimgPath = pdimgPath;
		this.pdScore = pdScore;
		this.pdDateStart = pdDateStart;
		this.pdPlace = pdPlace;
		this.pdWish = pdWish;
	}

	public int getPdNum() {
		return pdNum;
	}

	public void setPdNum(int pdNum) {
		this.pdNum = pdNum;
	}

	public String getPdName() {
		return pdName;
	}

	public void setPdName(String pdName) {
		this.pdName = pdName;
	}

	public int getPdPricea() {
		return pdPricea;
	}

	public void setPdPricea(int pdPricea) {
		this.pdPricea = pdPricea;
	}

	public int getPdPricec() {
		return pdPricec;
	}

	public void setPdPricec(int pdPricec) {
		this.pdPricec = pdPricec;
	}

	public String getPdimgPath() {
		return pdimgPath;
	}

	public void setPdimgPath(String pdimgPath) {
		this.pdimgPath = pdimgPath;
	}

	public int getPdScore() {
		return pdScore;
	}

	public void setPdScore(int pdScore) {
		this.pdScore = pdScore;
	}

	public Date getPdDateStart() {
		return pdDateStart;
	}

	public void setPdDateStart(Date pdDateStart) {
		this.pdDateStart = pdDateStart;
	}

	public String getPdPlace() {
		return pdPlace;
	}

	public void setPdPlace(String pdPlace) {
		this.pdPlace = pdPlace;
	}

	public String getPdWish() {
		return pdWish;
	}

	public void setPdWish(String pdWish) {
		this.pdWish = pdWish;
	}

	@Override
	public String toString() {
		return "Product [pdNum=" + pdNum + ", pdName=" + pdName + ", pdPricea=" + pdPricea + ", pdPricec=" + pdPricec
				+ ", pdimgPath=" + pdimgPath + ", pdScore=" + pdScore + ", pdDateStart=" + pdDateStart + ", pdPlace="
				+ pdPlace + ", pdWish=" + pdWish + "]";
	}
	
	
	
	
}
