package com.jscd.app.board.qna.qnaDto;

import java.util.Date;
import java.util.Objects;

public class AllqnaDto {

    private Integer allqnaNo; //게시글 번호
    private Integer allqnaCmtNo; //댓글 번호 (조회수)
    private Integer allqnaCmtNum;// 댓글 Pk

    private Integer allqnaCmtReplyNo; //대댓글 번호
    private Integer qnaCtNo; //카테고리 번호
    private Integer mebrNo; //회원 번호
    private String title; //게시글 제목
    private String writer; //게시글 작성자
    private String content; //게시글 내용
    private String cmtWriter; //댓글 작성자
    private String cmtContent; //댓글 내용

    private Integer hit; //게시글 조회수
    private String openYN;
    private Date regDate;
    private Date cmtRegDate; //댓글 번호
    private Integer firstIdNo;
    private Date modifyDate;
    private Integer lastIdNo;
    private String etc;

    public AllqnaDto() {
    }

    public AllqnaDto(Integer allqnaNo, Integer allqnaCmtNo, Integer allqnaCmtNum, Integer allqnaCmtReplyNo, Integer qnaCtNo, Integer mebrNo, String title, String writer, String content, String cmtWriter, String cmtContent, Integer hit, String openYN, Date regDate, Date cmtRegDate, Integer firstIdNo, Date modifyDate, Integer lastIdNo, String etc) {
        this.allqnaNo = allqnaNo;
        this.allqnaCmtNo = allqnaCmtNo;
        this.allqnaCmtNum = allqnaCmtNum;
        this.allqnaCmtReplyNo = allqnaCmtReplyNo;
        this.qnaCtNo = qnaCtNo;
        this.mebrNo = mebrNo;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.cmtWriter = cmtWriter;
        this.cmtContent = cmtContent;
        this.hit = hit;
        this.openYN = openYN;
        this.regDate = regDate;
        this.cmtRegDate = cmtRegDate;
        this.firstIdNo = firstIdNo;
        this.modifyDate = modifyDate;
        this.lastIdNo = lastIdNo;
        this.etc = etc;
    }


    public Integer getAllqnaNo() {
        return allqnaNo;
    }

    public void setAllqnaNo(Integer allqnaNo) {
        this.allqnaNo = allqnaNo;
    }

    public Integer getAllqnaCmtNo() {
        return allqnaCmtNo;
    }

    public void setAllqnaCmtNo(Integer allqnaCmtNo) {
        this.allqnaCmtNo = allqnaCmtNo;
    }

    public Integer getAllqnaCmtNum() {
        return allqnaCmtNum;
    }

    public void setAllqnaCmtNum(Integer allqnaCmtNum) {
        this.allqnaCmtNum = allqnaCmtNum;
    }

    public Integer getAllqnaCmtReplyNo() {
        return allqnaCmtReplyNo;
    }

    public void setAllqnaCmtReplyNo(Integer allqnaCmtReplyNo) {
        this.allqnaCmtReplyNo = allqnaCmtReplyNo;
    }

    public Integer getQnaCtNo() {
        return qnaCtNo;
    }

    public void setQnaCtNo(Integer qnaCtNo) {
        this.qnaCtNo = qnaCtNo;
    }

    public Integer getMebrNo() {
        return mebrNo;
    }

    public void setMebrNo(Integer mebrNo) {
        this.mebrNo = mebrNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCmtWriter() {
        return cmtWriter;
    }

    public void setCmtWriter(String cmtWriter) {
        this.cmtWriter = cmtWriter;
    }

    public String getCmtContent() {
        return cmtContent;
    }

    public void setCmtContent(String cmtContent) {
        this.cmtContent = cmtContent;
    }

    public Integer getHit() {
        return hit;
    }

    public void setHit(Integer hit) {
        this.hit = hit;
    }

    public String getOpenYN() {
        return openYN;
    }

    public void setOpenYN(String openYN) {
        this.openYN = openYN;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getCmtRegDate() {
        return cmtRegDate;
    }

    public void setCmtRegDate(Date cmtRegDate) {
        this.cmtRegDate = cmtRegDate;
    }

    public Integer getFirstIdNo() {
        return firstIdNo;
    }

    public void setFirstIdNo(Integer firstIdNo) {
        this.firstIdNo = firstIdNo;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getLastIdNo() {
        return lastIdNo;
    }

    public void setLastIdNo(Integer lastIdNo) {
        this.lastIdNo = lastIdNo;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    @Override
    public String toString() {
        return "AllqnaDto{" +
                "allqnaNo=" + allqnaNo +
                ", allqnaCmtNo=" + allqnaCmtNo +
                ", allqnaCmtNum=" + allqnaCmtNum +
                ", allqnaCmtReplyNo=" + allqnaCmtReplyNo +
                ", qnaCtNo=" + qnaCtNo +
                ", mebrNo=" + mebrNo +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", cmtWriter='" + cmtWriter + '\'' +
                ", cmtContent='" + cmtContent + '\'' +
                ", hit=" + hit +
                ", openYN='" + openYN + '\'' +
                ", regDate=" + regDate +
                ", cmtRegDate=" + cmtRegDate +
                ", firstIdNo=" + firstIdNo +
                ", modifyDate=" + modifyDate +
                ", lastIdNo=" + lastIdNo +
                ", etc='" + etc + '\'' +
                '}';
    }
}
