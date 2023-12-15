package com.jscd.app.admin.dto;

import java.util.Date;
import java.util.Objects;

public class AdminDto { //관리자 테이블

    private String id; //pk
    private String name;
    private String nickname;
    private Date birth;
    private String pwd;
    private String phone;
    private Integer status;
    private Integer grade;
    private Date regDate;
    private String firstIdNo;
    private Date modifyDate;
    private String lastIdNo;
    private String etc;


    public AdminDto(String id, String name, String nickname, String pwd) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.pwd = pwd;
    }

    public AdminDto(String id, String name, String nickname, Date birth, String pwd, String phone, Integer status, Integer grade, Date regDate, String firstIdNo, Date modifyDate, String lastIdNo, String etc) {
        this.id = id;
        this.name = name;
        this.nickname = nickname;
        this.birth = birth;
        this.pwd = pwd;
        this.phone = phone;
        this.status = status;
        this.grade = grade;
        this.regDate = regDate;
        this.firstIdNo = firstIdNo;
        this.modifyDate = modifyDate;
        this.lastIdNo = lastIdNo;
        this.etc = etc;
    }

    public AdminDto() {
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

    public String getnickname() {
        return nickname;
    }

    public void setnickname(String nickname) {
        this.nickname = nickname;
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

    public String getfirstIdNo() {
        return firstIdNo;
    }

    public void setfirstIdNo(String firstIdNo) {
        this.firstIdNo = firstIdNo;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getlastIdNo() {
        return lastIdNo;
    }

    public void setlastIdNo(String lastIdNo) {
        this.lastIdNo = lastIdNo;
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
        return Objects.equals(id, adminDto.id) && Objects.equals(name, adminDto.name) && Objects.equals(nickname, adminDto.nickname) && Objects.equals(birth, adminDto.birth) && Objects.equals(pwd, adminDto.pwd) && Objects.equals(phone, adminDto.phone) && Objects.equals(status, adminDto.status) && Objects.equals(grade, adminDto.grade) && Objects.equals(regDate, adminDto.regDate) && Objects.equals(firstIdNo, adminDto.firstIdNo) && Objects.equals(modifyDate, adminDto.modifyDate) && Objects.equals(lastIdNo, adminDto.lastIdNo) && Objects.equals(etc, adminDto.etc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, nickname, birth, pwd, phone, status, grade, regDate, firstIdNo, modifyDate, lastIdNo, etc);
    }

    @Override
    public String toString() {
        return "AdminDto{" +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                ", birth=" + birth +
                ", pwd='" + pwd + '\'' +
                ", phone='" + phone + '\'' +
                ", status=" + status +
                ", grade=" + grade +
                ", regDate=" + regDate +
                ", firstIdNo='" + firstIdNo + '\'' +
                ", modifyDate=" + modifyDate +
                ", lastIdNo='" + lastIdNo + '\'' +
                ", etc='" + etc + '\'' +
                '}';
    }

}

