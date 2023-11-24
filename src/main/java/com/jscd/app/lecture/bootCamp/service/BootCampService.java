package com.jscd.app.lecture.bootCamp.service;

import com.jscd.app.lecture.bootCamp.dto.BootCampDto;

import java.util.List;
import java.util.Map;

public interface BootCampService {
    int getCount() throws Exception;

    int remove(Integer classEnrollNo, String writer) throws Exception;

    int write(BootCampDto dto) throws Exception;

    List<BootCampDto> getList() throws Exception;

    BootCampDto read(Integer classEnrollNo) throws Exception;

    List<BootCampDto> getPage(Map map) throws Exception;

    int modify(BootCampDto dto) throws Exception;
}
