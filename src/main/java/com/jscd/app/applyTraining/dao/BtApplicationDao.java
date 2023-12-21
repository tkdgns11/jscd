package com.jscd.app.applyTraining.dao;

import com.jscd.app.applyTraining.dto.BtApplicationDto;
import com.jscd.app.applyTraining.dto.SearchApplication;

import java.util.List;
import java.util.Map;

public interface BtApplicationDao {
    int count() throws Exception;

    int deleteAll() throws Exception;

    int delete(Integer stfmNo) throws Exception;

    List<BtApplicationDto> selectAll() throws Exception;

    BtApplicationDto select(Integer stfmNo) throws Exception;

    List<BtApplicationDto> selectPage(Map map) throws Exception;

    int update(BtApplicationDto dto) throws Exception;

    int insert(BtApplicationDto dto) throws Exception;

    int lectureApplyInsert(BtApplicationDto dto) throws Exception;

    int confirmApplcation(BtApplicationDto dto) throws Exception;

    List<BtApplicationDto> searchSelectPage(SearchApplication sa) throws Exception;

    int searchResultCnt(SearchApplication sa) throws Exception;
}
