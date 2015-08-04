package com.fantastic.web.vo;

import java.util.Date;

public class Comment {
	private String Code;
	private String MemberID;
	private String TravelCode;
	private Date regDate;
	private String Contents;

	
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public String getMemberID() {
		return MemberID;
	}
	public void setMemberID(String memberID) {
		MemberID = memberID;
	}
	public String getTravelCode() {
		return TravelCode;
	}
	public void setTravelCode(String travelCode) {
		TravelCode = travelCode;
	}

	public String getContents() {
		return Contents;
	}
	public void setContents(String contents) {
		Contents = contents;
	}
}
