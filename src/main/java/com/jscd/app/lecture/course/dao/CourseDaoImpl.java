package com.jscd.app.lecture.course.dao;

import com.jscd.app.lecture.course.dto.CourseDto;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CourseDaoImpl implements CourseDao{
    @Autowired
    SqlSession session;
    private static String courseNamespace = "com.jscd.app.lecture.course.courseMapper.";
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
}
