package com.jscd.app.applyTraining.dto;

import java.util.Date;
import java.util.Objects;

public class SmApplicationDto {
    private Integer stfmNo;
    private Integer mebrNO;
    private String id;
    private Integer registCode;
    private String title;
    private Integer lastPrice;
    private String status;
    private String level;
    private String levelDetail;
    private String attdPps;
    private String attdPath;
    private String intro;
    private String expect;
    private Date regDate;
    private Integer firstIdNO;
    private Date modifyDate;
    private Integer lastIdNO;
    private String etc;

    public SmApplicationDto() {}

    public SmApplicationDto(String id, Integer registCode, String title, Integer lastPrice, String status, String level, String levelDetail, String attdPps, String attdPath, String intro, String expect) {
        this.id = id;
        this.registCode = registCode;
        this.title = title;
        this.lastPrice = lastPrice;
        this.status = status;
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
        return Objects.equals(stfmNo, that.stfmNo) && Objects.equals(mebrNO, that.mebrNO) && Objects.equals(id, that.id) && Objects.equals(registCode, that.registCode) && Objects.equals(title, that.title) && Objects.equals(lastPrice, that.lastPrice) && Objects.equals(status, that.status) && Objects.equals(level, that.level) && Objects.equals(levelDetail, that.levelDetail) && Objects.equals(attdPps, that.attdPps) && Objects.equals(attdPath, that.attdPath) && Objects.equals(intro, that.intro) && Objects.equals(expect, that.expect) && Objects.equals(regDate, that.regDate) && Objects.equals(firstIdNO, that.firstIdNO) && Objects.equals(modifyDate, that.modifyDate) && Objects.equals(lastIdNO, that.lastIdNO) && Objects.equals(etc, that.etc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(stfmNo, mebrNO, id, registCode, title, lastPrice, status, level, levelDetail, attdPps, attdPath, intro, expect, regDate, firstIdNO, modifyDate, lastIdNO, etc);
    }

    @Override
    public String toString() {
        return "SmApplicationDto{" +
                "stfmNo=" + stfmNo +
                ", mebrNO=" + mebrNO +
                ", id='" + id + '\'' +
                ", registCode=" + registCode +
                ", title='" + title + '\'' +
                ", lastPrice=" + lastPrice +
                ", status='" + status + '\'' +
                ", level='" + level + '\'' +
                ", levelDetail='" + levelDetail + '\'' +
                ", attdPps='" + attdPps + '\'' +
                ", attdPath='" + attdPath + '\'' +
                ", intro='" + intro + '\'' +
                ", expect='" + expect + '\'' +
                ", regDate=" + regDate +
                ", firstIdNO=" + firstIdNO +
                ", modifyDate=" + modifyDate +
                ", lastIdNO=" + lastIdNO +
                ", etc='" + etc + '\'' +
                '}';
    }

    public Integer getStfmNo() {
        return stfmNo;
    }

    public void setStfmNo(Integer stfmNo) {
        this.stfmNo = stfmNo;
    }

    public Integer getMebrNO() {
        return mebrNO;
    }

    public void setMebrNO(Integer mebrNO) {
        this.mebrNO = mebrNO;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getRegistCode() {
        return registCode;
    }

    public void setRegistCode(Integer registCode) {
        this.registCode = registCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(Integer lastPrice) {
        this.lastPrice = lastPrice;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public Integer getFirstIdNO() {
        return firstIdNO;
    }

    public void setFirstIdNO(Integer firstIdNO) {
        this.firstIdNO = firstIdNO;
    }

    public Date getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(Date modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getLastIdNO() {
        return lastIdNO;
    }

    public void setLastIdNO(Integer lastIdNO) {
        this.lastIdNO = lastIdNO;
    }

    public String getEtc() {
        return etc;
    }

    public void setEtc(String etc) {
        this.etc = etc;
    }
}
