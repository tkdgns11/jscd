package com.jscd.app.applyTraining.dao;

import com.jscd.app.applyTraining.dto.BtApplicationDto;
import com.jscd.app.applyTraining.dto.SearchApplication;
import com.jscd.app.applyTraining.dto.SmApplicationDto;

import java.util.List;
import java.util.Map;

public interface SmApplicationDao {
    int count() throws Exception;
    int countWaitPay() throws Exception; //결제대기

    int countRegist() throws Exception; //등록완료

    int deleteAll() throws Exception;

    int delete(Integer stfmNo) throws Exception;

    List<SmApplicationDto> selectAll() throws Exception;

    SmApplicationDto select(Integer stfmNo) throws Exception;

    List<SmApplicationDto> selectPage(Map map) throws Exception;

    int update(SmApplicationDto dto) throws Exception;

    int insert(SmApplicationDto dto) throws Exception;

    int lectureApplyInsert(SmApplicationDto dto) throws Exception;

    int confirmApplcation(SmApplicationDto dto) throws Exception;

    List<SmApplicationDto> searchSelectPage(SearchApplication sa) throws Exception;

    int searchResultCnt(SearchApplication sa) throws Exception;
}
