package com.jscd.app.admin.controller;


import com.jscd.app.admin.dto.AdminDto;
import com.jscd.app.admin.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;

	/*
	작성일:20231126
	작성자:김보영
	작성 기능:관리자 로그인,로그아웃 / 관리자 개인정보 읽기,수정
	 */

@Controller
@RequestMapping("/admin")
public class AdminController {



    @Autowired
    AdminService adminService;

    @Autowired
    BCryptPasswordEncoder passwordEncoder;

    @Bean
    public static BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    //관리자 홈
    @GetMapping("/home")
    public String adminHome() {return "redirect:/dashBoard/home";}
//    public String adminHome() {
//
//
//
//
//        return "/admin/home";
//    }


    //로그인 화면 보여주기
    @GetMapping("/login")
    public String adminLoginForm() {
        return "/admin/adminLogin";
    }


    //로그아웃
    @GetMapping("/logout")
    public String adminLogout(HttpSession session) {
        //관리자 아이디만 지우기
        session.removeAttribute("adminId");
        return "redirect:/admin/login";
    }

    //로그인 하기
    @PostMapping("/login")
    public String adminLogin(String id, String pwd, String adminIdCheck, String manageURL, HttpServletRequest request, HttpServletResponse response, Model model) throws Exception {

        //id,pwd 체크

        //일치하지 않는다면,
        if (!loginCheck(id, pwd)) {
            //불일치 메세지를 모델에 전달
            //(*)컨트롤러에서 직접 URL을 만들면 브라우저가 인코딩 해줄 수 없음. 그럴 땐 메서드로 인코딩 해줘야한다
            String msg = URLEncoder.encode("id 또는 pwd가 일치하지 않습니다.", "utf-8");
            model.addAttribute("msg", msg);
            return "redirect:/admin/login?msg=" + msg;
        }

        //일치 한다면,

        //세션 생성
        HttpSession session = request.getSession();
        session.setAttribute("adminId", id);

        //아이디 기억을 체크하지 않았다면,
        if (adminIdCheck == null) {
            //쿠키를 삭제
            Cookie cookie = new Cookie("adminId", id);
            cookie.setMaxAge(0);
            response.addCookie(cookie);
        } else { //체크 했다면,
            //쿠키를 생성
            Cookie cookie = new Cookie("adminId", id);
            response.addCookie(cookie);
        }
        //관리자 메뉴에서 넘어온 uri가 존재하다면, 그 uri로 바로 이동, 아니면 관리자 홈으로 이동한다
        manageURL = manageURL == null || manageURL.equals("") ? "/admin/home" : manageURL;

        return "redirect:" + manageURL;
    }

    //로그인 체크
    private boolean loginCheck(String id, String pwd) {
        AdminDto admin = null;
        try {
            admin = adminService.readAdmin(id);
            System.out.println("비밀번호 = " + passwordEncoder.matches(pwd,admin.getPwd()));
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return admin != null && passwordEncoder.matches(pwd,admin.getPwd());

    }



    //관리자 개인정보 페이지 보여주기
    @GetMapping("/read")
    public String adminInfoRead(Model model, HttpSession session) {
        try {
            //현재 세션에 저장된 관리자 id를 가져옴
            String adminId = (String) session.getAttribute("adminId");
            //관리자 id로 dto객체를 얻어오고,
            AdminDto adminDto = adminService.readAdmin(adminId);
            //jsp에 뿌려주기
            model.addAttribute("adminDto", adminDto);
        } catch (Exception e) {
            e.printStackTrace();
            model.addAttribute("msg", "READ_ERR");
            return "redirect:/admin/home";
        }
        return "/admin/adminInfo/adminInfo";
    }

    //관리자 생일 수정을 위한 변환기
    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));}

    //관리자 개인정보 수정하기
    @PostMapping("/modify")
    public String adminModify(AdminDto adminDto, Model model, HttpSession session) {
        try {
            //현재 세션에 저장된 관리자 id를 가져옴
            String adminId = (String) session.getAttribute("adminId");
            //비밀번호 암호화
            String pwd = adminDto.getPwd();
            String securePwd = passwordEncoder.encode(pwd);

            adminDto.setId(adminId);
            adminDto.setPwd(securePwd);
            adminService.modifyAdmin(adminDto);
            //수정 성공 시, msg 모델에 넘겨줌
            model.addAttribute("msg", "MOD_OK");
        } catch (Exception e) {
            e.printStackTrace();
            //수정 실패 시, msg 모델에 넘겨줌
            model.addAttribute("msg", "MOD_ERR");
            return "redirect:/admin/modify";
        }
        return "redirect:/admin/read";
    }



}

