package com.jscd.app.board.qna.qnaDto;

import java.util.Date;
import java.util.Objects;

public class AllqnacDto {

    private Integer allqnaCNo;
    private Integer allqnaNo;
    private String writer;
    private String content;
    private Date regDate;
    private Date frsidNmbr;
    private Date modifyDate;
    private Date lsticNmbr;
    private String etc;

    public AllqnacDto() {
    }

    public AllqnacDto(Integer allqnaCNo, Integer allqnaNo, String writer, String content, Date regDate, Date frsidNmbr, Date modifyDate, Date lsticNmbr, String etc) {
        this.allqnaCNo = allqnaCNo;
        this.allqnaNo = allqnaNo;
        this.writer = writer;
        this.content = content;
        this.regDate = regDate;
        this.frsidNmbr = frsidNmbr;
        this.modifyDate = modifyDate;
        this.lsticNmbr = lsticNmbr;
        this.etc = etc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AllqnacDto that = (AllqnacDto) o;
        return allqnaCNo == that.allqnaCNo && allqnaNo == that.allqnaNo && Objects.equals(writer, that.writer) && Objects.equals(content, that.content) && Objects.equals(regDate, that.regDate) && Objects.equals(frsidNmbr, that.frsidNmbr) && Objects.equals(modifyDate, that.modifyDate) && Objects.equals(lsticNmbr, that.lsticNmbr) && Objects.equals(etc, that.etc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(allqnaCNo, allqnaNo, writer, content, regDate, frsidNmbr, modifyDate, lsticNmbr, etc);
    }

    @Override
    public String toString() {
        return "allqnacDto{" +
                "allqnaCNo=" + allqnaCNo +
                ", allqnaNo=" + allqnaNo +
                ", writer='" + writer + '\'' +
                ", content='" + content + '\'' +
                ", regDate=" + regDate +
                ", frsidNmbr=" + frsidNmbr +
                ", modifyDate=" + modifyDate +
                ", lsticNmbr=" + lsticNmbr +
                ", etc='" + etc + '\'' +
                '}';
    }

    //    public AllqnaDto getAllqnaCNo() {
//        return allqnaCNo;
//    }
    public Integer getAllqnaCNo() {
        return allqnaCNo;
    }

    public void setAllqnaCNo(Integer allqnaCNo) {
        this.allqnaCNo = allqnaCNo;
    }

    public Integer getAllqnaNo() {
        return allqnaNo;
    }

    public void setAllqnaNo(Integer allqnaNo) {
        this.allqnaNo = allqnaNo;
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

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getFrsidNmbr() {
        return frsidNmbr;
    }

    public void setFrsidNmbr(Date frsidNmbr) {
        this.frsidNmbr = frsidNmbr;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Date getLsticNmbr() {
        return lsticNmbr;
    }

    public void setLsticNmbr(Date lsticNmbr) {
        this.lsticNmbr = lsticNmbr;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }
}