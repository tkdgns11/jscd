package com.jscd.app.board.qna.qnaDto;

public class QnActDto {

    private Integer qnaCtNo;
    private String name;
    private String expanation;
    private Integer regDate;
    private Integer frsidNmbr;
    private Integer modifyDate;
    private Integer lstidNmbr;
    private String etc;


    public QnActDto() {

    }

    public QnActDto(Integer qnaCtNo, String name, String expanation, Integer regDate, Integer frsidNmbr, Integer modifyDate, Integer lstidNmbr, String etc) {
        this.qnaCtNo = qnaCtNo;
        this.name = name;
        this.expanation = expanation;
        this.regDate = regDate;
        this.frsidNmbr = frsidNmbr;
        this.modifyDate = modifyDate;
        this.lstidNmbr = lstidNmbr;
        this.etc = etc;
    }

    public Integer getQnaCtNo() {
        return qnaCtNo;
    }

    public void setQnaCtNo(Integer qnaCtNo) {
        this.qnaCtNo = qnaCtNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getExpanation() {
        return expanation;
    }

    public void setExpanation(String expanation) {
        this.expanation = expanation;
    }

    public Integer getRegDate() {
        return regDate;
    }

    public void setRegDate(Integer regDate) {
        this.regDate = regDate;
    }

    public Integer getFrsidNmbr() {
        return frsidNmbr;
    }

    public void setFrsidNmbr(Integer frsidNmbr) {
        this.frsidNmbr = frsidNmbr;
    }

    public Integer getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Integer modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getLstidNmbr() {
        return lstidNmbr;
    }

    public void setLstidNmbr(Integer lstidNmbr) {
        this.lstidNmbr = lstidNmbr;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    @Override
    public String toString() {
        return "QnActDto{" +
                "qnaCtNo=" + qnaCtNo +
                ", name='" + name + '\'' +
                ", expanation='" + expanation + '\'' +
                ", regDate=" + regDate +
                ", frsidNmbr=" + frsidNmbr +
                ", modifyDate=" + modifyDate +
                ", lstidNmbr=" + lstidNmbr +
                ", etc='" + etc + '\'' +
                '}';
    }
}


