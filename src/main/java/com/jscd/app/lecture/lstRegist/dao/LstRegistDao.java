package com.jscd.app.lecture.lstRegist.dao;

import com.jscd.app.lecture.lstRegist.dto.LstRegistDto;

import java.util.List;
import java.util.Map;

public interface LstRegistDao {
    int countRegist() throws Exception;
    int addRegist(LstRegistDto dto) throws Exception;
    List<LstRegistDto> getRegistList() throws Exception;
    Map<String, Object> readRegist(Integer registCode) throws Exception;
    int modifyRegist(LstRegistDto dto) throws Exception;
    int removeAllRegist(Integer registCode) throws Exception;
    int removeRegist(Integer registCode) throws Exception;
}
