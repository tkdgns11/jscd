package com.jscd.app.lecture.lstRegist.dto;

import java.util.Date;
import java.util.Objects;

public class LstRegistDto {
    private Integer registCode;
    private String title;
    private String discription;
    private Integer courseCode;
    private String subject1;
    private String subject2;
    private String subject3;
    private String subject4;
    private String subject5;

    private Integer price1;
    private Integer price2;
    private Integer price3;
    private Integer price4;
    private Integer price5;

    private String onOff;
    private String status;
    private Integer minNum;
    private Integer maxNum;
    private String location;
    private Integer currentNum;

    private String startDate;
    private String endDate;
    private String book;
    private String material;


    private Integer totalPrice;
    private String discount;
    private Integer lastPrice;
    private String content;

    private String regDate;
    private Integer firstIdNo;
    private String modifyDate;
    private Integer lastIdNo;
    private String etc;
    private String courseName;

    //파일 첨부
/*    private Integer fileNo;
    private String originFileName;
    private String storedFileName;
    private String fileSize;

    private String file;

    private String fileName;

    private String attachedFile;*/

    public LstRegistDto() {
    }

    public LstRegistDto(Integer registCode, String title, String discription, Integer courseCode, String subject1, String subject2, String subject3, String subject4, String subject5, Integer price1, Integer price2, Integer price3, Integer price4, Integer price5, String onOff, String status, Integer minNum, Integer maxNum, String location, Integer currentNum, String startDate, String endDate, String book, String material, Integer totalPrice, String discount, Integer lastPrice, String content, String regDate, Integer firstIdNo, String modifyDate, Integer lastIdNo, String etc, String courseName) {
        this.registCode = registCode;
        this.title = title;
        this.discription = discription;
        this.courseCode = courseCode;
        this.subject1 = subject1;
        this.subject2 = subject2;
        this.subject3 = subject3;
        this.subject4 = subject4;
        this.subject5 = subject5;
        this.price1 = price1;
        this.price2 = price2;
        this.price3 = price3;
        this.price4 = price4;
        this.price5 = price5;
        this.onOff = onOff;
        this.status = status;
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.location = location;
        this.currentNum = currentNum;
        this.startDate = startDate;
        this.endDate = endDate;
        this.book = book;
        this.material = material;
        this.totalPrice = totalPrice;
        this.discount = discount;
        this.lastPrice = lastPrice;
        this.content = content;
        this.regDate = regDate;
        this.firstIdNo = firstIdNo;
        this.modifyDate = modifyDate;
        this.lastIdNo = lastIdNo;
        this.etc = etc;
        this.courseName = courseName;
    }

    public Integer getRegistCode() {
        return registCode;
    }

    public void setRegistCode(Integer registCode) {
        this.registCode = registCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDiscription() {
        return discription;
    }

    public void setDiscription(String discription) {
        this.discription = discription;
    }

    public Integer getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(Integer courseCode) {
        this.courseCode = courseCode;
    }

    public String getSubject1() {
        return subject1;
    }

    public void setSubject1(String subject1) {
        this.subject1 = subject1;
    }

    public String getSubject2() {
        return subject2;
    }

    public void setSubject2(String subject2) {
        this.subject2 = subject2;
    }

    public String getSubject3() {
        return subject3;
    }

    public void setSubject3(String subject3) {
        this.subject3 = subject3;
    }

    public String getSubject4() {
        return subject4;
    }

    public void setSubject4(String subject4) {
        this.subject4 = subject4;
    }

    public String getSubject5() {
        return subject5;
    }

    public void setSubject5(String subject5) {
        this.subject5 = subject5;
    }

    public Integer getPrice1() {
        return price1;
    }

    public void setPrice1(Integer price1) {
        this.price1 = price1;
    }

    public Integer getPrice2() {
        return price2;
    }

    public void setPrice2(Integer price2) {
        this.price2 = price2;
    }

    public Integer getPrice3() {
        return price3;
    }

    public void setPrice3(Integer price3) {
        this.price3 = price3;
    }

    public Integer getPrice4() {
        return price4;
    }

    public void setPrice4(Integer price4) {
        this.price4 = price4;
    }

    public Integer getPrice5() {
        return price5;
    }

    public void setPrice5(Integer price5) {
        this.price5 = price5;
    }

    public String getOnOff() {
        return onOff;
    }

    public void setOnOff(String onOff) {
        this.onOff = onOff;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Integer getMinNum() {
        return minNum;
    }

    public void setMinNum(Integer minNum) {
        this.minNum = minNum;
    }

    public Integer getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(Integer maxNum) {
        this.maxNum = maxNum;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Integer getCurrentNum() {
        return currentNum;
    }

    public void setCurrentNum(Integer currentNum) {
        this.currentNum = currentNum;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    public String getBook() {
        return book;
    }

    public void setBook(String book) {
        this.book = book;
    }

    public String getMaterial() {
        return material;
    }

    public void setMaterial(String material) {
        this.material = material;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getDiscount() {
        return discount;
    }

    public void setDiscount(String discount) {
        this.discount = discount;
    }

    public Integer getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Integer lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public Integer getFirstIdNo() {
        return firstIdNo;
    }

    public void setFirstIdNo(Integer firstIdNo) {
        this.firstIdNo = firstIdNo;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
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

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return "LstRegistDto{" +
                "registCode=" + registCode +
                ", title='" + title + '\'' +
                ", discription='" + discription + '\'' +
                ", courseCode=" + courseCode +
                ", subject1='" + subject1 + '\'' +
                ", subject2='" + subject2 + '\'' +
                ", subject3='" + subject3 + '\'' +
                ", subject4='" + subject4 + '\'' +
                ", subject5='" + subject5 + '\'' +
                ", price1=" + price1 +
                ", price2=" + price2 +
                ", price3=" + price3 +
                ", price4=" + price4 +
                ", price5=" + price5 +
                ", onOff='" + onOff + '\'' +
                ", status='" + status + '\'' +
                ", minNum=" + minNum +
                ", maxNum=" + maxNum +
                ", location='" + location + '\'' +
                ", currentNum=" + currentNum +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", book='" + book + '\'' +
                ", material='" + material + '\'' +
                ", totalPrice=" + totalPrice +
                ", discount='" + discount + '\'' +
                ", lastPrice=" + lastPrice +
                ", content='" + content + '\'' +
                ", regDate=" + regDate +
                ", firstIdNo=" + firstIdNo +
                ", modifyDate='" + modifyDate + '\'' +
                ", lastIdNo=" + lastIdNo +
                ", etc='" + etc + '\'' +
                ", courseName='" + courseName + '\'' +
                '}';
    }
}
