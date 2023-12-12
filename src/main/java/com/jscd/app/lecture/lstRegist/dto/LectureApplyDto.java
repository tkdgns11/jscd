package com.jscd.app.lecture.lstRegist.dto;

public class LectureApplyDto {
    private String id;
    private Integer registCode;
    private Integer stdApplyNo;
    private String status;
    private String title;
    private String lastPrice;

    public LectureApplyDto() {
    }

    public LectureApplyDto(String id, Integer registCode, Integer stdApplyNo, String status, String title, String lastPrice) {
        this.id = id;
        this.registCode = registCode;
        this.stdApplyNo = stdApplyNo;
        this.status = status;
        this.title = title;
        this.lastPrice = lastPrice;
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

    @Override
    public String toString() {
        return "lectureApplyDto{" +
                "id='" + id + '\'' +
                ", registCode=" + registCode +
                ", stdApplyNo=" + stdApplyNo +
                ", status='" + status + '\'' +
                ", title='" + title + '\'' +
                ", lastPrice='" + lastPrice + '\'' +
                '}';
    }
}
