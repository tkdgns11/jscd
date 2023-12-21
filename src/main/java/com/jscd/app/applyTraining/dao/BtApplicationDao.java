package com.jscd.app.applyTraining.dao;

import com.jscd.app.applyTraining.dto.BtApplicationDto;
import com.jscd.app.applyTraining.dto.SearchApplication;

import java.util.List;
import java.util.Map;

public interface BtApplicationDao {
    int count() throws Exception;

    int countWaiting() throws Exception; //승인대기중

    int countApproval() throws Exception; //승인완료

    int countNotApproval() throws Exception; //미승인

    int countWaitPay() throws Exception; //결제대기

    int countRegist() throws Exception; //등록완료

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
