package com.jscd.app.lecture.course.service;

import com.jscd.app.lecture.course.dto.CourseDto;

import java.util.List;

public interface CourseService {
    List<CourseDto> getCourseList() throws Exception;
    int addCourse(CourseDto dto) throws Exception;
    CourseDto readCourse(Integer courseCode) throws Exception;
    int removeCourse(Integer courseCode) throws Exception;
    int modifyCourse(CourseDto dto) throws Exception;
}
