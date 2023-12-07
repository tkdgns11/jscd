package com.jscd.app.lecture.lstRegist.controller;

import com.jscd.app.lecture.classEnroll.dto.ClassEnrollDto;
import com.jscd.app.lecture.classEnroll.service.ClassEnrollService;
import com.jscd.app.lecture.course.dto.CourseDto;
import com.jscd.app.lecture.course.service.CourseService;
import com.jscd.app.lecture.lstRegist.dto.LstRegistDto;
import com.jscd.app.lecture.lstRegist.service.LstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
//@RequestMapping("/onlyAdmin/lstRegist")
@RequestMapping("/lstRegist")
public class LstController {
    @Autowired
    LstService lstService;

    @Autowired
    CourseService courseService;

    @Autowired
    ClassEnrollService classEnrollService;


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
            Map<String, Object> lstRegistDto = lstService.readRegist(registCode);

            m.addAttribute("lstRegistDto", lstRegistDto);
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

    @PostMapping("/addRegist")
    public String addRegist(LstRegistDto lstRegistDto, Model m) throws Exception {

        System.out.println("hhheeellooo");

        try {
            System.out.println("llll" +lstRegistDto.toString());
            lstService.addRegist(lstRegistDto);
            return "redirect:/lstRegist/list";
        } catch(Exception e) {
            e.printStackTrace();
            m.addAttribute("lstRegistDto", lstRegistDto);
            return "/lecture/lstRegist/lstRegistRegist";
        }
    }

    // 강의 추가 기능 구현
//    @PostMapping("/addRegist")
//    @ResponseBody
//    public String addRegist(@RequestBody  LstRegistDto lstRegistDto, Model m) throws Exception {
//        try {
//            System.out.println(lstRegistDto);
//            lstService.addRegist(lstRegistDto);
////            return "redirect:/onlyAdmin/lstRegist/list";
//            return "redirect:/lstRegist/list";
//        } catch(Exception e) {
//            e.printStackTrace();
//            m.addAttribute("lstRegistDto", lstRegistDto);
//            return "/lecture/lstRegist/lstRegistRegist";
//        }
//    }

    //디비에 접근해서 courseCode에 해당하는 데이터 가져오기
    @PostMapping("/getData")
    @ResponseBody
    public Map<String, List<ClassEnrollDto>> getData(@RequestBody String courseCode, Model m) throws Exception {
        Map<String, List<ClassEnrollDto>> map = new HashMap<>();

        //System.out.println(courseCode);


        try {
            //System.out.println("hello getData");
            List<ClassEnrollDto> list = classEnrollService.getList(Integer.valueOf(courseCode));
            //System.out.println("list = " + list);
            m.addAttribute("courseList", list);

            map.put("courseList", list);

            // Map 출력
            for (Map.Entry<String, List<ClassEnrollDto>> entry : map.entrySet()) {
                String key = entry.getKey();
                List<ClassEnrollDto> value = entry.getValue();

                System.out.println("Key: " + key);
                System.out.println("Value: " + value);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
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
