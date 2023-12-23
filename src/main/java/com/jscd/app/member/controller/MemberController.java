package com.jscd.app.member.controller;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.jscd.app.admin.dto.InstructorInfoDto;
import com.jscd.app.admin.dto.InstructorMemberInfoDto;
import com.jscd.app.admin.service.InstructorInfoService;
import com.jscd.app.applyTraining.dto.BtApplicationDto;
import com.jscd.app.board.qna.qnaDto.AttachDto;
import com.jscd.app.lecture.lstRegist.dto.LectureApplyDto;
import com.jscd.app.member.dto.KakaoLoginBo;
import com.jscd.app.member.dto.MailSendService;
import com.jscd.app.member.dto.NaverLoginBo;
//import com.jscd.app.member.dto.mailSender;
import com.jscd.app.member.dto.MemberDto;
import com.jscd.app.member.service.MemberService;
import com.jscd.app.order.dto.CompanyInfoDTO;
import com.jscd.app.order.dto.StodDTO;
import com.jscd.app.order.service.CompanyInfoService;
import com.jscd.app.order.service.StodService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.*;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;


@Controller
@RequestMapping("/member/*")
public class MemberController {
	private MemberService memberService;
	private NaverLoginBo naverLoginBo;
	private KakaoLoginBo kakaoLoginBo;
	private String apiResult = null;
	private InstructorInfoService infoService;
	private final CompanyInfoService companyInfoService; //소희
	private final StodService stodService; //소희


//	@Autowired
//	public MemberController(MemberService memberService, NaverLoginBo naverLoginBo,KakaoLoginBo kakaoLoginBo,InstructorInfoService infoService){
//		this.memberService = memberService;
//		this.naverLoginBo = naverLoginBo;
//		this.kakaoLoginBo = kakaoLoginBo;
//		this.infoService = infoService;
//	}


	@Autowired
	public MemberController(MemberService memberService, NaverLoginBo naverLoginBo,KakaoLoginBo kakaoLoginBo,InstructorInfoService infoService, CompanyInfoService companyInfoService, StodService stodService){
		this.memberService = memberService;
		this.naverLoginBo = naverLoginBo;
		this.kakaoLoginBo = kakaoLoginBo;
		this.infoService = infoService;
		this.companyInfoService = companyInfoService; //소희
		this.stodService = stodService; //소희
	}

	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	@Bean
	public static BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
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
		if(!memberService.login(id,pwd)){
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
	public Map<String, String> signup(@RequestBody MemberDto memberDto) throws Exception {
		Map<String, String> map = new HashMap<>();

		try{
			// 비밀번호 암호화
			String pwd = memberDto.getPwd();
			System.out.println("signup , pwd = " + pwd);
			String securePwd = passwordEncoder.encode(pwd);
			System.out.println("signup , securePwd = " + securePwd);
			memberDto.setPwd(securePwd);

			// 여기까지는 성공해서 아래에서 map으로 error 넘겨도 db에 회원가입은 되는 상황
			int signupCnt = memberService.signup(memberDto);

			if(signupCnt == 1){
				// 회원가입 성공시
				System.out.println("signupCnt = " + signupCnt);
				System.out.println("hello, signup = " + memberDto);
			}else {
				// 회원가입 실패시
				System.out.println("signupCnt = " + signupCnt);
				throw new Exception();
			}

			// 회원가입 시 약관 등록
			int insertTermsYNCnt = memberService.insertTermsYN(memberDto); // 여기서 예외 발생하고 map에 error로 넘기느듯
			if(insertTermsYNCnt == 1){
				// 약관 등록 성공시
				System.out.println("insertTermsYNCnt = " + signupCnt);
			}else {
				// 약관 등록 실패시
				System.out.println("insertTermsYNCnt = " + signupCnt);
				throw new Exception();
			}

			map.put("redirect", "/member/login");
			System.out.println("map = " + map);
			return map;
		}catch (Exception e){
			//회원가입에 실패했을 경우
			e.printStackTrace();
			map.put("error", "회원가입에 실패했습니다.");
			System.out.println("map = " + map);
			return map;
		}
	}

	//회원 개인정보수정 페이지 이동(비밀번호 확인 페이지)
	@GetMapping("/memberEdit")
	public String memberEditPage(Model model,HttpSession session) throws Exception{
		//등급이 강사라면, 사이드바에 '강사 소개말' 메뉴 보이도록 해야돼서, 등급 체크를 위해 현재 로그인된 member객체 jsp에 보내주기
		String id = (String)session.getAttribute("id");
		MemberDto memberDto = memberService.memberSelect(id);
		model.addAttribute("memberDto",memberDto);
		return "/member/myPagePwdChk";
	}

	//비밀번호 확인 후, 일치한다면 마이페이지로 이동 ⭐️이
	@PostMapping("/memberEdit")
	public String memberPwdChk(String pwd,Model model,HttpSession session)throws Exception{

		String id = (String)session.getAttribute("id");
		MemberDto memberDto = memberService.memberSelect(id);
		model.addAttribute("memberDto",memberDto);
		//암호화한 비밀번호와 매치
		if(!passwordEncoder.matches(pwd,memberDto.getPwd())){
			//일치하지 않는다면, 에러메세지 전달
			model.addAttribute("msg","PWD_ERR");
			return "redirect:/member/memberEdit";
		}
		//일치한다면, 마이페이지 수정 페이지로 이동
		return "redirect:/member/memberEdit/read";
	}

	//개인정보수정 ⭐️
	@PostMapping("/memberEdit/modify")
	public String memberEdit(MemberDto memberDto,Model model) {
		try{
			//비밀번호 암호화로 저장
			String pwd = memberDto.getPwd();
			String securePwd = passwordEncoder.encode(pwd);
			memberDto.setPwd(securePwd);
			memberService.memberEdit(memberDto);
			model.addAttribute("msg","MOD_OK");
		}catch (Exception e){
			e.printStackTrace();
			model.addAttribute("msg","MOD_ERR");
			return "redirect:/member/memberEdit/read";
		}
		return "redirect:/member/memberEdit/read";

	}

	//수정 후 읽기 페이지  ⭐️
	@GetMapping("/memberEdit/read")
	public String memberPwdChk(Model model, HttpServletRequest request) throws Exception{
		//세션 값 가져와서 아이디 조회
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		//아이디 조회에 따른 결과 보여주기
		MemberDto memberDto = memberService.memberSelect(id);
		System.out.println(memberDto);
		//결과 담아주기
		model.addAttribute(memberDto);
		return "/member/myPage";
	}







	//회원 삭제
	@PostMapping("/delete")
	@ResponseBody
	public String memberDelete(MemberDto memberDto) throws Exception{
		memberService.memberDelete(memberDto.getId());
		return null;
	}

	//이메일 중복 확인
	@GetMapping("/idChk")
	@ResponseBody
	public String idChk(String id){
		System.out.println("비교할 이메일 아이디 = " + id);

		String email = "";

		try {
			MemberDto memberDto = memberService.memberSelect(id);
			email = memberDto.getId();

			System.out.println("email = " + email);
		} catch (Exception e) {
			e.printStackTrace();
		}

		return email;
	}

	//이메일 인증
	@Autowired
	private MailSendService mailService;
	@GetMapping("/mailChk")
	@ResponseBody
	public String mailChk(String email){
		System.out.println("이메일 인증 요청이 들어옴");
		System.out.println("이메일 인증할 이메일 : " + email);

		return mailService.joinEmail(email);
	}

	//찾아오시는 길
	@GetMapping("/jscdRoad")
	public String road(){
		return "jsRoad";
	}

	//학원 소개
	@GetMapping("/jscdIntro")
	public String intro(){
		return "jsIntro";
	}

	@GetMapping("/introTeacher")
	public String introTeacher(){
		return "introTeacher";
	}


	//강사 소개말 작성 페이지 이동
	@GetMapping("/instructorIntro")
	public String instructorIntro(HttpSession session,Model model){
		String id = (String)session.getAttribute("id");
		try{
			//등급 체크를 위해 현재 로그인된 회원객체 select + 기존 강사 소개말 띄우기 위해 강사 객체 select jsp에 넘기기
			MemberDto memberDto = memberService.memberSelect(id);
			InstructorMemberInfoDto instructorMemberInfoDto = infoService.read(memberDto.getMebrNo());
			model.addAttribute("memberDto",memberDto);
			model.addAttribute("infoDto",instructorMemberInfoDto);
		}catch (Exception e){
			e.printStackTrace();
			model.addAttribute("msg", "READ_ERR");
			return "redirect:/member/memberEdit";
		}
		return "/member/instructorIntro";
	}

	//강사 소개말 등록+수정
	@PostMapping("/instructorIntro")
	public String instructorIntroSave(InstructorInfoDto instructorInfoDto,Model model){
		try{
			//넘어온 객체로 강사 객체 update
			infoService.modifyIntro(instructorInfoDto);
			model.addAttribute("msg", "MOD_OK");

		}catch (Exception e){
			e.printStackTrace();
			model.addAttribute("msg", "MOD_ERR");
			return "redirect:/member/instructorIntro";
		}
		return "redirect:/member/instructorIntro";
	}

	// 강의 신청 현황 이동
	@GetMapping("/lectureApplyState")
	public String showLectureApplyState(LectureApplyDto lectureApplyDto,Model m,HttpServletRequest request) {
		HttpSession session = request.getSession();
		String id = (String) session.getAttribute("id");
		lectureApplyDto.setId(id);
		// lectureApply에 있는 정보가 필요해.
		try {

			List<LectureApplyDto> list = memberService.selectLecture(lectureApplyDto);
			m.addAttribute("list",list);
			System.out.println("applylist = " + list);

		} catch (Exception e){

		}

		return "member/lectureApplyState";
	}


//	@GetMapping("/lectureApplyState")
//	public String showLectureApplyState(@RequestParam(defaultValue = "1") int page, Model model, MemberDto memberDto, CompanyInfoDTO companyInfoDto, HttpServletRequest request) throws Exception {
//		HttpSession session = request.getSession();
//		String id = (String) session.getAttribute("id");
//
//		int itemsPerPage = 5; // 페이지당 보여줄 아이템 수 (StodServiceImpl.java - selectOrderList()와 연결 됨)
//		List<StodDTO> orderList = stodService.selectOrderList(id, page, itemsPerPage);
//		model.addAttribute("orderList", orderList);
//
//		memberDto = memberService.memberSelect(id);
//		model.addAttribute("memberDto", memberDto);
//		System.out.println(memberDto.toString());
//
//		companyInfoDto.setSlrNo(1); //231207 류소희 강의 등록 시 회사 번호도 등록해야함...
//		// 회사 정보 가져오기
//		companyInfoDto = companyInfoService.select(companyInfoDto.getSlrNo());
//		model.addAttribute("companyInfoDto", companyInfoDto);
//		System.out.println(companyInfoDto.toString());
//
//		int totalItems = stodService.countOrderList(id); // 전체 아이템 수를 조회
//		int totalPages = (int) Math.ceil((double) totalItems / itemsPerPage);
//		model.addAttribute("totalPages", totalPages);
//
//		// 현재 페이지 번호를 모델에 추가
//		model.addAttribute("currentPage", page);
//
//		return "member/lectureApplyState";
//	}


	//아이디 찾기 화면 보여주기
	@GetMapping("/findEmail")
	public String findEmail(){
		return "/member/findEmailPwd/findEmail";
	}

	//이름,생년월일,전화번호 요청받아 이메일 넘겨주기
	@PostMapping("/findEmail")
	public String returnEmail(MemberDto memberDto,Model model)
	{
		try{
			System.out.println("넘어온 회원 객체 memberDto = " + memberDto);
			//회원 정보에 해당하는 아이디를 찾고,
			String id = memberService.getEmail(memberDto);
			if(id == null) throw new Exception("Email Error");
			model.addAttribute("id",id);
		}catch (Exception e){
			e.printStackTrace();
			model.addAttribute("msg", "EMAIL_ERR");
			return "redirect:/member/findEmail";
		}
		return "/member/findEmailPwd/findEmailResult";
	}

	//비밀번호 찾기 화면 보여주기
	@GetMapping("/findPwd")
	public String findPwd(){
		return "/member/findEmailPwd/findPwd";
	}

	//비밀번호 찾기 이메일 인증
	@GetMapping("/findEmailChk")
	@ResponseBody
	public String findEmailChk(String email){
		System.out.println("이메일 인증 요청이 들어옴");
		System.out.println("이메일 인증할 이메일 : " + email);
		System.out.println("인증 이메일 : " + email);

		return mailService.findPwd(email);
	}

	//비밀번호 재설정 화면 보여주기_이메일 get으로 노출 시, 비번 아무나 바꿀 수 있어서 post로 수정
	@PostMapping("/pwdModifyForm")
	public String pwdModifyForm(String id,Model model){
		model.addAttribute("id",id);

		return "/member/findEmailPwd/pwdModify";
	}

	//비밀번호 재설정
	@PostMapping("/pwdModify")
	public String pwdModify(MemberDto memberDto,Model model){
		try{
			//비밀번호 암호화로 저장
			String pwd = memberDto.getPwd();
			String securePwd = passwordEncoder.encode(pwd);
			memberDto.setPwd(securePwd);
			System.out.println("비밀번호 재설정 memberDto = " + memberDto);
			memberService.modifyPwd(memberDto);
			model.addAttribute("msg","PWD_UP_OK");
		}catch (Exception e){
			e.printStackTrace();
			model.addAttribute("msg","PWD_UP_ERR");
			return "redirect:/member/pwdModify?id="+memberDto.getId();
		}
		return "redirect:/member/login/";
	}




}

