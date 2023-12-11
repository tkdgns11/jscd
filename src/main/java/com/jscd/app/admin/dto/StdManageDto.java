package com.jscd.app.admin.dto;

import java.util.Date;
import java.util.Objects;

public class StdManageDto { //학생
        private Integer mebrNo; //pk_회원 고유 번호
        private String gisu;
        private Integer status;
        private Date regDate;
        private String firstIdNo;
        private Date modifyDate;
        private String lastIdNo;
        private String etc;

        public StdManageDto(){}

        public StdManageDto(Integer mebrNo,String gisu, Integer status) {
            this.mebrNo = mebrNo;
            this.gisu = gisu;
            this.status = status;
        }

        public Integer getMebrNo() {
            return mebrNo;
        }

        public void setMebrNo(Integer mebrNo) {
            this.mebrNo = mebrNo;
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
            StdManageDto that = (StdManageDto) o;
            return Objects.equals(mebrNo, that.mebrNo)&& Objects.equals(gisu, that.gisu) && Objects.equals(status, that.status) && Objects.equals(regDate, that.regDate) && Objects.equals(firstIdNo, that.firstIdNo) && Objects.equals(modifyDate, that.modifyDate) && Objects.equals(lastIdNo, that.lastIdNo) && Objects.equals(etc, that.etc);
        }

        @Override
        public int hashCode() {
            return Objects.hash(mebrNo, gisu, status, regDate, firstIdNo, modifyDate, lastIdNo, etc);
        }

        @Override
        public String toString() {
            return "StdManageDto{" +
                    "mebrNo=" + mebrNo +
                    ", gisu='" + gisu + '\'' +
                    ", status='" + status + '\'' +
                    ", regDate=" + regDate +
                    ", firstIdNo='" + firstIdNo + '\'' +
                    ", modifyDate=" + modifyDate +
                    ", lastIdNo='" + lastIdNo + '\'' +
                    ", etc='" + etc + '\'' +
                    '}';
        }
    }


