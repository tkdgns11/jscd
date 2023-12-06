package com.jscd.app.member.dao;

import com.jscd.app.member.dto.MemberDto;

public interface MemberDao {
	MemberDto selectUser(String id) throws Exception;
    int deleteUser(String id) throws Exception;
    int insertUser(MemberDto memberDto) throws Exception;
    int updateUser(MemberDto memberDto) throws Exception;
    int count() throws Exception;
    int deleteAll() throws Exception;
    int insertTermsYN(MemberDto memberDto) throws Exception;
}
