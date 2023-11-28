package com.jscd.app.member.controller;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.jscd.app.member.dto.MemberDto;
import com.jscd.app.member.dto.NaverLoginBo;
import com.jscd.app.member.service.MemberService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Objects;

@Controller
@RequestMapping("/naver/*")
public class NaverController {
    private NaverLoginBo naverLoginBo;
    private MemberService memberService;
    private String apiResult = null;

    @Autowired
    private  void setNaverLoginBo(NaverLoginBo naverLoginBo, MemberService memberService ){
        this.naverLoginBo = naverLoginBo;
        this.memberService = memberService;
    }

    @GetMapping("/login")
    public String naverLogin(Model model, @RequestParam String code, @RequestParam String state, HttpSession session) throws Exception{
        System.out.println("네이버 로그인 성공");
        System.out.println("code====" + code + ", state====" + state);
        OAuth2AccessToken oAuth2AccessToken;

        oAuth2AccessToken  = naverLoginBo.getAccessToken(session, code, state);
        apiResult = naverLoginBo.getUserProfile(oAuth2AccessToken);

        JSONParser jsonParser = new JSONParser();
        JSONObject jsonObj;

        jsonObj = (JSONObject) jsonParser.parse(apiResult);
        JSONObject response_obj = (JSONObject) jsonObj.get("response");
        System.out.println(response_obj.toString());

        String id = (String) response_obj.get("email");
        String name = (String) response_obj.get("name");
        String nickname = (String) response_obj.get("nickname");
        //비밀번호 해시코드로 저장
        String pwd = String.valueOf(Objects.hash(id)*31);
        //그 외의 값들
        String genderResult = (String) response_obj.get("gender");
        int gender = 0;
        if(genderResult.equals("F")){
            gender = 1;
        }
        String birthday = (String) response_obj.get("birthday");
        String birthyear = (String)response_obj.get("birthyear");
        String birth = birthyear.substring(2) + birthday.replace("-","");
        String phone = (String)response_obj.get("mobile");

        System.out.println("회원가입 전");
        MemberDto memberDto = new MemberDto();

        if(memberService.memberSelect(id)==null){
            System.out.println(memberDto);
            memberDto.setId(id);
            memberDto.setName(name);
            memberDto.setNickname(nickname);
            memberDto.setPwd(pwd);
            memberDto.setGender(gender);
            memberDto.setBirth(birth);
            memberDto.setPhone(phone);

            memberService.signUp(memberDto);

        }

        session.setAttribute("signIn",apiResult);
        session.setAttribute("id", id);
        session.setAttribute("nickname", nickname);



        return "redirect:/";

    }







}
