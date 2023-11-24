package com.jscd.app.member.kakao.controller;

import com.jscd.app.member.dto.MemberDto;
import com.jscd.app.member.kakao.service.KakaoService;
import com.jscd.app.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Map;
import java.util.Objects;


/*
작성일:20231122
작성자:강정수
작성 기능: 카카오 로그인
 */
@Controller
@RequestMapping("/kakao/*")
public class KakaoController {

    private KakaoService kakaoService;
    private MemberService memberService;

    @Autowired
    public KakaoController(KakaoService kakaoService, MemberService memberService){
        this.kakaoService = kakaoService;
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String kakaoLogin(@RequestParam String code, HttpServletRequest request, HttpServletResponse response) throws Exception {
        System.out.println("kakao 로그인 code : " + code);
        //1. 인가 코드 받기
        //@RequestParam String code
        //2. 토큰 받기
        String accessToken =  kakaoService.kakaoAccessToken(code);
        //3. 사용자 정보 받기
        Map<String, Object> userInfo = kakaoService.getUserInfo(accessToken);

        //카카오 이메일
        String id = (String)userInfo.get("email");
        //비밀번호 해시코드로 저장
        String pwd = String.valueOf(Objects.hash(id)*31);
        //그 외의 값들
        String nickname = (String)userInfo.get("nickname");
        String gender = (String)userInfo.get("gender");
        String birthday = (String)userInfo.get("birthday");
        String birthyear = (String)userInfo.get("birthyear");
        String phone = (String)userInfo.get("phone");

        //가입된 아이디가 없을 때
        if(!memberService.login(id,pwd)){

        //생년월일
        birthyear = birthyear.substring(2, 4);
        String birth = birthyear+birthday;
            System.out.println("birth : " + birth);


            //휴대폰번호
        String cleanedNumber = phone.replaceAll("[\\s-]+", "");
        System.out.println(cleanedNumber);
        String phone1 = cleanedNumber.substring(0, 5);
        String phone2 = cleanedNumber.substring(5, 9);
        String phone3 = cleanedNumber.substring(9);

        MemberDto memberDto = new MemberDto();
        memberDto.setId(id);
        memberDto.setName(nickname);
        memberDto.setPwd(pwd);
        memberDto.setGender(gender);
        memberDto.setBirth(birth);
        memberDto.setPhone(phone);
        memberDto.setPhone1(phone1);
        memberDto.setPhone2(phone2);
        memberDto.setPhone3(phone3);

        memberService.signUp(memberDto);

        }

        HttpSession session = request.getSession();
        session.setAttribute("id",id);
        session.setAttribute("accessToken",accessToken);

        return "redirect:/";

    }

    @GetMapping("/logout")
    public String kakaoLogout(HttpSession httpSession) throws Exception {

        String accessToken =  (String) httpSession.getAttribute("accessToken");
        kakaoService.kakaoLogout(accessToken);
        httpSession.invalidate();
        return "/member/login";
    }



}
