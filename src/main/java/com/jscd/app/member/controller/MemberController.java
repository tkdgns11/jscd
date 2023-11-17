package com.jscd.app.member.controller;

import com.jscd.app.member.dto.MemberDto;
import com.jscd.app.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;


/*
작성일:20231117
작성자:강정수
작성 기능: 회원 관리
 */

@Controller
@RequestMapping("/login/")
public class MemberController {
	
	private MemberService memberService;

	@Autowired
	public MemberController(MemberService memberService){
		this.memberService = memberService;
	}

	@GetMapping("/login")
	public String loginPageMove(){
		return "/member/login";
	}

	@PostMapping("/login")
	public String loginCheck(MemberDto memberDto) throws Exception {
		//1. 아이디 체크
		if(memberService.loginCheck(memberDto.getId(), memberDto.getPwd())) {
			return "redirect:/";
		}else {
			return "redirect:/member/login";
		}

	}


/*
작성일:20231117
작성자:강정수
작성 기능: 회원 관리
 */

@GetMapping("/signup")
public String signupPageMove() {
	System.out.println("여기!!!!");
	return "member/signup";

}

@PostMapping("/signup")
public String signup(MemberDto memberDto) throws Exception {

	System.out.println("memberDto!!!!"+memberDto);
	memberService.signUp(memberDto);
	return "redirect:/member/login";
}



}