package com.jscd.app.member.controller;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

	/*
	작성일:20231227
	작성자:김보영
	작성 기능: 로그인 해야 부캠/세미나 페이지 접근 가능
	 */

@WebFilter(urlPatterns = {"/btTraining/smApplication", "/smTraining/smApplication"})
public class LoginCheckFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, NullPointerException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession();

        //로그인 여부
        boolean login = session.getAttribute("id") != null;

        //로그인을 했으면, uri로 바로 이동
        if (login) {
            chain.doFilter(request, response);

        } else { //로그인 안 했으면,
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            String toURL = httpRequest.getRequestURI(); //요청한 uri 추출
            //로그인 창으로 redirect(넘어온 uri 덧붙이기)
            httpResponse.sendRedirect("/member/login?toURL=" + toURL);
        }


    }

    @Override
    public void destroy() {
    }
}
