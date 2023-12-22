package com.jscd.app.applyTraining.controller;

import com.jscd.app.applyTraining.dto.BtApplicationDto;
import com.jscd.app.applyTraining.dto.LecturePageHandler;
import com.jscd.app.applyTraining.dto.SmApplicationDto;
import com.jscd.app.applyTraining.service.SmApplicationService;
import com.jscd.app.lecture.classEnroll.dto.ClassEnrollDto;
import com.jscd.app.lecture.classEnroll.service.ClassEnrollService;
import com.jscd.app.lecture.lstRegist.dto.LstRegistDto;
import com.jscd.app.lecture.lstRegist.dto.lstregistfileDto;
import com.jscd.app.lecture.lstRegist.service.LstService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/smTraining")
public class SmTrainingController {
    @Autowired
    SmApplicationService smApplicationService;
    @Autowired
    LstService lstService;
    @Autowired
    ClassEnrollService classEnrollService;

    // 부트캠프 신청서 제출시
    @PostMapping("smApplication")
    public String smApplicationWrite(SmApplicationDto smApplicationDto, Model m, RedirectAttributes rattr){

        try {
            int cnt = smApplicationService.write(smApplicationDto);
            smApplicationService.lectureApplyInsert(smApplicationDto);

            if(cnt != 1)
                throw new Exception("write err");

            rattr.addFlashAttribute("msg", "write ok");

            // 신청서 제출 후 결제 페이지로 이동해야 함.
//            return null; //(용호) 수정 전
            return "redirect:/order/order";  // (소희) 수정 후
        } catch (Exception e) {
            // 신청서 제출 실패시
            // 작성했던 내용, 에러 메세지와 함께 신청서 페이지로 이동
            e.printStackTrace();
            m.addAttribute(smApplicationDto);
            m.addAttribute("msg", "write err");
            return "/applyTraining/smApplication";
        }
    }

    // 세미나 신청서 이동
    @GetMapping("smApplication")
    public String smTrainingApplication(LstRegistDto lstRegistDto, Model m, HttpServletRequest request){

        // 이미 생성된 세션이 있으면 기존의 세션 반환 없으면 null 반환
        HttpSession session = request.getSession(false);

        // session id, 신청한 강의 번호 얻기
        String id = (String)session.getAttribute("id");
        Integer registCode = lstRegistDto.getRegistCode();

        // id, registCode, title, lastPrice를 신청서 페이지로 전달
        m.addAttribute("id" + id);
        m.addAttribute("lstRegistDto" + lstRegistDto);
        return "/applyTraining/smApplication";
    }

    // 강의 신청 중복 확인
    @GetMapping("/duplicationChk")
    @ResponseBody
    public int idDuplication(String loginId, Integer registCode) throws Exception{
//        System.out.println("loginId = " + loginId);
//        System.out.println("registCode = " + registCode);

        // loginId, registCode를 smApplicationDto에 set
        SmApplicationDto smApplicationDto = new SmApplicationDto();
        smApplicationDto.setId(loginId);
        smApplicationDto.setRegistCode(registCode);

        // smApplicationDto로 신청한 강의가 있는지 검색
        int cnt = smApplicationService.confirmApplcation(smApplicationDto);
//        System.out.println("cnt = " + cnt);

        return cnt;
    }

    // 세미나 리스트 이동
    @GetMapping("/list")
    public String smTrainingList(Integer page, Integer pageSize, Model m) throws Exception {

        if(page==null) page=1;
        if(pageSize==null) pageSize = 9;

        try {
            int totalCnt = lstService.getCountSM();
            LecturePageHandler lecturePageHandler = new LecturePageHandler(totalCnt, page, pageSize);

            Map map = new HashMap();
            map.put("offset", (page-1) * pageSize);
            map.put("pageSize", pageSize);

            List<lstregistfileDto> list = lstService.seminarPaging(map);

            m.addAttribute("list", list);
            m.addAttribute("ph", lecturePageHandler);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "/applyTraining/seminarList";
    }

    // 부트캠프 진행예정일 때 리스트 이동
//    @GetMapping("/appointSMList")
//    public String smAppointList(Integer page, Integer pageSize, Model m) throws Exception {
//        if(page == null) page=1;
//        if(pageSize == null) pageSize = 9;
//
//        try {
//            // TODO 진행예정 세미나 카운팅 새로 해야함.
//            int totalCnt = lstService.getCountSM();
//            LecturePageHandler lecturePageHandler = new LecturePageHandler(totalCnt, page, pageSize);
//
//            Map map = new HashMap();
//            map.put("offset", (page-1) * pageSize);
//            map.put("pageSize", pageSize);
//
//            List<LstRegistDto> list = lstService.appointSMList(map);
//
//            m.addAttribute("list", list);
//            m.addAttribute("ph", lecturePageHandler);
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//        return "/applyTraining/appointBootCampList";
//    }

    // 부트캠프 진행중일 때 리스트 이동
//    @GetMapping("/processBTList")
//    public String smProcessList(Integer page, Integer pageSize, Model m) throws Exception {
//        if(page == null) page = 1;
//        if(pageSize ==  null) pageSize = 9;
//
//        try {
//            // TODO 진행 중 부트캠프 카운팅 다시해야함.
//            int totalCnt = lstService.getCountBT();
//            LecturePageHandler lecturePageHandler = new LecturePageHandler(totalCnt, page, pageSize);
//
//            Map map = new HashMap();
//            map.put("offset", (page-1) * pageSize);
//            map.put("pageSize", pageSize);
//
//            List<LstRegistDto> list = lstService.appointBTList(map);
//
//            m.addAttribute("list", list);
//            m.addAttribute("ph", lecturePageHandler);
//        } catch(Exception e) {
//            e.printStackTrace();
//        }
//        return "/applyTraining/processBootCampList";
//    }


    // 세미나 세부페이지 이동
    @GetMapping("/read")
    public String seminarRead(Integer registCode, Model m) throws Exception {
        try {
            LstRegistDto lstRegistDto = lstService.seminarRead(registCode);
            m.addAttribute(lstRegistDto);
        } catch(Exception e) {
            e.printStackTrace();
            return "redirect:/smTraining/list";
        }
        return "/applyTraining/seminar";
    }
}
