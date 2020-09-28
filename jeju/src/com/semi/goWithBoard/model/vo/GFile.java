package com.semi.goWithBoard.model.vo;

public class GFile {
	
	private int gowithNo;
	private String fileName;
	private String fileRename;
	
	public GFile() {
		// TODO Auto-generated constructor stub
	}

	public GFile(int gowithNo, String fileName, String fileRename) {
		super();
		this.gowithNo = gowithNo;
		this.fileName = fileName;
		this.fileRename = fileRename;
	}

	public int getGowithNo() {
		return gowithNo;
	}

	public void setGowithNo(int gowithNo) {
		this.gowithNo = gowithNo;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileRename() {
		return fileRename;
	}

	public void setFileRename(String fileRename) {
		this.fileRename = fileRename;
	}

	@Override
	public String toString() {
		return "GFIle [gowithNo=" + gowithNo + ", fileName=" + fileName + ", fileRename=" + fileRename + "]";
	}
	
	
}
