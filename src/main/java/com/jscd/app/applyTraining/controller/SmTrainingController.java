package com.jscd.app.applyTraining.controller;

import com.jscd.app.applyTraining.dto.SmApplicationDto;
import com.jscd.app.applyTraining.service.SmApplicationService;
import com.jscd.app.lecture.lstRegist.dto.LstRegistDto;
import com.jscd.app.lecture.lstRegist.service.LstService;
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
@RequestMapping("/smTraining")
public class SmTrainingController {
    @Autowired
    SmApplicationService smApplicationService;
    @Autowired
    LstService lstService;

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

        // 신청한 강의 번호, session id 얻기
        String id = (String)session.getAttribute("id");
        System.out.println("id = " + id);
        Integer registCode = lstRegistDto.getRegistCode();

        // 1. 로그인 상태라면 이미 신청한 회원인지 확인
        if(id != null){

            // 1.2 신청한 강의 번호, session id를 smApplicationDto에 담기
            SmApplicationDto smApplicationDto = new SmApplicationDto();
            smApplicationDto.setRegistCode(registCode);
            smApplicationDto.setId(id);

            // 1.3 smApplicationDto 이용하여 검색
            try {
                SmApplicationDto smApplicationDto2 = smApplicationService.confirmApplcation(smApplicationDto);
                System.out.println("smApplicationDto2 검색 결과 = " + smApplicationDto2);
                // 1.4.1 검색 결과가 중복 신청이라면 예외 발생
                if (smApplicationDto2 != null)
                    throw new Exception("duplicate application");

                // 1.5 검색 결과가 중복이 아니라면
                // mebrNo, id, registCode, title, lastPrice를 신청서 페이지로 전달
                m.addAttribute("id" + id);
                m.addAttribute("lstRegistDto" + lstRegistDto);
                return "/applyTraining/smApplication";
            } catch (Exception e) {
                // 1.4.2 신청 중복 메시지와 함께 리턴
                e.printStackTrace();
                System.out.println("중복 신청 발생");
                try {
                    LstRegistDto lstRegistDto2 = lstService.seminarRead(registCode);

                    m.addAttribute("lstRegistDto", lstRegistDto2);
                    m.addAttribute("msg", "duplicate application");
                    return "/applyTraining/seminar";
                } catch (Exception e2) {
                    e2.printStackTrace();
                    return "redirect:/smTraining/list";
                }// try catch end
            }// try catch end

        }else{
            // 3. 로그인 상태가 아니면
            System.out.println("로그인 상태가 아님");
            try {
                LstRegistDto lstRegistDto2 = lstService.seminarRead(registCode);

                m.addAttribute("lstRegistDto", lstRegistDto2);
                m.addAttribute("msg", "login required");
                return "/applyTraining/seminar";
            } catch (Exception e) {
                e.printStackTrace();
                return "redirect:/smTraining/list";
            }// try catch end
        }// if else end
    }

    // 세미나 리스트 이동
    @GetMapping("/list")
    public String smTrainingList(Model m) throws Exception {
        try {
            List<LstRegistDto> list = lstService.seminarList();
            m.addAttribute("list", list);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return "/applyTraining/seminarList";
    }

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
