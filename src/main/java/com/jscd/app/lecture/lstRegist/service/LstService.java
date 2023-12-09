package com.jscd.app.lecture.lstRegist.service;

import com.jscd.app.lecture.course.dto.CourseDto;
import com.jscd.app.lecture.lstRegist.dto.LstRegistDto;
import com.jscd.app.lecture.lstRegist.dto.SearchCondition;

import java.util.List;
import java.util.Map;

public interface LstService {
    List<LstRegistDto> getLstRegistList() throws Exception;
    int addRegist(LstRegistDto dto) throws Exception;
    Map<String, Object> readRegist(Integer registCode) throws Exception;
    int removeRegist(Integer registCode) throws Exception;
    int modifyRegist(LstRegistDto dto) throws Exception;

    int getSearchResultCnt(SearchCondition sc) throws Exception;
    List<LstRegistDto> getSearchResultPage(SearchCondition sc) throws Exception;

    //    세미나 리스트 불러오기
    List<LstRegistDto> seminarList() throws Exception;
    //    세미나 세부항목 불러오기
    LstRegistDto seminarRead(Integer registCode) throws Exception;
    //    부트캠프 리스트 불러오기
    List<LstRegistDto> bootCampList() throws Exception;
    //    부트캠프 세부항목 불러오기
    LstRegistDto bootCampRead(Integer registCode) throws Exception;

}
