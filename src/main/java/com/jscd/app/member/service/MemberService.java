package com.jscd.app.member.service;

import com.jscd.app.applyTraining.dto.BtApplicationDto;
import com.jscd.app.board.qna.qnaDto.AttachDto;
import com.jscd.app.lecture.lstRegist.dto.LectureApplyDto;
import com.jscd.app.member.dto.MemberDto;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;

public interface MemberService {

	public boolean login(String id, String pwd) throws Exception;
	public MemberDto memberSelect(String id) throws Exception;
	public void logout(HttpSession session);
	public int signup(MemberDto memberDto) throws Exception;
	public int memberEdit(MemberDto memberDto) throws Exception;
	public int memberDelete(String id) throws Exception;

	//회원 약관 동의
	public int insertTermsYN(MemberDto memberDto) throws  Exception;
	//마이페이지 강의 현황
	public List<LectureApplyDto> selectLecture(LectureApplyDto lectureApplyDto) throws Exception;
	//<payhty.status> == 'paid'일 때, <stod.status> && <lectureApply.status> == 'paid' update
//	void updateStatusToPaid(LectureApplyDto lectureApplyDto);
	int getGeneralMember() throws Exception;

	int getStudentMember() throws Exception;
	String getEmail(MemberDto memberDto)throws Exception;
	int modifyPwd(MemberDto memberDto)throws Exception;


	}