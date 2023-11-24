package com.jscd.app.lecture.bootCamp.dao;

import com.jscd.app.lecture.bootCamp.dto.BootCampDto;

import java.util.List;
import java.util.Map;

public interface BootCampDao {
    int count() throws Exception;

    int deleteAll() throws Exception;

    int delete(Integer classEnrollNo, String writer) throws Exception;

    int insert(BootCampDto dto) throws Exception;

    List<BootCampDto> selectAll() throws Exception;

    BootCampDto select(Integer classEnrollNo) throws Exception;

    List<BootCampDto> selectPage(Map map) throws Exception;

    int update(BootCampDto dto) throws Exception;

    int increaseViewCnt(Integer classEnrollNo) throws Exception;
}
