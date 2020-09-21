package com.semi.partner.model.vo;

import java.sql.Date;

public class Partner {
	
	private int partnerNum;
	private  String partnerId;
	private String partnerImgOriginal;
	private String partnerImgRename;
	private String idCardImgOriginal;
	private String idCardImgRename;
	private String partnerNick;
	private Date pEnrolldate;
	
	public Partner() {
		// TODO Auto-generated constructor stub
	}

	public Partner(int partnerNum, String partnerId, String partnerImgOriginal, String partnerImgRename,
			String idCardImgOriginal, String idCardImgRename, String partnerNick, Date pEnrolldate) {
		super();
		this.partnerNum = partnerNum;
		this.partnerId = partnerId;
		this.partnerImgOriginal = partnerImgOriginal;
		this.partnerImgRename = partnerImgRename;
		this.idCardImgOriginal = idCardImgOriginal;
		this.idCardImgRename = idCardImgRename;
		this.partnerNick = partnerNick;
		this.pEnrolldate = pEnrolldate;
	}

	public int getPartnerNum() {
		return partnerNum;
	}

	public void setPartnerNum(int partnerNum) {
		this.partnerNum = partnerNum;
	}

	public String getPartnerId() {
		return partnerId;
	}

	public void setPartnerId(String partnerId) {
		this.partnerId = partnerId;
	}

	public String getPartnerImgOriginal() {
		return partnerImgOriginal;
	}

	public void setPartnerImgOriginal(String partnerImgOriginal) {
		this.partnerImgOriginal = partnerImgOriginal;
	}

	public String getPartnerImgRename() {
		return partnerImgRename;
	}

	public void setPartnerImgRename(String partnerImgRename) {
		this.partnerImgRename = partnerImgRename;
	}

	public String getIdCardImgOriginal() {
		return idCardImgOriginal;
	}

	public void setIdCardImgOriginal(String idCardImgOriginal) {
		this.idCardImgOriginal = idCardImgOriginal;
	}

	public String getIdCardImgRename() {
		return idCardImgRename;
	}

	public void setIdCardImgRename(String idCardImgRename) {
		this.idCardImgRename = idCardImgRename;
	}

	public String getPartnerNick() {
		return partnerNick;
	}

	public void setPartnerNick(String partnerNick) {
		this.partnerNick = partnerNick;
	}

	public Date getpEnrolldate() {
		return pEnrolldate;
	}

	public void setpEnrolldate(Date pEnrolldate) {
		this.pEnrolldate = pEnrolldate;
	}

	@Override
	public String toString() {
		return "Partner [partnerNum=" + partnerNum + ", partnerId=" + partnerId + ", partnerImgOriginal="
				+ partnerImgOriginal + ", partnerImgRename=" + partnerImgRename + ", idCardImgOriginal="
				+ idCardImgOriginal + ", idCardImgRename=" + idCardImgRename + ", partnerNick=" + partnerNick
				+ ", pEnrolldate=" + pEnrolldate + "]";
	}
	
	
	

}
