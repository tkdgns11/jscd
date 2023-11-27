package com.jscd.app.member.controller;

import com.jscd.app.member.dto.KakaoLoginBo;
import com.jscd.app.member.dto.NaverLoginBo;
import com.jscd.app.member.dto.mailSender;
import com.jscd.app.member.dto.MemberDto;
import com.jscd.app.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;


/*
작성일:20231117
작성자:강정수
작성 기능: 회원 관리
 */

@Controller
@RequestMapping("/member/*")
public class MemberController {
	private MemberService memberService;
	private NaverLoginBo naverLoginBo;

	private KakaoLoginBo kakaoLoginBo;
	@Autowired
	public MemberController(MemberService memberService, NaverLoginBo naverLoginBo,KakaoLoginBo kakaoLoginBo){
		this.memberService = memberService;
		this.naverLoginBo = naverLoginBo;
		this.kakaoLoginBo = kakaoLoginBo;
	}

	/*
	작성일:20231117
	작성자:강정수
	작성 기능: 로그인 및 로그아웃
	 */
	@GetMapping("/login")
	public String loginPageMove(Model model, HttpSession session){

		String naverAuthUrl = naverLoginBo.getAuthorizationUrl(session);
		System.out.println("네이버" + naverAuthUrl);
		model.addAttribute("urlNaver", naverAuthUrl);

		String kakaoAuthUrl = kakaoLoginBo.getAuthorizationUrl(session);
		System.out.println("카카오" + kakaoAuthUrl);
		model.addAttribute("urlKakao", kakaoAuthUrl);



		return "/member/login";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		// 1. 세션을 종료
		session.invalidate();
		// 2. 홈으로 이동
		return "redirect:/";
	}
	@PostMapping("/login")
	@ResponseBody
	public Map<String, String> loginCheck(@RequestBody MemberDto memberDto, String toUrl, HttpServletRequest request, HttpServletResponse response) throws Exception {

		String id = memberDto.getId();
		String pwd = memberDto.getPwd();
		String rememberId = memberDto.getRememberId();
		Map<String, String> map = new HashMap<>();
		System.out.println(id+pwd+rememberId);

		//1. id, pwd 체크
		//1-1 일치하지 않음.
		if(!memberService.login(id, pwd)){
			String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");
			map.put("redirect", "/member/login?msg="+msg);
			return map;
		}
		//1-2 일치하는 경우
		HttpSession session = request.getSession();
		session.setAttribute("id",id);

		//2.아이디 기억 처리
		if(rememberId.equals("true")){
			//2-1.쿠키 생성 및 응답에 저장
			Cookie cookie = new Cookie("id", id);
			response.addCookie(cookie);
		} else {
			//2-2. 쿠키 삭제 및 응답에 저장
			Cookie cookie = new Cookie("id", id);
			cookie.setMaxAge(0);
			response.addCookie(cookie);
		}

		toUrl = toUrl == null || toUrl.equals("") ? "/" : toUrl;

		map.put("redirect",toUrl);
		return map;
	}


	/*
	작성일:20231117
	작성자:강정수
	작성 기능: 회원 가입 및 관리
	 */

	@GetMapping("/signup")
	public String signupPageMove() {
		System.out.println("여기!!!!");
		return "/member/signup";

	}

	//회원가입
	@PostMapping("/signup")
	@ResponseBody
	public Map<String, String> signup(MemberDto memberDto) throws Exception {
		Map<String, String> map = new HashMap<>();
		try{
			System.out.println("memberDto!!!!"+memberDto);
			memberService.signUp(memberDto);
			System.out.println("회원가입 성공");
			map.put("redirect","/member/login");
		}catch (Exception e){
			map.put("error","회원가입에 실패했습니다.");
		}
		return map;
	}

	@GetMapping("/memberEdit")
	public String memberEdit(Model model, HttpServletRequest request, HttpServletResponse response) throws Exception{
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		System.out.println("memberEdit===" + id);
		MemberDto memberDto = memberService.memberSelect(id);
		model.addAttribute(memberDto);


		return "/member/signup";
	}

	public String memberDelete(MemberDto memberDto) throws Exception{
		System.out.println("memberDelete===" + memberDto);
		memberService.memberDelete(memberDto.getId());
		return null;
	}

	//이메일 인증
	@GetMapping("/mailChk")
	@ResponseBody
	public String mailChk(String email){
		mailSender mailSender;
		System.out.println("이메일 인증 요청이 들어옴");
		System.out.println("이메일 인증" + email);

		return null;
	}

}

