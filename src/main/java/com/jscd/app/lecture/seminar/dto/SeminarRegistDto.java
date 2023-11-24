package com.jscd.app.lecture.seminar.dto;

import java.util.Date;
import java.util.Objects;

public class SeminarRegistDto {
    private Integer classEnrollNo; //강의 등록 고유번호
    private String title; // 강의 제목
    private String description; // 강의 상세 설명
    private String subjectName; // 과목 이름
    private String roundName; // 회차 이름
    private String onOff; // 온라인/오프라인 여부
    private String status; // 진행상태
    private String location; // 강의 장소
    private Integer minNum; // 최소인원
    private Integer maxNum; // 최대인원
    private Integer presentNum; // 현재인원
    private String startDate; // 강의 시작일
    private String endDate; // 강의 종료일
    private String startTime; // 강의 시작 시간
    private String endTime; // 강의 종료 시간
    private String name; // 강사명
    private String book; // 교재
    private String material; // 준비물
    private Integer price; // 금액
    private String discount; // 할인율
    private Integer lstPrice; // 최종 금액
    private String etc; // 비고
    private String writer; // 작성자
    private int viewCnt; // 조회수
    private Date regDate; // 최초 등록일시
    private Date modifyDate; // 최종 수정일시
    private String frsidNmbr; // 최초 등록자 식별 번호
    private String lstidNmbr; // 최종 수정자 식별 번호
    private Integer adminNo; // 관리자 고유 번호

    public SeminarRegistDto() {}
    public SeminarRegistDto(String title, String description, String subjectName, String roundName, String onOff, String status, String location, Integer minNum, Integer maxNum, Integer presentNum, String startDate, String endDate, String startTime, String endTime, String name, String book, String material, Integer price, String discount, Integer lstPrice, String etc, String writer, String frsidNmbr, String lstidNmbr, Integer adminNo) {
        this.title = title;
        this.description = description;
        this.subjectName = subjectName;
        this.roundName = roundName;
        this.onOff = onOff;
        this.status = status;
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
        this.frsidNmbr = frsidNmbr;
        this.lstidNmbr = lstidNmbr;
        this.adminNo = adminNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeminarRegistDto that = (SeminarRegistDto) o;
        return viewCnt == that.viewCnt && Objects.equals(classEnrollNo, that.classEnrollNo) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(subjectName, that.subjectName) && Objects.equals(roundName, that.roundName) && Objects.equals(onOff, that.onOff) && Objects.equals(status, that.status) && Objects.equals(location, that.location) && Objects.equals(minNum, that.minNum) && Objects.equals(maxNum, that.maxNum) && Objects.equals(presentNum, that.presentNum) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(name, that.name) && Objects.equals(book, that.book) && Objects.equals(material, that.material) && Objects.equals(price, that.price) && Objects.equals(discount, that.discount) && Objects.equals(lstPrice, that.lstPrice) && Objects.equals(etc, that.etc) && Objects.equals(writer, that.writer) && Objects.equals(regDate, that.regDate) && Objects.equals(modifyDate, that.modifyDate) && Objects.equals(frsidNmbr, that.frsidNmbr) && Objects.equals(lstidNmbr, that.lstidNmbr) && Objects.equals(adminNo, that.adminNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classEnrollNo, title, description, subjectName, roundName, onOff, status, location, minNum, maxNum, presentNum, startDate, endDate, startTime, endTime, name, book, material, price, discount, lstPrice, etc, writer, viewCnt, regDate, modifyDate, frsidNmbr, lstidNmbr, adminNo);
    }

    @Override
    public String toString() {
        return "SeminarRegistDto{" +
                "classEnrollNo=" + classEnrollNo +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", roundName='" + roundName + '\'' +
                ", onOff='" + onOff + '\'' +
                ", status='" + status + '\'' +
                ", location='" + location + '\'' +
                ", minNum=" + minNum +
                ", maxNum=" + maxNum +
                ", presentNum=" + presentNum +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public int getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(int viewCnt) {
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

    public String getfrsidNmbr() {
        return frsidNmbr;
    }

    public void setfrsidNmbr(String frsidNmbr) {
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
}
