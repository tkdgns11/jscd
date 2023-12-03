package com.jscd.app.member.controller;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.jscd.app.member.dto.KakaoLoginBo;
import com.jscd.app.member.dto.NaverLoginBo;
import com.jscd.app.member.dto.mailSender;
import com.jscd.app.member.dto.MemberDto;
import com.jscd.app.member.service.MemberService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


@Controller
@RequestMapping("/member/*")
public class MemberController {
	private MemberService memberService;
	private NaverLoginBo naverLoginBo;
	private KakaoLoginBo kakaoLoginBo;
	private String apiResult = null;
	@Autowired
	public MemberController(MemberService memberService, NaverLoginBo naverLoginBo,KakaoLoginBo kakaoLoginBo){
		this.memberService = memberService;
		this.naverLoginBo = naverLoginBo;
		this.kakaoLoginBo = kakaoLoginBo;
	}


	//로그인 페이지 이동
	@GetMapping("/login")
	public String loginPageMove(Model model, HttpSession session){

		//네이버 랜덤으로 난수 생성해서 값 넘겨주기
		String naverAuthUrl = naverLoginBo.getAuthorizationUrl(session);
		System.out.println("네이버" + naverAuthUrl);
		model.addAttribute("urlNaver", naverAuthUrl);

		//카카오 랜덤으로 난수 생성해서 값 넘겨주기
		String kakaoAuthUrl = kakaoLoginBo.getAuthorizationUrl(session);
		System.out.println("카카오" + kakaoAuthUrl);
		model.addAttribute("urlKakao", kakaoAuthUrl);

		return "/member/login";
	}

	//카카오 로그인 api 기능 구현
	@GetMapping("/kakaoLogin")
	public String kakaoLogin(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws Exception{

		OAuth2AccessToken oAuth2AccessToken;

		oAuth2AccessToken  = kakaoLoginBo.getAccessToken(session, code, state);
		//로그인 사용자 정보를 읽어온다.
		apiResult = kakaoLoginBo.getUserProfile(oAuth2AccessToken);

		//json으로 받아온 데이터 처리
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObj;
		jsonObj = (JSONObject) jsonParser.parse(apiResult);
		JSONObject response_obj = (JSONObject) jsonObj.get("kakao_account");
		JSONObject response_obj2 = (JSONObject) jsonObj.get("profile");

		//memberDto 객체에 담기 전 변수에 저장
		String id = (String) response_obj.get("email");
		String name = (String) response_obj.get("name");
		String nickname = (String) response_obj.get("nickname");
		//비밀번호 해시코드로 저장
		String pwd = String.valueOf(Objects.hash(id)*31);
		//성별 처리
		String genderResult = (String) response_obj.get("gender");
		int gender = 0;
		if(genderResult.equals("F")){
			gender = 1;
		}
		//생년월일처리
		String birthday = (String) response_obj.get("birthday");
		String birthyear = (String)response_obj.get("birthyear");
		String birth = birthyear.substring(2) + birthday.replace("-","");
		String phone = (String)response_obj.get("phone_number");


		//회원 테이블에 없는 경우 회원가입 진행
		MemberDto memberDto = new MemberDto();
		if(memberService.memberSelect(id)==null){
			memberDto.setId(id);
			memberDto.setName(name);
			memberDto.setNickname(nickname);
			memberDto.setPwd(pwd);
			memberDto.setGender(gender);
			memberDto.setBirth(birth);
			memberDto.setPhone(phone);

			memberService.signup(memberDto);

		}
		//로그인 세션 처리
		session.setAttribute("signIn",apiResult);
		session.setAttribute("id", id);
		session.setAttribute("nickname", nickname);

		return "redirect:/";

	}

	//네이버 로그인 api 기능 구현
	@GetMapping("/naverLogin")
	public String naverLogin(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws Exception {

		OAuth2AccessToken oAuth2AccessToken;

		oAuth2AccessToken = naverLoginBo.getAccessToken(session, code, state);
		//로그인 사용자 정보를 읽어온다.
		apiResult = naverLoginBo.getUserProfile(oAuth2AccessToken);

		//json으로 받아온 데이터 처리
		JSONParser jsonParser = new JSONParser();
		JSONObject jsonObj;
		jsonObj = (JSONObject) jsonParser.parse(apiResult);
		JSONObject response_obj = (JSONObject) jsonObj.get("response");

		//memberDto 객체에 담기 전 변수에 저장
		String id = (String) response_obj.get("email");
		String name = (String) response_obj.get("name");
		String nickname = (String) response_obj.get("nickname");
		//비밀번호 해시코드로 저장
		String pwd = String.valueOf(Objects.hash(id) * 31);
		//성별 처리
		String genderResult = (String) response_obj.get("gender");
		int gender = 0;
		if (genderResult.equals("F")) {
			gender = 1;
		}
		//생년월일처리
		String birthday = (String) response_obj.get("birthday");
		String birthyear = (String) response_obj.get("birthyear");
		String birth = birthyear.substring(2) + birthday.replace("-", "");
		String phone = (String) response_obj.get("mobile");


		//회원 테이블에 없는 경우 회원가입 진행
		MemberDto memberDto = new MemberDto();
		if (memberService.memberSelect(id) == null) {
			System.out.println(memberDto);
			memberDto.setId(id);
			memberDto.setName(name);
			memberDto.setNickname(nickname);
			memberDto.setPwd(pwd);
			memberDto.setGender(gender);
			memberDto.setBirth(birth);
			memberDto.setPhone(phone);

			memberService.signup(memberDto);

		}

		//로그인 세션 처리
		session.setAttribute("signIn", apiResult);
		session.setAttribute("id", id);
		session.setAttribute("nickname", nickname);

		return "redirect:/";

	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		//네이버 로그인일 경우?
		//카카오 로그인일 경우?

		// 1. 세션을 종료
		session.invalidate();
		// 2. 홈으로 이동
		return "redirect:/";
	}
	
	//로그인 체크(회원인지 아닌지)
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

	//회원가입 페이지 이동
	@GetMapping("/signup")
	public String signupPageMove() {
		return "/member/signup";

	}

	//회원가입
	@PostMapping("/signup")
	@ResponseBody
	public Map<String, String> signup(MemberDto memberDto) throws Exception {
		Map<String, String> map = new HashMap<>();

		try{
			//회원가입에 성공했을 경우
			memberService.signup(memberDto);
			map.put("redirect","/member/login");
		}catch (Exception e){
			//회원가입에 실패했을 경우
			map.put("error","회원가입에 실패했습니다.");
		}
		return map;
	}

	//회원 개인정보수정 페이지 이동
	@GetMapping("/memberEdit")
	public String memberEditPage(Model model, HttpServletRequest request) throws Exception{
		//세션 값 가져와서 아이디 조회
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		//아이디 조회에 따른 결과 보여주기
		MemberDto memberDto = memberService.memberSelect(id);
		//결과 담아주기
		model.addAttribute(memberDto);
		return "/member/signup";
	}

	//회원, 개인정보수정 기능 구현
	@PostMapping("/memberEdit")
	public Map<String, String> memberEdit(MemberDto memberDto) throws Exception{
		Map<String, String> map = new HashMap<>();

		try{
			//개인정보수정
			memberService.memberEdit(memberDto);
			map.put("redirect","/member/login");
		}catch (Exception e){
			//회원가입에 실패했을 경우
			map.put("error","개인정보수정에 실패했습니다.");
		}
		return map;
	}

	//회원 삭제
	@PostMapping("/delete")
	@ResponseBody
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

