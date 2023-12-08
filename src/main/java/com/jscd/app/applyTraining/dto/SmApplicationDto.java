package com.jscd.app.applyTraining.dto;

import java.util.Date;
import java.util.Objects;

public class SmApplicationDto {
    private Integer stfmNo;
    private Integer registCode;
    private Integer mebrNo;
    private String level;
    private String levelDetail;
    private String attdPps;
    private String attdPath;
    private String intro;
    private String expect;
    private Date regDate;
    private Integer firstIdNo;
    private Date modifyDate;
    private Integer lastIdNo;
    private String etc;

    public SmApplicationDto() {}

    public SmApplicationDto(String level, String levelDetail, String attdPps, String attdPath, String intro, String expect) {
        this.level = level;
        this.levelDetail = levelDetail;
        this.attdPps = attdPps;
        this.attdPath = attdPath;
        this.intro = intro;
        this.expect = expect;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SmApplicationDto that = (SmApplicationDto) o;
        return Objects.equals(stfmNo, that.stfmNo) && Objects.equals(registCode, that.registCode) && Objects.equals(mebrNo, that.mebrNo) && Objects.equals(level, that.level) && Objects.equals(levelDetail, that.levelDetail) && Objects.equals(attdPps, that.attdPps) && Objects.equals(attdPath, that.attdPath) && Objects.equals(intro, that.intro) && Objects.equals(expect, that.expect) && Objects.equals(regDate, that.regDate) && Objects.equals(firstIdNo, that.firstIdNo) && Objects.equals(modifyDate, that.modifyDate) && Objects.equals(lastIdNo, that.lastIdNo) && Objects.equals(etc, that.etc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stfmNo, registCode, mebrNo, level, levelDetail, attdPps, attdPath, intro, expect, regDate, firstIdNo, modifyDate, lastIdNo, etc);
    }

    @Override
    public String toString() {
        return "SmApplicationDto{" +
                "stfmNo=" + stfmNo +
                ", registCode=" + registCode +
                ", mebrNo=" + mebrNo +
                ", level='" + level + '\'' +
                ", levelDetail='" + levelDetail + '\'' +
                ", attdPps='" + attdPps + '\'' +
                ", attdPath='" + attdPath + '\'' +
                ", intro='" + intro + '\'' +
                ", expect='" + expect + '\'' +
                ", regDate=" + regDate +
                ", firstIdNo=" + firstIdNo +
                ", modifyDate=" + modifyDate +
                ", lastIdNo=" + lastIdNo +
                ", etc='" + etc + '\'' +
                '}';
    }

    public Integer getStfmNo() {
        return stfmNo;
    }

    public void setStfmNo(Integer stfmNo) {
        this.stfmNo = stfmNo;
    }

    public Integer getRegistCode() {
        return registCode;
    }

    public void setRegistCode(Integer registCode) {
        this.registCode = registCode;
    }

    public Integer getMebrNo() {
        return mebrNo;
    }

    public void setMebrNo(Integer mebrNo) {
        this.mebrNo = mebrNo;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public String getLevelDetail() {
        return levelDetail;
    }

    public void setLevelDetail(String levelDetail) {
        this.levelDetail = levelDetail;
    }

    public String getAttdPps() {
        return attdPps;
    }

    public void setAttdPps(String attdPps) {
        this.attdPps = attdPps;
    }

    public String getAttdPath() {
        return attdPath;
    }

    public void setAttdPath(String attdPath) {
        this.attdPath = attdPath;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Integer getFirstIdNo() {
        return firstIdNo;
    }

    public void setFirstIdNo(Integer firstIdNo) {
        this.firstIdNo = firstIdNo;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
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
}
