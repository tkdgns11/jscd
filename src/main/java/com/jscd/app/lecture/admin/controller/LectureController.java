package com.jscd.app.lecture.admin.controller;

import com.jscd.app.lecture.admin.dto.CourseDto;
import com.jscd.app.lecture.admin.dto.RoundDto;
import com.jscd.app.lecture.admin.service.RegistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
//@RequestMapping("/onlyAdmin/regist")
@RequestMapping("/regist")
public class LectureController {
    // course, round, classEnroll, regist 사용할 DB
    // courseList, courseRegist, roundList, roundRegist, classEnrollList, classEnrollRegist, registList, registRegist 사용할 jsp 페이지
    @Autowired
    RegistService registService;

    // 등록된 회차 수정 기능 구현
    @PostMapping("/modifyRound")
    public String modifyRound(RoundDto roundDto, RedirectAttributes rattr, Model m) {
        // 로그인 유효성 검사
        try {
            registService.modifyRound(roundDto);
            // TODO 수정완료 메시지 전달
//            return "redirect:/onlyAdmin/regist/course";
            return "redirect:/regist/round";
        } catch(Exception e) {
            e.printStackTrace();
            m.addAttribute(roundDto);
            return "roundRegist";
        }
    }

    // 등록된 회차 삭제 기능 구현
    @PostMapping("/removeRound")
    public String removeRound(Integer roundCode, Model m, RedirectAttributes rattr) throws Exception {
        // 로그인 유효성 검사
        try {
            registService.removeRound(roundCode);
        } catch(Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "DEL_ERR");
        }
//        return "redirect:/onlyadmin/regist/courseList";
        return "redirect:/regist/round";
    }

    // 등록된 회차 상세 확인 기능 구현
    @GetMapping("/roundDetail")
    public String detailRound(Integer roundCode, Model m) throws Exception {
        // 로그인 유효성 검사
        try {
            RoundDto roundDto = registService.readRound(roundCode);
            m.addAttribute(roundCode);
        } catch(Exception e) {
            e.printStackTrace();
//            return "redirect:/onlyAdmin/regist/course";
            return "redirect:/regist/round";
        }
        return "/lecture/admin/roundRegist";
    }

    // 회차 추가하는 페이지 이동 기능 구현
    @GetMapping("/addRound")
    public String addRound(Model m) throws Exception {
        // 로그인 유효성 검사
        try {
            m.addAttribute("mode", "new");
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        return "/lecture/admin/roundRegist";
    }

    // 회차 추가 기능 구현
    @PostMapping("/addRound")
    public String addRound(RoundDto roundDto, Model m) throws Exception {
        try {
            registService.addRound(roundDto);
//            return "redirect:/onlyAdmin/regist/course";
            return "redirect:/regist/round";
        } catch(Exception e) {
            e.printStackTrace();
            m.addAttribute("roundDto", roundDto);
            return "roundRegist";
        }
    }

    // 등록된 회차 리스트 이동 기능 구현
    @GetMapping("/round")
    public String listRound(RoundDto roundDto, Model m) {
        try {
            List<RoundDto> list = registService.getRoundList();
            m.addAttribute("list", list);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "/lecture/admin/roundList";
    }

    // 등록된 과정 수정 기능 구현
    @PostMapping("/modifyCourse")
    public String modifyCourse(CourseDto courseDto, RedirectAttributes rattr, Model m) {
        // 로그인 유효성 검사
        try {
            registService.modifyCourse(courseDto);
            // TODO 수정완료 메시지 전달
//            return "redirect:/onlyAdmin/regist/course";
            return "redirect:/regist/course";
        } catch(Exception e) {
            e.printStackTrace();
            m.addAttribute(courseDto);
            return "courseRegist";
        }
    }

    // 등록된 과정 삭제 기능 구현
    @PostMapping("/removeCourse")
    public String removeCourse(Integer courseCode, Model m, RedirectAttributes rattr) throws Exception {
        // 로그인 유효성 검사
        try {
            registService.removeCourse(courseCode);
        } catch(Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "DEL_ERR");
        }
//        return "redirect:/onlyadmin/regist/courseList";
        return "redirect:/regist/course";
    }

    // 등록된 과정 상세 확인 기능 구현
    @GetMapping("/courseDetail")
    public String detailCourse(Integer courseCode, Model m) throws Exception {
        // 로그인 유효성 검사
        try {
            System.out.println("courseCode = " + courseCode);
            CourseDto courseDto = registService.readCourse(courseCode);
            m.addAttribute(courseDto);
        } catch(Exception e) {
            e.printStackTrace();
//            return "redirect:/onlyAdmin/regist/course";
            return "redirect:/regist/course";
        }
        return "/lecture/admin/courseRegist";
    }

    // 과정 추가하는 페이지 이동 기능 구현
    @GetMapping("/addCourse")
    public String addCourse(Model m) throws Exception {
        // 로그인 유효성 검사
        try {
            m.addAttribute("mode", "new");
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        return "/lecture/admin/courseRegist";
    }

    // 과정 추가 기능 구현
    @PostMapping("/addCourse")
    public String addCourse(CourseDto courseDto, Model m) throws Exception {
        try {
            registService.addCourse(courseDto);
//            return "redirect:/onlyAdmin/regist/course";
            return "redirect:/regist/course";
        } catch(Exception e) {
            e.printStackTrace();
            m.addAttribute("courseDto", courseDto);
            return "courseRegist";
        }
    }

    // 등록된 과정 리스트 이동 기능 구현
    @GetMapping("/course")
    public String listCourse(CourseDto courseDto, Model m) {
        try {
            List<CourseDto> list = registService.getCourseList();
            m.addAttribute("list", list);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "/lecture/admin/courseList";
    }
}
