package com.jscd.app.lecture.classEnroll.dto;

import java.util.Date;
import java.util.Objects;

public class ClassEnrollDto {
    private Integer classCode;
    private Integer courseCode;
    private Integer roundCode;
    private String className;
    private String category;
    private String content;
    private Integer price;
//    private String discount;
//    private Integer lstPrice;
    private Date regDate;
    private Integer firstIdNO;
    private Date modifyDate;
    private Integer lastIdNO;
    private String etc;

    public ClassEnrollDto() {}

    public ClassEnrollDto(Integer classCode, Integer courseCode, Integer roundCode, String className, String category, String content, Integer price, Date regDate, Integer firstIdNO, Date modifyDate, Integer lastIdNO, String etc) {
        this.classCode = classCode;
        this.courseCode = courseCode;
        this.roundCode = roundCode;
        this.className = className;
        this.category = category;
        this.content = content;
        this.price = price;
        this.regDate = regDate;
        this.firstIdNO = firstIdNO;
        this.modifyDate = modifyDate;
        this.lastIdNO = lastIdNO;
        this.etc = etc;
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

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Integer getFirstIdNO() {
        return firstIdNO;
    }

    public void setFirstIdNO(Integer firstIdNO) {
        this.firstIdNO = firstIdNO;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getLastIdNO() {
        return lastIdNO;
    }

    public void setLastIdNO(Integer lastIdNO) {
        this.lastIdNO = lastIdNO;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    @Override
    public String toString() {
        return "ClassEnrollDto{" +
                "classCode=" + classCode +
                ", courseCode=" + courseCode +
                ", roundCode=" + roundCode +
                ", className='" + className + '\'' +
                ", category='" + category + '\'' +
                ", content='" + content + '\'' +
                ", price=" + price +
                ", regDate=" + regDate +
                ", firstIdNO=" + firstIdNO +
                ", modifyDate=" + modifyDate +
                ", lastIdNO=" + lastIdNO +
                ", etc='" + etc + '\'' +
                '}';
    }
}
