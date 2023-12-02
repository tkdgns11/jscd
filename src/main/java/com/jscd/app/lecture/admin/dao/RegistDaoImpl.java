package com.jscd.app.lecture.admin.dao;

import com.jscd.app.lecture.admin.dto.CourseDto;
import com.jscd.app.lecture.admin.dto.RoundDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class RegistDaoImpl implements RegistDao {
    @Autowired
    private SqlSession session;
    private static String courseNamespace = "com.jscd.app.lecture.admin.courseMapper.";
    private static String roundNamespace = "com.jscd.app.lecture.admin.roundMapper.";
    @Override
    public List<CourseDto> getCourseList() throws Exception {
        return session.selectList(courseNamespace + "selectAll");
    }

    @Override
    public int addCourse(CourseDto dto) throws Exception {
        return session.insert(courseNamespace + "addCourse", dto);
    }

    @Override
    public CourseDto readCourse(Integer courseCode) throws Exception {
        return session.selectOne(courseNamespace + "readCourse", courseCode);
    }

    @Override
    public int removeCourse(Integer courseCode) throws Exception {
        return session.delete(courseNamespace + "removeCourse", courseCode);
    }

    @Override
    public int modifyCourse(CourseDto dto) throws Exception {
        return session.update(courseNamespace + "modifyCourse", dto);
    }

    @Override
    public List<RoundDto> getRoundList() throws Exception {
        return session.selectList(roundNamespace + "selectAll");
    }

    @Override
    public int addRound(RoundDto dto) throws Exception {
        return session.insert(roundNamespace + "addRound", dto);
    }

    @Override
    public RoundDto readRound(Integer roundCode) throws Exception {
        return session.selectOne(roundNamespace + "readRound", roundCode);
    }

    @Override
    public int removeRound(Integer roundCode) throws Exception {
        return session.delete(roundNamespace + "removeRound", roundCode);
    }

    @Override
    public int modifyRound(RoundDto dto) throws Exception {
        return session.update(roundNamespace + "modifyRound", dto);
    }
}
