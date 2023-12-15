package com.jscd.app.board.qna.qnaDto;

public class AttachDto {

    int fileNo; //파일 고유 번호
    int allqnaNo; //qna 번호
    int registCode; // registCode 번호
    String uploadPath; //업로드 파일명
    String uuid;    // uuid
    String fileName; //실제 파일명
    String savePath; // 로컬 저장 경로

    public AttachDto() {
    }

    public AttachDto(int fileNo, int allqnaNo, int registCode, String uploadPath, String uuid, String fileName, String savePath) {
        this.fileNo = fileNo;
        this.allqnaNo = allqnaNo;
        this.registCode = registCode;
        this.uploadPath = uploadPath;
        this.uuid = uuid;
        this.fileName = fileName;
        this.savePath = savePath;
    }

    public int getFileNo() {
        return fileNo;
    }

    public void setFileNo(int fileNo) {
        this.fileNo = fileNo;
    }

    public int getAllqnaNo() {
        return allqnaNo;
    }

    public void setAllqnaNo(int allqnaNo) {
        this.allqnaNo = allqnaNo;
    }

    public int getRegistCode() {
        return registCode;
    }

    public void setRegistCode(int registCode) {
        this.registCode = registCode;
    }

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
    }

    public String getUuid() {
        return uuid;
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getSavePath() {
        return savePath;
    }

    public void setSavePath(String savePath) {
        this.savePath = savePath;
    }

    @Override
    public String toString() {
        return "AttachDto{" +
                "fileNo=" + fileNo +
                ", allqnaNo=" + allqnaNo +
                ", registCode=" + registCode +
                ", uploadPath='" + uploadPath + '\'' +
                ", uuid='" + uuid + '\'' +
                ", fileName='" + fileName + '\'' +
                ", savePath='" + savePath + '\'' +
                '}';
    }
}
