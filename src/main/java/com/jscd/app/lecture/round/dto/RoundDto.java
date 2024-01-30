package com.jscd.app.lecture.round.dto;

import java.util.Objects;

public class RoundDto {
    private Integer roundCode;
    private String roundName;
    private String regDate;
    private Integer firstIdNO;
    private String modifyDate;
    private Integer lastIdNO;

    public RoundDto() {
    }

    public RoundDto(Integer roundCode, String roundName, String regDate, Integer firstIdNO, String modifyDate, Integer lastIdNO) {
        this.roundCode = roundCode;
        this.roundName = roundName;
        this.regDate = regDate;
        this.firstIdNO = firstIdNO;
        this.modifyDate = modifyDate;
        this.lastIdNO = lastIdNO;
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

    public Integer getFirstIdNO() {
        return firstIdNO;
    }

    public void setFirstIdNO(Integer firstIdNO) {
        this.firstIdNO = firstIdNO;
    }

    public String getModifyDate() {
        return modifyDate;
    }

    public void setModifyDate(String modifyDate) {
        this.modifyDate = modifyDate;
    }

    public Integer getLastIdNO() {
        return lastIdNO;
    }

    public void setLastIdNO(Integer lastIdNO) {
        this.lastIdNO = lastIdNO;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoundDto roundDto = (RoundDto) o;
        return Objects.equals(roundCode, roundDto.roundCode) && Objects.equals(roundName, roundDto.roundName) && Objects.equals(regDate, roundDto.regDate) && Objects.equals(firstIdNO, roundDto.firstIdNO) && Objects.equals(modifyDate, roundDto.modifyDate) && Objects.equals(lastIdNO, roundDto.lastIdNO);
    }

    @Override
    public int hashCode() {
        return Objects.hash(roundCode, roundName, regDate, firstIdNO, modifyDate, lastIdNO);
    }

    @Override
    public String toString() {
        return "RoundDto{" +
                "roundCode=" + roundCode +
                ", roundName='" + roundName + '\'' +
                ", regDate='" + regDate + '\'' +
                ", firstIdNO=" + firstIdNO +
                ", modifyDate='" + modifyDate + '\'' +
                ", lastIdNO=" + lastIdNO +
                '}';
    }
}
