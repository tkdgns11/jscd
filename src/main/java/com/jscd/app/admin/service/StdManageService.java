package com.jscd.app.admin.service;

import com.jscd.app.admin.domain.SearchCondition;
import com.jscd.app.admin.dto.StdManageDto;
import com.jscd.app.admin.dto.StdMemberManageDto;

import java.util.List;

public interface StdManageService {
    int write(StdManageDto stdManageDto) throws Exception;

    int getCount() throws Exception;

    List<StdMemberManageDto> getList(int offset,int pageSize) throws Exception;

    StdMemberManageDto read(Integer mebrNo) throws Exception;

    int modify(StdManageDto stdManageDto) throws Exception;

    int remove(Integer mebrNo) throws Exception;
    List<StdMemberManageDto> getSearchPage(SearchCondition sc)throws Exception;
    int getSearchResultCnt(SearchCondition sc)throws Exception;

}
