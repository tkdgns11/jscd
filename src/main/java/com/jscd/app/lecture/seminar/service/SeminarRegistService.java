package com.jscd.app.lecture.seminar.service;

import com.jscd.app.lecture.seminar.dto.SeminarRegistDto;

import java.util.List;
import java.util.Map;

public interface SeminarRegistService {
    int getCount() throws Exception;

    int remove(Integer classEnrollNo, String writer) throws Exception;

    int write(SeminarRegistDto dto) throws Exception;

    List<SeminarRegistDto> getList() throws Exception;

    SeminarRegistDto read(Integer classEnrollNo) throws Exception;

    List<SeminarRegistDto> getPage(Map map) throws Exception;

    int modify(SeminarRegistDto dto) throws Exception;
}
