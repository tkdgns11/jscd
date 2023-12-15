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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.*;
import java.util.List;

@Controller
//@RequestMapping("/onlyAdmin/lstRegist")
@RequestMapping("/lstRegist")
public class LstController {
    // 로그 선언
    private static final Logger logger = LoggerFactory.getLogger(LstController.class);
    @Autowired
    LstService lstService;

    @Autowired
    CourseService courseService;

    @Autowired
    ClassEnrollService classEnrollService;

    // 등록된 강의 수정 기능 구현
    @PostMapping("/modifyRegist")
    public String modifyRegist(LstRegistDto lstRegistDto, SearchCondition sc, RedirectAttributes rattr, Model m) throws Exception{
        try {
            lstService.modifyRegist(lstRegistDto);
//            return "redirect:/onlyAdmin/lstRegist/list";
            return "redirect:/lstRegist/list"+sc.getQueryString();
        } catch(Exception e) {
            e.printStackTrace();
            m.addAttribute(lstRegistDto);
            return "/lecture/lstRegist/lstRegistRegist";
        }
    }

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

        try {
            lstService.addRegist(lstRegistDto);
            return "redirect:/lstRegist/list";
        } catch(Exception e) {
            e.printStackTrace();
            m.addAttribute("lstRegistDto", lstRegistDto);
            return "/lecture/lstRegist/lstRegistRegist";
        }
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

    /* 첨부 파일 업로드 */
    @PostMapping(value="/uploadAjaxAction", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<List<AttachDto>> uploadAjaxActionPOST(MultipartFile[] uploadFile) {

        logger.info("uploadAjaxActionPOST..........");

        /* 이미지 파일 체크 */
        for(MultipartFile multipartFile: uploadFile) {

            File checkfile = new File(multipartFile.getOriginalFilename());
            String type = null;

            try {
                type = Files.probeContentType(checkfile.toPath());
                logger.info("MIME TYPE : " + type);
            } catch (IOException e) {
                e.printStackTrace();
            }

            if(!type.startsWith("image")) {

                List<AttachDto> list = null;
                return new ResponseEntity<>(list, HttpStatus.BAD_REQUEST);

            }
        }

        String uploadFolder = "/Users/george/Desktop/WEB_Project/src/main/webapp/resources/img";

        String Path = "jk";

        /* 폴더 생성 */
        File uploadPath = new File(uploadFolder, Path);

        if(uploadPath.exists() == false) {
            uploadPath.mkdirs();
        }

        /* 이미지 정보 담는 객체*/
        List<AttachDto> list = new ArrayList();

        // 향상된 for
        for(MultipartFile multipartFile : uploadFile) {
            /* 이미지 정보 객체 */
            AttachDto attachDto = new AttachDto();

            /* 파일 이름 */
            String uploadFileName = multipartFile.getOriginalFilename();
            attachDto.setFileName(uploadFileName);
            attachDto.setUploadPath(Path);

            /* uuid 적용 파일 이름 */
            String uuid = UUID.randomUUID().toString();
            attachDto.setUuid(uuid);

            uploadFileName = uuid + "_" + uploadFileName;

            /* 파일 위치, 파일 이름을 합친 File 객체 */
            File saveFile = new File(uploadPath, uploadFileName);

            /* 파일 저장 */
            try {
                multipartFile.transferTo(saveFile);

                /* 썸네일 생성(ImageIO) */
                File thumbnailFile = new File(uploadPath, "s_" + uploadFileName);

                BufferedImage bo_image = ImageIO.read(saveFile);
                /* 비율 */
                double ratio = 3;

                /*넓이 높이*/
                int width = (int) (bo_image.getWidth() / ratio);
                int height = (int) (bo_image.getHeight() / ratio);

                BufferedImage bt_image = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
                Graphics2D graphic = bt_image.createGraphics();

                graphic.drawImage(bo_image, 0, 0, width, height, null);

                ImageIO.write(bt_image, "jpg", thumbnailFile);
            } catch (Exception e) {
                e.printStackTrace();
            }
            list.add(attachDto);
        }
        ResponseEntity<List<AttachDto>> result = new ResponseEntity<List<AttachDto>>(list, HttpStatus.OK);

        return result;
    }

    // 강의 리스트로 이동 기능 구현
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
}
