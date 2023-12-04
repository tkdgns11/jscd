package com.jscd.app.lecture.seminar.dao;

import com.jscd.app.lecture.seminar.dto.SeminarRegistDto;

import java.util.List;
import java.util.Map;

public interface SeminarRegistDao {
    int count() throws Exception;

    int deleteAll() throws Exception;

    int delete(Integer classEnrollNo, String writer) throws Exception;

    int insert(SeminarRegistDto dto) throws Exception;

    List<SeminarRegistDto> selectAll() throws Exception;

    SeminarRegistDto select(Integer classEnrollNo) throws Exception;

    List<SeminarRegistDto> selectPage(Map map) throws Exception;

    int update(SeminarRegistDto dto) throws Exception;

    int increaseViewCnt(Integer classEnrollNo) throws Exception;

//    int searchResultCnt(SeminarRegistSearch ss) throws Exception;
//    List<SeminarRegistDto> searchSelectPage(SeminarRegistSearch ss) throws Exception;

}
