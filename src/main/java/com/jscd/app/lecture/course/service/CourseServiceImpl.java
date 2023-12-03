package com.jscd.app.lecture.course.service;

import com.jscd.app.lecture.course.dao.CourseDao;
import com.jscd.app.lecture.course.dto.CourseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired
    CourseDao courseDao;
    @Override
    public List<CourseDto> getCourseList() throws Exception {
        return courseDao.getCourseList();
    }

    @Override
    public int addCourse(CourseDto dto) throws Exception {
        return courseDao.addCourse(dto);
    }

    @Override
    public CourseDto readCourse(Integer courseCode) throws Exception {
        CourseDto courseDto = courseDao.readCourse(courseCode);
        return courseDto;
    }

    @Override
    public int removeCourse(Integer courseCode) throws Exception {
        return courseDao.removeCourse(courseCode);
    }

    @Override
    public int modifyCourse(CourseDto dto) throws Exception {
        return courseDao.modifyCourse(dto);
    }
}
