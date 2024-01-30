package com.jscd.app.member.dto;

import java.util.Date;
import java.util.Objects;

public class MemberDto {
	private int mebrNO;
	private String id;
	private String name;
	private String nickname;
	private String birth;
	private String pwd;
	private int gender;
	private String phone;
	private String acct;
	private int status;
	private int grade;
	private Date regDate;
	private String firstIdNO;	// 시스템 컬럼은 안들어가도 되는거 아닌가?
	private Date modifyDate;
	private String lastIdNO;
	private String etc;
	private String rememberId; //아이디 기억
	private String serviceChkYN;
	private String privacyChkYN;
	private String ageChkYN;
	private String marketingChkYN;
	private String toURL;

	public String getToURL() {
		return toURL;
	}

	public void setToURL(String toURL) {
		this.toURL = toURL;
	}

	public MemberDto() {}

	public MemberDto(String id){
		this.id = id;
	}

	public MemberDto(int mebrNO, String id, String name, String nickname, String birth, String pwd, int gender, String phone, String acct, int status, int grade, Date regDate, String firstIdNO, Date modifyDate, String lastIdNO, String etc, String rememberId, String serviceChkYN, String privacyChkYN, String ageChkYN, String marketingChkYN) {
		this.mebrNO = mebrNO;
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
		this.firstIdNO = firstIdNO;
		this.modifyDate = modifyDate;
		this.lastIdNO = lastIdNO;
		this.etc = etc;
		this.rememberId = rememberId;
		this.serviceChkYN = serviceChkYN;
		this.privacyChkYN = privacyChkYN;
		this.ageChkYN = ageChkYN;
		this.marketingChkYN = marketingChkYN;
	}

	public int getMebrNO() {
		return mebrNO;
	}

	public void setMebrNO(int mebrNO) {
		this.mebrNO = mebrNO;
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

	public int getGender() {
		return gender;
	}

	public void setGender(int gender) {
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

	public String getFirstIdNO() {
		return firstIdNO;
	}

	public void setFirstIdNO(String firstIdNO) {
		this.firstIdNO = firstIdNO;
	}

	public Date getModifyDate() {
		return modifyDate;
	}

	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}

	public String getLastIdNO() {
		return lastIdNO;
	}

	public void setLastIdNO(String lastIdNO) {
		this.lastIdNO = lastIdNO;
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

	public String getServiceChkYN() {
		return serviceChkYN;
	}

	public void setServiceChkYN(String serviceChkYN) {
		this.serviceChkYN = serviceChkYN;
	}

	public String getPrivacyChkYN() {
		return privacyChkYN;
	}

	public void setPrivacyChkYN(String privacyChkYN) {
		this.privacyChkYN = privacyChkYN;
	}

	public String getAgeChkYN() {
		return ageChkYN;
	}

	public void setAgeChkYN(String ageChkYN) {
		this.ageChkYN = ageChkYN;
	}

	public String getMarketingChkYN() {
		return marketingChkYN;
	}

	public void setMarketingChkYN(String marketingChkYN) {
		this.marketingChkYN = marketingChkYN;
	}


	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MemberDto memberDto = (MemberDto) o;
		return mebrNO == memberDto.mebrNO && gender == memberDto.gender && status == memberDto.status && grade == memberDto.grade && Objects.equals(id, memberDto.id) && Objects.equals(name, memberDto.name) && Objects.equals(nickname, memberDto.nickname) && Objects.equals(birth, memberDto.birth) && Objects.equals(pwd, memberDto.pwd) && Objects.equals(phone, memberDto.phone) && Objects.equals(acct, memberDto.acct) && Objects.equals(regDate, memberDto.regDate) && Objects.equals(firstIdNO, memberDto.firstIdNO) && Objects.equals(modifyDate, memberDto.modifyDate) && Objects.equals(lastIdNO, memberDto.lastIdNO) && Objects.equals(etc, memberDto.etc) && Objects.equals(rememberId, memberDto.rememberId) && Objects.equals(serviceChkYN, memberDto.serviceChkYN) && Objects.equals(privacyChkYN, memberDto.privacyChkYN) && Objects.equals(ageChkYN, memberDto.ageChkYN) && Objects.equals(marketingChkYN, memberDto.marketingChkYN);
	}


	@Override
	public String toString() {
		return "MemberDto{" +
				"mebrNO=" + mebrNO +
				", id='" + id + '\'' +
				", name='" + name + '\'' +
				", nickname='" + nickname + '\'' +
				", birth='" + birth + '\'' +
				", pwd='" + pwd + '\'' +
				", gender=" + gender +
				", phone='" + phone + '\'' +
				", acct='" + acct + '\'' +
				", status=" + status +
				", grade=" + grade +
				", regDate=" + regDate +
				", firstIdNO='" + firstIdNO + '\'' +
				", modifyDate=" + modifyDate +
				", lastIdNO='" + lastIdNO + '\'' +
				", etc='" + etc + '\'' +
				", rememberId='" + rememberId + '\'' +
				", serviceChkYN='" + serviceChkYN + '\'' +
				", privacyChkYN='" + privacyChkYN + '\'' +
				", ageChkYN='" + ageChkYN + '\'' +
				", marketingChkYN='" + marketingChkYN + '\'' +
				'}';
	}
}
