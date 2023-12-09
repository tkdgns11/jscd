package com.jscd.app.board.qna.qnaDto;

public class AttachDto {

    int fileNo;
    int allqnaNo;
    String uploadPath;
    String fileName;
    String savePath;

    public AttachDto(){}

    public AttachDto(int fileNo, int allqnaNo, String uploadPath, String fileName, String savePath) {
        this.fileNo = fileNo;
        this.allqnaNo = allqnaNo;
        this.uploadPath = uploadPath;
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

    public String getUploadPath() {
        return uploadPath;
    }

    public void setUploadPath(String uploadPath) {
        this.uploadPath = uploadPath;
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
                ", uploadPath='" + uploadPath + '\'' +
                ", fileName='" + fileName + '\'' +
                ", savePath='" + savePath + '\'' +
                '}';
    }
}
