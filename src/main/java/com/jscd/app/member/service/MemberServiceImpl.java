package com.jscd.app.member.service;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jscd.app.member.dao.MemberDao;
import com.jscd.app.member.dto.MemberDto;
	/*
	작성일:20231117
	작성자:강정수
	작성 기능: 회원 관리
	 */
@Service
public class MemberServiceImpl implements MemberService {
	
	@Autowired
	MemberDao memberDao;
	
	@Override
	public boolean loginCheck(String id, String pwd) throws Exception {
		MemberDto memberDto = null;
		
		try {
			memberDto = memberDao.selectUser(id);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return memberDto != null && memberDto.getPwd().equals(pwd);
	}
	
	@Override
	public void logout(HttpSession session) {
		session.invalidate();
	}

	@Override
	public int signUp(MemberDto memberDto) throws Exception {
		return memberDao.insertUser(memberDto);
	}
}
