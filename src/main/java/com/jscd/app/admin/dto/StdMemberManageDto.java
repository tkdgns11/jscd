package com.jscd.app.admin.dto;

import java.util.Date;
import java.util.Objects;

public class StdMemberManageDto { //학생+회원 조인 Dto

    //회원테이블
    private Integer mebrNo;
    private String id;
    private String name;
    private String alias;
    private String birth;
    private String phone;
    private String acct;

    private Date regDate;

    //학생테이블
    private String gisu;
    private String status;
    private String etc;

    public StdMemberManageDto(Integer mebrNo, String id, String name, String alias, String birth, String phone, Date regDate, String gisu, String status, String etc) {
        this.mebrNo = mebrNo;
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.birth = birth;
        this.phone = phone;
        this.regDate = regDate;
        this.gisu = gisu;
        this.status = status;
        this.etc = etc;
    }

    public StdMemberManageDto() {
    }

    public String getAcct() {
        return acct;
    }

    public void setAcct(String acct) {
        this.acct = acct;
    }

    public int getmebrNo() {
        return mebrNo;
    }

    public void setmebrNo(int mebrNo) {
        this.mebrNo = mebrNo;
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

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }


    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getGisu() {
        return gisu;
    }

    public void setGisu(String gisu) {
        this.gisu = gisu;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StdMemberManageDto that = (StdMemberManageDto) o;
        return mebrNo == that.mebrNo && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(alias, that.alias) && Objects.equals(birth, that.birth) && Objects.equals(phone, that.phone) && Objects.equals(regDate, that.regDate) && Objects.equals(gisu, that.gisu) && Objects.equals(status, that.status) && Objects.equals(etc, that.etc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mebrNo, id, name, alias, birth, phone, regDate, gisu, status, etc);
    }

    @Override
    public String toString() {


        return "StdMemberManageDto{" +
                "mebrNo=" + mebrNo +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", birth=" + birth +
                ", phone='" + phone + '\'' +
                ", regDate=" + regDate +
                ", gisu='" + gisu + '\'' +
                ", status='" + status + '\'' +
                ", etc='" + etc + '\'' +
                '}';
    }

}

