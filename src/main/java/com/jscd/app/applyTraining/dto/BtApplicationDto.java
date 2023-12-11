package com.jscd.app.applyTraining.dto;

import java.util.Date;
import java.util.Objects;

public class BtApplicationDto {
    private Integer stfmNo;
    private String id;
    private Integer registCode;
    private Integer mebrNo;
    private String level;
    private String levelDetail;
    private String attdPps;
    private String attdPath;
    private String intro;
    private String expect;
    private String agreeYN;
    private String approvalYN;
    private Date regDate;
    private Integer firstIdNo;
    private Date modifyDate;
    private Integer lastIdNo;
    private String etc;

    public BtApplicationDto() {
    }

    public BtApplicationDto(Integer stfmNo, String id, Integer registCode, Integer mebrNo, String level, String levelDetail, String attdPps, String attdPath, String intro, String expect, String agreeYN, String approvalYN, Date regDate, Integer firstIdNo, Date modifyDate, Integer lastIdNo, String etc) {
        this.stfmNo = stfmNo;
        this.id = id;
        this.registCode = registCode;
        this.mebrNo = mebrNo;
        this.level = level;
        this.levelDetail = levelDetail;
        this.attdPps = attdPps;
        this.attdPath = attdPath;
        this.intro = intro;
        this.expect = expect;
        this.agreeYN = agreeYN;
        this.approvalYN = approvalYN;
        this.regDate = regDate;
        this.firstIdNo = firstIdNo;
        this.modifyDate = modifyDate;
        this.lastIdNo = lastIdNo;
        this.etc = etc;
    }

    public Integer getStfmNo() {
        return stfmNo;
    }

    public void setStfmNo(Integer stfmNo) {
        this.stfmNo = stfmNo;
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

    public String getAgreeYN() {
        return agreeYN;
    }

    public void setAgreeYN(String agreeYN) {
        this.agreeYN = agreeYN;
    }

    public String getApprovalYN() {
        return approvalYN;
    }

    public void setApprovalYN(String approvalYN) {
        this.approvalYN = approvalYN;
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

    @Override
    public String toString() {
        return "BtApplicationDto{" +
                "stfmNo=" + stfmNo +
                ", id='" + id + '\'' +
                ", registCode=" + registCode +
                ", mebrNo=" + mebrNo +
                ", level='" + level + '\'' +
                ", levelDetail='" + levelDetail + '\'' +
                ", attdPps='" + attdPps + '\'' +
                ", attdPath='" + attdPath + '\'' +
                ", intro='" + intro + '\'' +
                ", expect='" + expect + '\'' +
                ", agreeYN='" + agreeYN + '\'' +
                ", approvalYN='" + approvalYN + '\'' +
                ", regDate=" + regDate +
                ", firstIdNo=" + firstIdNo +
                ", modifyDate=" + modifyDate +
                ", lastIdNo=" + lastIdNo +
                ", etc='" + etc + '\'' +
                '}';
    }


}
