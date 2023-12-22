package com.jscd.app.member.dao;

import com.jscd.app.applyTraining.dto.BtApplicationDto;
import com.jscd.app.board.qna.qnaDto.AttachDto;
import com.jscd.app.lecture.lstRegist.dto.LectureApplyDto;
import com.jscd.app.member.dto.MemberDto;

import java.util.List;

public interface MemberDao {
    MemberDto selectUser(String id) throws Exception;
    int deleteUser(String id) throws Exception;
    int insertUser(MemberDto memberDto) throws Exception;
    int updateUser(MemberDto memberDto) throws Exception;
    int count() throws Exception;
    int countGeneral() throws Exception;
    int countStudent() throws Exception;
    int deleteAll() throws Exception;
    //회원 약관
    int insertTermsYN(MemberDto memberDto) throws Exception;
    //마이페이지 강의 현황
    public List<LectureApplyDto> selectLecture(LectureApplyDto lectureApplyDto) throws Exception;
    String selectEmail(MemberDto memberDto)throws Exception;
    int updatePwd(MemberDto memberDto)throws Exception;


    }
