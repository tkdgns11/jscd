package com.jscd.app.lecture.course.dto;

import java.util.Objects;

public class CourseDto {
    private Integer courseCode;
    private String courseName;
    private String regDate;
    private Integer firstIdNO;
    private String modifyDate;
    private Integer lastIdNO;
    private String etc;

    public CourseDto() {
    }

    public CourseDto(Integer courseCode, String courseName, String regDate, Integer firstIdNO, String modifyDate, Integer lastIdNO, String etc) {
        this.courseCode = courseCode;
        this.courseName = courseName;
        this.regDate = regDate;
        this.firstIdNO = firstIdNO;
        this.modifyDate = modifyDate;
        this.lastIdNO = lastIdNO;
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
        return Objects.equals(courseCode, courseDto.courseCode) && Objects.equals(courseName, courseDto.courseName) && Objects.equals(regDate, courseDto.regDate) && Objects.equals(firstIdNO, courseDto.firstIdNO) && Objects.equals(modifyDate, courseDto.modifyDate) && Objects.equals(lastIdNO, courseDto.lastIdNO) && Objects.equals(etc, courseDto.etc);
    }

    @Override
    public int hashCode() {
        return Objects.hash(courseCode, courseName, regDate, firstIdNO, modifyDate, lastIdNO, etc);
    }

    @Override
    public String toString() {
        return "CourseDto{" +
                "courseCode=" + courseCode +
                ", courseName='" + courseName + '\'' +
                ", regDate='" + regDate + '\'' +
                ", firstIdNO=" + firstIdNO +
                ", modifyDate='" + modifyDate + '\'' +
                ", lastIdNO=" + lastIdNO +
                ", etc='" + etc + '\'' +
                '}';
    }
}
