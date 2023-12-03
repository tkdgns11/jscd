package com.jscd.app.admin.dto;

import java.util.Date;

public class MemberManageDto {
	//member + allCode와 조인하여 성별,상태,등급을 String으로 받아서 화면에 뿌릴 때 사용할 Dto
	private int mebrNo;
	private String id;
	private String name;
	private String nickname;
	private String birth;
	private String pwd;
	private String gender;
	private String phone;
	private String acct;
	private String status;
	private String grade;
	private Date regDate;
	private String frsidNmbr;
	private Date modifyDate;
	private String lstidNmbr;
	private String etc;
	private String rememberId;


	public MemberManageDto(){}

	public MemberManageDto(String id, String pwd, String rememberId, String toUrl) {
		this.id = id;
		this.pwd = pwd;
		this.rememberId = rememberId;
	}

	public MemberManageDto(int mebrNo, String id, String name, String nickname, String birth, String pwd, String gender, String phone, String acct, String status, String grade, Date regDate, String frsidNmbr, Date modifyDate, String lstidNmbr, String etc, String rememberId) {
		this.mebrNo = mebrNo;
		this.id = id;
		this.name = name;
		this.nickname = nickname;
		this.birth = birth;
		this.pwd = pwd;
		this.gender = gender;
		this.phone = phone;
		this.acct = acct;
		this.status = status;
		this.grade = grade;
		this.regDate = regDate;
		this.frsidNmbr = frsidNmbr;
		this.modifyDate = modifyDate;
		this.lstidNmbr = lstidNmbr;
		this.etc = etc;
		this.rememberId = rememberId;
	}

	public int getMebrNo() {
		return mebrNo;
	}
	public void setMebrNo(int mebrNo) {
		this.mebrNo = mebrNo;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getBirth() {
		return birth;
	}
	public void setBirth(String birth) {
		this.birth = birth;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAcct() {
		return acct;
	}
	public void setAcct(String acct) {
		this.acct = acct;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getGrade() {
		return grade;
	}
	public void setGrade(String grade) {
		this.grade = grade;
	}
	public Date getRegDate() {
		return regDate;
	}
	public void setRegDate(Date regDate) {
		this.regDate = regDate;
	}
	public String getFrsidNmbr() {
		return frsidNmbr;
	}
	public void setFrsidNmbr(String frsidNmbr) {
		this.frsidNmbr = frsidNmbr;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	public String getLstidNmbr() {
		return lstidNmbr;
	}
	public void setLstidNmbr(String lstidNmbr) {
		this.lstidNmbr = lstidNmbr;
	}
	public String getEtc() {
		return etc;
	}
	public void setEtc(String etc) {
		this.etc = etc;
	}

	public String getRememberId() {
		return rememberId;
	}

	public void setRememberId(String rememberId) {
		this.rememberId = rememberId;
	}


	@Override
	public String toString() {
		return "MemberManageDto{" +
				"mebrNo=" + mebrNo +
				", id='" + id + '\'' +
				", name='" + name + '\'' +
				", nickname='" + nickname + '\'' +
				", birth='" + birth + '\'' +
				", pwd='" + pwd + '\'' +
				", gender='" + gender + '\'' +
				", phone='" + phone + '\'' +
				", acct='" + acct + '\'' +
				", status=" + status +
				", grade=" + grade +
				", regDate=" + regDate +
				", frsidNmbr='" + frsidNmbr + '\'' +
				", modifyDate=" + modifyDate +
				", lstidNmbr='" + lstidNmbr + '\'' +
				", etc='" + etc + '\'' +
				'}';
	}



}
