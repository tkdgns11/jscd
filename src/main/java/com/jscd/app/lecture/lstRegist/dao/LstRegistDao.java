package com.jscd.app.lecture.lstRegist.dao;

import com.jscd.app.lecture.lstRegist.dto.LstRegistDto;
import com.jscd.app.lecture.lstRegist.dto.SearchCondition;

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

    int searchResultCnt(SearchCondition sc) throws Exception;
    List<LstRegistDto> searchSelectPage(SearchCondition sc) throws Exception;

    List<LstRegistDto> getSeminarList() throws Exception;
    LstRegistDto readSeminar(Integer registCode) throws Exception;

    List<LstRegistDto> getBootCampList() throws Exception;
    LstRegistDto readBootCamp(Integer registCode) throws Exception;

}
