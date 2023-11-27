package com.jscd.app.admin.controller;


import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

	/*
	작성일:20231126
	작성자:김보영
	작성 기능:관리자 메뉴를 관리자만 사용할 수 있도록 id를 확인
	 */

@WebFilter(urlPatterns = {"/onlyAdmin/*", "/admin/home"})
public class AdminLoginCheckFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {}

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpSession session = httpRequest.getSession(false);

        //로그인 여부
        boolean login = session.getAttribute("adminId") != null;

        //로그인을 했으면, uri로 바로 이동
        if (login) {
            chain.doFilter(request, response);

        } else { //로그인 안 했으면,
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            String manageURL = httpRequest.getRequestURI(); //요청한 uri 추출
            //로그인 창으로 redirect(넘어온 uri 덧붙이기)
            httpResponse.sendRedirect("/admin/login?manageURL=" + manageURL);
        }
    }

    @Override
    public void destroy() {}
}
