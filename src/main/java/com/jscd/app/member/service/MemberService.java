package com.jscd.app.member.service;

import com.jscd.app.member.dto.MemberDto;
import org.springframework.beans.factory.annotation.Value;

import javax.servlet.http.HttpSession;
import java.util.HashMap;

public interface MemberService {

	 public boolean login(String id, String pwd) throws Exception;
	 public MemberDto memberSelect(String id) throws Exception;
	 public void logout(HttpSession session);
	 public int signUp(MemberDto memberDto) throws Exception;
	 public int memberEdit(MemberDto memberDto) throws Exception;
	 public int memberDelete(String id) throws Exception;


}