package com.jscd.app.lecture.classEnroll.service;

import com.jscd.app.lecture.classEnroll.dto.ClassEnrollDto;

import java.util.List;

public interface ClassEnrollService {
    List<ClassEnrollDto> getList(Integer courseCode) throws Exception;

    ClassEnrollDto read(Integer classCode) throws Exception;

    int write(ClassEnrollDto dto) throws Exception;

    int modify(ClassEnrollDto dto) throws Exception;

    int remove(Integer classCode) throws Exception;

//    부트캠프 신청 상세페이지에서 부트캠프 관련 category와 content만 불러오기.
    List<ClassEnrollDto> getBootList(Integer courseCode) throws Exception;
}
