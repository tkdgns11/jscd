package com.jscd.app.lecture.classEnroll.controller;

import com.jscd.app.lecture.classEnroll.dto.ClassEnrollDto;
import com.jscd.app.lecture.classEnroll.service.ClassEnrollService;
import com.jscd.app.lecture.course.dto.CourseDto;
import com.jscd.app.lecture.course.service.CourseService;
import com.jscd.app.lecture.round.dto.RoundDto;
import com.jscd.app.lecture.round.service.RoundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
@RequestMapping("/classEnroll")// /onlyAdimn/
public class ClassEnrollController {
    @Autowired
    ClassEnrollService classEnrollService;
    @Autowired
    CourseService courseService;
    @Autowired
    RoundService roundService;

    @PostMapping("/modify")
    public String modify(ClassEnrollDto classEnrollDto, Model m, RedirectAttributes rattr){
        System.out.println("classEnrollDto = " + classEnrollDto);

        try {
            int cnt = classEnrollService.modify(classEnrollDto);

            if(cnt != 1)
                throw new Exception("modify fail");

            rattr.addFlashAttribute("msg", "modify ok");
            return "redirect:/classEnroll/list";
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("classEnrollDto", classEnrollDto);
            m.addAttribute("msg", "modify fail");
            return "lecture/classEnroll/classEnroll";
        }
    }

    @PostMapping("/write")
    public String write(ClassEnrollDto classEnrollDto, Model m, RedirectAttributes rattr){

        System.out.println("classEnrollDto = " + classEnrollDto);

        try {
            int cnt = classEnrollService.write(classEnrollDto);

            if(cnt != 1)
                throw new Exception("write fail");

            rattr.addFlashAttribute("msg", "write ok");
            return "redirect:/classEnroll/list";
        } catch (Exception e) {
            e.printStackTrace();

            m.addAttribute("classEnrollDto", classEnrollDto);
            m.addAttribute("msg", "write fail");
            return "lecture/classEnroll/classEnroll";
        }
    }

    @GetMapping("/write")
    public String write(Model m){

        try {
            // course, round 2개의 db에서 데이터 불러오기
            List<CourseDto> courseList = courseService.getCourseList();
            List<RoundDto> roundList = roundService.getRoundList();

            // db에서 불러온 데이터 model로 전달
            m.addAttribute("courseList", courseList);
            m.addAttribute("roundList", roundList);
            m.addAttribute("mode", "new");
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "lecture/classEnroll/classEnroll";
    }

    @PostMapping("/remove")
    public String remove(Integer classCode, RedirectAttributes rattr){

        try {
            int cnt = classEnrollService.remove(classCode);

            if(cnt != 1)
                throw new Exception("remove fail");

            rattr.addFlashAttribute("msg", "remove ok");
        } catch (Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "remove fail");
        }

        return "redirect:/classEnroll/list";
    }

    // 게시물 하나 읽기
    @GetMapping("read")
    public String read(Integer classCode, Model m){

        try {
            // 1.classEnroll, course, round 3개의 db에서 데이터 불러오기
            ClassEnrollDto classEnrollDto = classEnrollService.read(classCode);
            List<CourseDto> courseList = courseService.getCourseList();
            List<RoundDto> roundList = roundService.getRoundList();

            // 2.db에서 불러온 데이터 model로 전달
            m.addAttribute("classEnrollDto", classEnrollDto);
            m.addAttribute("courseList", courseList);
            m.addAttribute("roundList", roundList);

        } catch (Exception e) {
            e.printStackTrace();
        }

        // 3. 해당 jsp로 이동
        return "lecture/classEnroll/classEnroll";
    }

    // 게시물 화면 출력
    @GetMapping("/list")
    public String list(Model m){
        Integer classCode = null;

        try {
            List<ClassEnrollDto> classEnrollList = classEnrollService.getList(classCode);

            m.addAttribute("classEnrollList", classEnrollList);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return "lecture/classEnroll/classEnrollList";
    }
}
