package com.jscd.app.applyTraining.controller;

import com.jscd.app.applyTraining.dto.BtApplicationDto;
import com.jscd.app.applyTraining.service.BtApplicationService;
import com.jscd.app.lecture.classEnroll.dto.ClassEnrollDto;
import com.jscd.app.lecture.classEnroll.service.ClassEnrollService;
import com.jscd.app.lecture.lstRegist.dto.LstRegistDto;
import com.jscd.app.lecture.lstRegist.service.LstService;
import com.jscd.app.member.dto.MemberDto;
import com.jscd.app.member.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
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

        // 신청한 강의 번호, session id 얻기
        String id = (String)session.getAttribute("id");
        System.out.println("id = " + id);
        Integer registCode = lstRegistDto.getRegistCode();

        try {
            MemberDto memberDto = memberService.memberSelect(id);
            Integer mebrNo = memberDto.getMebrNo();
            System.out.println("mebrNo = " + mebrNo);
        } catch (Exception e) {
            e.printStackTrace();
        }

        // 1. 로그인 상태라면 이미 신청한 회원인지 확인
        if(id != null){

            // 1.2 신청한 강의 번호, session id를 btApplicationDto에 담기
            BtApplicationDto btApplicationDto = new BtApplicationDto();
            btApplicationDto.setRegistCode(registCode);
            btApplicationDto.setId(id);

            // 1.3  btApplicationDto 이용하여 검색
            try {
                BtApplicationDto btApplicationDto2 = btApplicationService.confirmApplcation(btApplicationDto);
                System.out.println("btApplicationDto2 검색 결과 = " + btApplicationDto2);
                // 1.4.1 검색 결과가 중복 신청이라면 예외 발생
                if (btApplicationDto2 != null)
                    throw new Exception("duplicate application");

                // 1.5 검색 결과가 중복이 아니라면
                // mebrNo, id, registCode, title, lastPrice를 신청서 페이지로 전달
                m.addAttribute("id" + id);
                m.addAttribute("lstRegistDto" + lstRegistDto);
                return "/applyTraining/btApplication";
            } catch (Exception e) {
                // 1.4.2 신청 중복 메시지와 함께 리턴
                e.printStackTrace();
                System.out.println("중복 신청 발생");
                try {
                    LstRegistDto lstRegistDto2 = lstService.bootCampRead(registCode);

                    m.addAttribute("lstRegistDto", lstRegistDto2);
                    m.addAttribute("msg", "duplicate application");
                    return "/applyTraining/bootCamp";
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return "redirect:/btTraining/list";
                }// try catch end
            }// try catch end

        }else{
            // 3. 로그인 상태가 아니면
            System.out.println("로그인 상태가 아님");
            try {
                LstRegistDto lstRegistDto2 = lstService.bootCampRead(registCode);

                m.addAttribute("lstRegistDto", lstRegistDto2);
                m.addAttribute("msg", "login required");
                return "/applyTraining/bootCamp";
            } catch (Exception e) {
                e.printStackTrace();
                return "redirect:/btTraining/list";
            }// try catch end
        }// if else end
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
            m.addAttribute("list", classList);
        } catch(Exception e) {
            e.printStackTrace();
            return "redirect:/btTraining/list";
        }
        return "/applyTraining/bootCamp";
    }
}