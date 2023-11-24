package com.jscd.app.admin.dto;

import java.util.Date;
import java.util.Objects;

public class InstructorMemberInfoDto {
    private String iscrNo; //pk_강사 고유 번호
    private Integer mebrNo; //회원 고유 번호
    private String intro;
    private Integer status;
    private Float hourPmt;
    private Date regDate;
    private String frsidNmbr;
    private Date modifyDate;
    private String lstidNmbr;
    private String etc;
    //    ㅡㅡㅡㅡㅡㅡㅡㅡ회원컬럼ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    private String id;
    private String name;
    private Date birth;
    private String phone;
    private String acct;

    public InstructorMemberInfoDto(){}

    public InstructorMemberInfoDto(String iscrNo, Integer mebrNo, String intro, Integer status, Float hourPmt, Date regDate,
                                   String frsidNmbr, Date modifyDate, String lstidNmbr, String etc, String id, String name, Date birth,
                                   String phone, String acct) {
        this.iscrNo = iscrNo;
        this.mebrNo = mebrNo;
        this.intro = intro;
        this.status = status;
        this.hourPmt = hourPmt;
        this.regDate = regDate;
        this.frsidNmbr = frsidNmbr;
        this.modifyDate = modifyDate;
        this.lstidNmbr = lstidNmbr;
        this.etc = etc;
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.phone = phone;
        this.acct = acct;
    }

    public String getIscrNo() {
        return iscrNo;
    }

    public void setIscrNo(String iscrNo) {
        this.iscrNo = iscrNo;
    }

    public Integer getMebrNo() {
        return mebrNo;
    }

    public void setMebrNo(Integer mebrNo) {
        this.mebrNo = mebrNo;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Float getHourPmt() {
        return hourPmt;
    }

    public void setHourPmt(Float hourPmt) {
        this.hourPmt = hourPmt;
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }


    public String getAcct() {
        return acct;
    }

    public void setAcct(String acct) {
        this.acct = acct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstructorMemberInfoDto that = (InstructorMemberInfoDto) o;
        return Objects.equals(iscrNo, that.iscrNo) && Objects.equals(mebrNo, that.mebrNo) && Objects.equals(intro, that.intro) && Objects.equals(status, that.status) && Objects.equals(hourPmt, that.hourPmt) && Objects.equals(regDate, that.regDate) && Objects.equals(frsidNmbr, that.frsidNmbr) && Objects.equals(modifyDate, that.modifyDate) && Objects.equals(lstidNmbr, that.lstidNmbr) && Objects.equals(etc, that.etc) && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(birth, that.birth) && Objects.equals(phone, that.phone)&& Objects.equals(acct, that.acct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iscrNo, mebrNo, intro, status, hourPmt, regDate, frsidNmbr, modifyDate, lstidNmbr, etc, id, name, birth, phone, acct);
    }

    @Override
    public String toString() {
        return "InstructorMemberInfoDto{" +
                "iscrNo='" + iscrNo + '\'' +
                ", mebrNo=" + mebrNo +
                ", intro='" + intro + '\'' +
                ", status=" + status +
                ", hourPmt=" + hourPmt +
                ", regDate=" + regDate +
                ", frsidNmbr='" + frsidNmbr + '\'' +
                ", modifyDate=" + modifyDate +
                ", lstidNmbr='" + lstidNmbr + '\'' +
                ", etc='" + etc + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", phone='" + phone + '\'' +
                ", acct='" + acct + '\'' +
                '}';
    }
    }






