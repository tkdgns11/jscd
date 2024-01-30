package com.jscd.app.order.dto;

import java.sql.Date;

public class CompanyInfoDTO {
    private int slrNo;
    private String slrName;
    private String slrNum;
    private String actName;
    private String actNum;
    private String slrAddr;
    private String slrMail;
    private String companyName;
    private String indst;
    private String kind;
    private String slrPhone;
    private Date regDate;
    private int firstIdNO;
    private Date modifyDate;
    private int lastIdNO;
    private String etc;

    public CompanyInfoDTO(){}

    public CompanyInfoDTO(int slrNo, String slrName, String slrNum, String actName, String actNum, String slrAddr, String slrMail, String companyName, String indst, String kind, String slrPhone, Date regDate, int firstIdNO, Date modifyDate, int lastIdNO, String etc) {
        this.slrNo = slrNo;
        this.slrName = slrName;
        this.slrNum = slrNum;
        this.actName = actName;
        this.actNum = actNum;
        this.slrAddr = slrAddr;
        this.slrMail = slrMail;
        this.companyName = companyName;
        this.indst = indst;
        this.kind = kind;
        this.slrPhone = slrPhone;
        this.regDate = regDate;
        this.firstIdNO = firstIdNO;
        this.modifyDate = modifyDate;
        this.lastIdNO = lastIdNO;
        this.etc = etc;
    }

    public int getSlrNo() {
        return slrNo;
    }

    public void setSlrNo(int slrNo) {
        this.slrNo = slrNo;
    }

    public String getSlrName() {
        return slrName;
    }

    public void setSlrName(String slrName) {
        this.slrName = slrName;
    }

    public String getSlrNum() {
        return slrNum;
    }

    public void setSlrNum(String slrNum) {
        this.slrNum = slrNum;
    }

    public String getActName() {
        return actName;
    }

    public void setActName(String actName) {
        this.actName = actName;
    }

    public String getActNum() {
        return actNum;
    }

    public void setActNum(String actNum) {
        this.actNum = actNum;
    }

    public String getSlrAddr() {
        return slrAddr;
    }

    public void setSlrAddr(String slrAddr) {
        this.slrAddr = slrAddr;
    }

    public String getSlrMail() {
        return slrMail;
    }

    public void setSlrMail(String slrMail) {
        this.slrMail = slrMail;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getIndst() {
        return indst;
    }

    public void setIndst(String indst) {
        this.indst = indst;
    }

    public String getKind() {
        return kind;
    }

    public void setKind(String kind) {
        this.kind = kind;
    }

    public String getSlrPhone() {
        return slrPhone;
    }

    public void setSlrPhone(String slrPhone) {
        this.slrPhone = slrPhone;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public int getFirstIdNO() {
        return firstIdNO;
    }

    public void setFirstIdNO(int firstIdNO) {
        this.firstIdNO = firstIdNO;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public int getLastIdNO() {
        return lastIdNO;
    }

    public void setLastIdNO(int lastIdNO) {
        this.lastIdNO = lastIdNO;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    @Override
    public String toString() {
        return "CompanyInfoDTO{" +
                "slrNo=" + slrNo +
                ", slrName='" + slrName + '\'' +
                ", slrNum='" + slrNum + '\'' +
                ", actName='" + actName + '\'' +
                ", actNum='" + actNum + '\'' +
                ", slrAddr='" + slrAddr + '\'' +
                ", slrMail='" + slrMail + '\'' +
                ", companyName='" + companyName + '\'' +
                ", indst='" + indst + '\'' +
                ", kind='" + kind + '\'' +
                ", slrPhone='" + slrPhone + '\'' +
                ", regDate=" + regDate +
                ", firstIdNO=" + firstIdNO +
                ", modifyDate=" + modifyDate +
                ", lastIdNO=" + lastIdNO +
                ", etc='" + etc + '\'' +
                '}';
    }
}
