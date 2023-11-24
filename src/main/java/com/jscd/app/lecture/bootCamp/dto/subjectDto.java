package com.jscd.app.lecture.bootCamp.dto;

import java.util.Date;
import java.util.Objects;

public class subjectDto {
    private String subjectName;
    private String etc;
    private Date regDate;
    private Date modifyDate;
    private String frsidnmbr;
    private String lstidNmbr;

    public subjectDto() {}

    public subjectDto(String subjectName, String etc, Date regDate, Date modifyDate, String frsidnmbr, String lstidNmbr) {
        this.subjectName = subjectName;
        this.etc = etc;
        this.regDate = regDate;
        this.modifyDate = modifyDate;
        this.frsidnmbr = frsidnmbr;
        this.lstidNmbr = lstidNmbr;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        subjectDto that = (subjectDto) o;
        return Objects.equals(subjectName, that.subjectName) && Objects.equals(etc, that.etc) && Objects.equals(regDate, that.regDate) && Objects.equals(modifyDate, that.modifyDate) && Objects.equals(frsidnmbr, that.frsidnmbr) && Objects.equals(lstidNmbr, that.lstidNmbr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(subjectName, etc, regDate, modifyDate, frsidnmbr, lstidNmbr);
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public String getFrsidnmbr() {
        return frsidnmbr;
    }

    public void setFrsidnmbr(String frsidnmbr) {
        this.frsidnmbr = frsidnmbr;
    }

    public String getLstidNmbr() {
        return lstidNmbr;
    }

    public void setLstidNmbr(String lstidNmbr) {
        this.lstidNmbr = lstidNmbr;
    }

    @Override
    public String toString() {
        return "subjectDto{" +
                "subjectName='" + subjectName + '\'' +
                ", etc='" + etc + '\'' +
                ", regDate=" + regDate +
                ", modifyDate=" + modifyDate +
                ", frsidnmbr='" + frsidnmbr + '\'' +
                ", lstidNmbr='" + lstidNmbr + '\'' +
                '}';
    }
}
