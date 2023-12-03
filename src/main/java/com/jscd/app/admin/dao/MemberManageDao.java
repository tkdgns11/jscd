package com.jscd.app.admin.dao;

import com.jscd.app.admin.domain.SearchCondition;
import com.jscd.app.admin.dto.MemberManageDto;
import com.jscd.app.member.dto.MemberDto;

import java.util.List;

public interface MemberManageDao {
    int count()throws Exception;
    List<MemberDto> selectAll(int offset, int pageSize) throws Exception;

    MemberManageDto select(Integer mebrNo) throws Exception;

    int update(Integer status,Integer grade, List<Integer> mebrNo) throws Exception;
    int updateDetail(MemberDto memberDto)throws Exception;
    int delete(Integer mebrNo)throws Exception;
    void deleteAll()throws Exception;
    List<MemberManageDto> searchSelectPage(SearchCondition sc)throws Exception;
    int searchResultCnt(SearchCondition sc)throws Exception;
}
