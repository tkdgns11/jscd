package com.jscd.app.lecture.admin.dto;

import java.util.Objects;

public class CourseDto {
    private Integer courseCode;
    private String courseName;
    private String regDate;
    private Integer firstIdNo;
    private String modifyDate;
    private Integer lastIdNo;
    private String etc;

    public CourseDto() {
    }

    public CourseDto(Integer courseCode, String courseName, String regDate, Integer firstIdNo, String modifyDate, Integer lastIdNo, String etc) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.regDate = regDate;
        this.firstIdNo = firstIdNo;
        this.modifyDate = modifyDate;
        this.lastIdNo = lastIdNo;
        this.etc = etc;
    }

    public Integer getCourseCode() {
        return courseCode;
    }

    public void setCourseCode(Integer courseCode) {
        this.courseCode = courseCode;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
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
        CourseDto courseDto = (CourseDto) o;
        return Objects.equals(courseCode, courseDto.courseCode) && Objects.equals(courseName, courseDto.courseName) && Objects.equals(regDate, courseDto.regDate) && Objects.equals(firstIdNo, courseDto.firstIdNo) && Objects.equals(modifyDate, courseDto.modifyDate) && Objects.equals(lastIdNo, courseDto.lastIdNo) && Objects.equals(etc, courseDto.etc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode, courseName, regDate, firstIdNo, modifyDate, lastIdNo, etc);
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "courseCode=" + courseCode +
                ", courseName='" + courseName + '\'' +
                ", regDate='" + regDate + '\'' +
                ", firstIdNo=" + firstIdNo +
                ", modifyDate='" + modifyDate + '\'' +
                ", lastIdNo=" + lastIdNo +
                ", etc='" + etc + '\'' +
                '}';
    }
}
