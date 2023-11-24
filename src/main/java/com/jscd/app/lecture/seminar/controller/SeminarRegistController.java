package com.jscd.app.lecture.seminar.controller;

import com.jscd.app.lecture.seminar.dto.SeminarRegistDto;
import com.jscd.app.lecture.seminar.dto.SeminarRegistHandler;
import com.jscd.app.lecture.seminar.service.SeminarRegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//    작성일 : 2023-11-17
//    작성자 : 장용호
//    작성 기능 : 세미나 등록 게시판(관리자)

@Controller
@RequestMapping("/regist")
public class SeminarRegistController {
    @Autowired
    SeminarRegistService seminarRegistService;

    @GetMapping("/read")
    public String read(Integer classEnrollNo, Integer page, Integer pageSize, Model m){

        try {
            SeminarRegistDto seminarRegistDto = seminarRegistService.read(classEnrollNo);
            m.addAttribute(seminarRegistDto);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "lecture/seminar/seminarRegist";
    }

    @GetMapping("list")
    public String list(Integer page, Integer pageSize, Model m, HttpServletRequest request){
//        if(!loginCheck(request))
//            return "redirect:/login/login?toURL="+request.getRequestURL();

        if(page==null) page=1;
        if(pageSize==null) pageSize=10;

        try{
            int totalCnt = seminarRegistService.getCount();
            SeminarRegistHandler sh = new SeminarRegistHandler(totalCnt, page, pageSize);

            Map map = new HashMap();
            map.put("offset", (page-1) * pageSize);
            map.put("pageSize", pageSize);

            List<SeminarRegistDto> list = seminarRegistService.getPage(map);
            m.addAttribute("list", list);
            m.addAttribute("sh", sh);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
        } catch (Exception e){
            e.printStackTrace();
        }

        return "lecture/seminar/seminarRegistList";
    }

//    private boolean loginCheck(HttpServletRequest request) {
//        HttpSession session = request.getSession();
//        return session.getAttribute("id")!=null;
//    }
}
