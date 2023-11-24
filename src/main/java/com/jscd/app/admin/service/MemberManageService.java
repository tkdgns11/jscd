package com.jscd.app.admin.service;

import com.jscd.app.admin.domain.SearchCondition;
import com.jscd.app.member.dto.MemberDto;

import java.util.List;

public interface MemberManageService {
    int getCount() throws Exception;

    List<MemberDto> getList(int offset, int pageSize) throws Exception;

    MemberDto read(Integer mebrNo) throws Exception;

    int modify(MemberDto memberDto) throws Exception;

    int modifyDetail(MemberDto memberDto) throws Exception;

    int remove(Integer mebrNo) throws Exception;
    List<MemberDto> getSearchPage(SearchCondition sc)throws Exception;
    int getSearchResultCnt(SearchCondition sc)throws Exception;
}
