package com.jscd.app.applyTraining.service;

import com.jscd.app.applyTraining.dto.BtApplicationDto;
import com.jscd.app.applyTraining.dto.SearchApplication;

import java.util.List;
import java.util.Map;

public interface BtApplicationService {
    int getCount() throws Exception;

    int getWaitingNum()  throws Exception;

    int getApprovalNum()  throws Exception;

    int getNotApprovalNum()  throws Exception;

    int getWaitPayNum()  throws Exception;

    int getRegistNum()  throws Exception;

    int remove(Integer stfmNo) throws Exception;

    List<BtApplicationDto> getList() throws Exception;

    BtApplicationDto read(Integer stfmNo) throws Exception;

    List<BtApplicationDto> getPage(Map map) throws Exception;

    int modify(BtApplicationDto dto) throws Exception;

    //
    int write(BtApplicationDto dto) throws Exception;
    //    부트캠프 폼 상태
    int lectureApplyInsert(BtApplicationDto dto) throws Exception;
    int confirmApplcation(BtApplicationDto dto) throws Exception;

    List<BtApplicationDto> getSearchResultpage(SearchApplication sa) throws Exception;

    int getSearchResulCnt(SearchApplication sa) throws Exception;
}
