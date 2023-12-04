package com.jscd.app.lecture.lstRegist.service;

import com.jscd.app.lecture.lstRegist.dto.LstRegistDto;

import java.util.List;

public interface LstService {
    List<LstRegistDto> getLstRegistList() throws Exception;
    int addRegist(LstRegistDto dto) throws Exception;
    LstRegistDto readRegist(Integer registCode) throws Exception;
    int removeRegist(Integer registCode) throws Exception;
    int modifyRegist(LstRegistDto dto) throws Exception;
}
