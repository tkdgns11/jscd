package com.jscd.app.lecture.bootCamp.dao;

import com.jscd.app.lecture.bootCamp.dto.BootCampDto;

import java.util.List;
import java.util.Map;

public interface BootCampDao {
    BootCampDto selectBoot(String classEnrollNo) throws Exception;
    int insertBootCamp(BootCampDto bootCampDto) throws Exception;
    List<BootCampDto> selectPage(Map map) throws Exception;
    List<BootCampDto> selectAll() throws Exception;
    int count() throws Exception;
}
