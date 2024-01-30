package com.jscd.app.admin;


import com.jscd.app.admin.dto.AdminDto;
import com.jscd.app.admin.service.AdminService;
import com.jscd.app.admin.service.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.net.URLEncoder;

	/*
	작성일:20231219
	작성자:김보영
	작성 기능:관리자 사이트 내에서 일부 페이지에 원장님만 접근하도록 제한
	 */


@Component
public class AdminGradeCheckInterceptor implements HandlerInterceptor{

    @Autowired
    AdminService adminService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {

        //현재 로그인된 관리자의 등급 추출
        String adminId = (String)request.getSession().getAttribute("adminId");
        int grade = adminService.readAdmin(adminId).getGrade();
        System.out.println("grade = " + grade);

        //등급이 5가 아니라면(조교라면,)
//        if(grade != 5){ //원장님 : 5 _ 조교 : 4
//            System.out.println("<< 원장님만 접근 가능 >>");
//            String msg = URLEncoder.encode("원장님만 접근 가능한 페이지 입니다.", "utf-8");
//            //메세지 띄우고 홈으로 이동
//            response.sendRedirect("/admin/home?msg="+msg);
//            return false;
//        }
        //원장님이면 접근 가능
        return true;


    }
}
