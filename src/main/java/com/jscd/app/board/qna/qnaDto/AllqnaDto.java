package com.jscd.app.board.qna.qnaDto;

import java.util.Date;
import java.util.Objects;

public class AllqnaDto {
    private long allqnaNo;
    private int qnaCtNo;
    private int mebrNo;
    private String title;
    private String writer;
    private String content;
    private int hit;
    private String openYN;
    private Date regDate;
    private int frsidNmbr;
    private Date modifyDate;
    private int lstidNmbr;
    private String etc;

    public AllqnaDto() {

    }

    public AllqnaDto(long allqnaNo, int qnaCtNo, int mebrNo, String title, String writer, String content,
                     int hit, String openYN, Date regDate, int frsidNmbr, Date modifyDate, int lstidNmbr, String etc) {
        this.allqnaNo = allqnaNo;
        this.qnaCtNo = qnaCtNo;
        this.mebrNo = mebrNo;
        this.title = title;
        this.writer = writer;
        this.content = content;
        this.hit = hit;
        this.openYN = openYN;
        this.regDate = regDate;
        this.frsidNmbr = frsidNmbr;
        this.modifyDate = modifyDate;
        this.lstidNmbr = lstidNmbr;
        this.etc = etc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllqnaDto allqnaDto = (AllqnaDto) o;
        return allqnaNo == allqnaDto.allqnaNo && qnaCtNo == allqnaDto.qnaCtNo && mebrNo == allqnaDto.mebrNo && hit == allqnaDto.hit && frsidNmbr == allqnaDto.frsidNmbr && lstidNmbr == allqnaDto.lstidNmbr && title.equals(allqnaDto.title) && writer.equals(allqnaDto.writer) && content.equals(allqnaDto.content) && openYN.equals(allqnaDto.openYN) && regDate.equals(allqnaDto.regDate) && modifyDate.equals(allqnaDto.modifyDate) && Objects.equals(etc, allqnaDto.etc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allqnaNo, qnaCtNo, mebrNo, title, writer, content, hit, openYN, regDate, frsidNmbr, modifyDate, lstidNmbr, etc);
    }

    @Override
    public String toString() {
        return "allqnaDto{" +
                "allqnaNo=" + allqnaNo +
                ", qnaCtNo=" + qnaCtNo +
                ", mebrNo=" + mebrNo +
                ", title='" + title + '\'' +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", hit=" + hit +
                ", openYN='" + openYN + '\'' +
                ", regDate=" + regDate +
                ", frsidNmbr=" + frsidNmbr +
                ", modifyDate=" + modifyDate +
                ", lstidNmbr=" + lstidNmbr +
                ", etc='" + etc + '\'' +
                '}';
    }

    // Getter and Setter methods for each field
    public long getAllqnaNo() {
        return allqnaNo;
    }

    public void setAllqnaNo(long allqnaNo) {
        this.allqnaNo = allqnaNo;
    }

    public int getQnaCtNo() {
        return qnaCtNo;
    }

    public void setQnaCtNo(int qnaCtNo) {
        this.qnaCtNo = qnaCtNo;
    }

    public int getMebrNo() {
        return mebrNo;
    }

    public void setMebrNo(int mebrNo) {
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

    public int getHit() {
        return hit;
    }

    public void setHit(int hit) {
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

    public int getFrsidNmbr() {
        return frsidNmbr;
    }

    public void setFrsidNmbr(int frsidNmbr) {
        this.frsidNmbr = frsidNmbr;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public int getLstidNmbr() {
        return lstidNmbr;
    }

    public void setLstidNmbr(int lstidNmbr) {
        this.lstidNmbr = lstidNmbr;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }
}
