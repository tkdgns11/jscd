package com.jscd.app.admin.dao;

import com.jscd.app.member.dto.MemberDto;

import java.util.List;

public interface MemberManageDao {
    int count()throws Exception;
    List<MemberDto> selectAll() throws Exception;

    MemberDto select(Integer mebrNo) throws Exception;

    int update(MemberDto memberDto) throws Exception;
    int updateDetail(MemberDto memberDto)throws Exception;
    int delete(Integer mebrNo)throws Exception;
    void deleteAll()throws Exception;
}
