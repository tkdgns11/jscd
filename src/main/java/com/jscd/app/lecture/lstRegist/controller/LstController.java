package com.jscd.app.lecture.lstRegist.controller;

import com.jscd.app.board.qna.qnaDto.AttachDto;
import com.jscd.app.lecture.classEnroll.dto.ClassEnrollDto;
import com.jscd.app.lecture.classEnroll.service.ClassEnrollService;
import com.jscd.app.lecture.course.dto.CourseDto;
import com.jscd.app.lecture.course.service.CourseService;
import com.jscd.app.lecture.lstRegist.dto.LstRegistDto;
import com.jscd.app.lecture.lstRegist.dto.PageHandler;
import com.jscd.app.lecture.lstRegist.dto.SearchCondition;
import com.jscd.app.lecture.lstRegist.service.LstService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.util.*;
import java.util.List;

@Controller
//@RequestMapping("/onlyAdmin/lstRegist")
@RequestMapping("/lstRegist")
public class LstController {
    // 로그 선언
    private static final Logger logger = LoggerFactory.getLogger(LstController.class);
    // 파일이 저장될 위치
//    private static final String filePath = "C:\\Users\\wjdtn\\Desktop\\jscd\\src\\main\\webapp\\resources\\upload\\img";
    private static final String filePath = "/Users/george/Desktop/JungSuk_Project/src/main/webapp/resources/upload/img";

    @Autowired
    LstService lstService;

    @Autowired
    CourseService courseService;

    @Autowired
    ClassEnrollService classEnrollService;

    //1.강의 목록
    // 강의 리스트로 이동 기능 구현(목록)
    @GetMapping("/list")
    public String listRegist(LstRegistDto lstRegistDto, SearchCondition sc, Model m) throws Exception {
        try {
            int totalCnt = lstService.getSearchResultCnt(sc);
            m.addAttribute("totalCnt", totalCnt);

            PageHandler pageHandler = new PageHandler(totalCnt, sc);


            List<LstRegistDto> list = lstService.getSearchResultPage(sc);
            m.addAttribute("list", list);
            m.addAttribute("ph", pageHandler);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "/lecture/lstRegist/lstRegistList";
    }


    //2.강의 등록
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

    //강의 등록
    @PostMapping("/addRegist")
    public String addRegist(LstRegistDto lstRegistDto, Model m, MultipartHttpServletRequest mpRequest) throws Exception {
        System.out.println("lstRegistDto = " + lstRegistDto);
        try {
            lstService.addRegist(lstRegistDto, mpRequest);
            return "redirect:/lstRegist/list";
        } catch(Exception e) {
            e.printStackTrace();
            m.addAttribute("lstRegistDto", lstRegistDto);
            return "/lecture/lstRegist/lstRegistRegist";
        }
    }
    //3.강의 상세
    // 등록된 강의 상세 확인 기능 구현(세부항목)
    @GetMapping("/detailRegist")
    public String detailRegist(Integer registCode, Model m) throws Exception {
        try {
            Map<String, Object> lstRegistDto = lstService.readRegist(registCode);
            m.addAttribute("lstRegistDto", lstRegistDto);

            List<Map<String, Object>> fileList = lstService.selectFileList(registCode);
            m.addAttribute("file", fileList);


        } catch(Exception e) {
            e.printStackTrace();
            return "redirect:/lstRegist/list";
        }
        return "/lecture/lstRegist/lstRegistRegist";
    }
    //4.강의 삭제
    // 등록된 강의 삭제 기능 구현
    @PostMapping("/removeRegist")
    public String removeRegist(Integer registCode, SearchCondition sc, Model m, RedirectAttributes rattr) throws Exception {
        try {
            lstService.removeRegist(registCode);
        } catch(Exception e) {
            e.printStackTrace();
            rattr.addFlashAttribute("msg", "DEL_ERR");
        }
//        return "redirect:/onlyAdmin/lstRegist/list;
        return "redirect:/lstRegist/list"+sc.getQueryString();
    }


    //5.강의 수정
    // 등록된 강의 수정 기능 구현
    @PostMapping("/modifyRegist")
    public String modifyRegist(LstRegistDto lstRegistDto,
                               @RequestParam(value="fileNoDel[]")String[] files,
                               @RequestParam(value="fileNameDel[]")String[] fileNames,
                               MultipartHttpServletRequest mpRequest,
                               SearchCondition sc,
                               Model m) throws Exception{
        try {
            // hidden에 담긴 정보들과 form에 담겨있는 각종 컬럼들의 값들을 service로 전달한다.
            lstService.modifyRegist(lstRegistDto, files, fileNames, mpRequest);
//            return "redirect:/onlyAdmin/lstRegist/list";
            return "redirect:/lstRegist/list"+sc.getQueryString();
        } catch(Exception e) {
            e.printStackTrace();
            m.addAttribute(lstRegistDto);
            m.addAttribute(mpRequest);
            return "/lecture/lstRegist/lstRegistRegist";
        }
    }
    //6. 첨부파일 다운로드
    @RequestMapping(value="/fileDown")
    public void fileDown(@RequestParam Map<String, Object> map, HttpServletResponse response) throws Exception{
        Map<String, Object> resultMap = lstService.selectFileDown(map);
        String storedFileName = (String) resultMap.get("storedFileName");
        String originalFileName = (String) resultMap.get("originFileName");

        // 파일을 저장했던 위치에서 첨부파일을 읽어 byte[]형식으로 변환한다.
        byte fileByte[] = org.apache.commons.io.FileUtils.readFileToByteArray(new File(filePath+storedFileName));

        response.setContentType("application/octet-stream");
        response.setContentLength(fileByte.length);
        response.setHeader("Content-Disposition",  "attachment; fileName=\""+ URLEncoder.encode(originalFileName, "UTF-8")+"\";");
        response.getOutputStream().write(fileByte);
        response.getOutputStream().flush();
        response.getOutputStream().close();

    }

    //디비에 접근해서 courseCode에 해당하는 데이터 가져오기
    @PostMapping("/getData")
    @ResponseBody
    public Map<String, List<ClassEnrollDto>> getData(@RequestBody String courseCode, Model m) throws Exception {
        Map<String, List<ClassEnrollDto>> map = new HashMap<>();

        try {
            List<ClassEnrollDto> list = classEnrollService.getList(Integer.valueOf(courseCode));
            m.addAttribute("courseList", list);
            map.put("courseList", list);

        }catch (Exception e){
            e.printStackTrace();
        }
        return map;
    }


}
