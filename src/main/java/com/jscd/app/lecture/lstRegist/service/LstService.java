package com.jscd.app.lecture.lstRegist.service;

import com.jscd.app.lecture.lstRegist.dto.LstRegistDto;

import java.util.List;
import java.util.Map;

public interface LstService {
    List<LstRegistDto> getLstRegistList() throws Exception;
    int addRegist(LstRegistDto dto) throws Exception;
    Map<String, Object> readRegist(Integer registCode) throws Exception;
    int removeRegist(Integer registCode) throws Exception;
    int modifyRegist(LstRegistDto dto) throws Exception;
}
