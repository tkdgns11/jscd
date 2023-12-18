package com.jscd.app.lecture.lstRegist.dto;

public class lstregistfileDto {
    private Integer fileNo;
    private Integer registCode;
    private String originFileName;
    private String storedFileName;
    private String fileSize;

    // 세미나 리스트에서 필요한 lstregist 컬럼
    private String status;
    private String title;

    public lstregistfileDto() {
    }

    public lstregistfileDto(Integer fileNo, Integer registCode, String originFileName, String storedFileName, String fileSize, String status, String title) {
        this.fileNo = fileNo;
        this.registCode = registCode;
        this.originFileName = originFileName;
        this.storedFileName = storedFileName;
        this.fileSize = fileSize;
        this.status = status;
        this.title = title;
    }

    public Integer getFileNo() {
        return fileNo;
    }

    public void setFileNo(Integer fileNo) {
        this.fileNo = fileNo;
    }

    public Integer getRegistCode() {
        return registCode;
    }

    public void setRegistCode(Integer registCode) {
        this.registCode = registCode;
    }

    public String getOriginFileName() {
        return originFileName;
    }

    public void setOriginFileName(String originFileName) {
        this.originFileName = originFileName;
    }

    public String getStoredFileName() {
        return storedFileName;
    }

    public void setStoredFileName(String storedFileName) {
        this.storedFileName = storedFileName;
    }

    public String getFileSize() {
        return fileSize;
    }

    public void setFileSize(String fileSize) {
        this.fileSize = fileSize;
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

    @Override
    public String toString() {
        return "lstregistfileDto{" +
                "fileNo=" + fileNo +
                ", registCode=" + registCode +
                ", originFileName='" + originFileName + '\'' +
                ", storedFileName='" + storedFileName + '\'' +
                ", fileSize='" + fileSize + '\'' +
                ", status='" + status + '\'' +
                ", title='" + title + '\'' +
                '}';
    }
}
