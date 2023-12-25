package com.jscd.app.member.controller;


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
public class StdGradeCheckInterceptor implements HandlerInterceptor {

    @Autowired
    MemberService memberService;


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        //로그인 여부
        boolean login = request.getSession().getAttribute("id") == null;
        //현재 로그인된 아이디
        String id = (String) request.getSession().getAttribute("id");
        int grade = 0;
        String msg = URLEncoder.encode("학생만 접근 가능한 페이지 입니다.", "utf-8");
        String redirectUrl = "/?msg=" + msg;

        try {
            //로그인을 안 했다면, 널포인트 예외 발생 -> 예외 처리
            grade = memberService.memberSelect(id).getGrade();
            if (grade == 1 || login) {

                //메세지 띄우고 홈으로 이동
                response.sendRedirect(redirectUrl);
                return false;
            }

        } catch (Exception e) {
            e.printStackTrace();
            //접근 막음

            //메세지 띄우고 홈으로 이동
            response.sendRedirect(redirectUrl);
            return false;
        }

        return true;


    }


}
