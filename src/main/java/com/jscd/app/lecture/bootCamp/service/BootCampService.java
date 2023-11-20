package com.jscd.app.lecture.bootCamp.service;

import com.jscd.app.lecture.bootCamp.dto.BootCampDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

public interface BootCampService {
    // 부트캠프 등록
    int registBootCamp(BootCampDto bootCampDto) throws Exception;
    // 부트캠프 리스트
    List<BootCampDto> getList() throws Exception;
    List<BootCampDto> getPage(Map map) throws Exception;
    //
    int getCount() throws Exception;

}
