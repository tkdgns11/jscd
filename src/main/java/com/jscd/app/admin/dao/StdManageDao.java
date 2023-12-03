package com.jscd.app.admin.dao;

import com.jscd.app.admin.domain.SearchCondition;
import com.jscd.app.admin.dto.StdManageDto;
import com.jscd.app.admin.dto.StdMemberManageDto;

import java.util.List;

public interface StdManageDao {
    int insert(StdManageDto stdManageDto) throws Exception;

    int count() throws Exception;

    List<StdMemberManageDto> selectAll(int offset, int pageSize) throws Exception;

    StdMemberManageDto select(Integer mebrNo) throws Exception;

    int update(StdManageDto stdManageDto) throws Exception;

    int updateStatus(Integer status, List<Integer> mebrNo) throws Exception;


    int delete(Integer mebrNo) throws Exception;

    void deleteAll() throws Exception;

    List<StdMemberManageDto> searchSelectPage(SearchCondition sc) throws Exception;

    int searchResultCnt(SearchCondition sc) throws Exception;

}
