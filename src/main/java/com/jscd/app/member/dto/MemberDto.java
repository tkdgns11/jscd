package com.jscd.app.member.dto;

import java.util.Date;

public class MemberDto {
	private int meberNo;
	private String id;
	private String name;
	private String alias;
	private String birth;
	private String pwd;
	private String phone1;
	private String phone2;
	private String phone3;
	private String acct;
	private int status;
	private int grade;
	private Date regDate;
	private String frsidNmbr;	// 시스템 컬럼은 안들어가도 되는거 아닌가?
	private Date modifyDate;	
	private String lstidNmbr;
	private String etc;

	//(id, name, alias, birth, pwd, phone1, phone2, phone3,
	//                acct, status, grade, regDate, frsidNmbr, modifyDate, lstidNmbr, etc)
	public MemberDto(){}

	public MemberDto(String id, String name, String alias, String birth, String pwd, String phone1, String phone2, String phone3, String acct, int status, int grade, Date regDate, String frsidNmbr, Date modifyDate, String lstidNmbr, String etc) {
		this.id = id;
		this.name = name;
		this.alias = alias;
		this.birth = birth;
		this.pwd = pwd;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.acct = acct;
		this.status = status;
		this.grade = grade;
		this.regDate = regDate;
		this.frsidNmbr = frsidNmbr;
		this.modifyDate = modifyDate;
		this.lstidNmbr = lstidNmbr;
		this.etc = etc;
	}

	@Override
	public String toString() {
		return "memberDto [meberNo=" + meberNo + ", id=" + id + ", name=" + name + ", alias=" + alias + ", birth="
				+ birth + ", pwd=" + pwd + ", phone1=" + phone1 + ", phone2=" + phone2 + ", phone3=" + phone3
				+ ", acct=" + acct + ", status=" + status + ", grade=" + grade + ", regDate=" + regDate + ", frsidNmbr="
				+ frsidNmbr + ", modifyDate=" + modifyDate + ", lstidNmbr=" + lstidNmbr + ", etc=" + etc + "]";
	}
	
	
	public MemberDto(String id, String name, String pwd){
		this.id = id;
		this.name = name;
		this.pwd = pwd;
	}
	public MemberDto(int meberNo, String id, String name, String alias, String birth, String pwd, String phone1,
					 String phone2, String phone3, String acct, int status, int grade, Date regDate, String frsidNmbr,
					 Date modifyDate, String lstidNmbr, String etc) {
		super();
		this.meberNo = meberNo;
		this.id = id;
		this.name = name;
		this.alias = alias;
		this.birth = birth;
		this.pwd = pwd;
		this.phone1 = phone1;
		this.phone2 = phone2;
		this.phone3 = phone3;
		this.acct = acct;
		this.status = status;
		this.grade = grade;
		this.regDate = regDate;
		this.frsidNmbr = frsidNmbr;
		this.modifyDate = modifyDate;
		this.lstidNmbr = lstidNmbr;
		this.etc = etc;
	}




	public int getMeberNo() {
		return meberNo;
	}
	public void setMeberNo(int meberNo) {
		this.meberNo = meberNo;
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
	public String getAlias() {
		return alias;
	}
	public void setAlias(String alias) {
		this.alias = alias;
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
	public String getPhone1() {
		return phone1;
	}
	public void setPhone1(String phone1) {
		this.phone1 = phone1;
	}
	public String getPhone2() {
		return phone2;
	}
	public void setPhone2(String phone2) {
		this.phone2 = phone2;
	}
	public String getPhone3() {
		return phone3;
	}
	public void setPhone3(String phone3) {
		this.phone3 = phone3;
	}
	public String getAcct() {
		return acct;
	}
	public void setAcct(String acct) {
		this.acct = acct;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
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
	
	
}
