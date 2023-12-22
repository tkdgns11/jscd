package com.jscd.app.lecture.lstRegist.dto;

public class LectureApplyDto {
    private String id;
    private Integer registCode;
    private Integer stdApplyNo;
    private String status;
    private String title;
    private String lastPrice;

    private Integer courseCode;
    private String startDate;
    private String endDate;
    private Integer odNo;
    private String regDate;
    private String payType;



    public LectureApplyDto() {
    }

    public LectureApplyDto(String id, Integer registCode, Integer stdApplyNo, String status, String title, String lastPrice, Integer courseCode, String startDate, String endDate, Integer odNo, String regDate, String payType) {
        this.id = id;
        this.registCode = registCode;
        this.stdApplyNo = stdApplyNo;
        this.status = status;
        this.title = title;
        this.lastPrice = lastPrice;
        this.courseCode = courseCode;
        this.startDate = startDate;
        this.endDate = endDate;
        this.odNo = odNo;
        this.regDate = regDate;
        this.payType = payType;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRegistCode() {
        return registCode;
    }

    public void setRegistCode(Integer registCode) {
        this.registCode = registCode;
    }

    public Integer getStdApplyNo() {
        return stdApplyNo;
    }

    public void setStdApplyNo(Integer stdApplyNo) {
        this.stdApplyNo = stdApplyNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(String lastPrice) {
        this.lastPrice = lastPrice;
    }

    public Integer getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(Integer courseCode) {
        this.courseCode = courseCode;
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

    public Integer getOdNo() {
        return odNo;
    }

    public void setOdNo(Integer odNo) {
        this.odNo = odNo;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    @Override
    public String toString() {
        return "LectureApplyDto{" +
                "id='" + id + '\'' +
                ", registCode=" + registCode +
                ", stdApplyNo=" + stdApplyNo +
                ", status='" + status + '\'' +
                ", title='" + title + '\'' +
                ", lastPrice='" + lastPrice + '\'' +
                ", courseCode=" + courseCode +
                ", startDate='" + startDate + '\'' +
                ", endDate='" + endDate + '\'' +
                ", odNo=" + odNo +
                ", regDate='" + regDate + '\'' +
                ", payType='" + payType + '\'' +
                '}';
    }
}
