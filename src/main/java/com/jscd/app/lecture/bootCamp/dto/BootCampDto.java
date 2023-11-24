package com.jscd.app.lecture.bootCamp.dto;

import com.jscd.app.lecture.bootCamp.dto.BootCampDto;

import java.util.Date;
import java.util.Objects;

public class BootCampDto {
    private Integer classEnrollNo;
   private String title;
   private String description;
   private String subjectName;
   private String roundName;
   private String onOff;
   private String location;
   private Integer minNum;
   private Integer maxNum;
   private Integer presentNum;
   private Date startDate;
   private Date endDate;
   private String startTime;
   private String endTime;
   private String name;
   private String book;
   private String material;
   private Integer price;
   private String discount;
   private Integer lstPrice;
   private String etc;
   private String writer;
   private Integer viewCnt;
   private Date regDate;
   private Date modifyDate;
   private String frsidNmbr;
   private String lstidNmbr;
   private Integer adminNo;

    public BootCampDto() {}

    public BootCampDto(Integer classEnrollNo, String title, String description, String subjectName, String roundName, String onOff, String location, Integer minNum, Integer maxNum, Integer presentNum, Date startDate, Date endDate, String startTime, String endTime, String name, String book, String material, Integer price, String discount, Integer lstPrice, String etc, String writer, Integer viewCnt, Date regDate, Date modifyDate, String frsidNmbr, String lstidNmbr, Integer adminNo) {
        this.classEnrollNo = classEnrollNo;
        this.title = title;
        this.description = description;
        this.subjectName = subjectName;
        this.roundName = roundName;
        this.onOff = onOff;
        this.location = location;
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.presentNum = presentNum;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.name = name;
        this.book = book;
        this.material = material;
        this.price = price;
        this.discount = discount;
        this.lstPrice = lstPrice;
        this.etc = etc;
        this.writer = writer;
        this.viewCnt = viewCnt;
        this.regDate = regDate;
        this.modifyDate = modifyDate;
        this.frsidNmbr = frsidNmbr;
        this.lstidNmbr = lstidNmbr;
        this.adminNo = adminNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BootCampDto that = (BootCampDto) o;
        return Objects.equals(classEnrollNo, that.classEnrollNo) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(subjectName, that.subjectName) && Objects.equals(roundName, that.roundName) && Objects.equals(onOff, that.onOff) && Objects.equals(location, that.location) && Objects.equals(minNum, that.minNum) && Objects.equals(maxNum, that.maxNum) && Objects.equals(presentNum, that.presentNum) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(name, that.name) && Objects.equals(book, that.book) && Objects.equals(material, that.material) && Objects.equals(price, that.price) && Objects.equals(discount, that.discount) && Objects.equals(lstPrice, that.lstPrice) && Objects.equals(etc, that.etc) && Objects.equals(writer, that.writer) && Objects.equals(viewCnt, that.viewCnt) && Objects.equals(regDate, that.regDate) && Objects.equals(modifyDate, that.modifyDate) && Objects.equals(frsidNmbr, that.frsidNmbr) && Objects.equals(lstidNmbr, that.lstidNmbr) && Objects.equals(adminNo, that.adminNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classEnrollNo, title, description, subjectName, roundName, onOff, location, minNum, maxNum, presentNum, startDate, endDate, startTime, endTime, name, book, material, price, discount, lstPrice, etc, writer, viewCnt, regDate, modifyDate, frsidNmbr, lstidNmbr, adminNo);
    }

    public Integer getClassEnrollNo() {
        return classEnrollNo;
    }

    public void setClassEnrollNo(Integer classEnrollNo) {
        this.classEnrollNo = classEnrollNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getRoundName() {
        return roundName;
    }

    public void setRoundName(String roundName) {
        this.roundName = roundName;
    }

    public String getOnOff() {
        return onOff;
    }

    public void setOnOff(String onOff) {
        this.onOff = onOff;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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

    public Integer getPresentNum() {
        return presentNum;
    }

    public void setPresentNum(Integer presentNum) {
        this.presentNum = presentNum;
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

    public String getStartTime() {
        return startTime;
    }

    public void setStartTime(String startTime) {
        this.startTime = startTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Integer getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(Integer viewCnt) {
        this.viewCnt = viewCnt;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getFrsidNmbr() {
        return frsidNmbr;
    }

    public void setFrsidNmbr(String frsidNmbr) {
        this.frsidNmbr = frsidNmbr;
    }

    public String getLstidNmbr() {
        return lstidNmbr;
    }

    public void setLstidNmbr(String lstidNmbr) {
        this.lstidNmbr = lstidNmbr;
    }

    public Integer getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(Integer adminNo) {
        this.adminNo = adminNo;
    }

    @Override
    public String toString() {
        return "BootCampDto{" +
                "classEnrollNo=" + classEnrollNo +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", roundName='" + roundName + '\'' +
                ", onOff='" + onOff + '\'' +
                ", location='" + location + '\'' +
                ", minNum=" + minNum +
                ", maxNum=" + maxNum +
                ", presentNum=" + presentNum +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", name='" + name + '\'' +
                ", book='" + book + '\'' +
                ", material='" + material + '\'' +
                ", price=" + price +
                ", discount='" + discount + '\'' +
                ", lstPrice=" + lstPrice +
                ", etc='" + etc + '\'' +
                ", writer='" + writer + '\'' +
                ", viewCnt=" + viewCnt +
                ", regDate=" + regDate +
                ", modifyDate=" + modifyDate +
                ", frsidNmbr='" + frsidNmbr + '\'' +
                ", lstidNmbr='" + lstidNmbr + '\'' +
                ", adminNo=" + adminNo +
                '}';
    }
}
