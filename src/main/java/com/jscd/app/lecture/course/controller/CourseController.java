package com.jscd.app.lecture.course.controller;

import com.jscd.app.lecture.course.dto.CourseDto;
import com.jscd.app.lecture.course.service.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
//@RequestMapping("/onlyAdmin/registCourse")
@RequestMapping("/registCourse")
public class CourseController {
    @Autowired
    CourseService courseService;

    // 등록된 과정 수정 기능 구현
    @PostMapping("/modifyCourse")
    public String modifyCourse(CourseDto courseDto, RedirectAttributes rattr, Model m) {
        try {
            courseService.modifyCourse(courseDto);
            // TODO 수정완료 메시지 전달
//            return "redirect:/onlyAdmin/registCourse/course";
            return "redirect:/registCourse/course";
        } catch(Exception e) {
            e.printStackTrace();
            m.addAttribute(courseDto);
            return "courseRegist";
        }
    }

    // 등록된 과정 삭제 기능 구현
    @PostMapping("/removeCourse")
    public String removeCourse(Integer courseCode, Model m, RedirectAttributes rattr) throws Exception {
        try {
            courseService.removeCourse(courseCode);
        } catch(Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "DEL_ERR");
        }
//        return "redirect:/onlyAdmin/registCourse/course";
        return "redirect:/registCourse/course";
    }

    // 등록된 과정 상세 확인 기능 구현
    @GetMapping("/courseDetail")
    public String detailCourse(Integer courseCode, Model m) throws Exception {
        try {
            CourseDto courseDto = courseService.readCourse(courseCode);
            m.addAttribute(courseDto);
        } catch(Exception e) {
            e.printStackTrace();
//            return "redirect:/onlyAdmin/registCourse/course";
            return "redirect:/registCourse/course";
        }
        return "/lecture/course/courseRegist";
    }

    // 과정 추가하는 페이지 이동 기능 구현
    @GetMapping("/addCourse")
    public String addCourse(Model m) throws Exception {
        try {
            m.addAttribute("mode", "new");
        } catch(Exception e) {
            throw new RuntimeException(e);
        }
        return "/lecture/course/courseRegist";
    }

    // 과정 추가 기능 구현
    @PostMapping("/addCourse")
    public String addCourse(CourseDto courseDto, Model m) throws Exception {
        try {
            courseService.addCourse(courseDto);
//            return "redirect:/onlyAdmin/registCourse/course";
            return "redirect:/registCourse/course";
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
            List<CourseDto> list = courseService.getCourseList();
            m.addAttribute("list", list);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "/lecture/course/courseList";
    }
}
