package com.jscd.app.member.controller;

import com.jscd.app.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


	/*
	작성일:20231117
	작성자:강정수
	작성 기능: 회원 관리
	 */

@Controller
@RequestMapping("/login")
public class MemberController {
	
	private MemberService memberService;

	@Autowired
	public MemberController(MemberService memberService){
		this.memberService = memberService;
	}

	@GetMapping("/login")
	public String loginPageMove(){

	}


}