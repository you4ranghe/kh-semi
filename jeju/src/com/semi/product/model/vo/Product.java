package com.semi.product.model.vo;

import java.sql.Date;

public class Product {

	private String pNum;
	private String pBigNameEng;
	private String pBigNameKor;
	private String pName;
	private int pPriceA;
	private int pPriceC;
	private int pCountA;
	private int pCountC;
	private String pPlace;
	private String pWish;
	private Date pDateStart;
	private Date pDateFinish;
	private String pTime;
	private String pPeriod;

	private String gNum;
	private String titleImgPath;
	private String pInfo;
	private String pPointInfo;
	private String pIntd;
	private String runtime;
	private String schedule;
	private String precaution;
	private String pMapName;
	private String pMap;
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	public Product(String pNum, String pBigNameEng, String pBigNameKor, String pName, int pPriceA, int pPriceC,
			int pCountA, int pCountC, String pPlace, String pWish, Date pDateStart, Date pDateFinish, String pTime,
			String pPeriod, String gNum, String titleImgPath, String pInfo, String pPointInfo, String pIntd,
			String runtime, String schedule, String precaution, String pMapName, String pMap) {
		super();
		this.pNum = pNum;
		this.pBigNameEng = pBigNameEng;
		this.pBigNameKor = pBigNameKor;
		this.pName = pName;
		this.pPriceA = pPriceA;
		this.pPriceC = pPriceC;
		this.pCountA = pCountA;
		this.pCountC = pCountC;
		this.pPlace = pPlace;
		this.pWish = pWish;
		this.pDateStart = pDateStart;
		this.pDateFinish = pDateFinish;
		this.pTime = pTime;
		this.pPeriod = pPeriod;
		this.gNum = gNum;
		this.titleImgPath = titleImgPath;
		this.pInfo = pInfo;
		this.pPointInfo = pPointInfo;
		this.pIntd = pIntd;
		this.runtime = runtime;
		this.schedule = schedule;
		this.precaution = precaution;
		this.pMapName = pMapName;
		this.pMap = pMap;
	}

	public String getpNum() {
		return pNum;
	}

	public void setpNum(String pNum) {
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

	public String getpPlace() {
		return pPlace;
	}

	public void setpPlace(String pPlace) {
		this.pPlace = pPlace;
	}

	public String getpWish() {
		return pWish;
	}

	public void setpWish(String pWish) {
		this.pWish = pWish;
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

	public String getpPeriod() {
		return pPeriod;
	}

	public void setpPeriod(String pPeriod) {
		this.pPeriod = pPeriod;
	}

	public String getgNum() {
		return gNum;
	}

	public void setgNum(String gNum) {
		this.gNum = gNum;
	}

	public String getTitleImgPath() {
		return titleImgPath;
	}

	public void setTitleImgPath(String titleImgPath) {
		this.titleImgPath = titleImgPath;
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

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getPrecaution() {
		return precaution;
	}

	public void setPrecaution(String precaution) {
		this.precaution = precaution;
	}

	public String getpMapName() {
		return pMapName;
	}

	public void setpMapName(String pMapName) {
		this.pMapName = pMapName;
	}

	public String getpMap() {
		return pMap;
	}

	public void setpMap(String pMap) {
		this.pMap = pMap;
	}

	@Override
	public String toString() {
		return "Product [pNum=" + pNum + ", pBigNameEng=" + pBigNameEng + ", pBigNameKor=" + pBigNameKor + ", pName="
				+ pName + ", pPriceA=" + pPriceA + ", pPriceC=" + pPriceC + ", pCountA=" + pCountA + ", pCountC="
				+ pCountC + ", pPlace=" + pPlace + ", pWish=" + pWish + ", pDateStart=" + pDateStart + ", pDateFinish="
				+ pDateFinish + ", pTime=" + pTime + ", pPeriod=" + pPeriod + ", gNum=" + gNum + ", titleImgPath="
				+ titleImgPath + ", pInfo=" + pInfo + ", pPointInfo=" + pPointInfo + ", pIntd=" + pIntd + ", runtime="
				+ runtime + ", schedule=" + schedule + ", precaution=" + precaution + ", pMapName=" + pMapName
				+ ", pMap=" + pMap + "]";
	}

	
	
	
	}