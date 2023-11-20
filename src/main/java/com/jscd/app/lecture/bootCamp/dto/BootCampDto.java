package com.jscd.app.lecture.bootCamp.dto;

import java.util.Date;
import java.util.Objects;

public class BootCampDto {
    private int classEnrollNo;  // 강의등록 고유번호
    private int adminNo;        // 관리자 고유번호
    private int codeNum;        // 과목 코드 번호
    private String title;       // 강의 제목
    private String description; // 강의 상세 설명
    private String name;        // 강사명
    private Date startDate;     // 강의 시작일
    private Date endDate;       // 강의 종료일
    private int price;          // 금액
    private String status;      // 진행상태
    private String onOff;       // 온/오프라인 여부
    private String location;    // 강의 장소
    private int minNum;         // 최소 인원
    private int maxNum;         // 최대 인원
    private int presentNum;     // 현재 인원
    private String book;        // 교재
    private String material;    // 준비물
    private String writer;      // 작성한 관리자
    private Date regDate;       // 준비물
    private String frsidNumbr;  // 강의 등록 최초 일자
    private Date modifyDate;    // 강의 수정 날짜

    private String lstidNumbr;

    private String etc;

    public BootCampDto() {}

    public BootCampDto(int classEnrollNo, int adminNo, int codeNum, String title, String description, String name, Date startDate, Date endDate, int price, String status, String onOff, String location, int minNum, int maxNum, int presentNum, String book, String material, String writer) {
        this.classEnrollNo = classEnrollNo;
        this.adminNo = adminNo;
        this.codeNum = codeNum;
        this.title = title;
        this.description = description;
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.price = price;
        this.status = status;
        this.onOff = onOff;
        this.location = location;
        this.minNum = minNum;
        this.maxNum = maxNum;
        this.presentNum = presentNum;
        this.book = book;
        this.material = material;
        this.writer = writer;
    }


    public int getClassEnrollNo() {
        return classEnrollNo;
    }

    public void setClassEnrollNo(int classEnrollNo) {
        this.classEnrollNo = classEnrollNo;
    }

    public int getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(int adminNo) {
        this.adminNo = adminNo;
    }

    public int getCodeNum() {
        return codeNum;
    }

    public void setCodeNum(int codeNum) {
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

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
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

    public int getMinNum() {
        return minNum;
    }

    public void setMinNum(int minNum) {
        this.minNum = minNum;
    }

    public int getMaxNum() {
        return maxNum;
    }

    public void setMaxNum(int maxNum) {
        this.maxNum = maxNum;
    }

    public int getPresentNum() {
        return presentNum;
    }

    public void setPresentNum(int presentNum) {
        this.presentNum = presentNum;
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

    public String getFrsidNumbr() {
        return frsidNumbr;
    }

    public void setFrsidNumbr(String frsidNumbr) {
        this.frsidNumbr = frsidNumbr;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getLstidNumbr() {
        return lstidNumbr;
    }

    public void setLstidNumbr(String lstidNumbr) {
        this.lstidNumbr = lstidNumbr;
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
        if (o == null || getClass() != o.getClass()) return false;
        BootCampDto that = (BootCampDto) o;
        return classEnrollNo == that.classEnrollNo && adminNo == that.adminNo && codeNum == that.codeNum && price == that.price && minNum == that.minNum && maxNum == that.maxNum && presentNum == that.presentNum && Objects.equals(title, that.title) && Objects.equals(description, that.description) && Objects.equals(name, that.name) && Objects.equals(startDate, that.startDate) && Objects.equals(endDate, that.endDate) && Objects.equals(status, that.status) && Objects.equals(onOff, that.onOff) && Objects.equals(location, that.location) && Objects.equals(book, that.book) && Objects.equals(material, that.material) && Objects.equals(writer, that.writer) && Objects.equals(regDate, that.regDate) && Objects.equals(frsidNumbr, that.frsidNumbr) && Objects.equals(modifyDate, that.modifyDate) && Objects.equals(lstidNumbr, that.lstidNumbr) && Objects.equals(etc, that.etc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(classEnrollNo, adminNo, codeNum, title, description, name, startDate, endDate, price, status, onOff, location, minNum, maxNum, presentNum, book, material, writer, regDate, frsidNumbr, modifyDate, lstidNumbr, etc);
    }

    @Override
    public String toString() {
        return "bootCampDto{" +
                "classEnrollNo=" + classEnrollNo +
                ", adminNo=" + adminNo +
                ", codeNum=" + codeNum +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", name='" + name + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", price=" + price +
                ", status='" + status + '\'' +
                ", onOff='" + onOff + '\'' +
                ", location='" + location + '\'' +
                ", minNum=" + minNum +
                ", maxNum=" + maxNum +
                ", presentNum=" + presentNum +
                ", book='" + book + '\'' +
                ", material='" + material + '\'' +
                ", writer='" + writer + '\'' +
                ", regDate=" + regDate +
                ", frsidNumbr='" + frsidNumbr + '\'' +
                ", modifyDate=" + modifyDate +
                ", lstidNumbr='" + lstidNumbr + '\'' +
                ", etc='" + etc + '\'' +
                '}';
    }
}
