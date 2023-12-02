package com.jscd.app.lecture.admin.service;

import com.jscd.app.lecture.admin.dao.RegistDao;
import com.jscd.app.lecture.admin.dto.CourseDto;
import com.jscd.app.lecture.admin.dto.RoundDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistServiceImpl implements RegistService {
    @Autowired
    RegistDao registDao;

    @Override
    public List<CourseDto> getCourseList() throws Exception {
        return registDao.getCourseList();
    }

    @Override
    public int addCourse(CourseDto dto) throws Exception {
        return registDao.addCourse(dto);
    }

    @Override
    public CourseDto readCourse(Integer courseCode) throws Exception {
        CourseDto courseDto = registDao.readCourse(courseCode);
        return courseDto;
    }

    @Override
    public int removeCourse(Integer courseCode) throws Exception {
        return registDao.removeCourse(courseCode);
    }

    @Override
    public int modifyCourse(CourseDto dto) throws Exception {
        return registDao.modifyCourse(dto);
    }

    @Override
    public List<RoundDto> getRoundList() throws Exception {
        return registDao.getRoundList();
    }

    @Override
    public int addRound(RoundDto dto) throws Exception {
        return registDao.addRound(dto);
    }

    @Override
    public RoundDto readRound(Integer roundCode) throws Exception {
        RoundDto roundDto = registDao.readRound(roundCode);
        return roundDto;
    }

    @Override
    public int removeRound(Integer roundCode) throws Exception {
        return registDao.removeRound(roundCode);
    }

    @Override
    public int modifyRound(RoundDto dto) throws Exception {
        return registDao.modifyRound(dto);
    }
}
