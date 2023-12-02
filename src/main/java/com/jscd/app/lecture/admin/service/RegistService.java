package com.jscd.app.lecture.admin.service;


import com.jscd.app.lecture.admin.dto.CourseDto;
import com.jscd.app.lecture.admin.dto.RoundDto;

import java.util.List;

public interface RegistService {
    List<CourseDto> getCourseList() throws Exception;
    int addCourse(CourseDto dto) throws Exception;
    CourseDto readCourse(Integer courseCode) throws Exception;
    int removeCourse(Integer courseCode) throws Exception;
    int modifyCourse(CourseDto dto) throws Exception;
    List<RoundDto> getRoundList() throws Exception;
    int addRound(RoundDto dto) throws Exception;
    RoundDto readRound(Integer roundCode) throws Exception;
    int removeRound(Integer roundCode) throws Exception;
    int modifyRound(RoundDto dto) throws Exception;
}
