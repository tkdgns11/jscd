package com.jscd.app.facility.dto;

import java.util.Date;
import java.util.Objects;

public class LockerDto {
    //member table
    private String id; //email
    private String name;
    private String phone;

    //lockerInfo table
    private String lockerCode;
    private Integer lockerCnt;
    private String lockerAddr;
    private String lockerDeAddr;
    private Integer monthFee;

    //lockerDetailtable
    private String lockerID;
    private Integer historyNO;
    private Integer lockerNO;
    private String mebrID;
    private Integer statusCode;
    private Date startDate;
    private Date endDate;
    private String etc;
    private Date regDate;
    private String frsidNmbr;
    private Date modifyDate;
    private String lstidNmbr;
    //기간연장 변수
    private Integer extdDays;
    private String endDateString;
    private String remainDays;

    public LockerDto(String lockerID, Integer historyNO) {
        this.lockerID = lockerID;
        this.historyNO = historyNO;
    }

    public LockerDto(){}

    public LockerDto(String lockerID, String mebrID, Date startDate, Date endDate) {
        this.lockerID = lockerID;
        this.mebrID = mebrID;
        this.startDate = startDate;
        this.endDate = endDate;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLockerCode() {
        return lockerCode;
    }

    public void setLockerCode(String lockerCode) {
        this.lockerCode = lockerCode;
    }

    public Integer getLockerCnt() {
        return lockerCnt;
    }

    public void setLockerCnt(Integer lockerCnt) {
        this.lockerCnt = lockerCnt;
    }

    public String getLockerAddr() {
        return lockerAddr;
    }

    public void setLockerAddr(String lockerAddr) {
        this.lockerAddr = lockerAddr;
    }

    public String getLockerDeAddr() {
        return lockerDeAddr;
    }

    public void setLockerDeAddr(String lockerDeAddr) {
        this.lockerDeAddr = lockerDeAddr;
    }

    public Integer getMonthFee() {
        return monthFee;
    }

    public void setMonthFee(Integer monthFee) {
        this.monthFee = monthFee;
    }

    public String getLockerID() {
        return lockerID;
    }

    public void setLockerID(String lockerID) {
        this.lockerID = lockerID;
    }

    public Integer getHistoryNO() {
        return historyNO;
    }

    public void setHistoryNO(Integer historyNO) {
        this.historyNO = historyNO;
    }

    public Integer getLockerNO() {
        return lockerNO;
    }

    public void setLockerNO(Integer lockerNO) {
        this.lockerNO = lockerNO;
    }

    public String getMebrID() {
        return mebrID;
    }

    public void setMebrID(String mebrID) {
        this.mebrID = mebrID;
    }

    public Integer getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(Integer statusCode) {
        this.statusCode = statusCode;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
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

    public Integer getExtdDays() {
        return extdDays;
    }

    public void setExtdDays(Integer extdDays) {
        this.extdDays = extdDays;
    }

    public String getEndDateString() {
        return endDateString;
    }

    public void setEndDateString(String endDateString) {
        this.endDateString = endDateString;
    }

    public String getRemainDays() {
        return remainDays;
    }

    public void setRemainDays(String remainDays) {
        this.remainDays = remainDays;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LockerDto)) return false;
        LockerDto lockerDto = (LockerDto) o;
        return Objects.equals(getId(), lockerDto.getId()) && Objects.equals(getName(), lockerDto.getName()) && Objects.equals(getPhone(), lockerDto.getPhone()) && Objects.equals(getLockerCode(), lockerDto.getLockerCode()) && Objects.equals(getLockerCnt(), lockerDto.getLockerCnt()) && Objects.equals(getLockerAddr(), lockerDto.getLockerAddr()) && Objects.equals(getLockerDeAddr(), lockerDto.getLockerDeAddr()) && Objects.equals(getMonthFee(), lockerDto.getMonthFee()) && Objects.equals(getLockerID(), lockerDto.getLockerID()) && Objects.equals(getHistoryNO(), lockerDto.getHistoryNO()) && Objects.equals(getLockerNO(), lockerDto.getLockerNO()) && Objects.equals(getMebrID(), lockerDto.getMebrID()) && Objects.equals(getStatusCode(), lockerDto.getStatusCode()) && Objects.equals(getStartDate(), lockerDto.getStartDate()) && Objects.equals(getEndDate(), lockerDto.getEndDate()) && Objects.equals(getEtc(), lockerDto.getEtc()) && Objects.equals(getExtdDays(), lockerDto.getExtdDays()) && Objects.equals(getEndDateString(), lockerDto.getEndDateString()) && Objects.equals(getRemainDays(), lockerDto.getRemainDays());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getName(), getPhone(), getLockerCode(), getLockerCnt(), getLockerAddr(), getLockerDeAddr(), getMonthFee(), getLockerID(), getHistoryNO(), getLockerNO(), getMebrID(), getStatusCode(), getStartDate(), getEndDate(), getEtc(), getExtdDays(), getEndDateString(), getRemainDays());
    }

    @Override
    public String toString() {
        return "LockerDto{" +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", lockerCode='" + lockerCode + '\'' +
                ", lockerCnt=" + lockerCnt +
                ", lockerAddr='" + lockerAddr + '\'' +
                ", lockerDeAddr='" + lockerDeAddr + '\'' +
                ", monthFee=" + monthFee +
                ", lockerID='" + lockerID + '\'' +
                ", historyNO=" + historyNO +
                ", lockerNO=" + lockerNO +
                ", mebrID='" + mebrID + '\'' +
                ", statusCode=" + statusCode +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", etc='" + etc + '\'' +
                ", regDate=" + regDate +
                ", frsidNmbr='" + frsidNmbr + '\'' +
                ", modifyDate=" + modifyDate +
                ", lstidNmbr='" + lstidNmbr + '\'' +
                ", extdDays=" + extdDays +
                ", endDateString='" + endDateString + '\'' +
                ", remainDays='" + remainDays + '\'' +
                '}';
    }
}