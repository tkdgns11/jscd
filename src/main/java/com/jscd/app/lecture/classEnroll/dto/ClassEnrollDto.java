package com.jscd.app.lecture.classEnroll.dto;

import java.util.Date;
import java.util.Objects;

public class ClassEnrollDto {
    private Integer classCode;
    private Integer courseCode;
    private Integer roundCode;
    private String className;
    private Integer price;
    private String discount;
    private Integer lstPrice;
    private Date regDate;
    private Integer firstIdNo;
    private Date modifyDate;
    private Integer lastIdNo;
    private String etc;

    public ClassEnrollDto() {}

    public ClassEnrollDto(Integer courseCode, Integer roundCode, String className, Integer price, String discount, Integer lstPrice, Date regDate, Integer firstIdNo, Integer lastIdNo, String etc) {
        this.courseCode = courseCode;
        this.roundCode = roundCode;
        this.className = className;
        this.price = price;
        this.discount = discount;
        this.lstPrice = lstPrice;
        this.regDate = regDate;
        this.firstIdNo = firstIdNo;
        this.lastIdNo = lastIdNo;
        this.etc = etc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClassEnrollDto that = (ClassEnrollDto) o;
        return Objects.equals(classCode, that.classCode) && Objects.equals(courseCode, that.courseCode) && Objects.equals(roundCode, that.roundCode) && Objects.equals(className, that.className) && Objects.equals(price, that.price) && Objects.equals(discount, that.discount) && Objects.equals(lstPrice, that.lstPrice) && Objects.equals(regDate, that.regDate) && Objects.equals(firstIdNo, that.firstIdNo) && Objects.equals(modifyDate, that.modifyDate) && Objects.equals(lastIdNo, that.lastIdNo) && Objects.equals(etc, that.etc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classCode, courseCode, roundCode, className, price, discount, lstPrice, regDate, firstIdNo, modifyDate, lastIdNo, etc);
    }

    @Override
    public String toString() {
        return "ClassEnrollDto{" +
                "classCode=" + classCode +
                ", courseCode=" + courseCode +
                ", roundCode=" + roundCode +
                ", className='" + className + '\'' +
                ", price=" + price +
                ", discount='" + discount + '\'' +
                ", lstPrice=" + lstPrice +
                ", regDate='" + regDate + '\'' +
                ", firstIdNo=" + firstIdNo +
                ", modifyDate='" + modifyDate + '\'' +
                ", lastIdNo=" + lastIdNo +
                ", etc='" + etc + '\'' +
                '}';
    }

    public Integer getClassCode() {
        return classCode;
    }

    public void setClassCode(Integer classCode) {
        this.classCode = classCode;
    }

    public Integer getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(Integer courseCode) {
        this.courseCode = courseCode;
    }

    public Integer getRoundCode() {
        return roundCode;
    }

    public void setRoundCode(Integer roundCode) {
        this.roundCode = roundCode;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Integer getLstPrice() {
        return lstPrice;
    }

    public void setLstPrice(Integer lstPrice) {
        this.lstPrice = lstPrice;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Integer getFirstIdNo() {
        return firstIdNo;
    }

    public void setFirstIdNo(Integer firstIdNo) {
        this.firstIdNo = firstIdNo;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getLastIdNo() {
        return lastIdNo;
    }

    public void setLastIdNo(Integer lastIdNo) {
        this.lastIdNo = lastIdNo;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }
}
