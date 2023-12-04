package com.jscd.app.lecture.lstRegist.controller;

import com.jscd.app.lecture.course.dto.CourseDto;
import com.jscd.app.lecture.course.service.CourseService;
import com.jscd.app.lecture.lstRegist.dto.LstRegistDto;
import com.jscd.app.lecture.lstRegist.service.LstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
//@RequestMapping("/onlyAdmin/lstRegist")
@RequestMapping("/lstRegist")
public class LstController {
    @Autowired
    LstService lstService;

    @Autowired
    CourseService courseService;

    // 등록된 강의 수정 기능 구현
    @PostMapping("/modifyRegist")
    public String modifyRegist(LstRegistDto lstRegistDto, RedirectAttributes rattr, Model m) throws Exception{
        try {
            lstService.modifyRegist(lstRegistDto);
//            return "redirect:/onlyAdmin/lstRegist/list";
            return "redirect:/lstRegist/list";
        } catch(Exception e) {
            e.printStackTrace();
            m.addAttribute(lstRegistDto);
            return "/lecture/lstRegist/lstRegistRegist";
        }
    }

    // 등록된 강의 삭제 기능 구현
    @PostMapping("/removeRegist")
    public String removeRegist(Integer registCode, Model m, RedirectAttributes rattr) throws Exception {
        try {
            lstService.removeRegist(registCode);
        } catch(Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "DEL_ERR");
        }
//        return "redirect:/onlyAdmin/lstRegist/list;
        return "redirect:/lstRegist/list";
    }

    // 등록된 강의 상세 확인 기능 구현
    @GetMapping("/detailRegist")
    public String detailRegist(Integer registCode, Model m) throws Exception {
        try {
            LstRegistDto lstRegistDto = lstService.readRegist(registCode);
            m.addAttribute(lstRegistDto);
        } catch(Exception e) {
            e.printStackTrace();
//            return "redirect:/onlyAdmin/lstRegist/list";
            return "redirect:/lstRegist/list";
        }
        return "/lecture/lstRegist/lstRegistRegist";
    }

    // 강의 추가하는 페이지 이동 기능 구현
    @GetMapping("/addRegist")
    public String addRegist(Model m) throws Exception {
        try {
            List<CourseDto> list = courseService.getCourseList();
            m.addAttribute("mode", "new");
            m.addAttribute("list", list);
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        return "/lecture/lstRegist/lstRegistRegist";
    }

    // 강의 추가 기능 구현
    @PostMapping("/addRegist")
    public String addRegist(LstRegistDto lstRegistDto, Model m) throws Exception {
        try {
            lstService.addRegist(lstRegistDto);
//            return "redirect:/onlyAdmin/lstRegist/list";
            return "redirect:/lstRegist/list";
        } catch(Exception e) {
            e.printStackTrace();
            m.addAttribute("lstRegistDto", lstRegistDto);
            return "/lecture/lstRegist/lstRegistRegist";
        }
    }

    // 강의 리스트로 이동 기능 구현
    @GetMapping("/list")
    public String listRegist(LstRegistDto lstRegistDto, Model m) throws Exception {
        try {
            List<LstRegistDto> list = lstService.getLstRegistList();
            m.addAttribute("list", list);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "/lecture/lstRegist/lstRegistList";
    }
}
