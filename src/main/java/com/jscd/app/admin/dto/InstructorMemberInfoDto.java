package com.jscd.app.admin.dto;

import java.util.Date;
import java.util.Objects;

public class InstructorMemberInfoDto { //강사 + 회원 조인 Dto
    private Integer iscrNO; //pk_강사 고유 코드
    private Integer mebrNO; //회원 고유 번호
    private String intro;
    private String status;
    private Float hourPmt;
    private Date regDate;
    private String firstIdNO;
    private Date modifyDate;
    private String lastIdNO;
    private String etc;
    //    ㅡㅡㅡㅡㅡㅡㅡㅡ회원컬럼ㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡㅡ
    private String id;
    private String name;
    private String birth;
    private String phone;
    private String acct;

    public InstructorMemberInfoDto(){}

    public InstructorMemberInfoDto(Integer iscrNO, Integer mebrNO, String intro, String status, Float hourPmt, Date regDate,
                                   String firstIdNO, Date modifyDate, String lastIdNO, String etc, String id, String name, String birth,
                                   String phone, String acct) {
        this.iscrNO = iscrNO;
        this.mebrNO = mebrNO;
        this.intro = intro;
        this.status = status;
        this.hourPmt = hourPmt;
        this.regDate = regDate;
        this.firstIdNO = firstIdNO;
        this.modifyDate = modifyDate;
        this.lastIdNO = lastIdNO;
        this.etc = etc;
        this.id = id;
        this.name = name;
        this.birth = birth;
        this.phone = phone;
        this.acct = acct;
    }

    public Integer getIscrNO() {
        return iscrNO;
    }

    public void setIscrNo(Integer iscrNo) {
        this.iscrNO = iscrNO;
    }

    public Integer getMebrNO() {
        return mebrNO;
    }

    public void setMebrNo(Integer mebrNO) {
        this.mebrNO = mebrNO;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Float getHourPmt() {
        return hourPmt;
    }

    public void setHourPmt(Float hourPmt) {
        this.hourPmt = hourPmt;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public String getfirstIdNO() {
        return firstIdNO;
    }

    public void setfirstIdNO(String firstIdNO) {
        this.firstIdNO = firstIdNO;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getlastIdNO() {
        return lastIdNO;
    }

    public void setlastIdNO(String lastIdNO) {
        this.lastIdNO = lastIdNO;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getPhone() {
        return phone;
    }


    public String getAcct() {
        return acct;
    }

    public void setAcct(String acct) {
        this.acct = acct;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InstructorMemberInfoDto that = (InstructorMemberInfoDto) o;
        return Objects.equals(iscrNO, that.iscrNO) && Objects.equals(mebrNO, that.mebrNO) && Objects.equals(intro, that.intro) && Objects.equals(status, that.status) && Objects.equals(hourPmt, that.hourPmt) && Objects.equals(regDate, that.regDate) && Objects.equals(firstIdNO, that.firstIdNO) && Objects.equals(modifyDate, that.modifyDate) && Objects.equals(lastIdNO, that.lastIdNO) && Objects.equals(etc, that.etc) && Objects.equals(id, that.id) && Objects.equals(name, that.name) && Objects.equals(birth, that.birth) && Objects.equals(phone, that.phone)&& Objects.equals(acct, that.acct);
    }

    @Override
    public int hashCode() {
        return Objects.hash(iscrNO, mebrNO, intro, status, hourPmt, regDate, firstIdNO, modifyDate, lastIdNO, etc, id, name, birth, phone, acct);
    }

    @Override
    public String toString() {
        return "InstructorMemberInfoDto{" +
                "iscrNO='" + iscrNO + '\'' +
                ", mebrNO=" + mebrNO +
                ", intro='" + intro + '\'' +
                ", status=" + status +
                ", hourPmt=" + hourPmt +
                ", regDate=" + regDate +
                ", firstIdNO='" + firstIdNO + '\'' +
                ", modifyDate=" + modifyDate +
                ", lastIdNO='" + lastIdNO + '\'' +
                ", etc='" + etc + '\'' +
                ", id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", birth=" + birth +
                ", phone='" + phone + '\'' +
                ", acct='" + acct + '\'' +
                '}';
    }
    }






