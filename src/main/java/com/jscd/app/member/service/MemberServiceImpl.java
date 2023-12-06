package com.jscd.app.member.service;

import javax.servlet.http.HttpSession;
import javax.swing.text.html.parser.Parser;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.jscd.app.member.dao.MemberDao;
import com.jscd.app.member.dto.MemberDto;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;


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
	public boolean login(String id, String pwd) throws Exception {
		MemberDto memberDto = null;
		
		try {
			memberDto = memberDao.selectUser(id);
			System.out.println(memberDto);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
		return memberDto != null && memberDto.getPwd().equals(pwd);
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


}
