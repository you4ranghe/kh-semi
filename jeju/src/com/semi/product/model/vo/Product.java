package com.semi.product.model.vo;

import java.sql.Date;

public class Product {

	private int pNum;
	private String pBigNameEng;
	private String pBigNameKor;
	private String pName;
	private int pPriceA;
	private int pPriceC;
	private Date pDateStart;
	private Date pDateFinish;
	private String pTime;
	
	private String titleImgPath;
	private String pImgPath;
	private String pInfo;
	private String pPointInfo;
	private String pIntd;
	private String runtime;
	private String scheduleImgPath;
	private String precaution;
	private String pMapAddress;
	private String pMap;
	private int pScore;

	private String partnerId;

	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(int pNum, String pBigNameEng, String pBigNameKor, String pName, int pPriceA, int pPriceC,
			Date pDateStart, Date pDateFinish, String pTime, String titleImgPath, String pImgPath, String pInfo,
			String pPointInfo, String pIntd, String runtime, String scheduleImgPath, String precaution,
			String pMapAddress, String pMap, int pScore, String partnerId) {
		super();
		this.pNum = pNum;
		this.pBigNameEng = pBigNameEng;
		this.pBigNameKor = pBigNameKor;
		this.pName = pName;
		this.pPriceA = pPriceA;
		this.pPriceC = pPriceC;
		this.pDateStart = pDateStart;
		this.pDateFinish = pDateFinish;
		this.pTime = pTime;
		this.titleImgPath = titleImgPath;
		this.pImgPath = pImgPath;
		this.pInfo = pInfo;
		this.pPointInfo = pPointInfo;
		this.pIntd = pIntd;
		this.runtime = runtime;
		this.scheduleImgPath = scheduleImgPath;
		this.precaution = precaution;
		this.pMapAddress = pMapAddress;
		this.pMap = pMap;
		this.pScore = pScore;
		this.partnerId = partnerId;
	}

	public int getpNum() {
		return pNum;
	}

	public void setpNum(int pNum) {
		this.pNum = pNum;
	}

	public String getpBigNameEng() {
		return pBigNameEng;
	}

	public void setpBigNameEng(String pBigNameEng) {
		this.pBigNameEng = pBigNameEng;
	}

	public String getpBigNameKor() {
		return pBigNameKor;
	}

	public void setpBigNameKor(String pBigNameKor) {
		this.pBigNameKor = pBigNameKor;
	}

	public String getpName() {
		return pName;
	}

	public void setpName(String pName) {
		this.pName = pName;
	}

	public int getpPriceA() {
		return pPriceA;
	}

	public void setpPriceA(int pPriceA) {
		this.pPriceA = pPriceA;
	}

	public int getpPriceC() {
		return pPriceC;
	}

	public void setpPriceC(int pPriceC) {
		this.pPriceC = pPriceC;
	}

	public Date getpDateStart() {
		return pDateStart;
	}

	public void setpDateStart(Date pDateStart) {
		this.pDateStart = pDateStart;
	}

	public Date getpDateFinish() {
		return pDateFinish;
	}

	public void setpDateFinish(Date pDateFinish) {
		this.pDateFinish = pDateFinish;
	}

	public String getpTime() {
		return pTime;
	}

	public void setpTime(String pTime) {
		this.pTime = pTime;
	}

	public String getTitleImgPath() {
		return titleImgPath;
	}

	public void setTitleImgPath(String titleImgPath) {
		this.titleImgPath = titleImgPath;
	}

	public String getpImgPath() {
		return pImgPath;
	}

	public void setpImgPath(String pImgPath) {
		this.pImgPath = pImgPath;
	}

	public String getpInfo() {
		return pInfo;
	}

	public void setpInfo(String pInfo) {
		this.pInfo = pInfo;
	}

	public String getpPointInfo() {
		return pPointInfo;
	}

	public void setpPointInfo(String pPointInfo) {
		this.pPointInfo = pPointInfo;
	}

	public String getpIntd() {
		return pIntd;
	}

	public void setpIntd(String pIntd) {
		this.pIntd = pIntd;
	}

	public String getRuntime() {
		return runtime;
	}

	public void setRuntime(String runtime) {
		this.runtime = runtime;
	}

	public String getScheduleImgPath() {
		return scheduleImgPath;
	}

	public void setScheduleImgPath(String scheduleImgPath) {
		this.scheduleImgPath = scheduleImgPath;
	}

	public String getPrecaution() {
		return precaution;
	}

	public void setPrecaution(String precaution) {
		this.precaution = precaution;
	}

	public String getpMapAddress() {
		return pMapAddress;
	}

	public void setpMapAddress(String pMapAddress) {
		this.pMapAddress = pMapAddress;
	}

	public String getpMap() {
		return pMap;
	}

	public void setpMap(String pMap) {
		this.pMap = pMap;
	}

	public int getpScore() {
		return pScore;
	}

	public void setpScore(int pScore) {
		this.pScore = pScore;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	@Override
	public String toString() {
		return "Product [pNum=" + pNum + ", pBigNameEng=" + pBigNameEng + ", pBigNameKor=" + pBigNameKor + ", pName="
				+ pName + ", pPriceA=" + pPriceA + ", pPriceC=" + pPriceC + ", pDateStart=" + pDateStart
				+ ", pDateFinish=" + pDateFinish + ", pTime=" + pTime + ", titleImgPath=" + titleImgPath + ", pImgPath="
				+ pImgPath + ", pInfo=" + pInfo + ", pPointInfo=" + pPointInfo + ", pIntd=" + pIntd + ", runtime="
				+ runtime + ", scheduleImgPath=" + scheduleImgPath + ", precaution=" + precaution + ", pMapAddress="
				+ pMapAddress + ", pMap=" + pMap + ", pScore=" + pScore + ", partnerId=" + partnerId + "]";
	}

	
	

	
}
