package com.jscd.app.lecture.seminar.domain;

import java.util.Date;
import java.util.Objects;

public class SeminarRegistDto {
    private Integer classEnrollNo; //강의 등록 고유번호
//    private Integer adminNo; // 관리자 고유 번호
    private String codeNum; // 과목 코드 번호
    private String title; // 강의 제목
    private String description; // 강의 소개
    private String name; // 강사명
    private String startDate; // 강의 시작일
    private String endDate; // 강의 종료일
    private String startTime; // 강의 시작 시간
    private String endTime; // 강의 종료 시간
    private Integer price; // 금액
    private String status; // 진행상태
    private String onOff; // 온라인/오프라인 여부
    private String location; // 강의 장소
    private Integer minNum; // 최소인원
    private Integer maxNum; // 최대인원
//    private Integer presentNum; // 현재인원
    private String book; // 교재
    private String material; // 준비물
    private String writer; // 작성자
    private Date regDate; // 최초 등록일시
//    private Date modifyDate; // 최종 수정일시
//    private String frsidNumbr; // 최초 등록자 식별 번호
//    private String lstidNmbr; // 최종 수정자 식별 번호
    private String etc; // 비고
    private int viewCnt; // 조회수

    public SeminarRegistDto(String codeNum, String title, String description, String name, String startDate,
                            String endDate, String startTime, String endTime, Integer price, String status,
                            String onOff, String location, Integer minNum, Integer maxNum, String book,
                            String material, String writer, String etc) {

        this.codeNum = codeNum;
        this.title = title;
        this.description = description;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.status = status;
        this.onOff = onOff;
        this.location = location;
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.book = book;
        this.material = material;
        this.writer = writer;
        this.etc = etc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SeminarRegistDto that = (SeminarRegistDto) o;
        return Objects.equals(classEnrollNo, that.classEnrollNo) && Objects.equals(codeNum, that.codeNum) && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(name, that.name) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(startTime, that.startTime) && Objects.equals(endTime, that.endTime) && Objects.equals(price, that.price) && Objects.equals(status, that.status) && Objects.equals(onOff, that.onOff) && Objects.equals(location, that.location) && Objects.equals(minNum, that.minNum) && Objects.equals(maxNum, that.maxNum) && Objects.equals(book, that.book) && Objects.equals(material, that.material) && Objects.equals(writer, that.writer) && Objects.equals(etc, that.etc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classEnrollNo, codeNum, title, description, name, startDate, endDate, startTime, endTime, price, status, onOff, location, minNum, maxNum, book, material, writer, etc);
    }

    @Override
    public String toString() {
        return "SeminarRegistDto{" +
                "classEnrollNo=" + classEnrollNo +
                ", codeNum=" + codeNum +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", startTime='" + startTime + '\'' +
                ", endTime='" + endTime + '\'' +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", onOff='" + onOff + '\'' +
                ", location='" + location + '\'' +
                ", minNum=" + minNum +
                ", maxNum=" + maxNum +
                ", book='" + book + '\'' +
                ", material='" + material + '\'' +
                ", writer='" + writer + '\'' +
                ", regDate=" + regDate +
                ", etc='" + etc + '\'' +
                ", viewCnt=" + viewCnt +
                '}';
    }

    public Integer getclassEnrollNo() {
        return classEnrollNo;
    }

    public void setclassEnrollNo(Integer classEnrollNo) {
        this.classEnrollNo = classEnrollNo;
    }

    public String getCodeNum() {
        return codeNum;
    }

    public void setCodeNum(String codeNum) {
        this.codeNum = codeNum;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public int getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(int viewCnt) {
        this.viewCnt = viewCnt;
    }
}
