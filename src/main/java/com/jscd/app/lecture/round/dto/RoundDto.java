package com.jscd.app.lecture.round.dto;

import java.util.Objects;

public class RoundDto {
    private Integer roundCode;
    private String roundName;
    private String regDate;
    private Integer firstIdNo;
    private String modifyDate;
    private Integer lastIdNo;

    public RoundDto() {
    }

    public RoundDto(Integer roundCode, String roundName, String regDate, Integer firstIdNo, String modifyDate, Integer lastIdNo) {
        this.roundCode = roundCode;
        this.roundName = roundName;
        this.regDate = regDate;
        this.firstIdNo = firstIdNo;
        this.modifyDate = modifyDate;
        this.lastIdNo = lastIdNo;
    }

    public Integer getRoundCode() {
        return roundCode;
    }

    public void setRoundCode(Integer roundCode) {
        this.roundCode = roundCode;
    }

    public String getRoundName() {
        return roundName;
    }

    public void setRoundName(String roundName) {
        this.roundName = roundName;
    }

    public String getRegDate() {
        return regDate;
    }

    public void setRegDate(String regDate) {
        this.regDate = regDate;
    }

    public Integer getFirstIdNo() {
        return firstIdNo;
    }

    public void setFirstIdNo(Integer firstIdNo) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundDto roundDto = (RoundDto) o;
        return Objects.equals(roundCode, roundDto.roundCode) && Objects.equals(roundName, roundDto.roundName) && Objects.equals(regDate, roundDto.regDate) && Objects.equals(firstIdNo, roundDto.firstIdNo) && Objects.equals(modifyDate, roundDto.modifyDate) && Objects.equals(lastIdNo, roundDto.lastIdNo);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundCode, roundName, regDate, firstIdNo, modifyDate, lastIdNo);
    }

    @Override
    public String toString() {
        return "RoundDto{" +
                "roundCode=" + roundCode +
                ", roundName='" + roundName + '\'' +
                ", regDate='" + regDate + '\'' +
                ", firstIdNo=" + firstIdNo +
                ", modifyDate='" + modifyDate + '\'' +
                ", lastIdNo=" + lastIdNo +
                '}';
    }
}
