package com.jscd.app.applyTraining.controller;

import com.jscd.app.applyTraining.dto.BtApplicationDto;
import com.jscd.app.applyTraining.service.BtApplicationService;
import com.jscd.app.lecture.classEnroll.dto.ClassEnrollDto;
import com.jscd.app.lecture.classEnroll.service.ClassEnrollService;
import com.jscd.app.lecture.lstRegist.dto.LstRegistDto;
import com.jscd.app.lecture.lstRegist.service.LstService;
import com.jscd.app.member.service.MemberService;
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
import java.util.List;

@Controller
@RequestMapping("/btTraining")
public class BtTrainingController {
    @Autowired
    BtApplicationService btApplicationService;
    @Autowired
    LstService lstService;
    @Autowired
    MemberService memberService;
    @Autowired
    ClassEnrollService classEnrollService;

    // 부트캠프 신청서 제출
    @PostMapping("btApplication")
    public String btApplicationWrite(BtApplicationDto btApplicationDto, Model m, RedirectAttributes rattr){

        try {
            int cnt = btApplicationService.write(btApplicationDto);
            btApplicationService.lectureApplyInsert(btApplicationDto);

            if(cnt != 1)
                throw new Exception("write err");

            rattr.addFlashAttribute("msg", "write ok");
            // 신청서 제출 후 마이페이지 강의 신청 현황으로 이동
            return null;
        } catch (Exception e) {
            // 신청서 제출 실패시
            // 작성했던 내용, 에러 메세지와 함께 신청서 페이지로 이동
            e.printStackTrace();
            m.addAttribute(btApplicationDto);
            m.addAttribute("msg", "write err");
            return "/applyTraining/btApplication";
        }
    }

    // 부트캠프 신청서 이동
    @GetMapping("btApplication")
    public String btTrainingApplication(LstRegistDto lstRegistDto, Model m, HttpServletRequest request){

        // 이미 생성된 세션이 있으면 기존의 세션 반환 없으면 null 반환
        HttpSession session = request.getSession(false);

        // session id, 신청한 강의 번호 얻기
        String id = (String)session.getAttribute("id");
        Integer registCode = lstRegistDto.getRegistCode();

        // id, registCode, title, lastPrice를 신청서 페이지로 전달
        m.addAttribute("id" + id);
        m.addAttribute("lstRegistDto" + lstRegistDto);
        return "/applyTraining/btApplication";
    }

    // 강의 신청 중복 확인
    @GetMapping("/duplicationChk")
    @ResponseBody
    public int idDuplication(String loginId, Integer registCode) throws Exception{
        System.out.println("loginId = " + loginId);
        System.out.println("registCode = " + registCode);

        // loginId, registCode를 btApplicationDto에 set
        BtApplicationDto btApplicationDto = new BtApplicationDto();
        btApplicationDto.setId(loginId);
        btApplicationDto.setRegistCode(registCode);

        // btApplicationDto로 신청한 강의가 있는지 검색
        int cnt = btApplicationService.confirmApplcation(btApplicationDto);
        System.out.println("cnt = " + cnt);

        return cnt;
    }

    // 부트캠프 리스트 이동
    @GetMapping("/list")
    public String btTrainingList(Model m) throws Exception {

        try {
            List<LstRegistDto> list = lstService.bootCampList();
            System.out.println(list);

            m.addAttribute("list", list);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "/applyTraining/bootCampList";
    }

    // 부트캠프 세부페이지 이동
    @GetMapping("/read")
    public String bootCampRead(Integer registCode, Integer courseCode, Model m, HttpServletRequest request) throws Exception {

        try {
            LstRegistDto lstRegistDto = lstService.bootCampRead(registCode);
            List<ClassEnrollDto> classList = classEnrollService.getBootList(courseCode);
            m.addAttribute(lstRegistDto);
            System.out.println("lstRegistDto = " + lstRegistDto);
            m.addAttribute("list", classList);
        } catch(Exception e) {
            e.printStackTrace();
            return "redirect:/btTraining/list";
        }
        return "/applyTraining/bootCamp";
    }

}
