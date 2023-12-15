package com.jscd.app.lecture.classEnroll.dao;

import com.jscd.app.lecture.classEnroll.dto.ClassEnrollDto;

import java.util.List;

public interface ClassEnrollDao {
    List<ClassEnrollDto> selectAll(Integer classCode) throws Exception;

    ClassEnrollDto select(Integer classCode) throws Exception;

    int insert(ClassEnrollDto dto) throws Exception;

    int update(ClassEnrollDto dto) throws Exception;

    int delete(Integer classCode) throws Exception;

    int deleteAll() throws Exception;

    List<ClassEnrollDto> selectBoot(Integer courseCode) throws Exception;
}
