package com.jscd.app.admin.dto;

import java.util.Date;
import java.util.Objects;

public class InstructorInfoDto { //강사정보

        private Integer iscrNO; //pk_강사 고유 코드
        private Integer mebrNO; //회원 고유 번호
        private String intro;
        private Integer status;

        private Float hourPmt;
        private Date regDate;
        private String firstIdNO;
        private Date modifyDate;
        private String lastIdNO;
        private String etc;

        public InstructorInfoDto(){}

        public InstructorInfoDto(Integer iscrNO, Integer mebrNO, String intro, Integer status, Float hourPmt, Date regDate, String firstIdNO, Date modifyDate, String lastIdNO, String etc) {
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
        }

    public InstructorInfoDto(Integer iscrNO, Integer mebrNO, String intro, Integer status, Float hourPmt) {
        this.iscrNO = iscrNO;
        this.mebrNO = mebrNO;
        this.intro = intro;
        this.status = status;
        this.hourPmt = hourPmt;
    }



        public Integer getIscrNO() {
            return iscrNO;
        }

        public void setIscrNO(Integer iscrNO) {
            this.iscrNO = iscrNO;
        }

        public Integer getMebrNO() {
            return mebrNO;
        }

        public void setMebrNO(Integer mebrNO) {
            this.mebrNO = mebrNO;
        }

        public String getIntro() {
            return intro;
        }

        public void setIntro(String intro) {
            this.intro = intro;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            InstructorInfoDto that = (InstructorInfoDto) o;
            return Objects.equals(iscrNO, that.iscrNO) && Objects.equals(mebrNO, that.mebrNO) && Objects.equals(intro, that.intro) && Objects.equals(status, that.status) && Objects.equals(hourPmt, that.hourPmt) && Objects.equals(regDate, that.regDate) && Objects.equals(firstIdNO, that.firstIdNO) && Objects.equals(modifyDate, that.modifyDate) && Objects.equals(lastIdNO, that.lastIdNO) && Objects.equals(etc, that.etc);
        }

        @Override
        public int hashCode() {
            return Objects.hash(iscrNO, mebrNO, intro, status, hourPmt, regDate, firstIdNO, modifyDate, lastIdNO, etc);
        }

        @Override
        public String toString() {
            return "InstructorInfoDto{" +
                    "iscrNO=" + iscrNO +
                    ", mebrNO=" + mebrNO +
                    ", intro='" + intro + '\'' +
                    ", status=" + status +
                    ", hourPmt=" + hourPmt +
                    ", regDate=" + regDate +
                    ", firstIdNO='" + firstIdNO + '\'' +
                    ", modifyDate=" + modifyDate +
                    ", lastIdNO='" + lastIdNO + '\'' +
                    ", etc='" + etc + '\'' +
                    '}';
        }
    }





