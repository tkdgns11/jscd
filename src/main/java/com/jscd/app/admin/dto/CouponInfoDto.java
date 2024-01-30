package com.jscd.app.admin.dto;

import java.util.Date;
import java.util.Objects;

public class CouponInfoDto {

    private Integer couponNO;
    private String name;
    private String description;
    private Integer maxIssueNO;
    private Integer maxPerMebr;
    private Integer maxPerUse;
    private Integer validityPeriodIssue;
    private String specialNotes;
    private char isAvailable;
    private Integer historyNO ;
    private Date regDate;
    private String firstIdNO;
    private Date modifyDate;
    private String lastIdNO;
    private String etc;

    public CouponInfoDto() {}

    public CouponInfoDto(Integer couponNO, String name) {
        this.couponNO = couponNO;
        this.name = name;
    }

    public Integer getCouponNO() {
        return couponNO;
    }

    public void setCouponNO(Integer couponNO) {
        this.couponNO = couponNO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getMaxIssueNO() {
        return maxIssueNO;
    }

    public void setMaxIssueNO(Integer maxIssueNO) {
        this.maxIssueNO = maxIssueNO;
    }

    public Integer getMaxPerMebr() {
        return maxPerMebr;
    }

    public void setMaxPerMebr(Integer maxPerMebr) {
        this.maxPerMebr = maxPerMebr;
    }

    public Integer getMaxPerUse() {
        return maxPerUse;
    }

    public void setMaxPerUse(Integer maxPerUse) {
        this.maxPerUse = maxPerUse;
    }

    public Integer getValidityPeriodIssue() {
        return validityPeriodIssue;
    }

    public void setValidityPeriodIssue(Integer validityPeriodIssue) {
        this.validityPeriodIssue = validityPeriodIssue;
    }

    public String getSpecialNotes() {
        return specialNotes;
    }

    public void setSpecialNotes(String specialNotes) {
        this.specialNotes = specialNotes;
    }

    public char getIsAvailable() {
        return isAvailable;
    }

    public void setIsAvailable(char isAvailable) {
        this.isAvailable = isAvailable;
    }

    public Integer getHistoryNO() {
        return historyNO;
    }

    public void setHistoryNO(Integer historyNO) {
        this.historyNO = historyNO;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CouponInfoDto)) return false;
        CouponInfoDto that = (CouponInfoDto) o;
        return getIsAvailable() == that.getIsAvailable() && Objects.equals(getCouponNO(), that.getCouponNO()) && Objects.equals(getName(), that.getName()) && Objects.equals(getDescription(), that.getDescription()) && Objects.equals(getMaxIssueNO(), that.getMaxIssueNO()) && Objects.equals(getMaxPerMebr(), that.getMaxPerMebr()) && Objects.equals(getMaxPerUse(), that.getMaxPerUse()) && Objects.equals(getValidityPeriodIssue(), that.getValidityPeriodIssue()) && Objects.equals(getSpecialNotes(), that.getSpecialNotes()) && Objects.equals(getHistoryNO(), that.getHistoryNO()) && Objects.equals(getRegDate(), that.getRegDate()) && Objects.equals(getFirstIdNO(), that.getFirstIdNO()) && Objects.equals(getModifyDate(), that.getModifyDate()) && Objects.equals(getLastIdNO(), that.getLastIdNO()) && Objects.equals(getEtc(), that.getEtc());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCouponNO(), getName(), getDescription(), getMaxIssueNO(), getMaxPerMebr(), getMaxPerUse(), getValidityPeriodIssue(), getSpecialNotes(), getIsAvailable(), getHistoryNO(), getRegDate(), getFirstIdNO(), getModifyDate(), getLastIdNO(), getEtc());
    }

    @Override
    public String toString() {
        return "CouponInfoDto{" +
                "couponNO=" + couponNO +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", maxIssueNO=" + maxIssueNO +
                ", maxPerMebr=" + maxPerMebr +
                ", maxPerUse=" + maxPerUse +
                ", validityPeriodIssue=" + validityPeriodIssue +
                ", specialNotes='" + specialNotes + '\'' +
                ", isAvailable=" + isAvailable +
                ", historyNO=" + historyNO +
                ", regDate=" + regDate +
                ", firstIdNO='" + firstIdNO + '\'' +
                ", modifyDate=" + modifyDate +
                ", lastIdNO='" + lastIdNO + '\'' +
                ", etc='" + etc + '\'' +
                '}';
    }
}