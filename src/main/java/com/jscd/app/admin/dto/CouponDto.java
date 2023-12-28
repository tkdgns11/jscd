package com.jscd.app.admin.dto;

import java.time.LocalTime;
import java.util.Date;
import java.util.Objects;

public class CouponDto {
    private Integer historyNO;
    private String couponID;
    private Integer couponNO;
    private Date startUseDate ;
    private Date endUseDate;
    private LocalTime usableStartTime;
    private LocalTime usableEndTime;
    private char useAvailable;
    private String etc;
    private Date regDate;
    private String firstIdNo;
    private Date modifyDate;
    private String lastIdNo;

    public CouponDto(String couponID) {
        this.couponID = couponID;
    }

    public CouponDto(String couponID, Integer couponNO, Date startUseDate, Date endUseDate, LocalTime usableStartTime, LocalTime usableEndTime) {
        this.couponID = couponID;
        this.couponNO = couponNO;
        this.startUseDate = startUseDate;
        this.endUseDate = endUseDate;
        this.usableStartTime = usableStartTime;
        this.usableEndTime = usableEndTime;
    }

    public CouponDto() {}

    public Integer getHistoryNO() {
        return historyNO;
    }

    public void setHistoryNO(Integer historyNO) {
        this.historyNO = historyNO;
    }

    public String getCouponID() {
        return couponID;
    }

    public void setCouponID(String couponID) {
        this.couponID = couponID;
    }

    public Integer getCouponNO() {
        return couponNO;
    }

    public void setCouponNO(Integer couponNO) {
        this.couponNO = couponNO;
    }

    public Date getStartUseDate() {
        return startUseDate;
    }

    public void setStartUseDate(Date startUseDate) {
        this.startUseDate = startUseDate;
    }

    public Date getEndUseDate() {
        return endUseDate;
    }

    public void setEndUseDate(Date endUseDate) {
        this.endUseDate = endUseDate;
    }

    public LocalTime getUsableStartTime() {
        return usableStartTime;
    }

    public void setUsableStartTime(LocalTime usableStartTime) {
        this.usableStartTime = usableStartTime;
    }

    public LocalTime getUsableEndTime() {
        return usableEndTime;
    }

    public void setUsableEndTime(LocalTime usableEndTime) {
        this.usableEndTime = usableEndTime;
    }

    public char getUseAvailable() {
        return useAvailable;
    }

    public void setUseAvailable(char useAvailable) {
        this.useAvailable = useAvailable;
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

    public String getFirstIdNo() {
        return firstIdNo;
    }

    public void setFirstIdNo(String firstIdNo) {
        this.firstIdNo = firstIdNo;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getLastIdNo() {
        return lastIdNo;
    }

    public void setLastIdNo(String lastIdNo) {
        this.lastIdNo = lastIdNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CouponDto)) return false;
        CouponDto couponDto = (CouponDto) o;
        return getUseAvailable() == couponDto.getUseAvailable() && Objects.equals(getHistoryNO(), couponDto.getHistoryNO()) && Objects.equals(getCouponID(), couponDto.getCouponID()) && Objects.equals(getCouponNO(), couponDto.getCouponNO()) && Objects.equals(getStartUseDate(), couponDto.getStartUseDate()) && Objects.equals(getEndUseDate(), couponDto.getEndUseDate()) && Objects.equals(getUsableStartTime(), couponDto.getUsableStartTime()) && Objects.equals(getUsableEndTime(), couponDto.getUsableEndTime()) && Objects.equals(getEtc(), couponDto.getEtc()) && Objects.equals(getRegDate(), couponDto.getRegDate()) && Objects.equals(getFirstIdNo(), couponDto.getFirstIdNo()) && Objects.equals(getModifyDate(), couponDto.getModifyDate()) && Objects.equals(getLastIdNo(), couponDto.getLastIdNo());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getHistoryNO(), getCouponID(), getCouponNO(), getStartUseDate(), getEndUseDate(), getUsableStartTime(), getUsableEndTime(), getUseAvailable(), getEtc(), getRegDate(), getFirstIdNo(), getModifyDate(), getLastIdNo());
    }

    @Override
    public String toString() {
        return "CouponDto{" +
                "historyNO=" + historyNO +
                ", couponID='" + couponID + '\'' +
                ", couponNO=" + couponNO +
                ", startUseDate=" + startUseDate +
                ", endUseDate=" + endUseDate +
                ", usableStartTime=" + usableStartTime +
                ", usableEndTime=" + usableEndTime +
                ", useAvailable=" + useAvailable +
                ", etc='" + etc + '\'' +
                ", regDate=" + regDate +
                ", firstIdNo='" + firstIdNo + '\'' +
                ", modifyDate=" + modifyDate +
                ", lastIdNo='" + lastIdNo + '\'' +
                '}';
    }
}