package com.jscd.app.lecture.seminar.controller;

import com.jscd.app.lecture.seminar.dto.SeminarRegistDto;
import com.jscd.app.lecture.seminar.dto.SeminarRegistHandler;
import com.jscd.app.lecture.seminar.service.SeminarRegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//    작성일 : 2023-11-17
//    작성자 : 장용호
//    작성 기능 : 세미나 등록 게시판(관리자)

@Controller
@RequestMapping("/regist")// /onlyAdimn/regist
public class SeminarRegistController {
    @Autowired
    SeminarRegistService seminarRegistService; // 강의 등록

    @PostMapping("/modify")
    public String modify(SeminarRegistDto seminarRegistDto, Integer page, Integer pageSize, Model m, HttpSession session, RedirectAttributes rattr){

        seminarRegistDto.setWriter("castello");

        try{
            if(seminarRegistService.modify(seminarRegistDto) != 1)
                throw new Exception("Modify failed.");

            rattr.addAttribute("page", page);
            rattr.addAttribute("pageSize", pageSize);
            rattr.addFlashAttribute("msg", "MOD_OK");
            return "redirect:/regist/list";
        } catch (Exception e){
            e.printStackTrace();
            m.addAttribute(seminarRegistDto);
            m.addAttribute("page", page);
            m.addAttribute("page", pageSize);
            m.addAttribute("msg", "MOD_ERR");
            return "lecture/seminar/seminarRegist";
        }
    }
    @PostMapping("/write")
    public String write(SeminarRegistDto seminarRegistDto, Model m, HttpSession session, RedirectAttributes rattr){

        seminarRegistDto.setWriter("castello");

        try {
            int rowCnt = seminarRegistService.write(seminarRegistDto);
            System.out.println("Post write에서 출력하는 seminarRegistDto = " + seminarRegistDto);

            if(rowCnt != 1)
                throw new Exception("Write failed");

            rattr.addFlashAttribute("msg", "WRT_OK");
            return "redirect:/regist/list";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("seminarRegistDto", seminarRegistDto);
            m.addAttribute("msg", "WRT_ERR");
            return "lecture/seminar/seminarRegist";
        }
    }

    @GetMapping("/write")
    public String write(Integer page, Integer pageSize, Model m){

        try {

            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
            m.addAttribute("mode", "new");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "lecture/seminar/seminarRegist";
    }

    @PostMapping("/remove")
    public String remove(Integer classEnrollNo, Integer page, Integer pageSize, Model m, HttpSession session, RedirectAttributes rattr){

//        String writer = (String)session.getAttribute("id"); // todo 관리자 로그인 구현시 수정
        String writer = "castello";

        try {
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);

            int rowCnt = seminarRegistService.remove(classEnrollNo, writer);

//            console 테스트
            System.out.println("seminarRegist.jsp에서 넘어온 classEnrollNo = " + classEnrollNo);
            System.out.println("seminarRegist.jsp에서 넘어온 writer = " + writer);
            System.out.println("rowCnt = " + rowCnt + " 삭제 성공!");

            if(rowCnt != 1)
                throw new Exception("remove error");

            rattr.addFlashAttribute("msg","DEL_OK");
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "DEL_ERR");
        }

        return "redirect:/regist/list";
    }

    @GetMapping("/read")
    public String read(Integer classEnrollNo, Integer page, Integer pageSize, Model m){

        try {
            SeminarRegistDto seminarRegistDto = seminarRegistService.read(classEnrollNo);
            System.out.println("seminarRegistDto = " + seminarRegistDto);

            m.addAttribute(seminarRegistDto);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "lecture/seminar/seminarRegist";
    }

    @GetMapping("list")
    public String list(Integer page, Integer pageSize, Model m, HttpServletRequest request) {

        if (page == null) page = 1;
        if (pageSize == null) pageSize = 10;

        try {
            int totalCnt = seminarRegistService.getCount();
            SeminarRegistHandler sh = new SeminarRegistHandler(totalCnt, page, pageSize);
            System.out.println(" page = " + page);
            System.out.println("pageSize = " + pageSize);

            Map map = new HashMap();
            map.put("offset", (page - 1) * pageSize);
            map.put("pageSize", pageSize);

            List<SeminarRegistDto> list = seminarRegistService.getPage(map);
            m.addAttribute("list", list);
            m.addAttribute("sh", sh);
            m.addAttribute("page", page);
            m.addAttribute("pageSize", pageSize);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "lecture/seminar/seminarRegistList";
    }
}
