package com.jscd.app.admin.dto;

import java.util.Date;
import java.util.Objects;

public class StdMemberManageDto {

    //회원테이블
    private Integer mebrNo;
    private String id;
    private String name;
    private String alias;
    private Date birth;
    private String phone1;
    private String phone2;
    private String phone3;
    private Date regDate;

    //학생테이블
    private String gisu;
    private String status;
    private String etc;

    public StdMemberManageDto(Integer mebrNo, String id, String name, String alias, Date birth, String phone1, String phone2, String phone3, Date regDate, String gisu, String status, String etc) {
        this.mebrNo = mebrNo;
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.birth = birth;
        this.phone1 = phone1;
        this.phone2 = phone2;
        this.phone3 = phone3;
        this.regDate = regDate;
        this.gisu = gisu;
        this.status = status;
        this.etc = etc;
    }

    public StdMemberManageDto() {
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

    public Date getBirth() {
        return birth;
    }

    public void setBirth(Date birth) {
        this.birth = birth;
    }

    public String getPhone1() {
        return phone1;
    }

    public void setPhone1(String phone1) {
        this.phone1 = phone1;
    }

    public String getPhone2() {
        return phone2;
    }

    public void setPhone2(String phone2) {
        this.phone2 = phone2;
    }

    public String getPhone3() {
        return phone3;
    }

    public void setPhone3(String phone3) {
        this.phone3 = phone3;
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
        return mebrNo == that.mebrNo && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(alias, that.alias) && Objects.equals(birth, that.birth) && Objects.equals(phone1, that.phone1) && Objects.equals(phone2, that.phone2) && Objects.equals(phone3, that.phone3) && Objects.equals(regDate, that.regDate) && Objects.equals(gisu, that.gisu) && Objects.equals(status, that.status) && Objects.equals(etc, that.etc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mebrNo, id, name, alias, birth, phone1, phone2, phone3, regDate, gisu, status, etc);
    }

    @Override
    public String toString() {


        return "StdMemberManageDto{" +
                "mebrNo=" + mebrNo +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", birth=" + birth +
                ", phone1='" + phone1 + '\'' +
                ", phone2='" + phone2 + '\'' +
                ", phone3='" + phone3 + '\'' +
                ", regDate=" + regDate +
                ", gisu='" + gisu + '\'' +
                ", status='" + status + '\'' +
                ", etc='" + etc + '\'' +
                '}';
    }

}

