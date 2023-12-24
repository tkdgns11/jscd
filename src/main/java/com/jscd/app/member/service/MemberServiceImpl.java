package com.jscd.app.member.service;

import javax.servlet.http.HttpSession;

import com.jscd.app.lecture.lstRegist.dto.LectureApplyDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.jscd.app.member.dao.MemberDao;
import com.jscd.app.member.dto.MemberDto;

import java.util.List;


/*
작성일:20231117
작성자:강정수
작성 기능: 회원 관리
 */
@Service
public class MemberServiceImpl implements MemberService {

	@Autowired
	MemberDao memberDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	public boolean login(String id, String pwd) throws Exception {
		MemberDto memberDto = null;

		try {
			memberDto = memberDao.selectUser(id);
			System.out.println("memberSeviceImpl=="+memberDto);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return memberDto != null && passwordEncoder.matches(pwd, memberDto.getPwd());
	}

	@Override
	public MemberDto memberSelect(String id) throws Exception {
		return memberDao.selectUser(id);
	}

	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

	@Override
	public int signup(MemberDto memberDto) throws Exception {
		return memberDao.insertUser(memberDto);
	}

	@Override
	public int memberEdit(MemberDto memberDto) throws Exception {
		return memberDao.updateUser(memberDto);
	}

	@Override
	public int memberDelete(String id) throws Exception {
		return memberDao.deleteUser(id);
	}

	@Override
	public int insertTermsYN(MemberDto memberDto) throws Exception {
		return memberDao.insertTermsYN(memberDto);
	}

	@Override
	public List<LectureApplyDto> selectLecture(LectureApplyDto lectureApplyDto) throws Exception {
		return memberDao.selectLecture(lectureApplyDto);
	}

	//<payhty.status> == 'paid'일 때, <stod.status> && <lectureApply.status> == 'paid' update
//	@Override
//	public void updateStatusToPaid(LectureApplyDto lectureApplyDto) {
//		memberDao.updateStatusToPaid(lectureApplyDto);
//	}
	
	@Override
	public int getGeneralMember() throws Exception {
		return memberDao.countGeneral();
	}

	@Override
	public int getStudentMember() throws Exception {
		return memberDao.countStudent();
	}

	@Override
	public String getEmail(MemberDto memberDto)throws Exception{
		return memberDao.selectEmail(memberDto);
	}

	@Override
	public int modifyPwd(MemberDto memberDto)throws Exception{
		return memberDao.updatePwd(memberDto);
	}

}

