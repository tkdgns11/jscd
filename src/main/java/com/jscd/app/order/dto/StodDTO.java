package com.jscd.app.order.dto;

public class StodDTO {

    //memberDto
    private String id;
    private String name;
    private String phone;

    //orderDto
    private int registCode;
    private String title;
    private int lastPrice;

    //companyDto
    private int slrNo;
    private String slrName;
    private String slrNum;
    private String companyName;
    private String indst;
    private String kind;
    private String slrPhone;
    private String regDate;
    private int firstIdNo;
    private String modifyDate;
    private Integer lastIdNo;
    private String etc;
    private String slrAddr; //추가
    private String slrMail;

    private String odNo;
    private String status;
    private String payType;

    //payHty
    private String creditNum;
    private String cardType;
    private int instlFees;
    private String payDay; //
    private String csrcNum; //
    private String payTime;
    private String userActNum;
    private String payName;
    private String payBank;

    public StodDTO(){}

    public StodDTO(String id, String name, String phone, int registCode, String title, int lastPrice, int slrNo, String slrName, String slrNum, String companyName, String indst, String kind, String slrPhone, String regDate, int firstIdNo, String modifyDate, Integer lastIdNo, String etc, String slrAddr, String slrMail, String odNo, String status, String payType, String creditNum, String cardType, int instlFees, String payDay, String csrcNum, String payTime, String userActNum, String payName, String payBank) {
        this.id = id;
        this.name = name;
        this.phone = phone;
        this.registCode = registCode;
        this.title = title;
        this.lastPrice = lastPrice;
        this.slrNo = slrNo;
        this.slrName = slrName;
        this.slrNum = slrNum;
        this.companyName = companyName;
        this.indst = indst;
        this.kind = kind;
        this.slrPhone = slrPhone;
        this.regDate = regDate;
        this.firstIdNo = firstIdNo;
        this.modifyDate = modifyDate;
        this.lastIdNo = lastIdNo;
        this.etc = etc;
        this.slrAddr = slrAddr;
        this.slrMail = slrMail;
        this.odNo = odNo;
        this.status = status;
        this.payType = payType;
        this.creditNum = creditNum;
        this.cardType = cardType;
        this.instlFees = instlFees;
        this.payDay = payDay;
        this.csrcNum = csrcNum;
        this.payTime = payTime;
        this.userActNum = userActNum;
        this.payName = payName;
        this.payBank = payBank;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public int getRegistCode() {
        return registCode;
    }

    public void setRegistCode(int registCode) {
        this.registCode = registCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(int lastPrice) {
        this.lastPrice = lastPrice;
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

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public int getFirstIdNo() {
        return firstIdNo;
    }

    public void setFirstIdNo(int firstIdNo) {
        this.firstIdNo = firstIdNo;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
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

    public String getOdNo() {
        return odNo;
    }

    public void setOdNo(String odNo) {
        this.odNo = odNo;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getPayType() {
        return payType;
    }

    public void setPayType(String payType) {
        this.payType = payType;
    }

    public String getCreditNum() {
        return creditNum;
    }

    public void setCreditNum(String creditNum) {
        this.creditNum = creditNum;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public int getInstlFees() {
        return instlFees;
    }

    public void setInstlFees(int instlFees) {
        this.instlFees = instlFees;
    }

    public String getPayDay() {
        return payDay;
    }

    public void setPayDay(String payDay) {
        this.payDay = payDay;
    }

    public String getCsrcNum() {
        return csrcNum;
    }

    public void setCsrcNum(String csrcNum) {
        this.csrcNum = csrcNum;
    }

    public String getPayTime() {
        return payTime;
    }

    public void setPayTime(String payTime) {
        this.payTime = payTime;
    }

    public String getUserActNum() {
        return userActNum;
    }

    public void setUserActNum(String userActNum) {
        this.userActNum = userActNum;
    }

    public String getPayName() {
        return payName;
    }

    public void setPayName(String payName) {
        this.payName = payName;
    }

    public String getPayBank() {
        return payBank;
    }

    public void setPayBank(String payBank) {
        this.payBank = payBank;
    }

    @Override
    public String toString() {
        return "StodDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", registCode=" + registCode +
                ", title='" + title + '\'' +
                ", lastPrice=" + lastPrice +
                ", slrNo=" + slrNo +
                ", slrName='" + slrName + '\'' +
                ", slrNum='" + slrNum + '\'' +
                ", companyName='" + companyName + '\'' +
                ", indst='" + indst + '\'' +
                ", kind='" + kind + '\'' +
                ", slrPhone='" + slrPhone + '\'' +
                ", regDate='" + regDate + '\'' +
                ", firstIdNo=" + firstIdNo +
                ", modifyDate='" + modifyDate + '\'' +
                ", lastIdNo=" + lastIdNo +
                ", etc='" + etc + '\'' +
                ", slrAddr='" + slrAddr + '\'' +
                ", slrMail='" + slrMail + '\'' +
                ", odNo='" + odNo + '\'' +
                ", status='" + status + '\'' +
                ", payType='" + payType + '\'' +
                ", creditNum='" + creditNum + '\'' +
                ", cardType='" + cardType + '\'' +
                ", instlFees=" + instlFees +
                ", payDay='" + payDay + '\'' +
                ", csrcNum='" + csrcNum + '\'' +
                ", payTime='" + payTime + '\'' +
                ", userActNum='" + userActNum + '\'' +
                ", payName='" + payName + '\'' +
                ", payBank='" + payBank + '\'' +
                '}';
    }
}
