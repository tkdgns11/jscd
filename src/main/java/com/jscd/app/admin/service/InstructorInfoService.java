package com.jscd.app.admin.service;

import com.jscd.app.admin.domain.SearchCondition;
import com.jscd.app.admin.dto.InstructorInfoDto;
import com.jscd.app.admin.dto.InstructorMemberInfoDto;

import java.util.List;

public interface InstructorInfoService {
    int write(InstructorInfoDto instructorInfoDto) throws Exception;

    int getCount() throws Exception;

    List<InstructorMemberInfoDto> getList(int offset, int pageSize) throws Exception;

    InstructorMemberInfoDto read(Integer iscrNo) throws Exception;

    int modify(InstructorInfoDto instructorInfoDto) throws Exception;

    int modifyStatus(Integer status,List<Integer>mebrNo) throws Exception;


    int remove(Integer mebrNo) throws Exception;

    List<InstructorMemberInfoDto> getSearchPage(SearchCondition sc) throws Exception;

    int getSearchResultCnt(SearchCondition sc) throws Exception;
}
