package com.jscd.app.lecture.classEnroll.service;

import com.jscd.app.lecture.classEnroll.dto.ClassEnrollDto;

import java.util.List;

public interface ClassEnrollService {
    List<ClassEnrollDto> getList(Integer courseCode) throws Exception;

    ClassEnrollDto read(Integer classCode) throws Exception;

    int write(ClassEnrollDto dto) throws Exception;

    int modify(ClassEnrollDto dto) throws Exception;

    int remove(Integer classCode) throws Exception;

}
