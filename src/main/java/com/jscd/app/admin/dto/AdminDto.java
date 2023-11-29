package com.jscd.app.admin.dto;

import java.util.Date;
import java.util.Objects;

public class AdminDto { //관리자

    private Integer adminNo; //pk_관리자 고유 번호
    private String id;
    private String name;
    private String alias;
    private Date birth;
    private String pwd;
    private String phone;
    private Integer status;
    private Integer grade;
    private Date regDate;
    private String frsidNmbr;
    private Date modifyDate;
    private String lstidNmbr;
    private String etc;


    public AdminDto(String id, String name, String alias, String pwd) {
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.pwd = pwd;
    }

    public AdminDto(Integer adminNo, String id, String name, String alias, Date birth, String pwd, String phone, Integer status, Integer grade, Date regDate, String frsidNmbr, Date modifyDate, String lstidNmbr, String etc) {
        this.adminNo = adminNo;
        this.id = id;
        this.name = name;
        this.alias = alias;
        this.birth = birth;
        this.pwd = pwd;
        this.phone = phone;
        this.status = status;
        this.grade = grade;
        this.regDate = regDate;
        this.frsidNmbr = frsidNmbr;
        this.modifyDate = modifyDate;
        this.lstidNmbr = lstidNmbr;
        this.etc = etc;
    }

    public AdminDto() {
    }

    public Integer getAdminNo() {
        return adminNo;
    }

    public void setAdminNo(Integer adminNo) {
        this.adminNo = adminNo;
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

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getFrsidNmbr() {
        return frsidNmbr;
    }

    public void setFrsidNmbr(String frsidNmbr) {
        this.frsidNmbr = frsidNmbr;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getLstidNmbr() {
        return lstidNmbr;
    }

    public void setLstidNmbr(String lstidNmbr) {
        this.lstidNmbr = lstidNmbr;
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
        AdminDto adminDto = (AdminDto) o;
        return Objects.equals(adminNo, adminDto.adminNo) && Objects.equals(id, adminDto.id) && Objects.equals(name, adminDto.name) && Objects.equals(alias, adminDto.alias) && Objects.equals(birth, adminDto.birth) && Objects.equals(pwd, adminDto.pwd) && Objects.equals(phone, adminDto.phone) && Objects.equals(status, adminDto.status) && Objects.equals(grade, adminDto.grade) && Objects.equals(regDate, adminDto.regDate) && Objects.equals(frsidNmbr, adminDto.frsidNmbr) && Objects.equals(modifyDate, adminDto.modifyDate) && Objects.equals(lstidNmbr, adminDto.lstidNmbr) && Objects.equals(etc, adminDto.etc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(adminNo, id, name, alias, birth, pwd, phone, status, grade, regDate, frsidNmbr, modifyDate, lstidNmbr, etc);
    }

    @Override
    public String toString() {
        return "AdminDto{" +
                "adminNo=" + adminNo +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", alias='" + alias + '\'' +
                ", birth=" + birth +
                ", pwd='" + pwd + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", grade=" + grade +
                ", regDate=" + regDate +
                ", frsidNmbr='" + frsidNmbr + '\'' +
                ", modifyDate=" + modifyDate +
                ", lstidNmbr='" + lstidNmbr + '\'' +
                ", etc='" + etc + '\'' +
                '}';
    }

}

