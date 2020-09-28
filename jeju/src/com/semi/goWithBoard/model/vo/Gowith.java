package com.semi.goWithBoard.model.vo;

import java.util.Date;

public class Gowith {
	
	private int gowhitNo;//게시판번호
	private String userId;//작성자 아이디
	private String gowithTitle;
	private Date writeDate;//작성 날짜
	private Date travelStart;//여행시작 날짜
	private Date travelEnd;//여행 종료날짜
	private Date recruitmentEnd;//모집 종료 날짜
	private String schedule;//일정
	private String destination;//행선지
	private int totalPerson;//총인원
	private int recruitmentPerson;//모집인원
	private int nowGenderM;//현제 남자
	private int nowGenderF;//현재 여자
	private int recruitmentGenderM;//모집 남자
	private int recruitmentGenderF;//모집 여자
	private String contact;//대표연락처
	private String comment;//기타내용
	private int gRecommend;
	private int gHits;
	
	public Gowith() {
		// TODO Auto-generated constructor stub
	}

	public Gowith(int gowhitNo, String userId, String gowithTitle, Date writeDate, Date travelStart, Date travelEnd,
			Date recruitmentEnd, String schedule, String destination, int totalPerson, int recruitmentPerson,
			int nowGenderM, int nowGenderF, int recruitmentGenderM, int recruitmentGenderF, String contact,
			String comment, int gRecommend, int gHits) {
		super();
		this.gowhitNo = gowhitNo;
		this.userId = userId;
		this.gowithTitle = gowithTitle;
		this.writeDate = writeDate;
		this.travelStart = travelStart;
		this.travelEnd = travelEnd;
		this.recruitmentEnd = recruitmentEnd;
		this.schedule = schedule;
		this.destination = destination;
		this.totalPerson = totalPerson;
		this.recruitmentPerson = recruitmentPerson;
		this.nowGenderM = nowGenderM;
		this.nowGenderF = nowGenderF;
		this.recruitmentGenderM = recruitmentGenderM;
		this.recruitmentGenderF = recruitmentGenderF;
		this.contact = contact;
		this.comment = comment;
		this.gRecommend = gRecommend;
		this.gHits = gHits;
	}

	public int getGowhitNo() {
		return gowhitNo;
	}

	public void setGowhitNo(int gowhitNo) {
		this.gowhitNo = gowhitNo;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getGowithTitle() {
		return gowithTitle;
	}

	public void setGowithTitle(String gowithTitle) {
		this.gowithTitle = gowithTitle;
	}

	public Date getWriteDate() {
		return writeDate;
	}

	public void setWriteDate(Date writeDate) {
		this.writeDate = writeDate;
	}

	public Date getTravelStart() {
		return travelStart;
	}

	public void setTravelStart(Date travelStart) {
		this.travelStart = travelStart;
	}

	public Date getTravelEnd() {
		return travelEnd;
	}

	public void setTravelEnd(Date travelEnd) {
		this.travelEnd = travelEnd;
	}

	public Date getRecruitmentEnd() {
		return recruitmentEnd;
	}

	public void setRecruitmentEnd(Date recruitmentEnd) {
		this.recruitmentEnd = recruitmentEnd;
	}

	public String getSchedule() {
		return schedule;
	}

	public void setSchedule(String schedule) {
		this.schedule = schedule;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public int getTotalPerson() {
		return totalPerson;
	}

	public void setTotalPerson(int totalPerson) {
		this.totalPerson = totalPerson;
	}

	public int getRecruitmentPerson() {
		return recruitmentPerson;
	}

	public void setRecruitmentPerson(int recruitmentPerson) {
		this.recruitmentPerson = recruitmentPerson;
	}

	public int getNowGenderM() {
		return nowGenderM;
	}

	public void setNowGenderM(int nowGenderM) {
		this.nowGenderM = nowGenderM;
	}

	public int getNowGenderF() {
		return nowGenderF;
	}

	public void setNowGenderF(int nowGenderF) {
		this.nowGenderF = nowGenderF;
	}

	public int getRecruitmentGenderM() {
		return recruitmentGenderM;
	}

	public void setRecruitmentGenderM(int recruitmentGenderM) {
		this.recruitmentGenderM = recruitmentGenderM;
	}

	public int getRecruitmentGenderF() {
		return recruitmentGenderF;
	}

	public void setRecruitmentGenderF(int recruitmentGenderF) {
		this.recruitmentGenderF = recruitmentGenderF;
	}

	public String getContact() {
		return contact;
	}

	public void setContact(String contact) {
		this.contact = contact;
	}

	public String getComment() {
		return comment;
	}

	public void setComment(String comment) {
		this.comment = comment;
	}

	public int getgRecommend() {
		return gRecommend;
	}

	public void setgRecommend(int gRecommend) {
		this.gRecommend = gRecommend;
	}

	public int getgHits() {
		return gHits;
	}

	public void setgHits(int gHits) {
		this.gHits = gHits;
	}

	@Override
	public String toString() {
		return "Gowith [gowhitNo=" + gowhitNo + ", userId=" + userId + ", gowithTitle=" + gowithTitle + ", writeDate="
				+ writeDate + ", travelStart=" + travelStart + ", travelEnd=" + travelEnd + ", recruitmentEnd="
				+ recruitmentEnd + ", schedule=" + schedule + ", destination=" + destination + ", totalPerson="
				+ totalPerson + ", recruitmentPerson=" + recruitmentPerson + ", nowGenderM=" + nowGenderM
				+ ", nowGenderF=" + nowGenderF + ", recruitmentGenderM=" + recruitmentGenderM + ", recruitmentGenderF="
				+ recruitmentGenderF + ", contact=" + contact + ", comment=" + comment + ", gRecommend=" + gRecommend
				+ ", gHits=" + gHits + "]";
	}

	
	
}
