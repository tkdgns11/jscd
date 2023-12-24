package com.jscd.app.member.controller;


import com.jscd.app.admin.service.AdminService;
import com.jscd.app.member.dto.MemberDto;
import com.jscd.app.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.URLEncoder;

	/*
	작성일:20231223
	작성자:김보영
	작성 기능: 학사관리 학생등급만 접근할 수 있도록 제한
	 */


@Component
public class StdGradeCheckInterceptor implements HandlerInterceptor{

    @Autowired
    MemberService memberService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        //현재 로그인된 관리자의 등급 추출
        boolean login = request.getSession().getAttribute("id") == null;
        String id = (String)request.getSession().getAttribute("id");
        int grade = 0;

        try {
            //로그인을 안 했다면, 널포인트 예외 발생 -> 예외 처리
            grade = memberService.memberSelect(id).getGrade();

        }catch (Exception e){
            e.printStackTrace();
            //접근 막음
            String msg = URLEncoder.encode("학생만 접근 가능한 페이지 입니다.", "utf-8");
            //메세지 띄우고 홈으로 이동
            response.sendRedirect("/?msg="+msg);
            return false;
        }

        //등급이 일반이라면,
        if(grade == 1 || login){
            String msg = URLEncoder.encode("학생만 접근 가능한 페이지 입니다.", "utf-8");
            //메세지 띄우고 홈으로 이동
            response.sendRedirect("/?msg="+msg);
            return false;
        }
        //등급 2~5는 접근 가능(학생,강사,조교,원장)
        return true;


    }
}
