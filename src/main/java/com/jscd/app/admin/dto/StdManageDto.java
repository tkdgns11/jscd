package com.jscd.app.admin.dto;

import java.util.Date;
import java.util.Objects;

public class StdManageDto { //학생
        private Integer mebrNo; //pk_회원 고유 번호
        private Integer codeNum; //강의실 정보 코드
        private String gisu;
        private String status;
        private Date regDate;
        private String frsidNmbr;
        private Date modifyDate;
        private String lstidNmbr;
        private String etc;

        public StdManageDto(){}

        public StdManageDto(Integer mebrNo, Integer codeNum, String gisu, String status) {
            this.mebrNo = mebrNo;
            this.codeNum = codeNum;
            this.gisu = gisu;
            this.status = status;
        }

        public Integer getMebrNo() {
            return mebrNo;
        }

        public void setMebrNo(Integer mebrNo) {
            this.mebrNo = mebrNo;
        }

        public Integer getCodeNum() {
            return codeNum;
        }

        public void setCodeNum(Integer codeNum) {
            this.codeNum = codeNum;
        }

        public String getGisu() {
            return gisu;
        }

        public void setGisu(String gisu) {
            this.gisu = gisu;
        }

        public String getStatus() {
            return status;
        }

        public void setStatus(String status) {
            this.status = status;
        }

        public Date getRegDate() {
            return regDate;
        }

        public void setRegDate(Date regDate) {
            this.regDate = regDate;
        }

        public String getFrsidNmbr() {
            return frsidNmbr;
        }

        public void setFrsidNmbr(String frsidNmbr) {
            this.frsidNmbr = frsidNmbr;
        }

        public Date getModifyDate() {
            return modifyDate;
        }

        public void setModifyDate(Date modifyDate) {
            this.modifyDate = modifyDate;
        }

        public String getLstidNmbr() {
            return lstidNmbr;
        }

        public void setLstidNmbr(String lstidNmbr) {
            this.lstidNmbr = lstidNmbr;
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
            return Objects.equals(mebrNo, that.mebrNo) && Objects.equals(codeNum, that.codeNum) && Objects.equals(gisu, that.gisu) && Objects.equals(status, that.status) && Objects.equals(regDate, that.regDate) && Objects.equals(frsidNmbr, that.frsidNmbr) && Objects.equals(modifyDate, that.modifyDate) && Objects.equals(lstidNmbr, that.lstidNmbr) && Objects.equals(etc, that.etc);
        }

        @Override
        public int hashCode() {
            return Objects.hash(mebrNo, codeNum, gisu, status, regDate, frsidNmbr, modifyDate, lstidNmbr, etc);
        }

        @Override
        public String toString() {
            return "StdManageDto{" +
                    "mebrNo=" + mebrNo +
                    ", codeNum=" + codeNum +
                    ", gisu='" + gisu + '\'' +
                    ", status='" + status + '\'' +
                    ", regDate=" + regDate +
                    ", frsidNmbr='" + frsidNmbr + '\'' +
                    ", modifyDate=" + modifyDate +
                    ", lstidNmbr='" + lstidNmbr + '\'' +
                    ", etc='" + etc + '\'' +
                    '}';
        }
    }


