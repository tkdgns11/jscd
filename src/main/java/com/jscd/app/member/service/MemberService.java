package com.jscd.app.member.service;

import com.jscd.app.member.dto.MemberDto;

import javax.servlet.http.HttpSession;

public interface MemberService {
	 public boolean loginCheck(String id, String pwd) throws Exception;
	 public void logout(HttpSession session);
	 public int signUp(MemberDto memberDto) throws Exception;
}