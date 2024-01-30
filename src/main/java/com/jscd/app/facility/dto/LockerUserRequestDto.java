package com.jscd.app.facility.dto;

import java.util.Date;
import java.util.Objects;

public class LockerUserRequestDto {

    //lockerDetail 테이블
    private String lockerID;
    private String couponID;
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

    public LockerUserRequestDto(){}

    public LockerUserRequestDto(String lockerID, String mebrID) {
        this.lockerID = lockerID;
        this.mebrID = mebrID;
    }

    public LockerUserRequestDto(String lockerID, String couponID, String mebrID, Integer extdDays) {
        this.lockerID = lockerID;
        this.couponID = couponID;
        this.mebrID = mebrID;
        this.extdDays = extdDays;
    }

    public LockerUserRequestDto(String lockerID, String mebrID, Date startDate, Date endDate) {
        this.lockerID = lockerID;
        this.mebrID = mebrID;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public String getLockerID() {
        return lockerID;
    }

    public void setLockerID(String lockerID) {
        this.lockerID = lockerID;
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

    public String getCouponID() {
        return couponID;
    }

    public void setCouponID(String couponID) {
        this.couponID = couponID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof LockerUserRequestDto)) return false;
        LockerUserRequestDto that = (LockerUserRequestDto) o;
        return Objects.equals(getLockerID(), that.getLockerID()) && Objects.equals(getCouponID(), that.getCouponID()) && Objects.equals(getMebrID(), that.getMebrID()) && Objects.equals(getStatusCode(), that.getStatusCode()) && Objects.equals(getStartDate(), that.getStartDate()) && Objects.equals(getEndDate(), that.getEndDate()) && Objects.equals(getEtc(), that.getEtc()) && Objects.equals(getRegDate(), that.getRegDate()) && Objects.equals(getFrsidNmbr(), that.getFrsidNmbr()) && Objects.equals(getModifyDate(), that.getModifyDate()) && Objects.equals(getLstidNmbr(), that.getLstidNmbr()) && Objects.equals(getExtdDays(), that.getExtdDays());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getLockerID(), getCouponID(), getMebrID(), getStatusCode(), getStartDate(), getEndDate(), getEtc(), getRegDate(), getFrsidNmbr(), getModifyDate(), getLstidNmbr(), getExtdDays());
    }

    @Override
    public String toString() {
        return "LockerUserRequestDto{" +
                "lockerID='" + lockerID + '\'' +
                ", couponID='" + couponID + '\'' +
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
                '}';
    }
}