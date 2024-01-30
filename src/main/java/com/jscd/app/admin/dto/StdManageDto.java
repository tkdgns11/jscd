package com.jscd.app.admin.dto;

import java.util.Date;
import java.util.Objects;

public class StdManageDto { //학생
        private Integer mebrNO; //pk_회원 고유 번호
        private String gisu;
        private Integer status;
        private Date regDate;
        private String firstIdNO;
        private Date modifyDate;
        private String lastIdNO;
        private String etc;

        public StdManageDto(){}

        public StdManageDto(Integer mebrNO,String gisu, Integer status) {
            this.mebrNO = mebrNO;
            this.gisu = gisu;
            this.status = status;
        }

        public Integer getMebrNO() {
            return mebrNO;
        }

        public void setMebrNO(Integer mebrNO) {
            this.mebrNO = mebrNO;
        }

        public String getGisu() {
            return gisu;
        }

        public void setGisu(String gisu) {
            this.gisu = gisu;
        }

        public Integer getStatus() {
            return status;
        }

        public void setStatus(Integer status) {
            this.status = status;
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
            StdManageDto that = (StdManageDto) o;
            return Objects.equals(mebrNO, that.mebrNO)&& Objects.equals(gisu, that.gisu) && Objects.equals(status, that.status) && Objects.equals(regDate, that.regDate) && Objects.equals(firstIdNO, that.firstIdNO) && Objects.equals(modifyDate, that.modifyDate) && Objects.equals(lastIdNO, that.lastIdNO) && Objects.equals(etc, that.etc);
        }

        @Override
        public int hashCode() {
            return Objects.hash(mebrNO, gisu, status, regDate, firstIdNO, modifyDate, lastIdNO, etc);
        }

        @Override
        public String toString() {
            return "StdManageDto{" +
                    "mebrNO=" + mebrNO +
                    ", gisu='" + gisu + '\'' +
                    ", status='" + status + '\'' +
                    ", regDate=" + regDate +
                    ", firstIdNO='" + firstIdNO + '\'' +
                    ", modifyDate=" + modifyDate +
                    ", lastIdNO='" + lastIdNO + '\'' +
                    ", etc='" + etc + '\'' +
                    '}';
        }
    }


