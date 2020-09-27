package com.semi.board.model.vo;

import java.util.Date;

public class Board {
	
	private int boardNo;
	private String boardTitle;
	private String boardContent;
	private String userId;
	private String originalFN;
	private String renameFN;
	private Date boardDate;
	private int boardRecommend;
	private int boardHits;
	
	public Board() {
		// TODO Auto-generated constructor stub
	}

	public Board(int boardNo, String boardTitle, String boardContent, String userId, String originalFN, String renameFn,
			Date boardDate, int boardRecommend, int boardHits) {
		super();
		this.boardNo = boardNo;
		this.boardTitle = boardTitle;
		this.boardContent = boardContent;
		this.userId = userId;
		this.originalFN = originalFN;
		this.renameFN = renameFn;
		this.boardDate = boardDate;
		this.boardRecommend = boardRecommend;
		this.boardHits = boardHits;
	}

	public int getBoardNo() {
		return boardNo;
	}

	public void setBoardNo(int boardNo) {
		this.boardNo = boardNo;
	}

	public String getBoardTitle() {
		return boardTitle;
	}

	public void setBoardTitle(String boardTitle) {
		this.boardTitle = boardTitle;
	}

	public String getBoardContent() {
		return boardContent;
	}

	public void setBoardContent(String boardContent) {
		this.boardContent = boardContent;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getOriginalFN() {
		return originalFN;
	}

	public void setOriginalFN(String originalFN) {
		this.originalFN = originalFN;
	}

	public String getRenameFN() {
		return renameFN;
	}

	public void setRenameFN(String renameFn) {
		this.renameFN = renameFn;
	}

	public Date getBoardDate() {
		return boardDate;
	}

	public void setBoardDate(Date boardDate) {
		this.boardDate = boardDate;
	}

	public int getBoardRecommend() {
		return boardRecommend;
	}

	public void setBoardRecommend(int boardRecommend) {
		this.boardRecommend = boardRecommend;
	}

	public int getBoardHits() {
		return boardHits;
	}

	public void setBoardHits(int boardHits) {
		this.boardHits = boardHits;
	}

	@Override
	public String toString() {
		return "Board [boardNo=" + boardNo + ", boardTitle=" + boardTitle + ", boardContent=" + boardContent
				+ ", userId=" + userId + ", originalFN=" + originalFN + ", renameFN=" + renameFN + ", boardDate="
				+ boardDate + ", boardRecommend=" + boardRecommend + ", boardHits=" + boardHits + "]";
	}
	
	
}
